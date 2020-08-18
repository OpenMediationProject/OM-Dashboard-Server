// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.UmUserMapper;
import com.adtiming.om.ds.dao.UmUserPublisherMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.dto.UserDTO;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.ShiroUtils;
import com.adtiming.om.ds.web.shiro.OmLoginException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ruandianbo
 * @date 20-2-4
 */
@Service
public class UserService extends BaseService {

    public static final String DEFAULT_PASSWORD = "666666";
    protected static final Logger log = LogManager.getLogger();
    @Resource
    private RedisSessionDAO redisSessionDAO;

    @Autowired
    private RoleService roleService;

    @Resource
    private UmUserMapper umUserMapper;

    @Resource
    private UmUserPublisherMapper umUserPublisherMapper;

    /**
     * Get all user
     */
    public UmUser getUser(Integer userId) {
        return umUserMapper.selectByPrimaryKey(userId);
    }

    public List<UmUser> getUsers(Integer publisherId, String email) {
        UmUser currentUser = this.getCurrentUser();
        List<UmUser> umUsers;
        if (currentUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
            umUsers = this.getUsers(email);
            if (publisherId != null) {
                Iterator<UmUser> iterator = umUsers.iterator();
                while (iterator.hasNext()) {
                    UmUser umUser = iterator.next();
                    if (umUser.getRoleId() != null && umUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
                        continue;
                    }
                    if (umUser.getPublisherId() != null && !publisherId.equals(umUser.getPublisherId())) {
                        iterator.remove();
                    }
                }
            }
            return umUsers;
        } else if (publisherId != null) {
            umUsers = this.umUserMapper.selectByPublisherId(publisherId);
            return umUsers;
        } else {
            List<UmUser> users = new ArrayList<>();
            if (currentUser.getRoleId() == RoleType.ORGANIZATION_OWNER.getId()) {
                List<UmUser> publisherUsers = this.umUserMapper.selectByPublisherId(this.getCurrentPublisherId());
                users.addAll(publisherUsers);
                users.add(currentUser);
            } else {
                users = this.umUserMapper.getUsersByName(email);
            }
            return users;
        }
    }

    /**
     * Get user app map by user ids
     *
     * @param userIds
     */
    public Map<Integer, List<UmUserApp>> getUserAppsMap(List<Integer> userIds, Integer pubAppId) {
        UmUserAppCriteria umUserAppCriteria = new UmUserAppCriteria();
        UmUserAppCriteria.Criteria criteria = umUserAppCriteria.createCriteria();
        criteria.andUserIdIn(userIds);
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        umUserAppCriteria.setOrderByClause(" create_time desc ");
        List<UmUserApp> umUserApps = this.umUserAppMapper.select(umUserAppCriteria);
        return umUserApps.stream()
                .collect(Collectors.groupingBy(UmUserApp::getUserId, Collectors.toList()));
    }

    /**
     * Get users
     */
    public List<UmUser> getUsers(String email) {
        UmUserCriteria umUserCriteria = new UmUserCriteria();
        UmUserCriteria.Criteria criteria = umUserCriteria.createCriteria();
        if (StringUtils.isNotBlank(email)) {
            criteria.andUsernameEqualTo(email);
        }
        return umUserMapper.selectUsers(umUserCriteria);
    }

    /**
     * Get users
     *
     * @param userIds
     */
    public List<UmUser> getUsers(List<Integer> userIds, String email) {
        UmUserCriteria umUserCriteria = new UmUserCriteria();
        UmUserCriteria.Criteria criteria = umUserCriteria.createCriteria();
        criteria.andIdIn(userIds);
        if (StringUtils.isNotBlank(email)) {
            criteria.andEmailEqualTo(email);
        }
        return umUserMapper.select(umUserCriteria);
    }

