package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmAdnetworkAppChange;
import com.adtiming.om.ds.model.OmAdnetworkAppChangeCriteria;
import java.util.List;

public interface OmAdnetworkAppChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmAdnetworkAppChange record);

    int insertSelective(OmAdnetworkAppChange record);

    List<OmAdnetworkAppChange> selectByExample(OmAdnetworkAppChangeCriteria example);

    OmAdnetworkAppChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmAdnetworkAppChange record);

    int updateByPrimaryKey(OmAdnetworkAppChange record);
}