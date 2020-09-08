// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmPlacementRuleInstanceMapper;
import com.adtiming.om.ds.dao.OmPlacementRuleMapper;
import com.adtiming.om.ds.dao.OmPlacementRuleSegmentMapper;
import com.adtiming.om.ds.dto.NormalStatus;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SegmentDTO;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Mediation Manager
 *
 * @author dianbo ruan
 */
@Service
@Transactional
public class MediationService extends BaseService {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    private AdNetworkService adNetworkService;

    @Autowired
    private InstanceService instanceService;

    @Resource
    private OmPlacementRuleMapper omPlacementRuleMapper;

    @Resource
    private OmPlacementRuleInstanceMapper omPlacementRuleInstanceMapper;

    @Resource
    private OmPlacementRuleSegmentMapper omPlacementRuleSegmentMapper;

    /**
     * Save mediation by instances
     *
     * @param ruleId
     * @param instanceArray
     * @return Response
     */
    public void saveRuleMediation(Integer ruleId, OmInstanceWithBLOBs[] instanceArray) {
        if (instanceArray == null || instanceArray.length <= 0) {
            return;
        }
        List<OmInstanceWithBLOBs> instances = new ArrayList<>();
        for (OmInstanceWithBLOBs omInstanceWithBLOBs : instanceArray) {
            if (omInstanceWithBLOBs.getPriority() == null) {
                omInstanceWithBLOBs.setPriority(-1);
            }
            instances.add(omInstanceWithBLOBs);
        }
        Map<Integer, OmPlacementRuleInstance> ruleMediationMap = this.getRuleMediationMap(ruleId);
        int priority = 1;
        for (OmInstanceWithBLOBs instance : instances) {
            OmPlacementRuleInstance ruleMediation = ruleMediationMap.get(instance.getPlacementRuleInstanceId());
            //when disable instance
            if ((ruleMediation != null) && ((instance.getPriority() == null) || (instance.getPriority() <= 0))) {
                int result = this.omPlacementRuleInstanceMapper.deleteByPrimaryKey(ruleMediation.getId());
                if (result <= 0) {
                    throw new RuntimeException("Delete rule mediation " + ruleMediation.getId() + " failed");
                }
                continue;
            }
            //when enable instance
            if (instance.getPriority() != null && instance.getPriority() > 0) {
                if (ruleMediation == null) {
                    ruleMediation = new OmPlacementRuleInstance();
                    ruleMediation.setStatus(NormalStatus.Active.ordinal());
                    ruleMediation.setAdnId(instance.getAdnId());
                    ruleMediation.setRuleId(ruleId);
                    ruleMediation.setInstanceId(instance.getId());
                    if (instance.getHbStatus() != null && instance.getHbStatus() == 1) {
                        ruleMediation.setPriority(1);
                    } else {
                        ruleMediation.setPriority(priority++);
                    }

                    int result = 0;
                    List<OmPlacementRuleInstance> dbRuleMediations = this.getPlacementRuleInstances(ruleMediation.getRuleId(),
                            ruleMediation.getAdnId(), ruleMediation.getInstanceId());
                    if (!CollectionUtils.isEmpty(dbRuleMediations)) {
                        ruleMediation.setId(dbRuleMediations.get(0).getId());
                        result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(ruleMediation);
                    } else {
                        result = this.omPlacementRuleInstanceMapper.insertSelective(ruleMediation);
                    }
                    if (result <= 0) {
                        throw new RuntimeException("Save new rule mediation " + JSONObject.toJSON(instance) + " failed.");
                    }
                } else {
                    ruleMediation.setStatus(NormalStatus.Active.ordinal());
                    ruleMediation.setAdnId(instance.getAdnId());
                    ruleMediation.setRuleId(ruleId);
                    ruleMediation.setInstanceId(instance.getId());
                    if (instance.getHbStatus() != null && instance.getHbStatus() == 1) {
                        ruleMediation.setPriority(1);
                    } else {
                        ruleMediation.setPriority(priority++);
                    }
                    int result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(ruleMediation);
                    if (result <= 0) {
                        throw new RuntimeException("Save rule mediation " + JSONObject.toJSON(instance) + " failed.");
                    }
                }
            }
        }
    }

