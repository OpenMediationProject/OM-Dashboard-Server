// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmAdnetworkAppMapper;
import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmAdnetworkApp;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.util.HttpConnMgr;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.admob.v1.AdMob;
import com.google.api.services.admob.v1.model.ListPublisherAccountsResponse;
import com.google.api.services.admob.v1.model.PublisherAccount;
import com.google.api.services.adsense.AdSense;
import com.google.api.services.adsense.model.Account;
import com.google.api.services.adsense.model.Accounts;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author dianbo ruan
 */
@Service
public class AdmobService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    private static final JsonFactory JSON_FACTORY = Utils.getDefaultJsonFactory();

    @Value("${admob.client_id}")
    public String omClientId;

    @Value("${admob.client_secret}")
    public String omClientSecret;

    @Resource
    OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    ReportAdnetworkAccountMapper reportAdnAccountMapper;

    @Value("${om.adc.domain}")
    String adcDomain;

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

    public Response getAdmobPublisherId(String clientId, String clientSecret, String refreshToken) {
        try {
            NetHttpTransport transport = new NetHttpTransport.Builder().build();
            GoogleCredential credential = new GoogleCredential.Builder()
                    .setJsonFactory(JacksonFactory.getDefaultInstance())
                    .setTransport(transport)
                    .setClientSecrets(clientId, clientSecret)
                    .build()
                    .setRefreshToken(refreshToken);
            boolean isRefreshed = credential.refreshToken();

            if (!isRefreshed) {
                throw new IOException("Refresh credential failed.");
            }
            AdSense adsense = new AdSense.Builder(transport,
                    JacksonFactory.getDefaultInstance(), credential)
                    .setApplicationName("google_api")
                    .build();
            Accounts accounts = adsense.accounts().list()
                    .setMaxResults(1)
                    .execute();
            if (accounts.getItems() != null && !accounts.getItems().isEmpty()) {
                Account account = accounts.getItems().get(0);
                if (StringUtils.isEmpty(account.getId())) {
                    log.error("Get account {} admobPublisherId failed", JSONObject.toJSON(account));
                    return Response.failure(Response.CODE_DATA_DOES_NOT_EXISTED, "Get admob publisher id failed! Id is empty!");
                }
                return Response.buildSuccess(account.getId());
            } else {
                throw new IOException("No accounts found.");
            }
        } catch (Exception e) {
            log.error("Grant failed, get admob publisher id by client id {} client secret {} refresh token {} error:",
                    clientId, clientSecret, refreshToken, e);
            return Response.failure(Response.CODE_DATA_INCOMPLETE, "Grant failed, get admob publisher id failed " + e.getMessage());
        }
    }

    public Response saveTokenByCode(String authCode) throws Exception {
        // Exchange auth code for access token
        //GoogleClientSecrets clientSecrets = getClientSecrets();
        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
                new NetHttpTransport.Builder().build(),
                JacksonFactory.getDefaultInstance(),
                "https://oauth2.googleapis.com/token",//clientSecrets.getDetails().getTokenUri(),
                omClientId,//clientSecrets.getDetails().getClientId(),
                omClientSecret,//clientSecrets.getDetails().getClientSecret(),
                authCode,
                "postmessage")  // Specify the same redirect URI that you use with your web
                // app. If you don't have a web version of your app, you can
                // specify an empty string.
                .execute();
        //GoogleIdToken idToken = tokenResponse.parseIdToken();
        String refreshToken = tokenResponse.getRefreshToken();
        log.info("Get refresh token {}", refreshToken);
        if (StringUtils.isBlank(refreshToken)) {
            throw new Exception("This Account is granted!");
        }
        Response response = getAdmobPublisherId(omClientId, omClientSecret, refreshToken);
        if (response.getCode() != Response.SUCCESS_CODE) {
            return response;
        }
        String publisherId = response.getData().toString();
        JSONObject result = new JSONObject();
        result.put("pubId", publisherId);
        result.put("refreshToken", refreshToken);
        return Response.buildSuccess(result);
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

    public Response saveAdmobTokenByCode(String authCode) throws Exception {
        // Exchange auth code for access token
        //GoogleClientSecrets clientSecrets = getClientSecrets();
        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
                new NetHttpTransport.Builder().setProxy(proxy).build(),
                JacksonFactory.getDefaultInstance(),
                "https://oauth2.googleapis.com/token",//clientSecrets.getDetails().getTokenUri(),
                omClientId,//clientSecrets.getDetails().getClientId(),
                omClientSecret,//clientSecrets.getDetails().getClientSecret(),
                authCode,
                "postmessage")  // Specify the same redirect URI that you use with your web
                // app. If you don't have a web version of your app, you can
                // specify an empty string.
                .execute();
        //GoogleIdToken idToken = tokenResponse.parseIdToken();
        String refreshToken = tokenResponse.getRefreshToken();
        log.info("AuthCode {} get refresh token {}", authCode, refreshToken);
        if (StringUtils.isBlank(refreshToken)) {
            throw new Exception("This Account is granted!");
        }
        Response response = getAdmobPublisherIdByAdMob(omClientId, omClientSecret, refreshToken);
        if (response.getCode() != Response.SUCCESS_CODE) {
            return response;
        }
        String publisherId = response.getData().toString();
        JSONObject result = new JSONObject();
        result.put("pubId", publisherId);
        result.put("refreshToken", refreshToken);
        return Response.buildSuccess(result);
    }

    public Response getAdmobPublisherIdByAdMob(String clientId, String clientSecret, String refreshToken) {
        try {
            NetHttpTransport transport = new NetHttpTransport.Builder().setProxy(proxy).build();
            GoogleCredential credential = new GoogleCredential.Builder()
                    .setJsonFactory(JacksonFactory.getDefaultInstance())
                    .setTransport(transport)
                    .setClientSecrets(clientId, clientSecret)
                    .build()
                    .setRefreshToken(refreshToken);
            boolean isRefreshed = credential.refreshToken();

            if (!isRefreshed) {
                throw new IOException("Refresh credential failed.");
            }
            AdMob admob = new AdMob.Builder(transport, JSON_FACTORY, credential)
                    .build();
            ListPublisherAccountsResponse accountsList = admob.accounts().list().setPageSize(1).execute();

            if (accountsList != null && accountsList.getAccount() != null && accountsList.getAccount().size() > 0) {
                PublisherAccount account = accountsList.getAccount().get(0);
                if (StringUtils.isEmpty(account.getPublisherId())) {
                    log.error("AdmobPublisherIdByAdMob account {} admobPublisherId failed", JSONObject.toJSON(account));
                    return Response.failure(Response.CODE_DATA_DOES_NOT_EXISTED, "Get Admob publisher id by AdMob failed! Id is empty!");
                }
                return Response.buildSuccess(account.getPublisherId());
            } else {
                throw new IOException("No accounts found.");
            }
        } catch (Exception e) {
            log.error("Grant admob failed, get admob publisher id by client id {} client secret {} refresh token {} error:",
                    clientId, clientSecret, refreshToken, e);
            return Response.failure(Response.CODE_DATA_INCOMPLETE, "Grant admob failed, get admob publisher id failed " + e.getMessage());
        }
    }
}
