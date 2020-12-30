// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class CpCampaign {
    private Integer id;

    private Byte skaCampaignId;

    private Integer publisherId;

    private Byte type;

    private String name;

    private String appId;

    private String appName;

    private String previewUrl;

    private Byte platform;

    private Byte billingType;

    private BigDecimal price;

    private Integer dailyCap;

    private BigDecimal dailyBudget;

    private BigDecimal maxBidprice;

    private BigDecimal bidprice;

    private Integer imprCap;

    private Integer imprFreq;

    private String adDomain;

    private Byte openType;

    private String clickUrl;

    private String imprUrl;

    private String clickTkUrls;

    private String imprTkUrls;

    private Date startTime;

    private Date endTime;

    private Byte status;

    private Byte runStatus;

    private String lastReason;

    private Date lastmodify;

    private Date createTime;

    private String remark;

    private CpCampaignTargeting[] targetingList;

    private CpCampaignTargeting[] placementTargetingList;

    private CpCampaignBidprice[] bidPriceList;

    private CpCreative[] creativeList;

    private OmAppWithBLOBs promoteApp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getSkaCampaignId() {
        return skaCampaignId;
    }

    public void setSkaCampaignId(Byte skaCampaignId) {
        this.skaCampaignId = skaCampaignId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public Byte getPlatform() {
        return platform;
    }

    public void setPlatform(Byte platform) {
        this.platform = platform;
    }

    public Byte getBillingType() {
        return billingType;
    }

    public void setBillingType(Byte billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDailyCap() {
        return dailyCap;
    }

    public void setDailyCap(Integer dailyCap) {
        this.dailyCap = dailyCap;
    }

    public BigDecimal getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(BigDecimal dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public BigDecimal getMaxBidprice() {
        return maxBidprice;
    }

    public void setMaxBidprice(BigDecimal maxBidprice) {
        this.maxBidprice = maxBidprice;
    }

    public BigDecimal getBidprice() {
        return bidprice;
    }

    public void setBidprice(BigDecimal bidprice) {
        this.bidprice = bidprice;
    }

    public Integer getImprCap() {
        return imprCap;
    }

    public void setImprCap(Integer imprCap) {
        this.imprCap = imprCap;
    }

    public Integer getImprFreq() {
        return imprFreq;
    }

    public void setImprFreq(Integer imprFreq) {
        this.imprFreq = imprFreq;
    }

    public String getAdDomain() {
        return adDomain;
    }

    public void setAdDomain(String adDomain) {
        this.adDomain = adDomain == null ? null : adDomain.trim();
    }

    public Byte getOpenType() {
        return openType;
    }

    public void setOpenType(Byte openType) {
        this.openType = openType;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl == null ? null : clickUrl.trim();
    }

    public String getImprUrl() {
        return imprUrl;
    }

    public void setImprUrl(String imprUrl) {
        this.imprUrl = imprUrl == null ? null : imprUrl.trim();
    }

    public String getClickTkUrls() {
        return clickTkUrls;
    }

    public void setClickTkUrls(String clickTkUrls) {
        this.clickTkUrls = clickTkUrls == null ? null : clickTkUrls.trim();
    }

    public String getImprTkUrls() {
        return imprTkUrls;
    }

    public void setImprTkUrls(String imprTkUrls) {
        this.imprTkUrls = imprTkUrls == null ? null : imprTkUrls.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(Byte runStatus) {
        this.runStatus = runStatus;
    }

    public String getLastReason() {
        return lastReason;
    }

    public void setLastReason(String lastReason) {
        this.lastReason = lastReason == null ? null : lastReason.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public CpCampaignTargeting[] getTargetingList() {
        return targetingList;
    }

    public void setTargetingList(CpCampaignTargeting[] targetingList) {
        this.targetingList = targetingList;
    }

    public CpCampaignTargeting[] getPlacementTargetingList() {
        return placementTargetingList;
    }

    public void setPlacementTargetingList(CpCampaignTargeting[] placementTargetingList) {
        this.placementTargetingList = placementTargetingList;
    }

    public CpCampaignBidprice[] getBidPriceList() {
        return bidPriceList;
    }

    public void setBidPriceList(CpCampaignBidprice[] bidPriceList) {
        this.bidPriceList = bidPriceList;
    }

    public CpCreative[] getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(CpCreative[] creativeList) {
        this.creativeList = creativeList;
    }

    public OmAppWithBLOBs getPromoteApp() {
        return promoteApp;
    }

    public void setPromoteApp(OmAppWithBLOBs promoteApp) {
        this.promoteApp = promoteApp;
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
        CpCampaign other = (CpCampaign) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkaCampaignId() == null ? other.getSkaCampaignId() == null : this.getSkaCampaignId().equals(other.getSkaCampaignId()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getPreviewUrl() == null ? other.getPreviewUrl() == null : this.getPreviewUrl().equals(other.getPreviewUrl()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getBillingType() == null ? other.getBillingType() == null : this.getBillingType().equals(other.getBillingType()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDailyCap() == null ? other.getDailyCap() == null : this.getDailyCap().equals(other.getDailyCap()))
            && (this.getDailyBudget() == null ? other.getDailyBudget() == null : this.getDailyBudget().equals(other.getDailyBudget()))
            && (this.getMaxBidprice() == null ? other.getMaxBidprice() == null : this.getMaxBidprice().equals(other.getMaxBidprice()))
            && (this.getBidprice() == null ? other.getBidprice() == null : this.getBidprice().equals(other.getBidprice()))
            && (this.getImprCap() == null ? other.getImprCap() == null : this.getImprCap().equals(other.getImprCap()))
            && (this.getImprFreq() == null ? other.getImprFreq() == null : this.getImprFreq().equals(other.getImprFreq()))
            && (this.getAdDomain() == null ? other.getAdDomain() == null : this.getAdDomain().equals(other.getAdDomain()))
            && (this.getOpenType() == null ? other.getOpenType() == null : this.getOpenType().equals(other.getOpenType()))
            && (this.getClickUrl() == null ? other.getClickUrl() == null : this.getClickUrl().equals(other.getClickUrl()))
            && (this.getImprUrl() == null ? other.getImprUrl() == null : this.getImprUrl().equals(other.getImprUrl()))
            && (this.getClickTkUrls() == null ? other.getClickTkUrls() == null : this.getClickTkUrls().equals(other.getClickTkUrls()))
            && (this.getImprTkUrls() == null ? other.getImprTkUrls() == null : this.getImprTkUrls().equals(other.getImprTkUrls()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRunStatus() == null ? other.getRunStatus() == null : this.getRunStatus().equals(other.getRunStatus()))
            && (this.getLastReason() == null ? other.getLastReason() == null : this.getLastReason().equals(other.getLastReason()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkaCampaignId() == null) ? 0 : getSkaCampaignId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getPreviewUrl() == null) ? 0 : getPreviewUrl().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getBillingType() == null) ? 0 : getBillingType().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDailyCap() == null) ? 0 : getDailyCap().hashCode());
        result = prime * result + ((getDailyBudget() == null) ? 0 : getDailyBudget().hashCode());
        result = prime * result + ((getMaxBidprice() == null) ? 0 : getMaxBidprice().hashCode());
        result = prime * result + ((getBidprice() == null) ? 0 : getBidprice().hashCode());
        result = prime * result + ((getImprCap() == null) ? 0 : getImprCap().hashCode());
        result = prime * result + ((getImprFreq() == null) ? 0 : getImprFreq().hashCode());
        result = prime * result + ((getAdDomain() == null) ? 0 : getAdDomain().hashCode());
        result = prime * result + ((getOpenType() == null) ? 0 : getOpenType().hashCode());
        result = prime * result + ((getClickUrl() == null) ? 0 : getClickUrl().hashCode());
        result = prime * result + ((getImprUrl() == null) ? 0 : getImprUrl().hashCode());
        result = prime * result + ((getClickTkUrls() == null) ? 0 : getClickTkUrls().hashCode());
        result = prime * result + ((getImprTkUrls() == null) ? 0 : getImprTkUrls().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRunStatus() == null) ? 0 : getRunStatus().hashCode());
        result = prime * result + ((getLastReason() == null) ? 0 : getLastReason().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}