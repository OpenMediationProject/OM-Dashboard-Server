// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmInstanceCountry;
import com.adtiming.om.ds.model.OmInstanceCountryCriteria;

import java.util.List;

public interface OmInstanceCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmInstanceCountry record);

    int insertSelective(OmInstanceCountry record);

    List<OmInstanceCountry> select(OmInstanceCountryCriteria criteria);

    OmInstanceCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmInstanceCountry record);

    int updateByPrimaryKey(OmInstanceCountry record);
}