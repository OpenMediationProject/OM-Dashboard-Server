// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpMaterial;
import com.adtiming.om.ds.model.CpMaterialCriteria;
import java.util.List;

public interface CpMaterialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpMaterial record);

    int insertSelective(CpMaterial record);

    List<CpMaterial> select(CpMaterialCriteria example);

    CpMaterial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpMaterial record);

    int updateByPrimaryKey(CpMaterial record);
}