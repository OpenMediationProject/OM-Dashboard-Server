// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmAdnetwork {
    private Integer id;

    private String name;

    private String className;

    private Byte type;

    private Byte iosAdtype;

    private Byte androidAdtype;

    private String sdkVersion;

    private String descn;

    private Byte status;

    private Byte publisherVisible;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getIosAdtype() {
        return iosAdtype;
    }

    public void setIosAdtype(Byte iosAdtype) {
        this.iosAdtype = iosAdtype;
    }

    public Byte getAndroidAdtype() {
        return androidAdtype;
    }

    public void setAndroidAdtype(Byte androidAdtype) {
        this.androidAdtype = androidAdtype;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion == null ? null : sdkVersion.trim();
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

    public Byte getPublisherVisible() {
        return publisherVisible;
    }

    public void setPublisherVisible(Byte publisherVisible) {
        this.publisherVisible = publisherVisible;
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
        OmAdnetwork other = (OmAdnetwork) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getIosAdtype() == null ? other.getIosAdtype() == null : this.getIosAdtype().equals(other.getIosAdtype()))
                && (this.getAndroidAdtype() == null ? other.getAndroidAdtype() == null : this.getAndroidAdtype().equals(other.getAndroidAdtype()))
                && (this.getSdkVersion() == null ? other.getSdkVersion() == null : this.getSdkVersion().equals(other.getSdkVersion()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getPublisherVisible() == null ? other.getPublisherVisible() == null : this.getPublisherVisible().equals(other.getPublisherVisible()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIosAdtype() == null) ? 0 : getIosAdtype().hashCode());
        result = prime * result + ((getAndroidAdtype() == null) ? 0 : getAndroidAdtype().hashCode());
        result = prime * result + ((getSdkVersion() == null) ? 0 : getSdkVersion().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPublisherVisible() == null) ? 0 : getPublisherVisible().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}