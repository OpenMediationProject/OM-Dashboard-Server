package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmAdnetworkApp;
import com.adtiming.om.ds.model.OmAdnetworkAppCriteria;

import java.util.List;

public interface OmAdnetworkAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAdnetworkApp record);

    int insertSelective(OmAdnetworkApp record);

    List<OmAdnetworkApp> select(OmAdnetworkAppCriteria example);

    OmAdnetworkApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAdnetworkApp record);

    int updateByPrimaryKey(OmAdnetworkApp record);
}