    /**
     * Get all placement rules(Segment)
     *
     * @param pubAppId
     * @param placementId
     * @param countries
     */
    public Response getSegments(Integer pubAppId, Integer placementId, String[] countries) {
        List<OmPlacementRule> placementRules = getPlacementRules(pubAppId, placementId, null);
        if (CollectionUtils.isEmpty(placementRules)) {
            log.error("No segments for publisher app id {} placement id {}", pubAppId, placementId);
            return Response.buildSuccess(new JSONArray());
        }

        List<Integer> ruleIds = new ArrayList<>();
        List<Integer> segmentIds = new ArrayList<>();
        for (OmPlacementRule rule : placementRules) {
            ruleIds.add(rule.getId());
            segmentIds.add(rule.getSegmentId());
        }
        List<OmPlacementRuleInstance> ruleInstances = getPlacementRuleInstances(ruleIds);
        Map<Integer, List<OmPlacementRuleInstance>> ruleInstancesMap = ruleInstances.stream()
                .collect(Collectors.groupingBy(m -> m.getRuleId(), Collectors.toList()));
        Map<Integer, OmPlacementRuleSegmentWithBLOBs> placementRuleSegmentMap = getPlacementRuleSegmentMap(segmentIds, countries);

        JSONArray resultRules = new JSONArray();
        Map<Integer, OmAdnetwork> adNetworkMap = this.adNetworkService.getAdNetworkMap();
        Map<Integer, OmInstanceWithBLOBs> instanceMap = this.instanceService.getInstanceMap(pubAppId);
        for (OmPlacementRule placementRule : placementRules) {
            JSONObject resultRule = this.buildResultSegment(placementRule, ruleInstancesMap, adNetworkMap, instanceMap, placementRuleSegmentMap);
            if (resultRule != null) {
                resultRules.add(resultRule);
            }
        }
        return Response.buildSuccess(resultRules);
    }

    private JSONObject buildResultSegment(OmPlacementRule placementRule, Map<Integer, List<OmPlacementRuleInstance>> ruleInstancesMap,
                                          Map<Integer, OmAdnetwork> adNetworkMap, Map<Integer, OmInstanceWithBLOBs> instanceMap,
                                          Map<Integer, OmPlacementRuleSegmentWithBLOBs> placementRuleSegmentMap) {
        JSONObject resultRule = (JSONObject) JSONObject.toJSON(placementRule);
        OmPlacementRuleSegmentWithBLOBs omPlacementRuleSegment = placementRuleSegmentMap.get(placementRule.getSegmentId());
        if (omPlacementRuleSegment == null) {
            log.info("Rule id {} does filtered by country", placementRule.getId());
            return null;
        }

        JSONObject resultRuleSegment = (JSONObject) JSONObject.toJSON(omPlacementRuleSegment);
        resultRuleSegment.remove("id");
        resultRuleSegment.remove("priority");
        String countries = omPlacementRuleSegment.getCountries();
        if (StringUtils.isNotBlank(countries)) {
            resultRuleSegment.put("countries", countries.split(","));
        }

        resultRule.putAll(resultRuleSegment);
        if (placementRule.getAutoOpt() != null && placementRule.getAutoOpt() == 1) {
            resultRule.put("strategy", "Auto");
        } else {
            resultRule.put("strategy", "Manual");
        }
        List<OmPlacementRuleInstance> placementRuleInstances = ruleInstancesMap.get(placementRule.getId());
        if (!CollectionUtils.isEmpty(placementRuleInstances)) {
            JSONArray resultRuleInstances = new JSONArray();
            for (OmPlacementRuleInstance ruleInstance : placementRuleInstances) {
                JSONObject resultRuleInstance = (JSONObject) JSONObject.toJSON(ruleInstance);
                if (adNetworkMap.get(ruleInstance.getAdnId()) != null) {
                    resultRuleInstance.put("className", adNetworkMap.get(ruleInstance.getAdnId()).getClassName());
                }
                OmInstanceWithBLOBs instance = instanceMap.get(ruleInstance.getInstanceId());
                if (instance != null) {
                    resultRuleInstance.put("instanceName", instance.getName());
                }
                resultRuleInstances.add(resultRuleInstance);
            }
            this.sortByPriority(resultRuleInstances);
            resultRule.put("ruleInstanceSize", placementRuleInstances.size());
            resultRule.put("ruleInstances", resultRuleInstances);
        } else {
            resultRule.put("ruleInstanceSize", 0);
            resultRule.put("ruleInstances", new JSONArray());
        }
        return resultRule;
    }

