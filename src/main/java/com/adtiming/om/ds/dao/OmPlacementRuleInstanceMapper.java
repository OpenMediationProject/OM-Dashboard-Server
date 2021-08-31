// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementRuleInstance;
import com.adtiming.om.ds.model.OmPlacementRuleInstanceCriteria;

import java.util.List;

public interface OmPlacementRuleInstanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(OmPlacementRuleInstance record);

    List<OmPlacementRuleInstance> select(OmPlacementRuleInstanceCriteria criteria);

    OmPlacementRuleInstance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementRuleInstance record);

    int updateByPrimaryKey(OmPlacementRuleInstance record);
}