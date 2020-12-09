// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatDauAdnPlacement;
import com.adtiming.om.ds.model.StatDauAdnPlacementCriteria;
import com.adtiming.om.ds.model.StatDauAdnPlacementKey;

import java.util.List;
import java.util.Map;

public interface StatDauAdnPlacementMapper {
    int deleteByPrimaryKey(StatDauAdnPlacementKey key);

    int insert(StatDauAdnPlacement record);

    int insertSelective(StatDauAdnPlacement record);

    List<StatDauAdnPlacement> selectByExample(StatDauAdnPlacementCriteria example);

    StatDauAdnPlacement selectByPrimaryKey(StatDauAdnPlacementKey key);

    int updateByPrimaryKeySelective(StatDauAdnPlacement record);

    int updateByPrimaryKey(StatDauAdnPlacement record);

    List<StatDauAdnPlacement> selectSummary(Map<String, Object> parameterMap);
}