// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by ruandianbo on 20-2-4.
 */
public class BaseController {

    protected static final Logger log = LogManager.getLogger();

    /**
     * Check to add include/exclude type for white/black list
     *
     * @param modelBlacklist
     * @param modelWhitelist
     */
    public static void buildModelBlackWhiteType(JSONObject result, String modelBlacklist, String modelWhitelist) {
        if (StringUtils.isNotBlank(modelBlacklist)) {
            result.put("modelType", "exclude");
            result.put("modelList", JSONArray.toJSON(modelBlacklist.split(",")));
        } else if (StringUtils.isNotBlank(modelWhitelist)) {
            result.put("modelType", "include");
            result.put("modelList", JSONArray.toJSON(modelWhitelist.split(",")));
        } else {
            result.put("modelType", "include");
            result.put("modelList", new JSONArray());
        }
    }

    /**
     * Check to add include/exclude type for white/black list
     *
     * @param brandBlacklist
     * @param brandWhitelist
     */
    public static void buildBrandBlackWhiteType(JSONObject resultInstance, String brandBlacklist, String brandWhitelist) {
        if (StringUtils.isNotBlank(brandBlacklist)) {
            resultInstance.put("brandType", "exclude");
            resultInstance.put("brandList", JSONArray.toJSON(brandBlacklist.split(",")));
        } else if (StringUtils.isNotBlank(brandWhitelist)) {
            resultInstance.put("brandType", "include");
            resultInstance.put("brandList", JSONArray.toJSON(brandWhitelist.split(",")));
        } else {
            resultInstance.put("brandType", "include");
            resultInstance.put("brandList", new JSONArray());
        }
    }
}
