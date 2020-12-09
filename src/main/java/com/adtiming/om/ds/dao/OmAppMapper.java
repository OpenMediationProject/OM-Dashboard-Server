// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmApp;
import com.adtiming.om.ds.model.OmAppCriteria;
import com.adtiming.om.ds.model.OmAppWithBLOBs;
import java.util.List;

public interface OmAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAppWithBLOBs record);

    int insertSelective(OmAppWithBLOBs record);

    List<OmAppWithBLOBs> selectWithBLOBs(OmAppCriteria example);

    List<OmApp> select(OmAppCriteria example);

    OmAppWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAppWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmAppWithBLOBs record);

    int updateByPrimaryKey(OmApp record);
}