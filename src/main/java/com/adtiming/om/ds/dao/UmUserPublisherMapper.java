// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmUserPublisher;
import com.adtiming.om.ds.model.UmUserPublisherCriteria;
import com.adtiming.om.ds.model.UmUserPublisherKey;

import java.util.List;

public interface UmUserPublisherMapper {
    int deleteByPrimaryKey(UmUserPublisherKey key);

    int insert(UmUserPublisher record);

    int insertSelective(UmUserPublisher record);

    List<UmUserPublisher> select(UmUserPublisherCriteria criteria);

    UmUserPublisher selectByPrimaryKey(UmUserPublisherKey key);

    int updateByPrimaryKeySelective(UmUserPublisher record);

    int updateByPrimaryKey(UmUserPublisher record);
}