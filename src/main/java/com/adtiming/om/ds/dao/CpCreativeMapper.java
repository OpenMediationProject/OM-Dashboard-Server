// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCreative;
import com.adtiming.om.ds.model.CpCreativeCriteria;
import java.util.List;

public interface CpCreativeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpCreative record);

    int insertSelective(CpCreative record);

    List<CpCreative> selectWithBLOBs(CpCreativeCriteria example);

    List<CpCreative> selectByExample(CpCreativeCriteria example);

    CpCreative selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpCreative record);

    int updateByPrimaryKeyWithBLOBs(CpCreative record);

    int updateByPrimaryKey(CpCreative record);
}