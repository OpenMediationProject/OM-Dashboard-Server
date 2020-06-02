package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.service.AdmobService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdmobCallbackController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private AdmobService admobService;

    @RequestMapping("/report/callback/oauth2authorize")
    public Object admobOAuth2Authorize(Integer adnAppId) {
        return admobService.getAdmobAuthUrl(adnAppId);
    }

    @RequestMapping("/report/callback/google/{authKey}")
    public Object admobOAuthCallback(String user_id, String code, String error, @PathVariable("authKey") String authKey) {
        return admobService.admobAuthCallBack(user_id, code, error, authKey);
    }

    @RequestMapping("/report/google/refreshToken/save")
    @Transactional
    public Response saveRefreshToken(int accountId, String authCode) {
        try {
            return admobService.saveTokenByCode(accountId, authCode);
        } catch (Exception e) {
            log.warn("Grant failed, accountId {} authCode {} error:", accountId, authCode, e);
            return Response.build().code(500).msg(String.format("Grant failed,msg:%s", e.getMessage()));
        }
    }
}
