// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmUser;
import com.adtiming.om.ds.model.UmUserCriteria;

import java.util.List;

public interface UmUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmUser record);

    int insertSelective(UmUser record);

    List<UmUser> select(UmUserCriteria criteria);

    UmUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmUser record);

    int updateByPrimaryKey(UmUser record);

    UmUser getUserByName(String userName);

    List<UmUser> getUsersByName(String userName);

    List<UmUser> selectByPublisherId(Integer publisherId);

    List<UmUser> selectUsers(UmUserCriteria criteria);
}