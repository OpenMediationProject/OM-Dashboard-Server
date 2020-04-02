// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmPlacementCountryMapper;
import com.adtiming.om.ds.dao.OmPlacementMapper;
import com.adtiming.om.ds.dao.OmPlacementSceneMapper;
import com.adtiming.om.ds.dto.*;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Placement Manager
 *
 * @author dianbo ruan
 */
@Service
public class PlacementService extends BaseService {

    public static byte DEFAULT_PRELOAD_TIMEOUT = 30;

    @Resource
    private OmPlacementMapper omPlacementMapper;

    @Resource
    private OmPlacementSceneMapper omPlacementSceneMapper;

    @Resource
    private OmPlacementCountryMapper omPlacementCountryMapper;

    /**
     * Select all placements by publisher app id
     *
     * @param pubAppId
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(Integer pubAppId) {
        return this.getPlacements(pubAppId, null, null, null);
    }

    /**
     * Select all placements from database which related to current user
     *
     * @param pubAppId
     * @param placementTypes
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(Integer pubAppId, Byte[] placementTypes) {
        return this.getPlacements(pubAppId, placementTypes, null, null);
    }

    /**
     * Select all placements from database which related to current user
     *
     * @param pubAppId
     * @param placementId
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(Integer pubAppId, Integer placementId) {
        return this.getPlacements(pubAppId, null, placementId, null);
    }

    /**
     * Select all placements from database by pubAppId and status
     *
     * @param pubAppId
     * @param status
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(Integer pubAppId, NormalStatus status) {
        return this.getPlacements(pubAppId, null, null, status);
    }

    /**
     * Select all placements from database which related to current user
     *
     * @param placementId
     * @param status
     * @param pubAppId
     * @param placementTypes
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(Integer pubAppId, Byte[] placementTypes, Integer placementId, NormalStatus status) {
        OmPlacementCriteria omPlacementCriteria = new OmPlacementCriteria();
        OmPlacementCriteria.Criteria criteria = omPlacementCriteria.createCriteria();
        criteria.andIdGreaterThan(0);
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (placementId != null) {
            criteria.andIdEqualTo(placementId);
        }
        if (placementTypes != null && placementTypes.length > 0) {
            List<Byte> types = new ArrayList<>();
            for (Byte type : placementTypes) {
                types.add(type);
            }
            criteria.andAdTypeIn(types);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        criteria.andPublisherIdIn(this.getPublisherIdsOfCurrentUser());

        PageHelper.offsetPage(0, 1000);
        List<OmPlacementWithBLOBs> placements = omPlacementMapper.selectWithBLOBs(omPlacementCriteria);
        this.sortPlacementsByRevenue(placements);
        return placements;
    }

    /**
     * Select placement by id
     *
     * @param placementId
     * @return OmPlacement
     */
    public OmPlacementWithBLOBs getPlacement(Integer placementId) {
        return omPlacementMapper.selectByPrimaryKey(placementId);
    }

    /**
     * Sort placement by revenue
     *
     * @param placements
     */
    private void sortPlacementsByRevenue(List<OmPlacementWithBLOBs> placements) {
        try {
            if (CollectionUtils.isEmpty(placements)) {
                return;
            }
            Map<Integer, Double> placementRevenueMap = this.cacheService.getPlacementRevenueMap();
            if (CollectionUtils.isEmpty(placementRevenueMap)) {
                return;
            }
            placements.sort((placement1, placement2) -> {
                Double revenue1 = placementRevenueMap.get(placement1.getId());
                if (revenue1 == null) {
                    revenue1 = 0D;
                }
                Double revenue2 = placementRevenueMap.get(placement2.getId());
                if (revenue2 == null) {
                    revenue2 = 0D;
                }
                return (int) (revenue2 - revenue1);
            });
        } catch (Exception e) {
            log.error("Sort placement by revenue error:", e);
        }
    }

