// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpMaterialApp;
import com.adtiming.om.ds.model.CpMaterialAppCriteria;
import com.adtiming.om.ds.model.CpMaterialAppKey;
import java.util.List;

public interface CpMaterialAppMapper {
    int deleteByPrimaryKey(CpMaterialAppKey key);

    int insert(CpMaterialApp record);

    int insertSelective(CpMaterialApp record);

    List<CpMaterialApp> select(CpMaterialAppCriteria example);

    CpMaterialApp selectByPrimaryKey(CpMaterialAppKey key);

    int updateByPrimaryKeySelective(CpMaterialApp record);

    int updateByPrimaryKey(CpMaterialApp record);
}