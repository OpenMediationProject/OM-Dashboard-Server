// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementRule;
import com.adtiming.om.ds.model.OmPlacementRuleCriteria;
import java.util.List;

public interface OmPlacementRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementRule record);

    int insertSelective(OmPlacementRule record);

    List<OmPlacementRule> select(OmPlacementRuleCriteria example);

    List<OmPlacementRule> selectCountries(OmPlacementRuleCriteria example);

    OmPlacementRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementRule record);

    int updateByPrimaryKey(OmPlacementRule record);
}