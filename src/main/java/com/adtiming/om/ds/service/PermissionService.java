// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.UmPermissionMapper;
import com.adtiming.om.ds.dao.UmRolePermissionMapper;
import com.adtiming.om.ds.dto.PermissionType;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangqiang
 * @date 2020/2/13
 * PermissionService
 */
@Service
public class PermissionService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private UmPermissionMapper umPermissionMapper;

    @Resource
    private UmRolePermissionMapper umRolePermissionMapper;

    public List<UmPermission> getPermissionsByUser(Integer userId) {
        return umPermissionMapper.getUserPermissions(userId);
    }

    public Map<Integer, JSONArray> getRolePermissions(List<UmRole> umRoles) {
        try {
            Map<Integer, JSONArray> resultMap = new HashMap<>();
            List<Integer> roleIds = new ArrayList<>();
            for (UmRole role : umRoles) {
                roleIds.add(role.getId());
            }
            Map<Integer, List<UmRolePermission>> roleRelatePermissionsMap = this.getUmRolePermissions(roleIds);
            for (UmRole role : umRoles) {
                List<UmRolePermission> rolePermissions = roleRelatePermissionsMap.get(role.getId());
                if (CollectionUtils.isEmpty(rolePermissions)) {
                    rolePermissions = new ArrayList<>();
                }
                List<UmPermission> permissions = this.getPermissions(rolePermissions);
                JSONArray roleActionPermissions = this.buildRolePermissions(permissions);
                resultMap.put(role.getId(), roleActionPermissions);
            }
            return resultMap;
        } catch (Exception e) {
            log.error("Get role permissions error", e);
        }
        return null;
    }

    public JSONArray buildRolePermissions(List<UmPermission> permissions) {
        try {
            Map<Integer, List<UmPermission>> userParentPermissionsMap = permissions.stream()
                    .collect(Collectors.groupingBy(m -> m.getPid(), Collectors.toList()));
            List<UmPermission> permPermissions = this.getPermPermissions();
            JSONArray resultPermissions = new JSONArray();
            for (UmPermission permission : permPermissions) {
                JSONObject resultPermission = (JSONObject) JSONObject.toJSON(permission);
                List<UmPermission> pidSubPermissions = userParentPermissionsMap.get(permission.getId());
                if (!CollectionUtils.isEmpty(pidSubPermissions)) {
                    JSONArray actionPermissions = new JSONArray();
                    for (UmPermission pidSubPermission : pidSubPermissions) {
                        if ("query".equals(pidSubPermission.getName())) {
                            actionPermissions.add("view");
                        } else {
                            actionPermissions.add(pidSubPermission.getName());
                        }
                    }
                    resultPermission.put("actions", actionPermissions);
                } else {
                    resultPermission.put("actions", new JSONArray());
                }
                resultPermissions.add(resultPermission);
            }
            return resultPermissions;
        } catch (Exception e) {
            log.error("Get role permission error:", e);
        }
        return null;
    }

    /**
     * Get permission list
     */
    public List<UmPermission> getPermPermissions() {
        UmPermissionCriteria umPermissionCriteria = new UmPermissionCriteria();
        UmPermissionCriteria.Criteria criteria = umPermissionCriteria.createCriteria();
        criteria.andTypeEqualTo("perm");
        return umPermissionMapper.selectWithBLOBs(umPermissionCriteria);
    }

    public UmPermission getPermPermissionByName(String permissionByName) {
        UmPermissionCriteria umPermissionCriteria = new UmPermissionCriteria();
        UmPermissionCriteria.Criteria criteria = umPermissionCriteria.createCriteria();
        criteria.andTypeEqualTo("perm");
        criteria.andNameEqualTo(permissionByName);
        List<UmPermission> permissions = umPermissionMapper.selectWithBLOBs(umPermissionCriteria);
        if (!CollectionUtils.isEmpty(permissions)) {
            return permissions.get(0);
        }
        return null;
    }

    /**
     * Get roles permissions
     *
     * @param rolePermissions
     */
    public List<UmPermission> getPermissions(List<UmRolePermission> rolePermissions) {
        if (CollectionUtils.isEmpty(rolePermissions)) {
            return Collections.emptyList();
        }
        List<Integer> rolePermissionIds = new ArrayList<>();
        for (UmRolePermission rolePermission : rolePermissions) {
            rolePermissionIds.add(rolePermission.getPermissionId());
        }
        UmPermissionCriteria umPermissionCriteria = new UmPermissionCriteria();
        UmPermissionCriteria.Criteria criteria = umPermissionCriteria.createCriteria();
        criteria.andIdIn(rolePermissionIds);
        criteria.andTypeEqualTo("action");
        return umPermissionMapper.selectWithBLOBs(umPermissionCriteria);
    }

    /**
     * Get role permissions
     *
     * @param roleIds
     */
    public Map<Integer, List<UmRolePermission>> getUmRolePermissions(List<Integer> roleIds) {
        UmRolePermissionCriteria umRolePermissionCriteria = new UmRolePermissionCriteria();
        UmRolePermissionCriteria.Criteria criteria = umRolePermissionCriteria.createCriteria();
        criteria.andRoleIdIn(roleIds);
        List<UmRolePermission> rolePermissions = umRolePermissionMapper.select(umRolePermissionCriteria);
        return rolePermissions.stream().collect(Collectors.groupingBy(m -> m.getRoleId(), Collectors.toList()));
    }

    /**
     * Get role permission
     *
     * @param roleId
     * @param permissionId
     */
    public UmRolePermission getUmRolePermission(Integer roleId, Integer permissionId) {
        UmRolePermissionKey permissionKey = new UmRolePermissionKey();
        permissionKey.setRoleId(roleId);
        permissionKey.setPermissionId(permissionId);
        return umRolePermissionMapper.selectByPrimaryKey(permissionKey);
    }

    private List<UmPermission> getSubPermissionByPid(Integer permissionId) {
        UmPermissionCriteria umPermissionCriteria = new UmPermissionCriteria();
        UmPermissionCriteria.Criteria criteria = umPermissionCriteria.createCriteria();
        criteria.andPidEqualTo(permissionId);
        List<UmPermission> subPermissions = this.umPermissionMapper.selectWithBLOBs(umPermissionCriteria);
        return subPermissions;
    }

    /**
     * Build role permission database object, and insert into database
     *
     * @param roleId
     * @param permissionName
     * @param permissionType
     */
    @Transactional
    public Response createPermission(Integer roleId, String permissionName, PermissionType permissionType) {
        try {
            UmPermission umPermission = this.getPermPermissionByName(permissionName);
            if (umPermission == null) {
                log.error("There has no such permission {}", permissionName);
                return Response.RES_PARAMETER_ERROR;
            }
            int permissionId = umPermission.getId();
            List<UmPermission> subPermissions = this.getSubPermissionByPid(permissionId);
            if (subPermissions.isEmpty()) {
                log.error("Permission id {} does not have any sub permissions", permissionId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            for (UmPermission subPermission : subPermissions) {
                if (permissionType.toString().equals(subPermission.getName())) {
                    UmRolePermissionKey umRolePermissionKey = new UmRolePermissionKey();
                    umRolePermissionKey.setRoleId(roleId);
                    umRolePermissionKey.setPermissionId(subPermission.getId());
                    UmRolePermission oldRolePermission = this.umRolePermissionMapper.selectByPrimaryKey(umRolePermissionKey);
                    if (oldRolePermission != null) {
                        log.info("Role permission {} existed", JSONObject.toJSONString(oldRolePermission));
                        continue;
                    }
                    UmRolePermission subRolePermission = new UmRolePermission();
                    subRolePermission.setPermissionId(subPermission.getId());
                    subRolePermission.setRoleId(roleId);
                    Response response = this.createRolePermission(subRolePermission);
                    if (response.getCode() != 0) {
                        throw new RuntimeException("Create role " + roleId + " sub permission " + subPermission.getId() + " error");
                    }
                    if (PermissionType.add.equals(permissionType) || PermissionType.edit.equals(permissionType)) {
                        response = this.createPermission(roleId, permissionName, PermissionType.query);
                        if (response.getCode() != 0) {
                            throw new RuntimeException("Create view role for " + roleId + " when add edit/add permission error");
                        }
                    }
                    return Response.build();
                }
            }
            return Response.build();
        } catch (Exception e) {
            log.error("Create role {} permission {} action type {} error", roleId, permissionName, permissionType, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Build role permission database object, and insert into database
     *
     * @param umRolePermission
     */
    public Response createRolePermission(UmRolePermission umRolePermission) {
        try {
            umRolePermission.setCreateTime(new Date());
            int result = this.umRolePermissionMapper.insert(umRolePermission);
            if (result > 0) {
                log.info("Create role permission {} successfully", JSONObject.toJSONString(umRolePermission));
                return Response.buildSuccess(umRolePermission);
            } else {
                log.error("Create role permission failed {} ", JSONObject.toJSONString(umRolePermission));
            }
        } catch (Exception e) {
            log.error("Create role permission error {} ", JSONObject.toJSONString(umRolePermission), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Delete role database object
     *
     * @param roleId
     * @param permissionName
     * @param permissionType
     */
    @Transactional
    public Response deleteRolePermission(Integer roleId, String permissionName, PermissionType permissionType) {
        try {
            UmPermission umPermission = this.getPermPermissionByName(permissionName);
            if (umPermission == null) {
                log.error("Delete! There has no such permission {}", permissionName);
                return Response.RES_PARAMETER_ERROR;
            }
            int permissionId = umPermission.getId();
            List<UmPermission> subPermissions = this.getSubPermissionByPid(permissionId);

            if (PermissionType.none.equals(permissionType)) {
                for (UmPermission subPermission : subPermissions) {
                    UmRolePermissionKey umRolePermissionKey = new UmRolePermissionKey();
                    umRolePermissionKey.setRoleId(roleId);
                    umRolePermissionKey.setPermissionId(subPermission.getId());
                    UmRolePermission rolePermission = this.umRolePermissionMapper.selectByPrimaryKey(umRolePermissionKey);
                    if (rolePermission != null) {
                        int result = this.umRolePermissionMapper.deleteByPrimaryKey(umRolePermissionKey);
                        if (result > 0) {
                            log.info("Delete role permission {} successfully", JSONObject.toJSONString(umRolePermissionKey));
                        } else {
                            throw new RuntimeException("Delete role permission failed " + JSONObject.toJSONString(umRolePermissionKey));
                        }
                    }
                }
            } else {
                for (UmPermission subPermission : subPermissions) {
                    UmRolePermissionKey umRolePermissionKey = new UmRolePermissionKey();
                    umRolePermissionKey.setRoleId(roleId);
                    umRolePermissionKey.setPermissionId(subPermission.getId());
                    if (permissionType.name().equals(subPermission.getName()) || PermissionType.query.equals(permissionType)) {
                        int result = this.umRolePermissionMapper.deleteByPrimaryKey(umRolePermissionKey);
                        if (result > 0) {
                            log.info("Delete role permission {} successfully", JSONObject.toJSONString(umRolePermissionKey));
                        } else {
                            throw new RuntimeException("Delete role permission failed, may be not existed" + JSONObject.toJSONString(umRolePermissionKey));
                        }
                    }
                }
            }
            return Response.build();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("Delete role id {} permission name: {} error", roleId, permissionName, e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Delete role permission failed!");
    }
}
