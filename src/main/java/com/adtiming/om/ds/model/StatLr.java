// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class StatLr extends StatLrKey {
    private Byte hour;

    private String country;

    private Byte platform;

    private Integer publisherId;

    private Integer pubAppId;

    private Integer placementId;

    private Integer instanceId;

    private Integer sceneId;

    private Integer adnId;

    private Byte abt;

    private Integer waterfallRequest;

    private Integer waterfallFilled;

    private Integer instanceRequest;

    private Integer instanceFilled;

    private Integer videoStart;

    private Integer videoComplete;

    private Integer calledShow;

    private Integer isReadyTrue;

    private Integer isReadyFalse;

    private Integer click;

    private Integer impr;

    private Integer mediationClick;

    private Integer mediationImpr;

    private Date createTime;

    private Integer bidReq;

    private Integer bidResp;

    private BigDecimal bidRespPrice;

    private Integer bidWin;

    private BigDecimal bidWinPrice;

    private Byte bid;

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

    public Integer getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer instanceId) {
        this.instanceId = instanceId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
    }

    public Byte getAbt() {
        return abt;
    }

    public void setAbt(Byte abt) {
        this.abt = abt;
    }

    public Integer getWaterfallRequest() {
        return waterfallRequest;
    }

    public void setWaterfallRequest(Integer waterfallRequest) {
        this.waterfallRequest = waterfallRequest;
    }

    public Integer getWaterfallFilled() {
        return waterfallFilled;
    }

    public void setWaterfallFilled(Integer waterfallFilled) {
        this.waterfallFilled = waterfallFilled;
    }

    public Integer getInstanceRequest() {
        return instanceRequest;
    }

    public void setInstanceRequest(Integer instanceRequest) {
        this.instanceRequest = instanceRequest;
    }

    public Integer getInstanceFilled() {
        return instanceFilled;
    }

    public void setInstanceFilled(Integer instanceFilled) {
        this.instanceFilled = instanceFilled;
    }

    public Integer getVideoStart() {
        return videoStart;
    }

    public void setVideoStart(Integer videoStart) {
        this.videoStart = videoStart;
    }

    public Integer getVideoComplete() {
        return videoComplete;
    }

    public void setVideoComplete(Integer videoComplete) {
        this.videoComplete = videoComplete;
    }

    public Integer getCalledShow() {
        return calledShow;
    }

    public void setCalledShow(Integer calledShow) {
        this.calledShow = calledShow;
    }

    public Integer getIsReadyTrue() {
        return isReadyTrue;
    }

    public void setIsReadyTrue(Integer isReadyTrue) {
        this.isReadyTrue = isReadyTrue;
    }

    public Integer getIsReadyFalse() {
        return isReadyFalse;
    }

    public void setIsReadyFalse(Integer isReadyFalse) {
        this.isReadyFalse = isReadyFalse;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getImpr() {
        return impr;
    }

    public void setImpr(Integer impr) {
        this.impr = impr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBidReq() {
        return bidReq;
    }

    public void setBidReq(Integer bidReq) {
        this.bidReq = bidReq;
    }

    public Integer getBidResp() {
        return bidResp;
    }

    public void setBidResp(Integer bidResp) {
        this.bidResp = bidResp;
    }

    public BigDecimal getBidRespPrice() {
        return bidRespPrice;
    }

    public void setBidRespPrice(BigDecimal bidRespPrice) {
        this.bidRespPrice = bidRespPrice;
    }

    public Integer getBidWin() {
        return bidWin;
    }

    public void setBidWin(Integer bidWin) {
        this.bidWin = bidWin;
    }

    public BigDecimal getBidWinPrice() {
        return bidWinPrice;
    }

    public void setBidWinPrice(BigDecimal bidWinPrice) {
        this.bidWinPrice = bidWinPrice;
    }

    public Byte getBid() {
        return bid;
    }

    public void setBid(Byte bid) {
        this.bid = bid;
    }

    public Integer getMediationClick() {
        return mediationClick;
    }

    public void setMediationClick(Integer mediationClick) {
        this.mediationClick = mediationClick;
    }

    public Integer getMediationImpr() {
        return mediationImpr;
    }

    public void setMediationImpr(Integer mediationImpr) {
        this.mediationImpr = mediationImpr;
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
        StatLr other = (StatLr) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getHour() == null ? other.getHour() == null : this.getHour().equals(other.getHour()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
            && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
            && (this.getInstanceId() == null ? other.getInstanceId() == null : this.getInstanceId().equals(other.getInstanceId()))
            && (this.getSceneId() == null ? other.getSceneId() == null : this.getSceneId().equals(other.getSceneId()))
            && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
            && (this.getAbt() == null ? other.getAbt() == null : this.getAbt().equals(other.getAbt()))
            && (this.getWaterfallRequest() == null ? other.getWaterfallRequest() == null : this.getWaterfallRequest().equals(other.getWaterfallRequest()))
            && (this.getWaterfallFilled() == null ? other.getWaterfallFilled() == null : this.getWaterfallFilled().equals(other.getWaterfallFilled()))
            && (this.getInstanceRequest() == null ? other.getInstanceRequest() == null : this.getInstanceRequest().equals(other.getInstanceRequest()))
            && (this.getInstanceFilled() == null ? other.getInstanceFilled() == null : this.getInstanceFilled().equals(other.getInstanceFilled()))
            && (this.getVideoStart() == null ? other.getVideoStart() == null : this.getVideoStart().equals(other.getVideoStart()))
            && (this.getVideoComplete() == null ? other.getVideoComplete() == null : this.getVideoComplete().equals(other.getVideoComplete()))
            && (this.getCalledShow() == null ? other.getCalledShow() == null : this.getCalledShow().equals(other.getCalledShow()))
            && (this.getIsReadyTrue() == null ? other.getIsReadyTrue() == null : this.getIsReadyTrue().equals(other.getIsReadyTrue()))
            && (this.getIsReadyFalse() == null ? other.getIsReadyFalse() == null : this.getIsReadyFalse().equals(other.getIsReadyFalse()))
            && (this.getClick() == null ? other.getClick() == null : this.getClick().equals(other.getClick()))
            && (this.getImpr() == null ? other.getImpr() == null : this.getImpr().equals(other.getImpr()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getBidReq() == null ? other.getBidReq() == null : this.getBidReq().equals(other.getBidReq()))
            && (this.getBidResp() == null ? other.getBidResp() == null : this.getBidResp().equals(other.getBidResp()))
            && (this.getBidRespPrice() == null ? other.getBidRespPrice() == null : this.getBidRespPrice().equals(other.getBidRespPrice()))
            && (this.getBidWin() == null ? other.getBidWin() == null : this.getBidWin().equals(other.getBidWin()))
            && (this.getBidWinPrice() == null ? other.getBidWinPrice() == null : this.getBidWinPrice().equals(other.getBidWinPrice()))
            && (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()));
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
        result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
        result = prime * result + ((getSceneId() == null) ? 0 : getSceneId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAbt() == null) ? 0 : getAbt().hashCode());
        result = prime * result + ((getWaterfallRequest() == null) ? 0 : getWaterfallRequest().hashCode());
        result = prime * result + ((getWaterfallFilled() == null) ? 0 : getWaterfallFilled().hashCode());
        result = prime * result + ((getInstanceRequest() == null) ? 0 : getInstanceRequest().hashCode());
        result = prime * result + ((getInstanceFilled() == null) ? 0 : getInstanceFilled().hashCode());
        result = prime * result + ((getVideoStart() == null) ? 0 : getVideoStart().hashCode());
        result = prime * result + ((getVideoComplete() == null) ? 0 : getVideoComplete().hashCode());
        result = prime * result + ((getCalledShow() == null) ? 0 : getCalledShow().hashCode());
        result = prime * result + ((getIsReadyTrue() == null) ? 0 : getIsReadyTrue().hashCode());
        result = prime * result + ((getIsReadyFalse() == null) ? 0 : getIsReadyFalse().hashCode());
        result = prime * result + ((getClick() == null) ? 0 : getClick().hashCode());
        result = prime * result + ((getImpr() == null) ? 0 : getImpr().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getBidReq() == null) ? 0 : getBidReq().hashCode());
        result = prime * result + ((getBidResp() == null) ? 0 : getBidResp().hashCode());
        result = prime * result + ((getBidRespPrice() == null) ? 0 : getBidRespPrice().hashCode());
        result = prime * result + ((getBidWin() == null) ? 0 : getBidWin().hashCode());
        result = prime * result + ((getBidWinPrice() == null) ? 0 : getBidWinPrice().hashCode());
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        return result;
    }
}