// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmDict;
import com.adtiming.om.ds.model.OmDictCriteria;

import java.util.List;

public interface OmDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmDict record);

    int insertSelective(OmDict record);

    List<OmDict> selectWithBLOBs(OmDictCriteria example);

    List<OmDict> selectByExample(OmDictCriteria example);

    OmDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmDict record);

    int updateByPrimaryKeyWithBLOBs(OmDict record);

    int updateByPrimaryKey(OmDict record);
}