// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmCountryMapper;
import com.adtiming.om.ds.dao.OmSupportDeviceMapper;
import com.adtiming.om.ds.model.OmCountry;
import com.adtiming.om.ds.model.OmCountryCriteria;
import com.adtiming.om.ds.model.OmSupportDevice;
import com.adtiming.om.ds.model.OmSupportDeviceCriteria;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
            countries.sort((country1, country2) -> {
                Double revenue1 = countryRevenueMap.get(country1.getA2());
                if (revenue1 == null) {
                    revenue1 = 0D;
                }
                Double revenue2 = countryRevenueMap.get(country2.getA2());
                if (revenue2 == null) {
                    revenue2 = 0D;
                }
                return (int) (revenue2 - revenue1);
            });
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
}
