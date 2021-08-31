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

    private Integer bidReq;

    private Integer bidResp;

    private BigDecimal bidRespPrice;

    private Integer bidWin;

    private BigDecimal bidWinPrice;

    private Byte bid;

    private String appVersion;

    private String sdkVersion;

    private String osVersion;

    private Integer ruleId;

    private Integer mediationImpr;

    private Integer mediationClick;

    private Date createTime;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion == null ? null : sdkVersion.trim();
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion == null ? null : osVersion.trim();
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getMediationImpr() {
        return mediationImpr;
    }

    public void setMediationImpr(Integer mediationImpr) {
        this.mediationImpr = mediationImpr;
    }

    public Integer getMediationClick() {
        return mediationClick;
    }

    public void setMediationClick(Integer mediationClick) {
        this.mediationClick = mediationClick;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}