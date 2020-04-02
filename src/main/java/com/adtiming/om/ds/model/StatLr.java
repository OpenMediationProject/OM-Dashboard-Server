// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class StatLr extends StatLrKey {
    private Byte hour;

    private String country;

    private Byte platform;

    private Integer publisherId;

    private Integer pubAppId;

    private Integer placementId;

    private Integer instanceId;

    private Integer adnId;

    private Byte abt;

    private Long waterfallRequest;

    private Long waterfallFilled;

    private Long instanceRequest;

    private Long instanceFilled;

    private Long videoStart;

    private Long videoComplete;

    private Long calledShow;

    private Long isReadyTrue;

    private Long isReadyFalse;

    private Long click;

    private Long impr;

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

    public Long getWaterfallRequest() {
        return waterfallRequest;
    }

    public void setWaterfallRequest(Long waterfallRequest) {
        this.waterfallRequest = waterfallRequest;
    }

    public Long getWaterfallFilled() {
        return waterfallFilled;
    }

    public void setWaterfallFilled(Long waterfallFilled) {
        this.waterfallFilled = waterfallFilled;
    }

    public Long getInstanceRequest() {
        return instanceRequest;
    }

    public void setInstanceRequest(Long instanceRequest) {
        this.instanceRequest = instanceRequest;
    }

    public Long getInstanceFilled() {
        return instanceFilled;
    }

    public void setInstanceFilled(Long instanceFilled) {
        this.instanceFilled = instanceFilled;
    }

    public Long getVideoStart() {
        return videoStart;
    }

    public void setVideoStart(Long videoStart) {
        this.videoStart = videoStart;
    }

    public Long getVideoComplete() {
        return videoComplete;
    }

    public void setVideoComplete(Long videoComplete) {
        this.videoComplete = videoComplete;
    }

    public Long getCalledShow() {
        return calledShow;
    }

    public void setCalledShow(Long calledShow) {
        this.calledShow = calledShow;
    }

    public Long getIsReadyTrue() {
        return isReadyTrue;
    }

    public void setIsReadyTrue(Long isReadyTrue) {
        this.isReadyTrue = isReadyTrue;
    }

    public Long getIsReadyFalse() {
        return isReadyFalse;
    }

    public void setIsReadyFalse(Long isReadyFalse) {
        this.isReadyFalse = isReadyFalse;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public Long getImpr() {
        return impr;
    }

    public void setImpr(Long impr) {
        this.impr = impr;
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
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
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
        return result;
    }
}