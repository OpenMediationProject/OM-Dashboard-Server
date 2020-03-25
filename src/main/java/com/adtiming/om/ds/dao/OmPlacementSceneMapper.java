// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPlacementScene;
import com.adtiming.om.ds.model.OmPlacementSceneCriteria;

import java.util.List;

public interface OmPlacementSceneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPlacementScene record);

    int insertSelective(OmPlacementScene record);

    List<OmPlacementScene> select(OmPlacementSceneCriteria criteria);

    OmPlacementScene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPlacementScene record);

    int updateByPrimaryKey(OmPlacementScene record);
}