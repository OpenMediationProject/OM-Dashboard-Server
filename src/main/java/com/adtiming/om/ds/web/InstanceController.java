// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmInstanceCountry;
import com.adtiming.om.ds.model.OmInstanceWithBLOBs;
import com.adtiming.om.ds.service.InstanceService;
import com.adtiming.om.ds.service.MediationService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Instance manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class InstanceController extends BaseController {

    @Autowired
    private InstanceService instanceService;

    @Autowired
    private MediationService mediationService;

    /**
     * Get all placement instances
     */
    @RequestMapping(value = "/instance/list", method = RequestMethod.GET)
    public Response getInstances(Integer adNetworkId, Integer pubAppId, Integer placementId, Integer instanceId) {
        try {
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstances(pubAppId, adNetworkId, instanceId, placementId);
            return Response.buildSuccess(instances);
        } catch (Exception e) {
            log.error("get placement instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get select placement instances
     */
    @RequestMapping(value = "/instance/select/list", method = RequestMethod.GET)
    public Response getSelectInstance(Integer adNetworkId, Integer pubAppId, Integer placementId, Integer instanceId, Byte headBid, Integer adNetworkAppId) {
        try {
            NormalStatus instanceStatus = null;
            if (headBid != null) {
                instanceStatus = NormalStatus.ACTIVE;
            }
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstances(pubAppId, adNetworkId, instanceId, placementId, instanceStatus, headBid, adNetworkAppId);
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
     * @param placementKey
     */
    @RequestMapping(value = "/instance/get", method = RequestMethod.GET)
    public Response getInstances(String placementKey) {
        try {
            if (StringUtils.isBlank(placementKey)) {
                log.info("Get instances parameter placement key is null");
                return Response.RES_PARAMETER_ERROR;
            }
            List<OmInstanceWithBLOBs> instances = this.instanceService.getInstance(placementKey);
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
        if (omInstanceWithBLOBs.getPubAppId() == null || omInstanceWithBLOBs.getName() == null || omInstanceWithBLOBs.getAdnAppId() == null) {
            log.error("Publisher id {} name {}", omInstanceWithBLOBs.getPubAppId(), omInstanceWithBLOBs.getName());
            return Response.RES_PARAMETER_ERROR;
        }
        return this.instanceService.createInstance(omInstanceWithBLOBs);
    }

    /**
     * Update placement instance status
     *
     * @param instanceId
     * @param status
     */
    @RequestMapping(value = "/instance/update/status", method = RequestMethod.GET)
    public Response updateInstance(Integer instanceId, Byte status) {
        if (instanceId == null || status == null || status > NormalStatus.ACTIVE.ordinal()) {
            log.error("Update instance {} status parameter, status {}", instanceId, status);
            return Response.RES_PARAMETER_ERROR;
        }
        NormalStatus instanceStatus = NormalStatus.getStatus(status);
        Response response = this.instanceService.updateInstanceStatus(instanceId, instanceStatus);
        if (!NormalStatus.ACTIVE.equals(instanceStatus)) {
            this.mediationService.deleteRuleInstances(instanceId);
        }
        return response;
    }

    /**
     * Update placement instance information
     *
     * @see OmInstanceWithBLOBs
     */
    @RequestMapping(value = "/instance/update", method = RequestMethod.POST)
    public Response updateInstance(@RequestBody OmInstanceWithBLOBs omInstanceWithBLOBs) {
        if (omInstanceWithBLOBs.getId() == null || omInstanceWithBLOBs.getId() <= 0) {
            log.error("It must have valid id");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.instanceService.updateInstance(omInstanceWithBLOBs);
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
