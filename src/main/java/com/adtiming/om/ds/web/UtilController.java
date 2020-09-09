// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.adtiming.om.ds.dto.Response;
import com.adtiming.om.ds.model.OmCountry;
import com.adtiming.om.ds.model.OmCurrencyExchange;
import com.adtiming.om.ds.model.OmMessageDict;
import com.adtiming.om.ds.model.OmSupportDevice;
import com.adtiming.om.ds.service.CacheService;
import com.adtiming.om.ds.service.UtilService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Util interface
 *
 * @author dianbo ruan
 */
@RestController
public class UtilController {

    protected static final Logger log = LogManager.getLogger();

    private static final int SELECT_LIST_SIZE = 30;

    @Autowired
    UtilService utilService;

    /**
     * Get dicts
     */
    @RequestMapping(value = "/msg/dict", method = RequestMethod.GET)
    public Response getMessageDicts() {
        try {
            List<OmMessageDict> dicts = this.utilService.getMessageDicts();
            Map<String, Map<String, String>> dictMap = dicts.stream().collect(
                    Collectors.groupingBy(OmMessageDict::getPage, Collectors.toMap(OmMessageDict::getMsgKey, OmMessageDict::getValue)));
            return Response.buildSuccess(dictMap);
        } catch (Exception e) {
            log.error("Get message dicts error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get currency list
     */
    @RequestMapping(value = "/util/currency/list", method = RequestMethod.GET)
    public Response getCurrencyList() {
        List<OmCurrencyExchange> currencyList = this.utilService.getCurrencyList();
        List<String> results = new ArrayList<>();
        currencyList.forEach(currency -> {
            results.add(currency.getCurFrom());
        });
        return Response.buildSuccess(results);
    }

    /**
     * Get support device brand list
     */
    @RequestMapping(value = "/util/device/brand/list", method = RequestMethod.GET)
    public Response getSupportDeviceBrands(String brand) {
        try {
            List<OmSupportDevice> omSupportDevices = this.utilService.getSupportDevices(brand, null);
            Map<String, String> brandMap = new HashMap<>();
            for (OmSupportDevice device : omSupportDevices) {
                brandMap.put(device.getBrand(), device.getBrand());
                if (brandMap.size() >= SELECT_LIST_SIZE) {
                    break;
                }
            }
            return Response.buildSuccess(brandMap);
        } catch (Exception e) {
            log.error("get support devices error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get support device list
     */
    @RequestMapping(value = "/util/device/model/list", method = RequestMethod.GET)
    public Response getSupportDevices(String brand, String model) {
        try {
            List<OmSupportDevice> omSupportDevices = this.utilService.getSupportDevices(brand, model);
            Map<String, String> modelMap = new HashMap<>();
            for (OmSupportDevice device : omSupportDevices) {
                modelMap.put(device.getModel(), device.getModel());
                if (modelMap.size() >= SELECT_LIST_SIZE) {
                    break;
                }
            }
            return Response.buildSuccess(modelMap);
        } catch (Exception e) {
            log.error("get support devices error:", e);
        }
        return Response.RES_FAILED;
    }

    /**
     * Get country list order by app revenue
     *
     * @param pubAppId
     */
    @RequestMapping(value = "/util/country/list", method = RequestMethod.GET)
    public Response getCountries(Integer pubAppId) {
        try {
            List<OmCountry> omCountries = this.utilService.getCountries(pubAppId);
            JSONArray resultTopCountries = new JSONArray();
            JSONArray resultOthers = new JSONArray();
            int top = CacheService.TOP_COUNTRY_SIZE;
            for (OmCountry country : omCountries) {
                JSONObject resultCountry = new JSONObject();
                resultCountry.put("a2", country.getA2());
                resultCountry.put("a3", country.getA3());
                resultCountry.put("name", country.getName());
                resultCountry.put("tier", country.getTier());
                if (top-- > 0) {
                    resultTopCountries.add(resultCountry);
                } else {
                    resultOthers.add(resultCountry);
                }
            }

            JSONObject resultCountries = new JSONObject();
            resultCountries.put("top", resultTopCountries);
            resultCountries.put("all", resultOthers);
            return Response.buildSuccess(resultCountries);
        } catch (Exception e) {
            log.error("get country error:", e);
        }
        return Response.RES_FAILED;
    }
}
