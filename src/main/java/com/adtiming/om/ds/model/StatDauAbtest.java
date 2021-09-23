// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class StatDauAbtest extends StatDauAbtestKey {
    private Integer publisherId;

    private Integer pubAppId;

    private Byte platform;

    private Byte abt;

    private Integer abtId;

    private String country;

    private Integer ipCount;

    private Integer didCount;

    private Integer dau;

    private Integer deu;

    private String appVersion;

    private String sdkVersion;

    private String osVersion;

    private Date createTime;

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

    public Byte getPlatform() {
        return platform;
    }

    public void setPlatform(Byte platform) {
        this.platform = platform;
    }

    public Byte getAbt() {
        return abt;
    }

    public void setAbt(Byte abt) {
        this.abt = abt;
    }

    public Integer getAbtId() {
        return abtId;
    }

    public void setAbtId(Integer abtId) {
        this.abtId = abtId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Integer getIpCount() {
        return ipCount;
    }

    public void setIpCount(Integer ipCount) {
        this.ipCount = ipCount;
    }

    public Integer getDidCount() {
        return didCount;
    }

    public void setDidCount(Integer didCount) {
        this.didCount = didCount;
    }

    public Integer getDau() {
        return dau;
    }

    public void setDau(Integer dau) {
        this.dau = dau;
    }

    public Integer getDeu() {
        return deu;
    }

    public void setDeu(Integer deu) {
        this.deu = deu;
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
        StatDauAbtest other = (StatDauAbtest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
            && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
            && (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
            && (this.getAbt() == null ? other.getAbt() == null : this.getAbt().equals(other.getAbt()))
            && (this.getAbtId() == null ? other.getAbtId() == null : this.getAbtId().equals(other.getAbtId()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getIpCount() == null ? other.getIpCount() == null : this.getIpCount().equals(other.getIpCount()))
            && (this.getDidCount() == null ? other.getDidCount() == null : this.getDidCount().equals(other.getDidCount()))
            && (this.getDau() == null ? other.getDau() == null : this.getDau().equals(other.getDau()))
            && (this.getDeu() == null ? other.getDeu() == null : this.getDeu().equals(other.getDeu()))
            && (this.getAppVersion() == null ? other.getAppVersion() == null : this.getAppVersion().equals(other.getAppVersion()))
            && (this.getSdkVersion() == null ? other.getSdkVersion() == null : this.getSdkVersion().equals(other.getSdkVersion()))
            && (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getAbt() == null) ? 0 : getAbt().hashCode());
        result = prime * result + ((getAbtId() == null) ? 0 : getAbtId().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getIpCount() == null) ? 0 : getIpCount().hashCode());
        result = prime * result + ((getDidCount() == null) ? 0 : getDidCount().hashCode());
        result = prime * result + ((getDau() == null) ? 0 : getDau().hashCode());
        result = prime * result + ((getDeu() == null) ? 0 : getDeu().hashCode());
        result = prime * result + ((getAppVersion() == null) ? 0 : getAppVersion().hashCode());
        result = prime * result + ((getSdkVersion() == null) ? 0 : getSdkVersion().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}