package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.AdNetworkType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.model.ReportAdnetworkAccountCriteria;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    @Resource
    private ReportAdnetworkAccountMapper reportAdnetworkAccountMapper;

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
            ReportAdnetworkAccount duplicatedAccount = this.getDuplicatedAccount(account);
            if (duplicatedAccount != null) {
                log.warn("Account {} already existed", JSONObject.toJSON(account));
                return Response.RES_DATA_EXISTED;
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
}
