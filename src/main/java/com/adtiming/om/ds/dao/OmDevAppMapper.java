// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmDevApp;
import com.adtiming.om.ds.model.OmDevAppCriteria;

import java.util.List;

public interface OmDevAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmDevApp record);

    int insertSelective(OmDevApp record);

    List<OmDevApp> select(OmDevAppCriteria criteria);

    OmDevApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmDevApp record);

    int updateByPrimaryKey(OmDevApp record);
}