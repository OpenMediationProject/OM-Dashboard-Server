// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDauInstance;
import com.adtiming.om.ds.model.StatDauInstanceCriteria;
import com.adtiming.om.ds.model.StatDauInstanceKey;

import java.util.List;
import java.util.Map;

public interface StatDauInstanceMapper {
    int deleteByPrimaryKey(StatDauInstanceKey key);

    int insert(StatDauInstance record);

    int insertSelective(StatDauInstance record);

    List<StatDauInstance> selectByExample(StatDauInstanceCriteria example);

    StatDauInstance selectByPrimaryKey(StatDauInstanceKey key);

    int updateByPrimaryKeySelective(StatDauInstance record);

    int updateByPrimaryKey(StatDauInstance record);

    List<StatDauInstance> selectSummary(Map<String, Object> parameterMap);
}