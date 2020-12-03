// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDauAdn;
import com.adtiming.om.ds.model.StatDauAdnCriteria;
import com.adtiming.om.ds.model.StatDauAdnKey;

import java.util.List;
import java.util.Map;

public interface StatDauAdnMapper {
    int deleteByPrimaryKey(StatDauAdnKey key);

    int insert(StatDauAdn record);

    int insertSelective(StatDauAdn record);

    List<StatDauAdn> selectByExample(StatDauAdnCriteria example);

    StatDauAdn selectByPrimaryKey(StatDauAdnKey key);

    int updateByPrimaryKeySelective(StatDauAdn record);

    int updateByPrimaryKey(StatDauAdn record);

    List<StatDauAdn> selectSummary(Map<String, Object> parameterMap);
}