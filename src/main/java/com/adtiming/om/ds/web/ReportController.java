// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.service.ReportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Report interface
 *
 * @author dianbo ruan
 */
@RestController
public class ReportController extends BaseController {

    protected static final Logger log = LogManager.getLogger();

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
}
