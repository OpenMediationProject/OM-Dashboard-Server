// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.PermissionType;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.dto.UserDTO;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ruandianbo on 20-2-4.
 */
@RestController
public class UserController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Value("${admob.client_id}")
    public String adtClientId;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PublisherAppService publisherAppService;

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public Response getCurrentUserInfo() {
        try {
            UmUser user = userService.getCurrentUser();
            log.info("current user:{}", JSON.toJSONString(user));
            JSONObject resultUser = (JSONObject) JSONObject.toJSON(user.clone());
            resultUser.put("clientId", adtClientId);
            return Response.buildSuccess(resultUser);
        } catch (Exception e) {
            log.error("getCurrentUserInfo error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get user
     */
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    public Response getUserByEmail(String email) {
        try {
            UmUser umUser = this.userService.getUserInfoByEmail(email);
            if (umUser != null) {
                JSONObject result = (JSONObject) JSONObject.toJSON(umUser);
                List<UmRole> roles = this.roleService.getRolesByUser(umUser.getId());
                if (!CollectionUtils.isEmpty(roles)) {
                    result.put("roleId", roles.get(0).getId());
                    result.put("roleName", roles.get(0).getName());
                }
                return Response.buildSuccess(result);
            } else {
                return Response.build();
            }
        } catch (Exception e) {
            log.error("getUserList error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get select users
     */
    @RequestMapping(value = "/user/select/list", method = RequestMethod.GET)
    public Response getSelectUsers(Integer publisherId) {
        try {
            JSONArray resultUsers = new JSONArray();
            List<UmUser> umUserList = this.userService.getUsers(publisherId, null);
            Set<String> uniqueSet = new HashSet<>();
            for (UmUser umUser : umUserList) {
                if (uniqueSet.contains(umUser.getEmail())) {
                    continue;
                }
                if (umUser.getRoleId() == RoleType.ADMINISTRATOR.getId() || umUser.getRoleId() == RoleType.ORGANIZATION_OWNER.getId()) {
                    continue;
                }
                uniqueSet.add(umUser.getEmail());
                JSONObject resultUser = (JSONObject) JSONObject.toJSON(umUser);
                resultUser.remove("password");
                resultUser.remove("secretKeyDone");
                resultUsers.add(resultUser);
            }
            return Response.buildSuccess(resultUsers);
        } catch (Exception e) {
            log.error("getUserList error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all users
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public Response getUsers(String email, Integer pubAppId, Integer roleId) {
        try {
            JSONArray resultUsers = new JSONArray();
            Set<Integer> publisherOwners = publisherService.getPublisherOwnerIds();
            UmUser currentUser = this.userService.getCurrentUser();
            if (currentUser.getRoleId() != RoleType.ORGANIZATION_OWNER.getId() && currentUser.getRoleId() != RoleType.ADMINISTRATOR.getId()) {
                email = currentUser.getEmail();
            }
            List<UmUser> umUserList = this.userService.getUsers(this.userService.getCurrentUser().getPublisherId(), email);
            List<Integer> userIdList = umUserList.stream().map(UmUser::getId).collect(Collectors.toList());
            Map<Integer, List<UmUserApp>> userAppsMap = this.userService.getUserAppsMap(userIdList, pubAppId);
            for (UmUser umUser : umUserList) {
                if (roleId != null && !roleId.equals(umUser.getRoleId())) {
                    continue;
                }
                if (!StringUtils.isEmpty(email) && !email.equals(umUser.getEmail())) {
                    continue;
                }
                if (umUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
                    umUser.setPublisherName(null);
                }
                umUser.setOldPublisherId(umUser.getPublisherId());
                JSONObject resultUser = (JSONObject) JSONObject.toJSON(umUser);
                resultUser.remove("password");
                if (publisherOwners.contains(umUser.getId())) {
                    resultUser.put("isPublisherOwner", true);
                } else {
                    resultUser.put("isPublisherOwner", false);
                }

                List<UmUserApp> umUserApps = userAppsMap.get(umUser.getId());
                if (!CollectionUtils.isEmpty(umUserApps)) {
                    List<Integer> appIdList = umUserApps.stream().map(UmUserApp::getPubAppId).collect(Collectors.toList());
                    List<OmPublisherApp> userPublisherApps = this.publisherAppService.getPublisherApps(appIdList);
                    resultUser.put("publisherApps", userPublisherApps);
                } else if (pubAppId != null && pubAppId > 0) {
                    continue;
                } else {
                    resultUser.put("publisherApps", new JSONArray());
                }
                resultUsers.add(resultUser);
            }
            return Response.buildSuccess(resultUsers);
        } catch (Exception e) {
            log.error("Get user list error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new User
     *
     * @see UmUser
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public Response createUser(@RequestBody UserDTO userDTO) {
        if (userDTO.getEmail() == null) {
            log.error("Create user parameter error {}", JSONObject.toJSONString(userDTO));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.userService.createUser(userDTO);
    }

    /**
     * Update User info
     *
     * @see UmUser
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Response updateUser(@RequestBody UmUser umUser) {
        if (umUser.getId() == null || umUser.getId() <= 1) {
            log.error("Update user parameter {} not valid!", JSONArray.toJSON(umUser));
            return Response.RES_PARAMETER_ERROR;
        }
        Set<Integer> publisherOwners = publisherService.getPublisherOwnerIds();
        if (publisherOwners.contains(umUser.getId())) {
            log.error("Publisher owner {} can not be update!", JSONObject.toJSONString(umUser));
            return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "This Owner is assigned by Admin. You can't change the role.");
        }
        return this.userService.updateUser(umUser);
    }

    /**
     * Update user password
     *
     * @see UmUser
     */
    @RequestMapping(value = "/user/password/update", method = RequestMethod.POST)
    public Response updateUserPassword(@RequestBody UmUser umUser) {
        if (umUser.getId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.userService.updateUserPassword(umUser);
    }

    /**
     * Delete user info
     *
     * @see UmUser
     */
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public Response deleteUser(Integer userId, Integer roleId, Integer publisherId) {
        if (userId == null || userId <= 1 || roleId == null) {//could not delete admin
            return Response.RES_PARAMETER_ERROR;
        }
        return this.userService.deleteUser(userId, roleId, publisherId);
    }

    /**
     * Get user
     */
    @RequestMapping(value = "/user/app/get", method = RequestMethod.GET)
    public Response getUserApp(Integer userId, Integer pubAppId) {
        try {
            if (userId == null || pubAppId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            UmUserApp umUserApp = this.userService.getUserApp(userId, pubAppId);
            if (umUserApp != null) {
                return Response.buildSuccess(umUserApp);
            } else {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
        } catch (Exception e) {
            log.error("Get user app error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all user app
     */
    @RequestMapping(value = "/user/app/list", method = RequestMethod.GET)
    public Response getUserAppList(Integer userId, Integer pubAppId, String email) {
        try {
            if (userId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            JSONArray results = new JSONArray();
            List<Integer> pubAppIds = null;
            if (pubAppId != null) {
                pubAppIds = new ArrayList<>();
                pubAppIds.add(pubAppId);
            }
            List<OmPublisherApp> publisherApps = this.publisherAppService.getPublisherApps(pubAppIds);
            for (OmPublisherApp publisherApp : publisherApps) {
                publisherApp.setDescn(null);
                JSONObject result = (JSONObject) JSONObject.toJSON(publisherApp);
                List<UmUserApp> umUserApps = this.userService.getUserApps(null, publisherApp.getId());
                if (!CollectionUtils.isEmpty(umUserApps)) {
                    List<Integer> userIds = new ArrayList<>();
                    umUserApps.forEach(umUserApp -> {
                        userIds.add(umUserApp.getUserId());
                    });
                    List<UmUser> umUsers = this.userService.getUsers(userIds, email);
                    if (!StringUtils.isEmpty(email) && CollectionUtils.isEmpty(umUsers)) {
                        continue;
                    }
                    if (!CollectionUtils.isEmpty(umUsers)) {
                        JSONArray resultUsers = new JSONArray();
                        for (UmUser umUser : umUsers) {
                            JSONObject resultUser = (JSONObject) JSONObject.toJSON(umUser);
                            List<UmRole> umRoles = this.roleService.getRolesByUser(umUser.getId());
                            if (!CollectionUtils.isEmpty(umRoles)) {
                                resultUser.put("roleName", umRoles.get(0).getName());
                            } else {
                                log.error("User {} has no role", umUser.getName());
                            }
                            resultUsers.add(resultUser);
                        }
                        result.put("users", resultUsers);
                    } else {
                        result.put("users", new JSONArray());
                    }
                } else {
                    result.put("users", new JSONArray());
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get user's app list error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new user app
     *
     * @see UmUserApp
     */
    @RequestMapping(value = "/user/app/create", method = RequestMethod.POST)
    public Response createUserApp(@RequestBody UmUserApp umUserApp) {
        if (umUserApp.getPubAppId() == null || umUserApp.getUserId() == null) {
            log.error("Create user app parameter error {}", JSONObject.toJSONString(umUserApp));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.userService.createUserApp(umUserApp);
    }

    /**
     * Update User info
     *
     * @param pubAppId
     */
    @RequestMapping(value = "/user/app/delete", method = RequestMethod.GET)
    public Response deleteUserApp(Integer userId, Integer pubAppId) {
        if (userId == null || pubAppId == null) {
            log.error("delete user {} app {} parameter error {}", userId, pubAppId);
            return Response.RES_PARAMETER_ERROR;
        }
        return this.userService.deleteUserApp(userId, pubAppId);
    }

    /**
     * Get all user role
     */
    @RequestMapping(value = "/user/user_role/list", method = RequestMethod.GET)
    public Response getUserRoleList(Integer userId) {
        try {
            if (userId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            List<UmUserRole> umUserRoles = this.roleService.getUserRoles(userId);
            return Response.buildSuccess(umUserRoles);
        } catch (Exception e) {
            log.error("Get user's role list error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new user role
     *
     * @see UmUserRole
     */
    @RequestMapping(value = "/user/user_role/create", method = RequestMethod.POST)
    public Response createUserRole(@RequestBody UmUserRole umUserRole) {
        if (umUserRole.getRoleId() == null || umUserRole.getUserId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.roleService.createUserRole(umUserRole.getUserId(), umUserRole.getRoleId(), umUserRole.getPubId());
    }

    /**
     * Get role
     */
    @RequestMapping(value = "/user/role/get", method = RequestMethod.GET)
    public Response getRole(Integer roleId) {
        try {
            if (roleId == null) {
                log.error("Get role error, role id {}", roleId);
                return Response.RES_PARAMETER_ERROR;
            }
            UmRole umRole = this.roleService.getRole(roleId);
            if (umRole != null) {
                return Response.buildSuccess(umRole);
            } else {
                log.error("Get role failed, role id {}:", roleId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
        } catch (Exception e) {
            log.error("Get role error, role id {}:", roleId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get roles and their permissions
     */
    @RequestMapping(value = "/user/role/list", method = RequestMethod.GET)
    public Response getRoles() {
        try {
            List<UmRole> umRoles = this.roleService.getRoles();
            JSONArray results = new JSONArray();
            Map<Integer, JSONArray> rolePermissionMap = this.permissionService.getRolePermissions(umRoles);
            for (UmRole role : umRoles) {
                if (role.getId() == RoleType.ADMINISTRATOR.getId()) {
                    continue;
                }
                JSONObject result = (JSONObject) JSONObject.toJSON(role);
                JSONArray permissions = rolePermissionMap.get(role.getId());
                result.put("permissions", permissions);
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get all roles error", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get roles
     */
    @RequestMapping(value = "/user/role/select/list", method = RequestMethod.GET)
    public Response getSelectRoles() {
        try {
            List<UmRole> umRoles = this.roleService.getRoles();
            return Response.buildSuccess(umRoles);
        } catch (Exception e) {
            log.error("Get select all roles error", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get role
     */
    @RequestMapping(value = "/user/role/permission/get", method = RequestMethod.GET)
    public Response getRolePermission(Integer roleId, Integer permissionId) {
        try {
            if (roleId == null || permissionId == null) {
                log.error("Get role permission error, role id {} permission id {}", roleId, permissionId);
                return Response.RES_PARAMETER_ERROR;
            }
            UmRolePermission umRolePermission = this.permissionService.getUmRolePermission(roleId, permissionId);
            if (umRolePermission != null) {
                log.error("Get role permission successfully, role id {} permission id {}", roleId, permissionId);
                return Response.buildSuccess(umRolePermission);
            } else {
                log.error("Get role permission failed, role id {} permission id {}", roleId, permissionId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
        } catch (Exception e) {
            log.error("Get role permission error, role id {} permission id {}", roleId, permissionId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new role permission
     *
     * @see UmRolePermission
     */
    @RequestMapping(value = "/user/role/permission/create", method = RequestMethod.GET)
    public Response createRolePermission(Integer roleId, String permissionName, String permissionType) {
        if (roleId == null || StringUtils.isEmpty(permissionName) || PermissionType.getPermissionType(permissionType) == null) {
            log.error("Create role {} permission {} action type {} parameter error", roleId, permissionName, permissionType);
            return Response.RES_PARAMETER_ERROR;
        }
        return this.permissionService.createPermission(roleId, permissionName, PermissionType.getPermissionType(permissionType));
    }

    /**
     * Delete role
     */
    @RequestMapping(value = "/user/role/permission/delete", method = RequestMethod.GET)
    public Response deleteRolePermission(Integer roleId, String permissionName, String permissionType) {
        try {
            if (roleId == null || StringUtils.isEmpty(permissionName) || PermissionType.getPermissionType(permissionType) == null) {
                log.error("Delete role {} permission {} action type {} parameter error", roleId, permissionName, permissionType);
                return Response.RES_PARAMETER_ERROR;
            }
            return this.permissionService.deleteRolePermission(roleId, permissionName, PermissionType.getPermissionType(permissionType));
        } catch (Exception e) {
            log.error("Delete role permission error, role id {} permission id {}", roleId, permissionName, e);
        }
        return Response.RES_FAILED;
    }
}
