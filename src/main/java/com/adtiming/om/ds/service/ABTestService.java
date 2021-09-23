// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.service;

import com.adtiming.om.ds.dao.OmPlacementRuleAbtMapper;
import com.adtiming.om.ds.dto.SwitchStatus;
import com.adtiming.om.ds.model.OmPlacementRuleAbt;
import com.adtiming.om.ds.model.OmPlacementRuleAbtCriteria;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author dianbo ruan
 */
@Service
public class ABTestService {

    private static final Logger log = LogManager.getLogger();

    @Resource
    OmPlacementRuleAbtMapper omPlacementRuleAbtMapper;

    @Transactional
    public OmPlacementRuleAbt createABTestHistory(int ruleId, String testName) {
        Date date = new Date();
        OmPlacementRuleAbt history = new OmPlacementRuleAbt();
        if (StringUtils.isEmpty(testName)) {
            testName = "ABTest";
        }
        history.setName(testName);
        history.setRuleId(ruleId);
        history.setCreateTime(date);
        history.setLastmodify(date);
        history.setStatus(SwitchStatus.ON.ordinal());
        int result = this.omPlacementRuleAbtMapper.insertSelective(history);
        if (result <= 0) {
            throw new RuntimeException("Insert abtest history failed" + JSONObject.toJSONString(history));
        }
        log.info("Insert abtest history {} success", JSONObject.toJSONString(history));
        return history;
    }

    @Transactional
    public void saveABTestHistory(int ruleId, int resultAbt, String ruleConf, String instanceConf, String report) {
        OmPlacementRuleAbt history;
        List<OmPlacementRuleAbt> historyList = this.getABTestHistoryList(ruleId, SwitchStatus.ON);
        if (CollectionUtils.isEmpty(historyList)) {
            history = this.createABTestHistory(ruleId, null);
        } else {
            history = historyList.get(0);
        }
        history.setReport(report);
        history.setRuleConf(ruleConf);
        history.setInstanceConf(instanceConf);
        history.setStatus(SwitchStatus.OFF.ordinal());
        history.setResultAb(resultAbt);
        history.setEndTime(new Date());
        int result = this.omPlacementRuleAbtMapper.updateByPrimaryKeySelective(history);
        if (result <= 0) {
            throw new RuntimeException("Update abtest history failed" + JSONObject.toJSONString(history));
        }
    }

    public OmPlacementRuleAbt getABTestHistory(int id) {
        return this.omPlacementRuleAbtMapper.selectByPrimaryKey(id);
    }

    public OmPlacementRuleAbt getCurrentABTest(int ruleId) {
        List<Integer> ruleIds = new ArrayList<>();
        ruleIds.add(ruleId);
        List<OmPlacementRuleAbt> abts = this.getABTestHistoryList(ruleIds, SwitchStatus.ON);
        if (!CollectionUtils.isEmpty(abts)) {
            return abts.get(0);
        }
        return null;
    }

    public List<OmPlacementRuleAbt> getABTestHistoryList(int ruleId, SwitchStatus status) {
        OmPlacementRuleAbtCriteria historyCriteria = new OmPlacementRuleAbtCriteria();
        OmPlacementRuleAbtCriteria.Criteria criteria = historyCriteria.createCriteria();
        criteria.andRuleIdEqualTo(ruleId);
        if (status != null) {
            criteria.andStatusEqualTo(status.ordinal());
        }
        PageHelper.orderBy(" create_time desc ");
        return this.omPlacementRuleAbtMapper.selectByExample(historyCriteria);
    }

    public Map<Integer, List<OmPlacementRuleAbt>> getABTestHistoryIdsMap(List<Integer> ruleIds) {
        Map<Integer, List<OmPlacementRuleAbt>> ruleABTestHistoryMap = new HashMap<>();
        List<OmPlacementRuleAbt> historyList = this.getABTestHistoryList(ruleIds, null);
        if (CollectionUtils.isEmpty(historyList)) {
            return ruleABTestHistoryMap;
        }
        for (OmPlacementRuleAbt history : historyList) {
            if (history.getEndTime() == null) {
                history.setEndTime(new Date());
            }
            List<OmPlacementRuleAbt> historyIds = ruleABTestHistoryMap.computeIfAbsent(history.getRuleId(), k -> new ArrayList<>());
            historyIds.add(history);
        }
        if (!CollectionUtils.isEmpty(ruleABTestHistoryMap)) {
            for (List<OmPlacementRuleAbt> history : ruleABTestHistoryMap.values()) {
                history.sort(Comparator.comparingInt(OmPlacementRuleAbt::getId));
                Collections.reverse(historyList);
            }
        }
        return ruleABTestHistoryMap;
    }

    public List<OmPlacementRuleAbt> getABTestHistoryList(List<Integer> ruleIds, SwitchStatus status) {
        OmPlacementRuleAbtCriteria historyCriteria = new OmPlacementRuleAbtCriteria();
        OmPlacementRuleAbtCriteria.Criteria criteria = historyCriteria.createCriteria();
        criteria.andRuleIdIn(ruleIds);
        if (status != null) {
            criteria.andStatusEqualTo(status.ordinal());
        }
        PageHelper.orderBy(" create_time desc ");
        return this.omPlacementRuleAbtMapper.selectByExample(historyCriteria);
    }
}
