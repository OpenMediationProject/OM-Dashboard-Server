package com.adtiming.om.ds.util;

import com.google.common.base.CaseFormat;
import org.apache.http.client.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtil {
    private static final Logger log = LogManager.getLogger();

    private static Map<String, Object> getPublicProperties(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class userCla = obj.getClass();
        Field[] fs = userCla.getFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            try {
                Object val = f.get(obj);
                map.put(f.getName(), val);
            } catch (Exception e) {
                log.error("reflex error", e);
            }
        }
        return map;
    }

    private static Map<String, Object> getPrivateProperties(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class userCla = obj.getClass();
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true);
            try {
                Object val = f.get(obj);
                map.put(f.getName(), val);
            } catch (Exception e) {
                log.error("reflex error", e);
            }
        }
        return map;
    }

    public static boolean equals(Object objA, Object objB, String filedNameA, String filedNameB) {
        Object objAValue = getValue(objA, filedNameA);
        Object objBValue = getValue(objB, filedNameB);
        return objectEquals(objAValue, objBValue);
    }

    private static boolean objectEquals(Object objAValue, Object objBValue) {
        if (objAValue == null && objBValue == null) {
            return true;
        }
        if (objAValue == null || objBValue == null) {
            return false;
        }
        if (objAValue instanceof BigDecimal || objAValue instanceof Double || objAValue instanceof Float) {
            BigDecimal aBig = new BigDecimal(objAValue.toString());
            BigDecimal bBig = new BigDecimal(objBValue.toString());
            return aBig.compareTo(bBig) == 0;
        }
        String aStrV;
        String bStrV;
        if (objAValue instanceof Date) {
            aStrV = DateUtils.formatDate((Date) objAValue, "yyyy-MM-dd");
            bStrV = DateUtils.formatDate((Date) objBValue, "yyyy-MM-dd");
        } else {
            aStrV = objAValue.toString();
            bStrV = objBValue.toString();
        }
        return aStrV.equals(bStrV);
    }

    public static Map<String, Object> getChangedValues(Object oldObj, Object newObj, List<String> fields) {
        Map<String, Object> changedMap = new HashMap<>();
        for (String field : fields) {
            Object oldValue = getValue(oldObj, field);
            Object newValue = getValue(newObj, field);
            if (!objectEquals(oldValue, newValue)) {
                changedMap.put(field, newValue);
            }
        }
        return changedMap;
    }

    public static void setValue(Object object, String fieldName, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            log.error("reflex error", e);
        }
    }

    public static void setValues(Object obj, Map<String, Object> valueMap) {
        valueMap.forEach((k, v) -> {
            setValue(obj, k, v);
        });
    }

    public static Object getValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            return null;
        }
    }

    public static Map<String, Object> getValues(Object object, List<String> fieldNames) {
        Map<String, Object> valueMap = new HashMap<>();
        try {
            for (String fieldName : fieldNames) {
                valueMap.put(fieldName, getValue(object, fieldName));
            }
        } catch (Exception e) {
            log.error("reflex getValues error", e);
        }
        return valueMap;
    }


    public static void main(String[] args) {
        /*OmAdnetworkApp a = new OmAdnetworkApp();
        a.setId(1);
        a.setClientId("aaaaa");
        OmAdnetworkApp b = new OmAdnetworkApp();
        b.setId(2);
        b.setClientId("bbbbb");
        System.out.println(equals(a, b, "clientId", "clientId"));
        Map<String, Object> changedValue = getChangedValues(a, b, Arrays.asList("id", "clientId"));
        System.out.println(JSON.toJSONString(changedValue));*/

        String str = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "apiKey");
        System.out.println(str);
    }
}
