// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmDataCenter;
import com.adtiming.om.ds.model.OmDataCenterCriteria;

import java.util.List;

public interface OmDataCenterMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(OmDataCenter record);

    int insertSelective(OmDataCenter record);

    List<OmDataCenter> selectByExample(OmDataCenterCriteria example);

    OmDataCenter selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(OmDataCenter record);

    int updateByPrimaryKey(OmDataCenter record);
}