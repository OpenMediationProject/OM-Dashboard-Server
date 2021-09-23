// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementRuleAbt;
import com.adtiming.om.ds.model.OmPlacementRuleAbtCriteria;
import java.util.List;

public interface OmPlacementRuleAbtMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementRuleAbt record);

    int insertSelective(OmPlacementRuleAbt record);

    List<OmPlacementRuleAbt> selectByExample(OmPlacementRuleAbtCriteria example);

    OmPlacementRuleAbt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementRuleAbt record);

    int updateByPrimaryKey(OmPlacementRuleAbt record);
}