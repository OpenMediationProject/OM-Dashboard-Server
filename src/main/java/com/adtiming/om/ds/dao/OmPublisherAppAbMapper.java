// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmPublisherAppAb;
import com.adtiming.om.ds.model.OmPublisherAppAbCriteria;

import java.util.List;

public interface OmPublisherAppAbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmPublisherAppAb record);

    int insertSelective(OmPublisherAppAb record);

    List<OmPublisherAppAb> selectByExample(OmPublisherAppAbCriteria example);

    OmPublisherAppAb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmPublisherAppAb record);

    int updateByPrimaryKey(OmPublisherAppAb record);
}