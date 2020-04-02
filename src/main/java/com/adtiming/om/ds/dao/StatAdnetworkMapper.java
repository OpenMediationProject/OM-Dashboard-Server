// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatAdnetwork;
import com.adtiming.om.ds.model.StatAdnetworkCriteria;
import com.adtiming.om.ds.model.StatAdnetworkKey;

import java.util.List;
import java.util.Map;

public interface StatAdnetworkMapper {
    int deleteByPrimaryKey(StatAdnetworkKey key);

    int insert(StatAdnetwork record);

    int insertSelective(StatAdnetwork record);

    List<StatAdnetwork> select(StatAdnetworkCriteria example);

    StatAdnetwork selectByPrimaryKey(StatAdnetworkKey key);

    int updateByPrimaryKeySelective(StatAdnetwork record);

    int updateByPrimaryKey(StatAdnetwork record);

    List<StatAdnetwork> selectSummary(Map<String, Object> parameterMap);
}