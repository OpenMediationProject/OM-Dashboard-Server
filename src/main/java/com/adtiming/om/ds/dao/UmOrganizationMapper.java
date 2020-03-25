// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmOrganization;
import com.adtiming.om.ds.model.UmOrganizationCriteria;

import java.util.List;

public interface UmOrganizationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmOrganization record);

    int insertSelective(UmOrganization record);

    List<UmOrganization> selectByExample(UmOrganizationCriteria example);

    UmOrganization selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmOrganization record);

    int updateByPrimaryKey(UmOrganization record);
}