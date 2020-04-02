// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-13.
 */
public enum AdNetworkAppStatus {
    Pending, Active, Paused, Deleted, ADN_Paused;

    public static AdNetworkAppStatus getAdNetworkAppStatus(int adNetworkAppStatus) {
        switch (adNetworkAppStatus) {
            case 0:
                return Pending;
            case 1:
                return Active;
            case 2:
                return Paused;
            case 3:
                return Deleted;
            case 4:
                return ADN_Paused;
            default:
                return Pending;
        }
    }
}
