// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

public class OmAppWithBLOBs extends OmApp {
    private String screenshotUrls;

    private String descn;

    private String moreDescn;

    private String whatsnew;

    public String getScreenshotUrls() {
        return screenshotUrls;
    }

    public void setScreenshotUrls(String screenshotUrls) {
        this.screenshotUrls = screenshotUrls == null ? null : screenshotUrls.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public String getMoreDescn() {
        return moreDescn;
    }

    public void setMoreDescn(String moreDescn) {
        this.moreDescn = moreDescn == null ? null : moreDescn.trim();
    }

    public String getWhatsnew() {
        return whatsnew;
    }

    public void setWhatsnew(String whatsnew) {
        this.whatsnew = whatsnew == null ? null : whatsnew.trim();
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
        OmAppWithBLOBs other = (OmAppWithBLOBs) that;
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
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
            && (this.getScreenshotUrls() == null ? other.getScreenshotUrls() == null : this.getScreenshotUrls().equals(other.getScreenshotUrls()))
            && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
            && (this.getMoreDescn() == null ? other.getMoreDescn() == null : this.getMoreDescn().equals(other.getMoreDescn()))
            && (this.getWhatsnew() == null ? other.getWhatsnew() == null : this.getWhatsnew().equals(other.getWhatsnew()));
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
        result = prime * result + ((getScreenshotUrls() == null) ? 0 : getScreenshotUrls().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getMoreDescn() == null) ? 0 : getMoreDescn().hashCode());
        result = prime * result + ((getWhatsnew() == null) ? 0 : getWhatsnew().hashCode());
        return result;
    }
}