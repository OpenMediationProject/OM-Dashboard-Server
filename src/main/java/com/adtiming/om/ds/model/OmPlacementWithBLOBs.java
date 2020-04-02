// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class OmPlacementWithBLOBs extends OmPlacement {
    private String osvWhitelist;

    private String osvBlacklist;

    private String makeWhitelist;

    private String makeBlacklist;

    private String brandWhitelist;

    private String brandBlacklist;

    private String modelWhitelist;

    private String modelBlacklist;

    private String didBlacklist;

    private String sdkvBlacklist;

    public String getOsvWhitelist() {
        return osvWhitelist;
    }

    public void setOsvWhitelist(String osvWhitelist) {
        this.osvWhitelist = osvWhitelist == null ? null : osvWhitelist.trim();
    }

    public String getOsvBlacklist() {
        return osvBlacklist;
    }

    public void setOsvBlacklist(String osvBlacklist) {
        this.osvBlacklist = osvBlacklist == null ? null : osvBlacklist.trim();
    }

    public String getMakeWhitelist() {
        return makeWhitelist;
    }

    public void setMakeWhitelist(String makeWhitelist) {
        this.makeWhitelist = makeWhitelist == null ? null : makeWhitelist.trim();
    }

    public String getMakeBlacklist() {
        return makeBlacklist;
    }

    public void setMakeBlacklist(String makeBlacklist) {
        this.makeBlacklist = makeBlacklist == null ? null : makeBlacklist.trim();
    }

    public String getBrandWhitelist() {
        return brandWhitelist;
    }

    public void setBrandWhitelist(String brandWhitelist) {
        this.brandWhitelist = brandWhitelist == null ? null : brandWhitelist.trim();
    }

    public String getBrandBlacklist() {
        return brandBlacklist;
    }

    public void setBrandBlacklist(String brandBlacklist) {
        this.brandBlacklist = brandBlacklist == null ? null : brandBlacklist.trim();
    }

    public String getModelWhitelist() {
        return modelWhitelist;
    }

    public void setModelWhitelist(String modelWhitelist) {
        this.modelWhitelist = modelWhitelist == null ? null : modelWhitelist.trim();
    }

    public String getModelBlacklist() {
        return modelBlacklist;
    }

    public void setModelBlacklist(String modelBlacklist) {
        this.modelBlacklist = modelBlacklist == null ? null : modelBlacklist.trim();
    }

    public String getDidBlacklist() {
        return didBlacklist;
    }

    public void setDidBlacklist(String didBlacklist) {
        this.didBlacklist = didBlacklist == null ? null : didBlacklist.trim();
    }

    public String getSdkvBlacklist() {
        return sdkvBlacklist;
    }

    public void setSdkvBlacklist(String sdkvBlacklist) {
        this.sdkvBlacklist = sdkvBlacklist == null ? null : sdkvBlacklist.trim();
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
        OmPlacementWithBLOBs other = (OmPlacementWithBLOBs) that;
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
                && (this.getOsvMin() == null ? other.getOsvMin() == null : this.getOsvMin().equals(other.getOsvMin()))
                && (this.getOsvWhitelist() == null ? other.getOsvWhitelist() == null : this.getOsvWhitelist().equals(other.getOsvWhitelist()))
                && (this.getOsvBlacklist() == null ? other.getOsvBlacklist() == null : this.getOsvBlacklist().equals(other.getOsvBlacklist()))
                && (this.getMakeWhitelist() == null ? other.getMakeWhitelist() == null : this.getMakeWhitelist().equals(other.getMakeWhitelist()))
                && (this.getMakeBlacklist() == null ? other.getMakeBlacklist() == null : this.getMakeBlacklist().equals(other.getMakeBlacklist()))
                && (this.getBrandWhitelist() == null ? other.getBrandWhitelist() == null : this.getBrandWhitelist().equals(other.getBrandWhitelist()))
                && (this.getBrandBlacklist() == null ? other.getBrandBlacklist() == null : this.getBrandBlacklist().equals(other.getBrandBlacklist()))
                && (this.getModelWhitelist() == null ? other.getModelWhitelist() == null : this.getModelWhitelist().equals(other.getModelWhitelist()))
                && (this.getModelBlacklist() == null ? other.getModelBlacklist() == null : this.getModelBlacklist().equals(other.getModelBlacklist()))
                && (this.getDidBlacklist() == null ? other.getDidBlacklist() == null : this.getDidBlacklist().equals(other.getDidBlacklist()))
                && (this.getSdkvBlacklist() == null ? other.getSdkvBlacklist() == null : this.getSdkvBlacklist().equals(other.getSdkvBlacklist()));
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
        result = prime * result + ((getOsvWhitelist() == null) ? 0 : getOsvWhitelist().hashCode());
        result = prime * result + ((getOsvBlacklist() == null) ? 0 : getOsvBlacklist().hashCode());
        result = prime * result + ((getMakeWhitelist() == null) ? 0 : getMakeWhitelist().hashCode());
        result = prime * result + ((getMakeBlacklist() == null) ? 0 : getMakeBlacklist().hashCode());
        result = prime * result + ((getBrandWhitelist() == null) ? 0 : getBrandWhitelist().hashCode());
        result = prime * result + ((getBrandBlacklist() == null) ? 0 : getBrandBlacklist().hashCode());
        result = prime * result + ((getModelWhitelist() == null) ? 0 : getModelWhitelist().hashCode());
        result = prime * result + ((getModelBlacklist() == null) ? 0 : getModelBlacklist().hashCode());
        result = prime * result + ((getDidBlacklist() == null) ? 0 : getDidBlacklist().hashCode());
        result = prime * result + ((getSdkvBlacklist() == null) ? 0 : getSdkvBlacklist().hashCode());
        return result;
    }
}