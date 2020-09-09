// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ruandianbo on 20-2-5.
 */
public class Util {

    public static final String SPLIT_SYMBOL = "\n";

    protected static final Logger log = LogManager.getLogger();

    /**
     * Check to add include/exclude type for white/black list
     *
     * @param modelBlacklist
     * @param modelWhitelist
     */
    public static void buildModelBlackWhiteType(JSONObject result, String modelBlacklist, String modelWhitelist) {
        if (result.containsKey("modelType")) {
            result.put("deviceModelType", result.get("modelType"));
        }

        if (StringUtils.isNotBlank(modelBlacklist)) {
            result.put("modelType", "exclude");
            result.put("modelList", JSONArray.toJSON(modelBlacklist.split(SPLIT_SYMBOL)));
        } else if (StringUtils.isNotBlank(modelWhitelist)) {
            result.put("modelType", "include");
            result.put("modelList", JSONArray.toJSON(modelWhitelist.split(SPLIT_SYMBOL)));
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
            resultInstance.put("brandList", JSONArray.toJSON(brandBlacklist.split(SPLIT_SYMBOL)));
        } else if (StringUtils.isNotBlank(brandWhitelist)) {
            resultInstance.put("brandType", "include");
            resultInstance.put("brandList", JSONArray.toJSON(brandWhitelist.split(SPLIT_SYMBOL)));
        } else {
            resultInstance.put("brandType", "include");
            resultInstance.put("brandList", new JSONArray());
        }
    }

    public static Date getDateYYYYMMDDHH(String strDate) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH");
            Date date = null;
            date = f.parse(strDate);
            return date;
        } catch (Exception e) {
            log.error("Get date string error {}", strDate, e);
        }
        return null;
    }

    public static int getHour(Date date) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("HH");
            String result = f.format(date);

            return Integer.parseInt(result);
        } catch (Exception e) {
            log.error("Get day error {}", date, e);
        }
        return 0;
    }

    public static Integer[] stringToInteger(String[] data) {
        if (data == null || data.length <= 0) {
            return new Integer[0];
        }
        Integer[] intArr = new Integer[data.length];
        int index = 0;
        for (String str : data) {
            intArr[index++] = Integer.parseInt(str);
        }
        return intArr;
    }


    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 0);
        return getDateYYYYMMDD(getYYYYMMDD(calendar.getTime()));
    }

    public static Date getLastMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        return getDateYYYYMMDD(getYYYYMMDD(calendar.getTime()));
    }

    public static Date getLastMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return getDateYYYYMMDD(getYYYYMMDD(calendar.getTime()));
    }

    public static String getDateString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

    public static String buildAppKey() {
        String baseCharacters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String appKey = "";
        for (int i = 0; i < 32; ++i) {
            appKey += baseCharacters.charAt((int) Math.ceil(Math.random() * 1000) % baseCharacters.length());
        }
        return appKey;
    }

    public static Date getDateYYYYMMDD(String strDate) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            date = f.parse(strDate);
            return date;
        } catch (Exception e) {
            log.error("Get date string error {}", strDate, e);
        }
        return null;
    }

    public static String getYYYYMMDD(Date date) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String result = f.format(date);

            return result;
        } catch (Exception e) {
            log.error("Get day error {}", date, e);
        }
        return null;
    }

    public static int getInt(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).intValue();
    }

    public static float getFloat(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).floatValue();
    }

    public static List<Integer> buildIntegerList(Integer[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        List<Integer> integerList = new ArrayList<>();
        for (Integer integer : array) {
            integerList.add(integer);
        }
        return integerList;
    }

    public static List<Byte> buildByteList(Byte[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        List<Byte> byteList = new ArrayList<>();
        for (Byte b : array) {
            byteList.add(b);
        }
        return byteList;
    }

    public static List<String> buildStringList(String[] array) {
        if (array == null || array.length <= 0) {
            return null;
        }
        List<String> stringList = new ArrayList<>();
        for (String str : array) {
            stringList.add(str);
        }
        return stringList;
    }

    public static int byteToInt(byte by) {
        return by & 0xff;
    }

    public static byte intToByte(int x) {
        return (byte) (x & 0xff);
    }

    public static String buildAuthKey() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static void main(String[] args) {

    }
}
