// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web.shiro;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Locale;

public class OmLogoutFilter extends LogoutFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = this.getSubject(request, response);
        if(this.isPostOnlyLogout() && !WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH).equals("POST")) {
            return this.onLogoutRequestNotAPost(request, response);
        } else {
            //String redirectUrl = this.getRedirectUrl(request, response, subject);

            try {
                subject.logout();
            } catch (SessionException var6) {
                //log.debug("Encountered session exception during logout.  This can generally safely be ignored.", var6);
            }

            //this.issueRedirect(request, response, redirectUrl);
        }
        return false;
    }
}
