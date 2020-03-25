// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-13.
 */
public enum NormalStatus {
    PENDING, ACTIVE;

    public static NormalStatus getStatus(int instanceStatus) {
        switch (instanceStatus) {
            case 0:
                return PENDING;
            case 1:
                return ACTIVE;
            default:
                return PENDING;
        }
    }
}
