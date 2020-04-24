// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmAdnetworkAppMapper;
import com.adtiming.om.ds.dao.OmAdnetworkMapper;
import com.adtiming.om.ds.dao.OmPublisherAppMapper;
import com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper;
import com.adtiming.om.ds.dto.AdvertisementType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.ReportApiStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.ReflectUtil;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
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

    @Resource
    private OmAdnetworkMapper omAdnetworkMapper;

    @Resource
    private OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    private OmPublisherAppMapper omPublisherAppMapper;

    @Resource
    private ReportAdnetworkAccountMapper reportAdnAccountMapper;

    @Resource
    private InstanceService instanceService;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public boolean doesPlatMatch(OmPublisherApp publisherApp, OmAdnetwork adNetwork){
        if (publisherApp != null && publisherApp.getPlat() == 0 && adNetwork.getIosAdtype() == 0) {
            return false;
        }
        if (publisherApp != null && publisherApp.getPlat() == 1 && adNetwork.getAndroidAdtype() == 0) {
            return false;
        }
        return true;
    }

    /**
     * Select all AdNetwork
     *
     * @return resultAdnetWorks
     */
    public JSONArray getAdNetworks(Integer pubAppId) {
        JSONArray resultAdNetWorks = new JSONArray();
        List<OmInstanceWithBLOBs> appInstances = instanceService.getInstancesByStatus(pubAppId, NormalStatus.ACTIVE);
        Map<Integer, List<OmInstanceWithBLOBs>> appAdnIdInstanceMap = appInstances.stream()
                .collect(Collectors.groupingBy(OmInstance::getAdnId, Collectors.toList()));

        OmPublisherApp publisherApp = omPublisherAppMapper.selectByPrimaryKey(pubAppId);
        List<OmAdnetworkApp> adNetworkApps = this.getAdNetWorkApps(pubAppId);
        Map<Integer, OmAdnetworkApp> appAdNetworkMap = new HashMap<>();
        for (OmAdnetworkApp omAdnetworkApp : adNetworkApps) {
            appAdNetworkMap.put(omAdnetworkApp.getAdnId(), omAdnetworkApp);
        }

        List<OmAdnetwork> adNetworks = this.getAllAdNetworks();
        for (OmAdnetwork adNetwork : adNetworks) {
            if (!this.doesPlatMatch(publisherApp, adNetwork)){
                continue;
            }
            JSONObject resultAdNetwork = (JSONObject) JSONObject.toJSON(adNetwork);
            resultAdNetwork.put("status", 0);
            resultAdNetwork.put("adTypes", this.buildAdTypes(adNetwork, publisherApp));
            resultAdNetwork.put("reportapiStatus", "OFF");

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
                if (reportApiStatus.ordinal() == ReportApiStatus.NotSet.ordinal()) {
                    resultAdNetwork.put("reportapiStatus", ReportApiStatus.OFF.name());
                } else {
                    resultAdNetwork.put("reportapiStatus", reportApiStatus.name());
                }
                resultAdNetwork.put("status", omAdnetworkApp.getStatus());
                resultAdNetwork.put("adNetworkApp", omAdnetworkApp);
            } else {
                resultAdNetwork.put("reportapiStatus", ReportApiStatus.OFF.name());
            }
            if (adNetwork.getStatus() != 1) {
                resultAdNetwork.put("reportapiStatus", ReportApiStatus.OFF.name());
            }
            resultAdNetWorks.add(resultAdNetwork);
        }
        return resultAdNetWorks;
    }

    private JSONArray buildAdTypes(OmAdnetwork adNetwork, OmPublisherApp publisherApp) {
        Byte adType = adNetwork.getAndroidAdtype();
        if (publisherApp != null && publisherApp.getPlat() == (byte) 0) {
            adType = adNetwork.getIosAdtype();
        }
        String typeStr = Integer.toBinaryString(adType);
        typeStr = new StringBuilder(typeStr).reverse().toString();
        JSONArray adTypes = new JSONArray();
        for (int type = 0; type < typeStr.length() && type < 4; type++) {
            char hourChar = typeStr.charAt(type);
            if ("1" .equals(hourChar + "")) {
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
    public Map<Integer, OmAdnetworkApp> getAdNetworkIdAppMap(Integer pubAppId) {
        List<OmAdnetworkApp> omAdNetworkApps = this.getAdNetWorkApps(pubAppId);
        Map<Integer, OmAdnetworkApp> adNetworkAppMap = new HashMap<>();
        omAdNetworkApps.forEach(omAdNetworkApp -> adNetworkAppMap.put(omAdNetworkApp.getAdnId(), omAdNetworkApp));
        return adNetworkAppMap;
    }

    /**
     * Select AdNetworks by publisher app id, adNetWorkId
     *
     * @return omAdNetworkApps
     */
    public List<OmAdnetworkApp> getAdNetWorkApps(Integer pubAppId) {
        OmAdnetworkAppCriteria omAdnetworkAppCriteria = new OmAdnetworkAppCriteria();
        OmAdnetworkAppCriteria.Criteria criteria = omAdnetworkAppCriteria.createCriteria();
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
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
    public Response createAppAdNetwork(OmAdnetworkApp omAdnetworkApp) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            int result = this.omAdnetworkAppMapper.insertSelective(omAdnetworkApp);
            if (result > 0) {
                saveReportAccount(sqlSession, omAdnetworkApp);
                log.info("Create AppAdNetwork {} success", omAdnetworkApp.getId());
            }
            sqlSession.commit();
            return Response.buildSuccess(omAdnetworkApp);
        } catch (Exception e) {
            log.info("Create AdNetwork {} error", JSONObject.toJSONString(omAdnetworkApp), e);
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        log.info("Create AdNetwork {} failed", JSONObject.toJSONString(omAdnetworkApp));
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement failed!");
    }

    /**
     * Update app AdNetworks database object
     *
     * @param omAdnetworkApp
     */
    public Response updateAppAdNetworks(OmAdnetworkApp omAdnetworkApp) {
        Connection conn = null;
        try (SqlSession sqlSession = sqlSessionFactory.openSession(false)) {
            conn = sqlSession.getConnection();
            conn.setAutoCommit(false);
            //savepoint = conn.setSavepoint();
            OmAdnetworkApp oldAdnApp = this.omAdnetworkAppMapper.selectByPrimaryKey(omAdnetworkApp.getId());
            if (oldAdnApp == null) {
                log.error("AdNetworkAppId {} does not existed", omAdnetworkApp.getId());
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            int result = sqlSession.update("com.adtiming.om.ds.dao.OmAdnetworkAppMapper.updateByPrimaryKeySelective", omAdnetworkApp);
            //int result = this.omAdnetworkAppMapper.updateByPrimaryKeySelective(omAdnetworkApp);
            if (result > 0) {
                // save adnetwork report account info
                updateReportAccount(sqlSession, omAdnetworkApp, oldAdnApp);
                accountMajorKeyChanged(sqlSession, oldAdnApp, omAdnetworkApp);
                log.info("Update AdNetworks {} success", omAdnetworkApp.getId());
            }
            conn.commit();
            return Response.build();
        } catch (Exception e) {
            log.error("Update AdNetworks error {}", JSONObject.toJSONString(omAdnetworkApp), e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ignored) {
            }
        }
        log.error("Update AdNetworks {} failed", omAdnetworkApp.getId());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update AdNetworks failed!");
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

    private void saveReportAccount(SqlSession sqlSession, OmAdnetworkApp adnApp) {
        Map<String, String> fieldMap = new HashMap<>();
        String primaryFiled = buildAccountInfo(adnApp.getAdnId(), fieldMap);
        if (StringUtils.isNotBlank(primaryFiled)) {
            Object primaryValue = ReflectUtil.getValue(adnApp, primaryFiled);
            if (primaryValue == null || StringUtils.isBlank(primaryValue.toString())) {
                return;
            }
            String whereSql = String.format("%s='%s'", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldMap.get(primaryFiled)), primaryValue);
            List<ReportAdnetworkAccount> accountList = reportAdnAccountMapper.selectByDynamic(whereSql);
            if (accountList != null && !accountList.isEmpty()) {
                ReportAdnetworkAccount oldAccount = accountList.get(0);
                ReportAdnetworkAccount newAccount = new ReportAdnetworkAccount();
                newAccount.setId(oldAccount.getId());
                final boolean[] needChanged = {false};
                fieldMap.forEach((adnField, accountField) -> {
                    //Account info changed
                    if (!ReflectUtil.equals(adnApp, oldAccount, adnField, accountField)) {
                        ReflectUtil.setValue(newAccount, accountField, ReflectUtil.getValue(adnApp, adnField));
                        needChanged[0] = true;
                    }
                });
                if (needChanged[0]) {
                    //reportAdnAccountMapper.updateByPrimaryKeySelective(newAccount);
                    sqlSession.update("com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper.updateByPrimaryKeySelective", newAccount);
                    updateReportAccountId(sqlSession, adnApp, oldAccount);
                }
            } else {
                ReportAdnetworkAccount account = new ReportAdnetworkAccount();
                final boolean[] needInsert = {true};
                fieldMap.forEach((adnField, accountField) -> {
                    Object fieldValue = ReflectUtil.getValue(adnApp, adnField);
                    if (fieldValue == null || StringUtils.isBlank(fieldValue.toString())) {
                        needInsert[0] = false;
                        return;
                    }
                    ReflectUtil.setValue(account, accountField, fieldValue);
                });
                if (needInsert[0]) {
                    fillInsertAccountField(account, adnApp);
                    sqlSession.update("com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper.insertSelective", account);
                    //reportAdnAccountMapper.insertSelective(account);
                    updateReportAccountId(sqlSession, adnApp, account);
                }
            }
        }
    }

    private void fillInsertAccountField(ReportAdnetworkAccount account, OmAdnetworkApp adnApp) {
        account.setAdnId(adnApp.getAdnId());
        account.setAuthKey(Util.buildAuthKey());
        if (account.getAdnId() == 2) {//admob
            account.setCredentialPath("/credential/" + account.getAuthKey());
        }
    }

    private void updateReportAccount(SqlSession sqlSession, OmAdnetworkApp newAdnApp, OmAdnetworkApp oldAdnApp) {
        Map<String, String> fieldMap = new HashMap<>();
        String primaryFiled = buildAccountInfo(oldAdnApp.getAdnId(), fieldMap);
        if (StringUtils.isNotBlank(primaryFiled)) {
            Map<String, Object> valueChangeMap = ReflectUtil.getChangedValues(oldAdnApp, newAdnApp, new ArrayList<>(fieldMap.keySet()));
            if (valueChangeMap.isEmpty()) {
                return;
            }

            //Account info changed
            String whereSql = String.format("%s='%s'", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldMap.get(primaryFiled)), ReflectUtil.getValue(newAdnApp, primaryFiled));
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
                    sqlSession.update("com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper.updateByPrimaryKeySelective", newAccount);
                    //reportAdnAccountMapper.updateByPrimaryKeySelective(newAccount);
                    updateReportAccountId(sqlSession, oldAdnApp, oldAccount);
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
                    fillInsertAccountField(account, oldAdnApp);
                    sqlSession.update("com.adtiming.om.ds.dao.ReportAdnetworkAccountMapper.insertSelective", account);
                    //reportAdnAccountMapper.insertSelective(account);
                    updateReportAccountId(sqlSession, oldAdnApp, account);
                }
            }
        }
    }

    private void updateReportAccountId(SqlSession sqlSession, OmAdnetworkApp oldAdnApp, ReportAdnetworkAccount account) {
        if (!oldAdnApp.getReportAccountId().equals(account.getId())) {
            OmAdnetworkApp updateAccountIdAdn = new OmAdnetworkApp();
            updateAccountIdAdn.setId(oldAdnApp.getId());
            updateAccountIdAdn.setReportAccountId(account.getId());
            sqlSession.update("com.adtiming.om.ds.dao.OmAdnetworkAppMapper.updateByPrimaryKeySelective", updateAccountIdAdn);
            //omAdnetworkAppMapper.updateByPrimaryKeySelective(updateAccountIdAdn);
        }
    }

    private String buildAccountInfo(int adnId, Map<String, String> fieldMap) {
        String primaryFiled = "";
        switch (adnId) {
            case 1://Adtiming
                fieldMap.put("refreshToken", "adnAppToken");
                primaryFiled = "refreshToken";
                break;
            case 2://Admob
                fieldMap.put("clientId", "adnApiKey");
                fieldMap.put("clientSecret", "adnAppToken");
                fieldMap.put("reportAppId", "userId");
                primaryFiled = "reportAppId";
                break;
            case 3: //Facebook
                fieldMap.put("adnAppKey", "adnAppId");
                fieldMap.put("refreshToken", "adnAppToken");
                primaryFiled = "adnAppKey";
                break;
            case 4: //Unity
                fieldMap.put("apiKey", "adnApiKey");
                primaryFiled = "apiKey";
                break;
            case 5: //Vungle
                fieldMap.put("reportAppId", "adnApiKey");
                primaryFiled = "reportAppId";
                break;
            case 7: //AdColony
                fieldMap.put("clientSecret", "adnAppToken");
                primaryFiled = "clientSecret";
                break;
            case 8: //AppLovin
            case 9: //Mopub
                fieldMap.put("adnAppKey", "adnAppId");
                fieldMap.put("apiKey", "adnApiKey");
                primaryFiled = "apiKey";
                break;
            case 11: //Tapjoy
                fieldMap.put("apiKey", "adnApiKey");
                fieldMap.put("refreshToken", "adnAppToken");
                primaryFiled = "apiKey";
                break;
            case 12: //Charboost
                fieldMap.put("apiKey", "userId");
                fieldMap.put("clientSecret", "userSignature");
                primaryFiled = "apiKey";
                break;
            case 13: //TikTok
                fieldMap.put("clientId", "userId");
                fieldMap.put("clientSecret", "userSignature");
                primaryFiled = "clientId";
                break;
            case 14: //Mintegral
                fieldMap.put("apiKey", "adnApiKey");
                fieldMap.put("clientSecret", "userSignature");
                primaryFiled = "apiKey";
                break;
            default:
                break;
        }
        return primaryFiled;
    }

    private void accountMajorKeyChanged(SqlSession sqlSession, OmAdnetworkApp old, OmAdnetworkApp newAdnApp) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String keyField = getAccountKeyField(old.getAdnId());
        Object keyValue = ReflectUtil.getValue(newAdnApp, keyField);
        //OmAdnetworkApp adnApp = omAdnetworkAppMapper.selectByPrimaryKey(newAdnApp.getId());
        if (keyValue != null && StringUtils.isNotBlank(keyValue.toString()) //Account Major Key changed
                && !ReflectUtil.equals(old, newAdnApp, keyField, keyField)
                && Util.byteToInt(old.getStatus()) == 1) {
            //adnetworkAppChangeMapper.deleteByPrimaryKey(old.getId());
            //sqlSession.delete("com.adtiming.om.ds.dao.OmAdnetworkAppChangeMapper.deleteByPrimaryKey", old.getId());
            OmAdnetworkAppChange appChange = new OmAdnetworkAppChange();
            PropertyUtils.copyProperties(appChange, old);
            appChange.setNewAccountKey(keyValue.toString());
            sqlSession.update("com.adtiming.om.ds.dao.OmAdnetworkAppChangeMapper.insertSelective", appChange);
            //adnetworkAppChangeMapper.insertSelective(appChange);
        }
    }

    private String getAccountKeyField(int adnId) {
        switch (adnId) {
            case 1:
            case 4:
                return "reportAppId";
            case 2:
            case 7:
            case 8:
            case 15:
                return "adnAppKey";
            case 3:
            case 10:
            case 11:
            case 12:
            case 14:
                return "apiKey";
            case 6:
                return "refreshToken";
        }
        return "";
    }
}
