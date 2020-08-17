package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.service.AdmobService;
import com.adtiming.om.ds.util.HttpConnMgr;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdmobCallbackController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Value("${om.adc.domain}")
    public String adcDomain;

    @Resource
    protected ReportAdnetworkAccountMapper reportAdnetworkAccountMapper;

    @Resource
    private AdmobService admobService;

    @RequestMapping("oauth2authorize")
    public Object admobOAuth2Authorize(Integer adnAppId) {
        return admobService.getAdmobAuthUrl(adnAppId);
    }

    @RequestMapping("admob/{authKey}")
    public Object admobOAuthCallback(String user_id, String code, String error, @PathVariable("authKey") String authKey) {
        return admobService.admobAuthCallBack(user_id, code, error, authKey);
    }

    @RequestMapping("/report/callback/google/{authKey}")
    @ResponseBody
    public Object googleCallback(String user_id, String code, String error, @PathVariable("authKey") String authKey) {
        String message = "Authorization success!";
        try {
            String url = String.format("%s/admob/auth/callback/%s?user_id=%s&code=%s&error=%s", adcDomain, authKey, user_id, code, error);
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
        return "<html>\n" +
                "<head><title>OAuth 2.0 Authentication Token Recieved</title></head>\n" +
                "<body>\n" + message +
                "</body>\n" +
                "</HTML>";
    }

    @RequestMapping("/report/callback/oauth2authorize")
    public Response googleOauth2authorize(Integer accountId) {
        String url;
        try {
            ReportAdnetworkAccount reportAdnetworkAccount = reportAdnetworkAccountMapper.selectByPrimaryKey(accountId);
            if (reportAdnetworkAccount == null) {
                log.error("Adnetwork accout id {} does not existed", accountId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            String authKey = reportAdnetworkAccount.getAuthKey();
            if (StringUtils.isBlank(authKey)) {
                return new Response().code(500).msg("Account Auth Key is null");
            }
            String reqUrl = String.format("%s/admob/auth/getUrl?adnAppId=%s", adcDomain, accountId);
            log.info("GoogleOauth2authorize request url {}", reqUrl);
            HttpGet httpGet = new HttpGet(reqUrl);
            HttpResponse response = HttpConnMgr.getHttpClient().execute(httpGet);
            HttpEntity entity = response.getEntity();
            url = EntityUtils.toString(entity);
        } catch (Exception e) {
            log.error("OAuth Access error,id:{}", accountId, e);
            return Response.failure(Response.CODE_RES_UNAUTHORIZED, "OAuth Access error: " + e.getMessage());
        }
        return Response.buildSuccess(url);
    }

    @RequestMapping("/report/google/refreshToken/save")
    public Response saveRefreshToken(String authCode) {
        try {
            return admobService.saveTokenByCode(authCode);
        } catch (Exception e) {
            log.warn("Grant failed, authCode {} error:", authCode, e);
            return Response.failure(Response.CODE_RES_DATA_EXISTED, String.format("Grant failed,msg:%s", e.getMessage()));
        }
    }
}
