// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class ReportAdnetworkAccount {
    private Integer id;

    private Integer adnId;

    private Integer adnAccountId;

    private Byte adnAccountOwner;

    private String adnAppId;

    private String adnApiKey;

    private String adnAppToken;

    private String userId;

    private String userSignature;

    private String credentialPath;

    private String authKey;

    private Byte status;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
    }

    public Integer getAdnAccountId() {
        return adnAccountId;
    }

    public void setAdnAccountId(Integer adnAccountId) {
        this.adnAccountId = adnAccountId;
    }

    public Byte getAdnAccountOwner() {
        return adnAccountOwner;
    }

    public void setAdnAccountOwner(Byte adnAccountOwner) {
        this.adnAccountOwner = adnAccountOwner;
    }

    public String getAdnAppId() {
        return adnAppId;
    }

    public void setAdnAppId(String adnAppId) {
        this.adnAppId = adnAppId == null ? null : adnAppId.trim();
    }

    public String getAdnApiKey() {
        return adnApiKey;
    }

    public void setAdnApiKey(String adnApiKey) {
        this.adnApiKey = adnApiKey == null ? null : adnApiKey.trim();
    }

    public String getAdnAppToken() {
        return adnAppToken;
    }

    public void setAdnAppToken(String adnAppToken) {
        this.adnAppToken = adnAppToken == null ? null : adnAppToken.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature == null ? null : userSignature.trim();
    }

    public String getCredentialPath() {
        return credentialPath;
    }

    public void setCredentialPath(String credentialPath) {
        this.credentialPath = credentialPath == null ? null : credentialPath.trim();
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey == null ? null : authKey.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        ReportAdnetworkAccount other = (ReportAdnetworkAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getAdnAccountId() == null ? other.getAdnAccountId() == null : this.getAdnAccountId().equals(other.getAdnAccountId()))
                && (this.getAdnAccountOwner() == null ? other.getAdnAccountOwner() == null : this.getAdnAccountOwner().equals(other.getAdnAccountOwner()))
                && (this.getAdnAppId() == null ? other.getAdnAppId() == null : this.getAdnAppId().equals(other.getAdnAppId()))
                && (this.getAdnApiKey() == null ? other.getAdnApiKey() == null : this.getAdnApiKey().equals(other.getAdnApiKey()))
                && (this.getAdnAppToken() == null ? other.getAdnAppToken() == null : this.getAdnAppToken().equals(other.getAdnAppToken()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUserSignature() == null ? other.getUserSignature() == null : this.getUserSignature().equals(other.getUserSignature()))
                && (this.getCredentialPath() == null ? other.getCredentialPath() == null : this.getCredentialPath().equals(other.getCredentialPath()))
                && (this.getAuthKey() == null ? other.getAuthKey() == null : this.getAuthKey().equals(other.getAuthKey()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAdnAccountId() == null) ? 0 : getAdnAccountId().hashCode());
        result = prime * result + ((getAdnAccountOwner() == null) ? 0 : getAdnAccountOwner().hashCode());
        result = prime * result + ((getAdnAppId() == null) ? 0 : getAdnAppId().hashCode());
        result = prime * result + ((getAdnApiKey() == null) ? 0 : getAdnApiKey().hashCode());
        result = prime * result + ((getAdnAppToken() == null) ? 0 : getAdnAppToken().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserSignature() == null) ? 0 : getUserSignature().hashCode());
        result = prime * result + ((getCredentialPath() == null) ? 0 : getCredentialPath().hashCode());
        result = prime * result + ((getAuthKey() == null) ? 0 : getAuthKey().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}