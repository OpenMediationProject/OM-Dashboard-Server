// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmCompany;
import com.adtiming.om.ds.model.OmCompanyCriteria;

import java.util.List;

public interface OmCompanyMapper {
    int deleteByPrimaryKey(Byte id);

    int insert(OmCompany record);

    int insertSelective(OmCompany record);

    List<OmCompany> selectByExample(OmCompanyCriteria example);

    OmCompany selectByPrimaryKey(Byte id);

    int updateByPrimaryKeySelective(OmCompany record);

    int updateByPrimaryKey(OmCompany record);
}