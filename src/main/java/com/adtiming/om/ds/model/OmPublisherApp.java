// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmPublisherApp {
    private Integer id;

    private Integer publisherId;

    private Byte plat;

    private String appId;

    private String appName;

    private String appKey;

    private Byte status;

    private Byte debugStatus;

    private String sdkEventIds;

    private Byte coppa;

    private String bundleId;

    private String icon;

    private String descn;

    private String category;

    private Integer categoryId;

    private Integer subCategoryId;

    private String previewUrl;

    private String developer;

    private String osRequire;

    private String country;

    private String availableCountries;

    private Date createTime;

    private Date lastmodify;

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

    public Byte getPlat() {
        return plat;
    }

    public void setPlat(Byte plat) {
        this.plat = plat;
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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDebugStatus() {
        return debugStatus;
    }

    public void setDebugStatus(Byte debugStatus) {
        this.debugStatus = debugStatus;
    }

    public String getSdkEventIds() {
        return sdkEventIds;
    }

    public void setSdkEventIds(String sdkEventIds) {
        this.sdkEventIds = sdkEventIds == null ? null : sdkEventIds.trim();
    }

    public Byte getCoppa() {
        return coppa;
    }

    public void setCoppa(Byte coppa) {
        this.coppa = coppa;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId == null ? null : bundleId.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getOsRequire() {
        return osRequire;
    }

    public void setOsRequire(String osRequire) {
        this.osRequire = osRequire == null ? null : osRequire.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getAvailableCountries() {
        return availableCountries;
    }

    public void setAvailableCountries(String availableCountries) {
        this.availableCountries = availableCountries == null ? null : availableCountries.trim();
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
        OmPublisherApp other = (OmPublisherApp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
                && (this.getPlat() == null ? other.getPlat() == null : this.getPlat().equals(other.getPlat()))
                && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
                && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
                && (this.getAppKey() == null ? other.getAppKey() == null : this.getAppKey().equals(other.getAppKey()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDebugStatus() == null ? other.getDebugStatus() == null : this.getDebugStatus().equals(other.getDebugStatus()))
                && (this.getSdkEventIds() == null ? other.getSdkEventIds() == null : this.getSdkEventIds().equals(other.getSdkEventIds()))
                && (this.getCoppa() == null ? other.getCoppa() == null : this.getCoppa().equals(other.getCoppa()))
                && (this.getBundleId() == null ? other.getBundleId() == null : this.getBundleId().equals(other.getBundleId()))
                && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
                && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
                && (this.getSubCategoryId() == null ? other.getSubCategoryId() == null : this.getSubCategoryId().equals(other.getSubCategoryId()))
                && (this.getPreviewUrl() == null ? other.getPreviewUrl() == null : this.getPreviewUrl().equals(other.getPreviewUrl()))
                && (this.getDeveloper() == null ? other.getDeveloper() == null : this.getDeveloper().equals(other.getDeveloper()))
                && (this.getOsRequire() == null ? other.getOsRequire() == null : this.getOsRequire().equals(other.getOsRequire()))
                && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
                && (this.getAvailableCountries() == null ? other.getAvailableCountries() == null : this.getAvailableCountries().equals(other.getAvailableCountries()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getPlat() == null) ? 0 : getPlat().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getAppKey() == null) ? 0 : getAppKey().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDebugStatus() == null) ? 0 : getDebugStatus().hashCode());
        result = prime * result + ((getSdkEventIds() == null) ? 0 : getSdkEventIds().hashCode());
        result = prime * result + ((getCoppa() == null) ? 0 : getCoppa().hashCode());
        result = prime * result + ((getBundleId() == null) ? 0 : getBundleId().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getSubCategoryId() == null) ? 0 : getSubCategoryId().hashCode());
        result = prime * result + ((getPreviewUrl() == null) ? 0 : getPreviewUrl().hashCode());
        result = prime * result + ((getDeveloper() == null) ? 0 : getDeveloper().hashCode());
        result = prime * result + ((getOsRequire() == null) ? 0 : getOsRequire().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getAvailableCountries() == null) ? 0 : getAvailableCountries().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}