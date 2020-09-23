// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.StatAdnetworkMapper;
import com.adtiming.om.ds.dao.StatDauMapper;
import com.adtiming.om.ds.dao.StatLrMapper;
import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Report Manager
 *
 * @author dianbo ruan
 */
@Service
public class ReportService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    @Resource
    private StatDauMapper statDauMapper;

    @Resource
    private StatLrMapper statLrMapper;

    @Resource
    private StatAdnetworkMapper statAdnetworkMapper;

    @Autowired
    private FieldNameService fieldNameService;

    /**
     * Get dau lr revenue reports
     *
     * @param reportConditionDTO
     * @param reportTypeSet
     */
    public Response getReport(ReportConditionDTO reportConditionDTO, Set<String> reportTypeSet) {
        try {
            this.handleDataPermissions(reportConditionDTO);
            Set<String> dimensionSet = new HashSet<>();
            if (reportConditionDTO.getDimension() != null && reportConditionDTO.getDimension().length > 0) {
                Collections.addAll(dimensionSet, reportConditionDTO.getDimension());
            }

            if (dimensionSet.contains("adType") && !dimensionSet.contains("placementId")) {
                dimensionSet.add("placementId");
                String[] dimension = new String[dimensionSet.size() + 1];
                dimensionSet.toArray(dimension);
                reportConditionDTO.setDimension(dimension);
                dimensionSet.remove("placementId");
            }

            if (dimensionSet.contains("instanceId")) {
                dimensionSet.add("bid");
                String[] dimension = new String[dimensionSet.size() + 1];
                dimensionSet.toArray(dimension);
                reportConditionDTO.setDimension(dimension);
            }

            boolean isAdType = false;
            if (dimensionSet.contains("adType")) {
                isAdType = true;
                dimensionSet.remove("adType");
            }

            List<JSONObject> resultReport = new ArrayList<>();
            if (reportTypeSet.contains("api") && !dimensionSet.contains("sceneId")) {
                List<StatAdnetwork> statAdnetworks = this.getAdNetworkReport(reportConditionDTO);
                statAdnetworks.forEach(statAdnetwork -> {
                    resultReport.add((JSONObject) JSONObject.toJSON(statAdnetwork));
                });
            }

            if (reportTypeSet.contains("lr")) {
                List<StatLr> statLrs = this.getLrReport(reportConditionDTO);
                for (StatLr statLr : statLrs){
                    if (dimensionSet.contains("adnId") && statLr.getAdnId() == 0) {
                        continue;
                    }
                    if (dimensionSet.contains("instanceId") && statLr.getInstanceId() == 0) {
                        continue;
                    }
                    resultReport.add((JSONObject) JSONObject.toJSON(statLr));
                }
            }

            if (reportTypeSet.contains("dau") && !dimensionSet.contains("sceneId")) {
                List<StatDau> statDaus = this.getDauReport(reportConditionDTO);
                statDaus.forEach(statDau -> {
                    JSONObject resultStatDau = (JSONObject) JSONObject.toJSON(statDau);
                    resultReport.add(resultStatDau);
                });
            }

            if (isAdType) {
                this.fieldNameService.fillPlacementAdType(resultReport);
                dimensionSet.add("adType");
            }
            List<JSONObject> results = this.businessMapReduce(resultReport, reportConditionDTO, dimensionSet);
            this.fieldNameService.fillName(results);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get report error {} ", JSONObject.toJSONString(reportConditionDTO), e);
        }
        return Response.RES_FAILED;
    }

    private List<JSONObject> businessMapReduce(List<JSONObject> resultReport, ReportConditionDTO reportConditionDTO, Set<String> dimensionSet) {
        Map<String, List<JSONObject>> reportMap = resultReport.stream().collect(
                Collectors.groupingBy(report -> {
                    List keys = new ArrayList();
                    if (!CollectionUtils.isEmpty(dimensionSet)) {
                        for (String dim : dimensionSet) {
                            keys.add(report.get(dim));
                        }
                    }
                    return StringUtils.join(keys.toArray(), ",");
                }));

        List<JSONObject> results = new ArrayList<>(reportMap.size());
        reportMap.forEach((k, v) ->
                results.add(v.stream().reduce((result, report) -> {
                    result.put("cost", Util.getFloat(result, "cost") + Util.getFloat(report, "cost"));
                    result.put("dau", Util.getInt(result, "dau") + Util.getInt(report, "dau"));
                    result.put("deu", Util.getInt(result, "deu") + Util.getInt(report, "deu"));
                    result.put("instanceRequest", Util.getInt(result, "instanceRequest") + Util.getInt(report, "instanceRequest"));
                    result.put("instanceFilled", Util.getInt(result, "instanceFilled") + Util.getInt(report, "instanceFilled"));
                    result.put("apiClick", Util.getInt(result, "apiClick") + Util.getInt(report, "apiClick"));
                    result.put("apiImpr", Util.getInt(result, "apiImpr") + Util.getInt(report, "apiImpr"));
                    result.put("waterfallRequest", Util.getInt(result, "waterfallRequest") + Util.getInt(report, "waterfallRequest"));
                    result.put("waterfallFilled", Util.getInt(result, "waterfallFilled") + Util.getInt(report, "waterfallFilled"));
                    result.put("apiFilled", Util.getInt(result, "apiFilled") + Util.getInt(report, "apiFilled"));
                    result.put("apiRequest", Util.getInt(result, "apiRequest") + Util.getInt(report, "apiRequest"));
                    result.put("videoStart", Util.getInt(result, "videoStart") + Util.getInt(report, "videoStart"));
                    result.put("videoComplete", Util.getInt(result, "videoComplete") + Util.getInt(report, "videoComplete"));
                    result.put("isReadyTrue", Util.getInt(result, "isReadyTrue") + Util.getInt(report, "isReadyTrue"));
                    result.put("isReadyFalse", Util.getInt(result, "isReadyFalse") + Util.getInt(report, "isReadyFalse"));
                    result.put("mediationImpr", Util.getInt(result, "mediationImpr") + Util.getInt(report, "mediationImpr"));
                    result.put("mediationClick", Util.getInt(result, "mediationClick") + Util.getInt(report, "mediationClick"));

                    result.put("bidReq", Util.getInt(result, "bidReq") + Util.getInt(report, "bidReq"));
                    result.put("bidResp", Util.getInt(result, "bidResp") + Util.getInt(report, "bidResp"));
                    result.put("bidRespPrice", Util.getFloat(result, "bidRespPrice") + Util.getFloat(report, "bidRespPrice"));
                    result.put("bidWin", Util.getInt(result, "bidWin") + Util.getInt(report, "bidWin"));
                    result.put("bidWinPrice", Util.getFloat(result, "bidWinPrice") + Util.getFloat(report, "bidWinPrice"));
                    return result;
                }).get())
        );
        results.forEach(result -> {
            if (result.containsKey("day") && result.get("day") != null) {
                result.put("day", Util.getYYYYMMDD(result.getDate("day")));
            }
        });
        return results;
    }

    /**
     * Get revenue of last dat, last seven days, last month, current month
     *
     * @param pubAppId
     */
    public Response getDashboardHeadRevenue(Integer pubAppId) {
        JSONObject resultRevenue = new JSONObject();
        String yesterday = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -1));
        Double yesterdayRevenue = this.getRevenue(yesterday, yesterday, pubAppId);
        resultRevenue.put("yesterdayRevenue", yesterdayRevenue);

        String lastSevenDayBegin = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -7));
        String lastSevenDayEnd = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -1));
        Double lastSevenDayRevenue = this.getRevenue(lastSevenDayBegin, lastSevenDayEnd, pubAppId);
        resultRevenue.put("lastSevenDayRevenue", lastSevenDayRevenue);

        String currentMonthDayBegin = Util.getYYYYMMDD(Util.getMonthFirstDay());
        Double currentMonthRevenue = this.getRevenue(currentMonthDayBegin, yesterday, pubAppId);
        resultRevenue.put("currentMonthRevenue", currentMonthRevenue);

        String lastMonthBegin = Util.getYYYYMMDD(Util.getLastMonthFirstDay());
        String lastMonthEnd = Util.getYYYYMMDD(Util.getLastMonthLastDay());
        Double lastMonthRevenue = this.getRevenue(lastMonthBegin, lastMonthEnd, pubAppId);
        resultRevenue.put("lastMonthRevenue", lastMonthRevenue);
        return Response.buildSuccess(resultRevenue);
    }

    /**
     * Get revenue of different period
     *
     * @param pubAppId
     */
    private Double getRevenue(String dateBegin, String dateEnd, Integer pubAppId) {
        try {
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            if (pubAppId != null) {
                reportConditionDTO.setPubAppId(new Integer[]{pubAppId});
                reportConditionDTO.setDimension(new String[]{"pubAppId"});
            }
            reportConditionDTO.setDateBegin(dateBegin);
            reportConditionDTO.setDateEnd(dateEnd);
            this.handleDataPermissions(reportConditionDTO);
            List<StatAdnetwork> statAdNetworks = this.getAdNetworkReport(reportConditionDTO);
            if (CollectionUtils.isEmpty(statAdNetworks)) {
                return 0D;
            }
            if (statAdNetworks.size() > 1) {
                throw new RuntimeException("Get multi report publisher app id " + pubAppId);
            }
            BigDecimal revenue = statAdNetworks.get(0).getCost();
            if (revenue == null) {
                log.info("No revenue of {}", JSONArray.toJSON(statAdNetworks));
                return 0D;
            }
            return revenue.doubleValue();
        } catch (Exception e) {
            log.error("Get publisher app id {} revenue between {} and {} error", pubAppId, dateBegin, dateEnd, e);
        }
        return 0D;
    }

    /**
     * Get top 3 revenue countries revenue of last seven days and other counties merged
     *
     * @param pubAppId
     */
    public Response getRegionRevenue(Integer pubAppId) {
        try {
            Set<String> top3RevenueCountrySet = this.getTopRevenueCountries(3);
            String lastSevenDayBegin = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -7));
            String lastSevenDayEnd = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -1));
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            if (pubAppId != null) {
                Integer[] pubAppIds = new Integer[]{pubAppId};
                reportConditionDTO.setPubAppId(pubAppIds);
            }
            reportConditionDTO.setDateBegin(lastSevenDayBegin);
            reportConditionDTO.setDateEnd(lastSevenDayEnd);
            reportConditionDTO.setDimension(new String[]{"day", "country"});
            this.handleDataPermissions(reportConditionDTO);
            List<StatAdnetwork> allStatAdNetworks = this.getAdNetworkReport(reportConditionDTO);
            List<StatAdnetwork> top3StatAdNetworks = new ArrayList<>();
            Iterator<StatAdnetwork> iterator = allStatAdNetworks.iterator();
            while (iterator.hasNext()) {
                StatAdnetwork statAdnetwork = iterator.next();
                if (top3RevenueCountrySet.contains(statAdnetwork.getCountry())) {
                    top3StatAdNetworks.add(statAdnetwork);
                    iterator.remove();
                }
            }

            List<JSONObject> results = new ArrayList<>();
            top3StatAdNetworks.forEach(statAdNetwork -> {
                JSONObject result = (JSONObject) JSONObject.toJSON(statAdNetwork);
                result.put("day", Util.getYYYYMMDD(result.getDate("day")));
                result.remove("apiVideoStart");
                result.remove("apiFilled");
                result.remove("apiClick");
                result.remove("apiImpr");
                result.remove("apiVideoComplete");
                result.remove("apiRequest");
                results.add(result);
            });

            Map<Date, List<StatAdnetwork>> otherDayStatMap = allStatAdNetworks.stream()
                    .collect(Collectors.groupingBy(m -> m.getDay(), Collectors.toList()));
            for (Map.Entry<Date, List<StatAdnetwork>> entry : otherDayStatMap.entrySet()) {
                StatAdnetwork otherCountryStat = new StatAdnetwork();
                otherCountryStat.setDay(entry.getKey());
                otherCountryStat.setRevenue(new BigDecimal(0));
                otherCountryStat.setCountry("OTHER");
                otherCountryStat.setCost(new BigDecimal(0));
                for (StatAdnetwork statAdnetwork : entry.getValue()) {
                    if (statAdnetwork.getCost() != null) {
                        otherCountryStat.setCost(otherCountryStat.getCost().add(statAdnetwork.getCost()));
                    }
                    if (statAdnetwork.getRevenue() != null) {
                        otherCountryStat.setRevenue(otherCountryStat.getRevenue().add(statAdnetwork.getRevenue()));
                    }
                }
                JSONObject otherResult = (JSONObject) JSONObject.toJSON(otherCountryStat);
                otherResult.put("day", Util.getYYYYMMDD(otherResult.getDate("day")));
                results.add(otherResult);
            }
            log.info("Get region revenue size {}", results.size());
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get publisher app id {} regions' revenue error", pubAppId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get top revenue countries
     *
     * @param top
     */
    private Set<String> getTopRevenueCountries(Integer top) {
        String lastSevenDayBegin = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -7));
        String lastSevenDayEnd = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -1));
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin(lastSevenDayBegin);
        reportConditionDTO.setDateEnd(lastSevenDayEnd);
        reportConditionDTO.setDimension(new String[]{"country"});
        List<StatAdnetwork> statAdNetworks = this.getAdNetworkReport(reportConditionDTO);
        statAdNetworks.sort((stat1, stat2) -> {
            BigDecimal revenue1 = stat1.getCost();
            BigDecimal revenue2 = stat2.getCost();
            if (revenue1 == null) {
                return -1;
            }
            if (revenue2 == null) {
                return 1;
            }
            return revenue2.intValue() - revenue1.intValue();
        });
        Set<String> topResult = new HashSet<>();
        for (StatAdnetwork statAdnetwork : statAdNetworks) {
            topResult.add(statAdnetwork.getCountry());
            if (topResult.size() >= top) {
                break;
            }
        }
        log.info("Get top {} countries {}", top, topResult);
        return topResult;
    }

    /**
     * Build date/dimension/group by clause conditions
     *
     * @param reportConditionDTO
     */
    private Map<String, Object> buildConditionMap(ReportConditionDTO reportConditionDTO) {
        String[] dimensions = reportConditionDTO.getDimension();
        Map<String, Object> conditionMap = new HashMap<>();
        if (dimensions != null && dimensions.length > 0) {
            for (String dimension : dimensions) {
                conditionMap.put("dimension_" + dimension, dimension);
            }
        }
        if (conditionMap.size() == 3 && conditionMap.containsKey("dimension_adnId") && conditionMap.containsKey("dimension_day")
                && conditionMap.containsKey("dimension_hour") ||
                conditionMap.size() == 2 && conditionMap.containsKey("dimension_adnId") && conditionMap.containsKey("dimension_day")
                || conditionMap.size() == 1 && conditionMap.containsKey("dimension_adnId")){
            conditionMap.put("dimension_only_adn", "dimension_only_adn");
            conditionMap.remove("dimension_adnId");
        }
        return conditionMap;
    }

    /**
     * Set publisher and publisher app which current user could view
     *
     * @param reportConditionDTO
     */
    private void handleDataPermissions(ReportConditionDTO reportConditionDTO) {
        Integer[] publisherIdArr = new Integer[1];
        publisherIdArr[0] = this.getCurrentPublisherId();
        reportConditionDTO.setPublisherId(publisherIdArr);

        List<Integer> appIdsOfCurrentUser = this.getAppIdsOfCurrentUser();
        Set<Integer> appIdsOfCurrentUserSet = new HashSet<>(appIdsOfCurrentUser);
        List<Integer> publisherAppIds = Util.buildIntegerList(reportConditionDTO.getPubAppId());
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            Iterator iterator = publisherAppIds.iterator();
            while (iterator.hasNext()) {
                if (!appIdsOfCurrentUserSet.contains(iterator.next())) {
                    iterator.remove();
                }
            }
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
     * Get dau report
     *
     * @param reportConditionDTO
     */
    public List<StatDau> getDauReport(ReportConditionDTO reportConditionDTO) {
        Map<String, Object> conditionMap = this.buildConditionMap(reportConditionDTO);
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
        if (reportConditionDTO.getHourEnd() != null){
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

        List<Byte> abts = Util.buildByteList(reportConditionDTO.getAbt());
        if (!CollectionUtils.isEmpty(abts)) {
            criteria.andAbtIn(abts);
        }

        List<Byte> bids = Util.buildByteList(reportConditionDTO.getBid());
        if (!CollectionUtils.isEmpty(bids)) {
            criteria.andBidIn(bids);
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
}
