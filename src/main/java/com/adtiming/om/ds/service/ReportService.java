// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dto.DauDimensionsDTO;
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
public class ReportService extends ReportBaseService {

    private static final Logger log = LogManager.getLogger();

    private static final Set<String> NON_IN_API_DIMS = new HashSet<>(
            Arrays.asList("ruleId", "sceneId", "appVersion", "sdkVersion", "platform", "osVersion", "abt", "abtId"));

    @Resource
    FieldNameService fieldNameService;

    @Resource
    UtilService utilService;

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
            reportConditionDTO.setDimensionSet(dimensionSet);

            if ((dimensionSet.contains(PLACEMENT_ID) || dimensionSet.contains(INSTANCE_ID))
                    && !dimensionSet.contains(PUB_APP_ID)) {
                Set<String> dimensionSetTmp = new HashSet<>(dimensionSet);
                dimensionSetTmp.add(PUB_APP_ID);
                String[] dimension = new String[dimensionSetTmp.size() + 1];
                dimensionSetTmp.toArray(dimension);
                reportConditionDTO.setDimension(dimension);
            }

            if (dimensionSet.contains("adType") && !dimensionSet.contains(PLACEMENT_ID)) {
                dimensionSet.add(PLACEMENT_ID);
                String[] dimension = new String[dimensionSet.size() + 1];
                dimensionSet.toArray(dimension);
                reportConditionDTO.setDimension(dimension);
                dimensionSet.remove(PLACEMENT_ID);
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
            if (reportTypeSet.contains("api") && !dimensionSet.contains("sceneId") && !dimensionSet.contains("appVersion")
                    && !dimensionSet.contains("sdkVersion") && !dimensionSet.contains("osVersion")) {
                List<StatAdnetwork> statAdNetworks = this.getAdNetworkReport(reportConditionDTO);
                statAdNetworks.forEach(statAdNetwork -> resultReport.add((JSONObject) JSONObject.toJSON(statAdNetwork)));
            }

            List<StatLr> statLrs = this.getLrReport(reportConditionDTO);
            for (StatLr statLr : statLrs) {
                if (dimensionSet.contains("adnId") && statLr.getAdnId() == 0) {
                    continue;
                }
                if (dimensionSet.contains("instanceId") && statLr.getInstanceId() == 0) {
                    continue;
                }
                if (dimensionSet.contains("placementId") && statLr.getPlacementId() == 0) {
                    continue;
                }
                resultReport.add((JSONObject) JSONObject.toJSON(statLr));
            }

            if (reportTypeSet.contains("dau") && !dimensionSet.contains("sceneId")) {
                if (dimensionSet.contains("ruleId") || dimensionSet.contains("abt")) {
                    List<JSONObject> statABTestDauList = this.getRuleABTestDauReport(reportConditionDTO);
                    if (!CollectionUtils.isEmpty(statABTestDauList)) {
                        resultReport.addAll(statABTestDauList);
                    }
                } else {
                    List<JSONObject> statDauList = this.getDeuReport(reportConditionDTO);
                    if (!CollectionUtils.isEmpty(statDauList)) {
                        resultReport.addAll(statDauList);
                    }
                }
            }

            if (isAdType) {
                this.fieldNameService.fillPlacementAdType(resultReport);
                dimensionSet.add("adType");
            }
            List<JSONObject> results = this.businessMapReduce(resultReport, dimensionSet);
            if (reportTypeSet.contains("dau") && !dimensionSet.contains("sceneId")
                    && !dimensionSet.contains("ruleId")&& !dimensionSet.contains("abt")) {
                this.fillPlacementInstanceDau(results, reportConditionDTO);
            }
            this.computeEcpm(results, dimensionSet, reportConditionDTO.clone());
            this.fieldNameService.fillName(results);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get report error {} ", JSONObject.toJSONString(reportConditionDTO), e);
            return Response.build(Response.RES_FAILED.getCode(), Response.STATUS_DISABLE, e.getMessage());
        }
    }

    /**
     * SUM{ Instance revenue * [（Instance SDK impressions(Rule id)/ Instance SDK Impressions(All)] }/
     * SUM{Instance API Impressions* [（Instance SDK impressions(Rule id)/ Instance SDK Impressions(All)] }*1000
     **/
    private void computeEcpm(List<JSONObject> results, Set<String> dimensionSet, ReportConditionDTO reportConditionDTO) {
        try {
            boolean dimIntersection = false;
            for (String dim : NON_IN_API_DIMS) {
                if (dimensionSet.contains(dim)) {
                    dimIntersection = true;
                    break;
                }
            }
            if (!dimIntersection) {
                for (JSONObject result : results) {
                    double cost = 0;
                    Double costValue = result.getDouble("cost");
                    if (costValue != null) {
                        cost = costValue;
                    }
                    double apiImpr = 0;
                    Double apiImprValue = result.getDouble("apiImpr");
                    if (apiImprValue != null) {
                        apiImpr = apiImprValue;
                    }
                    double apiEcpm = 0;
                    if (apiImpr > 0) {
                        apiEcpm = cost * 1000 / apiImpr;
                    }
                    result.put("apiEcpm", apiEcpm);
                }
                return;
            }
            Map<Integer, List<JSONObject>> instanceCountryReportMap = this.getInstanceCountryReportMap(dimensionSet, reportConditionDTO);
            Map<String, List<JSONObject>> dimInstancesMap = this.getDimInstancesMap(dimensionSet, reportConditionDTO);
            Map<Integer, String> ruleCountriesMap = new HashMap<>();
            if (dimensionSet.contains("ruleId")) {
                List<Integer> ruleIds = new ArrayList<>();
                for (JSONObject report : results) {
                    ruleIds.add(report.getInteger("ruleId"));
                }
                ruleCountriesMap = this.getRuleCountries(ruleIds);
            }

            Map<String, List<JSONObject>> resultsMap = results.stream().collect(
                    Collectors.groupingBy(report -> {
                        List<String> keys = new ArrayList<>();
                        if (!CollectionUtils.isEmpty(dimensionSet)) {
                            for (String dim : dimensionSet) {
                                Object dimObj = report.get(dim);
                                if (dimObj != null) {
                                    keys.add(report.get(dim).toString());
                                }
                            }
                        }
                        return StringUtils.join(keys.toArray(), ",");
                    }));

            for (Map.Entry<String, List<JSONObject>> entry : resultsMap.entrySet()) {
                try {
                    String key = entry.getKey();
                    List<JSONObject> dimReportList = entry.getValue();
                    List<JSONObject> dimInstances = dimInstancesMap.get(key);
                    if (CollectionUtils.isEmpty(dimInstances)) {
                        for (JSONObject report : dimReportList) {
                            report.put("apiEcpm", 0D);
                        }
                        continue;
                    }

                    String ruleCountries = "";
                    if (dimensionSet.contains("ruleId")) {
                        ruleCountries = ruleCountriesMap.get(dimReportList.get(0).getInteger("ruleId"));
                    }
                    double apiImpr = 0;
                    int instanceMediationImpr = 0;
                    double cost = 0;
                    for (JSONObject dimInstance : dimInstances) {
                        int instanceId = dimInstance.getInteger("instanceId");
                        List<JSONObject> instanceCountryReportList = instanceCountryReportMap.get(instanceId);
                        for (JSONObject instanceReport : instanceCountryReportList) {
                            if (dimensionSet.contains("ruleId")) {
                                String country = instanceReport.getString("country");
                                if (!"00".equals(country) && StringUtils.isNotBlank(ruleCountries) && StringUtils.isNotBlank(country) && !ruleCountries.contains(country)) {
                                    continue;
                                }
                            }
                            if (instanceReport.containsKey("mediationImpr")) {
                                instanceMediationImpr += instanceReport.getInteger("mediationImpr");
                            }
                            if (instanceReport.containsKey("cost")) {
                                cost += instanceReport.getDouble("cost");
                            }
                            if (instanceReport.containsKey("apiImpr")) {
                                apiImpr += instanceReport.getInteger("apiImpr");
                            }
                        }
                    }

                    for (JSONObject report : dimReportList) {
                        double mediationImpr = 0D;
                        if (report.containsKey("mediationImpr")) {
                            mediationImpr = report.getDouble("mediationImpr");
                        }
                        double instanceImprRate = 1;
                        if (instanceMediationImpr > 0 && mediationImpr > 0) {
                            instanceImprRate = mediationImpr / instanceMediationImpr;
                        }
                        report.put("instanceImprRate", instanceImprRate);
                        report.put("notInApiDimImpr", apiImpr);
                        report.put("notInApiDimCost", cost);
                        cost = cost * instanceImprRate;
                        report.put("cost", cost);
                        apiImpr = apiImpr * instanceImprRate;
                        report.put("apiImpr", apiImpr);
                        double apiEcpm = 0;
                        if (apiImpr > 0) {
                            apiEcpm = (cost * 1000) / apiImpr;
                            apiEcpm = (int) (apiEcpm * 100) / 100D;
                        }
                        report.put("apiEcpm", apiEcpm);
                    }
                } catch (Exception e) {
                    log.error("Compute instance impression rate {} error:", entry.getValue(), e);
                }
            }
        } catch (Exception e) {
            log.error("Compute ecpm error:", e);
        }
    }

    private Map<String, List<JSONObject>> getDimInstancesMap(Set<String> dimensionSet, ReportConditionDTO reportConditionDTO) {
        Set<String> dimensionSetTmp = new HashSet<>(dimensionSet);
        dimensionSetTmp.add("instanceId");
        String[] dimension = new String[dimensionSetTmp.size()];
        dimensionSetTmp.toArray(dimension);
        reportConditionDTO.setDimension(dimension);
        List<StatLr> instanceReportList = this.getLrReport(reportConditionDTO);
        List<JSONObject> results = new ArrayList<>();
        if (!CollectionUtils.isEmpty(instanceReportList)) {
            for (StatLr lr : instanceReportList) {
                results.add((JSONObject) JSONObject.toJSON(lr));
            }
            return results.stream().collect(
                    Collectors.groupingBy(report -> {
                        List<String> keys = new ArrayList<>();
                        if (!CollectionUtils.isEmpty(dimensionSet)) {
                            for (String dim : dimensionSet) {
                                Object dimObj = report.get(dim);
                                if (dimObj != null) {
                                    keys.add(report.get(dim).toString());
                                }
                            }
                        }
                        return StringUtils.join(keys.toArray(), ",");
                    }));
        }
        return new HashMap<>();
    }

    private Map<Integer, List<JSONObject>> getInstanceCountryReportMap(Set<String> dimensionSet, ReportConditionDTO reportConditionDTO) {
        Set<String> dimensionSetTmp = new HashSet<>(dimensionSet);
        dimensionSetTmp.add("instanceId");
        dimensionSetTmp.removeAll(NON_IN_API_DIMS);
        dimensionSetTmp.add("country");
        String[] dimension = new String[dimensionSetTmp.size()];
        dimensionSetTmp.toArray(dimension);
        reportConditionDTO.setDimension(dimension);
        List<JSONObject> results = new ArrayList<>();
        List<StatLr> instanceReportList = this.getLrReport(reportConditionDTO);
        if (!CollectionUtils.isEmpty(instanceReportList)) {
            for (StatLr lr : instanceReportList) {
                results.add((JSONObject) JSONObject.toJSON(lr));
            }
        }
        List<StatAdnetwork> apiReportList = this.getAdNetworkReport(reportConditionDTO);
        if (!CollectionUtils.isEmpty(apiReportList)) {
            for (StatAdnetwork s : apiReportList) {
                results.add((JSONObject) JSONObject.toJSON(s));
            }
        }
        results = this.businessMapReduce(results, dimensionSetTmp);
        Map<Integer, List<JSONObject>> instanceReportMap = new HashMap<>();
        for (JSONObject report : results) {
            Integer instanceId = report.getInteger("instanceId");
            List<JSONObject> countryReportList = instanceReportMap.computeIfAbsent(instanceId, k -> new ArrayList<>());
            countryReportList.add(report);
        }
        return instanceReportMap;
    }

    private List<JSONObject> businessMapReduce(List<JSONObject> resultReport, Set<String> dimensionSet) {
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
                    result.put("impr", Util.getInt(result, "impr") + Util.getInt(report, "impr"));
                    result.put("click", Util.getInt(result, "click") + Util.getInt(report, "click"));

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
                    .collect(Collectors.groupingBy(StatAdnetworkKey::getDay, Collectors.toList()));
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
            return Response.build(Response.RES_FAILED.getCode(), Response.STATUS_DISABLE, e.getMessage());
        }
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
     * Get deu report
     *
     * @param reportConditionDTO
     */
    public List<JSONObject> getDeuReport(ReportConditionDTO reportConditionDTO) {
        try {
            Map<String, Object> dauConditionMap = this.buildDauConditionMap(reportConditionDTO);
            List<JSONObject> results = new ArrayList<>();
            OmDict omDict = this.utilService.getOmDict("dau_dimensions");
            if (omDict != null && StringUtils.isNotBlank(omDict.getValue())) {
                try {
                    DauDimensionsDTO dauDimensionsDTO = JSONObject.parseObject(omDict.getValue(), DauDimensionsDTO.class);
                    Set<String> dimensionSet = reportConditionDTO.getDimensionSet();
                    if (dimensionSet.contains(INSTANCE_ID)) {
                        if (dauDimensionsDTO.getInstance() != null && dauDimensionsDTO.getInstance() == 1) {
                            List<StatDauInstance> statInstanceDauSummary = this.getInstanceDauReport(reportConditionDTO, dauConditionMap);
                            statInstanceDauSummary.forEach(instanceStatDeu -> results.add((JSONObject) JSONObject.toJSON(instanceStatDeu)));
                            return results;
                        }
                    } else if (dimensionSet.contains(PLACEMENT_ID) && dimensionSet.contains(ADN_ID)
                            || (dimensionSet.contains(ADN_ID) && reportConditionDTO.getPlacementId() != null && reportConditionDTO.getPlacementId().length > 0)) {
                        if (dauDimensionsDTO.getAdn_placement() != null && dauDimensionsDTO.getAdn_placement() == 1) {
                            List<StatDauAdnPlacement> statAdnPlacementDauSummary = this.getAdnPlacementDauReport(reportConditionDTO, dauConditionMap);
                            statAdnPlacementDauSummary.forEach(adnPlacementStatDau -> results.add((JSONObject) JSONObject.toJSON(adnPlacementStatDau)));
                            return results;
                        }
                    } else if (dimensionSet.contains(PLACEMENT_ID)) {
                        if (dauDimensionsDTO.getPlacement() != null && dauDimensionsDTO.getPlacement() == 1) {
                            List<StatDauPlacement> statPlacementDauSummary = this.getPlacementDauReport(reportConditionDTO, dauConditionMap);
                            statPlacementDauSummary.forEach(placementStatDau -> results.add((JSONObject) JSONObject.toJSON(placementStatDau)));
                            return results;
                        }
                    } else if (dimensionSet.contains(ADN_ID)) {
                        if (dauDimensionsDTO.getAdn() != null && dauDimensionsDTO.getAdn() == 1) {
                            List<StatDauAdn> statAdnDauSummary = this.getAdnDauReport(reportConditionDTO, dauConditionMap);
                            statAdnDauSummary.forEach(adnStatDau -> results.add((JSONObject) JSONObject.toJSON(adnStatDau)));
                            return results;
                        }
                    }
                } catch (Exception e) {
                    log.error("Get dimension dau {} error:", JSONObject.toJSON(omDict), e);
                }
            }
            List<StatDau> appStatDeuList = this.getAppDauReport(reportConditionDTO, dauConditionMap);
            appStatDeuList.forEach(appStatDeu -> results.add((JSONObject) JSONObject.toJSON(appStatDeu)));
            return results;
        } catch (Exception e) {
            log.error("Get deu report {} error:", JSONObject.toJSON(reportConditionDTO), e);
        }
        return new ArrayList<>();
    }

    private void fillPlacementInstanceDau(List<JSONObject> reportList, ReportConditionDTO conditionDTO) {
        try {
            if (CollectionUtils.isEmpty(reportList)) {
                return;
            }
            Map<String, Object> dauConditionMap = this.buildDauConditionMap(conditionDTO);
            conditionDTO.setDimension(new String[]{"day", "pubAppId"});
            if (conditionDTO.getDimensionSet().contains("country")) {
                conditionDTO.setDimension(new String[]{"day", "pubAppId", "country"});
            }
            conditionDTO.setPublisherId(new Integer[]{this.getCurrentPublisherId()});
            List<StatDau> appStatSdkUsers = this.getAppDauReport(conditionDTO, dauConditionMap);
            Map<String, StatDau> appDeuMap = new HashMap<>();
            appStatSdkUsers.forEach(appStat -> appDeuMap.put(Util.getYYYYMMDD(appStat.getDay()) + appStat.getCountry() + appStat.getPubAppId(), appStat));
            reportList.forEach(report -> {
                StatDau sdkUser = appDeuMap.get(report.getString("day") + report.getString("country") + report.getString("pubAppId"));
                if (sdkUser != null) {
                    report.put("dau", sdkUser.getDau());
                } else if (!report.containsKey("dau")) {
                    report.put("dau", 0);
                }
            });
        } catch (Exception e) {
            log.error("fillPlacementInstanceDau error:", e);
        }
    }
}
