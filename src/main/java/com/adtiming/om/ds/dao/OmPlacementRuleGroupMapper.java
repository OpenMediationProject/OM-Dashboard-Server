package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementRuleGroup;
import com.adtiming.om.ds.model.OmPlacementRuleGroupCriteria;
import java.util.List;

public interface OmPlacementRuleGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementRuleGroup record);

    int insertSelective(OmPlacementRuleGroup record);

    List<OmPlacementRuleGroup> select(OmPlacementRuleGroupCriteria example);

    OmPlacementRuleGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementRuleGroup record);

    int updateByPrimaryKey(OmPlacementRuleGroup record);
}