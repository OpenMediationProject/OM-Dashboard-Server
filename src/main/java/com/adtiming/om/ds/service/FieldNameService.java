// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmAdnetworkMapper;
import com.adtiming.om.ds.dao.OmInstanceMapper;
import com.adtiming.om.ds.dao.OmPlacementMapper;
import com.adtiming.om.ds.dao.OmPublisherAppMapper;
import com.adtiming.om.ds.dto.AdvertisementType;
import com.adtiming.om.ds.dto.MobilePlatformType;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dianbo ruan
 */
@Service
public class FieldNameService {

    protected static final Logger log = LogManager.getLogger();

    private Map<String, String> idNameMap = new ConcurrentHashMap<>();

    private Map<Integer, Integer> placementAdTypeMap = new ConcurrentHashMap<>();

    @Resource
    private OmAdnetworkMapper omAdnetworkMapper;

    @Resource
    private OmPublisherAppMapper omPublisherAppMapper;

    @Resource
    private OmPlacementMapper omPlacementMapper;

    @Resource
    private OmInstanceMapper omInstanceMapper;

    /**
     * Init cache when start and per hour
     */
    @Scheduled(cron = "0 10 */1 * * *")
    @PostConstruct
    public void initCache() {
        this.initIdName();
        this.initAdType();
    }

    public synchronized void initIdName() {
        try {
            List<OmAdnetwork> adNetworks = this.omAdnetworkMapper.select(new OmAdnetworkCriteria());
            adNetworks.forEach(adNetwork -> {
                this.idNameMap.put("adnId" + adNetwork.getId(), adNetwork.getDescn());
                this.idNameMap.put("adnId-1", "In-app Bidding");
            });
            log.info("Init adNetworks size: {}", adNetworks.size());

            List<OmPublisherApp> publisherApps = omPublisherAppMapper.select(new OmPublisherAppCriteria());
            publisherApps.forEach(publisherApp -> {
                String appName = MobilePlatformType.getPlatType(publisherApp.getPlat()).name() + "-" + publisherApp.getAppName();
                this.idNameMap.put("pubAppId" + publisherApp.getId(), appName);
            });
            log.info("Init publisherApps size: {}", publisherApps.size());

            List<OmPlacement> placements = omPlacementMapper.select(new OmPlacementCriteria());
            placements.forEach(placement -> {
                this.idNameMap.put("placementId" + placement.getId(), placement.getName());
            });
            log.info("Init placements size: {}", placements.size());

            List<OmInstanceWithBLOBs> instances = omInstanceMapper.select(new OmInstanceCriteria());
            instances.forEach(instance -> {
                this.idNameMap.put("instanceId" + instance.getId(), instance.getName());
            });
            log.info("Init instances size: {}", instances.size());
        } catch (Exception e) {
            log.error("initIdName error:", e);
        }
    }

    public void fillName(List<JSONObject> results) {
        results.forEach(result -> {
            Integer adnId = result.getInteger("adnId");
            if (adnId != null) {
                result.put("adnName", this.idNameMap.get("adnId" + adnId));
            }

            Integer pubAppId = result.getInteger("pubAppId");
            if (pubAppId != null) {
                result.put("pubAppName", this.idNameMap.get("pubAppId" + pubAppId));
            }

            Integer placementId = result.getInteger("placementId");
            if (placementId != null) {
                result.put("placementName", this.idNameMap.get("placementId" + placementId));
            }

            Integer instanceId = result.getInteger("instanceId");
            if (instanceId != null) {
                result.put("instanceName", this.idNameMap.get("instanceId" + instanceId));
            }

            Integer adType = result.getInteger("adType");
            if (adType != null){
                result.put("adType", AdvertisementType.getAdvertisementType(adType).name());
            }
        });
    }

    private synchronized void initAdType() {
        List<OmPlacement> placements = this.omPlacementMapper.select(new OmPlacementCriteria());
        placements.forEach(placement -> {
            int adType = placement.getAdType();
            placementAdTypeMap.put(placement.getId(), adType);
        });
    }

    public void fillPlacementAdType(List<JSONObject> results) {
        results.forEach(result -> {
            Integer placementId = result.getInteger("placementId");
            if (placementId != null) {
                result.put("adType", this.placementAdTypeMap.get(placementId));
            }
        });
    }
}
