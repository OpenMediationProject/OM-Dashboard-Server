// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dao.OmPlacementRuleGroupMapper;
import com.adtiming.om.ds.dao.OmPlacementRuleInstanceMapper;
import com.adtiming.om.ds.dao.OmPlacementRuleMapper;
import com.adtiming.om.ds.dto.*;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.service.ABTestService;
import com.adtiming.om.ds.service.MediationService;
import com.adtiming.om.ds.service.ReportService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

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
    ABTestService abTestService;

    @Resource
    OmPlacementRuleGroupMapper omPlacementRuleGroupMapper;

    @Resource
    OmPlacementRuleMapper omPlacementRuleMapper;

    @Resource
    OmPlacementRuleInstanceMapper omPlacementRuleInstanceMapper;

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
                if (segmentDTO.getAbTest() == 1) {
                    this.abTestService.createABTestHistory(segmentDTO.getId(), segmentDTO.getTestName());
                    this.mediationService.clearGroup(segmentDTO.getId(), null);
                }
            }
            Map<String, OmPlacementRuleGroup> instanceLevelGroupIdMap = this.mediationService.getInstanceLevelGroupIdMap(segmentDTO.getId());
            Map<Integer, List<OmInstanceWithBLOBs>> groupIdInstanceMap = new HashMap<>();
            for (OmInstanceWithBLOBs instance : segmentDTO.getInstances()) {
                if (instance.getGroupLevel() == null) {
                    instance.setGroupLevel(1);
                }
                if (instance.getAutoSwitch() == null) {
                    instance.setAutoSwitch(2);
                }
                if (instance.getAbTest() == null) {
                    instance.setAbTest((byte)0);
                }
                OmPlacementRuleGroup group = instanceLevelGroupIdMap.get(instance.getGroupLevel() + "-" + instance.getAbTest());
                if (group == null) {
                    group = this.mediationService.addRuleGroup(segmentDTO.getId(), instance.getGroupLevel(), instance.getAbTest());
                    instanceLevelGroupIdMap.put(group.getGroupLevel() + "-" + group.getAbTest(), group);
                }
                instance.setGroupId(group.getId());
                List<OmInstanceWithBLOBs> groupIdInstances = groupIdInstanceMap.computeIfAbsent(instance.getGroupId(), k -> new ArrayList<>());
                groupIdInstances.add(instance);
            }
            for (List<OmInstanceWithBLOBs> groupInstances : groupIdInstanceMap.values()) {
                OmInstanceWithBLOBs instance = groupInstances.get(0);
                OmPlacementRuleGroup group = instanceLevelGroupIdMap.get(instance.getGroupLevel() + "-" + instance.getAbTest());
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

    @RequestMapping(value = "/mediation/stop_abtest", method = RequestMethod.GET)
    @Transactional
    public Response stopABTest(Integer ruleId, Integer abTest) {
        try {
            if (abTest == null) {
                log.error("Final abtest should not null");
                return Response.RES_PARAMETER_ERROR;
            }
            OmPlacementRule rule = this.mediationService.getPlacementRule(ruleId);
            if (rule == null) {
                log.error("Rule {} not exist", ruleId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            if (rule.getAbTest() == 0) {
                log.error("Rule {} not in abtest", ruleId);
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            rule.setAbTest((byte) 0);
            int result = this.omPlacementRuleMapper.updateByPrimaryKeySelective(rule);
            if (result <= 0) {
                throw new RuntimeException("Stop abtest failed, rule:" + JSONObject.toJSONString(rule));
            }
            List<Integer> ruleIds = new ArrayList<>();
            ruleIds.add(ruleId);
            List<OmPlacementRuleInstance> ruleInstances = this.mediationService.getPlacementRuleInstances(ruleIds);
            for (OmPlacementRuleInstance ruleInstance : ruleInstances) {
                //关闭非选中组，选中组ab_test=0
                if (ruleInstance.getAbTest() != abTest.intValue()) {
                    result = this.omPlacementRuleInstanceMapper.deleteByPrimaryKey(ruleInstance.getId());
                    if (result <= 0) {
                        throw new RuntimeException("Delete rule instance failed:" + JSONObject.toJSONString(ruleInstance));
                    }
                } else {
                    ruleInstance.setAbTest((byte) 0);
                    result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(ruleInstance);
                    if (result <= 0) {
                        throw new RuntimeException("Update rule instance failed:" + JSONObject.toJSONString(ruleInstance));
                    }
                    if (ruleInstance.getGroupId() != null && ruleInstance.getGroupId() > 0) {
                        OmPlacementRuleGroup group = this.omPlacementRuleGroupMapper.selectByPrimaryKey(ruleInstance.getGroupId());
                        if (group != null) {
                            group.setAbTest((byte) 0);
                            result = this.omPlacementRuleGroupMapper.updateByPrimaryKeySelective(group);
                            if (result <= 0) {
                                throw new RuntimeException("update instance group failed:" + JSONObject.toJSONString(group));
                            }
                        }
                    }
                }
            }
            this.mediationService.clearGroup(rule.getId(), ABTest.A);
            this.mediationService.clearGroup(rule.getId(), ABTest.B);
            Response ruleConf = this.getSegment(ruleId);
            Response instanceConf = this.getSegmentInstanceList(rule.getPubAppId(), ruleId, null, null, rule.getPlacementId(), 7, null);
            List<OmPlacementRuleAbt> historyList = this.abTestService.getABTestHistoryList(ruleId, SwitchStatus.ON);
            Response report = new Response();
            if (!CollectionUtils.isEmpty(historyList)) {
                report = this.getABTestReport(historyList.get(0), null, null, rule.getPlacementId(), null, null);
            }
            this.abTestService.saveABTestHistory(ruleId, abTest, ruleConf.toString(), instanceConf.toString(), report.toString());
            return Response.build();
        } catch (Exception e) {
            log.error("Stop rule {} ABTest {} error:", ruleId, abTest, e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return Response.STOP_ABTEST_FAILED;
    }

    @RequestMapping(value = "/mediation/get_abtest_report", method = RequestMethod.GET)
    public Response getABTestReport(Integer id, Integer instanceId, String[] adNetworkIds,
                                    Integer placementId, Integer lastDays, String[] countries) {
        try {
            OmPlacementRuleAbt history = this.abTestService.getABTestHistory(id);
            if (history == null) {
                return Response.RES_DATA_DOES_NOT_EXISTED;
            }
            if (history.getStatus() == 0) {
                if (history.getEndTime().getTime() - history.getCreateTime().getTime() > DateUtils.MILLIS_PER_DAY) {
                    return JSONObject.parseObject(history.getReport().toString(), Response.class);
                } else {
                    lastDays = null;
                }
            }
            return this.getABTestReport(history, instanceId, adNetworkIds, placementId, lastDays, countries);
        } catch (Exception e) {
            return Response.build(Response.CODE_RES_FAILED, Response.STATUS_DISABLE, e.getMessage());
        }
    }

    private Response getABTestReport(OmPlacementRuleAbt history, Integer instanceId, String[] adNetworkIds,
                                     Integer placementId, Integer lastDays, String[] countries) {
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDimension(new String[]{"ruleId", "abt"});
        reportConditionDTO.setRuleId(new Integer[]{history.getRuleId()});
        reportConditionDTO.setAbtId(new Integer[]{history.getId()});
        if (instanceId != null) {
            reportConditionDTO.setInstanceId(new Integer[]{instanceId});
        }
        if (placementId != null) {
            reportConditionDTO.setPlacementId(new Integer[]{placementId});
        }
        if (countries != null && countries.length > 0) {
            reportConditionDTO.setCountry(countries);
        }
        if (adNetworkIds != null && adNetworkIds.length > 0) {
            List<Integer> adNetworkIdList = new ArrayList<>();
            for (String adNetworkId : adNetworkIds) {
                adNetworkIdList.add(Integer.parseInt(adNetworkId));
            }
            reportConditionDTO.setAdnId(adNetworkIdList.toArray(new Integer[0]));
        }
        if (lastDays != null) {
            Date beginDate = DateUtils.addDays(new Date(), -lastDays);
            Date endDate = DateUtils.addDays(new Date(), -1);
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(beginDate));
            reportConditionDTO.setDateEnd(Util.getYYYYMMDD(endDate));
        } else {
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(history.getCreateTime()));
            if (history.getEndTime() != null) {
                reportConditionDTO.setDateEnd(Util.getYYYYMMDD(history.getEndTime()));
            } else {
                reportConditionDTO.setDateEnd(Util.getYYYYMMDD(new Date()));
            }
        }
        reportConditionDTO.setAbt(new Byte[]{1, 2});
        Set<String> reportTypeSet = new HashSet<>();
        Response response = this.reportService.getReport(reportConditionDTO, reportTypeSet);
        if (response.failed()) {
            return response;
        }
        List<JSONObject> reports = (List<JSONObject>)response.getData();
        if (CollectionUtils.isEmpty(reports)) {
            return response;
        }
        return Response.buildSuccess(this.buildReport(reports));
    }

    private List<JSONObject> buildReport(List<JSONObject> reports){
        List<JSONObject> results = new ArrayList<>();
        for (JSONObject r : reports) {
            JSONObject result = new JSONObject();
            result.put("impression", r.get("mediationImpr"));
            result.put("abt", r.get("abt"));
            Integer fills = r.getInteger("instanceFilled");
            if (fills != null) {
                result.put("fills", r.get("instanceFilled"));
            } else {
                fills = 0;
            }
            Double instanceRequest = r.getDouble("instanceRequest");
            if (instanceRequest != null) {
                result.put("request", r.get("instanceRequest"));
            } else {
                result.put("request", 0);
                instanceRequest = 0D;
            }
            Double ecpm = r.getDouble("apiEcpm");
            if (ecpm != null) {
                result.put("ecpm", r.get("apiEcpm"));
            } else {
                result.put("ecpm", 0);
            }
            if (instanceRequest > 0) {
                double fillRate = fills/instanceRequest;
                result.put("fillRate", ((int)(fillRate * 100))/100D);
            } else {
                result.put("fillRate", 0);
            }
            Double revenue = r.getDouble("cost");
            if (revenue != null) {
                result.put("revenue", r.get("cost"));
            } else {
                result.put("revenue", 0);
            }
            results.add(result);
        }
        return results;
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
    public Response getSegments(Integer pubAppId, Integer placementId, String[] countries, Integer lastDays, Integer instanceId, Integer status) {
        try {
            if (pubAppId == null) {
                log.error("Get segments error, publisher app id is null!");
                return Response.RES_PARAMETER_ERROR;
            }
            List<JSONObject> rules = this.mediationService.getSegments(pubAppId, placementId, countries, instanceId, SwitchStatus.getSwitchStatus(status));
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
            Map<Integer, List<OmPlacementRuleAbt>> abTestHistoryIdsMap = this.abTestService.getABTestHistoryIdsMap(ruleIds);

            for (JSONObject rule : rules) {
                try {
                    List<OmPlacementRuleAbt> abTestHistoryIds = abTestHistoryIdsMap.get(rule.getInteger("id"));
                    if (!CollectionUtils.isEmpty(abTestHistoryIds)) {
                        rule.put("abTestHistoryReports", abTestHistoryIds);
                    } else {
                        rule.put("abTestHistoryReports", new ArrayList<>());
                    }
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
        Map<String, JSONObject> latestReportMap = this.getReportMap(pubAppId, placementId, middleDay, DateUtils.addDays(new Date(), -1), countries, rule);
        Map<String, JSONObject> secondLatestReportMap = this.getReportMap(pubAppId, placementId,
                DateUtils.addDays(middleDay, -lastDays), DateUtils.addDays(middleDay, -1), countries, rule);

        JSONArray resultInstances = (JSONArray) response.getData();
        for (Object resultInstance : resultInstances) {
            try {
                JSONObject instance = (JSONObject) resultInstance;
                String reportKey = instance.getString("id") + "_" + instance.getString("abTest");
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

    private Map<String, JSONObject> getReportMap(Integer pubAppId, Integer placementId, Date dateBegin, Date dateEnd, String[] countries, OmPlacementRule rule) {
        Map<String, JSONObject> reportMap = new HashMap<>();
        try {
            ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
            reportConditionDTO.setDimension(new String[]{"pubAppId", "placementId", "instanceId", "abt"});
            reportConditionDTO.setPubAppId(new Integer[]{pubAppId});
            reportConditionDTO.setPlacementId(new Integer[]{placementId});
            reportConditionDTO.setDateBegin(Util.getYYYYMMDD(dateBegin));
            reportConditionDTO.setDateEnd(Util.getYYYYMMDD(dateEnd));
            if (rule != null) {
                reportConditionDTO.setRuleId(new Integer[]{rule.getId()});
                if (rule.getAbTest() != null && rule.getAbTest() == 1) {
                    reportConditionDTO.setAbt(new Byte[]{1, 2});
                    OmPlacementRuleAbt abt = this.abTestService.getCurrentABTest(rule.getId());
                    if (abt != null) {
                        reportConditionDTO.setAbtId(new Integer[]{abt.getId()});
                    }
                } else {
                    reportConditionDTO.setAbt(new Byte[]{0});
                }
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
                reportMap.put(report.getString("instanceId") + "_" + report.getString("abt"), report);
            }
        } catch (Exception e) {
            log.error("Get {} reports error:", placementId, e);
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

