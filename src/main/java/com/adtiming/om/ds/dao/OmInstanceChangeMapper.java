package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmInstanceChange;
import com.adtiming.om.ds.model.OmInstanceChangeCriteria;
import com.adtiming.om.ds.model.OmInstanceChangeKey;

import java.util.List;

public interface OmInstanceChangeMapper {
    int deleteByPrimaryKey(OmInstanceChangeKey key);

    int insert(OmInstanceChange record);

    int insertSelective(OmInstanceChange record);

    List<OmInstanceChange> selectByExample(OmInstanceChangeCriteria example);

    OmInstanceChange selectByPrimaryKey(OmInstanceChangeKey key);

    int updateByPrimaryKeySelective(OmInstanceChange record);

    int updateByPrimaryKey(OmInstanceChange record);
}