// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmUserRole;
import com.adtiming.om.ds.model.UmUserRoleCriteria;
import com.adtiming.om.ds.model.UmUserRoleKey;

import java.util.List;

public interface UmUserRoleMapper {
    int deleteByPrimaryKey(UmUserRoleKey key);

    int insert(UmUserRole record);

    int insertSelective(UmUserRole record);

    List<UmUserRole> select(UmUserRoleCriteria criteria);

    UmUserRole selectByPrimaryKey(UmUserRoleKey key);

    int updateByPrimaryKeySelective(UmUserRole record);

    int updateByPrimaryKey(UmUserRole record);
}