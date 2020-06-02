// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Advertisement Type enum
 *
 * @author dianbo
 */
public enum AdvertisementType {
    Banner, Native, RewardedVideo, Interstitial, Splash;

    public static AdvertisementType getAdvertisementType(int advertisementType) {
        switch (advertisementType) {
            case 0:
                return Banner;
            case 1:
                return Native;
            case 2:
                return RewardedVideo;
            case 3:
                return Interstitial;
            case 4:
                return Splash;
            default:
                return Banner;
        }
    }
}
