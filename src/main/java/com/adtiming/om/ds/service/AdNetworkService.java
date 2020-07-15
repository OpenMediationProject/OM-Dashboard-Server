// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.*;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.ReflectUtil;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
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
    public JSONArray getAdNetworks(Integer pubAppId) {
        JSONArray resultAdNetWorks = new JSONArray();
        List<OmInstanceWithBLOBs> appInstances = instanceService.getInstancesByStatus(pubAppId, NormalStatus.Active);
        Map<Integer, List<OmInstanceWithBLOBs>> appAdnIdInstanceMap = appInstances.stream()
                .collect(Collectors.groupingBy(OmInstance::getAdnId, Collectors.toList()));

        OmPublisherApp publisherApp = omPublisherAppMapper.selectByPrimaryKey(pubAppId);
        Map<Integer, OmAdnetworkApp> appAdNetworkMap = this.getAdNetWorkAppMap(pubAppId);
        List<OmAdnetwork> adNetworks = this.getAllAdNetworks();
        for (OmAdnetwork adNetwork : adNetworks) {
            if (!this.doesPlatMatch(publisherApp, adNetwork)) {
                continue;
            }
            JSONObject resultAdNetwork = (JSONObject) JSONObject.toJSON(adNetwork);
            resultAdNetwork.put("status", 0);
            resultAdNetwork.put("adTypes", this.buildAdTypes(adNetwork, publisherApp));
            resultAdNetwork.put("reportapiStatus", ReportApiStatus.OFF.name());

            List<OmInstanceWithBLOBs> appAdnInstances = appAdnIdInstanceMap.get(adNetwork.getId());
            if (!CollectionUtils.isEmpty(appAdnInstances)) {
                resultAdNetwork.put("instanceSize", appAdnInstances.size());
            } else {
                resultAdNetwork.put("instanceSize", 0);
            }
            OmAdnetworkApp omAdnetworkApp = appAdNetworkMap.get(adNetwork.getId());
            if (omAdnetworkApp != null) {
                resultAdNetwork.put("adNetworkAppId", omAdnetworkApp.getId());
                ReportApiStatus reportApiStatus = ReportApiStatus.getReportApiStatus(omAdnetworkApp.getReportapiStatus());
                resultAdNetwork.put("reportapiStatus", reportApiStatus.name());
                resultAdNetwork.put("status", omAdnetworkApp.getStatus());
                if (AdNetworkType.AdMob.name().equals(adNetwork.getClassName())) {
                    ReportAdnetworkAccount account = reportAdnAccountMapper.selectByPrimaryKey(omAdnetworkApp.getReportAccountId());
                    if (account != null) {
                        omAdnetworkApp.setRedirectUrl("/api/report/callback/admob/" + account.getAuthKey());
                    }
                }
                resultAdNetwork.put("adNetworkApp", omAdnetworkApp);
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

    private String getAdMobRedirectUrl(Integer reportAdNetworkAccountId) {
        ReportAdnetworkAccount account = reportAdnAccountMapper.selectByPrimaryKey(reportAdNetworkAccountId);
        if (account != null) {
            return "/api/report/callback/admob/" + account.getAuthKey();
        }
        return null;
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
        if (adnId != null){
            criteria.andAdnIdEqualTo(adnId);
        }
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (status != null){
            criteria.andStatusEqualTo((byte)status.ordinal());
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
        try {
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
                ReportAdnetworkAccount account = new ReportAdnetworkAccount();
                account.setAdnId(omAdnetworkApp.getAdnId());
                account.setAdnAppId(omAdnetworkApp.getAdnAppKey());
                account.setAdnAppToken(omAdnetworkApp.getRefreshToken());
                account.setPublisherId(this.getCurrentUser().getPublisherId());
                ReportAdnetworkAccount existedAccount = this.accountService.getDuplicatedAccount(account);
                if (existedAccount == null) {
                    int result = this.reportAdnetworkAccountMapper.insertSelective(account);
                    if (result <= 0) {
                        throw new RuntimeException("Create facebook account " + JSONObject.toJSON(omAdnetworkApp) + " failed");
                    }
                } else {
                    account.setId(existedAccount.getId());
                    int result = this.reportAdnetworkAccountMapper.updateByPrimaryKeySelective(account);
                    if (result <= 0) {
                        throw new RuntimeException("Update facebook account " + JSONObject.toJSON(omAdnetworkApp) + " failed");
                    }
                }
                omAdnetworkApp.setReportapiStatus((byte) SwitchStatus.ON.ordinal());
                this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
            }
            log.info("Create AppAdNetwork {} success", omAdnetworkApp.getId());
            return Response.buildSuccess(omAdnetworkApp);
        } catch (Exception e) {
            log.info("Create AdNetwork {} error", JSONObject.toJSONString(omAdnetworkApp), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement failed!");
    }

    /**
     * Update app AdNetworks database object
     *
     * @param omAdnetworkApp
     */
    @Transactional
    public Response updateAppAdNetworks(OmAdnetworkApp omAdnetworkApp) {
        try {
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
                this.updateFacebookReportAccount(omAdnetworkApp, dbAdnApp);
                if (omAdnetworkApp.getAdnAppKey() != null && dbAdnApp.getAdnAppKey() != null
                        && dbAdnApp.getStatus().intValue() == ReportApiStatus.Running.ordinal()
                        && !omAdnetworkApp.getAdnAppKey().equals(dbAdnApp.getAdnAppKey())) {
                    OmAdnetworkAppChange appChange = new OmAdnetworkAppChange();
                    PropertyUtils.copyProperties(appChange, dbAdnApp);
                    appChange.setNewAccountKey(omAdnetworkApp.getAdnAppKey());
                    appChange.setNewReportAccountId(omAdnetworkApp.getReportAccountId());
                    result = this.omAdnetworkAppChangeMapper.insertSelective(appChange);
                    if (result <= 0) {
                        throw new RuntimeException("Add Facebook OmAdnetworkAppChange for " + JSONObject.toJSON(dbAdnApp) + " failed");
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
        } catch (Exception e) {
            log.error("Update AdNetworks error {}", JSONObject.toJSONString(omAdnetworkApp), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update AdNetworks failed!");
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

    /**
     * Update adNetwork app status
     *
     * @param status
     */
    public Response updateAdNetworkAppStatus(Integer adNetworkAppId, Byte status) {
        try {
            OmAdnetworkApp omAdnetworkApp = this.omAdnetworkAppMapper.selectByPrimaryKey(adNetworkAppId);
            if (omAdnetworkApp == null) {
                log.error("AdNetworkAppId {} does not existed", adNetworkAppId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            if (status.intValue() == NormalStatus.Active.ordinal()){
                omAdnetworkApp.setReportapiStatus((byte)NormalStatus.Active.ordinal());
            } else {
                omAdnetworkApp.setReportapiStatus((byte)NormalStatus.Pending.ordinal());
            }
            omAdnetworkApp.setStatus(status);
            int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
            if (result > 0) {
                log.info("Update AdNetworks {} success", omAdnetworkApp.getId());
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Update AdNetworks error adNetworkAppId {}", adNetworkAppId, e);
        }
        log.error("Update AdNetworks app status {} failed, status {}", adNetworkAppId, status);
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update adNetwork app status failed!");
    }

    @Transactional
    private void updateFacebookReportAccount(OmAdnetworkApp newAdnApp, OmAdnetworkApp oldAdnApp) {
        Map<String, String> fieldMap = new HashMap<>();
        String primaryFiled = "adnAppKey";
        fieldMap.put("adnAppKey", "adnAppId");
        fieldMap.put("refreshToken", "adnAppToken");
        if (StringUtils.isNotBlank(primaryFiled)) {
            Map<String, Object> valueChangeMap = ReflectUtil.getChangedValues(oldAdnApp, newAdnApp, new ArrayList<>(fieldMap.keySet()));
            if (valueChangeMap.isEmpty()) {
                return;
            }

            //Account info changed
            String whereSql = String.format("%s='%s'", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldMap.get(primaryFiled)),
                    ReflectUtil.getValue(newAdnApp, primaryFiled));
            List<ReportAdnetworkAccount> accountList = reportAdnAccountMapper.selectByDynamic(whereSql);
            if (accountList != null && !accountList.isEmpty()) {
                ReportAdnetworkAccount oldAccount = accountList.get(0);
                ReportAdnetworkAccount newAccount = new ReportAdnetworkAccount();
                newAccount.setId(oldAccount.getId());
                final boolean[] hasNullValue = {false};
                valueChangeMap.forEach((filed, changedVal) -> {
                    if (changedVal == null || StringUtils.isBlank(changedVal.toString())) {
                        hasNullValue[0] = true;
                        return;
                    }
                    ReflectUtil.setValue(newAccount, fieldMap.get(filed), changedVal);
                });
                if (!hasNullValue[0]) {
                    int result = this.reportAdnAccountMapper.updateByPrimaryKeySelective(newAccount);
                    if (result <= 0) {
                        throw new RuntimeException("updateFacebookReportAccount " + oldAdnApp.getId() + "failed");
                    }
                    updateReportAccountId(oldAdnApp, oldAccount);
                }
            } else {
                ReportAdnetworkAccount account = new ReportAdnetworkAccount();
                final boolean[] needInsert = {true};
                valueChangeMap.forEach((filed, changedVal) -> {
                    if (changedVal == null || StringUtils.isBlank(changedVal.toString())) {
                        needInsert[0] = false;
                        return;
                    }
                    ReflectUtil.setValue(account, fieldMap.get(filed), changedVal);
                });
                if (needInsert[0]) {
                    account.setAdnId(oldAdnApp.getAdnId());
                    account.setAuthKey(Util.buildAuthKey());
                    if (account.getPublisherId() == null){
                        account.setPublisherId(this.getCurrentUser().getPublisherId());
                    }
                    account.setAdnAppId(newAdnApp.getAdnAppKey());
                    account.setAdnAppToken(newAdnApp.getRefreshToken());
                    int result = this.reportAdnAccountMapper.insertSelective(account);
                    if (result <= 0) {
                        throw new RuntimeException("Create Facebook Report Account " + oldAdnApp.getId() + "failed");
                    }
                    updateReportAccountId(oldAdnApp, account);
                }
            }
        }
    }

    @Transactional
    private void updateReportAccountId(OmAdnetworkApp oldAdnApp, ReportAdnetworkAccount account) {
        if (!oldAdnApp.getReportAccountId().equals(account.getId())) {
            OmAdnetworkApp updateAccountIdAdn = new OmAdnetworkApp();
            updateAccountIdAdn.setId(oldAdnApp.getId());
            updateAccountIdAdn.setReportapiStatus((byte) ReportApiStatus.Running.ordinal());
            updateAccountIdAdn.setReportAccountId(account.getId());
            int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(updateAccountIdAdn);
            if (result <= 0) {
                throw new RuntimeException("updateReportAccountId " + oldAdnApp.getId() + "failed");
            }
        }
    }
}
