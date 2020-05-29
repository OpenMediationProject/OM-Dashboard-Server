package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmReportBuilderTask;
import com.adtiming.om.ds.model.OmReportBuilderTaskCriteria;
import java.util.List;

public interface OmReportBuilderTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmReportBuilderTask record);

    int insertSelective(OmReportBuilderTask record);

    List<OmReportBuilderTask> select(OmReportBuilderTaskCriteria criteria);

    OmReportBuilderTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmReportBuilderTask record);

    int updateByPrimaryKey(OmReportBuilderTask record);
}