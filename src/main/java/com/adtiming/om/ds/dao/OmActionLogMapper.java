package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.OmActionLog;
import com.adtiming.om.ds.model.OmActionLogCriteria;
import java.util.List;

public interface OmActionLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OmActionLog record);

    int insertSelective(OmActionLog record);

    List<OmActionLog> selectByExampleWithBLOBs(OmActionLogCriteria example);

    List<OmActionLog> selectByExample(OmActionLogCriteria example);

    OmActionLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OmActionLog record);

    int updateByPrimaryKeyWithBLOBs(OmActionLog record);

    int updateByPrimaryKey(OmActionLog record);
}