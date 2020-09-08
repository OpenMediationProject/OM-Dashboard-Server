// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmPlacementCountryMapper;
import com.adtiming.om.ds.dao.OmPlacementMapper;
import com.adtiming.om.ds.dao.OmPlacementSceneMapper;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.RoleType;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
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
public class PlacementService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private OmPlacementMapper omPlacementMapper;

    @Resource
    private OmPlacementSceneMapper omPlacementSceneMapper;

    @Resource
    private OmPlacementCountryMapper omPlacementCountryMapper;

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
     * Select all placements from database by pubAppId and status
     *
     * @param pubAppIds
     * @param pubAppId
     * @param status
     * @return placements
     */
    public List<OmPlacementWithBLOBs> getPlacements(List<Integer> pubAppIds, Integer pubAppId, NormalStatus status) {
        OmPlacementCriteria omPlacementCriteria = new OmPlacementCriteria();
        OmPlacementCriteria.Criteria criteria = omPlacementCriteria.createCriteria();
        criteria.andIdGreaterThan(0);
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (pubAppIds != null) {
            criteria.andPubAppIdIn(pubAppIds);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        criteria.andStatusLessThan((byte) NormalStatus.Deleted.ordinal());
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        PageHelper.offsetPage(0, 1000);
        List<OmPlacementWithBLOBs> placements = this.omPlacementMapper.selectWithBLOBs(omPlacementCriteria);
        this.sortPlacementsByRevenue(placements);
        return placements;
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
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());

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
                Double revenue2 = placementRevenueMap.get(placement2.getId());
                if (revenue1 == null && revenue2 == null) {
                    return 0;
                }
                if (revenue1 == null) {
                    revenue1 = 0D;
                }
                if (revenue2 == null) {
                    revenue2 = 0D;
                }
                return revenue2.compareTo(revenue1);
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
    @Transactional
    public Response createPlacement(OmPlacementWithBLOBs omPlacement) {
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
        if (id <= 0) {
            throw new RuntimeException("Insert placement " + JSONObject.toJSON(omPlacement) + " failed!");
        }
        log.info("Create placement name {}", omPlacement.getName());
        return Response.buildSuccess(omPlacement);
    }

    /**
     * Update placement database object, and insert into database
     *
     * @param omPlacement
     */
    @Transactional
    public Response updatePlacement(OmPlacementWithBLOBs omPlacement) {
        omPlacement.setLastmodify(new Date());
        int result = this.omPlacementMapper.updateByPrimaryKeySelective(omPlacement);
        if (result <= 0) {
            throw new RuntimeException("Update placement " + JSONObject.toJSON(omPlacement) + " failed!");
        }
        log.info("Update placement {} success", omPlacement.getId());
        return Response.build();
    }

    /**
     * Select placement scenes by placement id
     *
     * @param placementId
     * @return List<OmPlacementScene>
     */
    public List<OmPlacementScene> getPlacementScenes(Integer placementId) {
        OmPlacementSceneCriteria omPlacementSceneCriteria = new OmPlacementSceneCriteria();
        OmPlacementSceneCriteria.Criteria criteria = omPlacementSceneCriteria.createCriteria();
        criteria.andPlacementIdEqualTo(placementId);
        List<OmPlacementScene> placementScenes = omPlacementSceneMapper.select(omPlacementSceneCriteria);
        return placementScenes;
    }

    /**
     * Select placement scenes map by placement id
     *
     * @param placementIds
     * @return Map<Integer, List < PublisherPlacementScene>>
     */
    public Map<Integer, List<OmPlacementScene>> getPlacementScenesMap(List<Integer> placementIds) {
        if (CollectionUtils.isEmpty(placementIds)) {
            return new HashMap<>();
        }
        OmPlacementSceneCriteria omPlacementSceneCriteria = new OmPlacementSceneCriteria();
        OmPlacementSceneCriteria.Criteria criteria = omPlacementSceneCriteria.createCriteria();
        criteria.andPlacementIdIn(placementIds);
        criteria.andStatusEqualTo((byte)NormalStatus.Active.ordinal());
        List<OmPlacementScene> placementScenes = this.omPlacementSceneMapper.select(omPlacementSceneCriteria);
        return placementScenes.stream()
                .collect(Collectors.groupingBy(m -> m.getPlacementId(), Collectors.toList()));
    }

    /**
     * Select apps placements map
     *
     * @param pubAppIds
     */
    public Map<Integer, List<OmPlacement>> getAppPlacementsMap(List<Integer> pubAppIds) {
        if (CollectionUtils.isEmpty(pubAppIds)) {
            return new HashMap<>();
        }
        OmPlacementCriteria omPlacementCriteria = new OmPlacementCriteria();
        OmPlacementCriteria.Criteria criteria = omPlacementCriteria.createCriteria();
        criteria.andPubAppIdIn(pubAppIds);
        if (this.getCurrentUser().getRoleId() != RoleType.ADMINISTRATOR.getId()) {
            criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
            criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        }
        List<OmPlacement> publisherAppPlacements = omPlacementMapper.select(omPlacementCriteria);
        return publisherAppPlacements.stream()
                .collect(Collectors.groupingBy(OmPlacement::getPubAppId, Collectors.toList()));
    }

    /**
     * Build placement scene database object, and insert into database
     *
     * @param omPlacementScene
     * @return Response
     */
    @Transactional
    public Response createPlacementScene(OmPlacementScene omPlacementScene) {
        Date currentTime = new Date();
        omPlacementScene.setCreateTime(currentTime);
        omPlacementScene.setLastmodify(currentTime);
        int result = this.omPlacementSceneMapper.insertSelective(omPlacementScene);
        if (result <= 0) {
            throw new RuntimeException("Create placement scene " + JSONObject.toJSON(omPlacementScene) + " failed!");
        }
        log.info("Create placement scene {}", JSONObject.toJSON(omPlacementScene));
        return Response.buildSuccess(omPlacementScene);
    }

    /**
     * Update placement scene database object, and insert into database
     *
     * @param omPlacementScene
     * @return Response
     */
    @Transactional
    public Response updatePlacementScene(OmPlacementScene omPlacementScene) {
        omPlacementScene.setLastmodify(new Date());
        int result = this.omPlacementSceneMapper.updateByPrimaryKeySelective(omPlacementScene);
        if (result <= 0) {
            throw new RuntimeException("Update placement scene " + omPlacementScene.getId() + " failed!");
        }
        log.info("Update placement scene {} success", JSONObject.toJSON(omPlacementScene));
        return Response.build();
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
