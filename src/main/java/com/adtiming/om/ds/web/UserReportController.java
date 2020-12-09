// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;


import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.service.UserReportService;
import com.adtiming.om.ds.util.MapHelper;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * User LTV and Retention Report
 *
 * @author dianbo.ruan
 * <p>
 * UPDATE `open_mediation`.`um_permission` SET `api_path` = '/report/list\n/report/dau/list\n/report/lr/list\n/report/adnetwork/list\n/report/ltv\n/report/ltv/chart\n/report/retention\n/report/retention/chart' WHERE (`id` = '1800');
 */
@RestController
public class UserReportController extends BaseController {

    private static final Logger log = LogManager.getLogger();

    @Resource
    UserReportService userReportService;

    /**
     * Get LTV report
     */
    @RequestMapping(value = "/report/ltv", method = RequestMethod.POST)
    public Response getLTV(@RequestParam MultiValueMap<String, String> ps) {
        try {
            String dateEnd = ps.getFirst("dateEnd").replace("-", "");
            String today = Util.getYYYYMMDD(new Date());
            ps.remove("dateEnd");
            ps.set("dateEnd", today);
            List<Map<String, Object>> baseReports = this.userReportService.getNewUserReport(ps);
            List<Map<String, Object>> newUserRetentionReports = this.userReportService.getLtvData(baseReports);
            List<JSONObject> results = this.userReportService.buildRetentionResults(ps.getFirst("dateBegin"), today, newUserRetentionReports);
            results.removeIf(result -> {
                if ("Mean".equals(result.getString("base_date"))) {
                    return true;
                }
                if (result.getString("base_date").compareTo(dateEnd) > 0) {
                    return true;
                }
                return false;
            });
            JSONObject mean = this.buildMean(results);
            results.add(mean);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get LTV {} error:", JSONObject.toJSON(ps), e);
        }
        return Response.RES_FAILED;
    }

    private JSONObject buildMean(List<JSONObject> reports) {
        JSONObject mean = new JSONObject();
        mean.put("base_date", "Mean");
        for (JSONObject report : reports) {
            for (int i = 0; i < 31; i++) {
                String keyUser = "day" + i + "_u_c";
                String keyRevenue = "day" + i + "_r_c";
                if (report.containsKey(keyUser)) {
                    mean.put(keyUser, MapHelper.getInt(mean, keyUser) + MapHelper.getInt(report, keyUser));
                }
                if (report.containsKey(keyRevenue)) {
                    mean.put(keyRevenue, MapHelper.getDouble(mean, keyRevenue) + MapHelper.getDouble(report, keyRevenue));
                }
            }
        }
        return mean;
    }

    /**
     * Get LTV Chart Data
     */
    @RequestMapping(value = "/report/ltv/chart", method = RequestMethod.POST)
    public Response getLTVChartData(@RequestParam MultiValueMap<String, String> ps) {
        return this.userReportService.getLtvChartData(ps);
    }

    /**
     * Get retention report
     */
    @RequestMapping(value = "/report/retention", method = RequestMethod.POST)
    public Response retentionReport(@RequestParam MultiValueMap<String, String> ps) {
        try {
            String dateEnd = ps.getFirst("dateEnd").replace("-", "");
            String today = Util.getYYYYMMDD(new Date());
            ps.remove("dateEnd");
            ps.set("dateEnd", today);
            List<Map<String, Object>> list = userReportService.getNewUserReport(ps);
            List<Map<String, Object>> retentionReports = userReportService.getRetentionData(list);
            List<JSONObject> results = this.userReportService.buildRetentionResults(ps.getFirst("dateBegin"), ps.getFirst("dateEnd"), retentionReports);
            results.removeIf(result -> {
                if ("Mean".equals(result.getString("base_date"))) {
                    return true;
                }
                if (result.getString("base_date").compareTo(dateEnd) > 0) {
                    return true;
                }
                return false;
            });
            JSONObject mean = this.buildMean(results);
            results.add(mean);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get LTV {} error:", JSONObject.toJSON(ps), e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get retention chart data
     */
    @RequestMapping(value = "/report/retention/chart", method = RequestMethod.POST)
    public Response retentionChartData(@RequestParam MultiValueMap<String, String> ps) {
        String dateEnd = ps.getFirst("dateEnd").replace("-", "");
        String today = Util.getYYYYMMDD(new Date());
        ps.remove("dateEnd");
        ps.set("dateEnd", today);

        List<Map<String, Object>> results = userReportService.getNewUserReport(ps);
        results.removeIf(result -> {
            if ("Mean".equals(result.get("base_date").toString())) {
                return true;
            }
            if (dateEnd.compareTo(result.get("base_date").toString()) < 0) {
                return true;
            }
            return false;
        });
        return Response.buildSuccess(userReportService.retentionChartData(ps, results));
    }

}
