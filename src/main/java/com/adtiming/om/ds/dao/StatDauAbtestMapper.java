// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDauAbtest;
import com.adtiming.om.ds.model.StatDauAbtestCriteria;
import com.adtiming.om.ds.model.StatDauAbtestKey;

import java.util.List;
import java.util.Map;

public interface StatDauAbtestMapper {
    int deleteByPrimaryKey(StatDauAbtestKey key);

    int insert(StatDauAbtest record);

    int insertSelective(StatDauAbtest record);

    List<StatDauAbtest> selectByExample(StatDauAbtestCriteria example);

    StatDauAbtest selectByPrimaryKey(StatDauAbtestKey key);

    int updateByPrimaryKeySelective(StatDauAbtest record);

    int updateByPrimaryKey(StatDauAbtest record);

    List<StatDauAbtest> selectSummary(Map<String, Object> parameterMap);
}