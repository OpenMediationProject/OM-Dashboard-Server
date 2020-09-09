// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class OmPlacement {
    private Integer id;

    private Integer publisherId;

    private Integer pubAppId;

    private Byte mainPlacement;

    private String name;

    private Byte adType;

    private String descn;

    private Byte status;

    private Byte preloadTimeout;

    private Byte abTestStatus;

    private String previewUrl;

    private String icUrl;

    private BigDecimal floorPrice;

    private Byte floorPriceSwitch;

    private Byte hbStatus;

    private Byte fanOut;

    private Byte batchSize;

    private Byte inventoryCount;

    private Integer inventoryInterval;

    private Integer reloadInterval;

    private Integer frequencyCap;

    private Integer frequencyUnit;

    private Integer frequencyInterval;

    private Date createTime;

    private Date lastmodify;

    private String osvMax;

    private String osvMin;

    private OmPlacementScene[] scenes;

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

    public Integer getPubAppId() {
        return pubAppId;
    }

    public void setPubAppId(Integer pubAppId) {
        this.pubAppId = pubAppId;
    }

    public Byte getMainPlacement() {
        return mainPlacement;
    }

    public void setMainPlacement(Byte mainPlacement) {
        this.mainPlacement = mainPlacement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getAdType() {
        return adType;
    }

    public void setAdType(Byte adType) {
        this.adType = adType;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getPreloadTimeout() {
        return preloadTimeout;
    }

    public void setPreloadTimeout(Byte preloadTimeout) {
        this.preloadTimeout = preloadTimeout;
    }

    public Byte getAbTestStatus() {
        return abTestStatus;
    }

    public void setAbTestStatus(Byte abTestStatus) {
        this.abTestStatus = abTestStatus;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public String getIcUrl() {
        return icUrl;
    }

    public void setIcUrl(String icUrl) {
        this.icUrl = icUrl == null ? null : icUrl.trim();
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Byte getFloorPriceSwitch() {
        return floorPriceSwitch;
    }

    public void setFloorPriceSwitch(Byte floorPriceSwitch) {
        this.floorPriceSwitch = floorPriceSwitch;
    }

    public Byte getHbStatus() {
        return hbStatus;
    }

    public void setHbStatus(Byte hbStatus) {
        this.hbStatus = hbStatus;
    }

    public Byte getFanOut() {
        return fanOut;
    }

    public void setFanOut(Byte fanOut) {
        this.fanOut = fanOut;
    }

    public Byte getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Byte batchSize) {
        this.batchSize = batchSize;
    }

    public Byte getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Byte inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Integer getInventoryInterval() {
        return inventoryInterval;
    }

    public void setInventoryInterval(Integer inventoryInterval) {
        this.inventoryInterval = inventoryInterval;
    }

    public Integer getReloadInterval() {
        return reloadInterval;
    }

    public void setReloadInterval(Integer reloadInterval) {
        this.reloadInterval = reloadInterval;
    }

    public Integer getFrequencyCap() {
        return frequencyCap;
    }

    public void setFrequencyCap(Integer frequencyCap) {
        this.frequencyCap = frequencyCap;
    }

    public Integer getFrequencyUnit() {
        return frequencyUnit;
    }

    public void setFrequencyUnit(Integer frequencyUnit) {
        this.frequencyUnit = frequencyUnit;
    }

    public Integer getFrequencyInterval() {
        return frequencyInterval;
    }

    public void setFrequencyInterval(Integer frequencyInterval) {
        this.frequencyInterval = frequencyInterval;
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

    public String getOsvMax() {
        return osvMax;
    }

    public void setOsvMax(String osvMax) {
        this.osvMax = osvMax == null ? null : osvMax.trim();
    }

    public String getOsvMin() {
        return osvMin;
    }

    public void setOsvMin(String osvMin) {
        this.osvMin = osvMin == null ? null : osvMin.trim();
    }

    public OmPlacementScene[] getScenes() {
        return scenes;
    }

    public void setScenes(OmPlacementScene[] scenes) {
        this.scenes = scenes;
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
        OmPlacement other = (OmPlacement) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
                && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
                && (this.getMainPlacement() == null ? other.getMainPlacement() == null : this.getMainPlacement().equals(other.getMainPlacement()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAdType() == null ? other.getAdType() == null : this.getAdType().equals(other.getAdType()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getPreloadTimeout() == null ? other.getPreloadTimeout() == null : this.getPreloadTimeout().equals(other.getPreloadTimeout()))
                && (this.getAbTestStatus() == null ? other.getAbTestStatus() == null : this.getAbTestStatus().equals(other.getAbTestStatus()))
                && (this.getPreviewUrl() == null ? other.getPreviewUrl() == null : this.getPreviewUrl().equals(other.getPreviewUrl()))
                && (this.getIcUrl() == null ? other.getIcUrl() == null : this.getIcUrl().equals(other.getIcUrl()))
                && (this.getFloorPrice() == null ? other.getFloorPrice() == null : this.getFloorPrice().equals(other.getFloorPrice()))
                && (this.getFloorPriceSwitch() == null ? other.getFloorPriceSwitch() == null : this.getFloorPriceSwitch().equals(other.getFloorPriceSwitch()))
                && (this.getHbStatus() == null ? other.getHbStatus() == null : this.getHbStatus().equals(other.getHbStatus()))
                && (this.getFanOut() == null ? other.getFanOut() == null : this.getFanOut().equals(other.getFanOut()))
                && (this.getBatchSize() == null ? other.getBatchSize() == null : this.getBatchSize().equals(other.getBatchSize()))
                && (this.getInventoryCount() == null ? other.getInventoryCount() == null : this.getInventoryCount().equals(other.getInventoryCount()))
                && (this.getInventoryInterval() == null ? other.getInventoryInterval() == null : this.getInventoryInterval().equals(other.getInventoryInterval()))
                && (this.getReloadInterval() == null ? other.getReloadInterval() == null : this.getReloadInterval().equals(other.getReloadInterval()))
                && (this.getFrequencyCap() == null ? other.getFrequencyCap() == null : this.getFrequencyCap().equals(other.getFrequencyCap()))
                && (this.getFrequencyUnit() == null ? other.getFrequencyUnit() == null : this.getFrequencyUnit().equals(other.getFrequencyUnit()))
                && (this.getFrequencyInterval() == null ? other.getFrequencyInterval() == null : this.getFrequencyInterval().equals(other.getFrequencyInterval()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getOsvMax() == null ? other.getOsvMax() == null : this.getOsvMax().equals(other.getOsvMax()))
                && (this.getOsvMin() == null ? other.getOsvMin() == null : this.getOsvMin().equals(other.getOsvMin()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getMainPlacement() == null) ? 0 : getMainPlacement().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAdType() == null) ? 0 : getAdType().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPreloadTimeout() == null) ? 0 : getPreloadTimeout().hashCode());
        result = prime * result + ((getAbTestStatus() == null) ? 0 : getAbTestStatus().hashCode());
        result = prime * result + ((getPreviewUrl() == null) ? 0 : getPreviewUrl().hashCode());
        result = prime * result + ((getIcUrl() == null) ? 0 : getIcUrl().hashCode());
        result = prime * result + ((getFloorPrice() == null) ? 0 : getFloorPrice().hashCode());
        result = prime * result + ((getFloorPriceSwitch() == null) ? 0 : getFloorPriceSwitch().hashCode());
        result = prime * result + ((getHbStatus() == null) ? 0 : getHbStatus().hashCode());
        result = prime * result + ((getFanOut() == null) ? 0 : getFanOut().hashCode());
        result = prime * result + ((getBatchSize() == null) ? 0 : getBatchSize().hashCode());
        result = prime * result + ((getInventoryCount() == null) ? 0 : getInventoryCount().hashCode());
        result = prime * result + ((getInventoryInterval() == null) ? 0 : getInventoryInterval().hashCode());
        result = prime * result + ((getReloadInterval() == null) ? 0 : getReloadInterval().hashCode());
        result = prime * result + ((getFrequencyCap() == null) ? 0 : getFrequencyCap().hashCode());
        result = prime * result + ((getFrequencyUnit() == null) ? 0 : getFrequencyUnit().hashCode());
        result = prime * result + ((getFrequencyInterval() == null) ? 0 : getFrequencyInterval().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getOsvMax() == null) ? 0 : getOsvMax().hashCode());
        result = prime * result + ((getOsvMin() == null) ? 0 : getOsvMin().hashCode());
        return result;
    }
}