// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.StatUserLtvMapper;
import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.StatUserLtv;
import com.adtiming.om.ds.model.StatUserLtvCriteria;
import com.adtiming.om.ds.util.MapHelper;
import com.adtiming.om.ds.util.Util;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * User LTV and Retention Report
 *
 * @author dianbo.ruan
 */
@Service
public class UserReportService extends BaseService {

    private static final Logger log = LogManager.getLogger();

    private static final JSONObject RETENTION_DATA_TEMPLATE = JSONObject.parseObject("{" +
            "\"retention_cnt_new\": 0," +
            "\"total_value_new\": 0," +
            "\"retention_day\": \"0\"," +
            "\"base_date\": \"0\"," +
            "\"d\": \"0\"," +
            "\"user_cnt_new\": 0," +
            "\"adt_value_new\": 0.0," +
            "\"iap_value_new\": 0.0," +
            "\"mediation_value_new\": 0," +
            "}");

    @Resource
    FieldNameService fieldNameService;

    @Resource
    StatUserLtvMapper statUserLtvMapper;

    public List<Map<String, Object>> getReport(MultiValueMap<String, String> ps) {
        List<String> dimensions = ps.get("dimensions");
        if (dimensions == null) {
            dimensions = new ArrayList<>();
        }
        dimensions.add("day");
        Map<String, Object> conditionMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(dimensions)) {
            for (String dimension : dimensions) {
                conditionMap.put("dimension_" + dimension, dimension);
            }
        }

        StatUserLtvCriteria statLtvCriteria = new StatUserLtvCriteria();
        StatUserLtvCriteria.Criteria criteria = statLtvCriteria.createCriteria();
        criteria.andDayGreaterThanOrEqualTo(Util.getDateYYYYMMDD(ps.getFirst("dateBegin")));
        criteria.andDayLessThanOrEqualTo(Util.getDateYYYYMMDD(ps.getFirst("dateEnd")));
        criteria.andPublisherIdEqualTo(this.getCurrentUser().getPublisherId());
        criteria.andPubAppIdIn(this.getAppIdsOfCurrentUser());

        List<String> publisherAppIds = ps.get("s_publisher_app_id");
        if (!CollectionUtils.isEmpty(publisherAppIds)) {
            List<Integer> appIds = new ArrayList<>();
            publisherAppIds.forEach(publisherAppId -> appIds.add(Integer.parseInt(publisherAppId)));
            criteria.andPubAppIdIn(appIds);
        }

        List<String> countries = ps.get("s_country");
        if (!CollectionUtils.isEmpty(countries)) {
            criteria.andCountryIn(countries);
        }

        List<String> baseDates = ps.get("s_base_date");
        if (!CollectionUtils.isEmpty(baseDates)) {
            List<Date> baseDays = new ArrayList<>();
            baseDates.forEach(baseDate -> baseDays.add(Util.getDateYYYYMMDD(baseDate)));
            criteria.andBaseDateIn(baseDays);
        }

