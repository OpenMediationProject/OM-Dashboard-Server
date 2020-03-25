// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmRolePermission;
import com.adtiming.om.ds.model.UmRolePermissionCriteria;
import com.adtiming.om.ds.model.UmRolePermissionKey;

import java.util.List;

public interface UmRolePermissionMapper {
    int deleteByPrimaryKey(UmRolePermissionKey key);

    int insert(UmRolePermission record);

    int insertSelective(UmRolePermission record);

    List<UmRolePermission> select(UmRolePermissionCriteria criteria);

    UmRolePermission selectByPrimaryKey(UmRolePermissionKey key);

    int updateByPrimaryKeySelective(UmRolePermission record);

    int updateByPrimaryKey(UmRolePermission record);
}