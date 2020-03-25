// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-26.
 */
public enum SwitchStatus {
    OFF, ON;

    public static SwitchStatus getSwitchStatus(int switchStatus) {
        switch (switchStatus) {
            case 0:
                return OFF;
            case 1:
                return ON;
            default:
                return null;
        }
    }
}
