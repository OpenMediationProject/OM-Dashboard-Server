// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmDevDevice;
import com.adtiming.om.ds.model.OmDevDeviceCriteria;

import java.util.List;

public interface OmDevDeviceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmDevDevice record);

    int insertSelective(OmDevDevice record);

    List<OmDevDevice> select(OmDevDeviceCriteria criteria);

    OmDevDevice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmDevDevice record);

    int updateByPrimaryKey(OmDevDevice record);
}