    /**
     * Build placement database object, and insert into database
     *
     * @param omPlacement
     */
    public Response createPlacement(OmPlacementWithBLOBs omPlacement) {
        try {
            Date currentTime = new Date();
            if (omPlacement.getPublisherId() == null || omPlacement.getPublisherId() <= 0) {
                Integer currentUserPublisherId = this.getCurrentUser().getPublisherId();
                if (currentUserPublisherId == null || currentUserPublisherId == 0) {
                    log.error("No publisher with current user {}", JSONObject.toJSON(this.getCurrentUser()));
                    return Response.RES_PUBLISHER_NOT_EXISTED;
                }
                omPlacement.setPublisherId(currentUserPublisherId);
            }
            if (omPlacement.getPubAppId() == null || omPlacement.getPubAppId() <= 0) {
                log.error("Publisher app does not existed {}", JSONObject.toJSONString(omPlacement));
                return Response.RES_PUBLISHER_APP_NOT_EXISTED;
            }
            omPlacement.setCreateTime(currentTime);
            omPlacement.setLastmodify(currentTime);
            int id = this.omPlacementMapper.insertSelective(omPlacement);
            if (id > 0) {
                this.buildDefaultScenes(omPlacement);
                log.info("Create placement name {}", omPlacement.getName());
                return Response.buildSuccess(omPlacement);
            }
        } catch (Exception e) {
            log.error("Create placement error {}", JSONObject.toJSONString(omPlacement), e);
        }
        log.info("Create placement name {} failed", omPlacement.getName());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement failed!");
    }

    private void buildDefaultScenes(OmPlacement omPlacement) {
        OmPlacementScene defaultPlacementScene = new OmPlacementScene();
        defaultPlacementScene.setName("Default_Scene");
        defaultPlacementScene.setPlacementId(omPlacement.getId());
        this.createPlacementScene(defaultPlacementScene);
    }

    /**
     * Build default placement database object for publisher app, and insert into database
     *
     * @param omPublisherApp
     */
    public void createDefaultPlacement(OmPublisherApp omPublisherApp) {
        Date currentTime = new Date();
        OmPlacementWithBLOBs defaultInterstitialPlacement = new OmPlacementWithBLOBs();
        defaultInterstitialPlacement.setName("Default_Interstitial");
        defaultInterstitialPlacement.setPubAppId(omPublisherApp.getId());
        defaultInterstitialPlacement.setPublisherId(omPublisherApp.getPublisherId());
        defaultInterstitialPlacement.setAdType((byte) AdvertisementType.Interstitial.ordinal());
        defaultInterstitialPlacement.setPreloadTimeout(DEFAULT_PRELOAD_TIMEOUT);
        defaultInterstitialPlacement.setCreateTime(currentTime);
        defaultInterstitialPlacement.setCreateTime(currentTime);
        this.createPlacement(defaultInterstitialPlacement);

        OmPlacementWithBLOBs defaultRewardVideoPlacement = new OmPlacementWithBLOBs();
        defaultRewardVideoPlacement.setName("Default_RewardVideo");
        defaultRewardVideoPlacement.setPubAppId(omPublisherApp.getId());
        defaultRewardVideoPlacement.setPublisherId(omPublisherApp.getPublisherId());
        defaultRewardVideoPlacement.setAdType((byte) AdvertisementType.RewardedVideo.ordinal());
        defaultRewardVideoPlacement.setPreloadTimeout(DEFAULT_PRELOAD_TIMEOUT);
        defaultRewardVideoPlacement.setCreateTime(currentTime);
        defaultRewardVideoPlacement.setCreateTime(currentTime);
        this.createPlacement(defaultRewardVideoPlacement);
    }

