// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-13.
 */
public enum ReportApiStatus {
    NotSet, Running, Delayed, OFF;

    public static ReportApiStatus getReportApiStatus(Byte reportApiStatus) {
        if (reportApiStatus == null) {
            return OFF;
        }
        switch (reportApiStatus) {
            case 1:
                return Running;
            case 2:
                return Delayed;
            default:
                return OFF;
        }
    }
}
