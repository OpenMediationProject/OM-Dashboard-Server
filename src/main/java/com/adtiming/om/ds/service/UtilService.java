// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmCountryMapper;
import com.adtiming.om.ds.dao.OmCurrencyExchangeMapper;
import com.adtiming.om.ds.dao.OmMessageDictMapper;
import com.adtiming.om.ds.dao.OmSupportDeviceMapper;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.*;
import com.adtiming.om.ds.util.HttpConnMgr;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Util
 *
 * @author dianbo ruan
 */
@Service
public class UtilService {

    protected static final Logger log = LogManager.getLogger();

    @Resource
    private OmSupportDeviceMapper omSupportDeviceMapper;

    @Resource
    private OmCountryMapper omCountryMapper;

    @Autowired
    private CacheService cacheService;

    @Resource
    private OmMessageDictMapper omMessageDictMapper;

    @Resource
    private OmCurrencyExchangeMapper omCurrencyExchangeMapper;

    public List<OmMessageDict> getMessageDicts() {
        OmMessageDictCriteria dictCriteria = new OmMessageDictCriteria();
        OmMessageDictCriteria.Criteria criteria = dictCriteria.createCriteria();
        criteria.andStatusEqualTo((byte) SwitchStatus.ON.ordinal());
        return omMessageDictMapper.selectWithBLOBs(dictCriteria);
    }

    public List<OmCurrencyExchange> getCurrencyList() {
        return omCurrencyExchangeMapper.select(new OmCurrencyExchangeCriteria());
    }

    /**
     * Select country by country 3 or english name
     * source http://storage.googleapis.com/play_public/supported_devices.html
     *
     * @param pubAppId
     * @return omSupportDevices
     */
    public List<OmCountry> getCountries(Integer pubAppId) {
        List<OmCountry> omCountries = this.omCountryMapper.select(new OmCountryCriteria());
        this.sortCountryByRevenue(omCountries, pubAppId);
        log.info("Select country size: {}", omCountries.size());
        return omCountries;
    }

    /**
     * Sort country by revenue
     *
     * @param countries
     */
    private void sortCountryByRevenue(List<OmCountry> countries, Integer pubAppId) {
        try {
            if (CollectionUtils.isEmpty(countries)) {
                return;
            }
            Map<String, Double> countryRevenueMap = this.cacheService.getAppCountryRevenueMap(pubAppId);
            if (CollectionUtils.isEmpty(countryRevenueMap)) {
                return;
            }
            countries.forEach(country -> {
                Double revenue = countryRevenueMap.get(country.getA3());
                if (revenue == null) {
                    country.setRevenue(0D);
                } else {
                    country.setRevenue(revenue);
                }
            });
            countries.sort(Comparator.comparing(OmCountry::getRevenue));
            Collections.reverse(countries);
        } catch (Exception e) {
            log.error("Sort country by revenue error:", e);
        }
    }

    /**
     * Select support devices by brand or model
     *
     * @param brand
     * @param model
     * @return omSupportDevices
     */
    public List<OmSupportDevice> getSupportDevices(String brand, String model) {
        OmSupportDeviceCriteria omSupportDeviceCriteria = new OmSupportDeviceCriteria();
        OmSupportDeviceCriteria.Criteria criteria = omSupportDeviceCriteria.createCriteria();
        if (StringUtils.isNotBlank(brand)) {
            criteria.andBrandLike("%" + brand + "%");
        }
        if (StringUtils.isNotBlank(model)) {
            criteria.andModelLike("%" + model + "%");
        }
        PageHelper.offsetPage(0, 100);
        List<OmSupportDevice> omSupportDevices = omSupportDeviceMapper.select(omSupportDeviceCriteria);
        log.info("Get support device size: {}", omSupportDevices.size());
        return omSupportDevices;
    }

    /**
     * update support device every month
     */
    @Scheduled(cron = "0 15 2 15 * ?")
    public void updateSupportDevices() {
        try {
            Set<String> supportDeviceSet = this.getSupportDeviceSet();
            if (CollectionUtils.isEmpty(supportDeviceSet)) {
                log.error("Database error, support device is empty");
                return;
            }
            String url = "http://storage.googleapis.com/play_public/supported_devices.html";
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = HttpConnMgr.getHttpClient().execute(httpGet);
            String content = EntityUtils.toString(response.getEntity());

            Document document = Jsoup.parse(content);
            Elements elements = document.getElementsByTag("tr");
            for (Element element : elements) {
                try {
                    Elements deviceItems = element.getElementsByTag("td");
                    if (deviceItems.isEmpty()) {
                        continue;
                    }
                    if (deviceItems.size() < 4) {
                        continue;
                    }
                    OmSupportDevice supportDevice = new OmSupportDevice();
                    supportDevice.setBrand(deviceItems.get(0).text());
                    supportDevice.setMarketName(deviceItems.get(1).text());
                    supportDevice.setDevice(deviceItems.get(2).text());
                    supportDevice.setModel(deviceItems.get(3).text());
                    String key = supportDevice.getBrand() + supportDevice.getMarketName() + supportDevice.getDevice() + supportDevice.getModel();
                    if (!supportDeviceSet.contains(key.toLowerCase())) {
                        int result = this.omSupportDeviceMapper.insertSelective(supportDevice);
                        if (result <= 0) {
                            log.warn("Insert support device {} failed", JSONObject.toJSON(supportDevice));
                        }
                    }
                } catch (Exception e) {
                    log.warn("Process support device error:", e);
                }
            }
        } catch (Exception e) {
            log.error("updateSupportDevices error:", e);
        }
    }

    public Set<String> getSupportDeviceSet() {
        Set<String> supportDeviceMap = new HashSet<>();
        List<OmSupportDevice> supportDevices = this.omSupportDeviceMapper.select(new OmSupportDeviceCriteria());
        for (OmSupportDevice supportDevice : supportDevices) {
            String key = supportDevice.getBrand() + supportDevice.getMarketName() + supportDevice.getDevice() + supportDevice.getModel();
            supportDeviceMap.add(key.toLowerCase());
        }
        return supportDeviceMap;
    }
}
