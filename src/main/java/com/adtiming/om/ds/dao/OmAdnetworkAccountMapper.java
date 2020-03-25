// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmAdnetworkAccount;
import com.adtiming.om.ds.model.OmAdnetworkAccountCriteria;

import java.util.List;

public interface OmAdnetworkAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAdnetworkAccount record);

    int insertSelective(OmAdnetworkAccount record);

    List<OmAdnetworkAccount> selectByExample(OmAdnetworkAccountCriteria example);

    OmAdnetworkAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAdnetworkAccount record);

    int updateByPrimaryKey(OmAdnetworkAccount record);
}