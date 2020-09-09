// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.dto.UserDTO;
import com.adtiming.om.ds.model.OmPublisher;
import com.adtiming.om.ds.model.OmPublisherCriteria;
import com.adtiming.om.ds.model.UmUser;
import com.adtiming.om.ds.model.UmUserRole;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Placement Manager
 *
 * @author dianbo ruan
 */
@Service
public class PublisherService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public OmPublisher getPublisher(Integer publisherId) {
        return omPublisherMapper.selectByPrimaryKey(publisherId);
    }

    /**
     * Get select publishers by user id
     *
     * @param userId
     */
    public Response getPublishers(Integer userId, SwitchStatus status) {
        try {
            UmUser currentUser = this.getCurrentUser();
            if (userId == null || userId <= 0) {
                userId = currentUser.getId();
            }
            List<UmUserRole> umUserRoles = this.roleService.getUserRoles(userId);
            Set<Integer> userRoleIdSet = new HashSet<>();
            umUserRoles.forEach(umUserRole -> {
                userRoleIdSet.add(umUserRole.getRoleId());
            });

            List<OmPublisher> publishers = new ArrayList<>();
            if (userRoleIdSet.contains(RoleType.ADMINISTRATOR.getId())) {
                List<OmPublisher> adminPublishers = this.omPublisherMapper.selectWithOwnerEmail();
                if (status != null) {
                    adminPublishers.removeIf(publisher -> publisher.getStatus().intValue() != status.ordinal());
                }
                publishers.addAll(adminPublishers);
            } else if (userRoleIdSet.contains(RoleType.ORGANIZATION_OWNER.getId())) {
                List<OmPublisher> userPublishers = this.selectPublishersByOwner(userId, status);
                publishers.addAll(userPublishers);
            }

            if (CollectionUtils.isEmpty(publishers)) {
                for (UmUserRole umUserRole : umUserRoles) {
                    List<OmPublisher> userPublishers = this.selectPublishers(umUserRole.getPubId(), status);
                    publishers.addAll(userPublishers);
                }
            }

            JSONArray results = new JSONArray();
            for (OmPublisher publisher : publishers) {
                JSONObject result = (JSONObject) JSONObject.toJSON(publisher);
                if (currentUser.getId().equals(userId)) {
                    result.put("roleId", currentUser.getRoleId());
                    result.put("roleName", currentUser.getRoleName());
                }
                results.add(result);
            }
            log.info("publishers size {} ", results.size());
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get select publishers by user id {} error:", userId, e);
        }
        return Response.RES_FAILED;
    }

    public List<OmPublisher> selectPublishersByOwner(Integer userId, SwitchStatus status) {
        return this.selectPublishers(null, status, userId);
    }

    public List<OmPublisher> selectPublishers(Integer id, SwitchStatus status) {
        return this.selectPublishers(id, status, null);
    }

    public List<OmPublisher> selectPublishers(Integer publisherId, SwitchStatus status, Integer ownerUserId) {
        OmPublisherCriteria omPublisherCriteria = new OmPublisherCriteria();
        OmPublisherCriteria.Criteria criteria = omPublisherCriteria.createCriteria();
        if (publisherId != null) {
            criteria.andIdEqualTo(publisherId);
        }
        if (ownerUserId != null) {
            criteria.andOwnerUserIdEqualTo(ownerUserId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        List<OmPublisher> userPublishers = this.omPublisherMapper.select(omPublisherCriteria);
        return userPublishers;
    }

    public List<OmPublisher> selectPublisherByName(String name) {
        OmPublisherCriteria omPublisherCriteria = new OmPublisherCriteria();
        OmPublisherCriteria.Criteria criteria = omPublisherCriteria.createCriteria();
        criteria.andNameEqualTo(name);
        List<OmPublisher> userPublishers = this.omPublisherMapper.select(omPublisherCriteria);
        return userPublishers;
    }

    /**
     * Build publisher database object, and insert into database
     * If email does not existed in user table ,add one
     *
     * @param omPublisher
     */
    @Transactional
    public Response createPublisher(OmPublisher omPublisher) {
        List<OmPublisher> publishers = this.selectPublisherByName(omPublisher.getName());
        if (!CollectionUtils.isEmpty(publishers)) {
            return Response.build(Response.CODE_PARAMETER_ERROR, Response.STATUS_DISABLE, "Name already existed!");
        }
        Date currentTime = new Date();
        if (omPublisher.getOwnerUserId() == null || omPublisher.getOwnerUserId() <= 0) {
            omPublisher.setOwnerUserId(this.getCurrentUser().getId());
        }
        omPublisher.setCreateTime(currentTime);
        omPublisher.setLastmodify(currentTime);
        int result = this.omPublisherMapper.insertSelective(omPublisher);
        if (result <= 0) {
            throw new RuntimeException("Create publisher " + JSONObject.toJSON(omPublisher) + " failed");
        }
        UmUser umUser = this.userService.getUserInfoByEmail(omPublisher.getEmail());
        if (umUser == null) {
            umUser = addUser(omPublisher);
        }
        omPublisher.setOwnerUserId(umUser.getId());
        result = this.omPublisherMapper.updateByPrimaryKeySelective(omPublisher);
        if (result <= 0) {
            throw new RuntimeException("Update publisher's creator id failed" + JSONObject.toJSONString(omPublisher));
        }
        Response response = this.roleService.createUserRole(umUser.getId(), RoleType.ORGANIZATION_OWNER.getId(), omPublisher.getId());
        if (response.getCode() != Response.SUCCESS_CODE) {
            throw new RuntimeException("Create user admin role error when create publisher!");
        }
        log.info("Create publisher {} success", omPublisher.getName());
        return Response.buildSuccess(omPublisher);
    }

    /**
     * Update publisher database object
     *
     * @param omPublisher
     */
    public Response updatePublisher(OmPublisher omPublisher) {
        OmPublisher dbPublisher = this.omPublisherMapper.selectByPrimaryKey(omPublisher.getId());
        UmUser currentUser = this.getCurrentUser();
        if (currentUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
            if (omPublisher.getEmail() != null && !StringUtils.isEmpty(omPublisher.getEmail())
                    && !StringUtils.isEmpty(dbPublisher.getEmail()) && !omPublisher.getEmail().equals(dbPublisher.getEmail())) {
                UmUser umUser = this.userService.getUserInfoByEmail(omPublisher.getEmail());
                if (umUser == null) {
                    umUser = addUser(omPublisher);
                }
                omPublisher.setOwnerUserId(umUser.getId());
            } else {
                omPublisher.setOwnerUserId(dbPublisher.getOwnerUserId());
            }
        }
        omPublisher.setLastmodify(new Date());
        int result = this.omPublisherMapper.updateByPrimaryKeySelective(omPublisher);
        if (result <= 0) {
            throw new RuntimeException("Update publisher " + JSONObject.toJSON(omPublisher) + " failed!");
        }
        return Response.build();
    }

    private UmUser addUser(OmPublisher omPublisher) {
        UserDTO userDTO = new UserDTO();
        userDTO.setRoleId(RoleType.ORGANIZATION_OWNER.getId());
        userDTO.setEmail(omPublisher.getEmail());
        userDTO.setPublisherId(omPublisher.getId());
        userDTO.setPassword(DigestUtils.md5Hex(UserService.DEFAULT_PASSWORD));
        Response response = this.userService.createUser(userDTO);
        if (response.getCode() != Response.SUCCESS_CODE) {
            throw new RuntimeException("Create user " + omPublisher.getEmail() + " failed");
        }
        UmUser umUser = (UmUser) response.getData();
        return umUser;
    }
}
