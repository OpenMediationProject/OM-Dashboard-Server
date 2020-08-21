package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dao.ReportAdnetworkAccountPublisherMapper;
import com.adtiming.om.ds.dto.AdNetworkType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.auth.oauth2.TokenResponseException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Account Manager
 *
 * @author dianbo ruan
 */
@Service
public class AccountService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    @Resource
    protected ReportAdnetworkAccountMapper reportAdnetworkAccountMapper;

    @Resource
    protected ReportAdnetworkAccountPublisherMapper reportAdnetworkAccountPublisherMapper;

    @Resource
    protected AdmobService admobService;

    public ReportAdnetworkAccount getAccount(Integer accountId) {
        return this.reportAdnetworkAccountMapper.selectByPrimaryKey(accountId);
    }

    public List<ReportAdnetworkAccount> getAccounts(Integer adnId) {
        return this.getAccounts(adnId, this.getCurrentUser().getPublisherId());
    }

    public Map<Integer, ReportAdnetworkAccount> getPublisherAccountMap(Integer publisherId) {
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        criteria.andPublisherIdEqualTo(publisherId);
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        List<ReportAdnetworkAccount> accounts = this.reportAdnetworkAccountMapper.select(accountCriteria);
        return accounts.stream().collect(Collectors.toMap(ReportAdnetworkAccount::getId, Function.identity()));
    }

    public List<ReportAdnetworkAccount> getAccounts(Integer adnId, Integer publisherId) {
        ReportAdnetworkAccountPublisherCriteria publisherCriteria = new ReportAdnetworkAccountPublisherCriteria();
        ReportAdnetworkAccountPublisherCriteria.Criteria publisherCriteriaCriteria = publisherCriteria.createCriteria();
        publisherCriteriaCriteria.andPublisherIdEqualTo(publisherId);
        List<ReportAdnetworkAccountPublisher> reportAdnetworkAccountPublishers = this.reportAdnetworkAccountPublisherMapper.select(publisherCriteria);
        if (CollectionUtils.isEmpty(reportAdnetworkAccountPublishers)) {
            return new ArrayList<>();
        }
        List<Integer> accountIds = new ArrayList<>();
        reportAdnetworkAccountPublishers.forEach(reportAdnetworkAccountPublisher -> {
            accountIds.add(reportAdnetworkAccountPublisher.getReportAccountId());
        });
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        criteria.andIdIn(accountIds);
        criteria.andAdnIdNotEqualTo(AdNetworkType.Facebook.ordinal());
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        return this.reportAdnetworkAccountMapper.select(accountCriteria);
    }

    public List<ReportAdnetworkAccount> getPublisherAccounts(Integer adnId, Integer publisherId, NormalStatus status, String adnAppId) {
        ReportAdnetworkAccountPublisherCriteria publisherCriteria = new ReportAdnetworkAccountPublisherCriteria();
        ReportAdnetworkAccountPublisherCriteria.Criteria publisherCriteriaCriteria = publisherCriteria.createCriteria();
        publisherCriteriaCriteria.andPublisherIdEqualTo(publisherId);
        List<ReportAdnetworkAccountPublisher> reportAdnetworkAccountPublishers = reportAdnetworkAccountPublisherMapper.select(publisherCriteria);
        if (CollectionUtils.isEmpty(reportAdnetworkAccountPublishers)) {
            return new ArrayList<>();
        }
        List<Integer> accountIds = new ArrayList<>();
        reportAdnetworkAccountPublishers.forEach(reportAdnetworkAccountPublisher -> {
            accountIds.add(reportAdnetworkAccountPublisher.getReportAccountId());
        });
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        criteria.andIdIn(accountIds);
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        if (StringUtils.isNotBlank(adnAppId)) {
            criteria.andAdnAppIdEqualTo(adnAppId);
        }
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        return this.reportAdnetworkAccountMapper.select(accountCriteria);
    }

    public Map<Integer, Collection<JSONObject>> getPublisherAdnAccountWithAppIconsMap(NormalStatus status) {
        Integer publisherId = this.getCurrentUser().getPublisherId();
        List<ReportAdnetworkAccount> accountsWithAppIcon = this.reportAdnetworkAccountMapper.selectWithAppIconByPublisher(publisherId);
        Map<Integer, Collection<JSONObject>> adnAccountWithAppIconsMap = new HashMap<>();
        if (CollectionUtils.isEmpty(accountsWithAppIcon)) {
            return adnAccountWithAppIconsMap;
        }
        Map<Integer, List<ReportAdnetworkAccount>> adnAccountsMap = accountsWithAppIcon.stream().collect(
                Collectors.groupingBy(ReportAdnetworkAccount::getAdnId));
        for (Map.Entry<Integer, List<ReportAdnetworkAccount>> entry : adnAccountsMap.entrySet()) {
            List<ReportAdnetworkAccount> adnAccounts = entry.getValue();
            Map<Integer, JSONObject> accountWithAppIconsMap = new HashMap<>();
            for (ReportAdnetworkAccount account : adnAccounts) {
                if (status != null && status.ordinal() != account.getStatus()) {
                    continue;
                }
                JSONObject accountJson = accountWithAppIconsMap.get(account.getId());
                if (accountJson == null) {
                    accountJson = (JSONObject) JSONObject.toJSON(account);
                }
                Set<String> appIcons = (Set<String>) accountJson.get("appIcons");
                if (appIcons == null) {
                    appIcons = new HashSet<>();
                }
                if (!StringUtils.isEmpty(account.getIcon())) {
                    appIcons.add(account.getIcon());
                }
                accountJson.put("appIcons", appIcons);
                accountWithAppIconsMap.put(account.getId(), accountJson);
            }
            adnAccountWithAppIconsMap.put(entry.getKey(), accountWithAppIconsMap.values());
        }
        return adnAccountWithAppIconsMap;
    }

    public ReportAdnetworkAccount getDuplicatedAccount(ReportAdnetworkAccount account) {
        ReportAdnetworkAccountCriteria accountCriteria = new ReportAdnetworkAccountCriteria();
        ReportAdnetworkAccountCriteria.Criteria criteria = accountCriteria.createCriteria();
        criteria.andAdnIdEqualTo(account.getAdnId());
        if (account.getId() != null && account.getId() > 0) {
            criteria.andIdNotEqualTo(account.getId());
        }
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        String primaryKey = "";
        AdNetworkType adNetworkType = AdNetworkType.getAdNetworkType(account.getAdnId());
        switch (adNetworkType) {
            case AdMob:
            case Chartboost:
            case ChartboostBid:
            case IronSource:
            case TencentAd:
            case TikTok: {
                criteria.andUserIdEqualTo(account.getUserId());
                primaryKey = account.getUserId();
                break;
            }
            case Unity:
            case Vungle:
            case AppLovin:
            case Mopub:
            case Mintegral: {
                criteria.andAdnApiKeyEqualTo(account.getAdnApiKey());
                primaryKey = account.getAdnApiKey();
                break;
            }
            case Adtiming:
            case AdColony:
            case Mint:
            case Tapjoy: {
                criteria.andAdnAppTokenEqualTo(account.getAdnAppToken());
                primaryKey = account.getAdnAppToken();
                break;
            }
            case Facebook: {
                criteria.andAdnAppIdEqualTo(account.getAdnAppId());
                criteria.andPublisherIdNotEqualTo(account.getPublisherId());
                primaryKey = account.getAdnAppId() + "_" + account.getPublisherId();
                break;
            }
            case Fyber: {
                criteria.andUserIdEqualTo(account.getUserId());
                criteria.andAdnAppIdEqualTo(account.getAdnApiKey());
                criteria.andUserSignatureEqualTo(account.getUserSignature());
                primaryKey = account.getUserId() + "_" + account.getAdnApiKey() + "_" + account.getUserSignature();
                break;
            }
            default:
                throw new RuntimeException("Not support Adnetwork id " + account.getAdnId());
        }
        List<ReportAdnetworkAccount> accounts = reportAdnetworkAccountMapper.select(accountCriteria);
        if (!CollectionUtils.isEmpty(accounts)) {
            ReportAdnetworkAccount duplicatedAccount = accounts.get(0);
            duplicatedAccount.setPrimaryKey(primaryKey);
            return duplicatedAccount;
        }
        return null;
    }

    @Transactional
    public Response createAccount(ReportAdnetworkAccount account) {
        if (account.getAdnId() == AdNetworkType.AdMob.ordinal() && account.getAuthType() == 2) {
            Response response = admobService.getAdmobPublisherId(account.getAdnApiKey(),
                    account.getUserSignature(), account.getAdnAppToken());
            if (response.getCode() != Response.SUCCESS_CODE){
                return response;
            }
            account.setUserId(response.getData().toString());
        }

        Response isAdKeyValid = this.isAdKeyValid(account);
        if (isAdKeyValid.getCode() != Response.SUCCESS_CODE) {
            log.error("Account {} primary key is null, msg {}", JSONObject.toJSON(account), isAdKeyValid.getMsg());
            return isAdKeyValid;
        }

        Integer publisherId = this.getCurrentUser().getPublisherId();
        ReportAdnetworkAccount duplicatedAccount = this.getDuplicatedAccount(account);
        if (duplicatedAccount != null) {
            String warn = "This Ad Network Account " + duplicatedAccount.getPrimaryKey() + " already exists. " +
                    "If you confirm it's your account, and be sure to use it, please contact your AdTiming account manager.";
            log.warn(warn);
            return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, warn);
        }

        account.setCreateTime(new Date());
        account.setStatus((byte)NormalStatus.Active.ordinal());
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
        ReportAdnetworkAccountPublisher accountPublisher = new ReportAdnetworkAccountPublisher();
        accountPublisher.setPublisherId(publisherId);
        accountPublisher.setReportAccountId(account.getId());
        ReportAdnetworkAccountPublisher dbAccountPublisher = this.reportAdnetworkAccountPublisherMapper.selectByPrimaryKey(accountPublisher);
        if (dbAccountPublisher == null) {
            result = this.reportAdnetworkAccountPublisherMapper.insertSelective(accountPublisher);
            if (result <= 0) {
                throw new RuntimeException("Insert ReportAdnetworkAccountPublisher " + JSONObject.toJSON(accountPublisher) + " failed!");
            }
        }
        return Response.buildSuccess(account);
    }

    public Response updateAccount(ReportAdnetworkAccount account) {
        try {
            ReportAdnetworkAccount oldAccount = this.reportAdnetworkAccountMapper.selectByPrimaryKey(account.getId());
            if (account.getStatus() == null || account.getStatus().equals(oldAccount.getStatus())) {
                Response isAdKeyValid = this.isAdKeyValid(account);
                if (isAdKeyValid.getCode() != Response.SUCCESS_CODE) {
                    log.error("Account {} primary key is null, msg {}", JSONObject.toJSON(account), isAdKeyValid.getMsg());
                    return isAdKeyValid;
                }
                account.setStatus((byte)NormalStatus.Active.ordinal());
                ReportAdnetworkAccount duplicatedAccount = this.getDuplicatedAccount(account);
                if (duplicatedAccount != null) {
                    String warn = "This Ad Network Account " + duplicatedAccount.getPrimaryKey() + " already exists. " +
                            "If you confirm it's your account, and be sure to use it, please contact your AdTiming account manager.";
                    log.warn(warn);
                    return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, warn);
                }
            }

            Response response = this.isUserRelateToAccount(account);
            if (response.getCode() != Response.SUCCESS_CODE) {
                return response;
            }
            account.setCreateTime(null);
            account.setLastmodify(new Date());
            account.setAdnAccountOwner((byte) 0);
            int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
            if (result <= 0) {
                throw new RuntimeException("Update account " + account.getId() + "failed");
            }
            return Response.buildSuccess(account);
        } catch (Exception e) {
            log.error("Update account {} error:", JSONObject.toJSON(account), e);
        }
        return Response.RES_FAILED;
    }

    @Transactional
    public Response deleteAccount(Integer accountId) {
        ReportAdnetworkAccount account = this.reportAdnetworkAccountMapper.selectByPrimaryKey(accountId);
        if (account == null) {
            log.error("Account id {} does not existed", accountId);
            return Response.RES_DATA_DOES_NOT_EXISTED;
        }
        Response response = this.isUserRelateToAccount(account);
        if (response.getCode() != Response.SUCCESS_CODE) {
            return response;
        }
        UmUser user = getCurrentUser();
        ReportAdnetworkAccountPublisherCriteria criteria = new ReportAdnetworkAccountPublisherCriteria();
        ReportAdnetworkAccountPublisherCriteria.Criteria cri = criteria.createCriteria();
        cri.andPublisherIdNotEqualTo(user.getPublisherId());
        cri.andReportAccountIdEqualTo(accountId);
        List<ReportAdnetworkAccountPublisher> list = reportAdnetworkAccountPublisherMapper.select(criteria);
        if (list.isEmpty()) {
            account.setStatus((byte) NormalStatus.Deleted.ordinal());
            account.setAdnAccountOwner((byte) 0);
            int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
            if (result <= 0) {
                throw new RuntimeException("Delete account " + accountId + "failed");
            }
        } else {
            ReportAdnetworkAccountPublisherKey key = new ReportAdnetworkAccountPublisherKey();
            key.setPublisherId(user.getPublisherId());
            key.setReportAccountId(accountId);
            int result = this.reportAdnetworkAccountPublisherMapper.deleteByPrimaryKey(key);
            if (result <= 0) {
                throw new RuntimeException("Delete account " + accountId + "failed");
            }
        }
        return Response.buildSuccess(account);
    }

    @Transactional
    private Response isUserRelateToAccount(ReportAdnetworkAccount account) {
        UmUser currentUser = this.getCurrentUser();
        ReportAdnetworkAccountPublisherKey key = new ReportAdnetworkAccountPublisherKey();
        key.setPublisherId(currentUser.getPublisherId());
        key.setReportAccountId(account.getId());
        ReportAdnetworkAccountPublisher accountPublisher = this.reportAdnetworkAccountPublisherMapper.selectByPrimaryKey(key);
        if (accountPublisher == null) {
            log.error("Account {} does not belong to user {} ", account.getId(), currentUser.getEmail());
            return Response.failure(Response.CODE_RES_UNAUTHORIZED, "You can't update this account, it's not belong to current publisher");
        }
        return Response.build();
    }

    public Response isAdKeyValid(ReportAdnetworkAccount account) {
        AdNetworkType adNetworkType = AdNetworkType.getAdNetworkType(account.getAdnId());
        switch (adNetworkType) {
            case Adtiming: {
                if (StringUtils.isBlank(account.getAdnAppToken())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Adtiming's [API Token] must be not null");
                }
                break;
            }
            case AdMob: {
                if (account.getAuthType() != null && account.getAuthType().intValue() == 0) {
                    if (StringUtils.isBlank(account.getUserId())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Publisher ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnApiKey())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client JSON] must be not null");
                    }
                } else if (account.getAuthType() != null && account.getAuthType().intValue() == 2) {
                    if (StringUtils.isBlank(account.getAdnAppId())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [API key] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnApiKey())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client key] must be not null");
                    }
                    if (StringUtils.isBlank(account.getUserSignature())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Client Secrect] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Refresh Token] must be not null");
                    }
                } else if (account.getAuthType() != null && account.getAuthType().intValue() == 1) {
                    if (StringUtils.isBlank(account.getUserId())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Publisher ID] must be not null");
                    }
                    if (StringUtils.isBlank(account.getAdnAppToken())) {
                        return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Refresh Token] must be not null");
                    }
                } else {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Admob's [Auth Type] must be not null");
                }
                break;
            }
            case ChartboostBid:
            case Chartboost:
                if (StringUtils.isBlank(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Chartboost's [ User Signature] must be not null");
                }
                break;
            case IronSource:
                if (StringUtils.isBlank(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "IronSource's [User Name] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "IronSource's [Secret Key] must be not null");
                }
                break;
            case TikTok: {
                if (StringUtils.isEmpty(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "TikTok's [User ID] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "TikTok's [Security-Key] must be not null");
                }
                break;
            }
            case Unity:
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Unity's [API Key] must be not null");
                }
                break;
            case Vungle:
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Vungle's [Reporting API Key] must be not null");
                }
                break;
            case AppLovin:
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "AppLovin's [Report Key] must be not null");
                }
                break;
            case Mopub:
                if (StringUtils.isBlank(account.getAdnAppId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mopub's [API Key] must be not null");
                }
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mopub's [Inventory Report ID] must be not null");
                }
                break;
            case Mintegral: {
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mintegral's [Report API SKey] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
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
            case Facebook: {
                if (StringUtils.isBlank(account.getAdnAppId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Facebook's [App ID] must be not null");
                }
                if (StringUtils.isBlank(account.getAdnAppToken())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Facebook's [System User Access Token] must be not null");
                }
                break;
            }
            case Fyber: {
                if (StringUtils.isBlank(account.getUserId())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Fyber's [Publisher ID] must be not null");
                }
                if (StringUtils.isBlank(account.getAdnApiKey())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Fyber's [Consumer key] must be not null");
                }
                if (StringUtils.isBlank(account.getUserSignature())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Fyber's [Consumer Secret] must be not null");
                }
                break;
            }
            case Mint:{
                if (StringUtils.isBlank(account.getAdnAppToken())) {
                    return Response.failure(Response.CODE_PARAMETER_NULL, "Mint's [App token] must be not null");
                }
                break;
            }
            default:
                throw new RuntimeException("Not support ad network id " + account.getAdnId());
        }
        return Response.build();
    }
}
