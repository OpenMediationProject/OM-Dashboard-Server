// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.AdvertisementType;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmInstanceWithBLOBs;
import com.adtiming.om.ds.model.OmPlacementCountry;
import com.adtiming.om.ds.model.OmPlacementScene;
import com.adtiming.om.ds.model.OmPlacementWithBLOBs;
import com.adtiming.om.ds.service.InstanceService;
import com.adtiming.om.ds.service.PlacementService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Placement manage interface
 *
 * @author dianbo ruan
 */
@RestController
public class PlacementController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    protected PlacementService placementService;

    @Autowired
    protected InstanceService instanceService;

    /**
     * Create or update placement information, include scene in a transaction
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/create_update", method = RequestMethod.POST)
    @Transactional
    public Response createOrUpdatePlacement(@RequestBody OmPlacementWithBLOBs placement) {
        try {
            if (placement.getPubAppId() == null || placement.getAdType() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            if (placement.getId() == null || placement.getId() <= 0) {
                AdvertisementType adType = AdvertisementType.getAdvertisementType(placement.getAdType().intValue());
                if (AdvertisementType.Interstitial.equals(adType) || AdvertisementType.RewardedVideo.equals(adType)) {
                    Byte[] adTypes = new Byte[1];
                    adTypes[0] = (byte) adType.ordinal();
                    List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(placement.getPubAppId(), adTypes);
                    if (!CollectionUtils.isEmpty(placements)) {
                        String warn = adType.name() + " already exists";
                        log.warn(warn);
                        return Response.failure(Response.CODE_RES_DATA_EXISTED, warn);
                    }
                }
                this.placementService.createPlacement(placement);
            } else {
                this.placementService.updatePlacement(placement);
            }
            OmPlacementScene[] scenes = placement.getScenes();
            if (scenes != null && scenes.length > 0) {
                for (OmPlacementScene scene : scenes) {
                    scene.setCreateTime(null);
                    scene.setLastmodify(null);
                    scene.setPlacementId(placement.getId());
                    if (scene.getId() == null || scene.getId() <= 0) {
                        this.placementService.createPlacementScene(scene);
                    } else {
                        this.placementService.updatePlacementScene(scene);
                    }
                }
            }
            return Response.buildSuccess(placement);
        } catch (Exception e) {
            log.error("Create or update placement {} error", JSONObject.toJSON(placement), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Response.RES_FAILED;
    }

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
                log.warn("Publisher id is {}", JSONObject.toJSONString(placementTypes));
            }
            Map<Integer, List<OmInstanceWithBLOBs>> placementInstancesMap = this.instanceService.getPlacementInstancesMap(pubAppId);
            JSONArray resultPlacements = new JSONArray();
            List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(pubAppId, placementTypes);
            List<Integer> placementIds = placements.stream().map(OmPlacementWithBLOBs::getId).collect(Collectors.toList());
            Map<Integer, List<OmPlacementScene>> placementScenesMap = this.placementService.getPlacementScenesMap(placementIds);
            for (OmPlacementWithBLOBs placement : placements) {
                if (placement.getStatus().intValue() == NormalStatus.Paused.ordinal()) {
                    placement.setStatus((byte) NormalStatus.Pending.ordinal());
                }
                List<OmPlacementScene> activeScenes = placementScenesMap.get(placement.getId());
                JSONObject resultPlacement = (JSONObject) JSONObject.toJSON(placement);
                if (!CollectionUtils.isEmpty(activeScenes)) {
                    resultPlacement.put("sceneSize", activeScenes.size());
                    resultPlacement.put("scenes", activeScenes);
                } else {
                    resultPlacement.put("sceneSize", 0);
                }
                Util.buildBrandBlackWhiteType(resultPlacement, placement.getBrandBlacklist(), placement.getBrandWhitelist());
                Util.buildModelBlackWhiteType(resultPlacement, placement.getModelBlacklist(), placement.getModelWhitelist());
                List<OmInstanceWithBLOBs> activeInstances = placementInstancesMap.get(placement.getId());
                if (!CollectionUtils.isEmpty(activeInstances)) {
                    resultPlacement.put("instanceSize", activeInstances);
                } else {
                    resultPlacement.put("instanceSize", 0);
                }
                resultPlacements.add(resultPlacement);
            }
            return Response.buildSuccess(resultPlacements);
        } catch (Exception e) {
            log.error("get placements error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Add placement scenes to result
     *
     * @return resultPlacement
     */
    private JSONObject buildResultPlacement(OmPlacementWithBLOBs placement, List<OmPlacementScene> placementScenes) {
        JSONObject resultPlacement = (JSONObject) JSONObject.toJSON(placement);
        if (!CollectionUtils.isEmpty(placementScenes)) {
            resultPlacement.put("sceneSize", placementScenes.size());
            resultPlacement.put("scenes", placementScenes);
        } else {
            resultPlacement.put("sceneSize", 0);
        }
        return resultPlacement;
    }

    /**
     * Get all valid placements for select component
     *
     * @param pubAppId
     */
    @RequestMapping(value = "/placement/select/list", method = RequestMethod.GET)
    public Response getSelectPlacements(Integer pubAppId, String[] pubAppIds, Integer status) {
        try {
            List<Integer> appIds = null;
            if (pubAppIds != null && pubAppIds.length > 0) {
                appIds = new ArrayList<>();
                for (String appId : pubAppIds) {
                    appIds.add(Integer.parseInt(appId));
                }
            }
            NormalStatus normalStatus = NormalStatus.Active;
            if (status != null){
                normalStatus = NormalStatus.getStatus(status);
            }
            JSONArray results = new JSONArray();
            List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(appIds, pubAppId, normalStatus);
            placements.forEach(placement -> {
                JSONObject result = new JSONObject();
                result.put("id", placement.getId());
                result.put("name", placement.getName());
                result.put("adType", placement.getAdType());
                results.add(result);
            });
            return Response.buildSuccess(results);
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
            List<OmPlacementScene> placementScenes = this.placementService.getPlacementScenes(placement.getId());
            JSONObject resultPlacement = (JSONObject) JSONObject.toJSON(placement);
            if (!CollectionUtils.isEmpty(placementScenes)) {
                resultPlacement.put("sceneSize", placementScenes.size());
                resultPlacement.put("scenes", placementScenes);
            } else {
                resultPlacement.put("sceneSize", 0);
            }
            Util.buildBrandBlackWhiteType(resultPlacement, placement.getBrandBlacklist(), placement.getBrandWhitelist());
            Util.buildModelBlackWhiteType(resultPlacement, placement.getModelBlacklist(), placement.getModelWhitelist());
            return Response.buildSuccess(resultPlacement);
        } catch (Exception e) {
            log.error("get placement error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement, related to current user
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/create", method = RequestMethod.POST)
    public Response createPlacement(@RequestBody OmPlacementWithBLOBs placement) {
        try {
            if (placement.getPubAppId() == null || placement.getAdType() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            AdvertisementType adType = AdvertisementType.getAdvertisementType(placement.getAdType().intValue());
            if (AdvertisementType.Interstitial.equals(adType) || AdvertisementType.RewardedVideo.equals(adType)) {
                Byte[] adTypes = new Byte[1];
                adTypes[0] = (byte) adType.ordinal();
                List<OmPlacementWithBLOBs> placements = this.placementService.getPlacements(placement.getPubAppId(), adTypes);
                if (!CollectionUtils.isEmpty(placements)) {
                    String warn = adType.name() + " already exists";
                    log.warn(warn);
                    return Response.failure(Response.CODE_RES_DATA_EXISTED, warn);
                }
            }
            return this.placementService.createPlacement(placement);
        } catch (Exception e) {
            log.error("Create placement error {}", JSONObject.toJSONString(placement), e);
        }
        log.info("Create placement name {} failed", placement.getName());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement failed!");
    }

    /**
     * Update placement information
     *
     * @see OmPlacementWithBLOBs
     */
    @RequestMapping(value = "/placement/update", method = RequestMethod.POST)
    public Response updatePlacement(@RequestBody OmPlacementWithBLOBs omPlacementWithBLOBs) {
        try {
            return this.placementService.updatePlacement(omPlacementWithBLOBs);
        } catch (Exception e) {
            log.error("Update placement error {}", JSONObject.toJSONString(omPlacementWithBLOBs), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement failed!");
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
            List<OmPlacementScene> placementScenes = this.placementService.getPlacementScenes(placementId);
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
        try {
            if (omPlacementScene.getPlacementId() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            return this.placementService.createPlacementScene(omPlacementScene);
        } catch (Exception e) {
            log.error("Create placement scene error {}", JSONObject.toJSONString(omPlacementScene), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement scene failed!");
    }

    /**
     * Update placement scene information
     *
     * @see OmPlacementScene
     */
    @RequestMapping(value = "/placement/scene/update", method = RequestMethod.POST)
    public Response updatePlacementScene(@RequestBody OmPlacementScene omPlacementScene) {
        try {
            return this.placementService.updatePlacementScene(omPlacementScene);
        } catch (Exception e) {
            log.error("Update placement scene error {}", JSONObject.toJSONString(omPlacementScene), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement scene failed!");
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
