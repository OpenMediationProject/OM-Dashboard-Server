package com.adtiming.om.ds.model;

public class OmPlacementRuleSegmentWithBLOBs extends OmPlacementRuleSegment {
    private String brandWhitelist;

    private String brandBlacklist;

    private String modelWhitelist;

    private String modelBlacklist;

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
        OmPlacementRuleSegmentWithBLOBs other = (OmPlacementRuleSegmentWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
            && (this.getCountries() == null ? other.getCountries() == null : this.getCountries().equals(other.getCountries()))
            && (this.getFrequency() == null ? other.getFrequency() == null : this.getFrequency().equals(other.getFrequency()))
            && (this.getConType() == null ? other.getConType() == null : this.getConType().equals(other.getConType()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getAgeMin() == null ? other.getAgeMin() == null : this.getAgeMin().equals(other.getAgeMin()))
            && (this.getAgeMax() == null ? other.getAgeMax() == null : this.getAgeMax().equals(other.getAgeMax()))
            && (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
            && (this.getIapMin() == null ? other.getIapMin() == null : this.getIapMin().equals(other.getIapMin()))
            && (this.getIapMax() == null ? other.getIapMax() == null : this.getIapMax().equals(other.getIapMax()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getChannelBow() == null ? other.getChannelBow() == null : this.getChannelBow().equals(other.getChannelBow()))
            && (this.getModelType() == null ? other.getModelType() == null : this.getModelType().equals(other.getModelType()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
            && (this.getBrandWhitelist() == null ? other.getBrandWhitelist() == null : this.getBrandWhitelist().equals(other.getBrandWhitelist()))
            && (this.getBrandBlacklist() == null ? other.getBrandBlacklist() == null : this.getBrandBlacklist().equals(other.getBrandBlacklist()))
            && (this.getModelWhitelist() == null ? other.getModelWhitelist() == null : this.getModelWhitelist().equals(other.getModelWhitelist()))
            && (this.getModelBlacklist() == null ? other.getModelBlacklist() == null : this.getModelBlacklist().equals(other.getModelBlacklist()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getCountries() == null) ? 0 : getCountries().hashCode());
        result = prime * result + ((getFrequency() == null) ? 0 : getFrequency().hashCode());
        result = prime * result + ((getConType() == null) ? 0 : getConType().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getAgeMin() == null) ? 0 : getAgeMin().hashCode());
        result = prime * result + ((getAgeMax() == null) ? 0 : getAgeMax().hashCode());
        result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
        result = prime * result + ((getIapMin() == null) ? 0 : getIapMin().hashCode());
        result = prime * result + ((getIapMax() == null) ? 0 : getIapMax().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getChannelBow() == null) ? 0 : getChannelBow().hashCode());
        result = prime * result + ((getModelType() == null) ? 0 : getModelType().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getBrandWhitelist() == null) ? 0 : getBrandWhitelist().hashCode());
        result = prime * result + ((getBrandBlacklist() == null) ? 0 : getBrandBlacklist().hashCode());
        result = prime * result + ((getModelWhitelist() == null) ? 0 : getModelWhitelist().hashCode());
        result = prime * result + ((getModelBlacklist() == null) ? 0 : getModelBlacklist().hashCode());
        return result;
    }
}