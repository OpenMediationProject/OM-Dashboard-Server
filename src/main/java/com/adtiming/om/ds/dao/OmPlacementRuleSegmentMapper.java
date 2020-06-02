// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementRuleSegment;
import com.adtiming.om.ds.model.OmPlacementRuleSegmentCriteria;
import com.adtiming.om.ds.model.OmPlacementRuleSegmentWithBLOBs;
import java.util.List;

public interface OmPlacementRuleSegmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementRuleSegmentWithBLOBs record);

    int insertSelective(OmPlacementRuleSegmentWithBLOBs record);

    List<OmPlacementRuleSegmentWithBLOBs> selectWithBLOBs(OmPlacementRuleSegmentCriteria example);

    List<OmPlacementRuleSegment> select(OmPlacementRuleSegmentCriteria example);

    OmPlacementRuleSegmentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementRuleSegmentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmPlacementRuleSegmentWithBLOBs record);

    int updateByPrimaryKey(OmPlacementRuleSegment record);
}