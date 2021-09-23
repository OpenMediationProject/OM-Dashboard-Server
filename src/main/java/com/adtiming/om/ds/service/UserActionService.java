// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmActionLogMapper;
import com.adtiming.om.ds.dto.LogType;
import com.adtiming.om.ds.model.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author dianbo ruan
 */
@Service
public class UserActionService extends BaseService{

    @Resource
    OmActionLogMapper omActionLogMapper;

    public boolean saveActionLog(Object objBefore, Object objAfter) {
        try {
            if (objBefore == null || objAfter == null) {
                log.error("Save action log error, before {} after {}", JSONObject.toJSON(objBefore), JSONObject.toJSON(objAfter));
                return false;
            }
            LogType logType = this.getLogType(objBefore);
            LogType afterLogType = this.getLogType(objAfter);
            if (!logType.equals(afterLogType)) {
                return false;
            }
            UmUser currentUser = this.getCurrentUser();
            OmActionLog actionLog = new OmActionLog();
            actionLog.setUserId(currentUser.getId());
            actionLog.setUserName(currentUser.getName());
            actionLog.setType((byte) logType.ordinal());

            JSONObject before = (JSONObject) JSONObject.toJSON(objBefore);
            JSONObject after = (JSONObject) JSONObject.toJSON(objAfter);
            Integer typeId = before.getInteger("id");
            if (typeId == null) {
                typeId = after.getInteger("id");
            }
            actionLog.setTypeId(typeId);
            actionLog.setTypeSubId(typeId);
            if (objBefore instanceof OmPlacementRuleInstance) {
                if (before.getInteger("ruleId") != null) {
                    actionLog.setTypeId(before.getInteger("ruleId"));
                }
                if (after.getInteger("ruleId") != null) {
                    actionLog.setTypeId(after.getInteger("ruleId"));
                }
            }

            Set<String> beforeKeySet = this.getKeySet(before, logType);
            Set<String> afterKeySet = this.getKeySet(after, logType);
            beforeKeySet.retainAll(afterKeySet);
            JSONObject changeValues = new JSONObject();
            for (String key : beforeKeySet) {
                if (!after.containsKey(key)) {
                    continue;
                }
                Object beforeValue;
                Object afterValue;
                Object value = before.get(key);
                if (value instanceof Integer) {
                    beforeValue = before.getInteger(key);
                    afterValue = after.getInteger(key);
                } else if (value instanceof Byte) {
                    beforeValue = before.getByte(key);
                    afterValue = after.getByte(key);
                } else if (value instanceof Number) {
                    beforeValue = before.getDoubleValue(key);
                    afterValue = after.getDoubleValue(key);
                } else if (value instanceof Boolean) {
                    beforeValue = before.getBoolean(key);
                    afterValue = after.getBoolean(key);
                } else {
                    beforeValue = null;
                    if (before.containsKey(key) && StringUtils.isNotBlank(before.getString(key))) {
                        beforeValue = before.getString(key);
                    }
                    afterValue = null;
                    if (after.containsKey(key) && StringUtils.isNotBlank(after.getString(key))) {
                        afterValue = after.getString(key);
                    }
                }
                if (afterValue == null && beforeValue == null) {
                    continue;
                }
                if (afterValue == null || !afterValue.equals(beforeValue)) {
                    String changeValue = beforeValue + "->" + afterValue;
                    changeValues.put(key, changeValue);
                }
            }
            if (changeValues.isEmpty()) {
                return false;
            }
            changeValues.put("from", "dash");
            changeValues.put("class", objBefore.getClass().getName());
            actionLog.setChangeContent(changeValues.toJSONString());
            int result = this.omActionLogMapper.insertSelective(actionLog);
            if (result <= 0) {
                throw new RuntimeException("Save action log error " + JSONObject.toJSON(actionLog));
            }
            return true;
        } catch (Exception e) {
            log.error("Save action log error, before {} after {}", JSONObject.toJSON(objBefore), JSONObject.toJSON(objAfter), e);
        }
        return false;
    }

    private Set<String> getKeySet(JSONObject object, LogType logType) {
        Set<String> keySet = object.keySet();
        keySet.remove("createTime");
        keySet.remove("lastmodify");
        keySet.remove("id");
        switch (logType) {
            case PLACEMENT_RULE: {
                keySet.remove("requireDid");
                keySet.remove("publisherId");
                keySet.remove("createUserId");
                break;
            }
            default:
                break;
        }
        return keySet;
    }

    private LogType getLogType(Object object) {
        if (object instanceof OmPlacementRule || object instanceof OmPlacementRuleSegment || object instanceof OmPlacementRuleInstance) {
            return LogType.PLACEMENT_RULE;
        }
        return LogType.NONE;
    }
}
