// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmCurrencyExchangeDay;
import com.adtiming.om.ds.model.OmCurrencyExchangeDayCriteria;

import java.util.List;

public interface OmCurrencyExchangeDayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmCurrencyExchangeDay record);

    int insertSelective(OmCurrencyExchangeDay record);

    List<OmCurrencyExchangeDay> selectByExample(OmCurrencyExchangeDayCriteria example);

    OmCurrencyExchangeDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmCurrencyExchangeDay record);

    int updateByPrimaryKey(OmCurrencyExchangeDay record);
}