// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.ReportAdnetworkAccountPublisher;
import com.adtiming.om.ds.model.ReportAdnetworkAccountPublisherCriteria;
import com.adtiming.om.ds.model.ReportAdnetworkAccountPublisherKey;
import java.util.List;

public interface ReportAdnetworkAccountPublisherMapper {
    int deleteByPrimaryKey(ReportAdnetworkAccountPublisherKey key);

    int insert(ReportAdnetworkAccountPublisher record);

    int insertSelective(ReportAdnetworkAccountPublisher record);

    List<ReportAdnetworkAccountPublisher> select(ReportAdnetworkAccountPublisherCriteria example);

    ReportAdnetworkAccountPublisher selectByPrimaryKey(ReportAdnetworkAccountPublisherKey key);

    int updateByPrimaryKeySelective(ReportAdnetworkAccountPublisher record);

    int updateByPrimaryKey(ReportAdnetworkAccountPublisher record);
}