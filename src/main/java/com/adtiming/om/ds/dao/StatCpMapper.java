// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.StatCp;
import com.adtiming.om.ds.model.StatCpCriteria;
import com.adtiming.om.ds.model.StatCpKey;

import java.util.List;
import java.util.Map;

public interface StatCpMapper {
    int deleteByPrimaryKey(StatCpKey key);

    int insert(StatCp record);

    int insertSelective(StatCp record);

    List<StatCp> selectByExample(StatCpCriteria example);

    StatCp selectByPrimaryKey(StatCpKey key);

    int updateByPrimaryKeySelective(StatCp record);

    int updateByPrimaryKey(StatCp record);

    List<StatCp> selectSummary(Map<String, Object> parameterMap);
}