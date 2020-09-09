// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class ReportAdnetworkAccountPublisher extends ReportAdnetworkAccountPublisherKey {
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        ReportAdnetworkAccountPublisher other = (ReportAdnetworkAccountPublisher) that;
        return (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getReportAccountId() == null ? other.getReportAccountId() == null : this.getReportAccountId().equals(other.getReportAccountId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getReportAccountId() == null) ? 0 : getReportAccountId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}