    /**
     * Get segments which is instance with rule instances
     *
     * @param pubAppId
     * @param ruleId
     * @param adNetworkIds
     * @param placementId
     */
    public Response getSegmentInstances(Integer pubAppId, Integer ruleId, Integer instanceId, String[] adNetworkIds, Integer placementId) {
        List<OmInstanceWithBLOBs> placementInstances = this.instanceService.getInstances(pubAppId, adNetworkIds, instanceId, placementId, NormalStatus.Active);
        if (CollectionUtils.isEmpty(placementInstances)) {
            return Response.buildSuccess(Collections.EMPTY_LIST);
        }
        Map<Integer, OmAdnetwork> adNetworkMap = this.adNetworkService.getAdNetworkMap();
        Map<Integer, OmPlacementRuleInstance> instanceIdKeyRuleInstanceMap = new HashMap<>(); //when build new rule
        if (ruleId != null) {
            instanceIdKeyRuleInstanceMap = getInstanceIdKeyRuleInstanceMap(placementInstances, ruleId);
        }

        JSONArray resultInstances = new JSONArray();
        for (OmInstanceWithBLOBs instance : placementInstances) {
            JSONObject resultInstance = (JSONObject) JSONObject.toJSON(instance);
            if (adNetworkMap.get(instance.getAdnId()) != null) {
                resultInstance.put("className", adNetworkMap.get(instance.getAdnId()).getClassName());
            }
            OmPlacementRuleInstance placementRuleInstance = instanceIdKeyRuleInstanceMap.get(instance.getId());
            if (placementRuleInstance != null) {
                resultInstance.put("priority", placementRuleInstance.getPriority());
                resultInstance.put("placementRuleInstanceId", placementRuleInstance.getId());
            } else {
                resultInstance.remove("priority");
            }
            resultInstances.add(resultInstance);
        }
        this.sortByPriority(resultInstances);
        return Response.buildSuccess(resultInstances);
    }

    private void sortByPriority(JSONArray results) {
        try {
            results.sort((instance1, instance2) -> {
                Integer priority1 = ((JSONObject) instance1).getInteger("priority");
                Integer priority2 = ((JSONObject) instance2).getInteger("priority");
                if (priority1 == null && priority2 == null) {
                    return 0;
                }
                if (priority1 == null) {
                    return 1;
                }
                if (priority2 == null) {
                    return -1;
                }
                return priority1.compareTo(priority2);
            });
        } catch (Exception e) {
            log.error("Sort instance error:", e);
        }
    }

    public Response resortWaterFallPriority(Integer placementRuleInstanceId, Integer priority) {
        OmPlacementRuleInstance dbRuleInstance = this.omPlacementRuleInstanceMapper.selectByPrimaryKey(placementRuleInstanceId);
        List<OmPlacementRuleInstance> ruleInstanceList = this.getPlacementRuleInstances(dbRuleInstance.getRuleId(), null);
        int oldPriority = dbRuleInstance.getPriority();
        for (OmPlacementRuleInstance ruleInstance : ruleInstanceList) {
            if (ruleInstance.getId().equals(placementRuleInstanceId)) {
                if (priority > oldPriority) {
                    ruleInstance.setPriority(priority * 10 + 1);
                } else {
                    ruleInstance.setPriority(priority * 10 - 1);
                }
            } else {
                ruleInstance.setPriority(ruleInstance.getPriority() * 10);
            }
        }
        ruleInstanceList.sort(Comparator.comparingInt(OmPlacementRuleInstance::getPriority));
        int newPriority = 1;
        for (OmPlacementRuleInstance ruleInstance : ruleInstanceList) {
            ruleInstance.setPriority(newPriority++);
            int result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(ruleInstance);
            if (result <= 0) {
                throw new RuntimeException("Resort rule instance priority failed to update rule: " + JSONObject.toJSON(ruleInstance));
            }
        }
        return Response.build();
    }

    public Response resortRulePriority(Integer ruleId, Integer priority) {
        OmPlacementRule placementRule = this.getPlacementRule(ruleId);
        List<OmPlacementRule> placementRules = this.getPlacementRules(placementRule.getPubAppId(),
                placementRule.getPlacementId(), SwitchStatus.ON);
        if (CollectionUtils.isEmpty(placementRules)){
            return Response.build();
        }
        int oldPriority = placementRule.getPriority();
        for (OmPlacementRule rule : placementRules) {
            if (rule.getId().equals(ruleId)) {
                if (priority > oldPriority) {
                    rule.setPriority(priority * 10 + 1);
                } else {
                    rule.setPriority(priority * 10 - 1);
                }
            } else {
                rule.setPriority(rule.getPriority() * 10);
            }
        }
        placementRules.sort(Comparator.comparingInt(OmPlacementRule::getPriority));
        int newPriority = 1;
        for (OmPlacementRule rule : placementRules) {
            rule.setPriority(newPriority++);
            int result = this.omPlacementRuleMapper.updateByPrimaryKeySelective(rule);
            if (result <= 0) {
                throw new RuntimeException("Resort rule priority failed to update rule: " + JSONObject.toJSON(rule));
            }
        }
        return Response.build();
    }

