// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCampaignBidprice;
import com.adtiming.om.ds.model.CpCampaignBidpriceCriteria;
import java.util.List;

public interface CpCampaignBidpriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpCampaignBidprice record);

    int insertSelective(CpCampaignBidprice record);

    List<CpCampaignBidprice> select(CpCampaignBidpriceCriteria example);

    CpCampaignBidprice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpCampaignBidprice record);

    int updateByPrimaryKey(CpCampaignBidprice record);
}