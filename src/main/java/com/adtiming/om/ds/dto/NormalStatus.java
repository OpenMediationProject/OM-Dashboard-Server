// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-13.
 */
public enum NormalStatus {
    Pending, Active, Paused, Deleted;

    public static NormalStatus getStatus(Integer instanceStatus) {
        if (instanceStatus == null) {
            return Pending;
        }
        switch (instanceStatus) {
            case 1:
                return Active;
            case 2:
                return Paused;
            case 3:
                return Deleted;
            default:
                return Pending;
        }
    }
}
