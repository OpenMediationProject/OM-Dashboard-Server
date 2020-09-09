package com.adtiming.om.ds.dto;

public enum AdNetworkType {
    NONE(0),
    Adtiming(1),
    AdMob(2),
    Facebook(3),
    Unity(4),
    Vungle(5),
    TencentAd(6),
    AdColony(7),
    AppLovin(8),
    Mopub(9),
    GoogleAd(10),
    Tapjoy(11),
    Chartboost(12),
    TikTok(13),
    Mintegral(14),
    IronSource(15),
    MyTarget(16),
    ChartboostBid(17),
    Mint(18),
    Fyber(30);

    private int value;

    AdNetworkType(int value) {
        this.value = value;
    }

    public static AdNetworkType getAdNetworkType(int adNetworkType) {
        switch (adNetworkType) {
            case 1:
                return Adtiming;
            case 2:
                return AdMob;
            case 3:
                return Facebook;
            case 4:
                return Unity;
            case 5:
                return Vungle;
            case 6:
                return TencentAd;
            case 7:
                return AdColony;
            case 8:
                return AppLovin;
            case 9:
                return Mopub;
            case 10:
                return GoogleAd;
            case 11:
                return Tapjoy;
            case 12:
                return Chartboost;
            case 13:
                return TikTok;
            case 14:
                return Mintegral;
            case 15:
                return IronSource;
            case 16:
                return MyTarget;
            case 17:
                return ChartboostBid;
            case 18:
                return Mint;
            case 30:
                return Fyber;
            default:
                throw new RuntimeException("Not support ad network type:" + adNetworkType);
        }
    }
}
