package com.adtiming.om.ds.model;

import java.util.Date;

public class OmReportBuilderTask {
    private Integer id;

    private Date day;

    private Integer builderId;

    private Byte status;

    private Integer reparationCount;

    private Integer reportLineSize;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getBuilderId() {
        return builderId;
    }

    public void setBuilderId(Integer builderId) {
        this.builderId = builderId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getReparationCount() {
        return reparationCount;
    }

    public void setReparationCount(Integer reparationCount) {
        this.reparationCount = reparationCount;
    }

    public Integer getReportLineSize() {
        return reportLineSize;
    }

    public void setReportLineSize(Integer reportLineSize) {
        this.reportLineSize = reportLineSize;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Date lastmodify) {
        this.lastmodify = lastmodify;
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
        OmReportBuilderTask other = (OmReportBuilderTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getBuilderId() == null ? other.getBuilderId() == null : this.getBuilderId().equals(other.getBuilderId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReparationCount() == null ? other.getReparationCount() == null : this.getReparationCount().equals(other.getReparationCount()))
            && (this.getReportLineSize() == null ? other.getReportLineSize() == null : this.getReportLineSize().equals(other.getReportLineSize()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getBuilderId() == null) ? 0 : getBuilderId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReparationCount() == null) ? 0 : getReparationCount().hashCode());
        result = prime * result + ((getReportLineSize() == null) ? 0 : getReportLineSize().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}