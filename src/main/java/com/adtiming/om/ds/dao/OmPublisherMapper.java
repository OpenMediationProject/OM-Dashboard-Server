// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPublisher;
import com.adtiming.om.ds.model.OmPublisherCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmPublisherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPublisher record);

    int insertSelective(OmPublisher record);

    List<OmPublisher> select(OmPublisherCriteria criteria);

    OmPublisher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPublisher record);

    int updateByPrimaryKey(OmPublisher record);

    List<OmPublisher> selectWithOwnerEmail();
}