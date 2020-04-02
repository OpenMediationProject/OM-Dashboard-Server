// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementCountry;
import com.adtiming.om.ds.model.OmPlacementCountryCriteria;

import java.util.List;

public interface OmPlacementCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementCountry record);

    int insertSelective(OmPlacementCountry record);

    List<OmPlacementCountry> select(OmPlacementCountryCriteria countryCriteria);

    OmPlacementCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementCountry record);

    int updateByPrimaryKey(OmPlacementCountry record);
}