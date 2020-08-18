// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.*;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AdNetwork Manager
 *
 * @author dianbo ruan
 */
@Service
public class AdNetworkService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private ReportAdnetworkAccountMapper reportAdnetworkAccountMapper;

    @Resource
    private OmAdnetworkMapper omAdnetworkMapper;

    @Resource
    private OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    private OmAdnetworkAppChangeMapper omAdnetworkAppChangeMapper;

    @Resource
    private OmPublisherAppMapper omPublisherAppMapper;

    @Resource
    private ReportAdnetworkAccountMapper reportAdnAccountMapper;

    @Resource
    private OmAdnetworkAppChangeMapper adnAppChange;

    @Resource
    private InstanceService instanceService;

    @Resource
    private AccountService accountService;

    /**
     * Select all AdNetwork
     *
     * @return resultAdnetWorks
     */
    public List<JSONObject> getAdNetworks(Integer pubAppId) {
        List<JSONObject> resultAdNetWorks = new ArrayList<>();
        List<OmInstanceWithBLOBs> appInstances = instanceService.getInstancesByStatus(pubAppId, NormalStatus.Active);
        Map<Integer, List<OmInstanceWithBLOBs>> appAdnIdInstanceMap = appInstances.stream()
                .collect(Collectors.groupingBy(OmInstanceWithBLOBs::getAdnId, Collectors.toList()));

        OmPublisherApp publisherApp = this.omPublisherAppMapper.selectByPrimaryKey(pubAppId);
        Map<Integer, OmAdnetworkApp> appAdNetworkMap = this.getAdNetWorkAppMap(pubAppId);
        Map<Integer, ReportAdnetworkAccount> publisherAccountMap = this.accountService.getPublisherAccountMap(this.getCurrentPublisherId());
        List<OmAdnetwork> adNetworks = this.getAllAdNetworks();
        for (OmAdnetwork adNetwork : adNetworks) {
            if (!this.doesPlatMatch(publisherApp, adNetwork)) {
                continue;
            }
            JSONObject resultAdNetwork = (JSONObject) JSONObject.toJSON(adNetwork);
            resultAdNetwork.put("status", NormalStatus.Pending.ordinal());
            resultAdNetwork.put("adTypes", this.buildAdTypes(adNetwork, publisherApp));

            List<OmInstanceWithBLOBs> appAdnInstances = appAdnIdInstanceMap.get(adNetwork.getId());
            if (!CollectionUtils.isEmpty(appAdnInstances)) {
                resultAdNetwork.put("instanceSize", appAdnInstances.size());
            } else {
                resultAdNetwork.put("instanceSize", 0);
            }
            OmAdnetworkApp msdkPublisherApp = appAdNetworkMap.get(adNetwork.getId());
            if (msdkPublisherApp != null) {
                resultAdNetwork.put("adNetworkAppId", msdkPublisherApp.getId());
                resultAdNetwork.put("reportAccountId", msdkPublisherApp.getReportAccountId());
                resultAdNetwork.put("status", msdkPublisherApp.getStatus());
                Integer reportAccountId = msdkPublisherApp.getReportAccountId();
                ReportAdnetworkAccount account = publisherAccountMap.get(reportAccountId);
                if (account == null && reportAccountId != null && reportAccountId > 0) {
                    account = this.accountService.getAccount(reportAccountId);
                }
                if (account != null) {
                    resultAdNetwork.put("accountStatus", account.getStatus());
                    resultAdNetwork.put("reason", account.getReason());
                }
                if (AdNetworkType.AdMob.ordinal() == adNetwork.getId() && account != null) {
                    msdkPublisherApp.setRedirectUrl("/api/report/callback/admob/" + account.getAuthKey());
                }
                resultAdNetwork.put("adNetworkApp", msdkPublisherApp);
            }
            resultAdNetWorks.add(resultAdNetwork);
        }
        return resultAdNetWorks;
    }

    public boolean doesPlatMatch(OmPublisherApp publisherApp, OmAdnetwork adNetwork) {
        if (publisherApp != null && publisherApp.getPlat() == MobilePlatformType.iOS.ordinal() && adNetwork.getIosAdtype() == 0) {
            return false;
        }
        return publisherApp == null || publisherApp.getPlat() != MobilePlatformType.Android.ordinal() || adNetwork.getAndroidAdtype() != 0;
    }

    public List<String> buildAdTypes(OmAdnetwork adNetwork, OmPublisherApp publisherApp) {
        Byte adType = adNetwork.getAndroidAdtype();
        if (publisherApp != null && publisherApp.getPlat() == (byte) 0) {
            adType = adNetwork.getIosAdtype();
        }
        String typeStr = Integer.toBinaryString(adType);
        typeStr = new StringBuilder(typeStr).reverse().toString();
        List<String> adTypes = new ArrayList<>();
        for (int type = 0; type < typeStr.length() && type < 10; type++) {
            char hourChar = typeStr.charAt(type);
            if ("1".equals(hourChar + "")) {
                AdvertisementType advertisementType = AdvertisementType.getAdvertisementType(type);
                adTypes.add(advertisementType.name());
            }
        }
        return adTypes;
    }

    /**
     * Select all AdNetwork
     *
     * @return resultAdnetWorks
     */
    public List<OmAdnetwork> getAllAdNetworks() {
        OmAdnetworkCriteria omAdnetworkCriteria = new OmAdnetworkCriteria();
        OmAdnetworkCriteria.Criteria criteria = omAdnetworkCriteria.createCriteria();
        criteria.andStatusEqualTo((byte) 1);
        criteria.andPublisherVisibleEqualTo((byte) 1);
        return omAdnetworkMapper.select(omAdnetworkCriteria);
    }

    /**
     * Select AdNetworkMap
     *
     * @return resultAdnetWorks
     */
    public Map<Integer, OmAdnetwork> getAdNetworkMap() {
        List<OmAdnetwork> adNetworks = omAdnetworkMapper.select(new OmAdnetworkCriteria());
        Map<Integer, OmAdnetwork> adNetworkMap = new HashMap<>();
        for (OmAdnetwork omAdnetwork : adNetworks) {
            adNetworkMap.put(omAdnetwork.getId(), omAdnetwork);
        }
        return adNetworkMap;
    }

    /**
     * Select AdNetwork app adNetWorkAppId
     *
     * @return omAdNetworkApp
     */
    public OmAdnetworkApp getAdNetWorkApp(Integer adNetworkAppId) {
        OmAdnetworkApp omAdNetworkApp = this.omAdnetworkAppMapper.selectByPrimaryKey(adNetworkAppId);
        log.info("Select app's adNetWork: {}", JSONObject.toJSONString(omAdNetworkApp));
        return omAdNetworkApp;
    }

    /**
     * Get a map which key is adnid, the value is OmAdnetworkApp for a pubAppId
     *
     * @return adNetworkAppMap
     */
    public Map<Integer, OmAdnetworkApp> getAdNetworkIdAppMap(Integer pubAppId, NormalStatus status) {
        List<OmAdnetworkApp> omAdNetworkApps = this.getAdNetWorkApps(pubAppId, null, status);
        Map<Integer, OmAdnetworkApp> adNetworkAppMap = new HashMap<>();
        omAdNetworkApps.forEach(omAdNetworkApp -> adNetworkAppMap.put(omAdNetworkApp.getAdnId(), omAdNetworkApp));
        return adNetworkAppMap;
    }

    /**
     * Select AdNetworks by publisher app id, adNetWorkId
     *
     * @return omAdNetworkAppMap
     */
    public Map<Integer, OmAdnetworkApp> getAdNetWorkAppMap(Integer pubAppId) {
        List<OmAdnetworkApp> adNetworkApps = this.getAdNetWorkApps(pubAppId, null, null);
        Map<Integer, OmAdnetworkApp> appAdNetworkMap = new HashMap<>();
        for (OmAdnetworkApp omAdnetworkApp : adNetworkApps) {
            appAdNetworkMap.put(omAdnetworkApp.getAdnId(), omAdnetworkApp);
        }
        return appAdNetworkMap;
    }

    /**
     * Select AdNetworks by publisher app id, adNetWorkId
     *
     * @return omAdNetworkApps
     */
    public List<OmAdnetworkApp> getAdNetWorkApps(Integer pubAppId, Integer adnId, NormalStatus status) {
        OmAdnetworkAppCriteria omAdnetworkAppCriteria = new OmAdnetworkAppCriteria();
        OmAdnetworkAppCriteria.Criteria criteria = omAdnetworkAppCriteria.createCriteria();
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        List<OmAdnetworkApp> omAdNetworkApps = this.omAdnetworkAppMapper.select(omAdnetworkAppCriteria);
        log.info("Select app's adNetWork size: {}", omAdNetworkApps.size());
        return omAdNetworkApps;
    }

    /**
     * create app AdNetworks database object
     *
     * @param omAdnetworkApp
     */
    @Transactional
    public Response createAppAdNetwork(OmAdnetworkApp omAdnetworkApp) {
        List<OmAdnetworkApp> omAdNetworkApps = this.getAdNetWorkApps(omAdnetworkApp.getPubAppId(),
                omAdnetworkApp.getAdnId(), NormalStatus.Active);
        if (!CollectionUtils.isEmpty(omAdNetworkApps)) {
            log.error("OmAdnetworkApp {} already existed", JSONObject.toJSON(omAdnetworkApp));
            return Response.RES_DATA_EXISTED;
        }

        ReportAdnetworkAccount adNetworkAccount = this.reportAdnetworkAccountMapper.selectByPrimaryKey(omAdnetworkApp.getReportAccountId());
        if (adNetworkAccount != null && adNetworkAccount.getStatus() == SwitchStatus.ON.ordinal()) {
            omAdnetworkApp.setReportapiStatus((byte) SwitchStatus.ON.ordinal());
        }

        if (omAdnetworkApp.getAdnId() == AdNetworkType.Mopub.ordinal()) {
            omAdnetworkApp.setAdnAppKey(adNetworkAccount.getAdnApiKey());
        }

        omAdNetworkApps = this.getAdNetWorkApps(omAdnetworkApp.getPubAppId(), omAdnetworkApp.getAdnId(), null);
        if (CollectionUtils.isEmpty(omAdNetworkApps)) {
            int result = this.omAdnetworkAppMapper.insertSelective(omAdnetworkApp);
            if (result <= 0) {
                throw new RuntimeException("Create AdNetwork app " + JSONObject.toJSONString(omAdnetworkApp) + " failed");
            }
        } else {
            omAdnetworkApp.setId(omAdNetworkApps.get(0).getId());
            int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
            if (result <= 0) {
                throw new RuntimeException("Create AdNetwork app " + JSONObject.toJSONString(omAdnetworkApp) + " use existed item failed");
            }
        }

        if (omAdnetworkApp.getAdnId() == AdNetworkType.Facebook.ordinal()) {
            this.addFacebookAccount(omAdnetworkApp);
        }
        log.info("Create AppAdNetwork {} success", omAdnetworkApp.getId());
        return Response.buildSuccess(omAdnetworkApp);
    }

    /**
     * Update app AdNetworks database object
     *
     * @param omAdnetworkApp
     */
    @Transactional
    public Response updateAppAdNetworks(OmAdnetworkApp omAdnetworkApp) throws Exception {
        OmAdnetworkApp dbAdnApp = this.omAdnetworkAppMapper.selectByPrimaryKey(omAdnetworkApp.getId());
        if (dbAdnApp == null) {
            log.error("AdNetworkAppId {} does not existed", omAdnetworkApp.getId());
            return Response.RES_DATA_DOES_NOT_EXISTED;
        }
        int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
        if (result <= 0) {
            throw new RuntimeException("Update AdNetworks app " + JSONObject.toJSON(omAdnetworkApp) + " failed");
        }
        if (AdNetworkType.Facebook.ordinal() == omAdnetworkApp.getAdnId()) {
            if (omAdnetworkApp.getAdnAppKey() == null || omAdnetworkApp.getRefreshToken() == null) {
                throw new RuntimeException("App ID or System User Access Token must not null when create facebook account");
            }
            if (!omAdnetworkApp.getAdnAppKey().equals(dbAdnApp.getAdnAppKey()) || !omAdnetworkApp.getRefreshToken().equals(dbAdnApp.getRefreshToken())) {
                if (!omAdnetworkApp.getAdnAppKey().equals(dbAdnApp.getAdnAppKey())) {
                    this.addFacebookAccount(omAdnetworkApp);
                    if (!org.springframework.util.StringUtils.isEmpty(dbAdnApp.getAdnAppKey())) {
                        OmAdnetworkAppChange appChange = new OmAdnetworkAppChange();
                        PropertyUtils.copyProperties(appChange, dbAdnApp);
                        appChange.setNewAccountKey(omAdnetworkApp.getAdnAppKey());
                        appChange.setNewReportAccountId(omAdnetworkApp.getReportAccountId());
                        result = this.omAdnetworkAppChangeMapper.insertSelective(appChange);
                        if (result <= 0) {
                            throw new RuntimeException("Add Facebook MsdkPublisherAppChange for " + JSONObject.toJSON(dbAdnApp) + " failed!");
                        }
                    }
                } else if (!omAdnetworkApp.getRefreshToken().equals(dbAdnApp.getRefreshToken())) {
                    ReportAdnetworkAccount account = this.accountService.getAccount(dbAdnApp.getReportAccountId());
                    account.setAdnAppToken(omAdnetworkApp.getRefreshToken());
                    Response response = this.accountService.updateAccount(account);
                    if (response.getCode() != Response.SUCCESS_CODE) {
                        throw new RuntimeException(response.getMsg());
                    }
                }
            }
        } else if (dbAdnApp.getReportAccountId() != null && !dbAdnApp.getReportAccountId().equals(omAdnetworkApp.getReportAccountId())) {
            OmAdnetworkAppChange appChange = this.copyAdNetworkApp(dbAdnApp);
            appChange.setNewReportAccountId(omAdnetworkApp.getReportAccountId());
            result = this.omAdnetworkAppChangeMapper.insertSelective(appChange);
            if (result <= 0) {
                throw new RuntimeException("Add OmAdnetworkApp for " + JSONObject.toJSON(dbAdnApp) + " failed");
            }
        }
        return Response.buildSuccess(omAdnetworkApp);
    }

    private OmAdnetworkAppChange copyAdNetworkApp(OmAdnetworkApp app) {
        OmAdnetworkAppChange appChange = new OmAdnetworkAppChange();
        appChange.setId(app.getId());
        appChange.setPubAppId(app.getPubAppId());
        appChange.setAdnId(app.getAdnId());
        appChange.setReportAccountId(app.getReportAccountId());
        appChange.setAccountId(app.getAccountId());
        appChange.setAccountOwner(app.getAccountOwner());
        appChange.setAdnAppKey(app.getAdnAppKey());
        appChange.setReportAppId(app.getReportAppId());
        appChange.setRefreshToken(app.getRefreshToken());
        return appChange;
    }

    @Transactional
    private void addFacebookAccount(OmAdnetworkApp omAdnetworkApp) {
        List<ReportAdnetworkAccount> accounts = this.accountService.getPublisherAccounts(AdNetworkType.Facebook.ordinal(),
                this.getCurrentUser().getPublisherId(), NormalStatus.Active, omAdnetworkApp.getAdnAppKey());
        ReportAdnetworkAccount account = null;
        if (CollectionUtils.isEmpty(accounts)) {
            account = new ReportAdnetworkAccount();
            account.setAdnId(omAdnetworkApp.getAdnId());
            account.setAdnAppId(omAdnetworkApp.getAdnAppKey());
            account.setAdnAppToken(omAdnetworkApp.getRefreshToken());
            account.setPublisherId(this.getCurrentUser().getPublisherId());
            account.setAdnAccountOwner((byte) 0);
            Response response = this.accountService.createAccount(account);
            if (response.getCode() != Response.SUCCESS_CODE) {
                throw new RuntimeException(response.getMsg());
            }
        } else {
            account = accounts.get(0);
            if (!omAdnetworkApp.getRefreshToken().equals(account.getAdnAppToken())) {
                account.setAdnAppToken(omAdnetworkApp.getRefreshToken());
                account.setStatus((byte)NormalStatus.Active.ordinal());
                int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
                if (result <= 0) {
                    throw new RuntimeException("Update account " + JSONObject.toJSON(account) + "failed");
                }
            }
        }
        omAdnetworkApp.setReportAccountId(account.getId());
        omAdnetworkApp.setReportapiStatus((byte) SwitchStatus.ON.ordinal());
        int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
        if (result <= 0) {
            throw new RuntimeException("Update facebook report account id failed for create " + JSONObject.toJSON(omAdnetworkApp));
        }
    }

    /**
     * Update adNetwork app status
     *
     * @param status
     */
    public Response updateAdNetworkAppStatus(Integer adNetworkAppId, Byte status) {
        OmAdnetworkApp omAdnetworkApp = this.omAdnetworkAppMapper.selectByPrimaryKey(adNetworkAppId);
        if (omAdnetworkApp == null) {
            log.error("AdNetworkAppId {} does not existed", adNetworkAppId);
            return Response.RES_DATA_DOES_NOT_EXISTED;
        }
        if (status.intValue() == NormalStatus.Active.ordinal()) {
            omAdnetworkApp.setReportapiStatus((byte) NormalStatus.Active.ordinal());
        } else {
            omAdnetworkApp.setReportapiStatus((byte) NormalStatus.Pending.ordinal());
        }
        omAdnetworkApp.setStatus(status);
        int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
        if (result <= 0) {
            throw new RuntimeException("Update adNetwork " + omAdnetworkApp.getId() + " failed!");
        }
        return Response.build();
    }
}
