// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatLr;
import com.adtiming.om.ds.model.StatLrCriteria;
import com.adtiming.om.ds.model.StatLrKey;
import java.util.List;
import java.util.Map;

public interface StatLrMapper {
    int deleteByPrimaryKey(StatLrKey key);

    int insert(StatLr record);

    int insertSelective(StatLr record);

    List<StatLr> selectByExample(StatLrCriteria example);

    StatLr selectByPrimaryKey(StatLrKey key);

    int updateByPrimaryKeySelective(StatLr record);

    int updateByPrimaryKey(StatLr record);

    List<StatLr> selectSummary(Map<String, Object> parameterMap);
}