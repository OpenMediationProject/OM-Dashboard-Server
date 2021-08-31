// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.*;
import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Report base
 *
 * @author dianbo ruan
 * @date 20210819
 */
public class ReportBaseService extends BaseService{

    public static final String ADN_ID = "adnId";

    public static final String PUB_APP_ID = "pubAppId";

    public static final String PLACEMENT_ID = "placementId";

    public static final String INSTANCE_ID = "instanceId";

    @Resource
    StatDauMapper statDauMapper;

    @Resource
    StatDauInstanceMapper statDauInstanceMapper;

    @Resource
    StatDauPlacementMapper statDauPlacementMapper;

    @Resource
    StatDauAdnPlacementMapper statDauAdnPlacementMapper;

    @Resource
    StatDauAdnMapper statDauAdnMapper;

    @Resource
    StatLrMapper statLrMapper;

    @Resource
    StatAdnetworkMapper statAdnetworkMapper;

    @Resource
    StatCpMapper statCpMapper;

    @Resource
    OmPlacementRuleMapper omPlacementRuleMapper;

    protected Map<Integer,String> getRuleCountries(List<Integer> ruleIds){
        if (CollectionUtils.isEmpty(ruleIds)){
            return new HashMap<>();
        }
        OmPlacementRuleCriteria ruleCriteria = new OmPlacementRuleCriteria();
        OmPlacementRuleCriteria.Criteria criteria = ruleCriteria.createCriteria();
        criteria.andIdIn(ruleIds);
        List<OmPlacementRule> rules = omPlacementRuleMapper.select(ruleCriteria);
        Map<Integer,String> ruleCountriesMap = new HashMap<>();
        for (OmPlacementRule rule : rules) {
            String country = rule.getCountries();
            if (StringUtils.isNotBlank(country)) {
                ruleCountriesMap.put(rule.getId(), country);
            }
        }
        return ruleCountriesMap;
    }

    /**
     * Build date/dimension/group by clause conditions
     *
     * @param reportConditionDTO
     */
    protected Map<String, Object> buildDauConditionMap(ReportConditionDTO reportConditionDTO) {
        String[] dimensions = reportConditionDTO.getDimension();
        Map<String, Object> conditionMap = new HashMap<>();
        if (dimensions != null && dimensions.length > 0) {
            for (String dimension : dimensions) {
                conditionMap.put("dimension_" + dimension, dimension);
            }
        }
        return conditionMap;
    }

    /**
     * Build date/dimension/group by clause conditions
     *
     * @param reportConditionDTO
     */
    protected Map<String, Object> buildConditionMap(ReportConditionDTO reportConditionDTO) {
        String[] dimensions = reportConditionDTO.getDimension();
        Map<String, Object> conditionMap = new HashMap<>();
        if (dimensions != null && dimensions.length > 0) {
            for (String dimension : dimensions) {
                conditionMap.put("dimension_" + dimension, dimension);
            }
        }
        if (conditionMap.containsKey("dimension_adnId") && (reportConditionDTO.getBid() == null || reportConditionDTO.getBid().length == 0)) {
            conditionMap.put("dimension_show_inapp_bid", "dimension_show_inapp_bid");
            conditionMap.remove("dimension_adnId");
        }
        return conditionMap;
    }

