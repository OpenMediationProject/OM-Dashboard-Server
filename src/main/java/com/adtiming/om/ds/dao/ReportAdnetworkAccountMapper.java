package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.ReportAdnetworkAccount;
import com.adtiming.om.ds.model.ReportAdnetworkAccountCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportAdnetworkAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportAdnetworkAccount record);

    int insertSelective(ReportAdnetworkAccount record);

    List<ReportAdnetworkAccount> select(ReportAdnetworkAccountCriteria criteria);

    ReportAdnetworkAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportAdnetworkAccount record);

    int updateByPrimaryKey(ReportAdnetworkAccount record);

    List<ReportAdnetworkAccount> selectByDynamic(String whereSql);

    List<ReportAdnetworkAccount> selectWithAppIconByPublisher(@Param("publisherId") Integer publisherId);
}