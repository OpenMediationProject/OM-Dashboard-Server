// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SegmentDTO;
import com.adtiming.om.ds.model.OmPlacementRule;
import com.adtiming.om.ds.model.OmPlacementRuleInstance;
import com.adtiming.om.ds.model.OmPlacementRuleSegmentWithBLOBs;
import com.adtiming.om.ds.service.MediationService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Mediation manage interface, it called segment in frontend, here it is placement rule and rule instance
 *
 * @author dianbo ruan
 */
@RestController
public class MediationController extends BaseController {

    @Autowired
    private MediationService mediationService;

    /**
     * Resort segment priority
     *
     * @param placementRuleInstanceIds
     */
    @RequestMapping(value = "/mediation/segment/resort/priority", method = RequestMethod.GET)
    public Response resortInstancesPriority(Integer[] placementRuleInstanceIds) {
        if (placementRuleInstanceIds == null || placementRuleInstanceIds.length <= 0) {
            log.error("Instance ids must not empty");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.resortWaterFallPriority(placementRuleInstanceIds);
    }

    /**
     * Resort placement rule priority
     *
     * @param placementRuleIds
     */
    @RequestMapping(value = "/mediation/rule/resort/priority", method = RequestMethod.GET)
    public Response resortRulePriority(Integer[] placementRuleIds) {
        if (placementRuleIds == null || placementRuleIds.length <= 0) {
            log.error("Rule ids must not empty");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.resortRulePriority(placementRuleIds);
    }

    /**
     * Create a new segment, related to current user
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/create", method = RequestMethod.POST)
    public Response createSegment(@RequestBody SegmentDTO segmentDTO) {
        if (segmentDTO.getName() == null || segmentDTO.getPubAppId() == null || segmentDTO.getPlacementId() == null) {
            log.error("Create segment parameter {} not valid", JSONObject.toJSONString(segmentDTO));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.createSegment(segmentDTO);
    }

    /**
     * Update segment information
     *
     * @see SegmentDTO
     */
    @RequestMapping(value = "/mediation/segment/update", method = RequestMethod.POST)
    public Response updateSegment(@RequestBody SegmentDTO segmentDTO) {
        if (segmentDTO.getId() == null || segmentDTO.getPubAppId() == null
                || segmentDTO.getPlacementId() == null || segmentDTO.getSegmentId() == null) {
            log.error("Parameter {} not valid", JSONObject.toJSONString(segmentDTO));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.updateSegment(segmentDTO);
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
                String interest = ruleSegment.getInterest();
                if (StringUtils.isNotBlank(interest)) {
                    resultRuleSegment.put("interest", interest.split(","));
                }
                String countries = ruleSegment.getCountries();
                if (StringUtils.isNotBlank(countries)) {
                    resultRuleSegment.put("countries", countries.split(","));
                }
                buildBrandBlackWhiteType(resultRuleSegment, ruleSegment.getBrandBlacklist(), ruleSegment.getBrandWhitelist());
                buildModelBlackWhiteType(resultRuleSegment, ruleSegment.getModelBlacklist(), ruleSegment.getModelWhitelist());

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
    public Response getSegments(Integer pubAppId, Integer placementId, String[] countries) {
        if (pubAppId == null) {
            log.error("Get segments error, publisher id is null!");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.getSegments(pubAppId, placementId, countries);
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
    public Response getSegmentInstances(Integer pubAppId, Integer ruleId, Integer instanceId, String[] adNetworkIds, Integer placementId) {
        if (pubAppId == null) {
            log.error("Get segment instances publisher app id must not be null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.getSegmentInstances(pubAppId, ruleId, instanceId, adNetworkIds, placementId);
    }

    /**
     * Create a new placement rule instance, enable a segment
     *
     * @see OmPlacementRuleInstance
     */
    @RequestMapping(value = "/mediation/segment/rule/instance/create", method = RequestMethod.POST)
    public Response createPlacementRuleInstance(@RequestBody OmPlacementRuleInstance omPlacementRuleInstance) {
        if (omPlacementRuleInstance.getAdnId() == null || omPlacementRuleInstance.getRuleId() == null) {
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.createPlacementRuleInstance(omPlacementRuleInstance);
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
        if (omPlacementRule.getName() == null || omPlacementRule.getPubAppId() == null || omPlacementRule.getPlacementId() == null) {
            log.error("Parameter {} not valid", JSONObject.toJSONString(omPlacementRule));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.createPlacementRule(omPlacementRule);
    }

    /**
     * Update placement rule information
     *
     * @see OmPlacementRule
     */
    @RequestMapping(value = "/mediation/segment/rule/update", method = RequestMethod.POST)
    public Response updatePlacementRule(@RequestBody OmPlacementRule omPlacementRule) {
        if (omPlacementRule.getId() == null) {
            log.error("Parameter {} not valid", JSONObject.toJSONString(omPlacementRule));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.updatePlacementRule(omPlacementRule);
    }

    /**
     * Delete placement rule information
     *
     * @see OmPlacementRule
     */
    @RequestMapping(value = "/mediation/segment/rule/delete", method = RequestMethod.GET)
    public Response deletePlacementRule(Integer ruleId) {
        if (ruleId == null || ruleId <= 0) {
            log.error("Parameter ruleId {} not valid", ruleId);
            return Response.RES_PARAMETER_ERROR;
        }
        return this.mediationService.deletePlacementRule(ruleId);
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
        return this.mediationService.updatePlacementRuleInstance(omPlacementRuleInstance);
    }
}

