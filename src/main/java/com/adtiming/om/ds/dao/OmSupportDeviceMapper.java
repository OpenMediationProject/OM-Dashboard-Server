// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmSupportDevice;
import com.adtiming.om.ds.model.OmSupportDeviceCriteria;

import java.util.List;

public interface OmSupportDeviceMapper {
    int insert(OmSupportDevice record);

    int insertSelective(OmSupportDevice record);

    List<OmSupportDevice> select(OmSupportDeviceCriteria criteria);
}