    /**
     * Build user database object, and insert into database
     *
     * @param userDTO
     */
    @Transactional
    public Response createUser(UserDTO userDTO) {
        try {
            if (userDTO.getPublisherId() == null) {
                userDTO.setPublisherId(0);
            }
            UmUser dbUser = this.umUserMapper.getUserByName(userDTO.getEmail());
            if (dbUser != null) {
                if (StringUtils.isNotBlank(userDTO.getEmail())) {
                    dbUser.setEmail(userDTO.getEmail());
                }
                dbUser.setStatus((byte) SwitchStatus.ON.ordinal());
                return this.updateUser(dbUser);
            }
            Date currentTime = new Date();
            UmUser umUser = new UmUser();
            umUser.setName(userDTO.getEmail());
            umUser.setEmail(userDTO.getEmail());
            umUser.setUsername(userDTO.getEmail());

            String salt = RandomStringUtils.randomNumeric(4);
            umUser.setSalt(salt);
            String password = ShiroUtils.sha256(DigestUtils.md5Hex(DEFAULT_PASSWORD), salt);
            if (StringUtils.isNotBlank(userDTO.getPassword())) {
                password = ShiroUtils.sha256(userDTO.getPassword(), salt);
            }
            umUser.setPassword(password);
            umUser.setCreatorId(this.getCurrentUser().getId());
            umUser.setCreateTime(currentTime);
            umUser.setLastmodify(currentTime);
            int result = this.umUserMapper.insertSelective(umUser);
            if (result <= 0) {
                throw new RuntimeException("Create user " + JSONObject.toJSONString(userDTO) + " failed");
            }
            if (userDTO.getPublisherId() == null) {
                userDTO.setPublisherId(this.getCurrentUser().getPublisherId());
            }
            Response response = this.roleService.createUserRole(umUser.getId(), userDTO.getRoleId(), userDTO.getPublisherId());
            if (response.getCode() != Response.SUCCESS_CODE) {
                throw new RuntimeException("Create user role relation error " + JSONObject.toJSONString(userDTO));
            }
            log.info("Create user {} success", umUser.getName());
            return Response.buildSuccess(umUser);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("Create user {} error", JSONObject.toJSONString(userDTO), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create user failed!");
    }

    /**
     * Update user password
     *
     * @param umUser
     */
    public Response updateUserPassword(UmUser umUser) {
        UmUser currentUser = this.getCurrentUser();
        if (currentUser.getId().equals(umUser.getId()) || currentUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
            return this.updatePassword(umUser);
        }
        if (currentUser.getRoleId() == RoleType.ORGANIZATION_OWNER.getId()) {
            List<UmUserRole> umUserRoles = this.getUserRoles(umUser.getId());
            boolean isManagedByCurrentUser = false;
            for (UmUserRole umUserRole : umUserRoles) {
                if (this.getCurrentPublisherId().equals(umUserRole.getPubId())) {
                    isManagedByCurrentUser = true;
                    break;
                }
            }
            if (isManagedByCurrentUser) {
                return this.updatePassword(umUser);
            }
        }
        log.error("Current user {} has no right to update password of {}", currentUser.getId(), umUser.getId());
        return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "You have no right to update this password");
    }

    /**
     * Update user password
     *
     * @param umUser
     */
    @Transactional
    public Response updatePassword(UmUser umUser) {
        try {
            UmUser dbUser = this.umUserMapper.selectByPrimaryKey(umUser.getId());
            umUser.setLastmodify(new Date());
            if (StringUtils.isNotBlank(umUser.getPassword()) && !umUser.getPassword().equals(dbUser.getPassword())) {
                String salt = RandomStringUtils.randomNumeric(4);
                umUser.setSalt(salt);
                String password = ShiroUtils.sha256(umUser.getPassword(), salt);
                umUser.setPassword(password);
            }
            int result = this.umUserMapper.updateByPrimaryKeySelective(umUser);
            if (result > 0) {
                this.deleteSession(umUser);
                log.info("Update user {} password success", umUser.getName());
                return Response.build();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("Update user password error {}", JSONObject.toJSONString(umUser), e);
        }
        log.error("Update user {} password failed", umUser.getName());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update user password failed!");
    }

    /**
     * Update user database object
     *
     * @param umUser
     */
    @Transactional
    public Response updateUser(UmUser umUser) {
        try {
            UmUser dbUser = this.umUserMapper.selectByPrimaryKey(umUser.getId());
            Set<Integer> userRoleIdSet = this.roleService.getUserRoleIdSet(dbUser.getId());
            if (umUser.getRoleId() != null) {
                if (userRoleIdSet.contains(RoleType.ADMINISTRATOR.getId()) && umUser.getRoleId() != RoleType.ADMINISTRATOR.getId()) {
                    log.error("Can not change administrator's role!", JSONObject.toJSONString(umUser));
                    return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "Can not change administrator's role!");
                }
                if (!userRoleIdSet.contains(RoleType.ADMINISTRATOR.getId()) && umUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
                    log.error("Normal user can not be promoted to administrator!", JSONObject.toJSONString(umUser));
                    return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "Normal user can not be promoted to administrator!");
                }
            }
            umUser.setLastmodify(new Date());
            if (umUser.getEmail() != null && !dbUser.getEmail().equals(umUser.getEmail())) {
                umUser.setUsername(umUser.getEmail());
                umUser.setName(umUser.getEmail());
            }
            int result = this.umUserMapper.updateByPrimaryKeySelective(umUser);
            if (result > 0) {
                if (umUser.getRoleId() != null && !umUser.getRoleId().equals(dbUser.getRoleId())) {
                    if (umUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
                        this.roleService.deleteUserRoles(dbUser.getId());
                        umUser.setPublisherId(0);
                    } else {
                        this.roleService.deleteUserRolePublisher(dbUser.getId(), dbUser.getOldPublisherId());
                    }
                    Response response = this.roleService.createUserRole(umUser.getId(), umUser.getRoleId(), umUser.getPublisherId());
                    if (response.success()) {
                        log.info("Update user {} role {} successfully when update user", umUser.getId(), umUser.getRoleId());
                    } else {
                        throw new RuntimeException("Update user " + umUser.getId() + " role " + umUser.getRoleId() + " failed when update user");
                    }
                }
                if (umUser.getStatus() != null && umUser.getStatus() == (byte) SwitchStatus.OFF.ordinal()) {
                    this.deleteSession(dbUser);
                }
                log.info("Update user {} success", umUser.getName());
                return Response.build();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("Update user error {}", JSONObject.toJSONString(umUser), e);
        }
        log.error("Update user {} failed", umUser.getName());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update user failed!");
    }

    /**
     * Delete user database object
     *
     * @param userId
     */
    @Transactional
    public Response deleteUser(Integer userId, Integer roleId, Integer pubId) {
        try {
            UmUser currentUser = this.getCurrentUser();
            if (currentUser.getId().equals(userId)) {
                log.info("Can not delete self {}", userId);
                return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "Can not delete your self");
            }
            Set<Integer> publisherOwners = this.getPublisherOwnerIds();
            if (publisherOwners.contains(userId)) {
                log.error("Publisher creator {} can not update!", userId);
                return Response.build(Response.CODE_RES_UNAUTHORIZED, Response.STATUS_DISABLE, "Can not delete publisher creator");
            }
            this.roleService.deleteUserRolePublisher(userId, pubId);
            List<UmUserRole> umUserRoles = this.roleService.getUserRoles(userId);
            if (CollectionUtils.isEmpty(umUserRoles)) {
                UmUser deleteUser = this.umUserMapper.selectByPrimaryKey(userId);
                int result = this.umUserMapper.deleteByPrimaryKey(userId);
                if (result <= 0) {
                    throw new RuntimeException("Delete user " + userId + " role " + roleId + " failed.");
                }
                this.deleteSession(deleteUser);
            }
            List<UmUserApp> umUserApps = this.getUserApps(userId, null);
            for (UmUserApp umUserApp : umUserApps) {
                this.umUserAppMapper.deleteByPrimaryKey(umUserApp);
            }
            log.info("Delete user {} role {} success!", userId, roleId);
            return Response.build();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error("Delete user error: {}", userId, e);
        }
        return Response.RES_FAILED;
    }

