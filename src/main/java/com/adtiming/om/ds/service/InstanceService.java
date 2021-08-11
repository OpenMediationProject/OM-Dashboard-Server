// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.AdNetworkType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Placement Manager
 *
 * @author dianbo ruan
 */
@Service
public class InstanceService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    OmInstanceMapper omInstanceMapper;

    @Resource
    OmInstanceCountryMapper omInstanceCountryMapper;

    @Resource
    OmInstanceChangeMapper omInstanceChangeMapper;

    @Resource
    OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    OmPlacementMapper omPlacementMapper;

    public Map<Integer, List<JSONObject>> getInstanceCountriesMap(Integer placementId){
        if (placementId == null){
            return new HashMap<>();
        }
        OmInstanceCountryCriteria countryCriteria = new OmInstanceCountryCriteria();
        OmInstanceCountryCriteria.Criteria criteria = countryCriteria.createCriteria();
        criteria.andPlacementIdEqualTo(placementId);
        List<OmInstanceCountry> instanceCountries = this.omInstanceCountryMapper.select(countryCriteria);
        Map<Integer, List<OmInstanceCountry>> instanceCountriesMap = instanceCountries.stream()
                .collect(Collectors.groupingBy(OmInstanceCountry::getInstanceId, Collectors.toList()));
        Map<Integer, List<JSONObject>> instanceCountryMap = new HashMap<>();
        for (Map.Entry<Integer, List<OmInstanceCountry>> entry : instanceCountriesMap.entrySet()){
            Integer instanceId = entry.getKey();
            List<OmInstanceCountry> ics = entry.getValue();
            List<JSONObject> results = new ArrayList<>();
            Map<BigDecimal, List<OmInstanceCountry>> ecpmIcsMap = ics.stream().collect(Collectors.groupingBy(OmInstanceCountry::getManualEcpm, Collectors.toList()));
            for (Map.Entry<BigDecimal, List<OmInstanceCountry>> entry1 : ecpmIcsMap.entrySet()){
                List<String> countries = new ArrayList<>();
                for (OmInstanceCountry icy : entry1.getValue()){
                    countries.add(icy.getCountry());
                }
                JSONObject result = new JSONObject();
                result.put("manualEcpm", entry1.getKey());
                result.put("country", StringUtils.join(countries, ","));
                results.add(result);
            }
            instanceCountryMap.put(instanceId, results);
        }
        return instanceCountryMap;
    }

    /**
     * Select instances
     *
     * @param instanceId
     * @return instances
     */
    public OmInstanceWithBLOBs getInstance(Integer instanceId) {
        return this.omInstanceMapper.selectByPrimaryKey(instanceId);
    }

    public boolean isPlacementKeyDuplicated(OmInstanceWithBLOBs instance, OmInstanceWithBLOBs dbInstance) {
        if (StringUtils.isEmpty(instance.getPlacementKey())){
            return false;
        }

        if (instance.getAdnId() == AdNetworkType.CrossPromotion.ordinal()) {
            return false;
        }

        if (dbInstance != null && instance.getPlacementKey().equals(dbInstance.getPlacementKey())){
            return false;
        }

        AdNetworkType adNetworkType = AdNetworkType.getAdNetworkType(instance.getAdnId());
        switch (adNetworkType) {
            case AppLovin:
            case Mopub:
            case Tapjoy:
            case Chartboost:
            case ChartboostBid:
                break;
            default: {
                List<Integer> pubAppIds = new ArrayList<>();
                pubAppIds.add(instance.getPubAppId());
                List<OmInstanceWithBLOBs> instances = this.getInstance(instance.getAdnId(), pubAppIds, instance.getPlacementKey(), SwitchStatus.ON);
                if (!CollectionUtils.isEmpty(instances)){
                    return true;
                }
                return false;
            }
        }

        Integer pubAppId = instance.getPubAppId();
        OmAdnetworkApp omAdnetworkApp = this.omAdnetworkAppMapper.selectByPrimaryKey(instance.getAdnAppId());
        if (omAdnetworkApp == null) {
            omAdnetworkApp = this.getOmAdNetworkApp(instance.getPubAppId(), instance.getAdnId());
        }
        if (omAdnetworkApp == null){
            log.error("Publisher app id " + pubAppId + " does not existed! Adn:" + instance.getAdnId());
            return true;
        }
        if (omAdnetworkApp.getReportAccountId() == null || omAdnetworkApp.getReportAccountId() == 0){
            log.error("Publisher app " + pubAppId + " does not have valid report account!");
            return true;
        }

        OmAdnetworkAppCriteria appCriteria = new OmAdnetworkAppCriteria();
        OmAdnetworkAppCriteria.Criteria criteria = appCriteria.createCriteria();
        criteria.andReportAccountIdEqualTo(omAdnetworkApp.getReportAccountId());
        criteria.andAdnIdEqualTo(instance.getAdnId());
        List<OmAdnetworkApp> apps = this.omAdnetworkAppMapper.select(appCriteria);
        if (CollectionUtils.isEmpty(apps)){
            log.error("Report account " + omAdnetworkApp.getReportAccountId() + " does not belong to any app!");
            return true;
        }
        List<Integer> pubAppIds = apps.stream().map(OmAdnetworkApp::getPubAppId).collect(Collectors.toList());
        String placementKey = instance.getPlacementKey();
        List<OmInstanceWithBLOBs> instances = this.getInstance(instance.getAdnId(), pubAppIds, placementKey, SwitchStatus.ON);
        if (instance.getId() != null) {
            instances.removeIf(instance1 -> instance1.getId().equals(instance.getId()));
        }
        return !CollectionUtils.isEmpty(instances) || this.isInstancePlacementKeyUsed(instance);
    }

    /**
     * instance修改记录内没有相同的pk
     *     - instance修改记录仅有效3天
     *     - 3天内这个pk不能有其他instance在用，避免该pk在其他instance上使用时，因为历史原因导致收益数据被混淆的情况
     *     - 如果修改记录的instance所属app，和当前app是同一个app，则不限制
     * **/
    private boolean isInstancePlacementKeyUsed(OmInstanceWithBLOBs newInstance){
        OmInstanceChangeCriteria changeCriteria = new OmInstanceChangeCriteria();
        OmInstanceChangeCriteria.Criteria criteria = changeCriteria.createCriteria();
        criteria.andAdnIdEqualTo(newInstance.getAdnId().byteValue());
        criteria.andPlacementKeyEqualTo(newInstance.getPlacementKey());
        Date today = Util.getDateYYYYMMDD(Util.getDateString(new Date()));
        if (today == null){
            today = new Date();
        }
        criteria.andCreateTimeGreaterThan(DateUtils.addDays(today, -3));
        List<OmInstanceChange> instanceChanges = this.omInstanceChangeMapper.select(changeCriteria);
        if (CollectionUtils.isEmpty(instanceChanges)){
            return false;
        }
        Iterator<OmInstanceChange> iterator = instanceChanges.listIterator();
        while (iterator.hasNext()){
            if (!iterator.next().getPubAppId().equals(newInstance.getPubAppId())){
                return true;
            } else {
                iterator.remove();
            }
        }
        return !CollectionUtils.isEmpty(instanceChanges);
    }

    /**
     * Select instances
     *
     * @param placementKey
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstance(Integer adnId, List<Integer> pubAppIds, String placementKey, SwitchStatus switchStatus) {
        OmInstanceCriteria instanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = instanceCriteria.createCriteria();
        if (placementKey != null) {
            criteria.andPlacementKeyEqualTo(placementKey);
        }
        if (adnId != null) {
            criteria.andAdnAppIdEqualTo(adnId);
        }
        if (!CollectionUtils.isEmpty(pubAppIds)) {
            criteria.andPubAppIdIn(pubAppIds);
        }
        if (switchStatus != null) {
            criteria.andStatusEqualTo((byte) SwitchStatus.ON.ordinal());
        }
        return this.omInstanceMapper.select(instanceCriteria);
    }

    private OmAdnetworkApp getOmAdNetworkApp(Integer pubAppId, Integer adnId){
        OmAdnetworkAppCriteria adNetworkAppCriteria = new OmAdnetworkAppCriteria();
        OmAdnetworkAppCriteria.Criteria criteria = adNetworkAppCriteria.createCriteria();
        criteria.andPubAppIdEqualTo(pubAppId);
        criteria.andAdnIdEqualTo(adnId);
        List<OmAdnetworkApp> omAdNetworkApps = this.omAdnetworkAppMapper.select(adNetworkAppCriteria);
        if (!CollectionUtils.isEmpty(omAdNetworkApps)) {
            return omAdNetworkApps.get(0);
        }
        return null;
    }

    public Map<Integer, List<OmInstanceWithBLOBs>> getPlacementInstancesMap(Integer pubAppId) {
        List<OmInstanceWithBLOBs> instances = this.getInstances(pubAppId, NormalStatus.Active);
        if (CollectionUtils.isEmpty(instances)) {
            return new HashMap<>();
        }
        return instances.stream().collect(Collectors.groupingBy(OmInstanceWithBLOBs::getPlacementId, Collectors.toList()));
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @param placementKey
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstance(Integer adnId, Integer pubAppId, String placementKey) {
        OmInstanceCriteria instanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = instanceCriteria.createCriteria();
        criteria.andAdnIdEqualTo(adnId);
        criteria.andPubAppIdEqualTo(pubAppId);
        criteria.andPlacementKeyEqualTo(placementKey);
        criteria.andStatusEqualTo((byte) NormalStatus.Active.ordinal());
        return this.omInstanceMapper.select(instanceCriteria);
    }

    /**
     * Get adnetworks id which has valid instance
     */
    public Set<Integer> getAdnIdsWithInstance(Integer pubAppId) {
        List<OmInstanceWithBLOBs> instances = this.getInstances(pubAppId);
        Set<Integer> adnIdSet = new HashSet<>();
        instances.forEach(instance -> {
            if (instance.getStatus() == NormalStatus.Active.ordinal()) {
                adnIdSet.add(instance.getAdnId());
            }
        });
        return adnIdSet;
    }

    /**
     * get placement id set
     *
     * @param placementId
     * @param adNetworkId
     * @return placementIdSet
     */
    public Set<Integer> getPlacementIds(Integer adNetworkId, Integer placementId) {
        List<OmInstanceWithBLOBs> instances = this.getInstances(null, adNetworkId, null, placementId);
        Set<Integer> placementIdSet = new HashSet<>();
        instances.forEach(instance -> placementIdSet.add(instance.getPlacementId()));
        return placementIdSet;
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @param adNetworkId
     * @param instanceId
     * @param placementId
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstances(Integer pubAppId, Integer adNetworkId, Integer instanceId, Integer placementId) {
        List<Integer> adnIds = null;
        if (adNetworkId != null) {
            adnIds = new ArrayList<>();
            adnIds.add(adNetworkId);
        }
        return this.getInstances(pubAppId, adnIds, instanceId, placementId, null, null, null);
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @param adNetworkIds
     * @param instanceId
     * @param placementId
     * @param status
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstances(Integer pubAppId, String[] adNetworkIds, Integer instanceId, Integer placementId, NormalStatus status) {
        OmInstanceCriteria omInstanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = omInstanceCriteria.createCriteria();
        criteria.andPubAppIdEqualTo(pubAppId);
        if (adNetworkIds != null && adNetworkIds.length > 0) {
            List<Integer> adNetworkIdList = new ArrayList<>();
            for (String adNetworkId : adNetworkIds) {
                adNetworkIdList.add(Integer.parseInt(adNetworkId));
            }
            criteria.andAdnIdIn(adNetworkIdList);
        }
        if (instanceId != null) {
            criteria.andIdEqualTo(instanceId);
        }
        if (placementId != null) {
            criteria.andPlacementIdEqualTo(placementId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        List<OmInstanceWithBLOBs> instances = this.omInstanceMapper.select(omInstanceCriteria);
        log.info("Select instance by publisher id size: {}", instances.size());
        return instances;
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @param adNetworkIds
     * @param instanceId
     * @param placementId
     * @param status
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstances(Integer pubAppId, List<Integer> adNetworkIds, Integer instanceId,
                                                  Integer placementId, NormalStatus status, Byte headBid, Integer adNetworkAppId) {
        OmInstanceCriteria omInstanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = omInstanceCriteria.createCriteria();
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (adNetworkIds != null) {
            criteria.andAdnIdIn(adNetworkIds);
        }
        if (instanceId != null) {
            criteria.andIdEqualTo(instanceId);
        }
        if (placementId != null) {
            criteria.andPlacementIdEqualTo(placementId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        if (headBid != null) {
            criteria.andHbStatusEqualTo(headBid);
        }
        if (adNetworkAppId != null) {
            criteria.andAdnAppIdEqualTo(adNetworkAppId);
        }
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        omInstanceCriteria.setOrderByClause(" create_time desc ");
        List<OmInstanceWithBLOBs> instances = this.omInstanceMapper.select(omInstanceCriteria);
        log.info("Select instance by publisher id size: {}", instances.size());
        return instances;
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @return instanceMap
     */
    public Map<Integer, OmInstanceWithBLOBs> getInstanceMap(Integer pubAppId) {
        Map<Integer, OmInstanceWithBLOBs> instanceMap = new HashMap<>();
        List<OmInstanceWithBLOBs> instances = this.getInstances(pubAppId);
        for (OmInstanceWithBLOBs instance : instances) {
            instanceMap.put(instance.getId(), instance);
        }
        return instanceMap;
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstances(Integer pubAppId) {
        return this.getInstances(pubAppId, null);
    }

    /**
     * Select instances
     *
     * @param pubAppId
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstances(Integer pubAppId, NormalStatus status) {
        OmInstanceCriteria omInstanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = omInstanceCriteria.createCriteria();
        criteria.andPubAppIdEqualTo(pubAppId);
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        List<OmInstanceWithBLOBs> instances = this.omInstanceMapper.select(omInstanceCriteria);
        log.info("Select instance size: {}", instances.size());
        return instances;
    }

    /**
     * Select instances
     *
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getInstancesByStatus(Integer pubAppId, NormalStatus status) {
        OmInstanceCriteria omInstanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = omInstanceCriteria.createCriteria();
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        List<OmInstanceWithBLOBs> instances = this.omInstanceMapper.select(omInstanceCriteria);
        log.info("Select app instance size: {}", instances.size());
        return instances;
    }

    @Transactional
    public void buildDefaultCrossBidInstance(OmPlacement placement) {
        OmInstanceWithBLOBs instance = new OmInstanceWithBLOBs();
        instance.setName("cross_biding");
        instance.setPlacementId(placement.getId());
        instance.setAdnId(AdNetworkType.CrossPromotion.ordinal());

        List<OmInstanceWithBLOBs> instances = this.getInstances(placement.getPubAppId(),
                AdNetworkType.CrossPromotion.ordinal(), null, placement.getId());
        if (!CollectionUtils.isEmpty(instances)){
            log.info("Cross promotion instance existed for placement {}", placement.getId());
            return;
        }

        if(placement.getAdType() == 5){
            instance.setStatus((byte) NormalStatus.Active.ordinal());
            instance.setHbStatus((byte) NormalStatus.Pending.ordinal());
        } else {
            instance.setHbStatus((byte) NormalStatus.Pending.ordinal());
            instance.setStatus((byte) NormalStatus.Pending.ordinal());
        }

        instance.setPubAppId(placement.getPubAppId());
        instance.setAdnAppId(placement.getPubAppId());
        Response response = this.createInstance(instance);
        if (response.failed()){
            throw new RuntimeException("Build default cross bid instance " + JSONObject.toJSON(instance) + " failed!");
        }
    }

    /**
     * Build placement instance database object, and insert into database
     *
     * @param omInstance
     */
    @Transactional
    public Response createInstance(OmInstanceWithBLOBs omInstance) {
        OmPlacementWithBLOBs placement = this.omPlacementMapper.selectByPrimaryKey(omInstance.getPlacementId());
        if (placement == null) {
            log.error("Placement id {} do not existed!", omInstance.getPlacementId());
            return Response.RES_DATA_EXISTED;
        }
        if (this.isPlacementKeyDuplicated(omInstance, null)) {
            String error = "This Unit ID " + omInstance.getPlacementKey() + " has already existed or had been used in last 3 days!";
            log.warn(error + JSONObject.toJSON(omInstance));
            return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, error);
        }
        Date currentTime = new Date();
        omInstance.setCreateTime(currentTime);
        omInstance.setLastmodify(currentTime);
        if (omInstance.getStatus() == null) {
            omInstance.setStatus((byte) NormalStatus.Pending.ordinal());
        }
        int result = this.omInstanceMapper.insertSelective(omInstance);
        if (result <= 0) {
            throw new RuntimeException("Create instance " + JSONObject.toJSON(omInstance) + " success");
        }
        if (!CollectionUtils.isEmpty(omInstance.getInstanceCountries())){
            this.addInstanceCountry(omInstance);
        }
        return Response.buildSuccess(omInstance);
    }

    @Transactional
    protected void addInstanceCountry(OmInstanceWithBLOBs instance){
        for (OmInstanceCountry ic : instance.getInstanceCountries()){
            for (String country : ic.getCountry().split(",")){
                OmInstanceCountry instanceCountry = new OmInstanceCountry();
                instanceCountry.setInstanceId(instance.getId());
                instanceCountry.setAdnId(instance.getAdnId().byteValue());
                instanceCountry.setPlacementId(instance.getPlacementId());
                instanceCountry.setManualEcpm(ic.getManualEcpm());
                instanceCountry.setCountry(country);
                int result = this.omInstanceCountryMapper.insertSelective(instanceCountry);
                if (result <= 0){
                    throw new RuntimeException("Add instance country " + JSONObject.toJSONString(instanceCountry) + " failed!");
                }
            }
        }
    }

    @Transactional
    protected void updateInstanceCountries(OmInstanceWithBLOBs instance){
        OmInstanceCountryCriteria countryCriteria = new OmInstanceCountryCriteria();
        OmInstanceCountryCriteria.Criteria criteria = countryCriteria.createCriteria();
        criteria.andInstanceIdEqualTo(instance.getId());
        List<OmInstanceCountry> instanceCountries = omInstanceCountryMapper.select(countryCriteria);
        if (CollectionUtils.isEmpty(instanceCountries) && CollectionUtils.isEmpty(instance.getInstanceCountries())){
            return;
        }

        for (OmInstanceCountry instanceCountry : instanceCountries){
            int result = this.omInstanceCountryMapper.deleteByPrimaryKey(instanceCountry.getId());
            if (result <= 0){
                throw new RuntimeException("Delete InstanceCountry " + JSONObject.toJSONString(instanceCountry) + " error");
            }
        }

        if (!CollectionUtils.isEmpty(instance.getInstanceCountries())){
            this.addInstanceCountry(instance);
        }
    }

    /**
     * Update instance status
     *
     * @param instanceId
     * @param status
     */
    public Response updateInstanceStatus(Integer instanceId, NormalStatus status) {
        OmInstanceWithBLOBs instance = this.omInstanceMapper.selectByPrimaryKey(instanceId);
        if (instance == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        OmPlacementWithBLOBs placement = this.omPlacementMapper.selectByPrimaryKey(instance.getPlacementId());
        if (placement == null) {
            log.warn("Placement id {} do not existed!", instance.getPlacementId());
            return Response.RES_DATA_EXISTED;
        }
        if (NormalStatus.Active.equals(status)) {
            if (StringUtils.isBlank(instance.getPlacementKey()) && instance.getAdnId() != AdNetworkType.CrossPromotion.ordinal()) {
                log.warn("PlacementKey is null instance {}", JSONObject.toJSON(instance));
                return Response.failure(Response.CODE_DATA_INCOMPLETE, "Placement key must not null");
            }
            if (this.isPlacementKeyDuplicated(instance, null)) {
                log.warn("It already has active placement key {} instance {}", instance.getPlacementKey(), JSONObject.toJSON(instance));
                return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, "This Unit ID " + instance.getPlacementKey() + " has already existed or had been used in last 3 days!");
            }
        }
        instance.setStatus((byte) status.ordinal());
        instance.setLastmodify(new Date());
        int result = this.omInstanceMapper.updateByPrimaryKeySelective(instance);
        if (result <= 0) {
            throw new RuntimeException("Update instance " + instanceId + " status " + status + " failed!");
        }
        return Response.build();
    }

    /**
     * Update instance database object
     *
     * @param omInstance
     */
    @Transactional
    public Response updateInstance(OmInstanceWithBLOBs omInstance) {
        OmInstanceWithBLOBs instance = omInstanceMapper.selectByPrimaryKey(omInstance.getId());
        if (instance == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        if (!instance.getHbStatus().equals(omInstance.getHbStatus())) {
            return Response.RES_CAN_NOT_CHANGE;
        }
        OmPlacementWithBLOBs placement = this.omPlacementMapper.selectByPrimaryKey(instance.getPlacementId());
        if (placement == null) {
            log.warn("Placement id {} do not existed!", instance.getPlacementId());
            return Response.RES_DATA_EXISTED;
        }

        if (this.isPlacementKeyDuplicated(omInstance, instance)) {
            String error = "This Unit ID " + omInstance.getPlacementKey() + " has already existed or had been used in last 3 days!";
            log.warn(error + JSONObject.toJSON(omInstance));
            return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE, error);
        }

        int result = this.omInstanceMapper.updateByPrimaryKeySelective(omInstance);
        if (result <= 0) {
            throw new RuntimeException("Update instance " + omInstance.getId() + " failed!");
        }
        this.updateInstanceCountries(omInstance);
        this.instancePlacementKeyChange(instance, omInstance);
        return Response.build();
    }

    @Transactional
    protected void instancePlacementKeyChange(OmInstance oldInstance, OmInstance newInstance) {
        if (StringUtils.isNotBlank(oldInstance.getPlacementKey()) && StringUtils.isNotBlank(newInstance.getPlacementKey())
                && !oldInstance.getPlacementKey().equals(newInstance.getPlacementKey())) {
            OmAdnetworkApp adnApp = omAdnetworkAppMapper.selectByPrimaryKey(oldInstance.getAdnAppId());
            if (adnApp != null && StringUtils.isNotBlank(adnApp.getAdnAppKey())) {
                OmInstanceChangeCriteria omInstanceChangeCriteria = new OmInstanceChangeCriteria();
                OmInstanceChangeCriteria.Criteria criteria = omInstanceChangeCriteria.createCriteria();
                criteria.andPlacementKeyIn(
                        Arrays.asList(oldInstance.getPlacementKey(), newInstance.getPlacementKey()));
                criteria.andIdEqualTo(oldInstance.getId());
                criteria.andPubAppIdEqualTo(oldInstance.getPubAppId());
                List<OmInstanceChange> oldPlacementKeys = omInstanceChangeMapper.select(omInstanceChangeCriteria);
                //
                if (!oldPlacementKeys.isEmpty()) {
                    for (OmInstanceChange omInstanceChange : oldPlacementKeys) {
                        OmInstanceChangeKey placementKey = new OmInstanceChangeKey();
                        placementKey.setId(omInstanceChange.getId());
                        placementKey.setPlacementKey(omInstanceChange.getPlacementKey());
                        int result = omInstanceChangeMapper.deleteByPrimaryKey(placementKey);
                        if (result <= 0) {
                            throw new RuntimeException("Delete instance change " + JSONObject.toJSON(omInstanceChange) + " failed!");
                        }
                    }
                }
                OmInstanceChange omInstanceChange = new OmInstanceChange();
                omInstanceChange.setId(oldInstance.getId());
                omInstanceChange.setPlacementKey(oldInstance.getPlacementKey());
                omInstanceChange.setInstanceName(oldInstance.getName());
                omInstanceChange.setAdnAppId(oldInstance.getAdnAppId());
                omInstanceChange.setPubAppId(oldInstance.getPubAppId());
                omInstanceChange.setPlacementId(oldInstance.getPlacementId());
                omInstanceChange.setAdnId(Util.intToByte(oldInstance.getAdnId()));
                omInstanceChange.setAppKey(adnApp.getAdnAppKey());
                omInstanceChange.setAccountId(adnApp.getAccountId());
                omInstanceChange.setAccountOwner(adnApp.getAccountOwner());
                omInstanceChange.setAbTestMode(oldInstance.getAbTestMode());
                omInstanceChange.setStatus(oldInstance.getStatus());
                //insert into om_instance_change
                int result = omInstanceChangeMapper.insertSelective(omInstanceChange);
                if (result <= 0) {
                    throw new RuntimeException("Insert instance change " + JSONObject.toJSON(omInstanceChange) + " failed!");
                }
            }
        }
    }

    /**
     * Select all Instance
     *
     * @return instances
     */
    public List<OmInstanceCountry> getInstanceCountries(Integer instanceId) {
        OmInstanceCountryCriteria omInstanceCountryCriteria = new OmInstanceCountryCriteria();
        OmInstanceCountryCriteria.Criteria criteria = omInstanceCountryCriteria.createCriteria();
        criteria.andInstanceIdEqualTo(instanceId);
        List<OmInstanceCountry> instanceCountries = omInstanceCountryMapper.select(omInstanceCountryCriteria);
        log.info("Get instance countries size: {}", instanceCountries.size());
        return instanceCountries;
    }

    /**
     * Build placement instance country database object, and insert into database
     *
     * @param omInstanceCountry
     */
    public Response createInstanceCountry(OmInstanceCountry omInstanceCountry) {
        try {
            Date currentTime = new Date();
            omInstanceCountry.setCreateTime(currentTime);
            omInstanceCountry.setLastmodify(currentTime);
            int result = this.omInstanceCountryMapper.insertSelective(omInstanceCountry);
            if (result > 0) {
                log.info("Create instance country {} success", omInstanceCountry.getCountry());
                return Response.buildSuccess(omInstanceCountry);
            }
        } catch (Exception e) {
            log.error("Create instance country {} error", JSONObject.toJSONString(omInstanceCountry), e);
        }
        log.error("Create instance country {} failed", JSONObject.toJSONString(omInstanceCountry));
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create instance country failed!");
    }

    /**
     * Update instance country database object
     *
     * @param omInstanceCountry
     */
    public Response updateInstanceCountry(OmInstanceCountry omInstanceCountry) {
        try {
            omInstanceCountry.setLastmodify(new Date());
            int result = this.omInstanceCountryMapper.updateByPrimaryKeySelective(omInstanceCountry);
            if (result > 0) {
                log.info("Update instance country {} success", omInstanceCountry.getCountry());
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Update instance country error {}", JSONObject.toJSONString(omInstanceCountry), e);
        }
        log.error("Update instance country {} failed", omInstanceCountry.getCountry());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update instance country failed!");
    }

    /**
     * Select instances
     *
     * @param adNetworkId
     * @param placementId
     * @param status
     * @return instances
     */
    public List<OmInstanceWithBLOBs> getAdnPlacementInstances(Integer adNetworkId, Integer placementId, SwitchStatus status) {
        OmInstanceCriteria omInstanceCriteria = new OmInstanceCriteria();
        OmInstanceCriteria.Criteria criteria = omInstanceCriteria.createCriteria();

        if (adNetworkId != null) {
            criteria.andAdnIdEqualTo(adNetworkId);
        }
        if (placementId != null) {
            criteria.andPlacementIdEqualTo(placementId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        omInstanceCriteria.setOrderByClause(" create_time desc ");
        List<OmInstanceWithBLOBs> instances = this.omInstanceMapper.select(omInstanceCriteria);
        log.info("Select instance by publisher id size: {}", instances.size());
        return instances;
    }
}
