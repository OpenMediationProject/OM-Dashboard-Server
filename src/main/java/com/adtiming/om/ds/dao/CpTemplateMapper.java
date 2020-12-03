// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpTemplate;
import com.adtiming.om.ds.model.CpTemplateCriteria;
import java.util.List;

public interface CpTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpTemplate record);

    int insertSelective(CpTemplate record);

    List<CpTemplate> select(CpTemplateCriteria criteria);

    CpTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpTemplate record);

    int updateByPrimaryKey(CpTemplate record);
}