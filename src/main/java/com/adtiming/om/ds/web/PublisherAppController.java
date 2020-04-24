// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.AdvertisementType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.PublisherAppDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmPlacement;
import com.adtiming.om.ds.model.OmPublisherApp;
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

import java.util.*;
import java.util.stream.Collectors;

/**
 * Publisher app manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class PublisherAppController extends BaseController {

    @Autowired
    private PublisherAppService publisherAppService;

    @Autowired
    private PlacementService placementService;

    /**
     * Get all valid publisher app which related to current user
     */
    @RequestMapping(value = "/publisher/app/list", method = RequestMethod.GET)
    public Response getPublisherApps() {
        try {
            List<OmPublisherApp> publisherApps = this.publisherAppService.getPublisherApps();
            if (CollectionUtils.isEmpty(publisherApps)) {
                return Response.buildSuccess(Collections.EMPTY_LIST);
            }
            List<JSONObject> publisherAppsWithPlacementsSummary = new ArrayList<>();
            List<Integer> publisherAppIds = publisherApps.stream().map(OmPublisherApp::getId).collect(Collectors.toList());
            Map<Integer, List<OmPlacement>> appPlacementsMap = this.placementService.getAppPlacementsMap(publisherAppIds);
            publisherApps.forEach(publisherApp -> {
                List<OmPlacement> placements = appPlacementsMap.get(publisherApp.getId());
                JSONObject publisherAppJson = (JSONObject) JSONObject.toJSON(publisherApp);
                Map<String, Integer> advertisementTypeSummaryMap = new HashMap<>();
                if (!CollectionUtils.isEmpty(placements)) {
                    for (OmPlacement omPlacement : placements) {
                        String advertisementTypeName = AdvertisementType.getAdvertisementType(omPlacement.getAdType()).name();
                        Integer typeCount = advertisementTypeSummaryMap.get(advertisementTypeName);
                        if (typeCount == null) {
                            typeCount = 0;
                        }
                        advertisementTypeSummaryMap.put(advertisementTypeName, typeCount + 1);
                    }
                }
                publisherAppJson.put("placementSummary", JSONArray.toJSON(advertisementTypeSummaryMap));
                publisherAppsWithPlacementsSummary.add(publisherAppJson);
            });
            return Response.buildSuccess(publisherAppsWithPlacementsSummary);
        } catch (Exception e) {
            log.error("get publisher app error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all valid publisher apps sort by revenue
     */
    @RequestMapping(value = "/publisher/app/sort_list", method = RequestMethod.GET)
    public Response getPublisherAppsSortByRevenue(Integer status) {
        try {
            NormalStatus normalStatus = null;
            if (status != null) {
                normalStatus = NormalStatus.getStatus(status);
            }
            List<OmPublisherApp> sortedPublisherApps = this.publisherAppService.getPublisherAppsSortByRevenue(normalStatus);
            if (CollectionUtils.isEmpty(sortedPublisherApps)) {
                return Response.buildSuccess(Collections.EMPTY_LIST);
            }
            return Response.buildSuccess(sortedPublisherApps);
        } catch (Exception e) {
            log.error("Get publisher apps sort by revenue error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new publisher app, related to current user with publisher_id and company_id
     *
     * @see PublisherAppDTO
     */
    @RequestMapping(value = "/publisher/app/create", method = RequestMethod.POST)
    public Response createPublisherApp(@RequestBody OmPublisherApp omPublisherApp) {
        return this.publisherAppService.createPublisherApp(omPublisherApp);
    }

    /**
     * Update publisher app's info
     *
     * @see PublisherAppDTO
     */
    @RequestMapping(value = "/publisher/app/update", method = RequestMethod.POST)
    public Response updatePublisherApp(@RequestBody PublisherAppDTO publisherAppDTO) {
        return this.publisherAppService.updatePublisherApp(publisherAppDTO);
    }

    /**
     * Update publisher app's info from app store
     */
    @RequestMapping(value = "/app/get", method = RequestMethod.GET)
    public Response updatePublisherApp(String appId) {
        if (appId == null) {
            log.error("Parameter appId must not null;");
            return Response.RES_PARAMETER_ERROR;
        }
        OmPublisherApp omPublisherApp = new OmPublisherApp();
        omPublisherApp.setAppId(appId);
        boolean result = this.publisherAppService.updatePublisherAppInfo(omPublisherApp);
        if (result) {
            return Response.buildSuccess(omPublisherApp);
        }
        return Response.RES_FAILED;
    }
}
