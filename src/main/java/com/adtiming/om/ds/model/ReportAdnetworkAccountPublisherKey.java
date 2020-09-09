// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class ReportAdnetworkAccountPublisherKey {
    private Integer publisherId;

    private Integer reportAccountId;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getReportAccountId() {
        return reportAccountId;
    }

    public void setReportAccountId(Integer reportAccountId) {
        this.reportAccountId = reportAccountId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ReportAdnetworkAccountPublisherKey other = (ReportAdnetworkAccountPublisherKey) that;
        return (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getReportAccountId() == null ? other.getReportAccountId() == null : this.getReportAccountId().equals(other.getReportAccountId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getReportAccountId() == null) ? 0 : getReportAccountId().hashCode());
        return result;
    }
}