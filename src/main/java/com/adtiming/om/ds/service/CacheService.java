// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dto.ReportConditionDTO;
import com.adtiming.om.ds.model.StatAdnetwork;
import com.adtiming.om.ds.util.Util;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * Basic data cache Manager
 *
 * @author dianbo ruan
 */
@Service
public class CacheService {

    public static final int REVENUE_BEFORE_DAYS = 6;
    public static final int TOP_COUNTRY_SIZE = 5;
    private static final Logger log = LogManager.getLogger();
    private static List<String> DEFAULT_TOP_REVENUE_COUNTRIES = new ArrayList<>(Arrays.asList("USA", "CAN", "GBR", "AUS", "JPN"));
    private static Map<String, Double> DEFAULT_TOP_COUNTRY_REVENUES = new HashMap<>();

    static {
        for (String topCountry : DEFAULT_TOP_REVENUE_COUNTRIES) {
            DEFAULT_TOP_COUNTRY_REVENUES.put(topCountry, 1D);
        }
    }

    private Map<Integer, Double> placementRevenueMap = new HashMap<>();

    private Map<Integer, Double> publisherAppRevenueMap = new HashMap<>();

    private Map<Integer, Map<String, Double>> appIdCountryRevenueMap = new HashMap<>();

    @Autowired
    private ReportService reportService;

    @Resource
    private RedisSessionDAO redisSessionDAO;

    /**
     * Init cache when start and per hour
     */
    @Scheduled(cron = "0 10 */1 * * *")
    @PostConstruct
    private void initCache() {
        redisSessionDAO.setSessionInMemoryEnabled(true);
        this.buildRevenue();
    }

    public Map<Integer, Double> getPlacementRevenueMap() {
        return placementRevenueMap;
    }

    public Map<Integer, Double> getPublisherAppRevenueMap() {
        return publisherAppRevenueMap;
    }

    public Map<String, Double> getAppCountryRevenueMap(Integer pubAppId) {
        Map<String, Double> appCountryRevenueMap = this.appIdCountryRevenueMap.get(pubAppId);
        if (appCountryRevenueMap != null) {
            return appCountryRevenueMap;
        }
        return DEFAULT_TOP_COUNTRY_REVENUES;
    }

    /**
     * Build revenue cache map
     */
    public synchronized void buildRevenue() {
        try {
            this.buildPublisherCostMap();

            this.buildPlacementCostMap();

            this.buildAppCountryCostMap();
        } catch (Exception e) {
            log.error("Build revenue error:", e);
        }
    }

    private List<StatAdnetwork> getStatAdNetworks(String[] dimensions) {
        ReportConditionDTO reportConditionDTO = new ReportConditionDTO();
        reportConditionDTO.setDateBegin(Util.getYYYYMMDD(DateUtils.addDays(new Date(), -REVENUE_BEFORE_DAYS)));
        reportConditionDTO.setDateEnd(Util.getYYYYMMDD(new Date()));
        reportConditionDTO.setDimension(dimensions);
        List<StatAdnetwork> statAdNetworks = this.reportService.getAdNetworkReport(reportConditionDTO);
        log.info("Cache service select statAdNetwork size {} dimensions {}", statAdNetworks.size(), dimensions);
        return statAdNetworks;
    }

    /**
     * Build placement revenue cache map
     */
    private void buildPlacementCostMap() {
        String[] dimensions = new String[]{"placementId"};
        List<StatAdnetwork> placementRevenueStat = this.getStatAdNetworks(dimensions);
        if (!placementRevenueStat.isEmpty()) {
            Map<Integer, Double> tmpPlacementRevenueMap = new HashMap<>();
            for (StatAdnetwork statAdnetwork : placementRevenueStat) {
                double revenue = statAdnetwork.getCost() == null ? 0D : statAdnetwork.getCost().doubleValue();
                tmpPlacementRevenueMap.put(statAdnetwork.getPlacementId(), revenue);
            }
            if (!CollectionUtils.isEmpty(tmpPlacementRevenueMap)) {
                this.placementRevenueMap = tmpPlacementRevenueMap;
            }
        }
    }

