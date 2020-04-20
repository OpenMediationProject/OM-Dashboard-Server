// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.AdNetworkAppStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.AdNetworkService;
import com.adtiming.om.ds.service.InstanceService;
import com.adtiming.om.ds.service.PlacementService;
import com.adtiming.om.ds.service.PublisherAppService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AdNetwork manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class AdNetworkController extends BaseController {

    @Autowired
    protected AdNetworkService adNetworkService;

    @Autowired
    protected PlacementService placementService;

    @Autowired
    protected InstanceService instanceService;

    @Autowired
    protected PublisherAppService publisherAppService;

    /**
     * Get all AdNetworks of publisher app
     */
    @RequestMapping(value = "/adnetwork/select/list", method = RequestMethod.GET)
    public Response getAdNetWorkSelectList(Integer pubAppId) {
        try {
            List<OmAdnetwork> adNetworks = this.adNetworkService.getAllAdNetworks();
            Map<Integer, OmAdnetworkApp> adNetworkAppMap = new HashMap<>();
            Map<Integer, OmPublisherApp> publisherAppMap = new HashMap<>();
            if (pubAppId != null) {
                adNetworkAppMap = this.adNetworkService.getAdNetworkIdAppMap(pubAppId);
                List<Integer> publisherAppIds = adNetworkAppMap.values().stream().map(OmAdnetworkApp::getPubAppId).collect(Collectors.toList());
                publisherAppMap = publisherAppService.getPublisherAppMap(publisherAppIds);
            }
            JSONArray results = new JSONArray();
            for (OmAdnetwork omAdnetwork : adNetworks) {
                JSONObject result = new JSONObject();
                result.put("name", omAdnetwork.getName());
                result.put("className", omAdnetwork.getClassName());
                result.put("id", omAdnetwork.getId());
                OmAdnetworkApp adNetworkApp = adNetworkAppMap.get(omAdnetwork.getId());
                if (adNetworkApp != null) {
                    result.put("adNetworkAppId", adNetworkApp.getId());
                    OmPublisherApp publisherApp = publisherAppMap.get(adNetworkApp.getPubAppId());
                    if (publisherApp != null && !this.adNetworkService.doesPlatMatch(publisherApp, omAdnetwork)){
                        continue;
                    }
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("get adNetworks error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all AdNetworks of publisher app
     */
    @RequestMapping(value = "/app/adnetwork/list", method = RequestMethod.GET)
    public Response getAdNetWorks(Integer pubAppId) {
        try {
            JSONArray adNetworks = this.adNetworkService.getAdNetworks(pubAppId);
            return Response.buildSuccess(adNetworks);
        } catch (Exception e) {
            log.error("get adNetworks error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get publisher app's placements with their instances
     */
    @RequestMapping(value = "/adnetwork/placement/instances", method = RequestMethod.GET)
    public Response getAdNetWorkPlacementInstances(Integer adNetworkId, Integer pubAppId, Integer placementId, Integer instanceId) {
        try {
            if (pubAppId == null) {
                log.error("publisher app id {}", pubAppId);
                return Response.RES_PARAMETER_ERROR;
            }
            List<OmPlacementWithBLOBs> placements = placementService.getPlacements(pubAppId, placementId);
            List<OmInstanceWithBLOBs> publisherInstances = instanceService.getInstances(pubAppId, adNetworkId, instanceId, placementId);
            Map<Integer, List<OmInstanceWithBLOBs>> publisherInstanceMap = publisherInstances.stream()
                    .collect(Collectors.groupingBy(OmInstance::getPlacementId, Collectors.toList()));
            Map<Integer, OmAdnetwork> adNetworkMap = adNetworkService.getAdNetworkMap();
            JSONArray resultPlacements = new JSONArray();
            for (OmPlacementWithBLOBs placementWithBLOBs : placements) {
                JSONObject resultPlacement = (JSONObject) JSONObject.toJSON(placementWithBLOBs);
                List<OmInstanceWithBLOBs> placementInstances = publisherInstanceMap.get(placementWithBLOBs.getId());
                if (!CollectionUtils.isEmpty(placementInstances)) {
                    JSONArray resultInstances = new JSONArray();
                    for (OmInstanceWithBLOBs instanceWithBLOBs : placementInstances) {
                        JSONObject resultInstance = (JSONObject) JSONObject.toJSON(instanceWithBLOBs);
                        OmAdnetwork adNetwork = adNetworkMap.get(instanceWithBLOBs.getAdnId());
                        if (adNetwork != null) {
                            resultInstance.put("className", adNetworkMap.get(instanceWithBLOBs.getAdnId()).getClassName());
                        } else {
                            log.error("Adn id {} is not existed!", instanceWithBLOBs.getAdnId());
                        }
                        buildBrandBlackWhiteType(resultInstance, instanceWithBLOBs.getBrandBlacklist(), instanceWithBLOBs.getBrandWhitelist());
                        buildModelBlackWhiteType(resultInstance, instanceWithBLOBs.getModelBlacklist(), instanceWithBLOBs.getModelWhitelist());
                        resultInstances.add(resultInstance);
                    }
                    resultPlacement.put("instances", resultInstances);
                } else {
                    resultPlacement.put("instances", Collections.EMPTY_LIST);
                }
                resultPlacements.add(resultPlacement);
            }
            return Response.buildSuccess(resultPlacements);
        } catch (Exception e) {
            log.error("Get AdNetWork placement instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get app AdNetworks
     */
    @RequestMapping(value = "/adnetwork/app/get", method = RequestMethod.GET)
    public Response getAdNetWorkApp(Integer adNetworkAppId) {
        try {
            if (adNetworkAppId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            OmAdnetworkApp omAdNetworkApps = this.adNetworkService.getAdNetWorkApp(adNetworkAppId);
            if (omAdNetworkApps != null) {
                return Response.buildSuccess(omAdNetworkApps);
            } else {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
        } catch (Exception e) {
            log.error("get app's adNetworks error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new adnetwork
     *
     * @see OmAdnetworkApp
     */
    @RequestMapping(value = "/adnetwork/app/create", method = RequestMethod.POST)
    public Response createAdNetworkApp(@RequestBody OmAdnetworkApp omAdnetworkApp) {
        if (omAdnetworkApp.getAdnId() == null || omAdnetworkApp.getPubAppId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.adNetworkService.createAppAdNetwork(omAdnetworkApp);
    }

    /**
     * Update adnetwork
     *
     * @see OmAdnetworkApp
     */
    @RequestMapping(value = "/adnetwork/app/update", method = RequestMethod.POST)
    public Response updateAdNetworkApp(@RequestBody OmAdnetworkApp omAdnetworkApp) {
        return this.adNetworkService.updateAppAdNetworks(omAdnetworkApp);
    }

    /**
     * Update adnetwork
     *
     * @see OmAdnetworkApp
     */
    @RequestMapping(value = "/adnetwork/app/status/update", method = RequestMethod.GET)
    public Response updateAdNetworkAppStatus(Integer adNetworkAppId, Byte status) {
        if (status >= AdNetworkAppStatus.ADN_Paused.ordinal()) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.adNetworkService.updateAdNetworkAppStatus(adNetworkAppId, status);
    }
}
