package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.AdNetworkType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.model.ReportAdnetworkAccountCriteria;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    @Resource
    private ReportAdnetworkAccountMapper reportAdnetworkAccountMapper;

    @Resource
    private AdmobService admobService;

    public List<ReportAdnetworkAccount> getAccounts(Integer adnId) {
        return this.getAccounts(adnId, this.getCurrentUser().getPublisherId());
    }

    public List<ReportAdnetworkAccount> getAccounts(Integer adnId, Integer publisherId) {
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        if (publisherId != null) {
            criteria.andPublisherIdEqualTo(publisherId);
        }
        criteria.andAdnIdNotEqualTo(AdNetworkType.Facebook.ordinal());
        criteria.andAdnIdNotEqualTo(AdNetworkType.TencentAd.ordinal());
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        return this.reportAdnetworkAccountMapper.select(accountCriteria);
    }

    public ReportAdnetworkAccount getDuplicatedAccount(ReportAdnetworkAccount account) {
        Integer publisherId = this.getCurrentUser().getPublisherId();
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        criteria.andPublisherIdEqualTo(publisherId);
        criteria.andAdnIdEqualTo(account.getAdnId());
        if (account.getId() != null && account.getId() > 0){
            criteria.andIdNotEqualTo(account.getId());
        }
        AdNetworkType adNetworkType = AdNetworkType.getAdNetworkType(account.getAdnId());
        switch (adNetworkType) {
            case AdMob: {
                if (account.getAuthType() != null && account.getAuthType().intValue() == 2) {
                    criteria.andAdnApiKeyEqualTo(account.getAdnApiKey());
                    criteria.andAdnAppIdEqualTo(account.getAdnAppId());
                    criteria.andAuthTypeEqualTo((byte) 2);
                } else if (account.getAuthType() != null && account.getAuthType().intValue() == 1) {
                    criteria.andUserIdIsNull();
                    criteria.andAuthTypeEqualTo((byte) 1);
                }
                break;
            }
            case Chartboost:
            case IronSource:
            case TencentAd:
            case TikTok: {
                criteria.andUserIdEqualTo(account.getUserId());
                break;
            }
            case Unity:
            case Vungle:
            case AppLovin:
            case Mopub:
            case Mintegral: {
                criteria.andAdnApiKeyEqualTo(account.getAdnApiKey());
                break;
            }
            case Adtiming:
            case AdColony:
            case Tapjoy: {
                criteria.andAdnAppTokenEqualTo(account.getAdnAppToken());
                break;
            }
            case Facebook: {
                criteria.andAdnAppIdEqualTo(account.getAdnAppId());
                break;
            }
            default:
                break;
        }
        List<ReportAdnetworkAccount> accounts = reportAdnetworkAccountMapper.select(accountCriteria);
        if (!CollectionUtils.isEmpty(accounts)) {
            return accounts.get(0);
        }
        return null;
    }

    public Response createAccount(ReportAdnetworkAccount account) {
        try {
            Response isAdKeyValid = this.isAdKeyValid(account);
            if (isAdKeyValid.getCode() != Response.SUCCESS_CODE){
                log.error("Account {} primary key is null, msg {}", JSONObject.toJSON(account), isAdKeyValid.getMsg());
                return isAdKeyValid;
            }

            Integer publisherId = this.getCurrentUser().getPublisherId();
            ReportAdnetworkAccount duplicatedAccount = this.getDuplicatedAccount(account);
            if (duplicatedAccount != null) {
                //admob is automatic, maybe click much times
                if (account.getAdnId().intValue() == AdNetworkType.AdMob.ordinal() && account.getAuthType() != null
                        && account.getAuthType().intValue() == 1 && StringUtils.isEmpty(duplicatedAccount.getUserId())) {
                    account.setId(duplicatedAccount.getId());
                    log.info("Use existed account {}", JSONObject.toJSON(duplicatedAccount));
                    return this.updateAccount(account);
                }
                String warn = "Account for publisher id " + publisherId + " existed";
                return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, warn);
            }

            account.setCreateTime(new Date());
            if (account.getStatus() == null) {
                account.setStatus((byte) SwitchStatus.ON.ordinal());
            }
            if (account.getPublisherId() == null) {
                account.setPublisherId(publisherId);
            }
            if (account.getAdnId() == AdNetworkType.AdMob.ordinal()) {
                account.setAuthKey(UUID.randomUUID().toString().replaceAll("-", ""));
                account.setCredentialPath("/credential/" + account.getAuthKey());
            }
            int result = this.reportAdnetworkAccountMapper.insertSelective(account);
            if (result <= 0) {
                throw new RuntimeException("Create account " + JSONObject.toJSON(account) + "failed");
            }
            return Response.buildSuccess(account);
        } catch (Exception e) {
            log.error("Create account {} error:", JSONObject.toJSON(account), e);
        }
        return Response.RES_FAILED;
    }

    public Response updateAccount(ReportAdnetworkAccount account) {
        try {
            if (account.getStatus() == null) { //It should check duplicate key except update status
                Response isAdKeyValid = this.isAdKeyValid(account);
                if (isAdKeyValid.getCode() != Response.SUCCESS_CODE){
                    log.error("Account {} primary key is null, msg {}", JSONObject.toJSON(account), isAdKeyValid.getMsg());
                    return isAdKeyValid;
                }
                ReportAdnetworkAccount duplicatedAccount = this.getDuplicatedAccount(account);
                if (duplicatedAccount != null) {
                    log.warn("Account {} already existed", JSONObject.toJSON(account));
                    return Response.RES_DATA_EXISTED;
                }
            }
            account.setCreateTime(null);
            account.setLastmodify(new Date());
            int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
            if (result <= 0) {
                throw new RuntimeException("Update account " + JSONObject.toJSON(account) + "failed");
            }
            return Response.buildSuccess(account);
        } catch (Exception e) {
            log.error("Update account {} error:", JSONObject.toJSON(account), e);
        }
        return Response.RES_FAILED;
    }

    public Response deleteAccount(Integer accountId) {
        try {
            ReportAdnetworkAccount account = this.reportAdnetworkAccountMapper.selectByPrimaryKey(accountId);
            if (account == null) {
                log.error("Account id {} does not existed", accountId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            account.setStatus((byte) NormalStatus.Deleted.ordinal());
            int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
            if (result <= 0) {
                throw new RuntimeException("Delete account " + accountId + "failed");
            }
            return Response.buildSuccess(account);
        } catch (Exception e) {
            log.error("Delete account {} error:", accountId, e);
        }
        return Response.RES_FAILED;
    }

    public Response isAdKeyValid(ReportAdnetworkAccount account) {
        AdNetworkType adNetworkType = AdNetworkType.getAdNetworkType(account.getAdnId());
        switch (adNetworkType) {
            case AdMob: {
                if (account.getAuthType() != null && account.getAuthType().intValue() == 0) {
                    if (StringUtils.isBlank(account.getUserId())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Publisher ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnApiKey()) ){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client JSON] must be not null");
                    }
                } else if (account.getAuthType() != null && account.getAuthType().intValue() == 2) {
                    if (StringUtils.isBlank(account.getAdnAppId())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [API key] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnApiKey()) ){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client key] must be not null");
                    }
                    if (StringUtils.isBlank(account.getUserSignature())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client Secrect] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Refresh Token] must be not null");
                    }
                } else if (account.getAuthType() != null && account.getAuthType().intValue() == 1) {
                    if (StringUtils.isBlank(account.getUserId())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Publisher ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())){
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Refresh Token] must be not null");
                    }
                } else {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Auth Type] must be not null");
                }
                break;
            }
            case Chartboost:
                if (StringUtils.isBlank(account.getUserId())){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [ User Signature] must be not null");
                }
                break;
            case IronSource:
                if (StringUtils.isBlank(account.getUserId())){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "IronSource's [User Name] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "IronSource's [Secret Key] must be not null");
                }
                break;
            case TikTok: {
                if (StringUtils.isEmpty(account.getUserId())){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "TikTok's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "TikTok's [Security-Key] must be not null");
                }
                break;
            }
            case Unity:
                if (StringUtils.isBlank(account.getAdnApiKey()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Unity's [API Key] must be not null");
                }
                break;
            case Vungle:
                if (StringUtils.isBlank(account.getAdnApiKey()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Vungle's [Reporting API Key] must be not null");
                }
                break;
            case AppLovin:
                if (StringUtils.isBlank(account.getAdnApiKey()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "AppLovin's [Report Key] must be not null");
                }
                break;
            case Mopub:
                if (StringUtils.isBlank(account.getAdnAppId()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mopub's [API Key] must be not null");
                }
                if (StringUtils.isBlank(account.getAdnApiKey()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mopub's [Inventory Report ID] must be not null");
                }
                break;
            case Mintegral: {
                if (StringUtils.isBlank(account.getAdnApiKey()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mintegral's [Report API SKey] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature()) ){
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mintegral's [Report API Secret] must be not null");
                }
                break;
            }
            case AdColony: {
                if (StringUtils.isBlank(account.getAdnAppToken())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "AdColony's [Read-Only API Key] must be not null");
                }
                break;
            }
            case Tapjoy: {
                if (StringUtils.isBlank(account.getAdnAppToken())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Tapjoy's [Publisher Reporting API Key] must be not null");
                }
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Tapjoy's [Ad Reporting API Key] must be not null");
                }
                break;
            }
            default:
                return Response.RES_DATA_DOES_NOT_EXISTED;
        }
        return Response.build();
    }
}
