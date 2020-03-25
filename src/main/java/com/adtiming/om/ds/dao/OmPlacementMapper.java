// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacement;
import com.adtiming.om.ds.model.OmPlacementCriteria;
import com.adtiming.om.ds.model.OmPlacementWithBLOBs;

import java.util.List;

public interface OmPlacementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementWithBLOBs record);

    int insertSelective(OmPlacementWithBLOBs record);

    List<OmPlacementWithBLOBs> selectWithBLOBs(OmPlacementCriteria example);

    List<OmPlacement> select(OmPlacementCriteria criteria);

    OmPlacementWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmPlacementWithBLOBs record);

    int updateByPrimaryKey(OmPlacement record);
}