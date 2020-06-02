// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.ReportBuilderDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmReportBuilderWithBLOBs;
import com.adtiming.om.ds.service.ReportBuilderService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Report builder interface
 *
 * @author dianbo ruan
 */
@RestController
public class ReportBuilderController {

    public static final String SPLIT_TAG = ",";

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    private ReportBuilderService reportBuilderService;

    /**
     * Get report builder by owner publisher id
     */
    @RequestMapping(value = "/report/builders", method = RequestMethod.GET)
    public Response getReportBuilders(Integer publisherId) {
        try {
            JSONArray results = new JSONArray();
            List<OmReportBuilderWithBLOBs> reportBuilders = reportBuilderService.getReportBuilders(publisherId);
            for (OmReportBuilderWithBLOBs reportBuilder : reportBuilders) {
                JSONObject result = (JSONObject) JSONObject.toJSON(reportBuilder);
                if (!StringUtils.isEmpty(reportBuilder.getDimensions())) {
                    result.put("dimensions", reportBuilder.getDimensions().split(SPLIT_TAG));
                } else {
                    result.put("dimensions", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getMetrics())) {
                    result.put("metrics", reportBuilder.getMetrics().split(SPLIT_TAG));
                } else {
                    result.put("metrics", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getCondPubAppList())) {
                    result.put("condPubAppList", Util.stringToInteger(reportBuilder.getCondPubAppList().split(SPLIT_TAG)));
                } else {
                    result.put("condPubAppList", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getCondPlacementList())) {
                    result.put("condPlacementList", Util.stringToInteger(reportBuilder.getCondPlacementList().split(SPLIT_TAG)));
                } else {
                    result.put("condPlacementList", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getCondInstanceList())) {
                    result.put("condInstanceList", Util.stringToInteger(reportBuilder.getCondInstanceList().split(SPLIT_TAG)));
                } else {
                    result.put("condInstanceList", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getCondAdnList())) {
                    result.put("condAdnList", Util.stringToInteger(reportBuilder.getCondAdnList().split(SPLIT_TAG)));
                } else {
                    result.put("condAdnList", Collections.EMPTY_LIST);
                }
                if (!StringUtils.isEmpty(reportBuilder.getCondCountryList())) {
                    result.put("condCountryList", reportBuilder.getCondCountryList().split(SPLIT_TAG));
                } else {
                    result.put("condCountryList", Collections.EMPTY_LIST);
                }
                results.add(result);
            }
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get report builders error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Do test
     *
     * @param id
     */
    @GetMapping(value = "/report/builder/test")
    public Response doTest(Integer id) {
        if (id == null) {
            log.error("Delete report builder id must not null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.reportBuilderService.doTest(id);
    }

    /**
     * Create a new report builder
     *
     * @see OmReportBuilderWithBLOBs
     */
    @RequestMapping(value = "/report/builder/create", method = RequestMethod.POST)
    public Response createReportBuilder(@RequestBody ReportBuilderDTO reportBuilder) {
        if (reportBuilder.getName() == null || reportBuilder.getDataSource() == null || reportBuilder.getSchedule() == null) {
            log.error("Create report builder parameter non valid {}", JSONObject.toJSONString(reportBuilder));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.reportBuilderService.createReportBuilder(reportBuilder.build());
    }

    /**
     * Update report builder
     *
     * @see OmReportBuilderWithBLOBs
     */
    @RequestMapping(value = "/report/builder/update", method = RequestMethod.POST)
    public Response updateReportBuilder(@RequestBody ReportBuilderDTO reportBuilder) {
        if (reportBuilder.getId() == null) {
            log.error("Update report builder parameter non valid {}", JSONObject.toJSONString(reportBuilder));
            return Response.RES_PARAMETER_ERROR;
        }
        return this.reportBuilderService.updateReportBuilder(reportBuilder.build());
    }

    /**
     * Delete report builder
     *
     * @param id
     */
    @PostMapping(value = "/report/builder/status/update")
    public Response updateReportBuilderStatus(Integer id, Integer status) {
        if (id == null || status == null || SwitchStatus.getSwitchStatus(status) == null) {
            log.error("Delete report builder id or status must not null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.reportBuilderService.updateReportBuilderStatus(id, SwitchStatus.getSwitchStatus(status));
    }

    /**
     * Delete report builder
     *
     * @param id
     */
    @PostMapping(value = "/report/builder/delete")
    public Response deleteReportBuilder(Integer id) {
        if (id == null) {
            log.error("Delete report builder id must not null");
            return Response.RES_PARAMETER_ERROR;
        }
        return this.reportBuilderService.deleteReportBuilder(id);
    }
}