    /**
     * Set publisher and publisher app which current user could view
     *
     * @param reportConditionDTO
     */
    protected void handleDataPermissions(ReportConditionDTO reportConditionDTO) {
        Integer[] publisherIdArr = new Integer[1];
        publisherIdArr[0] = this.getCurrentPublisherId();
        reportConditionDTO.setPublisherId(publisherIdArr);

        List<Integer> appIdsOfCurrentUser = this.getAppIdsOfCurrentUser();
        Set<Integer> appIdsOfCurrentUserSet = new HashSet<>(appIdsOfCurrentUser);
        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            publisherAppIds.removeIf(o -> !appIdsOfCurrentUserSet.contains(o));
            if (!CollectionUtils.isEmpty(publisherAppIds)) {
                Integer[] publisherAppIdArr = new Integer[publisherAppIds.size()];
                publisherAppIds.toArray(publisherAppIdArr);
                reportConditionDTO.setPubAppId(publisherAppIdArr);
            }
        } else {
            Integer[] publisherAppIdArr = new Integer[appIdsOfCurrentUser.size()];
            appIdsOfCurrentUser.toArray(publisherAppIdArr);
            reportConditionDTO.setPubAppId(publisherAppIdArr);
        }
    }

    /**
     * Get adn placement deu report
     *
     * @param reportConditionDTO
     */
    public List<StatDauAdn> getAdnDauReport(ReportConditionDTO reportConditionDTO, Map<String, Object> conditionMap) {
        StatDauAdnCriteria statDauCriteria = new StatDauAdnCriteria();
        StatDauAdnCriteria.Criteria criteria = statDauCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> adnIds = Util.buildIntegerList(reportConditionDTO.getAdnId());
        if (!CollectionUtils.isEmpty(adnIds)) {
            criteria.andAdnIdIn(adnIds);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statDauCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statDauCriteria.getOredCriteria());
        }
        statDauCriteria.setOrderByClause(" day desc ");
        conditionMap.put("orderByClause", statDauCriteria.getOrderByClause());

        List<StatDauAdn> statAdnDauSummary = this.statDauAdnMapper.selectSummary(conditionMap);
        log.info("Get adn DAU summary size {} condition {}", statAdnDauSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statAdnDauSummary;
    }


    /**
     * Get adn placement deu report
     *
     * @param reportConditionDTO
     */
    public List<StatDauAdnPlacement> getAdnPlacementDauReport(ReportConditionDTO reportConditionDTO, Map<String, Object> conditionMap) {
        StatDauAdnPlacementCriteria statDauCriteria = new StatDauAdnPlacementCriteria();
        StatDauAdnPlacementCriteria.Criteria criteria = statDauCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        } else {
            criteria.andPlacementIdGreaterThan(0);
        }

        List<Integer> adnIds = Util.buildIntegerList(reportConditionDTO.getAdnId());
        if (!CollectionUtils.isEmpty(adnIds)) {
            criteria.andAdnIdIn(adnIds);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statDauCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statDauCriteria.getOredCriteria());
        }
        statDauCriteria.setOrderByClause(" day desc ");
        conditionMap.put("orderByClause", statDauCriteria.getOrderByClause());

        List<StatDauAdnPlacement> statAdnPlacementDauSummary = this.statDauAdnPlacementMapper.selectSummary(conditionMap);
        log.info("Get adn placement DAU summary size {} condition {}", statAdnPlacementDauSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statAdnPlacementDauSummary;
    }

    /**
     * Get instance deu report
     *
     * @param reportConditionDTO
     */
    public List<StatDauPlacement> getPlacementDauReport(ReportConditionDTO reportConditionDTO, Map<String, Object> conditionMap) {
        StatDauPlacementCriteria statDauCriteria = new StatDauPlacementCriteria();
        StatDauPlacementCriteria.Criteria criteria = statDauCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        } else {
            criteria.andPlacementIdGreaterThan(0);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statDauCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statDauCriteria.getOredCriteria());
        }
        statDauCriteria.setOrderByClause(" day desc ");
        conditionMap.put("orderByClause", statDauCriteria.getOrderByClause());

        List<StatDauPlacement> statPlacementDauSummary = this.statDauPlacementMapper.selectSummary(conditionMap);
        log.info("Get placement DAU summary size {} condition {}", statPlacementDauSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statPlacementDauSummary;
    }

    /**
     * Get instance deu report
     *
     * @param reportConditionDTO
     */
    public List<StatDauInstance> getInstanceDauReport(ReportConditionDTO reportConditionDTO, Map<String, Object> conditionMap) {
        StatDauInstanceCriteria statDauCriteria = new StatDauInstanceCriteria();
        StatDauInstanceCriteria.Criteria criteria = statDauCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        }

        List<Integer> instanceIds = Util.buildIntegerList(reportConditionDTO.getInstanceId());
        if (!CollectionUtils.isEmpty(instanceIds)) {
            criteria.andInstanceIdIn(instanceIds);
        }

        List<Integer> adnIds = Util.buildIntegerList(reportConditionDTO.getAdnId());
        if (!CollectionUtils.isEmpty(adnIds)) {
            criteria.andAdnIdIn(adnIds);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statDauCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statDauCriteria.getOredCriteria());
        }
        statDauCriteria.setOrderByClause(" day desc ");
        conditionMap.put("orderByClause", statDauCriteria.getOrderByClause());

        List<StatDauInstance> statInstanceDauSummary = this.statDauInstanceMapper.selectSummary(conditionMap);
        log.info("Get instance DAU summary size {} condition {}", statInstanceDauSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statInstanceDauSummary;
    }

    /**
     * Get app deu report
     *
     * @param reportConditionDTO
     */
    public List<StatDau> getAppDauReport(ReportConditionDTO reportConditionDTO, Map<String, Object> conditionMap) {
        StatDauCriteria statDauCriteria = new StatDauCriteria();
        StatDauCriteria.Criteria criteria = statDauCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statDauCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statDauCriteria.getOredCriteria());
        }
        statDauCriteria.setOrderByClause(" day desc ");
        conditionMap.put("orderByClause", statDauCriteria.getOrderByClause());

        List<StatDau> statDauSummary = this.statDauMapper.selectSummary(conditionMap);
        log.info("Get DAU summary size {} condition {}", statDauSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statDauSummary;
    }

    /**
     * Get LR report
     *
     * @param reportConditionDTO
     */
    public List<StatLr> getLrReport(ReportConditionDTO reportConditionDTO) {
        Map<String, Object> conditionMap = this.buildConditionMap(reportConditionDTO);
        StatLrCriteria statLrCriteria = new StatLrCriteria();
        StatLrCriteria.Criteria criteria = statLrCriteria.createCriteria();
        if (reportConditionDTO.getHourBegin() != null) {
            criteria.andDayHourGreaterThanOrEqualTo(reportConditionDTO.getDateBegin(), reportConditionDTO.getHourBegin());
        } else {
            criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        }
        if (reportConditionDTO.getHourEnd() != null) {
            criteria.andDayHourLessThanOrEqualTo(reportConditionDTO.getDateEnd(), reportConditionDTO.getHourEnd());
        } else {
            criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));
        }

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        }

        List<Integer> instanceIds = Util.buildIntegerList(reportConditionDTO.getInstanceId());
        if (!CollectionUtils.isEmpty(instanceIds)) {
            criteria.andInstanceIdIn(instanceIds);
        }

        List<Integer> sceneIds = Util.buildIntegerList(reportConditionDTO.getSceneId());
        if (!CollectionUtils.isEmpty(sceneIds)) {
            criteria.andSceneIdIn(sceneIds);
        }

        List<Integer> adnIds = Util.buildIntegerList(reportConditionDTO.getAdnId());
        if (!CollectionUtils.isEmpty(adnIds)) {
            criteria.andAdnIdIn(adnIds);
        }

        List<Integer> ruleIds = Util.buildIntegerList(reportConditionDTO.getRuleId());
        if (!CollectionUtils.isEmpty(ruleIds)) {
            criteria.andRuleIdIn(ruleIds);
        }

        List<Byte> abts = Util.buildByteList(reportConditionDTO.getAbt());
        if (!CollectionUtils.isEmpty(abts)) {
            criteria.andAbtIn(abts);
        }

        List<Byte> bids = Util.buildByteList(reportConditionDTO.getBid());
        if (!CollectionUtils.isEmpty(bids)) {
            criteria.andBidIn(bids);
        }

        List<String> appVersions = Util.buildStringList(reportConditionDTO.getAppVersion());
        if (!CollectionUtils.isEmpty(appVersions)) {
            criteria.andAppVersionIn(appVersions);
        }

        List<String> sdkVersions = Util.buildStringList(reportConditionDTO.getSdkVersion());
        if (!CollectionUtils.isEmpty(sdkVersions)) {
            criteria.andSdkVersionIn(sdkVersions);
        }

        if (!StringUtils.isEmpty(reportConditionDTO.getOsVersion())) {
            String osVersion = reportConditionDTO.getOsVersion();
            String[] osVersionArr = reportConditionDTO.getOsVersion().replace("[", "").replace("]", "")
                    .replace("(", "").replace(")", "").split(",");
            if (osVersionArr.length >= 2){
                String minOsVersion = osVersionArr[0];
                String maxOsVersion = osVersionArr[1];
                if (osVersion.startsWith("[")){
                    criteria.andOsVersionGreaterThanOrEqualTo(minOsVersion);
                }
                if (osVersion.startsWith("(")){
                    criteria.andOsVersionGreaterThan(maxOsVersion);
                }
                if (osVersion.endsWith("]")){
                    criteria.andOsVersionLessThanOrEqualTo(maxOsVersion);
                }
                if (osVersion.endsWith(")")){
                    criteria.andOsVersionLessThan(maxOsVersion);
                }
            }
        }

        if (!CollectionUtils.isEmpty(statLrCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statLrCriteria.getOredCriteria());
        }
        List<StatLr> statLrSummary = this.statLrMapper.selectSummary(conditionMap);
        log.info("Get LR summary size {} condition {}", statLrSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statLrSummary;
    }

    /**
     * Get revenue report
     *
     * @param reportConditionDTO
     */
    public List<StatAdnetwork> getAdNetworkReport(ReportConditionDTO reportConditionDTO) {
        Map<String, Object> conditionMap = this.buildConditionMap(reportConditionDTO);
        StatAdnetworkCriteria statAdnetworkCriteria = new StatAdnetworkCriteria();
        StatAdnetworkCriteria.Criteria criteria = statAdnetworkCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<Byte> platforms = Util.buildByteList(reportConditionDTO.getPlatform());
        if (!CollectionUtils.isEmpty(platforms)) {
            criteria.andPlatformIn(platforms);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        }

        List<Integer> instanceIds = Util.buildIntegerList(reportConditionDTO.getInstanceId());
        if (!CollectionUtils.isEmpty(instanceIds)) {
            criteria.andInstanceIdIn(instanceIds);
        }

        List<Integer> adnIds = Util.buildIntegerList(reportConditionDTO.getAdnId());
        if (!CollectionUtils.isEmpty(adnIds)) {
            criteria.andAdnIdIn(adnIds);
        }

        List<Byte> abts = Util.buildByteList(reportConditionDTO.getAbt());
        if (!CollectionUtils.isEmpty(abts)) {
            criteria.andAbtIn(abts);
        }

        List<Byte> bids = Util.buildByteList(reportConditionDTO.getBid());
        if (!CollectionUtils.isEmpty(bids)) {
            criteria.andBidIn(bids);
        }

        statAdnetworkCriteria.setOrderByClause(" day desc ");
        if (!CollectionUtils.isEmpty(statAdnetworkCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statAdnetworkCriteria.getOredCriteria());
        }
        conditionMap.put("orderByClause", statAdnetworkCriteria.getOrderByClause());
        List<StatAdnetwork> statAdNetworkSummary = this.statAdnetworkMapper.selectSummary(conditionMap);
        log.info("Get adNetwork summary size {} condition {}", statAdNetworkSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statAdNetworkSummary;
    }

    public List<StatCp> getCrossBidReport(ReportConditionDTO reportConditionDTO) {
        this.handleDataPermissions(reportConditionDTO);
        Map<String, Object> conditionMap = this.buildConditionMap(reportConditionDTO);
        StatCpCriteria statCpCriteria = new StatCpCriteria();
        StatCpCriteria.Criteria criteria = statCpCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateBegin()));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(reportConditionDTO.getDateEnd()));

        List<Integer> publisherIds = Util.buildIntegerList(reportConditionDTO.getPublisherId());
        if (!CollectionUtils.isEmpty(publisherIds)) {
            criteria.andPublisherIdIn(publisherIds);
        }

        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            criteria.andPubAppIdIn(publisherAppIds);
        }

        List<String> countries = Util.buildStringList(reportConditionDTO.getCountry());
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<Integer> placementIds = Util.buildIntegerList(reportConditionDTO.getPlacementId());
        if (!CollectionUtils.isEmpty(placementIds)) {
            criteria.andPlacementIdIn(placementIds);
        }

        List<Integer> creativeIds = Util.buildIntegerList(reportConditionDTO.getCreativeId());
        if (!CollectionUtils.isEmpty(creativeIds)) {
            criteria.andCreativeIdIn(creativeIds);
        }

        statCpCriteria.setOrderByClause(" day desc ");
        if (!CollectionUtils.isEmpty(statCpCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statCpCriteria.getOredCriteria());
        }
        conditionMap.put("orderByClause", statCpCriteria.getOrderByClause());
        List<StatCp> statStatCpSummary = this.statCpMapper.selectSummary(conditionMap);
        log.info("Get adNetwork summary size {} condition {}", statStatCpSummary.size(), JSONObject.toJSONString(reportConditionDTO));
        return statStatCpSummary;
    }
}
