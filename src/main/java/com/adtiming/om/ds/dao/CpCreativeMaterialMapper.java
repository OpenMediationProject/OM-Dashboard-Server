// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCreativeMaterial;
import com.adtiming.om.ds.model.CpCreativeMaterialCriteria;
import com.adtiming.om.ds.model.CpCreativeMaterialKey;
import java.util.List;

public interface CpCreativeMaterialMapper {
    int deleteByPrimaryKey(CpCreativeMaterialKey key);

    int insert(CpCreativeMaterial record);

    int insertSelective(CpCreativeMaterial record);

    List<CpCreativeMaterial> select(CpCreativeMaterialCriteria example);

    CpCreativeMaterial selectByPrimaryKey(CpCreativeMaterialKey key);

    int updateByPrimaryKeySelective(CpCreativeMaterial record);

    int updateByPrimaryKey(CpCreativeMaterial record);
}