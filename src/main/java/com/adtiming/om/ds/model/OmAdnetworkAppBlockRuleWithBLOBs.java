// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class OmAdnetworkAppBlockRuleWithBLOBs extends OmAdnetworkAppBlockRule {
    private String makeDeviceBlacklist;

    private String brandModelBlacklist;

    public String getMakeDeviceBlacklist() {
        return makeDeviceBlacklist;
    }

    public void setMakeDeviceBlacklist(String makeDeviceBlacklist) {
        this.makeDeviceBlacklist = makeDeviceBlacklist == null ? null : makeDeviceBlacklist.trim();
    }

    public String getBrandModelBlacklist() {
        return brandModelBlacklist;
    }

    public void setBrandModelBlacklist(String brandModelBlacklist) {
        this.brandModelBlacklist = brandModelBlacklist == null ? null : brandModelBlacklist.trim();
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
        OmAdnetworkAppBlockRuleWithBLOBs other = (OmAdnetworkAppBlockRuleWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getSdkVersion() == null ? other.getSdkVersion() == null : this.getSdkVersion().equals(other.getSdkVersion()))
                && (this.getAppVersion() == null ? other.getAppVersion() == null : this.getAppVersion().equals(other.getAppVersion()))
                && (this.getOsvMax() == null ? other.getOsvMax() == null : this.getOsvMax().equals(other.getOsvMax()))
                && (this.getOsvMin() == null ? other.getOsvMin() == null : this.getOsvMin().equals(other.getOsvMin()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getMakeDeviceBlacklist() == null ? other.getMakeDeviceBlacklist() == null : this.getMakeDeviceBlacklist().equals(other.getMakeDeviceBlacklist()))
                && (this.getBrandModelBlacklist() == null ? other.getBrandModelBlacklist() == null : this.getBrandModelBlacklist().equals(other.getBrandModelBlacklist()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getSdkVersion() == null) ? 0 : getSdkVersion().hashCode());
        result = prime * result + ((getAppVersion() == null) ? 0 : getAppVersion().hashCode());
        result = prime * result + ((getOsvMax() == null) ? 0 : getOsvMax().hashCode());
        result = prime * result + ((getOsvMin() == null) ? 0 : getOsvMin().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getMakeDeviceBlacklist() == null) ? 0 : getMakeDeviceBlacklist().hashCode());
        result = prime * result + ((getBrandModelBlacklist() == null) ? 0 : getBrandModelBlacklist().hashCode());
        return result;
    }
}