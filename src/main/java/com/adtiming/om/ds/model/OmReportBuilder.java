// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmReportBuilder {
    private Integer id;

    private Integer publisherId;

    private String name;

    private Byte dataSource;

    private String recipients;

    private Integer schedule;

    private Byte weeklyDay;

    private Integer status;

    private String dimensions;

    private String metrics;

    private Byte condDayPeriod;

    private String condAdnList;

    private String condCountryList;

    private Integer creatorId;

    private Integer executeTimes;

    private Date lastExecuteTime;

    private Date lastmodify;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients == null ? null : recipients.trim();
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Byte getWeeklyDay() {
        return weeklyDay;
    }

    public void setWeeklyDay(Byte weeklyDay) {
        this.weeklyDay = weeklyDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions == null ? null : dimensions.trim();
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics == null ? null : metrics.trim();
    }

    public Byte getCondDayPeriod() {
        return condDayPeriod;
    }

    public void setCondDayPeriod(Byte condDayPeriod) {
        this.condDayPeriod = condDayPeriod;
    }

    public String getCondAdnList() {
        return condAdnList;
    }

    public void setCondAdnList(String condAdnList) {
        this.condAdnList = condAdnList == null ? null : condAdnList.trim();
    }

    public String getCondCountryList() {
        return condCountryList;
    }

    public void setCondCountryList(String condCountryList) {
        this.condCountryList = condCountryList == null ? null : condCountryList.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(Integer executeTimes) {
        this.executeTimes = executeTimes;
    }

    public Date getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Date lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public Date getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Date lastmodify) {
        this.lastmodify = lastmodify;
    }

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
        OmReportBuilder other = (OmReportBuilder) that;
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
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
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
        return result;
    }
}