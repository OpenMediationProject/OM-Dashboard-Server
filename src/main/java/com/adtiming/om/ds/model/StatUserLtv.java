// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class StatUserLtv {
    private Integer id;

    private Date day;

    private Date baseDate;

    private Integer retentionDay;

    private String country;

    private Integer publisherId;

    private Integer pubAppId;

    private Long userCntNew;

    private Long userCntOld;

    private Long retentionCntNew;

    private Long retentionCntOld;

    private BigDecimal mediationValueNew;

    private BigDecimal mediationValueOld;

    private BigDecimal iapValueNew;

    private BigDecimal iapValueOld;

    private BigDecimal totalValueNew;

    private BigDecimal totalValueOld;

    private Date createTime;

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

    public Date getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(Date baseDate) {
        this.baseDate = baseDate;
    }

    public Integer getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(Integer retentionDay) {
        this.retentionDay = retentionDay;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getPubAppId() {
        return pubAppId;
    }

    public void setPubAppId(Integer pubAppId) {
        this.pubAppId = pubAppId;
    }

    public Long getUserCntNew() {
        return userCntNew;
    }

    public void setUserCntNew(Long userCntNew) {
        this.userCntNew = userCntNew;
    }

    public Long getUserCntOld() {
        return userCntOld;
    }

    public void setUserCntOld(Long userCntOld) {
        this.userCntOld = userCntOld;
    }

    public Long getRetentionCntNew() {
        return retentionCntNew;
    }

    public void setRetentionCntNew(Long retentionCntNew) {
        this.retentionCntNew = retentionCntNew;
    }

    public Long getRetentionCntOld() {
        return retentionCntOld;
    }

    public void setRetentionCntOld(Long retentionCntOld) {
        this.retentionCntOld = retentionCntOld;
    }

    public BigDecimal getMediationValueNew() {
        return mediationValueNew;
    }

    public void setMediationValueNew(BigDecimal mediationValueNew) {
        this.mediationValueNew = mediationValueNew;
    }

    public BigDecimal getMediationValueOld() {
        return mediationValueOld;
    }

    public void setMediationValueOld(BigDecimal mediationValueOld) {
        this.mediationValueOld = mediationValueOld;
    }

    public BigDecimal getIapValueNew() {
        return iapValueNew;
    }

    public void setIapValueNew(BigDecimal iapValueNew) {
        this.iapValueNew = iapValueNew;
    }

    public BigDecimal getIapValueOld() {
        return iapValueOld;
    }

    public void setIapValueOld(BigDecimal iapValueOld) {
        this.iapValueOld = iapValueOld;
    }

    public BigDecimal getTotalValueNew() {
        return totalValueNew;
    }

    public void setTotalValueNew(BigDecimal totalValueNew) {
        this.totalValueNew = totalValueNew;
    }

    public BigDecimal getTotalValueOld() {
        return totalValueOld;
    }

    public void setTotalValueOld(BigDecimal totalValueOld) {
        this.totalValueOld = totalValueOld;
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
        StatUserLtv other = (StatUserLtv) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getBaseDate() == null ? other.getBaseDate() == null : this.getBaseDate().equals(other.getBaseDate()))
            && (this.getRetentionDay() == null ? other.getRetentionDay() == null : this.getRetentionDay().equals(other.getRetentionDay()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
            && (this.getUserCntNew() == null ? other.getUserCntNew() == null : this.getUserCntNew().equals(other.getUserCntNew()))
            && (this.getUserCntOld() == null ? other.getUserCntOld() == null : this.getUserCntOld().equals(other.getUserCntOld()))
            && (this.getRetentionCntNew() == null ? other.getRetentionCntNew() == null : this.getRetentionCntNew().equals(other.getRetentionCntNew()))
            && (this.getRetentionCntOld() == null ? other.getRetentionCntOld() == null : this.getRetentionCntOld().equals(other.getRetentionCntOld()))
            && (this.getMediationValueNew() == null ? other.getMediationValueNew() == null : this.getMediationValueNew().equals(other.getMediationValueNew()))
            && (this.getMediationValueOld() == null ? other.getMediationValueOld() == null : this.getMediationValueOld().equals(other.getMediationValueOld()))
            && (this.getIapValueNew() == null ? other.getIapValueNew() == null : this.getIapValueNew().equals(other.getIapValueNew()))
            && (this.getIapValueOld() == null ? other.getIapValueOld() == null : this.getIapValueOld().equals(other.getIapValueOld()))
            && (this.getTotalValueNew() == null ? other.getTotalValueNew() == null : this.getTotalValueNew().equals(other.getTotalValueNew()))
            && (this.getTotalValueOld() == null ? other.getTotalValueOld() == null : this.getTotalValueOld().equals(other.getTotalValueOld()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getBaseDate() == null) ? 0 : getBaseDate().hashCode());
        result = prime * result + ((getRetentionDay() == null) ? 0 : getRetentionDay().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getUserCntNew() == null) ? 0 : getUserCntNew().hashCode());
        result = prime * result + ((getUserCntOld() == null) ? 0 : getUserCntOld().hashCode());
        result = prime * result + ((getRetentionCntNew() == null) ? 0 : getRetentionCntNew().hashCode());
        result = prime * result + ((getRetentionCntOld() == null) ? 0 : getRetentionCntOld().hashCode());
        result = prime * result + ((getMediationValueNew() == null) ? 0 : getMediationValueNew().hashCode());
        result = prime * result + ((getMediationValueOld() == null) ? 0 : getMediationValueOld().hashCode());
        result = prime * result + ((getIapValueNew() == null) ? 0 : getIapValueNew().hashCode());
        result = prime * result + ((getIapValueOld() == null) ? 0 : getIapValueOld().hashCode());
        result = prime * result + ((getTotalValueNew() == null) ? 0 : getTotalValueNew().hashCode());
        result = prime * result + ((getTotalValueOld() == null) ? 0 : getTotalValueOld().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}