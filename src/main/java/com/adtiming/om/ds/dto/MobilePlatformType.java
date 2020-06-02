// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-6.
 */
public enum MobilePlatformType {
    iOS, Android;

    public static MobilePlatformType getPlatType(int platformType) {
        switch (platformType) {
            case 0:
                return iOS;
            case 1:
                return Android;
            default:
                return Android;
        }
    }
}
