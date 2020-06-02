// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmCurrencyExchange;
import com.adtiming.om.ds.model.OmCurrencyExchangeCriteria;

import java.util.List;

public interface OmCurrencyExchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmCurrencyExchange record);

    int insertSelective(OmCurrencyExchange record);

    List<OmCurrencyExchange> select(OmCurrencyExchangeCriteria criteria);

    OmCurrencyExchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmCurrencyExchange record);

    int updateByPrimaryKey(OmCurrencyExchange record);
}