        if (!CollectionUtils.isEmpty(statLtvCriteria.getOredCriteria())) {
            conditionMap.put("summaryWhereClause", statLtvCriteria.getOredCriteria());
        }
        List<StatUserLtv> ltvList = this.statUserLtvMapper.selectSummary(conditionMap);
        log.info("Get Ltv summary size {} condition {}", ltvList.size(), JSONObject.toJSONString(ps));
        List<Map<String, Object>> results = new ArrayList<>();
        for (StatUserLtv ltv : ltvList) {
            Map<String, Object> result = new HashMap<>();
            result.put("d", Util.getYYYYMMDD(ltv.getDay()));
            if (ltv.getPubAppId() != null && ltv.getPubAppId() > 0) {
                result.put("publisher_app_id", ltv.getPubAppId());
                result.put("pub_app_id", ltv.getPubAppId());
            }
            if (!StringUtils.isBlank(ltv.getCountry())) {
                result.put("country", ltv.getCountry());
            }
            result.put("total_value_new", ltv.getTotalValueNew());
            result.put("iap_value_new", ltv.getIapValueNew());
            result.put("retention_day", ltv.getRetentionDay().toString());
            result.put("base_date", Util.getNumYYYYMMDD(ltv.getBaseDate()));
            result.put("user_cnt_new", ltv.getUserCntNew());
            result.put("retention_cnt_new", ltv.getRetentionCntNew());
            result.put("mediation_value_new", ltv.getMediationValueNew());
            results.add(result);
        }
        return results;
    }

    public List<Map<String, Object>> getNewUserReport(MultiValueMap<String, String> ps) {
        if (ps.get("s_country") != null && ps.get("s_country").contains("ALL")) {
            ps.remove("s_country");
        }
        LocalDate lBegin = LocalDate.parse(Objects.requireNonNull(ps.getFirst("dateBegin")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate lEnd = LocalDate.parse(Objects.requireNonNull(ps.getFirst("dateEnd")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        while (lBegin.isBefore(lEnd)) {
            ps.add("s_base_date", lBegin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            lBegin = lBegin.plusDays(1);
        }
        ps.add("s_base_date", lBegin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        List<Map<String, Object>> results = this.getReport(ps);
        List<String> queryPaymentTypes = ps.get("queryPaymentType");
        if (!CollectionUtils.isEmpty(queryPaymentTypes) && queryPaymentTypes.size() == 1) {
            /**
             * 只选IAA = adt_value_new + mediation_value_new
             * 只选IAP = iap_value_new
             * IAA和IAP都选 = total_value_new 或者 adt_value_new + mediation_value_new + iap_value_new
             * **/
            String paymentType = queryPaymentTypes.get(0);
            for (Map<String, Object> result : results) {
                if ("IAA".equals(paymentType)) {
                    BigDecimal adtValueNew = MapHelper.getBigDecimal(result, "adt_value_new") == null
                            ? BigDecimal.ZERO : MapHelper.getBigDecimal(result, "adt_value_new");
                    BigDecimal mediationValueNew = MapHelper.getBigDecimal(result, "mediation_value_new") == null
                            ? BigDecimal.ZERO : MapHelper.getBigDecimal(result, "mediation_value_new");
                    result.put("total_value_new", adtValueNew.add(mediationValueNew));
                } else if ("IAP".equals(paymentType)) {
                    BigDecimal iapValueNew = MapHelper.getBigDecimal(result, "iap_value_new") == null
                            ? BigDecimal.ZERO : MapHelper.getBigDecimal(result, "iap_value_new");
                    result.put("total_value_new", iapValueNew);
                }
            }
        }
        Iterator<Map<String, Object>> iterator = results.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> report = iterator.next();
            if (report.containsKey("country")) {
                Object country = report.get("country");
                if (country == null) {
                    iterator.remove();
                    continue;
                }
                if (!Util.isCountryCode(country.toString())) {
                    iterator.remove();
                }
            }
        }
        return results;
    }

    public List<JSONObject> buildRetentionResults(String dateBegin, String dateEnd, List<Map<String, Object>> retentionReports) {
        Map<String, Map<String, Object>> newUserDataDayMap = new HashMap<>();
        JSONObject meanData = null;
        for (Map<String, Object> data : retentionReports) {
            if (data.containsKey("d")) {
                String day = data.get("base_date").toString();
                newUserDataDayMap.put(day, data);
            } else if ("Mean".equals(data.get("base_date").toString())) {
                meanData = new JSONObject(data);
            }
        }
        LocalDate lBegin = LocalDate.parse(dateBegin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate lEnd = LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> dayRanges = new ArrayList<>();
        String lastDay = Util.getYYYYMMDD(DateUtils.addDays(new Date(), -1));
        while (lBegin.isBefore(lEnd)) {
            if (lastDay.equals(lBegin.toString()) && !newUserDataDayMap.containsKey(lastDay)) {
                //昨天没有数据时排除，否则会多一行
                lBegin = lBegin.plusDays(1);
                continue;
            }
            dayRanges.add(lBegin.toString().replace("-", ""));
            lBegin = lBegin.plusDays(1);
        }
        Collections.reverse(dayRanges);

        List<JSONObject> results = new ArrayList<>();
        int dayIndex = 0;
        JSONObject lastDayEmptyData = new JSONObject();
        for (String day : dayRanges) {
            Map<String, Object> dayLtvData = newUserDataDayMap.get(day);
            JSONObject dayEmptyData = (JSONObject) RETENTION_DATA_TEMPLATE.clone();
            for (int i = 0; i <= dayIndex; i++) {
                String userCountKey = "day" + i + "_u_c";
                String retentionUserNewCountKey = "day" + i + "_r_c";
                dayEmptyData.put(userCountKey, 0);
                dayEmptyData.put(retentionUserNewCountKey, 0);
                lastDayEmptyData.put(userCountKey, 0);
                lastDayEmptyData.put(retentionUserNewCountKey, 0);
            }
            if (dayLtvData == null) {
                dayEmptyData.put("base_date", day.replace("-", ""));
            } else {
                dayEmptyData.putAll(dayLtvData);
            }
            results.add(dayEmptyData);
            dayIndex++;
        }
        if (newUserDataDayMap.isEmpty()) {
            meanData = (JSONObject) lastDayEmptyData.clone();
            meanData.put("base_date", "Mean");
        } else {
            lastDayEmptyData.putAll(meanData);
            meanData = lastDayEmptyData;
        }
        results.add(meanData);
        return results;
    }

    public List<Map<String, Object>> getLtvData(List<Map<String, Object>> list) {
        String fieldName = "total_value_new";
        Map<String, Map<String, Object>> data_map = list.stream().collect(Collectors.toMap(m -> MapHelper.getString(m, "base_date"), m -> m, (o, n) -> o));
        Map<String, Map<String, Object>> data_map_count = list.stream().collect(Collectors.toMap(m ->
                MapHelper.getString(m, "base_date") + "-" + MapHelper.getString(m, "retention_day"), m -> m, (o, n) -> o));
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> mean = new HashMap<>();
        mean.put("base_date", "Mean");
        for (String k : data_map.keySet()) {
            for (int i = 0; i < 31; i++) {
                if (i == 0) {
                    Map<String, Object> v0 = data_map_count.get(k + "-" + i);
                    if (v0 != null) {
                        BigDecimal d0 = MapHelper.getBigDecimal(v0, fieldName) == null ? BigDecimal.ZERO : MapHelper.getBigDecimal(v0, fieldName);
                        String k_u = "day0_u_c";
                        String k_r = "day0_r_c";
                        data_map.get(k).put(k_u, MapHelper.getInt(v0, "user_cnt_new"));
                        data_map.get(k).put(k_r, d0);
                        BigDecimal t0 = MapHelper.getBigDecimal(mean, k_r) == null ? BigDecimal.ZERO : MapHelper.getBigDecimal(mean, k_r);
                        mean.put(k_u, MapHelper.getInt(mean, k_u) + MapHelper.getInt(v0, "user_cnt_new"));
                        mean.put(k_r, t0.add(d0));
                    }
                } else {
                    Map<String, Object> v = data_map_count.get(k + "-" + i);
                    if (v != null) {
                        String k_u = "day" + i + "_u_c";
                        String k_r = "day" + i + "_r_c";
                        String k_r_f = "day" + (i - 1) + "_r_c";
                        Map<String, Object> v_f = data_map.get(k);
                        BigDecimal d = MapHelper.getBigDecimal(v, fieldName) == null ? BigDecimal.ZERO : MapHelper.getBigDecimal(v, fieldName);
                        BigDecimal f = MapHelper.getBigDecimal(v_f, k_r_f) == null ? BigDecimal.ZERO : MapHelper.getBigDecimal(v_f, k_r_f);
                        data_map.get(k).put(k_u, MapHelper.getInt(v, "user_cnt_new"));
                        data_map.get(k).put(k_r, d.add(f));
                        BigDecimal t = MapHelper.getBigDecimal(mean, k_r) == null ? BigDecimal.ZERO : MapHelper.getBigDecimal(mean, k_r);
                        mean.put(k_u, MapHelper.getInt(mean, k_u) + MapHelper.getInt(v, "user_cnt_new"));
                        mean.put(k_r, t.add(d.add(f)));
                    }
                }
            }
            data.add(data_map.get(k));
        }
        sortString(data, "base_date");
        data.add(mean);
        return data;
    }

    public Response getLtvChartData(MultiValueMap<String, String> ps) {
        try {
            String dateEnd = ps.getFirst("dateEnd").replace("-", "");
            String today = Util.getYYYYMMDD(new Date());
            ps.remove("dateEnd");
            ps.set("dateEnd", today);
            List<Map<String, Object>> retentionList = this.getNewUserReport(ps);
            if (CollectionUtils.isEmpty(retentionList)) {
                log.info("Get Ltv Chart Data empty");
                return Response.buildSuccess(new JSONArray());
            }
            String dimensionKey = ps.get("dimensions").contains("country") ? "country" : "publisher_app_id";
            List<JSONObject> results = new ArrayList<>();
            Map<String, List<Map<String, Object>>> reportDimensionMap = retentionList.stream().collect(
                    Collectors.groupingBy(report -> report.get(dimensionKey).toString()));
            for (Map.Entry<String, List<Map<String, Object>>> dimensionEntry : reportDimensionMap.entrySet()) {
                String dimensionVale = dimensionEntry.getKey();
                List<Map<String, Object>> dimReports = dimensionEntry.getValue();
                dimReports.removeIf(result -> {
                    if ("Mean".equals(result.get("base_date").toString())) {
                        return true;
                    }
                    if (dateEnd.compareTo(result.get("base_date").toString()) < 0) {
                        return true;
                    }
                    return false;
                });
                List<Map<String, Object>> ltvDataList = this.getLtvData(dimReports);
                for (Map<String, Object> ltvData : ltvDataList) {
                    if (ltvData.containsKey("base_date") && "Mean".equals(ltvData.get("base_date").toString())) {
                        for (int i = 0; i < 31; i++) {
                            String userCountKey = "day" + i + "_u_c";
                            String revenueKey = "day" + i + "_r_c";
                            if (ltvData.containsKey(userCountKey)) {
                                JSONObject dayLtv = new JSONObject();
                                dayLtv.put(userCountKey, ltvData.get(userCountKey));
                                dayLtv.put(revenueKey, ltvData.get(revenueKey));
                                dayLtv.put(dimensionKey, dimensionVale);
                                dayLtv.put("day", i);
                                results.add(dayLtv);
                            }
                        }
                    }
                }
            }
            this.fieldNameService.fillName(results);
            return Response.buildSuccess(results);
        } catch (Exception e) {
            log.error("Get Ltv chart report error, parameters {}:", JSONObject.toJSON(ps), e);
        }
        return Response.RES_FAILED;
    }

    public List<Map<String, Object>> getRetentionData(List<Map<String, Object>> list) {
        Map<String, Map<String, Object>> data_map = list.stream().collect(Collectors.toMap(m -> MapHelper.getString(m, "base_date"), m -> m, (o, n) -> o));
        Map<String, Map<String, Object>> data_map_count = list.stream().collect(Collectors.toMap(m ->
                MapHelper.getString(m, "base_date") + "-" + MapHelper.getString(m, "retention_day"), m -> m, (o, n) -> o));
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> mean = new HashMap<>();
        mean.put("base_date", "Mean");
        for (String k : data_map.keySet()) {
            for (int i = 0; i < 31; i++) {
                Map<String, Object> v = data_map_count.get(k + "-" + i);
                if (v != null) {
                    String k_u = "day" + i + "_u_c";
                    String k_r = "day" + i + "_r_c";
                    data_map.get(k).put(k_u, MapHelper.getInt(v, "user_cnt_new"));
                    data_map.get(k).put(k_r, MapHelper.getInt(v, "retention_cnt_new"));
                    mean.put(k_u, MapHelper.getInt(mean, k_u) + MapHelper.getInt(v, "user_cnt_new"));
                    mean.put(k_r, MapHelper.getInt(mean, k_r) + MapHelper.getInt(v, "retention_cnt_new"));
                }
            }
            data.add(data_map.get(k));
        }
        sortString(data, "base_date");
        data.add(mean);
        return data;
    }

    public List<JSONObject> retentionChartData(MultiValueMap<String, String> ps, List<Map<String, Object>> retentionList) {
        String dimensionKey = ps.get("dimensions").contains("country") ? "country" : "publisher_app_id";
        List<JSONObject> results = new ArrayList<>();
        Map<String, List<Map<String, Object>>> reportDimensionMap = retentionList.stream().collect(
                Collectors.groupingBy(report -> report.get(dimensionKey).toString()));
        for (Map.Entry<String, List<Map<String, Object>>> dimensionEntry : reportDimensionMap.entrySet()) {
            String dimensionVale = dimensionEntry.getKey();
            List<Map<String, Object>> dimReports = dimensionEntry.getValue();
            Map<String, List<Map<String, Object>>> retentionDayReportMap = dimReports.stream().collect(
                    Collectors.groupingBy(report -> report.get("retention_day").toString()));
            for (Map.Entry<String, List<Map<String, Object>>> retentionDayEntry : retentionDayReportMap.entrySet()) {
                String retentionDay = retentionDayEntry.getKey();
                if ("0".equals(retentionDay)) {
                    continue;
                }
                List<Map<String, Object>> retentionDayReports = retentionDayEntry.getValue();
                JSONObject result = new JSONObject();
                result.put(dimensionKey, dimensionVale);
                result.put("day", retentionDay);
                int userCntNew = 0;
                int retentionCntNew = 0;
                for (Map<String, Object> report : retentionDayReports) {
                    userCntNew += MapHelper.getInt(report, "user_cnt_new");
                    retentionCntNew += MapHelper.getInt(report, "retention_cnt_new");
                }
                String userCountNewKey = "day" + retentionDay + "_u_c";
                String retentionUserNewCountKey = "day" + retentionDay + "_r_c";
                result.put(userCountNewKey, userCntNew);
                result.put(retentionUserNewCountKey, retentionCntNew);
                results.add(result);
            }
        }
        this.fieldNameService.fillName(results);
        return results;
    }

    public void sortString(List<Map<String, Object>> list, String name) {
        list.sort((o1, o2) -> {
            String key1 = MapHelper.getString(o1, name);
            String key2 = MapHelper.getString(o2, name);
            if (key1 == null && key2 == null) {
                return 0;
            }
            if (key1 == null) {
                return -1;
            }
            if (key2 == null) {
                return 1;
            }
            return key2.compareTo(key1);
        });
    }
}
