// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPublisherApp;
import com.adtiming.om.ds.model.OmPublisherAppCriteria;

import java.util.List;

public interface OmPublisherAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPublisherApp record);

    int insertSelective(OmPublisherApp record);

    List<OmPublisherApp> select(OmPublisherAppCriteria criteria);

    OmPublisherApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPublisherApp record);

    int updateByPrimaryKey(OmPublisherApp record);
}