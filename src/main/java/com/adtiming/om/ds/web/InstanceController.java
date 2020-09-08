// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmAdnetwork;
import com.adtiming.om.ds.model.OmInstanceCountry;
import com.adtiming.om.ds.model.OmInstanceWithBLOBs;
import com.adtiming.om.ds.model.OmPlacementRuleInstance;
import com.adtiming.om.ds.service.AdNetworkService;
import com.adtiming.om.ds.service.InstanceService;
import com.adtiming.om.ds.service.MediationService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Instance manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class InstanceController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    protected InstanceService instanceService;

    @Autowired
    protected MediationService mediationService;

    @Autowired
    protected AdNetworkService adNetworkService;

    /**
     * Get all placement instances
     */
    @RequestMapping(value = "/instance/list", method = RequestMethod.GET)
    public Response getInstances(Integer adNetworkId, Integer pubAppId, Integer placementId, Integer instanceId) {
        try {
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstances(pubAppId, adNetworkId, instanceId, placementId);
            Map<Integer, OmAdnetwork> adNetworkMap = adNetworkService.getAdNetworkMap();
            JSONArray results = new JSONArray();
            instances.forEach(instance -> {
                JSONObject result = (JSONObject) JSONObject.toJSON(instance);
                OmAdnetwork adNetwork = adNetworkMap.get(instance.getAdnId());
                if (adNetwork != null) {
                    result.put("className", adNetworkMap.get(instance.getAdnId()).getClassName());
                } else {
                    result.put("className", "");
                }
                results.add(result);
            });
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("get placement instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get select placement instances
     */
    @RequestMapping(value = "/instance/select/list", method = RequestMethod.GET)
    public Response getSelectInstance(String[] adNetworkIds, Integer pubAppId, Integer placementId, Integer instanceId, Byte headBid, Integer adNetworkAppId) {
        try {
            List<Integer> adnIds = null;
            if (adNetworkIds != null && adNetworkIds.length > 0) {
                adnIds = new ArrayList<>();
                for (String adnId : adNetworkIds) {
                    adnIds.add(Integer.parseInt(adnId));
                }
            }
            NormalStatus instanceStatus = null;
            if (headBid != null) {
                instanceStatus = NormalStatus.Active;
            }
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstances(pubAppId, adnIds, instanceId, placementId, instanceStatus, headBid, adNetworkAppId);
            JSONArray selects = new JSONArray();
            for (OmInstanceWithBLOBs instance : instances) {
                JSONObject select = new JSONObject();
                select.put("id", instance.getId());
                select.put("name", instance.getName());
                select.put("placementId", instance.getPlacementId());
                select.put("placementKey", instance.getPlacementKey());
                selects.add(select);
            }
            return Response.buildSuccess(selects);
        } catch (Exception e) {
            log.error("get placement instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all placement instance
     *
     * @param adnId
     * @param pubAppId
     * @param placementKey
     */
    @RequestMapping(value = "/instance/get", method = RequestMethod.GET)
    public Response getInstances(Integer adnId, Integer pubAppId, String placementKey) {
        try {
            if (pubAppId != null && StringUtils.isBlank(placementKey)) {
                log.info("Get instances parameter app id or placement key is null");
                return Response.RES_PARAMETER_ERROR;
            }
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstance(adnId, pubAppId, placementKey);
            return Response.buildSuccess(instances);
        } catch (Exception e) {
            log.error("get placement instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement instance, related to current user
     *
     * @see OmInstanceWithBLOBs
     */
    @RequestMapping(value = "/instance/create", method = RequestMethod.POST)
    public Response createInstance(@RequestBody OmInstanceWithBLOBs omInstanceWithBLOBs) {
        try {
            if (omInstanceWithBLOBs.getPubAppId() == null || omInstanceWithBLOBs.getName() == null || omInstanceWithBLOBs.getAdnAppId() == null) {
                log.error("Publisher id {} name {}", omInstanceWithBLOBs.getPubAppId(), omInstanceWithBLOBs.getName());
                return Response.RES_PARAMETER_ERROR;
            }
            return this.instanceService.createInstance(omInstanceWithBLOBs);
        } catch (Exception e) {
            log.error("Create instance {} error", JSONObject.toJSONString(omInstanceWithBLOBs), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create instance failed!");
    }

    /**
     * Update placement instance status
     *
     * @param instanceId
     * @param status
     */
    @RequestMapping(value = "/instance/update/status", method = RequestMethod.GET)
    public Response updateInstance(Integer instanceId, Byte status) {
        try {
            if (instanceId == null || status == null || status > NormalStatus.Active.ordinal()) {
                log.error("Update instance {} status parameter, status {}", instanceId, status);
                return Response.RES_PARAMETER_ERROR;
            }
            NormalStatus instanceStatus = NormalStatus.getStatus(status.intValue());
            Response response = this.instanceService.updateInstanceStatus(instanceId, instanceStatus);
            if (!NormalStatus.Active.equals(instanceStatus)) {
                List<OmPlacementRuleInstance> placementRuleInstances = this.mediationService.getPlacementRuleInstancesByInstance(instanceId);
                for (OmPlacementRuleInstance placementRuleInstance : placementRuleInstances) {
                    this.mediationService.deletePlacementRuleInstance(placementRuleInstance.getRuleId(), placementRuleInstance.getInstanceId());
                }
            }
            return response;
        } catch (Exception e) {
            log.error("Update instance {} instance error:", instanceId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Update placement instance information
     *
     * @see OmInstanceWithBLOBs
     */
    @RequestMapping(value = "/instance/update", method = RequestMethod.POST)
    public Response updateInstance(@RequestBody OmInstanceWithBLOBs omInstanceWithBLOBs) {
        try {
            if (omInstanceWithBLOBs.getId() == null || omInstanceWithBLOBs.getId() <= 0) {
                log.error("It must have valid id");
                return Response.RES_PARAMETER_ERROR;
            }
            return this.instanceService.updateInstance(omInstanceWithBLOBs);
        } catch (Exception e) {
            log.error("Update instance error {}", JSONObject.toJSONString(omInstanceWithBLOBs), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update instance failed!");
    }

    /**
     * Get all placement instance counties by placement id
     */
    @RequestMapping(value = "/instance/country/list", method = RequestMethod.GET)
    public Response getInstanceCountries(Integer instanceId) {
        try {
            List<OmInstanceCountry> instanceCountries = this.instanceService.getInstanceCountries(instanceId);
            return Response.buildSuccess(instanceCountries);
        } catch (Exception e) {
            log.error("get placement instance country error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement instance country
     *
     * @see OmInstanceCountry
     */
    @RequestMapping(value = "/instance/country/create", method = RequestMethod.POST)
    public Response createInstanceCountry(@RequestBody OmInstanceCountry omInstanceCountry) {
        if (omInstanceCountry.getCountry() == null || omInstanceCountry.getInstanceId() == null || omInstanceCountry.getAdnId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.instanceService.createInstanceCountry(omInstanceCountry);
    }

    /**
     * Update placement instance country information
     *
     * @see OmInstanceCountry
     */
    @RequestMapping(value = "/instance/country/update", method = RequestMethod.POST)
    public Response updateInstanceCountry(@RequestBody OmInstanceCountry omInstanceCountry) {
        if (omInstanceCountry.getId() == null || omInstanceCountry.getId() <= 0) {
            log.error("It must have valid id");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.instanceService.updateInstanceCountry(omInstanceCountry);
    }
}
