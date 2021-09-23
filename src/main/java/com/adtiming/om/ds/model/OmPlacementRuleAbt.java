// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmPlacementRuleAbt {
    private Integer id;

    private Integer ruleId;

    private String name;

    private String testName;

    private Integer status;

    private Integer resultAb;

    private Date endTime;

    private Object ruleConf;

    private Object instanceConf;

    private Object report;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResultAb() {
        return resultAb;
    }

    public void setResultAb(Integer resultAb) {
        this.resultAb = resultAb;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Object getRuleConf() {
        return ruleConf;
    }

    public void setRuleConf(Object ruleConf) {
        this.ruleConf = ruleConf;
    }

    public Object getInstanceConf() {
        return instanceConf;
    }

    public void setInstanceConf(Object instanceConf) {
        this.instanceConf = instanceConf;
    }

    public Object getReport() {
        return report;
    }

    public void setReport(Object report) {
        this.report = report;
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
        OmPlacementRuleAbt other = (OmPlacementRuleAbt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getResultAb() == null ? other.getResultAb() == null : this.getResultAb().equals(other.getResultAb()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getRuleConf() == null ? other.getRuleConf() == null : this.getRuleConf().equals(other.getRuleConf()))
            && (this.getInstanceConf() == null ? other.getInstanceConf() == null : this.getInstanceConf().equals(other.getInstanceConf()))
            && (this.getReport() == null ? other.getReport() == null : this.getReport().equals(other.getReport()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getResultAb() == null) ? 0 : getResultAb().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getRuleConf() == null) ? 0 : getRuleConf().hashCode());
        result = prime * result + ((getInstanceConf() == null) ? 0 : getInstanceConf().hashCode());
        result = prime * result + ((getReport() == null) ? 0 : getReport().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}