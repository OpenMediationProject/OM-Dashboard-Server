// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class OmApp {
    private Integer id;

    private Byte plat;

    private String appId;

    private String otherStoreId;

    private String name;

    private String appName;

    private String icon;

    private String videoUrl;

    private String bundleId;

    private String category;

    private Integer categoryId;

    private Integer subCategoryId1;

    private Integer subCategoryId2;

    private Integer subCategoryId3;

    private String previewUrl;

    private BigDecimal ratingValue;

    private Integer ratingCount;

    private Date releaseTime;

    private String version;

    private String osRequire;

    private String mainLang;

    private String country;

    private Byte fetched;

    private Date fetchTime;

    private Integer failedTimes;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getOtherStoreId() {
        return otherStoreId;
    }

    public void setOtherStoreId(String otherStoreId) {
        this.otherStoreId = otherStoreId == null ? null : otherStoreId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId == null ? null : bundleId.trim();
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

    public Integer getSubCategoryId1() {
        return subCategoryId1;
    }

    public void setSubCategoryId1(Integer subCategoryId1) {
        this.subCategoryId1 = subCategoryId1;
    }

    public Integer getSubCategoryId2() {
        return subCategoryId2;
    }

    public void setSubCategoryId2(Integer subCategoryId2) {
        this.subCategoryId2 = subCategoryId2;
    }

    public Integer getSubCategoryId3() {
        return subCategoryId3;
    }

    public void setSubCategoryId3(Integer subCategoryId3) {
        this.subCategoryId3 = subCategoryId3;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public BigDecimal getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(BigDecimal ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getOsRequire() {
        return osRequire;
    }

    public void setOsRequire(String osRequire) {
        this.osRequire = osRequire == null ? null : osRequire.trim();
    }

    public String getMainLang() {
        return mainLang;
    }

    public void setMainLang(String mainLang) {
        this.mainLang = mainLang == null ? null : mainLang.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Byte getFetched() {
        return fetched;
    }

    public void setFetched(Byte fetched) {
        this.fetched = fetched;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public Integer getFailedTimes() {
        return failedTimes;
    }

    public void setFailedTimes(Integer failedTimes) {
        this.failedTimes = failedTimes;
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
        OmApp other = (OmApp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlat() == null ? other.getPlat() == null : this.getPlat().equals(other.getPlat()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getOtherStoreId() == null ? other.getOtherStoreId() == null : this.getOtherStoreId().equals(other.getOtherStoreId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getVideoUrl() == null ? other.getVideoUrl() == null : this.getVideoUrl().equals(other.getVideoUrl()))
            && (this.getBundleId() == null ? other.getBundleId() == null : this.getBundleId().equals(other.getBundleId()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getSubCategoryId1() == null ? other.getSubCategoryId1() == null : this.getSubCategoryId1().equals(other.getSubCategoryId1()))
            && (this.getSubCategoryId2() == null ? other.getSubCategoryId2() == null : this.getSubCategoryId2().equals(other.getSubCategoryId2()))
            && (this.getSubCategoryId3() == null ? other.getSubCategoryId3() == null : this.getSubCategoryId3().equals(other.getSubCategoryId3()))
            && (this.getPreviewUrl() == null ? other.getPreviewUrl() == null : this.getPreviewUrl().equals(other.getPreviewUrl()))
            && (this.getRatingValue() == null ? other.getRatingValue() == null : this.getRatingValue().equals(other.getRatingValue()))
            && (this.getRatingCount() == null ? other.getRatingCount() == null : this.getRatingCount().equals(other.getRatingCount()))
            && (this.getReleaseTime() == null ? other.getReleaseTime() == null : this.getReleaseTime().equals(other.getReleaseTime()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getOsRequire() == null ? other.getOsRequire() == null : this.getOsRequire().equals(other.getOsRequire()))
            && (this.getMainLang() == null ? other.getMainLang() == null : this.getMainLang().equals(other.getMainLang()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getFetched() == null ? other.getFetched() == null : this.getFetched().equals(other.getFetched()))
            && (this.getFetchTime() == null ? other.getFetchTime() == null : this.getFetchTime().equals(other.getFetchTime()))
            && (this.getFailedTimes() == null ? other.getFailedTimes() == null : this.getFailedTimes().equals(other.getFailedTimes()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlat() == null) ? 0 : getPlat().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getOtherStoreId() == null) ? 0 : getOtherStoreId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getVideoUrl() == null) ? 0 : getVideoUrl().hashCode());
        result = prime * result + ((getBundleId() == null) ? 0 : getBundleId().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getSubCategoryId1() == null) ? 0 : getSubCategoryId1().hashCode());
        result = prime * result + ((getSubCategoryId2() == null) ? 0 : getSubCategoryId2().hashCode());
        result = prime * result + ((getSubCategoryId3() == null) ? 0 : getSubCategoryId3().hashCode());
        result = prime * result + ((getPreviewUrl() == null) ? 0 : getPreviewUrl().hashCode());
        result = prime * result + ((getRatingValue() == null) ? 0 : getRatingValue().hashCode());
        result = prime * result + ((getRatingCount() == null) ? 0 : getRatingCount().hashCode());
        result = prime * result + ((getReleaseTime() == null) ? 0 : getReleaseTime().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getOsRequire() == null) ? 0 : getOsRequire().hashCode());
        result = prime * result + ((getMainLang() == null) ? 0 : getMainLang().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getFetched() == null) ? 0 : getFetched().hashCode());
        result = prime * result + ((getFetchTime() == null) ? 0 : getFetchTime().hashCode());
        result = prime * result + ((getFailedTimes() == null) ? 0 : getFailedTimes().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}