    private void deleteSession(UmUser user) {
        try {
            UmUser dbUser = this.umUserMapper.selectByPrimaryKey(user.getId());
            if (dbUser == null){
                return;
            }
            Collection<Session> sessions = this.redisSessionDAO.getActiveSessions();
            for (Session session : sessions) {
                SimplePrincipalCollection spc = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                UmUser sessionUser = (UmUser) spc.getPrimaryPrincipal();
                if (dbUser.getEmail().equals(sessionUser.getEmail())) {
                    new Thread(()->{
                        try {
                            Thread.sleep(10000);
                            this.redisSessionDAO.delete(session);
                            this.redisSessionDAO.setSessionInMemoryEnabled(false);
                            log.info("Delete session {} session successfully!", session);
                        } catch (Exception e){
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            log.error("Delete user {} session error:", user.getEmail(), e);
        }
    }

    /**
     * Get user app
     */
    public UmUserApp getUserApp(Integer userId, Integer pubAppId) {
        UmUserAppKey umUserAppKey = new UmUserAppKey();
        umUserAppKey.setUserId(userId);
        umUserAppKey.setPubAppId(pubAppId);
        return this.umUserAppMapper.selectByPrimaryKey(umUserAppKey);
    }

    private JSONObject buildResultUserApp(UmUserApp userApp) {
        JSONObject result = (JSONObject) JSONObject.toJSON(userApp);
        UmUser umUser = this.getUser(userApp.getUserId());
        result.put("email", umUser.getEmail());
        UmRole role = this.roleService.getRole(this.getCurrentUser().getPublisherId());
        if (role != null) {
            result.put("roleName", role.getName());
        }
        return result;
    }

    /**
     * Build user app database object, and insert into database
     *
     * @param umUserApp
     */
    public Response createUserApp(UmUserApp umUserApp) {
        try {
            List<Integer> appIds = this.getAppIdsOfCurrentUser();
            if (!appIds.contains(umUserApp.getPubAppId())) {
                log.error("User {} can not bind app {} to user {}", this.getCurrentUser().getName(),
                        umUserApp.getUserId(), umUserApp.getPubAppId());
                return Response.RES_UNAUTHORIZED;
            }
            UmUserApp oldUserApp = this.umUserAppMapper.selectByPrimaryKey(umUserApp);
            if (oldUserApp != null) {
                log.info("UmUserApp {} already existed", JSONObject.toJSONString(umUserApp));
                return Response.buildSuccess(this.buildResultUserApp(umUserApp));
            } else {
                Date currentTime = new Date();
                umUserApp.setCreateTime(currentTime);
                int result = this.umUserAppMapper.insertSelective(umUserApp);
                if (result > 0) {
                    log.info("Create user app {} success", JSONObject.toJSONString(umUserApp));
                    return Response.buildSuccess(this.buildResultUserApp(umUserApp));
                }
            }
        } catch (Exception e) {
            log.info("Create user app {} error", JSONObject.toJSONString(umUserApp), e);
        }
        log.info("Create user app {} failed", JSONObject.toJSONString(umUserApp));
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create user app failed!");
    }

    /**
     * Delete user app database object
     *
     * @param userId
     * @param pubAppId
     */
    public Response deleteUserApp(Integer userId, Integer pubAppId) {
        try {
            UmUserAppKey umUserAppKey = new UmUserAppKey();
            umUserAppKey.setPubAppId(pubAppId);
            umUserAppKey.setUserId(userId);
            int result = this.umUserAppMapper.deleteByPrimaryKey(umUserAppKey);
            if (result > 0) {
                log.info("Delete user app success");
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Delete user app error userId {} pubAppId {}", userId, pubAppId, e);
        }
        log.error("Delete user app userId {} pubAppId {} failed", userId, pubAppId);
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Delete user app failed!");
    }

    public UmUser getUserInfoByName(String userName) {
        try {
            UmUser umUser = umUserMapper.getUserByName(userName);
            return umUser;
        } catch (Exception e) {
            log.error("getUserInfoByName error:", e);
        }
        return null;
    }

    public UmUser getUserInfoByEmail(String email) {
        return this.getUserInfoByName(email);
    }

    public UmUser login(String email, String password, boolean rememberMe) {
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(email, password, rememberMe);
        // Certification
        try {
            // Method passed to MyShiroRealm class for authentication
            currentUser.login(token);
            // Build cached user information to return to the front end
            UmUser user = (UmUser) currentUser.getPrincipals().getPrimaryPrincipal();
            Session session = currentUser.getSession(false);
            if (session != null) {
                log.info("sessionId:{}", session.getId());
                user.setToken(session.getId().toString());
            }
            return user;
        } catch (UnknownAccountException e) {
            throw new OmLoginException("User name is not exist!", e);
        } catch (IncorrectCredentialsException e) {
            throw new OmLoginException("Password is wrong", e);
        } catch (AuthenticationException e) {
            throw new OmLoginException("User authentication failed!", e);
        }
    }

    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}