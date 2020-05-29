// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmPublisher;
import com.adtiming.om.ds.model.UmPermission;
import com.adtiming.om.ds.model.UmRole;
import com.adtiming.om.ds.model.UmUser;
import com.adtiming.om.ds.service.PermissionService;
import com.adtiming.om.ds.service.PublisherService;
import com.adtiming.om.ds.service.RoleService;
import com.adtiming.om.ds.service.UserService;
import com.adtiming.om.ds.web.shiro.OmShiroRealm;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by huangqiang on 2020/2/13.
 * LoginController
 */
@RestController
@RequestMapping("/auth")
public class LoginController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    OmShiroRealm omShiroRealm;

    @Resource
    private UserService userService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Resource
    private RedisSessionDAO redisSessionDAO;

    /**
     * description: login
     *
     * @return login response
     */
    @PostMapping("/login")
    public Response login(@RequestBody UmUser user, boolean rememberMe) {
        String email = user.getEmail();
        String password = user.getPassword();

        if (StringUtils.isBlank(email)) {
            email = user.getUsername();
            user.setEmail(email);
        }

        if (StringUtils.isBlank(email)) {
            return Response.build().code(Response.CODE_PARAMETER_ERROR).msg("User email is null!");
        }

        if (StringUtils.isBlank(password)) {
            return Response.build().msg("Password is null!");
        }

        UmUser umUser = this.userService.getUserInfoByName(user.getEmail());
        if (umUser == null) {
            return Response.build().code(Response.CODE_PARAMETER_ERROR).msg("User is not existed!");
        }

        if (umUser.getStatus().intValue() == SwitchStatus.OFF.ordinal()) {
            return Response.build().code(Response.CODE_PARAMETER_ERROR).msg("User is disable!");
        }

        boolean allPublisherValid = false;
        List<UmUser> publisherRoleUsers = this.userService.getUsers(umUser.getEmail());
        if (CollectionUtils.isEmpty(publisherRoleUsers)) {
            log.error("User {} does not belong to any organization", umUser.getEmail());
            return Response.build().code(Response.CODE_PARAMETER_ERROR).msg("User does not belong to any organization!");
        }
        for (UmUser publisherRoleUser : publisherRoleUsers) {
            if (publisherRoleUser.getRoleId() == RoleType.ADMINISTRATOR.getId()) {
                allPublisherValid = true;
                break;
            }
            if (publisherRoleUser.getPublisherId() > 0) {
                OmPublisher publisher = this.publisherService.getPublisher(publisherRoleUser.getPublisherId());
                if (publisher.getStatus() == SwitchStatus.ON.ordinal()) {
                    allPublisherValid = true;
                    break;
                }
            }
        }
        if (!allPublisherValid) {
            return Response.build().code(Response.CODE_PARAMETER_ERROR).msg("User organization are all disable!");
        }

        UmUser loginUser = userService.login(email, password, rememberMe);
        // login successful to result token
        return Response.buildSuccess(loginUser.getToken());
    }

    @RequestMapping(value = "/login/switch/publisher", method = RequestMethod.GET)
    public Response switchPublisher(HttpServletRequest req, Integer pubId, Integer roleId) {
        try {
            UmUser currentUser = this.userService.getCurrentUser();
            log.info("Switch begin Current user {} publisher id {} new publisher id {}",
                    currentUser.getId(), currentUser.getPublisherId(), pubId);
            if (currentUser.getPublisherId().equals(pubId)) {
                return Response.buildSuccess(currentUser);
            }

            Collection<Session> sessions = redisSessionDAO.getActiveSessions();
            redisSessionDAO.setSessionInMemoryEnabled(false);
            for (Session session : sessions) {
                SimplePrincipalCollection spc = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                UmUser sessionUser = (UmUser) spc.getPrimaryPrincipal();
                String sessionId = req.getSession().getId();
                if (sessionId.equals(session.getId()) && pubId != null) {
                    sessionUser.setPublisherId(pubId);
                    if (roleId != null) {
                        sessionUser.setRoleId(roleId);
                        UmRole role = roleService.getRole(roleId);
                        List<UmRole> roles = new ArrayList<>();
                        roles.add(role);
                        sessionUser.setRoleName(role.getName());
                        sessionUser.setRoles(roles);
                        List<UmPermission> perms = permissionService.getPermissionsByUser(sessionUser.getId());
                        sessionUser.setPerms(perms);
                    }
                    redisSessionDAO.update(session);
                    break;
                }
            }
            return Response.buildSuccess(currentUser);
        } catch (Exception e) {
            log.error("Switch publisher error pubId {} roleId {}:", pubId, roleId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * description: logout
     *
     * @return logout response
     */
    @RequestMapping("/logout")
    public Response logOut() {
        userService.logout();
        return Response.buildSuccess("logout successful!");
    }

    /**
     * If you are not logged in, shiro should redirect to the login interface, where the unlogged status information is returned to the jump page controlled by the front end
     *
     * @return Response
     */
    @RequestMapping("/un_auth")
    public Response unAuth() {
        return Response.failure(401, "Unauthorized");
    }

    /**
     * Unauthorized, no permission, here return unauthorized status information controlled by the front end jump page
     *
     * @return
     */
    @RequestMapping("/unauthorized")
    public Response unauthorized() {
        return Response.failure(403, "Forbidden");
    }

}
