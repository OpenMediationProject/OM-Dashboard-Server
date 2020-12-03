// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDauPlacement;
import com.adtiming.om.ds.model.StatDauPlacementCriteria;
import com.adtiming.om.ds.model.StatDauPlacementKey;

import java.util.List;
import java.util.Map;

public interface StatDauPlacementMapper {
    int deleteByPrimaryKey(StatDauPlacementKey key);

    int insert(StatDauPlacement record);

    int insertSelective(StatDauPlacement record);

    List<StatDauPlacement> selectByExample(StatDauPlacementCriteria example);

    StatDauPlacement selectByPrimaryKey(StatDauPlacementKey key);

    int updateByPrimaryKeySelective(StatDauPlacement record);

    int updateByPrimaryKey(StatDauPlacement record);

    List<StatDauPlacement> selectSummary(Map<String, Object> parameterMap);
}