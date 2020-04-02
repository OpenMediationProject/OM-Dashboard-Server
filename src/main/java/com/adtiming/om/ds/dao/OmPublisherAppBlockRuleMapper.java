// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPublisherAppBlockRule;
import com.adtiming.om.ds.model.OmPublisherAppBlockRuleCriteria;
import com.adtiming.om.ds.model.OmPublisherAppBlockRuleWithBLOBs;

import java.util.List;

public interface OmPublisherAppBlockRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPublisherAppBlockRuleWithBLOBs record);

    int insertSelective(OmPublisherAppBlockRuleWithBLOBs record);

    List<OmPublisherAppBlockRuleWithBLOBs> selectByExampleWithBLOBs(OmPublisherAppBlockRuleCriteria example);

    List<OmPublisherAppBlockRule> selectByExample(OmPublisherAppBlockRuleCriteria example);

    OmPublisherAppBlockRuleWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPublisherAppBlockRuleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmPublisherAppBlockRuleWithBLOBs record);

    int updateByPrimaryKey(OmPublisherAppBlockRule record);
}