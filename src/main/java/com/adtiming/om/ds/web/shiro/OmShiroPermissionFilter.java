// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web.shiro;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.UmPermission;
import com.adtiming.om.ds.model.UmUser;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by huangqiang on 2020/2/15.
 * OmShiroPermissionFilter
 */
public class OmShiroPermissionFilter extends PermissionsAuthorizationFilter {
    private static final Logger log = LogManager.getLogger();

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        // Record log
        Subject subject = this.getSubject(request, response);
        UmUser user = (UmUser) subject.getPrincipal();

        //true:has permission;false:permission denied
        boolean isPermitted = false;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        String basePath = httpServletRequest.getContextPath();// return /api
        if (StringUtils.isBlank(url)) {//domain root path is not allow
            return false;
        }
        String reqPath = url.substring(basePath.length());
        if (user != null) {
            if (user.getPerms() != null && !user.getPerms().isEmpty()) {
                for (UmPermission per : user.getPerms()) {
                    if (StringUtils.isBlank(per.getApiPath())) {
                        continue;
                    }
                    Set<String> paths = Arrays.stream(per.getApiPath().split("\n"))
                            .filter(StringUtils::isNotBlank)
                            .map(String::trim)
                            .collect(Collectors.toSet());
                    if (paths.contains(reqPath)) {
                        isPermitted = true;
                        break;
                    }
                }
            }
        }
        log.info("request url:{},hasPermission:{}", url, isPermitted);
        return isPermitted;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        /*Subject subject = getSubject(request, response);
        if (subject.getPrincipal() != null) {
            return true;
        } else {*/
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        log.info("has no permission, request url:{},", url);
        HttpServletResponse res = WebUtils.toHttp(response);
        res.setContentType("application/json; charset=utf-8");
        res.getWriter().print(JSONObject.toJSONString(Response.failure(403, "Permission access denied")));
        res.setStatus(403);
        return false;
    }
}
