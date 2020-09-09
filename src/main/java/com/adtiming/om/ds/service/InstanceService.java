// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
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
    private OmInstanceMapper omInstanceMapper;

    @Resource
    private OmInstanceCountryMapper omInstanceCountryMapper;

    @Resource
    private OmInstanceChangeMapper omInstanceChangeMapper;

    @Resource
    private OmAdnetworkAppMapper omAdnetworkAppMapper;

    @Resource
    private OmPlacementMapper omPlacementMapper;

    /**
     * Select instances
     *
     * @param instanceId
     * @return instances
     */
    public OmInstanceWithBLOBs getInstance(Integer instanceId) {
        return this.omInstanceMapper.selectByPrimaryKey(instanceId);
    }

    private boolean isPlacementKeyDuplicated(Integer adnId, Integer pubAppId, String placementKey, Integer instanceId) {
        List<OmInstanceWithBLOBs> instances = this.getInstance(adnId, pubAppId, placementKey);
        if (instanceId != null) {
            instances.removeIf(instance -> instance.getId().equals(instanceId));
        }
        return !CollectionUtils.isEmpty(instances);
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
        instances.forEach(instance -> {
            placementIdSet.add(instance.getPlacementId());
        });
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
        if (adNetworkId != null){
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

    /**
     * Build placement instance database object, and insert into database
     *
     * @param omInstance
     */
    public Response createInstance(OmInstanceWithBLOBs omInstance) {
        OmPlacementWithBLOBs placement = this.omPlacementMapper.selectByPrimaryKey(omInstance.getPlacementId());
        if (placement == null) {
            log.error("Placement id {} do not existed!", omInstance.getPlacementId());
            return Response.RES_DATA_EXISTED;
        }
        if (isPlacementKeyDuplicated(omInstance.getAdnId(), placement.getPubAppId(), omInstance.getPlacementKey(), null)) {
            log.error("It already has active PlacementKey {} instance {}", omInstance.getPlacementKey(), JSONObject.toJSON(omInstance));
            return Response.RES_DATA_EXISTED;
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
        return Response.buildSuccess(omInstance);
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
            boolean isPlacementKeyDuplicated = isPlacementKeyDuplicated(instance.getAdnId(), placement.getPubAppId(),
                    instance.getPlacementKey(), instance.getId());
            if (isPlacementKeyDuplicated) {
                log.warn("It already has active placement key {} instance {}", instance.getPlacementKey(), JSONObject.toJSON(instance));
                return Response.failure(Response.CODE_RES_DATA_EXISTED, "Placement key" + instance.getPlacementKey() + " already existed");
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
        if (!instance.getHbStatus().equals(omInstance.getHbStatus())){
            return Response.RES_CAN_NOT_CHANGE;
        }
        OmPlacementWithBLOBs placement = this.omPlacementMapper.selectByPrimaryKey(instance.getPlacementId());
        if (placement == null) {
            log.warn("Placement id {} do not existed!", instance.getPlacementId());
            return Response.RES_DATA_EXISTED;
        }

        boolean isPlacementKeyDuplicated = isPlacementKeyDuplicated(instance.getAdnId(), placement.getPubAppId(),
                instance.getPlacementKey(), instance.getId());
        if (isPlacementKeyDuplicated) {
            log.error("It already has active PlacementKey {} instance {}", instance.getPlacementKey(), JSONObject.toJSON(instance));
            return Response.RES_DATA_EXISTED;
        }
        int result = this.omInstanceMapper.updateByPrimaryKeySelective(omInstance);
        if (result <= 0) {
            throw new RuntimeException("Update instance " + omInstance.getId() + " failed!");
        }
        instancePlacementKeyChange(instance, omInstance);
        return Response.build();
    }

    @Transactional
    private void instancePlacementKeyChange(OmInstance oldInstance, OmInstance newInstance) {
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
                List<OmInstanceChange> oldPlacementKeys = omInstanceChangeMapper.selectByExample(omInstanceChangeCriteria);
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
