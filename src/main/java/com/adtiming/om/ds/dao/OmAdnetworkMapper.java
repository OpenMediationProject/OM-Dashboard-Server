// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmAdnetwork;
import com.adtiming.om.ds.model.OmAdnetworkCriteria;

import java.util.List;

public interface OmAdnetworkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAdnetwork record);

    int insertSelective(OmAdnetwork record);

    List<OmAdnetwork> select(OmAdnetworkCriteria criteria);

    OmAdnetwork selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAdnetwork record);

    int updateByPrimaryKey(OmAdnetwork record);
}