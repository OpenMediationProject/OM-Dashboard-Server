// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmPlacementCountry;
import com.adtiming.om.ds.model.OmPlacementScene;
import com.adtiming.om.ds.model.OmPlacementWithBLOBs;
import com.adtiming.om.ds.service.PlacementService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Placement manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class PlacementController extends BaseController {

    @Autowired
    private PlacementService placementService;

    /**
     * Get all valid placements which related to current user
     *
     * @param pubAppId
     * @param placementTypes
     */
    @RequestMapping(value = "/placement/list", method = RequestMethod.GET)
    public Response getPlacements(Integer pubAppId, Byte[] placementTypes) {
        try {
            if (pubAppId == null) {
                log.error("Publisher id is {}", JSONObject.toJSONString(placementTypes));
            }
            JSONArray resultPlacements = new JSONArray();
            List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(pubAppId, placementTypes);
            for (OmPlacementWithBLOBs placement : placements) {
                JSONObject resultPlacement = this.addScenes(placement);
                buildBrandBlackWhiteType(resultPlacement, placement.getBrandBlacklist(), placement.getBrandWhitelist());
                buildModelBlackWhiteType(resultPlacement, placement.getModelBlacklist(), placement.getModelWhitelist());
                resultPlacements.add(resultPlacement);
            }
            return Response.buildSuccess(resultPlacements);
        } catch (Exception e) {
            log.error("get placements error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all valid placements for select component
     *
     * @param pubAppId
     */
    @RequestMapping(value = "/placement/select/list", method = RequestMethod.GET)
    public Response getSelectPlacements(Integer pubAppId) {
        try {
            List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(pubAppId, NormalStatus.ACTIVE);
            return Response.buildSuccess(placements);
        } catch (Exception e) {
            log.error("get select placements error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get placement info by id
     *
     * @param placementId
     */
    @RequestMapping(value = "/placement/get", method = RequestMethod.GET)
    public Response getPlacement(Integer placementId) {
        try {
            if (placementId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            OmPlacementWithBLOBs placement = this.placementService.getPlacement(placementId);
            if (placement == null) {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            JSONObject resultPlacement = this.addScenes(placement);
            buildBrandBlackWhiteType(resultPlacement, placement.getBrandBlacklist(), placement.getBrandWhitelist());
            buildModelBlackWhiteType(resultPlacement, placement.getModelBlacklist(), placement.getModelWhitelist());
            return Response.buildSuccess(resultPlacement);
        } catch (Exception e) {
            log.error("get placement error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Add placement scenes to result
     *
     * @return resultPlacement
     */
    private JSONObject addScenes(OmPlacementWithBLOBs placement) {
        List<OmPlacementScene> placementScenes = this.placementService.getPlacementScenes(placement.getId(), SwitchStatus.ON);
        JSONObject resultPlacement = (JSONObject) JSONObject.toJSON(placement);
        if (!placementScenes.isEmpty()) {
            resultPlacement.put("sceneSize", placementScenes.size());
            resultPlacement.put("scenes", placementScenes);
        } else {
            resultPlacement.put("sceneSize", 0);
        }
        return resultPlacement;
    }

    /**
     * Create a new placement, related to current user
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/create", method = RequestMethod.POST)
    public Response createPlacement(@RequestBody OmPlacementWithBLOBs omPlacementWithBLOBs) {
        return this.placementService.createPlacement(omPlacementWithBLOBs);
    }

    /**
     * Update placement information
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/update", method = RequestMethod.POST)
    public Response updatePlacement(@RequestBody OmPlacementWithBLOBs omPlacementWithBLOBs) {
        return this.placementService.updatePlacement(omPlacementWithBLOBs);
    }

    /**
     * Get all placement scenes by placement id
     */
    @RequestMapping(value = "/placement/scenes", method = RequestMethod.GET)
    public Response getPlacementScenes(Integer placementId) {
        try {
            if (placementId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            List<OmPlacementScene> placementScenes = this.placementService.getPlacementScenes(placementId, null);
            return Response.buildSuccess(placementScenes);
        } catch (Exception e) {
            log.error("get placement scenes error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement scene, related to current user
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/scene/create", method = RequestMethod.POST)
    public Response createPlacementScene(@RequestBody OmPlacementScene omPlacementScene) {
        if (omPlacementScene.getPlacementId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.placementService.createPlacementScene(omPlacementScene);
    }

    /**
     * Update placement scene information
     *
     * @see OmPlacementScene
     */
    @RequestMapping(value = "/placement/scene/update", method = RequestMethod.POST)
    public Response updatePlacementScene(@RequestBody OmPlacementScene omPlacementScene) {
        return this.placementService.updatePlacementScene(omPlacementScene);
    }

    /**
     * Get all placement countries by placement id
     */
    @RequestMapping(value = "/placement/country/list", method = RequestMethod.GET)
    public Response getPlacementCountries(Integer placementId) {
        try {
            List<OmPlacementCountry> placementCountries = this.placementService.getPlacementCountries(placementId);
            return Response.buildSuccess(placementCountries);
        } catch (Exception e) {
            log.error("get placement countries error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement country, related to current user
     *
     * @see OmPlacementCountry
     */
    @RequestMapping(value = "/placement/country/create", method = RequestMethod.POST)
    public Response createPlacementCountry(@RequestBody OmPlacementCountry omPlacementCountry) {
        if (omPlacementCountry.getCountry() == null || omPlacementCountry.getPlacementId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.placementService.createPlacementCountry(omPlacementCountry);
    }

    /**
     * Update placement country information
     *
     * @see OmPlacementCountry
     */
    @RequestMapping(value = "/placement/country/update", method = RequestMethod.POST)
    public Response updatePlacementRules(@RequestBody OmPlacementCountry omPlacementCountry) {
        return this.placementService.updatePlacementCountry(omPlacementCountry);
    }
}
