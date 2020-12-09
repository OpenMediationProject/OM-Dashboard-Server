// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCampaignTargeting;
import com.adtiming.om.ds.model.CpCampaignTargetingCriteria;
import java.util.List;

public interface CpCampaignTargetingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpCampaignTargeting record);

    int insertSelective(CpCampaignTargeting record);

    List<CpCampaignTargeting> select(CpCampaignTargetingCriteria example);

    CpCampaignTargeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpCampaignTargeting record);

    int updateByPrimaryKey(CpCampaignTargeting record);

    int deleteByCampaignId(Integer campaignId);
}