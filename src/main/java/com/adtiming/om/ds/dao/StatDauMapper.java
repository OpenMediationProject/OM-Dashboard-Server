// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDau;
import com.adtiming.om.ds.model.StatDauCriteria;
import com.adtiming.om.ds.model.StatDauKey;

import java.util.List;
import java.util.Map;

public interface StatDauMapper {
    int deleteByPrimaryKey(StatDauKey key);

    int insert(StatDau record);

    int insertSelective(StatDau record);

    List<StatDau> selectByExample(StatDauCriteria example);

    StatDau selectByPrimaryKey(StatDauKey key);

    int updateByPrimaryKeySelective(StatDau record);

    int updateByPrimaryKey(StatDau record);

    List<StatDau> selectSummary(Map<String, Object> parameterMap);
}