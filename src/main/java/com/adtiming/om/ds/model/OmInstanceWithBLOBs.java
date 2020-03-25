// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class OmInstanceWithBLOBs extends OmInstance {
    private String makeWhitelist;

    private String makeBlacklist;

    private String brandWhitelist;

    private String brandBlacklist;

    private String modelWhitelist;

    private String modelBlacklist;

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
        OmInstanceWithBLOBs other = (OmInstanceWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOldId() == null ? other.getOldId() == null : this.getOldId().equals(other.getOldId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getAdnAppId() == null ? other.getAdnAppId() == null : this.getAdnAppId().equals(other.getAdnAppId()))
                && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
                && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
                && (this.getPlacementKey() == null ? other.getPlacementKey() == null : this.getPlacementKey().equals(other.getPlacementKey()))
                && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getOsvMax() == null ? other.getOsvMax() == null : this.getOsvMax().equals(other.getOsvMax()))
                && (this.getOsvMin() == null ? other.getOsvMin() == null : this.getOsvMin().equals(other.getOsvMin()))
                && (this.getFrequencyCap() == null ? other.getFrequencyCap() == null : this.getFrequencyCap().equals(other.getFrequencyCap()))
                && (this.getFrequencyUnit() == null ? other.getFrequencyUnit() == null : this.getFrequencyUnit().equals(other.getFrequencyUnit()))
                && (this.getFrequencyInterval() == null ? other.getFrequencyInterval() == null : this.getFrequencyInterval().equals(other.getFrequencyInterval()))
                && (this.getAbTestMode() == null ? other.getAbTestMode() == null : this.getAbTestMode().equals(other.getAbTestMode()))
                && (this.getMediationAudienceSegment() == null ? other.getMediationAudienceSegment() == null : this.getMediationAudienceSegment().equals(other.getMediationAudienceSegment()))
                && (this.getMediationAudienceSegmentDay() == null ? other.getMediationAudienceSegmentDay() == null : this.getMediationAudienceSegmentDay().equals(other.getMediationAudienceSegmentDay()))
                && (this.getAudienceSegment() == null ? other.getAudienceSegment() == null : this.getAudienceSegment().equals(other.getAudienceSegment()))
                && (this.getAudienceSegmentExpected() == null ? other.getAudienceSegmentExpected() == null : this.getAudienceSegmentExpected().equals(other.getAudienceSegmentExpected()))
                && (this.getHbStatus() == null ? other.getHbStatus() == null : this.getHbStatus().equals(other.getHbStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getMakeWhitelist() == null ? other.getMakeWhitelist() == null : this.getMakeWhitelist().equals(other.getMakeWhitelist()))
                && (this.getMakeBlacklist() == null ? other.getMakeBlacklist() == null : this.getMakeBlacklist().equals(other.getMakeBlacklist()))
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
        result = prime * result + ((getOldId() == null) ? 0 : getOldId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAdnAppId() == null) ? 0 : getAdnAppId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getPlacementKey() == null) ? 0 : getPlacementKey().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOsvMax() == null) ? 0 : getOsvMax().hashCode());
        result = prime * result + ((getOsvMin() == null) ? 0 : getOsvMin().hashCode());
        result = prime * result + ((getFrequencyCap() == null) ? 0 : getFrequencyCap().hashCode());
        result = prime * result + ((getFrequencyUnit() == null) ? 0 : getFrequencyUnit().hashCode());
        result = prime * result + ((getFrequencyInterval() == null) ? 0 : getFrequencyInterval().hashCode());
        result = prime * result + ((getAbTestMode() == null) ? 0 : getAbTestMode().hashCode());
        result = prime * result + ((getMediationAudienceSegment() == null) ? 0 : getMediationAudienceSegment().hashCode());
        result = prime * result + ((getMediationAudienceSegmentDay() == null) ? 0 : getMediationAudienceSegmentDay().hashCode());
        result = prime * result + ((getAudienceSegment() == null) ? 0 : getAudienceSegment().hashCode());
        result = prime * result + ((getAudienceSegmentExpected() == null) ? 0 : getAudienceSegmentExpected().hashCode());
        result = prime * result + ((getHbStatus() == null) ? 0 : getHbStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getMakeWhitelist() == null) ? 0 : getMakeWhitelist().hashCode());
        result = prime * result + ((getMakeBlacklist() == null) ? 0 : getMakeBlacklist().hashCode());
        result = prime * result + ((getBrandWhitelist() == null) ? 0 : getBrandWhitelist().hashCode());
        result = prime * result + ((getBrandBlacklist() == null) ? 0 : getBrandBlacklist().hashCode());
        result = prime * result + ((getModelWhitelist() == null) ? 0 : getModelWhitelist().hashCode());
        result = prime * result + ((getModelBlacklist() == null) ? 0 : getModelBlacklist().hashCode());
        return result;
    }
}