    /**
     * Create a new placement rule, related to current user
     *
     * @see SegmentDTO
     */
    public Response createSegment(SegmentDTO segmentDTO) {
        OmPlacementRuleSegmentWithBLOBs ruleSegment = new OmPlacementRuleSegmentWithBLOBs();
        ruleSegment.setBrandBlacklist(segmentDTO.getBrandBlacklist());
        ruleSegment.setBrandWhitelist(segmentDTO.getBrandWhitelist());
        ruleSegment.setConType(segmentDTO.getConType());
        ruleSegment.setCountries(segmentDTO.getCountries());
        ruleSegment.setFrequency(segmentDTO.getFrequency());
        ruleSegment.setGender(segmentDTO.getGender());
        ruleSegment.setIapMax(segmentDTO.getIapMax());
        ruleSegment.setIapMin(segmentDTO.getIapMin());
        ruleSegment.setAgeMax(segmentDTO.getAgeMax());
        ruleSegment.setAgeMin(segmentDTO.getAgeMin());
        ruleSegment.setModelBlacklist(segmentDTO.getModelBlacklist());
        ruleSegment.setModelWhitelist(segmentDTO.getModelWhitelist());
        ruleSegment.setPlacementId(segmentDTO.getPlacementId());
        ruleSegment.setPriority(segmentDTO.getPriority());
        ruleSegment.setStatus(segmentDTO.getStatus());
        ruleSegment.setChannel(segmentDTO.getChannel());
        ruleSegment.setChannelBow(segmentDTO.getChannelBow());
        ruleSegment.setModelType(segmentDTO.getDeviceModelType());
        ruleSegment.setCreateTime(new Date());
        ruleSegment.setLastmodify(new Date());
        int result = this.omPlacementRuleSegmentMapper.insertSelective(ruleSegment);
        if (result <= 0) {
            throw new RuntimeException("Create placement rule segment error " + JSONObject.toJSONString(segmentDTO));
        }
        segmentDTO.setSegmentId(ruleSegment.getId());

        OmPlacementRule omPlacementRule = new OmPlacementRule();
        omPlacementRule.setSegmentId(ruleSegment.getId());
        omPlacementRule.setName(segmentDTO.getName());
        omPlacementRule.setPlacementId(segmentDTO.getPlacementId());
        omPlacementRule.setPubAppId(segmentDTO.getPubAppId());
        omPlacementRule.setAbTest(segmentDTO.getAbTest());
        omPlacementRule.setAutoOpt(segmentDTO.getAutoOpt());
        omPlacementRule.setPriority(segmentDTO.getPriority());
        omPlacementRule.setSortType(segmentDTO.getSortType());
        omPlacementRule.setStatus(segmentDTO.getStatus());
        Response response = this.createPlacementRule(omPlacementRule);
        if (response.getCode() != 0) {
            throw new RuntimeException("Create placement rule error " + JSONObject.toJSONString(segmentDTO));
        }
        segmentDTO.setId(omPlacementRule.getId());
        JSONObject resultRule = (JSONObject) JSONObject.toJSON(omPlacementRule);
        JSONObject resultRuleSegment = (JSONObject) JSONObject.toJSON(ruleSegment);
        resultRuleSegment.remove("id");
        resultRule.putAll(resultRuleSegment);
        return Response.buildSuccess(resultRule);
    }

    /**
     * update segment
     *
     * @see SegmentDTO
     */
    public Response updateSegment(SegmentDTO segmentDTO) {
        OmPlacementRuleSegmentWithBLOBs ruleSegment = new OmPlacementRuleSegmentWithBLOBs();
        ruleSegment.setId(segmentDTO.getSegmentId());
        ruleSegment.setBrandBlacklist(segmentDTO.getBrandBlacklist());
        ruleSegment.setBrandWhitelist(segmentDTO.getBrandWhitelist());
        ruleSegment.setConType(segmentDTO.getConType());
        ruleSegment.setCountries(segmentDTO.getCountries());
        ruleSegment.setFrequency(segmentDTO.getFrequency());
        ruleSegment.setGender(segmentDTO.getGender());
        ruleSegment.setIapMax(segmentDTO.getIapMax());
        ruleSegment.setIapMin(segmentDTO.getIapMin());
        ruleSegment.setAgeMax(segmentDTO.getAgeMax());
        ruleSegment.setAgeMin(segmentDTO.getAgeMin());
        ruleSegment.setModelBlacklist(segmentDTO.getModelBlacklist());
        ruleSegment.setModelWhitelist(segmentDTO.getModelWhitelist());
        ruleSegment.setPlacementId(segmentDTO.getPlacementId());
        ruleSegment.setPriority(segmentDTO.getPriority());
        ruleSegment.setStatus(segmentDTO.getStatus());
        ruleSegment.setChannel(segmentDTO.getChannel());
        ruleSegment.setChannelBow(segmentDTO.getChannelBow());
        ruleSegment.setModelType(segmentDTO.getDeviceModelType());
        ruleSegment.setLastmodify(new Date());
        int id = this.omPlacementRuleSegmentMapper.updateByPrimaryKeySelective(ruleSegment);
        if (id <= 0) {
            throw new RuntimeException("Update placement rule segment error " + JSONObject.toJSONString(segmentDTO));
        }

        OmPlacementRule omPlacementRule = new OmPlacementRule();
        omPlacementRule.setId(segmentDTO.getId());
        omPlacementRule.setSegmentId(ruleSegment.getId());
        omPlacementRule.setName(segmentDTO.getName());
        omPlacementRule.setPlacementId(segmentDTO.getPlacementId());
        omPlacementRule.setPubAppId(segmentDTO.getPubAppId());
        omPlacementRule.setAbTest(segmentDTO.getAbTest());
        omPlacementRule.setAutoOpt(segmentDTO.getAutoOpt());
        omPlacementRule.setPriority(segmentDTO.getPriority());
        omPlacementRule.setSortType(segmentDTO.getSortType());
        omPlacementRule.setStatus(segmentDTO.getStatus());
        Response response = this.updatePlacementRule(omPlacementRule);
        if (response.getCode() != 0) {
            throw new RuntimeException("Update placement rule error " + JSONObject.toJSONString(segmentDTO));
        }
        JSONObject resultRule = (JSONObject) JSONObject.toJSON(omPlacementRule);
        JSONObject resultRuleSegment = (JSONObject) JSONObject.toJSON(ruleSegment);
        resultRuleSegment.remove("id");
        resultRule.putAll(resultRuleSegment);
        return Response.buildSuccess(resultRule);
    }

