package com.adtiming.om.ds.dto;

public enum ABTest {
    NONE,
    A,
    B;

    public static ABTest getAB(Integer abTest) {
        if (abTest == null) {
            return NONE;
        }
        switch (abTest) {
            case 1:
                return A;
            case 2:
                return B;
            default:
                return NONE;
        }
    }
}
