// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Simple way to get Primitive data types from {@link Map}
 *
 * @author wuwei
 * @see #getDate(Map, Object)
 * @see #getDouble(Map, Object)
 * @see #getFloat(Map, Object)
 * @see #getLong(Map, Object)
 * @see #getInt(Map, Object)
 * @see #getString(Map, Object)
 */
public class MapHelper {

    private MapHelper() {
    }

    public static BigDecimal getBigDecimal(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        if (o == null) return null;
        if (o instanceof BigDecimal) return (BigDecimal) o;
        return new BigDecimal(o.toString());
    }

    /**
     * 从map里获得int
     */
    public static int getInt(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).intValue();
    }

    /**
     * 从map里获得long
     */
    public static long getLong(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).longValue();
    }

    /**
     * 从map里获得double
     */
    public static double getDouble(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).doubleValue();
    }

    /**
     * 从map里获得float
     */
    public static float getFloat(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? 0 : ((Number) o).floatValue();
    }

    /**
     * 从map里获得string
     */
    public static String getString(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        return o == null ? null : o.toString();
    }

    /**
     * 从map里根据字符串转换日期类型，只适用于结果集里是标准 日期字符串
     */
    public static Date getDate(Map<?, ?> map, Object key) {
        Object o = map.get(key);
        if (o == null)
            return null;
        else {
            if (o instanceof Date)
                return (Date) o;
            String time = o.toString();
            SimpleDateFormat sdf = null;
            if (time.length() > 10) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            try {
                return sdf.parse(time);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
