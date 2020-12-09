// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatUserLtv;
import com.adtiming.om.ds.model.StatUserLtvCriteria;

import java.util.List;
import java.util.Map;

public interface StatUserLtvMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StatUserLtv record);

    int insertSelective(StatUserLtv record);

    List<StatUserLtv> select(StatUserLtvCriteria criteria);

    StatUserLtv selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatUserLtv record);

    int updateByPrimaryKey(StatUserLtv record);

    List<StatUserLtv> selectSummary(Map<String, Object> parameterMap);
}