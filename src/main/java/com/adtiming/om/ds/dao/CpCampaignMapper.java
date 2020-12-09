// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.CpCampaign;
import com.adtiming.om.ds.model.CpCampaignCriteria;
import java.util.List;

public interface CpCampaignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CpCampaign record);

    int insertSelective(CpCampaign record);

    List<CpCampaign> selectWithBLOBs(CpCampaignCriteria example);

    List<CpCampaign> selectByExample(CpCampaignCriteria example);

    CpCampaign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CpCampaign record);

    int updateByPrimaryKeyWithBLOBs(CpCampaign record);

    int updateByPrimaryKey(CpCampaign record);
}