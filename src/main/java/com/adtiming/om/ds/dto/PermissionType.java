// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-24.
 */
public enum PermissionType {
    none, add, edit, query;

    public static PermissionType getPermissionType(String permissionType) {
        if ("add".equals(permissionType)) {
            return add;
        } else if ("edit".equals(permissionType)) {
            return edit;
        } else if ("view".equals(permissionType)) {
            return query;
        } else if ("none".equals(permissionType)) {
            return none;
        }
        return null;
    }
}
