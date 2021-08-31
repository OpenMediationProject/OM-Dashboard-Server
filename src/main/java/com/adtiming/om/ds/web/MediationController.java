// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dao.OmPlacementRuleGroupMapper;
import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SegmentDTO;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.MediationService;
import com.adtiming.om.ds.service.ReportService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
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

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Mediation manage interface, it called segment in frontend, here it is placement rule and rule instance
 *
 * @author dianbo ruan
 */
@RestController
public class MediationController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    MediationService mediationService;

    @Resource
    ReportService reportService;

    @Resource
    OmPlacementRuleGroupMapper omPlacementRuleGroupMapper;

    /**
     * create or update segment with instances together in one transaction
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/save", method = RequestMethod.POST)
    @Transactional
    public Response saveSegment(@RequestBody SegmentDTO segmentDTO) {
        try {
            if (segmentDTO.getPubAppId() == null || segmentDTO.getPlacementId() == null) {
                log.warn("Parameter {} not valid", JSONObject.toJSONString(segmentDTO));
                return Response.RES_PARAMETER_ERROR;
            }
            if (segmentDTO.getId() == null || segmentDTO.getId() <= 0) {
                this.mediationService.createSegment(segmentDTO);
            } else {
                this.mediationService.updateSegment(segmentDTO);
            }
            Map<Integer, OmPlacementRuleGroup> instanceLevelGroupIdMap = this.mediationService.getInstanceLevelGroupIdMap(segmentDTO.getId());
            Map<Integer, List<OmInstanceWithBLOBs>> groupIdInstanceMap = new HashMap<>();
            for (OmInstanceWithBLOBs instance : segmentDTO.getInstances()) {
                if (instance.getGroupLevel() == null) {
                    instance.setGroupLevel(1);
                }
                if (instance.getAutoSwitch() == null) {
                    instance.setAutoSwitch(2);
                }
                OmPlacementRuleGroup group = instanceLevelGroupIdMap.get(instance.getGroupLevel());
                instance.setGroupId(group.getId());
                List<OmInstanceWithBLOBs> groupIdInstances = groupIdInstanceMap.computeIfAbsent(instance.getGroupId(), k -> new ArrayList<>());
                groupIdInstances.add(instance);
            }
            for (List<OmInstanceWithBLOBs> groupInstances : groupIdInstanceMap.values()) {
                OmInstanceWithBLOBs instance = groupInstances.get(0);
                OmPlacementRuleGroup group = instanceLevelGroupIdMap.get(instance.getGroupLevel());
                if (group.getAutoSwitch() != instance.getAutoSwitch().byteValue()) {
                    group.setAutoSwitch(instance.getAutoSwitch().byteValue());
                    int result = this.omPlacementRuleGroupMapper.updateByPrimaryKeySelective(group);
                    if (result <= 0) {
                        throw new RuntimeException("Update group auto switch " + JSONObject.toJSONString(group) + " failed");
                    }
                }
                this.mediationService.saveRuleMediation(segmentDTO.getId(), groupInstances);
            }
            this.mediationService.saveRuleMediation(segmentDTO.getId(), Arrays.asList(segmentDTO.getHeaderbidding()));
            return Response.buildSuccess(segmentDTO);
        } catch (Exception e) {
            log.error("Update segment {} error:", JSONObject.toJSON(segmentDTO), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Response.RES_FAILED;
    }

    /**
     * Resort segment priority
     *
     * @param placementRuleInstanceId
     * @param priority
     */
    @RequestMapping(value = "/mediation/segment/resort/priority", method = RequestMethod.GET)
    public Response resortInstancesPriority(Integer placementRuleInstanceId, Integer priority) {
        try {
            if (placementRuleInstanceId == null || priority == null) {
                log.warn("PlacementId instance id and priority must not empty");
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.resortWaterFallPriority(placementRuleInstanceId, priority);
        } catch (Exception e) {
            log.error("Resort instances priority error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Resort placement rule priority
     *
     * @param ruleId
     * @param priority
     */
    @RequestMapping(value = "/mediation/rule/resort/priority", method = RequestMethod.GET)
    public Response resortRulePriority(Integer ruleId, Integer priority) {
        try {
            if (ruleId == null || priority == null) {
                log.warn("Rule id and priority must not empty");
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.resortRulePriority(ruleId, priority);
        } catch (Exception e) {
            log.error("Resort segment {} priority error:", ruleId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new segment, related to current user
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/create", method = RequestMethod.POST)
    public Response createSegment(@RequestBody SegmentDTO segmentDTO) {
        try {
            if (segmentDTO.getPlacementId() == null) {
                return Response.RES_DATA_DOES_NOT_EXISTED.msg("Placement not existed");
            }
            if (segmentDTO.getName() == null || segmentDTO.getPubAppId() == null) {
                log.error("Create segment parameter {} not valid", JSONObject.toJSONString(segmentDTO));
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.createSegment(segmentDTO);
        } catch (Exception e) {
            log.error("Create segment error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Update segment information
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/update", method = RequestMethod.POST)
    public Response updateSegment(@RequestBody SegmentDTO segmentDTO) {
        try {
            if (segmentDTO.getId() == null || segmentDTO.getPubAppId() == null
                    || segmentDTO.getPlacementId() == null || segmentDTO.getSegmentId() == null) {
                log.error("Parameter {} not valid", JSONObject.toJSONString(segmentDTO));
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.updateSegment(segmentDTO);
        } catch (Exception e) {
            log.error("Update segment error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all placement rule(Segment) by rule(Segment) id
     *
     * @param ruleId
     */
    @RequestMapping(value = "/mediation/segment/get", method = RequestMethod.GET)
    public Response getSegment(Integer ruleId) {
        try {
            if (ruleId == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            OmPlacementRule placementRule = this.mediationService.getPlacementRule(ruleId);
            if (placementRule == null) {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            OmPlacementRuleSegmentWithBLOBs ruleSegment = this.mediationService.getPlacementRuleSegment(placementRule.getSegmentId());
            JSONObject resultRule = (JSONObject) JSONObject.toJSON(placementRule);
            if (ruleSegment != null) {
                JSONObject resultRuleSegment = (JSONObject) JSONObject.toJSON(ruleSegment);
                resultRuleSegment.remove("id");
                resultRuleSegment.put("segmentId", ruleSegment.getId());
                String countries = ruleSegment.getCountries();
                if (StringUtils.isNotBlank(countries)) {
                    resultRuleSegment.put("countries", countries.split(","));
                }
                Util.buildBrandBlackWhiteType(resultRuleSegment, ruleSegment.getBrandBlacklist(), ruleSegment.getBrandWhitelist());
                Util.buildModelBlackWhiteType(resultRuleSegment, ruleSegment.getModelBlacklist(), ruleSegment.getModelWhitelist());
                resultRule.putAll(resultRuleSegment);
            }
            return Response.buildSuccess(resultRule);
        } catch (Exception e) {
            log.error("get placement rule error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all placement rule(Segment)
     *
     * @param pubAppId
     * @param placementId
     * @param countries
     */
    @RequestMapping(value = "/mediation/segment/list", method = RequestMethod.GET)
    public Response getSegments(Integer pubAppId, Integer placementId, String[] countries, Integer lastDays) {
        try {
            if (pubAppId == null) {
                log.error("Get segments error, publisher app id is null!");
                return Response.RES_PARAMETER_ERROR;
            }
            List<JSONObject> rules = this.mediationService.getSegments(pubAppId, placementId, countries);
            if (CollectionUtils.isEmpty(rules)) {
                return Response.buildSuccess(rules);
            }
            List<Integer> ruleIds = new ArrayList<>();
            for (JSONObject result : rules) {
                Integer ruleId = result.getInteger("id");
                if (ruleId != null) {
                    ruleIds.add(ruleId);
                }
            }
            if (lastDays == null || lastDays <= 0) {
                lastDays = 1;
            }
            Date middleDay = DateUtils.addDays(new Date(), -lastDays);
            Map<Integer, JSONObject> latestRuleReportMap = this.getRuleReportMap(pubAppId, placementId, ruleIds, middleDay, DateUtils.addDays(new Date(), -1), countries);
            Map<Integer, JSONObject> secondRuleReportMap = this.getRuleReportMap(pubAppId, placementId, ruleIds, DateUtils.addDays(middleDay, -lastDays), DateUtils.addDays(middleDay, -1), countries);

            for (JSONObject rule : rules) {
                try {
                    Integer ruleId = rule.getInteger("id");
                    double fillRate = 0;
                    double ecpm = 0;
                    double fillRateB = 0;
                    double ecpmB = 0;
                    JSONObject ruleReport = latestRuleReportMap.get(ruleId);
                    if (ruleReport != null) {
                        float waterfallRequest = Util.getInt(ruleReport, "waterfallRequest");
                        float waterfallFilled = Util.getInt(ruleReport, "waterfallFilled");
                        if (waterfallRequest > 0) {
                            fillRate = (int) (waterfallFilled * 10000 / waterfallRequest) / 100D;
                        }
                        ecpm = ruleReport.getDouble("apiEcpm");
                    }
                    rule.put("fillRate", fillRate);
                    rule.put("ecpm", ecpm);
                    JSONObject ruleReportB = secondRuleReportMap.get(ruleId);
                    if (ruleReportB != null) {
                        double waterfallRequest = Util.getInt(ruleReportB, "waterfallRequest");
                        double waterfallFilled = Util.getInt(ruleReportB, "waterfallFilled");
                        if (waterfallRequest > 0) {
                            fillRateB = (int) (waterfallFilled * 10000 / waterfallRequest) / 100D;
                        }
                        ecpmB = ruleReportB.getDouble("apiEcpm");
                    }
                    rule.put("fillRateB", fillRateB);
                    rule.put("ecpmB", ecpmB);
                    double fillRateChainComparison = 0;
                    double ecpmChainComparison = 0;
                    if (fillRateB > 0) {
                        fillRateChainComparison = (int) ((fillRate - fillRateB) * 10000 / fillRateB) / 100D;
                    }
                    if (ecpmB > 0) {
                        ecpmChainComparison = (int) ((ecpm - ecpmB) * 10000 / ecpmB) / 100D;
                    }
                    rule.put("fillRateChainComparison", fillRateChainComparison);
                    rule.put("ecpmChainComparison", ecpmChainComparison);
                } catch (Exception e) {
                    log.error("Fill rule {} report error:", rule, e);
                }
            }
            return Response.buildSuccess(rules);
        } catch (Exception e) {
            log.error("Get placement rules error:", e);
        }
        return Response.RES_FAILED;
    }

    private Map<Integer, JSONObject> getRuleReportMap(Integer pubAppId, Integer placementId, List<Integer> ruleIds, Date dateBegin, Date dateEnd, String[] countries) {
        Map<Integer, JSONObject> ruleReports = new HashMap<>();
        try {
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            reportConditionDTO.setDimension(new String[]{"pubAppId", "placementId", "ruleId"});
            reportConditionDTO.setPubAppId(new Integer[]{pubAppId});
            reportConditionDTO.setPlacementId(new Integer[]{placementId});
            reportConditionDTO.setRuleId(ruleIds.toArray(new Integer[0]));
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(dateBegin));
            reportConditionDTO.setDateEnd(Util.getYYYYMMDD(dateEnd));
            Set<String> reportTypeSet = new HashSet<>();
            reportTypeSet.add("api");
            if (countries != null && countries.length > 0) {
                reportConditionDTO.setCountry(countries);
            }
            Response reportResponse = this.reportService.getReport(reportConditionDTO, reportTypeSet);
            if (reportResponse.getCode() != Response.SUCCESS_CODE) {
                return ruleReports;
            }
            List<JSONObject> reports = (List<JSONObject>) reportResponse.getData();
            for (JSONObject report : reports) {
                ruleReports.put(report.getInteger("ruleId"), report);
            }
        } catch (Exception e) {
            log.error("Get placement {} rule reports error:", placementId, e);
        }
        return ruleReports;
    }

    @RequestMapping(value = "/mediation/rule/instance_list", method = RequestMethod.GET)
    public Response getSegmentInstanceList(Integer pubAppId, Integer ruleId, Integer instanceId, String[] adNetworkIds,
                                           Integer placementId, Integer lastDays, String[] countries) {
        if (pubAppId == null) {
            log.warn("Get segment instances publisher app id must not be null");
            return Response.RES_PARAMETER_ERROR;
        }
        Response response = this.mediationService.getSegmentInstances(pubAppId, ruleId, instanceId, adNetworkIds, placementId);
        if (response.failed()) {
            return response;
        }
        OmPlacementRule rule = this.mediationService.getPlacementRule(ruleId);
        if (rule == null) {
            return response;
        }
        OmPlacementRuleSegmentWithBLOBs segment = this.mediationService.getPlacementRuleSegment(rule.getSegmentId());
        Set<String> ruleCountrySet = new HashSet<>();
        if (StringUtils.isNotBlank(segment.getCountries())) {
            String[] ruleCountries = segment.getCountries().split(",");
            Collections.addAll(ruleCountrySet, ruleCountries);
            if (ruleCountrySet.contains("00")) {
                ruleCountrySet.clear();
            }
        }
        Set<String> countrySet = new HashSet<>();
        if (countries != null) {
            Collections.addAll(countrySet, countries);
            if (countrySet.contains("00")) {
                countrySet.clear();
            }
        }
        if (!CollectionUtils.isEmpty(ruleCountrySet) && !CollectionUtils.isEmpty(countrySet)) {
            countrySet.retainAll(ruleCountrySet);
            if (CollectionUtils.isEmpty(countrySet)) {
                return response;
            }
        } else {
            countrySet.addAll(ruleCountrySet);
        }
        if (!CollectionUtils.isEmpty(countrySet)) {
            countries = new String[countrySet.size()];
            countrySet.toArray(countries);
        } else {
            countries = null;
        }

        Date middleDay = DateUtils.addDays(new Date(), -lastDays);
        Map<Integer, JSONObject> latestReportMap = this.getReportMap(pubAppId, placementId, middleDay, DateUtils.addDays(new Date(), -1), countries, ruleId);
        Map<Integer, JSONObject> secondLatestReportMap = this.getReportMap(pubAppId, placementId,
                DateUtils.addDays(middleDay, -lastDays), DateUtils.addDays(middleDay, -1), countries, ruleId);

        JSONArray resultInstances = (JSONArray) response.getData();
        for (Object resultInstance : resultInstances) {
            try {
                JSONObject instance = (JSONObject) resultInstance;
                Integer reportKey = Integer.parseInt(instance.getString("id"));
                JSONObject latestReport = latestReportMap.get(reportKey);

                if (latestReport != null) {
                    instance.put("instanceRequestLatest", latestReport.get("instanceRequest"));
                    instance.put("instanceFilledLatest", latestReport.get("instanceFilled"));
                    instance.put("mediationImprLatest", latestReport.get("mediationImpr"));
                    instance.put("apiImprLatest", latestReport.get("apiImpr"));
                    instance.put("costLatest", latestReport.get("cost"));

                    instance.put("bidRequestLatest", latestReport.get("bidReq"));
                    instance.put("bidResponseLatest", latestReport.get("bidResp"));
                    instance.put("bidWinLatest", latestReport.get("bidWin"));
                    instance.put("bidImpressionLatest", latestReport.get("mediationImpr"));
                    instance.put("bidWinPriceLatest", latestReport.get("bidWinPrice"));
                } else {
                    instance.put("instanceRequestLatest", 0);
                    instance.put("instanceFilledLatest", 0);
                    instance.put("mediationImprLatest", 0);
                    instance.put("apiImprLatest", 0);
                    instance.put("costLatest", 0);

                    instance.put("bidRequestLatest", 0);
                    instance.put("bidResponseLatest", 0);
                    instance.put("bidWinLatest", 0);
                    instance.put("bidImpressionLatest", 0);
                    instance.put("bidWinPriceLatest", 0);
                }

                JSONObject secondReport = secondLatestReportMap.get(reportKey);
                if (secondReport != null) {
                    instance.put("instanceRequestSecondLatest", secondReport.get("instanceRequest"));
                    instance.put("instanceFilledSecondLatest", secondReport.get("instanceFilled"));
                    instance.put("mediationImprSecondLatest", secondReport.get("mediationImpr"));
                    instance.put("apiImprSecondLatest", secondReport.get("apiImpr"));
                    instance.put("costSecondLatest", secondReport.get("cost"));

                    instance.put("bidRequestSecondLatest", secondReport.get("bidReq"));
                    instance.put("bidResponseSecondLatest", secondReport.get("bidResp"));
                    instance.put("bidWinSecondLatest", secondReport.get("bidWin"));
                    instance.put("bidImpressionSecondLatest", secondReport.get("mediationImpr"));
                    instance.put("bidWinPriceSecondLatest", secondReport.get("bidWinPrice"));
                } else {
                    instance.put("instanceRequestSecondLatest", 0);
                    instance.put("instanceFilledSecondLatest", 0);
                    instance.put("mediationImprSecondLatest", 0);
                    instance.put("apiImprSecondLatest", 0);
                    instance.put("costSecondLatest", 0);

                    instance.put("bidRequestSecondLatest", 0);
                    instance.put("bidResponseSecondLatest", 0);
                    instance.put("bidWinSecondLatest", 0);
                    instance.put("bidImpressionSecondLatest", 0);
                    instance.put("bidWinPriceSecondLatest", 0);
                }
            } catch (Exception e) {
                log.error("Fill report from instance {} error:", resultInstance, e);
            }
        }
        return Response.buildSuccess(resultInstances);
    }

    private Map<Integer, JSONObject> getReportMap(Integer pubAppId, Integer placementId, Date dateBegin, Date dateEnd, String[] countries, Integer ruleId) {
        Map<Integer, JSONObject> reportMap = new HashMap<>();
        try {
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            reportConditionDTO.setDimension(new String[]{"pubAppId", "placementId", "instanceId"});
            reportConditionDTO.setPubAppId(new Integer[]{pubAppId});
            reportConditionDTO.setPlacementId(new Integer[]{placementId});
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(dateBegin));
            reportConditionDTO.setDateEnd(Util.getYYYYMMDD(dateEnd));
            if (ruleId != null) {
                reportConditionDTO.setRuleId(new Integer[]{ruleId});
            }
            Set<String> reportTypeSet = new HashSet<>();
            reportTypeSet.add("api");
            if (countries != null && countries.length > 0) {
                reportConditionDTO.setCountry(countries);
            }
            Response reportResponse = this.reportService.getReport(reportConditionDTO, reportTypeSet);
            if (reportResponse.getCode() != Response.SUCCESS_CODE) {
                return reportMap;
            }
            List<JSONObject> reports = (List<JSONObject>) reportResponse.getData();
            for (JSONObject report : reports) {
                reportMap.put(report.getInteger("instanceId"), report);
            }
        } catch (Exception e) {
            log.error("Get {} reports error:", placementId, e);
        }
        return reportMap;
    }

    /**
     * Get segments
     *
     * @param pubAppId
     * @param ruleId
     * @param adNetworkIds
     * @param placementId
     */
    @RequestMapping(value = "/mediation/segment/instance/list", method = RequestMethod.GET)
    public Response getSegmentInstances(Integer pubAppId, Integer ruleId, Integer instanceId, String[] adNetworkIds,
                                        Integer placementId, Integer hourBefore) {
        try {
            if (pubAppId == null) {
                log.warn("Get segment instances publisher app id must not be null");
                return Response.RES_PARAMETER_ERROR;
            }
            Response response = this.mediationService.getSegmentInstances(pubAppId, ruleId, instanceId, adNetworkIds, placementId);
            if (response.failed()) {
                return response;
            }
            OmPlacementRule rule = this.mediationService.getPlacementRule(ruleId);
            if (rule == null) {
                return response;
            }
            OmPlacementRuleSegmentWithBLOBs segment = this.mediationService.getPlacementRuleSegment(rule.getSegmentId());
            String[] countries = null;
            if (segment != null && StringUtils.isNotBlank(segment.getCountries()) && !"00".equals(segment.getCountries())) {
                countries = segment.getCountries().split(",");
            }

            if (hourBefore == null) {
                hourBefore = 12;
            }
            Date currentHour = Util.getDateYYYYMMDDHH(Util.getDateString(new Date()));
            Date dateBegin = DateUtils.addHours(currentHour, -hourBefore);
            Map<String, JSONObject> latestHoursReportMap = this.getInstanceReportMap(pubAppId, placementId, dateBegin, currentHour, countries);
            Date doubleHoursBefore = DateUtils.addHours(dateBegin, -hourBefore);
            Map<String, JSONObject> secondHourReportMap = this.getInstanceReportMap(pubAppId, placementId, doubleHoursBefore, dateBegin, countries);

            Date currentDate = new Date();
            Map<String, JSONObject> firstEcpmMap;
            Map<String, JSONObject> secondEcpmMap;
            if (hourBefore <= 24) {
                dateBegin = DateUtils.addDays(currentDate, -1);
                Date dateEnd = currentDate;
                firstEcpmMap = this.getInstanceReportMap(pubAppId, placementId, dateBegin, dateEnd, countries);
                dateBegin = DateUtils.addDays(currentDate, -2);
                dateEnd = DateUtils.addDays(currentDate, -1);
                secondEcpmMap = this.getInstanceReportMap(pubAppId, placementId, dateBegin, dateEnd, countries);
            } else {
                dateBegin = DateUtils.addDays(currentDate, -2);
                Date dateEnd = DateUtils.addDays(currentDate, -1);
                firstEcpmMap = this.getInstanceReportMap(pubAppId, placementId, dateBegin, dateEnd, countries);
                dateBegin = DateUtils.addDays(currentDate, -3);
                dateEnd = DateUtils.addDays(currentDate, -2);
                secondEcpmMap = this.getInstanceReportMap(pubAppId, placementId, dateBegin, dateEnd, countries);
            }

            JSONArray resultInstances = (JSONArray) response.getData();
            for (Object resultInstance : resultInstances) {
                JSONObject instance = (JSONObject) resultInstance;
                String reportKey = instance.getString("id");
                JSONObject latestHoursReport = latestHoursReportMap.get(reportKey);
                if (latestHoursReport != null) {
                    instance.put("instanceRequestLatest", latestHoursReport.get("instanceRequest"));
                    instance.put("instanceFilledLatest", latestHoursReport.get("instanceFilled"));
                } else {
                    instance.put("instanceRequestLatest", 0);
                    instance.put("instanceFilledLatest", 0);
                }
                JSONObject secondHoursReport = secondHourReportMap.get(reportKey);
                if (secondHoursReport != null) {
                    instance.put("instanceRequestSecondLatest", secondHoursReport.get("instanceRequest"));
                    instance.put("instanceFilledSecondLatest", secondHoursReport.get("instanceFilled"));
                } else {
                    instance.put("instanceRequestSecondLatest", 0);
                    instance.put("instanceFilledSecondLatest", 0);
                }

                JSONObject firstReport = firstEcpmMap.get(reportKey);
                if (firstReport != null) {
                    instance.put("apiImprLatest", firstReport.get("apiImpr"));
                    instance.put("costLatest", firstReport.get("cost"));
                } else {
                    instance.put("apiImprLatest", 0);
                    instance.put("costLatest", 0);
                }
                JSONObject secondReport = secondEcpmMap.get(reportKey);
                if (secondReport != null) {
                    instance.put("apiImprSecondLatest", secondReport.get("apiImpr"));
                    instance.put("costSecondLatest", secondReport.get("cost"));
                } else {
                    instance.put("apiImprSecondLatest", 0);
                    instance.put("costSecondLatest", 0);
                }
            }
            return Response.buildSuccess(resultInstances);
        } catch (Exception e) {
            log.error("Get pubAppId {} ruleId {} segment instances error:", pubAppId, ruleId, e);
        }
        return Response.RES_FAILED;
    }

    private Map<String, JSONObject> getInstanceReportMap(Integer pubAppId, Integer placementId, Date dateBegin, Date dateEnd, String[] countries) {
        Map<String, JSONObject> reportMap = new HashMap<>();
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDimension(new String[]{"day", "hour", "pubAppId", "placementId", "instanceId"});
        reportConditionDTO.setPubAppId(new Integer[]{pubAppId});
        reportConditionDTO.setPlacementId(new Integer[]{placementId});
        reportConditionDTO.setDateBegin(Util.getYYYYMMDD(dateBegin));
        reportConditionDTO.setHourBegin(Util.getHour(dateBegin));
        reportConditionDTO.setDateEnd(Util.getYYYYMMDD(dateEnd));
        reportConditionDTO.setHourEnd(Util.getHour(dateEnd));
        Set<String> reportTypeSet = new HashSet<>();
        reportTypeSet.add("api");
        reportTypeSet.add("lr");
        if (countries != null && countries.length > 0) {
            reportConditionDTO.setCountry(countries);
        }
        Response reportResponse = this.reportService.getReport(reportConditionDTO, reportTypeSet);
        if (reportResponse.getCode() != Response.SUCCESS_CODE) {
            return reportMap;
        }
        List<JSONObject> reports = (List<JSONObject>) reportResponse.getData();
        for (JSONObject report : reports) {
            String instanceId = report.getString("instanceId");
            JSONObject instanceReport = reportMap.get(instanceId);
            if (instanceReport == null) {
                instanceReport = new JSONObject();
                reportMap.put(instanceId, instanceReport);
            }
            instanceReport.put("instanceRequest", Util.getInt(instanceReport, "instanceRequest") + Util.getInt(report, "instanceRequest"));
            instanceReport.put("instanceFilled", Util.getInt(instanceReport, "instanceFilled") + Util.getInt(report, "instanceFilled"));
            instanceReport.put("apiImpr", Util.getInt(instanceReport, "apiImpr") + Util.getInt(report, "apiImpr"));
            instanceReport.put("cost", Util.getFloat(instanceReport, "cost") + Util.getFloat(report, "cost"));
        }
        return reportMap;
    }

    /**
     * Create a new placement rule instance, enable a segment
     *
     * @see OmPlacementRuleInstance
     */
    @RequestMapping(value = "/mediation/segment/rule/instance/create", method = RequestMethod.POST)
    public Response createPlacementRuleInstance(@RequestBody OmPlacementRuleInstance omPlacementRuleInstance) {
        try {
            if (omPlacementRuleInstance.getAdnId() == null || omPlacementRuleInstance.getRuleId() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.createPlacementRuleInstance(omPlacementRuleInstance);
        } catch (Exception e) {
            log.error("Create placement rule instance error {}", JSONObject.toJSONString(omPlacementRuleInstance), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement rule instance failed!");
    }

    /**
     * Delete placement rule instance, it means do disable a segment
     *
     * @param ruleId
     * @param instanceId
     */
    @RequestMapping(value = "/mediation/segment/rule/instance/delete", method = RequestMethod.GET)
    public Response deletePlacementRuleInstance(Integer ruleId, Integer instanceId) {
        try {
            if (ruleId == null || instanceId == null) {
                log.error("Delete placement rule instance parameter error, ruleId {} instanceId {}", ruleId, instanceId);
                return Response.RES_PARAMETER_ERROR;
            }
            this.mediationService.deletePlacementRuleInstance(ruleId, instanceId);
            return Response.build();
        } catch (Exception e) {
            log.error("Delete placement rule {} instance id {} error,", ruleId, instanceId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Create a new placement rule, related to current user
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/rule/create", method = RequestMethod.POST)
    public Response createRule(@RequestBody OmPlacementRule omPlacementRule) {
        try {
            if (omPlacementRule.getName() == null || omPlacementRule.getPubAppId() == null || omPlacementRule.getPlacementId() == null) {
                log.error("Parameter {} not valid", JSONObject.toJSONString(omPlacementRule));
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.createPlacementRule(omPlacementRule);
        } catch (Exception e) {
            log.error("Create placement rule error {}", JSONObject.toJSONString(omPlacementRule), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Create placement rule failed!");
    }

    /**
     * Update placement rule information
     *
     * @see OmPlacementRule
     */
    @RequestMapping(value = "/mediation/segment/rule/update", method = RequestMethod.POST)
    public Response updatePlacementRule(@RequestBody OmPlacementRule omPlacementRule) {
        try {
            if (omPlacementRule.getId() == null) {
                log.error("Parameter {} not valid", JSONObject.toJSONString(omPlacementRule));
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.updatePlacementRule(omPlacementRule);
        } catch (Exception e) {
            log.error("Update placement rule error {}", JSONObject.toJSONString(omPlacementRule), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement rule failed!");
    }

    /**
     * Delete placement rule information
     *
     * @see OmPlacementRule
     */
    @RequestMapping(value = "/mediation/segment/rule/delete", method = RequestMethod.GET)
    public Response deletePlacementRule(Integer ruleId) {
        try {
            if (ruleId == null || ruleId <= 0) {
                log.error("Parameter ruleId {} not valid", ruleId);
                return Response.RES_PARAMETER_ERROR;
            }
            return this.mediationService.deletePlacementRule(ruleId);
        } catch (Exception e) {
            log.error("Delete placement rule {} error:", ruleId, e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get all placement rule instance
     *
     * @param ruleId
     * @param adnId
     */
    @RequestMapping(value = "/mediation/segment/rule/instance/list", method = RequestMethod.GET)
    public Response getPlacementRuleInstances(Integer ruleId, Integer adnId) {
        try {
            List<OmPlacementRuleInstance> placementRuleInstances = this.mediationService.getPlacementRuleInstances(ruleId, adnId);
            return Response.buildSuccess(placementRuleInstances);
        } catch (Exception e) {
            log.error("get placement rule instances error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Update placement rule instance information
     *
     * @see OmPlacementRuleInstance
     */
    @RequestMapping(value = "/mediation/segment/rule/instance/update", method = RequestMethod.POST)
    public Response updatePlacementRuleInstance(@RequestBody OmPlacementRuleInstance omPlacementRuleInstance) {
        try {
            if (omPlacementRuleInstance.getId() == null) {
                return Response.RES_PARAMETER_ERROR;
            }
            this.mediationService.updatePlacementRuleInstance(omPlacementRuleInstance);
            return Response.buildSuccess(omPlacementRuleInstance);
        } catch (Exception e) {
            log.error("Update placement rule instance error {}", JSONObject.toJSONString(omPlacementRuleInstance), e);
        }
        return Response.build(Response.CODE_DATABASE_ERROR, Response.STATUS_DISABLE, "Update placement rule instance failed!");
    }
}

