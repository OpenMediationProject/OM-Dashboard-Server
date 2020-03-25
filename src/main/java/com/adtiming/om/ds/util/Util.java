// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ruandianbo on 20-2-5.
 */
public class Util {

    protected static final Logger log = LogManager.getLogger();

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

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
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        return getDateYYYYMMDD(getYYYYMMDD(calendar.getTime()));
    }

    public static Date getLastMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.MONTH, -1);
        return getDateYYYYMMDD(getYYYYMMDD(calendar.getTime()));
    }

    public static String getDateString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return f.format(date);
    }

    /**
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString().toLowerCase();
    }

    /**
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
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
