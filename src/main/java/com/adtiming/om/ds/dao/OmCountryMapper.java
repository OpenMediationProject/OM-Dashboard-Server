// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmCountry;
import com.adtiming.om.ds.model.OmCountryCriteria;

import java.util.List;

public interface OmCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmCountry record);

    int insertSelective(OmCountry record);

    List<OmCountry> selectByExampleWithBLOBs(OmCountryCriteria example);

    List<OmCountry> select(OmCountryCriteria example);

    OmCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmCountry record);

    int updateByPrimaryKeyWithBLOBs(OmCountry record);

    int updateByPrimaryKey(OmCountry record);
}