// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.*;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * AdNetwork manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class AdNetworkController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    protected AdNetworkService adNetworkService;

    @Autowired
    protected PlacementService placementService;

    @Autowired
    protected InstanceService instanceService;

    @Autowired
    protected PublisherAppService publisherAppService;

    @Autowired
    protected AccountService accountService;

    /**
     * Get all AdNetworks of publisher app
     */
    @RequestMapping(value = "/adnetwork/select/list", method = RequestMethod.GET)
    public Response getAdNetWorkSelectList(Integer pubAppId, Integer placementId) {
        try {
            List<OmAdnetwork> adNetworks = this.adNetworkService.getAllAdNetworks();
            Map<Integer, OmAdnetworkApp> adNetworkAppMap = new HashMap<>();
            if (pubAppId != null) {
                adNetworkAppMap = this.adNetworkService.getAdNetworkIdAppMap(pubAppId, NormalStatus.Active);
            }
            OmPublisherApp publisherApp = null;
            if (pubAppId != null) {
                publisherApp = this.publisherAppService.getPublisherApp(pubAppId);
            }
            OmPlacementWithBLOBs placement = null;
            if (placementId != null) {
                placement = this.placementService.getPlacement(placementId);
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
                    if (publisherApp != null && !this.adNetworkService.doesPlatMatch(publisherApp, omAdnetwork)) {
                        continue;
                    }
                }
                //创建instance时过滤不支持广告位类型的adnetwork
                if (placement != null && publisherApp != null) {
                    List<String> adTypes = this.adNetworkService.buildAdTypes(omAdnetwork, publisherApp);
                    if (placement.getAdType() != null) {
                        AdvertisementType adType = AdvertisementType.getAdvertisementType(placement.getAdType().intValue());
                        if (!adTypes.contains(adType.name())) {
                            continue;
                        }
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
            if (pubAppId == null) {
                log.warn("Get AdNetWorks pubAppId can not be null");
                return Response.RES_PARAMETER_ERROR;
            }
            Map<Integer, Collection<JSONObject>> adnAccountAppIconsMap = this.accountService.getPublisherAdnAccountWithAppIconsMap(null);
            List<JSONObject> adNetworks = this.adNetworkService.getAdNetworks(pubAppId);
            for (JSONObject adNetwork : adNetworks) {
                Integer andId = adNetwork.getInteger("id");
                Collection<JSONObject> adnAccounts = adnAccountAppIconsMap.get(andId);
                if (!CollectionUtils.isEmpty(adnAccounts)) {
                    adNetwork.put("accounts", adnAccounts);
                } else {
                    adNetwork.put("accounts", new JSONArray());
                }
            }
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
                        Util.buildBrandBlackWhiteType(resultInstance, instanceWithBLOBs.getBrandBlacklist(), instanceWithBLOBs.getBrandWhitelist());
                        Util.buildModelBlackWhiteType(resultInstance, instanceWithBLOBs.getModelBlacklist(), instanceWithBLOBs.getModelWhitelist());
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
        try {
            if (omAdnetworkApp.getAdnId() == null || omAdnetworkApp.getPubAppId() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            if (omAdnetworkApp.getAdnId() != AdNetworkType.Adtiming.ordinal()
                    && omAdnetworkApp.getAdnId() != AdNetworkType.Facebook.ordinal()
                    && omAdnetworkApp.getAdnId() != AdNetworkType.TencentAd.ordinal()
                    && omAdnetworkApp.getReportAccountId() == null) {
                log.warn("Create adNetworkApp parameters ReportAccountId must not null");
                return Response.RES_PARAMETER_ERROR;
            }
            return this.adNetworkService.createAppAdNetwork(omAdnetworkApp);
        } catch (Exception e) {
            log.info("Create AdNetwork {} error", JSONObject.toJSONString(omAdnetworkApp), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement failed!");
    }

    /**
     * Update adnetwork
     *
     * @see OmAdnetworkApp
     */
    @RequestMapping(value = "/adnetwork/app/update", method = RequestMethod.POST)
    public Response updateAdNetworkApp(@RequestBody OmAdnetworkApp omAdnetworkApp) {
        try {
            return this.adNetworkService.updateAppAdNetworks(omAdnetworkApp);
        } catch (Exception e) {
            log.error("Update AdNetworks error {}", JSONObject.toJSONString(omAdnetworkApp), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update AdNetworks failed!");
    }

    /**
     * Update adnetwork
     *
     * @see OmAdnetworkApp
     */
    @RequestMapping(value = "/adnetwork/app/status/update", method = RequestMethod.GET)
    public Response updateAdNetworkAppStatus(Integer adNetworkAppId, Byte status) {
        try {
            if (status >= AdNetworkAppStatus.ADN_Paused.ordinal()) {
                return Response.RES_PARAMETER_ERROR;
            }
            return this.adNetworkService.updateAdNetworkAppStatus(adNetworkAppId, status);
        } catch (Exception e) {
            log.error("Update AdNetworks error adNetworkAppId {}", adNetworkAppId, e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update adNetwork app status failed!");
    }
}
