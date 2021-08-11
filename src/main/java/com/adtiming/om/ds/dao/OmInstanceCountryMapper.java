package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmInstanceCountry;
import com.adtiming.om.ds.model.OmInstanceCountryCriteria;
import java.util.List;

public interface OmInstanceCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmInstanceCountry record);

    int insertSelective(OmInstanceCountry record);

    List<OmInstanceCountry> select(OmInstanceCountryCriteria example);

    OmInstanceCountry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmInstanceCountry record);

    int updateByPrimaryKey(OmInstanceCountry record);
}