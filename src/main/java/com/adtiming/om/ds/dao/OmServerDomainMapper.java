// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmServerDomain;
import com.adtiming.om.ds.model.OmServerDomainCriteria;

import java.util.List;

public interface OmServerDomainMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(OmServerDomain record);

    int insertSelective(OmServerDomain record);

    List<OmServerDomain> selectByExample(OmServerDomainCriteria example);

    OmServerDomain selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(OmServerDomain record);

    int updateByPrimaryKey(OmServerDomain record);
}