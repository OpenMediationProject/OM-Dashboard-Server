// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCampaignPeriod;
import com.adtiming.om.ds.model.CpCampaignPeriodCriteria;
import java.util.List;

public interface CpCampaignPeriodMapper {
    int deleteByPrimaryKey(Integer campaignId);

    int insert(CpCampaignPeriod record);

    int insertSelective(CpCampaignPeriod record);

    List<CpCampaignPeriod> selectByExample(CpCampaignPeriodCriteria example);

    CpCampaignPeriod selectByPrimaryKey(Integer campaignId);

    int updateByPrimaryKeySelective(CpCampaignPeriod record);

    int updateByPrimaryKey(CpCampaignPeriod record);
}