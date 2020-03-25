// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web.shiro;


import com.adtiming.om.ds.model.UmPermission;
import com.adtiming.om.ds.model.UmRole;
import com.adtiming.om.ds.model.UmUser;
import com.adtiming.om.ds.model.UmUserRole;
import com.adtiming.om.ds.service.PermissionService;
import com.adtiming.om.ds.service.RoleService;
import com.adtiming.om.ds.service.UserService;
import com.adtiming.om.ds.util.ShiroUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class OmShiroRealm extends AuthorizingRealm {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    //@SuppressWarnings("all")
    public OmShiroRealm(UserService userService) {
        this.userService = userService;
    }

    /**
     * Authorization
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        UmUser user = (UmUser) principalCollection.getPrimaryPrincipal();

        if (user == null) {
            log.error("User {} not exist", user.getName());
            throw new UnknownAccountException("user is not exist");
        }

        //fill role collection
        List<UmRole> roles = roleService.getRolesByUser(user.getId());
        user.setRoles(roles);
        if (user.getRoles() != null) {
            user.getRoles().stream().forEach(o -> authorizationInfo.addRole(o.getName()));
        }

        //fill Permission collection
        List<UmPermission> perms = permissionService.getPermissionsByUser(user.getId());
        user.setPerms(perms);
        if (user.getPerms() != null) {
            user.getPerms().stream().forEach(o -> authorizationInfo.addStringPermission(o.getApiPath()));
        }
        return authorizationInfo;
    }


    /**
     * authentication
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //get user input login name
        String userName = (String) authenticationToken.getPrincipal();

        UmUser user = this.userService.getUserInfoByName(userName);
        if (Objects.isNull(user)) {
            return null;
        }

        List<UmRole> roles = this.roleService.getRolesByUser(user.getId());
        if (!CollectionUtils.isEmpty(roles)) {
            user.setRoles(roles);
        }

        List<UmUserRole> umUserRoles = this.roleService.getUserRoles(user.getId());
        log.info("umUserRoles:" + JSONArray.toJSON(umUserRoles));
        if (!CollectionUtils.isEmpty(umUserRoles)) {
            user.setPublisherId(umUserRoles.get(0).getPubId());
            user.setRoleId(umUserRoles.get(0).getRoleId());
            UmRole role = this.roleService.getRole(user.getRoleId());
            log.info("Log user {}", JSONObject.toJSONString(user));
            if (role != null) {
                user.setRoleName(role.getName());
            }
        }

        //fill Permission collection
        List<UmPermission> perms = this.permissionService.getPermissionsByUser(user.getId());
        user.setPerms(perms);

        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                // salt = username + salt
                ByteSource.Util.bytes(user.getSalt()),
                // realm name
                getName()
        );
    }


    /**
     * Add your own validation to the container
     * <p>
     * Credential matcher（Since our password verification was handed over to Shiro's SimpleAuthenticationInfo for processing
     * ）
     *
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //Hash algorithm: MD5 algorithm can be used here or SHA-256
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroUtils.HASH_ALGORITHM_NAME);
        // The number of hashes, such as 16 hashes, is equivalent to md5 (md5 (""));
        hashedCredentialsMatcher.setHashIterations(ShiroUtils.HASH_ITERATIONS);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

}
