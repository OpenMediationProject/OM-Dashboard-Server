// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmAdnetworkAppBlockRule;
import com.adtiming.om.ds.model.OmAdnetworkAppBlockRuleCriteria;
import com.adtiming.om.ds.model.OmAdnetworkAppBlockRuleWithBLOBs;

import java.util.List;

public interface OmAdnetworkAppBlockRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAdnetworkAppBlockRuleWithBLOBs record);

    int insertSelective(OmAdnetworkAppBlockRuleWithBLOBs record);

    List<OmAdnetworkAppBlockRuleWithBLOBs> selectByExampleWithBLOBs(OmAdnetworkAppBlockRuleCriteria example);

    List<OmAdnetworkAppBlockRule> selectByExample(OmAdnetworkAppBlockRuleCriteria example);

    OmAdnetworkAppBlockRuleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAdnetworkAppBlockRuleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmAdnetworkAppBlockRuleWithBLOBs record);

    int updateByPrimaryKey(OmAdnetworkAppBlockRule record);
}