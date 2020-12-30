// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ruandianbo
 * @date 20-9-24
 */
@Service
@Transactional
public class CrossBidService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    private static final String CDN_DOMAIN = "cdn_domain";

    @Resource
    CpCampaignMapper cpCampaignMapper;

    @Resource
    CpCreativeMapper cpCreativeMapper;

    @Resource
    CpMaterialMapper cpMaterialMapper;

    @Resource
    CpCreativeMaterialMapper cpCreativeMaterialMapper;

    @Resource
    CpMaterialAppMapper cpMaterialAppMapper;

    @Resource
    OmUploadMapper omUploadMapper;

    @Resource
    CpCampaignTargetingMapper cpCampaignTargetingMapper;

    @Resource
    CpCampaignBidpriceMapper cpCampaignBidpriceMapper;

    @Resource
    CpTemplateMapper cpTemplateMapper;

    @Resource
    OmAppMapper omAppMapper;

    @Resource
    OmPlacementMapper omPlacementMapper;

    @Autowired
    UtilService utilService;

    public List<JSONObject> getPromoteSelectApps() {
        List<JSONObject> results = new ArrayList<>();
        List<CpCampaign> campaigns = this.getCampaigns();
        if (CollectionUtils.isEmpty(campaigns)) {
            log.info("Campaign does not exist.");
            return results;
        }
        List<String> campaignAppIds = campaigns.stream().map(CpCampaign::getAppId).collect(Collectors.toList());
        OmAppCriteria appCriteria = new OmAppCriteria();
        OmAppCriteria.Criteria criteria = appCriteria.createCriteria();
        criteria.andAppIdIn(campaignAppIds);
        List<OmApp> apps = this.omAppMapper.select(appCriteria);
        for (OmApp app : apps) {
            JSONObject result = new JSONObject();
            result.put("name", app.getName());
            result.put("appId", app.getAppId());
            result.put("plat", app.getPlat());
            result.put("icon", app.getIcon());
            results.add(result);
        }
        return results;
    }

    public JSONObject getCampaign(Integer campaignId) {
        CpCampaign campaign = this.cpCampaignMapper.selectByPrimaryKey(campaignId);
        if (campaign == null) {
            throw new RuntimeException("Campaign " + campaignId + " does not exist!");
        }
        if (!campaign.getPublisherId().equals(this.getCurrentPublisherId())) {
            throw new RuntimeException("Campaign " + campaignId + " does not belong to current publisher!");
        }

        JSONObject result = (JSONObject) JSONObject.toJSON(campaign);
        List<CpCampaignTargeting> targetingList = this.getCampaignTargetingList(campaignId);
        if (CollectionUtils.isEmpty(targetingList)) {
            result.put("targetingList", Collections.EMPTY_LIST);
            result.put("placementTargetingList", Collections.EMPTY_LIST);
        } else {
            List<CpCampaignTargeting> placementTargetingList = new ArrayList<>();
            Iterator<CpCampaignTargeting> iterator = targetingList.iterator();
            while (iterator.hasNext()) {
                CpCampaignTargeting campaignTargeting = iterator.next();
                if (campaignTargeting.getType() == 2) {
                    placementTargetingList.add(campaignTargeting);
                    iterator.remove();
                }
            }
            if (!CollectionUtils.isEmpty(placementTargetingList)) {
                this.fillPlacementPubAppId(placementTargetingList);
            }
            result.put("placementTargetingList", placementTargetingList);
            result.put("targetingList", targetingList);
        }
        result.put("bidPriceList", this.getBidPrices(campaignId));
        result.put("creativeList", this.getCampaignCreatives(campaignId));
        return result;
    }

    private List<CpCreative> getCampaignCreatives(Integer campaignId) {
        List<CpCreative> creatives = this.getCreatives(campaignId);
        if (CollectionUtils.isEmpty(creatives)) {
            return creatives;
        }
        Map<Integer, CpMaterial> materialMap = this.getMaterialMap();
        Map<Integer, List<Integer>> creativeMaterialIdsMap = this.getCreativeMaterialIdsMap(creatives);
        for (CpCreative creative : creatives) {
            List<Integer> creativeMaterialIds = creativeMaterialIdsMap.get(creative.getId());
            if (CollectionUtils.isEmpty(creativeMaterialIds)) {
                continue;
            }
            List<CpMaterial> cpMaterials = new ArrayList<>();
            for (Integer creativeMaterialId : creativeMaterialIds) {
                CpMaterial material = materialMap.get(creativeMaterialId);
                if (material == null) {
                    throw new RuntimeException("Material id " + creativeMaterialId + " does not exist!");
                }
                cpMaterials.add(material);
            }
            creative.setCpMaterials(cpMaterials.toArray(new CpMaterial[0]));
        }
        return creatives;
    }

    private Map<Integer, List<Integer>> getCreativeMaterialIdsMap(List<CpCreative> creatives) {
        Map<Integer, List<Integer>> creativeMaterialIdsMap = new HashMap<>();
        if (CollectionUtils.isEmpty(creatives)) {
            return creativeMaterialIdsMap;
        }
        List<Integer> creativeIds = new ArrayList<>();
        creatives.forEach(creative -> creativeIds.add(creative.getId()));
        CpCreativeMaterialCriteria creativeMaterialCriteria = new CpCreativeMaterialCriteria();
        CpCreativeMaterialCriteria.Criteria criteria = creativeMaterialCriteria.createCriteria();
        criteria.andCreativeIdIn(creativeIds);
        List<CpCreativeMaterial> creativeMaterials = this.cpCreativeMaterialMapper.select(creativeMaterialCriteria);

        if (CollectionUtils.isEmpty(creativeMaterials)) {
            return creativeMaterialIdsMap;
        }
        for (CpCreativeMaterial creativeMaterial : creativeMaterials) {
            List<Integer> materialIds = creativeMaterialIdsMap.computeIfAbsent(creativeMaterial.getCreativeId(), k -> new ArrayList<>());
            materialIds.add(creativeMaterial.getMaterialId());
        }
        return creativeMaterialIdsMap;
    }

    private void fillPlacementPubAppId(List<CpCampaignTargeting> placementTargetingList) {
        if (CollectionUtils.isEmpty(placementTargetingList)){
            return;
        }
        List<Integer> placementIds = new ArrayList<>();
        placementTargetingList.forEach(targeting -> placementIds.add(Integer.parseInt(targeting.getContent())));
        OmPlacementCriteria placementCriteria = new OmPlacementCriteria();
        OmPlacementCriteria.Criteria criteria = placementCriteria.createCriteria();
        criteria.andIdIn(placementIds);
        List<OmPlacementWithBLOBs> placements = this.omPlacementMapper.selectWithBLOBs(placementCriteria);
        Map<Integer, OmPlacementWithBLOBs> placementMap = new HashMap<>();
        placements.forEach(placement -> placementMap.put(placement.getId(), placement));
        placementTargetingList.forEach(targeting -> {
            OmPlacementWithBLOBs placement = placementMap.get(Integer.parseInt(targeting.getContent()));
            if (placement == null) {
                throw new RuntimeException("Placement id " + targeting.getContent() + " does not exist!");
            }
            targeting.setPubAppId(placement.getPubAppId());
        });
    }

    private List<CpCampaignTargeting> getCampaignTargetingList(Integer campaignId) {
        CpCampaignTargetingCriteria targetingCriteria = new CpCampaignTargetingCriteria();
        CpCampaignTargetingCriteria.Criteria criteria = targetingCriteria.createCriteria();
        criteria.andCampaignIdEqualTo(campaignId);
        return cpCampaignTargetingMapper.select(targetingCriteria);
    }

    private List<CpCampaignBidprice> getBidPrices(Integer campaignId) {
        CpCampaignBidpriceCriteria bidPriceCriteria = new CpCampaignBidpriceCriteria();
        CpCampaignBidpriceCriteria.Criteria criteria = bidPriceCriteria.createCriteria();
        criteria.andCampaignIdEqualTo(campaignId);
        return this.cpCampaignBidpriceMapper.select(bidPriceCriteria);
    }

    private Set<Integer> getBigPriceSet(Integer campaignId) {
        List<CpCampaignBidprice> bidPrices = this.getBidPrices(campaignId);
        Set<Integer> bidPricesIdSet = new HashSet<>();
        bidPrices.forEach(bidPrice -> bidPricesIdSet.add(bidPrice.getId()));
        return bidPricesIdSet;
    }

    public List<CpCampaign> getCampaigns() {
        CpCampaignCriteria campaignCriteria = new CpCampaignCriteria();
        CpCampaignCriteria.Criteria criteria = campaignCriteria.createCriteria();
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        criteria.andStatusNotEqualTo((byte) NormalStatus.Deleted.ordinal());
        return this.cpCampaignMapper.selectWithBLOBs(campaignCriteria);
    }

    public void createCampaign(CpCampaign campaign) {
        campaign.setPublisherId(this.getCurrentPublisherId());
        int result = this.cpCampaignMapper.insertSelective(campaign);
        if (result <= 0) {
            throw new RuntimeException("Create campaign failed!" + JSONObject.toJSON(campaign));
        }

        if (campaign.getOpenType() != null && campaign.getOpenType() > 0){
            OmAppWithBLOBs promoteApp = campaign.getPromoteApp();
            if (promoteApp != null){
                OmAppCriteria appCriteria = new OmAppCriteria();
                OmAppCriteria.Criteria criteria = appCriteria.createCriteria();
                criteria.andAppIdEqualTo(promoteApp.getAppId());
                List<OmApp> apps = this.omAppMapper.select(appCriteria);
                if (CollectionUtils.isEmpty(apps)) {
                    result = this.omAppMapper.insertSelective(promoteApp);
                    if (result <= 0) {
                        throw new RuntimeException("Create promoteApp failed!" + JSONObject.toJSON(campaign));
                    }
                }
            }
        }

        CpCampaignTargeting[] targetingList = campaign.getTargetingList();
        if (targetingList != null && targetingList.length > 0) {
            for (CpCampaignTargeting targeting : targetingList) {
                targeting.setId(null);
                targeting.setCampaignId(campaign.getId());
                this.createTargeting(targeting);
            }
        }

        CpCampaignTargeting[] placementTargetingList = campaign.getPlacementTargetingList();
        if (placementTargetingList != null && placementTargetingList.length > 0) {
            for (CpCampaignTargeting placementTargeting : placementTargetingList) {
                placementTargeting.setId(null);
                placementTargeting.setCampaignId(campaign.getId());
                this.createTargeting(placementTargeting);
            }
        }

        CpCampaignBidprice[] bigPriceList = campaign.getBidPriceList();
        if (bigPriceList != null && bigPriceList.length > 0) {
            for (CpCampaignBidprice bigPrice : bigPriceList) {
                bigPrice.setId(null);
                bigPrice.setCampaignId(campaign.getId());
                this.createUpdateBidPrice(bigPrice);
            }
        }

        CpCreative[] creativeList = campaign.getCreativeList();
        if (creativeList != null && creativeList.length > 0) {
            for (CpCreative creative : creativeList) {
                creative.setCampaignId(campaign.getId());
                this.createCreative(creative);
            }
        }
        log.info("Create campaign {} successfully.", JSONObject.toJSON(campaign));
    }

    public void updateCampaign(CpCampaign campaign) {
        campaign.setPublisherId(this.getCurrentPublisherId());
        int result = this.cpCampaignMapper.updateByPrimaryKeyWithBLOBs(campaign);
        if (result <= 0) {
            throw new RuntimeException("Update campaign failed!" + JSONObject.toJSON(campaign));
        }
        this.updateCampaignTargeting(campaign);
        this.updateCampaignBidPrice(campaign);

        Map<Integer, CpCreative> creativeMap = this.getCreativeMap(campaign.getId());
        CpCreative[] creativeList = campaign.getCreativeList();
        if (creativeList != null && creativeList.length > 0) {
            List<CpCreative> creatives = new ArrayList<>();
            Collections.addAll(creatives, creativeList);
            Map<Integer, List<Integer>> creativeMaterialIdsMap = this.getCreativeMaterialIdsMap(creatives);

            for (CpCreative creative : creativeList) {
                creative.setCampaignId(campaign.getId());
                if (creative.getId() == null || creative.getId() < 0) {
                    this.createCreative(creative);
                } else {
                    List<Integer> creativeMaterialIds = creativeMaterialIdsMap.get(creative.getId());
                    this.updateCreative(creative, creativeMaterialIds);
                    creativeMap.remove(creative.getId());
                }
            }
        }
        if (!CollectionUtils.isEmpty(creativeMap)) {
            for (CpCreative creative : creativeMap.values()) {
                result = this.cpCreativeMapper.deleteByPrimaryKey(creative.getId());
                if (result <= 0) {
                    throw new RuntimeException("Clear creative failed! " + JSONObject.toJSON(creative));
                }
            }
        }
        log.info("Update campaign {} successfully.", campaign.getId());
    }

    public void updateCampaignTargeting(CpCampaign campaign) {
        this.cpCampaignTargetingMapper.deleteByCampaignId(campaign.getId());
        CpCampaignTargeting[] targetingList = campaign.getTargetingList();
        if (targetingList != null && targetingList.length > 0) {
            for (CpCampaignTargeting targeting : targetingList) {
                targeting.setCampaignId(campaign.getId());
                this.createTargeting(targeting);
            }
        }

        CpCampaignTargeting[] placementTargetingList = campaign.getPlacementTargetingList();
        if (placementTargetingList != null && placementTargetingList.length > 0) {
            for (CpCampaignTargeting targeting : placementTargetingList) {
                targeting.setCampaignId(campaign.getId());
                this.createTargeting(targeting);
            }
        }
    }

    public void updateCampaignBidPrice(CpCampaign campaign) {
        Set<Integer> dbBidPricesIdSet = this.getBigPriceSet(campaign.getId());
        Set<Integer> bidPricesIdSet = new HashSet<>();
        CpCampaignBidprice[] bidPriceList = campaign.getBidPriceList();
        if (bidPriceList != null && bidPriceList.length > 0) {
            for (CpCampaignBidprice bidPrice : bidPriceList) {
                if (bidPrice.getId() != null && bidPrice.getId() >= 0) {
                    bidPricesIdSet.add(bidPrice.getId());
                }
                bidPrice.setCampaignId(campaign.getId());
                this.createUpdateBidPrice(bidPrice);
            }
        }

        if (CollectionUtils.isEmpty(dbBidPricesIdSet)) {
            return;
        }
        dbBidPricesIdSet.removeAll(bidPricesIdSet);
        for (Integer bidPriceId : dbBidPricesIdSet) {
            this.cpCampaignBidpriceMapper.deleteByPrimaryKey(bidPriceId);
        }
    }

    public void updateCampaignStatus(Integer campaignId, NormalStatus status) {
        CpCampaign campaign = this.cpCampaignMapper.selectByPrimaryKey(campaignId);
        if (campaign.getStatus() == status.ordinal()) {
            return;
        }
        campaign.setStatus((byte) status.ordinal());
        int result = this.cpCampaignMapper.updateByPrimaryKeySelective(campaign);
        if (result <= 0) {
            throw new RuntimeException("Update campaign failed!" + JSONObject.toJSON(campaign));
        }
    }

    private void createTargeting(CpCampaignTargeting targeting) {
        targeting.setCreateTime(new Date());
        targeting.setLastmodify(new Date());
        int result = this.cpCampaignTargetingMapper.insertSelective(targeting);
        if (result <= 0) {
            throw new RuntimeException("Create campaign targeting failed!" + JSONObject.toJSON(targeting));
        }
    }

    private void createUpdateBidPrice(CpCampaignBidprice bidPrice) {
        if (bidPrice.getBidprice() != null && bidPrice.getId() != null && bidPrice.getId() > 0) {
            bidPrice.setCreateTime(null);
            bidPrice.setLastmodify(null);
            int result = this.cpCampaignBidpriceMapper.updateByPrimaryKeySelective(bidPrice);
            if (result <= 0) {
                throw new RuntimeException("Update campaign bid price failed!" + JSONObject.toJSON(bidPrice));
            }
        } else {
            bidPrice.setCreateTime(new Date());
            bidPrice.setLastmodify(new Date());
            int result = this.cpCampaignBidpriceMapper.insertSelective(bidPrice);
            if (result <= 0) {
                throw new RuntimeException("Create campaign bid price failed!" + JSONObject.toJSON(bidPrice));
            }
        }
    }

    public CpCreative getCreative(Integer creativeId) {
        return this.cpCreativeMapper.selectByPrimaryKey(creativeId);
    }

    public List<CpCreative> getCreatives() {
        return this.getCreatives(null);
    }

    public List<CpCreative> getCreatives(Integer campaignId) {
        CpCreativeCriteria creativeCriteria = new CpCreativeCriteria();
        CpCreativeCriteria.Criteria criteria = creativeCriteria.createCriteria();
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        if (campaignId != null) {
            criteria.andCampaignIdEqualTo(campaignId);
        }
        return this.cpCreativeMapper.selectWithBLOBs(creativeCriteria);
    }

    public Map<Integer, CpCreative> getCreativeMap(Integer campaignId) {
        List<CpCreative> cpCreatives = this.getCreatives(campaignId);
        Map<Integer, CpCreative> creativeMap = new HashMap<>();
        cpCreatives.forEach(creative -> creativeMap.put(creative.getId(), creative));
        return creativeMap;
    }

    public void createCreative(CpCreative creative) {
        creative.setPublisherId(this.getCurrentPublisherId());
        int result = this.cpCreativeMapper.insertSelective(creative);
        if (result <= 0) {
            throw new RuntimeException("Create creative failed!" + JSONObject.toJSON(creative));
        }
        CpMaterial[] cpMaterials = creative.getCpMaterials();
        if (cpMaterials == null || cpMaterials.length <= 0) {
            return;
        }
        for (CpMaterial cpMaterial : cpMaterials) {
            this.createUpdateMaterial(creative, cpMaterial, null);
        }
    }

    public void updateCreative(CpCreative creative, List<Integer> creativeMaterialIds) {
        creative.setPublisherId(this.getCurrentPublisherId());
        int result = this.cpCreativeMapper.updateByPrimaryKeyWithBLOBs(creative);
        if (result <= 0) {
            throw new RuntimeException("Update creative failed! " + JSONObject.toJSON(creative));
        }
        CpMaterial[] cpMaterials = creative.getCpMaterials();
        if (cpMaterials == null || cpMaterials.length <= 0) {
            return;
        }
        Set<Integer> materialIdSet = new HashSet<>();
        for (CpMaterial cpMaterial : cpMaterials) {
            this.createUpdateMaterial(creative, cpMaterial, materialIdSet);
        }
        if (CollectionUtils.isEmpty(creativeMaterialIds)) {
            return;
        }
        creativeMaterialIds.removeAll(materialIdSet);
        for (Integer materialId : creativeMaterialIds) {
            CpCreativeMaterial key = new CpCreativeMaterial();
            key.setCreativeId(creative.getId());
            key.setMaterialId(materialId);
            result = this.cpCreativeMaterialMapper.deleteByPrimaryKey(key);
            if (result <= 0) {
                throw new RuntimeException("Delete creative material failed! Id:" + materialId);
            }
        }
    }

    private void createUpdateMaterial(CpCreative creative, CpMaterial cpMaterial, Set<Integer> materialIdSet) {
        if (cpMaterial.getId() == null || cpMaterial.getId() < 0) {
            int result = this.cpMaterialMapper.insert(cpMaterial);
            if (result <= 0) {
                throw new RuntimeException("Create material failed!" + JSONObject.toJSON(creative));
            }
            CpCreativeMaterial creativeMaterial = new CpCreativeMaterial();
            creativeMaterial.setCreativeId(creative.getId());
            creativeMaterial.setMaterialId(cpMaterial.getId());
            result = this.cpCreativeMaterialMapper.insertSelective(creativeMaterial);
            if (result <= 0) {
                throw new RuntimeException("Create creative " + creative.getId() + " material " + cpMaterial.getId() + " relation failed!");
            }
        } else {
            if (materialIdSet != null) {
                materialIdSet.add(cpMaterial.getId());
            }
            CpCreativeMaterial key = new CpCreativeMaterial();
            key.setCreativeId(creative.getId());
            key.setMaterialId(cpMaterial.getId());
            CpCreativeMaterial creativeMaterial = this.cpCreativeMaterialMapper.selectByPrimaryKey(key);
            if (creativeMaterial == null) {
                int result = this.cpCreativeMaterialMapper.insertSelective(key);
                if (result <= 0) {
                    throw new RuntimeException("Create creative " + creative.getId() + " material " + cpMaterial.getId() + " relation failed!");
                }
            }
        }
    }

    public CpMaterial getMaterial(Integer materialId) {
        CpMaterial cpMaterial = this.cpMaterialMapper.selectByPrimaryKey(materialId);
        cpMaterial.setUrl("//" + this.utilService.getOmDictValue(CDN_DOMAIN) + cpMaterial.getUrl());
        return cpMaterial;
    }

    public List<CpMaterial> getMaterials(String appId) {
        return this.getMaterials(appId, null);
    }

    public List<CpMaterial> getMaterials(String appId, String md5sum) {
        CpMaterialCriteria materialCriteria = new CpMaterialCriteria();
        CpMaterialCriteria.Criteria criteria = materialCriteria.createCriteria();
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        if (!StringUtils.isEmpty(appId)) {
            List<CpMaterialApp> materialApps = this.getMaterialApp(appId);
            List<Integer> materialIds = new ArrayList<>();
            materialApps.forEach(materialApp -> materialIds.add(materialApp.getMaterialId()));
            if (CollectionUtils.isEmpty(materialIds)) {
                return new ArrayList<>();
            }
            criteria.andIdIn(materialIds);
        }
        if (!StringUtils.isEmpty(md5sum)) {
            criteria.andMd5sumEqualTo(md5sum);
        }
        List<CpMaterial> cpMaterialList = this.cpMaterialMapper.select(materialCriteria);
        cpMaterialList.forEach(cpMaterial -> cpMaterial.setUrl("//" + this.utilService.getOmDictValue(CDN_DOMAIN) + cpMaterial.getUrl()));
        return cpMaterialList;
    }

    private List<CpMaterialApp> getMaterialApp(String appId) {
        CpMaterialAppCriteria materialAppCriteria = new CpMaterialAppCriteria();
        CpMaterialAppCriteria.Criteria criteria = materialAppCriteria.createCriteria();
        criteria.andAppIdEqualTo(appId);
        return this.cpMaterialAppMapper.select(materialAppCriteria);
    }

    private Map<Integer, CpMaterial> getMaterialMap() {
        List<CpMaterial> materials = this.getMaterials(null);
        Map<Integer, CpMaterial> materialMap = new HashMap<>();
        materials.forEach(material -> materialMap.put(material.getId(), material));
        return materialMap;
    }

    public List<OmUpload> getUploads(String md5) {
        OmUploadCriteria uploadCriteria = new OmUploadCriteria();
        OmUploadCriteria.Criteria criteria = uploadCriteria.createCriteria();
        criteria.andMd5FileEqualTo(md5);
        return this.omUploadMapper.select(uploadCriteria);
    }

    public void addUpload(OmUpload upload) {
        int result = this.omUploadMapper.insertSelective(upload);
        if (result <= 0) {
            throw new RuntimeException("Create upload failed!" + JSONObject.toJSON(upload));
        }
    }

    public CpMaterial createMaterial(CpMaterial material) {
        List<CpMaterial> md5sumMaterials = this.getMaterials(null, material.getMd5sum());
        if (CollectionUtils.isEmpty(md5sumMaterials)) {
            material.setPublisherId(this.getCurrentPublisherId());
            int result = this.cpMaterialMapper.insertSelective(material);
            if (result <= 0) {
                throw new RuntimeException("Create material failed!" + JSONObject.toJSON(material));
            }
        } else {
            material = md5sumMaterials.get(0);
        }

        this.createMaterialApp(material.getId(), material.getAppId());
        material.setUrl("//" + this.utilService.getOmDictValue(CDN_DOMAIN) + material.getUrl());
        return material;
    }

    public void createMaterialApp(Integer materialId, String appId) {
        CpMaterialAppKey key = new CpMaterialAppKey();
        key.setMaterialId(materialId);
        key.setAppId(appId);
        CpMaterialApp materialApp = this.cpMaterialAppMapper.selectByPrimaryKey(key);
        if (materialApp == null) {
            materialApp = new CpMaterialApp();
            materialApp.setMaterialId(materialId);
            materialApp.setAppId(appId);
            int result = this.cpMaterialAppMapper.insertSelective(materialApp);
            if (result <= 0) {
                throw new RuntimeException("Create material " + materialId + " app id " + appId + " failed!");
            }
        }
    }

    public List<CpTemplate> getCpTemplateList() {
        CpTemplateCriteria templateCriteria = new CpTemplateCriteria();
        CpTemplateCriteria.Criteria criteria = templateCriteria.createCriteria();
        criteria.andStatusEqualTo((byte) SwitchStatus.ON.ordinal());
        return this.cpTemplateMapper.select(templateCriteria);
    }
}
