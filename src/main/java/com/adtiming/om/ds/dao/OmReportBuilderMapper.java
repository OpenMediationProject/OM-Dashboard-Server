// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmReportBuilder;
import com.adtiming.om.ds.model.OmReportBuilderCriteria;
import com.adtiming.om.ds.model.OmReportBuilderWithBLOBs;

import java.util.List;

public interface OmReportBuilderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmReportBuilderWithBLOBs record);

    int insertSelective(OmReportBuilderWithBLOBs record);

    List<OmReportBuilderWithBLOBs> selectWithBLOBs(OmReportBuilderCriteria example);

    List<OmReportBuilder> select(OmReportBuilderCriteria example);

    OmReportBuilderWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmReportBuilderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OmReportBuilderWithBLOBs record);

    int updateByPrimaryKey(OmReportBuilder record);
}