// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class OmReportBuilderWithBLOBs extends OmReportBuilder {
    private String condPubAppList;

    private String condPlacementList;

    private String condInstanceList;

    public String getCondPubAppList() {
        return condPubAppList;
    }

    public void setCondPubAppList(String condPubAppList) {
        this.condPubAppList = condPubAppList == null ? null : condPubAppList.trim();
    }

    public String getCondPlacementList() {
        return condPlacementList;
    }

    public void setCondPlacementList(String condPlacementList) {
        this.condPlacementList = condPlacementList == null ? null : condPlacementList.trim();
    }

    public String getCondInstanceList() {
        return condInstanceList;
    }

    public void setCondInstanceList(String condInstanceList) {
        this.condInstanceList = condInstanceList == null ? null : condInstanceList.trim();
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
        OmReportBuilderWithBLOBs other = (OmReportBuilderWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getDataSource() == null ? other.getDataSource() == null : this.getDataSource().equals(other.getDataSource()))
                && (this.getRecipients() == null ? other.getRecipients() == null : this.getRecipients().equals(other.getRecipients()))
                && (this.getSchedule() == null ? other.getSchedule() == null : this.getSchedule().equals(other.getSchedule()))
                && (this.getWeeklyDay() == null ? other.getWeeklyDay() == null : this.getWeeklyDay().equals(other.getWeeklyDay()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDimensions() == null ? other.getDimensions() == null : this.getDimensions().equals(other.getDimensions()))
                && (this.getMetrics() == null ? other.getMetrics() == null : this.getMetrics().equals(other.getMetrics()))
                && (this.getCondDayPeriod() == null ? other.getCondDayPeriod() == null : this.getCondDayPeriod().equals(other.getCondDayPeriod()))
                && (this.getCondAdnList() == null ? other.getCondAdnList() == null : this.getCondAdnList().equals(other.getCondAdnList()))
                && (this.getCondCountryList() == null ? other.getCondCountryList() == null : this.getCondCountryList().equals(other.getCondCountryList()))
                && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
                && (this.getExecuteTimes() == null ? other.getExecuteTimes() == null : this.getExecuteTimes().equals(other.getExecuteTimes()))
                && (this.getLastExecuteTime() == null ? other.getLastExecuteTime() == null : this.getLastExecuteTime().equals(other.getLastExecuteTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getCondPubAppList() == null ? other.getCondPubAppList() == null : this.getCondPubAppList().equals(other.getCondPubAppList()))
                && (this.getCondPlacementList() == null ? other.getCondPlacementList() == null : this.getCondPlacementList().equals(other.getCondPlacementList()))
                && (this.getCondInstanceList() == null ? other.getCondInstanceList() == null : this.getCondInstanceList().equals(other.getCondInstanceList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDataSource() == null) ? 0 : getDataSource().hashCode());
        result = prime * result + ((getRecipients() == null) ? 0 : getRecipients().hashCode());
        result = prime * result + ((getSchedule() == null) ? 0 : getSchedule().hashCode());
        result = prime * result + ((getWeeklyDay() == null) ? 0 : getWeeklyDay().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDimensions() == null) ? 0 : getDimensions().hashCode());
        result = prime * result + ((getMetrics() == null) ? 0 : getMetrics().hashCode());
        result = prime * result + ((getCondDayPeriod() == null) ? 0 : getCondDayPeriod().hashCode());
        result = prime * result + ((getCondAdnList() == null) ? 0 : getCondAdnList().hashCode());
        result = prime * result + ((getCondCountryList() == null) ? 0 : getCondCountryList().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getExecuteTimes() == null) ? 0 : getExecuteTimes().hashCode());
        result = prime * result + ((getLastExecuteTime() == null) ? 0 : getLastExecuteTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCondPubAppList() == null) ? 0 : getCondPubAppList().hashCode());
        result = prime * result + ((getCondPlacementList() == null) ? 0 : getCondPlacementList().hashCode());
        result = prime * result + ((getCondInstanceList() == null) ? 0 : getCondInstanceList().hashCode());
        return result;
    }
}