// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.StatCp;
import com.adtiming.om.ds.service.FieldNameService;
import com.adtiming.om.ds.service.ReportService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Report interface
 *
 * @author dianbo ruan
 */
@RestController
public class ReportController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

    @Autowired
    ReportService reportService;

    @Autowired
    FieldNameService fieldNameService;

    /**
     * Get DAU report
     */
    @RequestMapping(value = "/report/list", method = RequestMethod.POST)
    public Response getReport(@RequestBody ReportConditionDTO reportConditionDTO) {
        if (reportConditionDTO.getDateBegin() == null || reportConditionDTO.getDateEnd() == null) {
            log.error("Date must not null");
            return Response.RES_PARAMETER_ERROR;
        }
        if (reportConditionDTO.getType() == null || reportConditionDTO.getType().length <= 0) {
            log.error("Report type must not empty");
            return Response.RES_PARAMETER_ERROR;
        }
        if (reportConditionDTO.getCountry() != null && reportConditionDTO.getCountry().length == 1
                && "00".equals(reportConditionDTO.getCountry()[0])){
            reportConditionDTO.setCountry(null);
        }
        Set<String> reportTypeSet = new HashSet<>(Arrays.asList(reportConditionDTO.getType()));
        return this.reportService.getReport(reportConditionDTO, reportTypeSet);
    }

    /**
     * Get dashboard head four revenues
     */
    @RequestMapping(value = "/report/dashboard/head/revenues", method = RequestMethod.GET)
    public Response getDashboardHeadRevenue(Integer pubAppId) {
        try {
            return this.reportService.getDashboardHeadRevenue(pubAppId);
        } catch (Exception e){
            log.error("GetDashboardHeadRevenue error:", e);
            return Response.build(Response.RES_FAILED.getCode(), Response.STATUS_DISABLE, e.getMessage());
        }
    }

    /**
     * Get dashboard regions revenue of seven days
     */
    @RequestMapping(value = "/report/dashboard/regions/revenues", method = RequestMethod.GET)
    public Response getRegionRevenue(Integer pubAppId) {
        return this.reportService.getRegionRevenue(pubAppId);
    }

    @RequestMapping(value = "/report/list/cross_bid", method = RequestMethod.POST)
    public Response getCrossBidReport(@RequestBody ReportConditionDTO reportConditionDTO) {
        try {
            List<StatCp> statCpList = this.reportService.getCrossBidReport(reportConditionDTO);
            if (CollectionUtils.isEmpty(statCpList)){
                return Response.buildSuccess(new JSONArray());
            }
            List<JSONObject> results = new ArrayList<>();
            statCpList.forEach(statCp -> {
                JSONObject result = (JSONObject)JSONObject.toJSON(statCp);
                result.put("day", Util.getYYYYMMDD(statCp.getDay()));
                result.put("impression", statCp.getImpr());
                result.put("imprCost", statCp.getWinPrice());
                results.add(result);
            });
            this.fieldNameService.fillName(results);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get cross bid report error, {}:", JSONObject.toJSON(reportConditionDTO), e);
            return Response.build(Response.RES_FAILED.getCode(), Response.STATUS_DISABLE, e.getMessage());
        }
    }
}
