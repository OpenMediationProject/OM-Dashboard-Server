package com.adtiming.om.ds.web;

import com.adtiming.om.ds.service.AdmobService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/report/callback")
public class AdmobCallbackController extends BaseController {

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
}
