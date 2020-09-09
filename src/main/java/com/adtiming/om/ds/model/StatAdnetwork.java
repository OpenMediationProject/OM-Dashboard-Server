// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class StatAdnetwork extends StatAdnetworkKey {
    private Byte hour;

    private String country;

    private Byte platform;

    private Integer publisherId;

    private Integer pubAppId;

    private Integer placementId;

    private Byte adType;

    private Integer adnId;

    private Integer instanceId;

    private Byte bid;

    private Byte abt;

    private String currency;

    private BigDecimal exchangeRate;

    private BigDecimal cost;

    private BigDecimal costOri;

    private BigDecimal revenue;

    private BigDecimal revenueOri;

    private Integer apiRequest;

    private Integer apiFilled;

    private Integer apiClick;

    private Integer apiImpr;

    private Integer apiVideoStart;

    private Integer apiVideoComplete;

    private Integer accountId;

    private Byte accountOwner;

    private Byte category;

    private String accountName;

    private String adnAccountKey;

    private Integer reportAccountId;

    private Date createTime;

    private Date lastmodify;

    public Byte getHour() {
        return hour;
    }

    public void setHour(Byte hour) {
        this.hour = hour;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Byte getPlatform() {
        return platform;
    }

    public void setPlatform(Byte platform) {
        this.platform = platform;
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

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public Byte getAdType() {
        return adType;
    }

    public void setAdType(Byte adType) {
        this.adType = adType;
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
    }

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Byte getBid() {
        return bid;
    }

    public void setBid(Byte bid) {
        this.bid = bid;
    }

    public Byte getAbt() {
        return abt;
    }

    public void setAbt(Byte abt) {
        this.abt = abt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCostOri() {
        return costOri;
    }

    public void setCostOri(BigDecimal costOri) {
        this.costOri = costOri;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRevenueOri() {
        return revenueOri;
    }

    public void setRevenueOri(BigDecimal revenueOri) {
        this.revenueOri = revenueOri;
    }

    public Integer getApiRequest() {
        return apiRequest;
    }

    public void setApiRequest(Integer apiRequest) {
        this.apiRequest = apiRequest;
    }

    public Integer getApiFilled() {
        return apiFilled;
    }

    public void setApiFilled(Integer apiFilled) {
        this.apiFilled = apiFilled;
    }

    public Integer getApiClick() {
        return apiClick;
    }

    public void setApiClick(Integer apiClick) {
        this.apiClick = apiClick;
    }

    public Integer getApiImpr() {
        return apiImpr;
    }

    public void setApiImpr(Integer apiImpr) {
        this.apiImpr = apiImpr;
    }

    public Integer getApiVideoStart() {
        return apiVideoStart;
    }

    public void setApiVideoStart(Integer apiVideoStart) {
        this.apiVideoStart = apiVideoStart;
    }

    public Integer getApiVideoComplete() {
        return apiVideoComplete;
    }

    public void setApiVideoComplete(Integer apiVideoComplete) {
        this.apiVideoComplete = apiVideoComplete;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Byte getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Byte accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAdnAccountKey() {
        return adnAccountKey;
    }

    public void setAdnAccountKey(String adnAccountKey) {
        this.adnAccountKey = adnAccountKey == null ? null : adnAccountKey.trim();
    }

    public Integer getReportAccountId() {
        return reportAccountId;
    }

    public void setReportAccountId(Integer reportAccountId) {
        this.reportAccountId = reportAccountId;
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
        StatAdnetwork other = (StatAdnetwork) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getHour() == null ? other.getHour() == null : this.getHour().equals(other.getHour()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
            && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
            && (this.getAdType() == null ? other.getAdType() == null : this.getAdType().equals(other.getAdType()))
            && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()))
            && (this.getAbt() == null ? other.getAbt() == null : this.getAbt().equals(other.getAbt()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getExchangeRate() == null ? other.getExchangeRate() == null : this.getExchangeRate().equals(other.getExchangeRate()))
            && (this.getCost() == null ? other.getCost() == null : this.getCost().equals(other.getCost()))
            && (this.getCostOri() == null ? other.getCostOri() == null : this.getCostOri().equals(other.getCostOri()))
            && (this.getRevenue() == null ? other.getRevenue() == null : this.getRevenue().equals(other.getRevenue()))
            && (this.getRevenueOri() == null ? other.getRevenueOri() == null : this.getRevenueOri().equals(other.getRevenueOri()))
            && (this.getApiRequest() == null ? other.getApiRequest() == null : this.getApiRequest().equals(other.getApiRequest()))
            && (this.getApiFilled() == null ? other.getApiFilled() == null : this.getApiFilled().equals(other.getApiFilled()))
            && (this.getApiClick() == null ? other.getApiClick() == null : this.getApiClick().equals(other.getApiClick()))
            && (this.getApiImpr() == null ? other.getApiImpr() == null : this.getApiImpr().equals(other.getApiImpr()))
            && (this.getApiVideoStart() == null ? other.getApiVideoStart() == null : this.getApiVideoStart().equals(other.getApiVideoStart()))
            && (this.getApiVideoComplete() == null ? other.getApiVideoComplete() == null : this.getApiVideoComplete().equals(other.getApiVideoComplete()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getAccountOwner() == null ? other.getAccountOwner() == null : this.getAccountOwner().equals(other.getAccountOwner()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
            && (this.getAdnAccountKey() == null ? other.getAdnAccountKey() == null : this.getAdnAccountKey().equals(other.getAdnAccountKey()))
            && (this.getReportAccountId() == null ? other.getReportAccountId() == null : this.getReportAccountId().equals(other.getReportAccountId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getHour() == null) ? 0 : getHour().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getAdType() == null) ? 0 : getAdType().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        result = prime * result + ((getAbt() == null) ? 0 : getAbt().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getExchangeRate() == null) ? 0 : getExchangeRate().hashCode());
        result = prime * result + ((getCost() == null) ? 0 : getCost().hashCode());
        result = prime * result + ((getCostOri() == null) ? 0 : getCostOri().hashCode());
        result = prime * result + ((getRevenue() == null) ? 0 : getRevenue().hashCode());
        result = prime * result + ((getRevenueOri() == null) ? 0 : getRevenueOri().hashCode());
        result = prime * result + ((getApiRequest() == null) ? 0 : getApiRequest().hashCode());
        result = prime * result + ((getApiFilled() == null) ? 0 : getApiFilled().hashCode());
        result = prime * result + ((getApiClick() == null) ? 0 : getApiClick().hashCode());
        result = prime * result + ((getApiImpr() == null) ? 0 : getApiImpr().hashCode());
        result = prime * result + ((getApiVideoStart() == null) ? 0 : getApiVideoStart().hashCode());
        result = prime * result + ((getApiVideoComplete() == null) ? 0 : getApiVideoComplete().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAccountOwner() == null) ? 0 : getAccountOwner().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAdnAccountKey() == null) ? 0 : getAdnAccountKey().hashCode());
        result = prime * result + ((getReportAccountId() == null) ? 0 : getReportAccountId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}