    /**
     * Select placement rule
     *
     * @param ruleId
     */
    public OmPlacementRule getPlacementRule(Integer ruleId) {
        return this.omPlacementRuleMapper.selectByPrimaryKey(ruleId);
    }

    /**
     * Select placement rules
     *
     * @param pubAppId
     * @param placementId
     */
    public List<OmPlacementRule> getPlacementRules(Integer pubAppId, Integer placementId, SwitchStatus status) {
        OmPlacementRuleCriteria omPlacementRuleCriteria = new OmPlacementRuleCriteria();
        OmPlacementRuleCriteria.Criteria criteria = omPlacementRuleCriteria.createCriteria();
        if (pubAppId != null) {
            criteria.andPubAppIdEqualTo(pubAppId);
        }
        if (placementId != null) {
            criteria.andPlacementIdEqualTo(placementId);
        }
        if (status != null) {
            criteria.andStatusEqualTo((byte) status.ordinal());
        }
        omPlacementRuleCriteria.setOrderByClause(" create_time desc ");
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());
        criteria.andPublisherIdEqualTo(this.getCurrentPublisherId());
        List<OmPlacementRule> placementRules = this.omPlacementRuleMapper.select(omPlacementRuleCriteria);
        log.info("Get placement rules size: {}", placementRules.size());
        return placementRules;
    }

    /**
     * Build placement rule database object, and insert into database
     *
     * @param omPlacementRule
     * @return Response
     */
    public Response createPlacementRule(OmPlacementRule omPlacementRule) {
        Date currentTime = new Date();
        omPlacementRule.setCreateTime(currentTime);
        omPlacementRule.setLastmodify(currentTime);
        if (omPlacementRule.getPublisherId() == null || omPlacementRule.getPublisherId() <= 0) {
            Integer currentUserPublisherId = this.getCurrentUser().getPublisherId();
            if (currentUserPublisherId == null || currentUserPublisherId == 0) {
                log.error("No publisher with current user {}", JSONObject.toJSON(this.getCurrentUser()));
                return Response.RES_PUBLISHER_NOT_EXISTED;
            }
            omPlacementRule.setPublisherId(currentUserPublisherId);
        }
        omPlacementRule.setCreateUserId(this.getCurrentUser().getId());
        omPlacementRule.setPriority(Integer.MAX_VALUE);
        int id = this.omPlacementRuleMapper.insertSelective(omPlacementRule);
        if (id <= 0) {
            throw new RuntimeException("Create placement rule id: " + omPlacementRule.getId());
        }
        this.resortRulePriority(omPlacementRule.getPlacementId());
        return Response.buildSuccess(omPlacementRule);
    }

    /**
     * Delete placement rule database object
     *
     * @param ruleId
     * @return Response
     */
    public Response deletePlacementRule(Integer ruleId) {
        OmPlacementRule omPlacementRule = this.omPlacementRuleMapper.selectByPrimaryKey(ruleId);
        if (omPlacementRule == null) {
            log.info("Delete placement rule successfully, not existed!");
            return Response.build();
        }
        int result = this.omPlacementRuleMapper.deleteByPrimaryKey(ruleId);
        if (result <= 0) {
            throw new RuntimeException("Delete rule id " + ruleId + " failed!");
        }
        List<OmPlacementRuleInstance> placementRuleInstances = this.getPlacementRuleInstances(ruleId, null);
        for (OmPlacementRuleInstance ruleInstance : placementRuleInstances) {
            result = this.omPlacementRuleInstanceMapper.deleteByPrimaryKey(ruleInstance.getId());
            if (result <= 0) {
                throw new RuntimeException("Delete rule instance id " + ruleInstance.getId() + " failed!");
            }
        }
        return this.resortRulePriority(omPlacementRule.getPlacementId());
    }

    /**
     * Update placement rule database object
     *
     * @param omPlacementRule
     * @return Response
     */
    public Response updatePlacementRule(OmPlacementRule omPlacementRule) {
        if (omPlacementRule.getStatus() == null) {
            omPlacementRule.setStatus((byte) NormalStatus.Active.ordinal());
        }
        omPlacementRule.setLastmodify(new Date());
        int result = this.omPlacementRuleMapper.updateByPrimaryKeySelective(omPlacementRule);
        if (result <= 0) {
            throw new RuntimeException("Update rule error {}" + JSONObject.toJSONString(omPlacementRule));
        }
        log.info("Update placement rule id {}", omPlacementRule.getId());
        omPlacementRule = this.omPlacementRuleMapper.selectByPrimaryKey(omPlacementRule.getId());
        OmPlacementRuleSegmentWithBLOBs ruleSegment = this.omPlacementRuleSegmentMapper.selectByPrimaryKey(omPlacementRule.getSegmentId());
        if (ruleSegment == null) {
            throw new RuntimeException("Rule id " + omPlacementRule.getId() + " does not have a segment");
        }
        if (!omPlacementRule.getStatus().equals(ruleSegment.getStatus())) {
            ruleSegment.setStatus(omPlacementRule.getStatus());
            result = this.omPlacementRuleSegmentMapper.updateByPrimaryKeySelective(ruleSegment);
            if (result <= 0) {
                throw new RuntimeException("Update rule segment id " + omPlacementRule.getSegmentId() + " status " + omPlacementRule.getStatus() + " error");
            }
        }
        this.resortRulePriority(omPlacementRule.getPlacementId());
        log.info("Update rule segment id {} status {} successfully.", omPlacementRule.getSegmentId(), omPlacementRule.getStatus());
        return Response.buildSuccess(omPlacementRule);
    }

    public Response resortRulePriority(Integer placementId) {
        List<OmPlacementRule> placementRules = this.getPlacementRules(null, placementId, SwitchStatus.ON);
        placementRules.sort(Comparator.comparingInt(OmPlacementRule::getPriority));
        int priority = 1;
        for (OmPlacementRule rule : placementRules) {
            rule.setPriority(priority++);
            int result = this.omPlacementRuleMapper.updateByPrimaryKeySelective(rule);
            if (result <= 0) {
                throw new RuntimeException("Update rule id " + rule.getId() + " priority failed");
            }
        }
        return Response.build();
    }

    /**
     * Select placement rules instances
     *
     * @param ruleIds
     */
    public List<OmPlacementRuleInstance> getPlacementRuleInstances(List<Integer> ruleIds) {
        if (CollectionUtils.isEmpty(ruleIds)) {
            return Collections.EMPTY_LIST;
        }
        OmPlacementRuleInstanceCriteria omPlacementRuleInstanceCriteria = new OmPlacementRuleInstanceCriteria();
        OmPlacementRuleInstanceCriteria.Criteria criteria = omPlacementRuleInstanceCriteria.createCriteria();
        criteria.andRuleIdIn(ruleIds);
        List<OmPlacementRuleInstance> placementRuleInstances = this.omPlacementRuleInstanceMapper.select(omPlacementRuleInstanceCriteria);
        log.info("Get placement rule instances size: {}", placementRuleInstances.size());
        return placementRuleInstances;
    }

    /**
     * Select placement rule instance map
     *
     * @param ruleId
     * @return placementRuleInstances
     */
    public Map<Integer, OmPlacementRuleInstance> getRuleMediationMap(Integer ruleId) {
        Map<Integer, OmPlacementRuleInstance> ruleMediationMap = new HashMap<>();
        List<OmPlacementRuleInstance> ruleMediations = this.getPlacementRuleInstances(ruleId, null, null);
        ruleMediations.forEach(ruleMediation -> {
            ruleMediationMap.put(ruleMediation.getId(), ruleMediation);
        });
        return ruleMediationMap;
    }

    /**
     * Select placement rule instances
     *
     * @param placementInstances
     * @return placementRuleInstances
     */
    public Map<Integer, OmPlacementRuleInstance> getInstanceIdKeyRuleInstanceMap(List<OmInstanceWithBLOBs> placementInstances, Integer ruleId) {
        if (CollectionUtils.isEmpty(placementInstances)) {
            return Collections.EMPTY_MAP;
        }
        List<Integer> instanceIds = new ArrayList<>();
        for (OmInstanceWithBLOBs instance : placementInstances) {
            instanceIds.add(instance.getId());
        }
        OmPlacementRuleInstanceCriteria omPlacementRuleInstanceCriteria = new OmPlacementRuleInstanceCriteria();
        OmPlacementRuleInstanceCriteria.Criteria criteria = omPlacementRuleInstanceCriteria.createCriteria();
        criteria.andInstanceIdIn(instanceIds);
        if (ruleId != null) {
            criteria.andRuleIdEqualTo(ruleId);
        }
        List<OmPlacementRuleInstance> placementRuleInstances = this.omPlacementRuleInstanceMapper.select(omPlacementRuleInstanceCriteria);
        log.info("Get placement rule instances by instance id list size: {}", placementRuleInstances.size());
        Map<Integer, OmPlacementRuleInstance> instanceIdKeyRuleInstanceMap = new HashMap<>();
        for (OmPlacementRuleInstance ruleInstance : placementRuleInstances) {
            instanceIdKeyRuleInstanceMap.put(ruleInstance.getInstanceId(), ruleInstance);
        }
        return instanceIdKeyRuleInstanceMap;
    }

    /**
     * Select placement rule instances
     *
     * @param ruleId
     * @param adnId
     * @return placementRuleInstances
     */
    public List<OmPlacementRuleInstance> getPlacementRuleInstances(Integer ruleId, Integer adnId) {
        return this.getPlacementRuleInstances(ruleId, adnId, null);
    }

    /**
     * Select placement rule instances
     *
     * @param instanceId
     * @return placementRuleInstances
     */
    public List<OmPlacementRuleInstance> getPlacementRuleInstancesByInstance(Integer instanceId) {
        return this.getPlacementRuleInstances(null, null, instanceId);
    }

    /**
     * Select placement rule instances
     *
     * @param ruleId
     * @param adnId
     * @return placementRuleInstances
     */
    public List<OmPlacementRuleInstance> getPlacementRuleInstances(Integer ruleId, Integer adnId, Integer instanceId) {
        OmPlacementRuleInstanceCriteria omPlacementRuleInstanceCriteria = new OmPlacementRuleInstanceCriteria();
        OmPlacementRuleInstanceCriteria.Criteria criteria = omPlacementRuleInstanceCriteria.createCriteria();
        if (ruleId != null) {
            criteria.andRuleIdEqualTo(ruleId);
        }
        if (adnId != null) {
            criteria.andAdnIdEqualTo(adnId);
        }
        if (instanceId != null) {
            criteria.andInstanceIdEqualTo(instanceId);
        }
        List<OmPlacementRuleInstance> placementRuleInstances = this.omPlacementRuleInstanceMapper.select(omPlacementRuleInstanceCriteria);
        log.info("Get placement rule instances size: {}", placementRuleInstances.size());
        return placementRuleInstances;
    }

    /**
     * Build placement rule instance database object, and insert into database, enable a segment,
     * set priority to the biggest one add 1
     *
     * @param omPlacementRuleInstance
     * @return Response
     */
    public Response createPlacementRuleInstance(OmPlacementRuleInstance omPlacementRuleInstance) {
        Date currentTime = new Date();
        omPlacementRuleInstance.setCreateTime(currentTime);
        omPlacementRuleInstance.setLastmodify(currentTime);
        if (omPlacementRuleInstance.getUserId() == null || omPlacementRuleInstance.getUserId() <= 0) {
            omPlacementRuleInstance.setUserId(this.getCurrentUser().getId());
        }
        OmInstanceWithBLOBs instance = this.instanceService.getInstance(omPlacementRuleInstance.getInstanceId());
        if (instance.getHbStatus() == 1) {
            List<OmPlacementRuleInstance> ruleInstances = this.getPlacementRuleInstances(omPlacementRuleInstance.getRuleId(),
                    omPlacementRuleInstance.getAdnId());
            if (!CollectionUtils.isEmpty(ruleInstances)) {
                for (OmPlacementRuleInstance ruleInstance : ruleInstances) {
                    log.info("ruleInstance_id: {}", ruleInstance.getInstanceId());
                    OmInstanceWithBLOBs existedAdnInstance = this.instanceService.getInstance(ruleInstance.getInstanceId());
                    if (existedAdnInstance.getHbStatus() == 1) {
                        log.error("There already has head biding for this adn id {}", omPlacementRuleInstance.getAdnId());
                        return Response.build(Response.CODE_RES_DATA_EXISTED, Response.STATUS_DISABLE,
                                "Already existed header biding instance of this AdNetwork!");
                    }
                }
            }
        }
        List<OmPlacementRuleInstance> omPlacementRuleInstances = this.getPlacementRuleInstances(omPlacementRuleInstance.getRuleId(), null);
        omPlacementRuleInstance.setPriority(omPlacementRuleInstances.size() + 1);
        int result = this.omPlacementRuleInstanceMapper.insertSelective(omPlacementRuleInstance);
        if (result <= 0) {
            throw new RuntimeException("Create placement rule instance " + JSONObject.toJSON(omPlacementRuleInstance) + " failed!");
        }
        return Response.buildSuccess(omPlacementRuleInstance);
    }

    /**
     * Update placement rule instance database object
     *
     * @param omPlacementRuleInstance
     * @return Response
     */
    public void updatePlacementRuleInstance(OmPlacementRuleInstance omPlacementRuleInstance) {
        omPlacementRuleInstance.setLastmodify(new Date());
        int result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(omPlacementRuleInstance);
        if (result <= 0) {
            throw new RuntimeException("Update placement rule instance id " + omPlacementRuleInstance.getId());
        }
    }

    /**
     * Delete placement rule instance database object
     *
     * @param ruleId
     * @param instanceId
     * @return Response
     */
    public void deletePlacementRuleInstance(Integer ruleId, Integer instanceId) {
        List<OmPlacementRuleInstance> ruleInstances = this.getPlacementRuleInstances(ruleId, null);
        Iterator<OmPlacementRuleInstance> instanceIterator = ruleInstances.iterator();
        while (instanceIterator.hasNext()) {
            OmPlacementRuleInstance ruleInstance = instanceIterator.next();
            if (instanceId.equals(ruleInstance.getInstanceId())) {
                int result = this.omPlacementRuleInstanceMapper.deleteByPrimaryKey(ruleInstance.getId());
                if (result > 0) {
                    log.info("Delete placement pule instance id: {} successfully", ruleInstance.getId());
                    instanceIterator.remove();
                    break;
                } else {
                    throw new RuntimeException("Delete placement pule instance error, id: " + ruleInstance.getId());
                }
            }
        }
        ruleInstances.sort(Comparator.comparingInt(OmPlacementRuleInstance::getPriority));
        int priority = 1;
        for (OmPlacementRuleInstance ruleInstance : ruleInstances) {
            ruleInstance.setPriority(priority++);
            int result = this.omPlacementRuleInstanceMapper.updateByPrimaryKeySelective(ruleInstance);
            if (result > 0) {
                log.info("Update placement pule instance id {} successfully", ruleInstance.getId());
            } else {
                throw new RuntimeException("Update placement pule instance error, id: " + ruleInstance.getId());
            }
        }
    }

    /**
     * Select placement rule segment
     *
     * @param segmentIds
     * @return placementRuleSegmentMap
     */
    public Map<Integer, OmPlacementRuleSegmentWithBLOBs> getPlacementRuleSegmentMap(List<Integer> segmentIds, String[] countries) {
        try {
            OmPlacementRuleSegmentCriteria omPlacementRuleSegmentCriteria = new OmPlacementRuleSegmentCriteria();
            OmPlacementRuleSegmentCriteria.Criteria criteria = omPlacementRuleSegmentCriteria.createCriteria();
            criteria.andIdIn(segmentIds);
            if (countries != null && countries.length > 0) {
                for (String country : countries) {
                    criteria.andCountriesLike("%" + country + "%");
                }
            }
            List<OmPlacementRuleSegmentWithBLOBs> ruleSegments = this.omPlacementRuleSegmentMapper.selectWithBLOBs(omPlacementRuleSegmentCriteria);
            if (!CollectionUtils.isEmpty(ruleSegments)) {
                Map<Integer, OmPlacementRuleSegmentWithBLOBs> segmentMap = new HashMap<>();
                for (OmPlacementRuleSegmentWithBLOBs segment : ruleSegments) {
                    segmentMap.put(segment.getId(), segment);
                }
                return segmentMap;
            }
        } catch (Exception e) {
            log.error("Get placement rule segments error {}", JSONObject.toJSONString(segmentIds), e);
        }
        return Collections.EMPTY_MAP;
    }

    /**
     * Select placement rule segment
     *
     * @param segmentId
     * @return placementRuleInstances
     */
    public OmPlacementRuleSegmentWithBLOBs getPlacementRuleSegment(Integer segmentId) {
        return this.omPlacementRuleSegmentMapper.selectByPrimaryKey(segmentId);
    }
}
