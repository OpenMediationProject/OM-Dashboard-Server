// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dao;

import com.adtiming.om.ds.model.UmPermission;
import com.adtiming.om.ds.model.UmPermissionCriteria;

import java.util.List;

public interface UmPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UmPermission record);

    int insertSelective(UmPermission record);

    List<UmPermission> selectWithBLOBs(UmPermissionCriteria criteria);

    List<UmPermission> select(UmPermissionCriteria criteria);

    UmPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UmPermission record);

    int updateByPrimaryKeyWithBLOBs(UmPermission record);

    int updateByPrimaryKey(UmPermission record);

    List<UmPermission> getUserPermissions(Integer userId);
}