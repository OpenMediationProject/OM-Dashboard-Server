// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmUserApp;
import com.adtiming.om.ds.model.UmUserAppCriteria;
import com.adtiming.om.ds.model.UmUserAppKey;

import java.util.List;

public interface UmUserAppMapper {
    int deleteByPrimaryKey(UmUserAppKey key);

    int insert(UmUserApp record);

    int insertSelective(UmUserApp record);

    List<UmUserApp> select(UmUserAppCriteria criteria);

    UmUserApp selectByPrimaryKey(UmUserAppKey key);

    int updateByPrimaryKeySelective(UmUserApp record);

    int updateByPrimaryKey(UmUserApp record);
}