    /**
     * Update placement database object, and insert into database
     *
     * @param omPlacement
     */
    public Response updatePlacement(OmPlacementWithBLOBs omPlacement) {
        try {
            omPlacement.setLastmodify(new Date());
            int result = this.omPlacementMapper.updateByPrimaryKeySelective(omPlacement);
            if (result > 0) {
                log.info("Update placement {} success", omPlacement.getId());
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Update placement error {}", JSONObject.toJSONString(omPlacement), e);
        }
        log.error("Update placement {} failed", omPlacement.getId());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement failed!");
    }

    /**
     * Select placement scenes by placement id
     *
     * @param placementId
     * @return List<OmPlacementScene>
     */
    public List<OmPlacementScene> getPlacementScenes(Integer placementId, SwitchStatus status) {
        OmPlacementSceneCriteria omPlacementSceneCriteria = new OmPlacementSceneCriteria();
        OmPlacementSceneCriteria.Criteria criteria = omPlacementSceneCriteria.createCriteria();
        criteria.andPlacementIdEqualTo(placementId);
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        List<OmPlacementScene> placementScenes = omPlacementSceneMapper.select(omPlacementSceneCriteria);
        return placementScenes;
    }

    /**
     * Select placement by publisher app id
     *
     * @param pubAppId
     */
    public List<OmPlacement> getPlacementsByPublisherAppId(Integer pubAppId, NormalStatus status) {
        OmPlacementCriteria omPlacementCriteria = new OmPlacementCriteria();
        OmPlacementCriteria.Criteria criteria = omPlacementCriteria.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andPubAppIdEqualTo(pubAppId);
        if (this.getCurrentUser().getRoleId() != RoleType.ADMINISTRATOR.getId()) {
            criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
            criteria.andPublisherIdIn(this.getPublisherIdsOfCurrentUser());
        }
        List<OmPlacement> publisherAppPlacements = omPlacementMapper.select(omPlacementCriteria);
        return publisherAppPlacements;
    }

    /**
     * Build placement scene database object, and insert into database
     *
     * @param omPlacementScene
     * @return Response
     */
    public Response createPlacementScene(OmPlacementScene omPlacementScene) {
        try {
            Date currentTime = new Date();
            omPlacementScene.setCreateTime(currentTime);
            omPlacementScene.setLastmodify(currentTime);
            int id = this.omPlacementSceneMapper.insertSelective(omPlacementScene);
            if (id > 0) {
                log.info("Create placement scene id {}", omPlacementScene.getName());
                return Response.buildSuccess(omPlacementScene);
            }
        } catch (Exception e) {
            log.error("Create placement scene error {}", JSONObject.toJSONString(omPlacementScene), e);
        }
        log.error("Create placement scene id {}", omPlacementScene.getName());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement scene failed!");
    }

    /**
     * Update placement scene database object, and insert into database
     *
     * @param omPlacementScene
     * @return Response
     */
    public Response updatePlacementScene(OmPlacementScene omPlacementScene) {
        try {
            omPlacementScene.setLastmodify(new Date());
            int result = this.omPlacementSceneMapper.updateByPrimaryKeySelective(omPlacementScene);
            if (result > 0) {
                log.info("Update placement scene {} success", omPlacementScene.getId());
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Update placement scene error {}", JSONObject.toJSONString(omPlacementScene), e);
        }
        log.error("Update placement scene {} failed", omPlacementScene.getId());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement scene failed!");
    }

    /**
     * Select placement countries
     *
     * @param placementId
     * @return placementCountries
     */
    public List<OmPlacementCountry> getPlacementCountries(Integer placementId) {
        OmPlacementCountryCriteria omPlacementCountryCriteria = new OmPlacementCountryCriteria();
        OmPlacementCountryCriteria.Criteria criteria = omPlacementCountryCriteria.createCriteria();
        criteria.andPlacementIdEqualTo(placementId);
        List<OmPlacementCountry> placementCountries = this.omPlacementCountryMapper.select(omPlacementCountryCriteria);
        log.info("Get placement countries size: {}", placementCountries.size());
        return placementCountries;
    }

    /**
     * Build placement country database object, and insert into database
     *
     * @param omPlacementCountry
     */
    public Response createPlacementCountry(OmPlacementCountry omPlacementCountry) {
        try {
            Date currentTime = new Date();
            omPlacementCountry.setCreateTime(currentTime);
            omPlacementCountry.setLastmodify(currentTime);
            int result = this.omPlacementCountryMapper.insertSelective(omPlacementCountry);
            if (result > 0) {
                log.info("Create placement country {} success", omPlacementCountry.getCountry());
                return Response.buildSuccess(omPlacementCountry);
            }
        } catch (Exception e) {
            log.info("Create placement country {} error", JSONObject.toJSONString(omPlacementCountry), e);
        }
        log.info("Create placement country {} failed", JSONObject.toJSONString(omPlacementCountry));
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement country failed!");
    }

    /**
     * Update placement country database object
     *
     * @param omPlacementCountry
     */
    public Response updatePlacementCountry(OmPlacementCountry omPlacementCountry) {
        try {
            omPlacementCountry.setLastmodify(new Date());
            int result = this.omPlacementCountryMapper.updateByPrimaryKeySelective(omPlacementCountry);
            if (result > 0) {
                log.info("Update placement country {} success", omPlacementCountry.getCountry());
                return Response.build();
            }
        } catch (Exception e) {
            log.error("Update placement country error {}", JSONObject.toJSONString(omPlacementCountry), e);
        }
        log.error("Update placement country {} failed", omPlacementCountry.getCountry());
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement country failed!");
    }
}
