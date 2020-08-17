package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmMessageDict;
import com.adtiming.om.ds.model.OmMessageDictCriteria;
import java.util.List;

public interface OmMessageDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmMessageDict record);

    int insertSelective(OmMessageDict record);

    List<OmMessageDict> selectWithBLOBs(OmMessageDictCriteria example);

    List<OmMessageDict> selectByExample(OmMessageDictCriteria example);

    OmMessageDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmMessageDict record);

    int updateByPrimaryKeyWithBLOBs(OmMessageDict record);

    int updateByPrimaryKey(OmMessageDict record);
}