// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmRole;
import com.adtiming.om.ds.model.UmRoleCriteria;

import java.util.List;

public interface UmRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmRole record);

    int insertSelective(UmRole record);

    List<UmRole> select(UmRoleCriteria criteria);

    UmRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmRole record);

    int updateByPrimaryKey(UmRole record);

    List<UmRole> getUserRoles(Integer userId);
}