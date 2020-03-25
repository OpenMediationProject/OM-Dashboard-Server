// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-26.
 */
public enum DevAppTestResult {
    Fail, Success, UnKnow;

    public static DevAppTestResult getDevAppTestResult(Integer devAppTestResult) {
        switch (devAppTestResult) {
            case 0:
                return Fail;
            case 1:
                return Success;
            default:
                return UnKnow;
        }
    }
}
