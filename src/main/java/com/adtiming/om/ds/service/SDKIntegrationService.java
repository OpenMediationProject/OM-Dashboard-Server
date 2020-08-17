// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmDevAppMapper;
import com.adtiming.om.ds.dao.OmDevDeviceMapper;
import com.adtiming.om.ds.dto.DevAppTestResult;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * SDK integration service
 *
 * @author dianbo ruan
 */
@Service
public class SDKIntegrationService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private AdNetworkService adNetworkService;

    @Autowired
    private PlacementService placementService;

    @Resource
    private OmDevDeviceMapper omDevDeviceMapper;

    @Resource
    private OmDevAppMapper omDevAppMapper;

    public Response getDevApp(Integer pubAppId) {
        List<OmDevApp> devApps = this.getDevApps(null, pubAppId, SwitchStatus.ON, DevAppTestResult.UnKnow);
        if (!CollectionUtils.isEmpty(devApps)) {
            return Response.buildSuccess(devApps.get(0));
        }
        return Response.buildSuccess(null);
    }

    /**
     * Get test adnetwoks
     *
     * @param pubAppId
     */
    public Response getAdNetWorks(Integer pubAppId) {
        try {
            JSONArray results = new JSONArray();
            Map<Integer, OmDevApp> devAppMap = this.getDevAppMap(pubAppId, null);
            Set<Integer> adNetworkIds = this.instanceService.getAdnIdsWithInstance(pubAppId);
            if (CollectionUtils.isEmpty(adNetworkIds)) {
                return Response.build(Response.CODE_RES_FAILED, Response.STATUS_DISABLE, "No active instances to be test");
            }
            List<OmAdnetwork> adNetworks = this.adNetworkService.getAllAdNetworks();
            for (OmAdnetwork omAdnetwork : adNetworks) {
                Integer adNetworkId = omAdnetwork.getId();
                if (!adNetworkIds.contains(adNetworkId)) {
                    continue;
                }
                JSONObject result = new JSONObject();
                result.put("adnId", omAdnetwork.getId());
                result.put("className", omAdnetwork.getClassName());
                OmDevApp devApp = devAppMap.get(adNetworkId);
                if (devApp != null && devApp.getAdnId().equals(adNetworkId)) {
                    result.put("lastTesting", Util.getDateString(devApp.getActiveTime()));
                    result.put("devResult", DevAppTestResult.getDevAppTestResult(devApp.getDevResult().intValue()).name());
                    result.put("operation", "UnSelect");
                    result.put("dveAppId", devApp.getId());
                    result.put("status", devApp.getStatus());
                } else {
                    result.put("lastTesting", "");
                    result.put("devResult", DevAppTestResult.UnKnow.name());
                    result.put("operation", "Select");
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get adnetwoks with valid instance error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get placements by adnId and pubAppId
     *
     * @param adnId
     * @param pubAppId
     */
    public Response getAdNetworkPlacements(Integer adnId, Integer pubAppId) {
        try {
            JSONArray results = new JSONArray();
            Set<Integer> placementIdSet = this.instanceService.getPlacementIds(adnId, pubAppId);
            List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(pubAppId, NormalStatus.Active);
            Map<Integer, OmDevApp> devAppMap = this.getDevAppMap(pubAppId, SwitchStatus.ON);
            for (OmPlacementWithBLOBs placement : placements) {
                if (placementIdSet.contains(placement.getId())) {
                    continue;
                }
                List<OmInstanceWithBLOBs> instances = this.instanceService.getAdnPlacementInstances(
                        adnId, placement.getId(), SwitchStatus.ON);
                if (CollectionUtils.isEmpty(instances)) {
                    continue;
                }
                JSONObject result = new JSONObject();
                result.put("placementId", placement.getId());
                result.put("placementName", placement.getName());
                result.put("adType", placement.getAdType());
                OmDevApp devApp = devAppMap.get(adnId);
                if (devApp != null) {
                    result.put("devAppId", devApp.getId());
                    result.put("status", devApp.getStatus());
                    result.put("lastTesting", Util.getDateString(devApp.getActiveTime()));
                    result.put("devResult", DevAppTestResult.getDevAppTestResult(devApp.getDevResult().intValue()).name());
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get ad network {} placements error:", adnId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Update develop app's test result
     *
     * @param devAppId
     * @param
     */
    public Response updateDevResult(Integer devAppId, DevAppTestResult devAppTestResult) {
        try {
            OmDevApp devApp = this.omDevAppMapper.selectByPrimaryKey(devAppId);
            if (devApp == null) {
                throw new RuntimeException("Develop app " + devAppId + " does not existed");
            }
            devApp.setDevResult((byte) devAppTestResult.ordinal());
            devApp.setLastmodify(new Date());
            devApp.setActiveTime(new Date());
            devApp.setStatus((byte) SwitchStatus.OFF.ordinal());
            int result = this.omDevAppMapper.updateByPrimaryKeySelective(devApp);
            if (result > 0) {
                log.info("Update develop app's test result {} successfully", JSONObject.toJSONString(devApp));
                return Response.buildSuccess(devApp);
            } else {
                throw new Exception("Update develop app's test result failed " + JSONObject.toJSONString(devApp));
            }
        } catch (Exception e) {
            log.error("Update develop app {}'s test result {} error:", devAppId, devAppTestResult, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create develop app when not existed or update
     *
     * @param omDevApp
     */
    public Response createDevApp(OmDevApp omDevApp) {
        try {
            List<OmDevApp> devApps = this.getDevApps(omDevApp.getAdnId(), omDevApp.getPubAppId(), null);
            if (CollectionUtils.isEmpty(devApps)) {
                omDevApp.setCreateTime(new Date());
                omDevApp.setLastmodify(new Date());
                omDevApp.setActiveTime(new Date());
                omDevApp.setStatus((byte) SwitchStatus.ON.ordinal());
                omDevApp.setDevResult((byte) DevAppTestResult.UnKnow.ordinal());
                if (omDevApp.getPublisherId() == null || omDevApp.getPublisherId() <= 0) {
                    omDevApp.setPublisherId(this.getCurrentUser().getPublisherId());
                }
                int result = this.omDevAppMapper.insertSelective(omDevApp);
                if (result > 0) {
                    log.info("Create develop app {} successfully", JSONObject.toJSONString(omDevApp));
                    return Response.buildSuccess(omDevApp);
                } else {
                    throw new Exception("Create develop app failed " + JSONObject.toJSONString(omDevApp));
                }
            } else {
                OmDevApp devApp = devApps.get(0);
                devApp.setAdnId(omDevApp.getAdnId());
                devApp.setLastmodify(new Date());
                devApp.setActiveTime(new Date());
                devApp.setDevResult((byte) DevAppTestResult.UnKnow.ordinal());
                if (omDevApp.getAdnId() != null) {
                    devApp.setAdnId(omDevApp.getAdnId());
                }
                if (omDevApp.getPubAppId() != null) {
                    devApp.setPubAppId(omDevApp.getPubAppId());
                }
                devApp.setStatus((byte) SwitchStatus.ON.ordinal());
                if (devApp.getPublisherId() == null || devApp.getPublisherId() <= 0) {
                    devApp.setPublisherId(this.getCurrentUser().getPublisherId());
                }
                int result = this.omDevAppMapper.updateByPrimaryKeySelective(devApp);
                if (result > 0) {
                    log.info("Update develop app {} successfully", JSONObject.toJSONString(omDevApp));
                    return Response.buildSuccess(devApp);
                } else {
                    throw new Exception("Update develop app failed " + JSONObject.toJSONString(omDevApp));
                }
            }
        } catch (Exception e) {
            log.error("Create develop app error {}", JSONObject.toJSONString(omDevApp), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get develop app list
     *
     * @param pubAppId
     */
    private Map<Integer, OmDevApp> getDevAppMap(Integer pubAppId, SwitchStatus devAppStatus) {
        List<OmDevApp> omDevApps = this.getDevApps(null, pubAppId, devAppStatus);
        Map<Integer, OmDevApp> devAppMap = new HashMap<>();
        omDevApps.forEach(omDevApp -> {
            devAppMap.put(omDevApp.getAdnId(), omDevApp);
        });
        return devAppMap;
    }

    /**
     * Get develop app list
     *
     * @param pubAppId
     */
    private List<OmDevApp> getDevApps(Integer adnId, Integer pubAppId, SwitchStatus devAppStatus) {
        return this.getDevApps(adnId, pubAppId, devAppStatus, null);
    }

    /**
     * Get develop app list
     *
     * @param pubAppId
     */
    private List<OmDevApp> getDevApps(Integer adnId, Integer pubAppId, SwitchStatus devAppStatus, DevAppTestResult result) {
        OmDevAppCriteria devAppCriteria = new OmDevAppCriteria();
        OmDevAppCriteria.Criteria criteria = devAppCriteria.createCriteria();
        criteria.andPubAppIdEqualTo(pubAppId);
        if (devAppStatus != null) {
            criteria.andStatusEqualTo((byte) devAppStatus.ordinal());
        }
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        if (result != null) {
            criteria.andDevResultEqualTo((byte) result.ordinal());
        }
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        devAppCriteria.setOrderByClause(" lastmodify desc ");
        List<OmDevApp> devApps = omDevAppMapper.select(devAppCriteria);

        if (!CollectionUtils.isEmpty(devApps)) {
            Map<Integer, OmAdnetwork> adNetworkMap = adNetworkService.getAdNetworkMap();
            for (OmDevApp sdkDevApp : devApps) {
                OmAdnetwork adNetwork = adNetworkMap.get(sdkDevApp.getAdnId());
                if (adNetwork != null) {
                    sdkDevApp.setClassName(adNetworkMap.get(sdkDevApp.getAdnId()).getClassName());
                }
            }
        }
        return devApps;
    }

    /**
     * Get device list
     *
     * @param publisherId
     * @param status
     */
    public List<OmDevDevice> getDevDevices(Integer publisherId, Byte status) {
        OmDevDeviceCriteria devDeviceCriteria = new OmDevDeviceCriteria();
        OmDevDeviceCriteria.Criteria criteria = devDeviceCriteria.createCriteria();
        if (publisherId != null) {
            criteria.andPublisherIdEqualTo(publisherId);
        }
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        return omDevDeviceMapper.select(devDeviceCriteria);
    }

    public Response createDevDevice(OmDevDevice devDevice) {
        try {
            devDevice.setCreateTime(new Date());
            devDevice.setLastmodify(new Date());
            if (devDevice.getPublisherId() == null) {
                devDevice.setPublisherId(this.getCurrentUser().getPublisherId());
            }
            int result = this.omDevDeviceMapper.insertSelective(devDevice);
            if (result > 0) {
                log.info("Create device {} successfully", JSONObject.toJSONString(devDevice));
                return Response.buildSuccess(devDevice);
            } else {
                throw new Exception("Create device failed " + JSONObject.toJSONString(devDevice));
            }
        } catch (Exception e) {
            log.error("Create device error {}", JSONObject.toJSONString(devDevice), e);
        }
        return Response.RES_FAILED;
    }

    public Response updateDevDevice(OmDevDevice devDevice) {
        try {
            devDevice.setLastmodify(new Date());
            int result = this.omDevDeviceMapper.updateByPrimaryKeySelective(devDevice);
            if (result > 0) {
                log.info("Update device {} successfully", JSONObject.toJSONString(devDevice));
                return Response.buildSuccess(devDevice);
            } else {
                throw new Exception("Update device failed " + JSONObject.toJSONString(devDevice));
            }
        } catch (Exception e) {
            log.error("Update device error {}", JSONObject.toJSONString(devDevice), e);
        }
        return Response.RES_FAILED;
    }

    public Response deleteDevDevice(Integer id) {
        try {
            int result = this.omDevDeviceMapper.deleteByPrimaryKey(id);
            if (result > 0) {
                log.info("Delete device {} successfully", id);
                return Response.build();
            } else {
                throw new Exception("Delete device failed " + id);
            }
        } catch (Exception e) {
            log.error("Delete device error {}", id, e);
        }
        return Response.RES_FAILED;
    }
}
