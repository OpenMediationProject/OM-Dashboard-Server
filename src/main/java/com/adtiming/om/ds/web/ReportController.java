// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.StatAdnetwork;
import com.adtiming.om.ds.model.StatDau;
import com.adtiming.om.ds.model.StatLr;
import com.adtiming.om.ds.service.ReportService;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Report interface
 *
 * @author dianbo ruan
 */
@RestController
public class ReportController extends BaseController {

    @Autowired
    private ReportService reportService;

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
        Set<String> reportTypeSet = new HashSet<>();
        for (String type : reportConditionDTO.getType()) {
            reportTypeSet.add(type);
        }
        return this.reportService.getReport(reportConditionDTO, reportTypeSet);
    }

    /**
     * Get dashboard head four revenues
     */
    @RequestMapping(value = "/report/dashboard/head/revenues", method = RequestMethod.GET)
    public Response getDashboardHeadRevenue(Integer pubAppId) {
        return this.reportService.getDashboardHeadRevenue(pubAppId);
    }

    /**
     * Get dashboard regions revenue of seven days
     */
    @RequestMapping(value = "/report/dashboard/regions/revenues", method = RequestMethod.GET)
    public Response getRegionRevenue(Integer pubAppId) {
        return this.reportService.getRegionRevenue(pubAppId);
    }

    /**
     * Get DAU report
     */
    @RequestMapping(value = "/report/dau/list", method = RequestMethod.POST)
    public Response getDauReport(@RequestBody ReportConditionDTO reportConditionDTO, HttpServletResponse response) {
        try {
            if (reportConditionDTO.getDateBegin() == null || reportConditionDTO.getDateEnd() == null) {
                log.error("Date must not null");
                return Response.RES_PARAMETER_ERROR;
            }
            if (reportConditionDTO.getDimension() == null || reportConditionDTO.getDimension().length <= 0) {
                log.error("Dimensions must not empty");
                response.setStatus(HttpStatus.SC_BAD_REQUEST);
                return Response.RES_PARAMETER_ERROR;
            }
            List<StatDau> statDauList = reportService.getDauReport(reportConditionDTO);
            JSONArray resultDauArray = new JSONArray();
            for (StatDau statDau : statDauList) {
                JSONObject resultDau = (JSONObject) JSONObject.toJSON(statDau);
                if (resultDau.containsKey("day") && resultDau.get("day") != null) {
                    resultDau.put("day", Util.getYYYYMMDD(resultDau.getDate("day")));
                }
                resultDauArray.add(resultDau);
            }
            return Response.buildSuccess(resultDauArray);
        } catch (Exception e) {
            log.error("Get DAU report error {}", JSONObject.toJSONString(reportConditionDTO), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get LR report
     */
    @RequestMapping(value = "/report/lr/list", method = RequestMethod.POST)
    public Response geLRReport(@RequestBody ReportConditionDTO reportConditionDTO, HttpServletResponse response) {
        try {
            if (reportConditionDTO.getDateBegin() == null || reportConditionDTO.getDateEnd() == null) {
                log.error("Date must not null");
                return Response.RES_PARAMETER_ERROR;
            }
            if (reportConditionDTO.getDimension() == null || reportConditionDTO.getDimension().length <= 0) {
                log.error("Dimensions must not empty");
                response.setStatus(HttpStatus.SC_BAD_REQUEST);
                return Response.RES_PARAMETER_ERROR;
            }
            List<StatLr> statLrList = reportService.getLrReport(reportConditionDTO);
            JSONArray resultDauArray = new JSONArray();
            for (StatLr statLr : statLrList) {
                JSONObject resultLr = (JSONObject) JSONObject.toJSON(statLr);
                if (resultLr.containsKey("day") && resultLr.get("day") != null) {
                    resultLr.put("day", Util.getYYYYMMDD(resultLr.getDate("day")));
                }
                resultDauArray.add(resultLr);
            }
            return Response.buildSuccess(resultDauArray);
        } catch (Exception e) {
            log.error("Get LR report error {}", JSONObject.toJSONString(reportConditionDTO), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get ad network report
     */
    @RequestMapping(value = "/report/adnetwork/list", method = RequestMethod.POST)
    public Response geAdNetWorkReport(@RequestBody ReportConditionDTO reportConditionDTO) {
        try {
            if (reportConditionDTO.getDateBegin() == null || reportConditionDTO.getDateEnd() == null) {
                log.error("Date must not null");
                return Response.RES_PARAMETER_ERROR;
            }
            if (reportConditionDTO.getDimension() == null || reportConditionDTO.getDimension().length <= 0) {
                log.error("Dimensions must not empty");
                return Response.RES_PARAMETER_ERROR;
            }
            List<StatAdnetwork> statAdNetworkList = reportService.getAdNetworkReport(reportConditionDTO);
            JSONArray resultDauArray = new JSONArray();
            for (StatAdnetwork statAdnetwork : statAdNetworkList) {
                JSONObject resultAdNetworkReport = (JSONObject) JSONObject.toJSON(statAdnetwork);
                if (resultAdNetworkReport.containsKey("day") && resultAdNetworkReport.get("day") != null) {
                    resultAdNetworkReport.put("day", Util.getYYYYMMDD(resultAdNetworkReport.getDate("day")));
                }
                resultDauArray.add(resultAdNetworkReport);
            }
            return Response.buildSuccess(resultDauArray);
        } catch (Exception e) {
            log.error("Get LR report error {}", JSONObject.toJSONString(reportConditionDTO), e);
        }
        return Response.RES_FAILED;
    }
}
