// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.UmRoleMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author huangqiang
 * @date 2020/2/13
 * RoleService
 */
@Service
public class RoleService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    UmRoleMapper umRoleMapper;

    public List<UmRole> getRolesByUser(Integer userId) {
        return umRoleMapper.getUserRoles(userId);
    }

    public Set<Integer> getUserRoleIdSet(Integer userId) {
        List<UmRole> roles = this.getRolesByUser(userId);
        Set<Integer> userRoleIdSet = new HashSet<>();
        roles.forEach(role -> userRoleIdSet.add(role.getId()));
        return userRoleIdSet;
    }

    /**
     * Get all roles
     */
    public List<UmRole> getRoles() {
        UmUser currentUser = this.getCurrentUser();
        if (currentUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
            return this.umRoleMapper.select(new UmRoleCriteria());
        } else {
            UmRoleCriteria umRoleCriteria = new UmRoleCriteria();
            UmRoleCriteria.Criteria criteria = umRoleCriteria.createCriteria();
            criteria.andIdNotEqualTo(RoleType.ADMINISTRATOR.getId());
            return this.umRoleMapper.select(umRoleCriteria);
        }
    }

    /**
     * Get role
     *
     * @param roleId
     */
    public UmRole getRole(Integer roleId) {
        return this.umRoleMapper.selectByPrimaryKey(roleId);
    }

    public UmUserRole getRolesByPublisherUser(Integer userId, Integer publisherId) {
        UmUserRoleCriteria roleCriteria = new UmUserRoleCriteria();
        UmUserRoleCriteria.Criteria criteria = roleCriteria.createCriteria();
        criteria.andPubIdEqualTo(publisherId);
        criteria.andUserIdEqualTo(userId);
        List<UmUserRole> umUserRoles = umUserRoleMapper.select(roleCriteria);
        if (!CollectionUtils.isEmpty(umUserRoles)){
            return umUserRoles.get(0);
        }
        return null;
    }

    /**
     * Build user app role database object, and insert into database
     *
     * @param userId
     * @param roleId
     */
    public Response createUserRole(Integer userId, Integer roleId, Integer pubId) {
        UmUserRole umUserRole = new UmUserRole();
        umUserRole.setUserId(userId);
        umUserRole.setRoleId(roleId);
        umUserRole.setPubId(pubId);
        UmUserRole dbUmUserRole = this.umUserRoleMapper.selectByPrimaryKey(umUserRole);
        if (dbUmUserRole != null) {
            throw new RuntimeException("User account already exists.");
        }
        UmUserRole userPublisherRole = this.getRolesByPublisherUser(userId, pubId);
        if (userPublisherRole != null){
            throw new RuntimeException("User account already exists.");
        }
        Date currentTime = new Date();
        umUserRole.setCreateTime(currentTime);
        int result = this.umUserRoleMapper.insertSelective(umUserRole);
        if (result <= 0) {
            throw new RuntimeException("Create user " + userId + " role id " + roleId + " failed");
        }
        log.info("Create user role {} success", JSONObject.toJSONString(umUserRole));
        return Response.buildSuccess(umUserRole);
    }

    @Transactional
    public void deleteUserRolePublisher(Integer userId, Integer pubId) {
        List<UmUserRole> umUserRoles = this.getUserRoles(userId, pubId);
        for (UmUserRole umUserRole : umUserRoles) {
            int result = this.deleteUserRole(umUserRole);
            if (result <= 0) {
                throw new RuntimeException("Delete UmUserRole " + JSONObject.toJSON(umUserRole) + " failed!");
            }
        }
    }

    @Transactional
    public void deleteUserRoles(Integer userId) {
        List<UmUserRole> umUserRoles = this.getUserRoles(userId);
        for (UmUserRole umUserRole : umUserRoles) {
            int result = this.deleteUserRole(umUserRole);
            if (result <= 0) {
                throw new RuntimeException("Delete UmUserRole " + JSONObject.toJSON(umUserRole) + " failed!");
            }
        }
    }

    /**
     * Delete user role database object
     *
     * @param umUserRoleKey
     */
    public int deleteUserRole(UmUserRoleKey umUserRoleKey) {
        return this.umUserRoleMapper.deleteByPrimaryKey(umUserRoleKey);
    }
}
