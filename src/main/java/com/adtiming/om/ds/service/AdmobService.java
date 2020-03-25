// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmAdnetworkAppMapper;
import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmAdnetworkApp;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.util.HttpConnMgr;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdmobService extends BaseService {

    @Resource
    private OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    private ReportAdnetworkAccountMapper reportAdnAccountMapper;

    @Value("${om.adc.domain}")
    private String adcDomain;

    /**
     * Get admob auth grant url
     *
     * @param adnAppId
     */
    public Response getAdmobAuthUrl(Integer adnAppId) {
        String url;
        try {
            if (adnAppId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            OmAdnetworkApp adnetworkApp = this.omAdnetworkAppMapper.selectByPrimaryKey(adnAppId);
            if (adnetworkApp == null) {
                log.error("AdNetworkAppId {} does not existed", adnAppId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            ReportAdnetworkAccount account = reportAdnAccountMapper.selectByPrimaryKey(adnetworkApp.getReportAccountId());
            String authKey = account.getAuthKey();
            if (StringUtils.isBlank(authKey)) {
                return new Response().code(500).msg("Account Auth Key is null");
            }
            String reqUrl = String.format("%s/admob/auth/getUrl?adnAppId=%s", adcDomain, adnAppId);
            HttpGet httpGet = new HttpGet(reqUrl);
            HttpResponse response = HttpConnMgr.getHttpClient().execute(httpGet);
            url = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            return new Response().code(500).msg("OAuth Access error," + e.getMessage());
        }
        return Response.buildSuccess(url);
    }

    /**
     * Get admob auth grant url
     */
    public Object admobAuthCallBack(String userId, String code, String error, String authKey) {
        String message = "Successfully Granted!";
        try {
            String url = String.format("%s/admob/auth/callback/%s?user_id=%s&code=%s&error=%s", adcDomain, authKey, userId, code, error);
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = HttpConnMgr.getHttpClient().execute(httpGet);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            if (StringUtils.isNotBlank(content)) {
                message = "Authorization failed";
            }
        } catch (Exception e) {
            message = "Authorization failed, reason:" + e.getMessage();
        }
        /*String content =  "<html><head><title>OAuth 2.0 Authentication Token Recieved</title></head><body>"
                + message
                + "</body></HTML>";*/
        return Response.buildSuccess(message);
    }
}
