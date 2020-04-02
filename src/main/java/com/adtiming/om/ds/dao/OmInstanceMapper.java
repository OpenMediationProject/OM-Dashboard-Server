// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmInstance;
import com.adtiming.om.ds.model.OmInstanceCriteria;
import com.adtiming.om.ds.model.OmInstanceWithBLOBs;

import java.util.List;

public interface OmInstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmInstanceWithBLOBs record);

    int insertSelective(OmInstanceWithBLOBs record);

    List<OmInstanceWithBLOBs> select(OmInstanceCriteria criteria);

    List<OmInstance> selectByExample(OmInstanceCriteria example);

    OmInstanceWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmInstanceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmInstanceWithBLOBs record);

    int updateByPrimaryKey(OmInstance record);
}