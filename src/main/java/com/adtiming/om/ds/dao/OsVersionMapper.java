// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OsVersion;
import com.adtiming.om.ds.model.OsVersionCriteria;
import java.util.List;

public interface OsVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OsVersion record);

    int insertSelective(OsVersion record);

    List<OsVersion> select(OsVersionCriteria example);

    OsVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OsVersion record);

    int updateByPrimaryKey(OsVersion record);
}