    /**
     * Build publisher revenue cache map
     */
    private void buildPublisherCostMap() {
        String[] dimensions = new String[]{"pubAppId"};
        List<StatAdnetwork> publisherAppStat = this.getStatAdNetworks(dimensions);
        if (!publisherAppStat.isEmpty()) {
            Map<Integer, Double> tmpPublisherAppRevenueMap = new HashMap<>();
            for (StatAdnetwork statAdnetwork : publisherAppStat) {
                double revenue = statAdnetwork.getCost() == null ? 0D : statAdnetwork.getCost().doubleValue();
                tmpPublisherAppRevenueMap.put(statAdnetwork.getPubAppId(), revenue);
            }
            if (!CollectionUtils.isEmpty(tmpPublisherAppRevenueMap)) {
                this.publisherAppRevenueMap = tmpPublisherAppRevenueMap;
            }
        }
    }

    /**
     * Build country revenue cache map
     */
    private void buildAppCountryCostMap() {
        String[] dimensions = new String[]{"pubAppId", "country"};
        List<StatAdnetwork> appCountryRevenueStat = this.getStatAdNetworks(dimensions);
        if (appCountryRevenueStat.isEmpty()) {
            return;
        }

        Map<Integer, Map<String, Double>> tmpAppIdCountryRevenueMap = new HashMap<>();
        for (StatAdnetwork statAdnetwork : appCountryRevenueStat) {
            Map<String, Double> countryAppRevenueMap = tmpAppIdCountryRevenueMap.get(statAdnetwork.getPubAppId());
            if (countryAppRevenueMap != null) {
                Double countryRevenue = countryAppRevenueMap.get(statAdnetwork.getCountry());
                if (countryRevenue == null) {
                    countryRevenue = 0D;
                }
                double currentCountryRevenue = statAdnetwork.getCost() == null ? 0D : statAdnetwork.getCost().doubleValue();
                countryAppRevenueMap.put(statAdnetwork.getCountry(), countryRevenue + currentCountryRevenue);
            } else {
                Map<String, Double> countryRevenueMap = new HashMap<>();
                countryRevenueMap.put(statAdnetwork.getCountry(), statAdnetwork.getCost() == null ? 0 : statAdnetwork.getCost().doubleValue());
                tmpAppIdCountryRevenueMap.put(statAdnetwork.getPubAppId(), countryRevenueMap);
            }
        }

        //keep top five country revenue of each app
        for (Map.Entry<Integer, Map<String, Double>> entry : tmpAppIdCountryRevenueMap.entrySet()) {
            Map<String, Double> countryAppRevenueMap = entry.getValue();
            if (countryAppRevenueMap.size() > TOP_COUNTRY_SIZE) {
                List<Double> sortedRevenueList = new ArrayList<>(countryAppRevenueMap.values());
                Collections.sort(sortedRevenueList);
                Collections.reverse(sortedRevenueList);
                double fifthBigRevenue = sortedRevenueList.get(TOP_COUNTRY_SIZE);
                Iterator<Map.Entry<String, Double>> iterator = countryAppRevenueMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Double> entry1 = iterator.next();
                    if (entry1.getValue() < fifthBigRevenue) {
                        iterator.remove();
                    }
                }
            } else {
                List<String> defaultCountries = new ArrayList<>(DEFAULT_TOP_REVENUE_COUNTRIES);
                Collections.shuffle(defaultCountries);
                for (String defaultCountry : defaultCountries) {
                    countryAppRevenueMap.put(defaultCountry, 1D);
                    if (countryAppRevenueMap.size() > TOP_COUNTRY_SIZE) {
                        break;
                    }
                }
            }
        }
        if (!CollectionUtils.isEmpty(tmpAppIdCountryRevenueMap)) {
            this.appIdCountryRevenueMap = tmpAppIdCountryRevenueMap;
        }
    }
}
