// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-3-11.
 */
public enum RoleType {
    ADMINISTRATOR(1), ORGANIZATION_OWNER(20), APP_OWNER(30), APP_OPERATOR(40), APP_VIEWER(50);

    private int id;

    RoleType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
