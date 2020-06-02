package com.adtiming.om.ds.model;

import java.util.Date;

public class OmAdnetworkAppChange {
    private Integer id;

    private Integer pubAppId;

    private Integer adnId;

    private Integer accountId;

    private Byte accountOwner;

    private Byte status;

    private String adnAppKey;

    private String clientId;

    private String clientSecret;

    private String refreshToken;

    private String apiKey;

    private String reportAppId;

    private String newAccountKey;

    private Byte abTestMode;

    private Integer reportAccountId;

    private Integer newReportAccountId;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPubAppId() {
        return pubAppId;
    }

    public void setPubAppId(Integer pubAppId) {
        this.pubAppId = pubAppId;
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Byte getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(Byte accountOwner) {
        this.accountOwner = accountOwner;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAdnAppKey() {
        return adnAppKey;
    }

    public void setAdnAppKey(String adnAppKey) {
        this.adnAppKey = adnAppKey == null ? null : adnAppKey.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret == null ? null : clientSecret.trim();
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey == null ? null : apiKey.trim();
    }

    public String getReportAppId() {
        return reportAppId;
    }

    public void setReportAppId(String reportAppId) {
        this.reportAppId = reportAppId == null ? null : reportAppId.trim();
    }

    public String getNewAccountKey() {
        return newAccountKey;
    }

    public void setNewAccountKey(String newAccountKey) {
        this.newAccountKey = newAccountKey == null ? null : newAccountKey.trim();
    }

    public Byte getAbTestMode() {
        return abTestMode;
    }

    public void setAbTestMode(Byte abTestMode) {
        this.abTestMode = abTestMode;
    }

    public Integer getReportAccountId() {
        return reportAccountId;
    }

    public void setReportAccountId(Integer reportAccountId) {
        this.reportAccountId = reportAccountId;
    }

    public Integer getNewReportAccountId() {
        return newReportAccountId;
    }

    public void setNewReportAccountId(Integer newReportAccountId) {
        this.newReportAccountId = newReportAccountId;
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
        OmAdnetworkAppChange other = (OmAdnetworkAppChange) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
            && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
            && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
            && (this.getAccountOwner() == null ? other.getAccountOwner() == null : this.getAccountOwner().equals(other.getAccountOwner()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getAdnAppKey() == null ? other.getAdnAppKey() == null : this.getAdnAppKey().equals(other.getAdnAppKey()))
            && (this.getClientId() == null ? other.getClientId() == null : this.getClientId().equals(other.getClientId()))
            && (this.getClientSecret() == null ? other.getClientSecret() == null : this.getClientSecret().equals(other.getClientSecret()))
            && (this.getRefreshToken() == null ? other.getRefreshToken() == null : this.getRefreshToken().equals(other.getRefreshToken()))
            && (this.getApiKey() == null ? other.getApiKey() == null : this.getApiKey().equals(other.getApiKey()))
            && (this.getReportAppId() == null ? other.getReportAppId() == null : this.getReportAppId().equals(other.getReportAppId()))
            && (this.getNewAccountKey() == null ? other.getNewAccountKey() == null : this.getNewAccountKey().equals(other.getNewAccountKey()))
            && (this.getAbTestMode() == null ? other.getAbTestMode() == null : this.getAbTestMode().equals(other.getAbTestMode()))
            && (this.getReportAccountId() == null ? other.getReportAccountId() == null : this.getReportAccountId().equals(other.getReportAccountId()))
            && (this.getNewReportAccountId() == null ? other.getNewReportAccountId() == null : this.getNewReportAccountId().equals(other.getNewReportAccountId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAccountOwner() == null) ? 0 : getAccountOwner().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAdnAppKey() == null) ? 0 : getAdnAppKey().hashCode());
        result = prime * result + ((getClientId() == null) ? 0 : getClientId().hashCode());
        result = prime * result + ((getClientSecret() == null) ? 0 : getClientSecret().hashCode());
        result = prime * result + ((getRefreshToken() == null) ? 0 : getRefreshToken().hashCode());
        result = prime * result + ((getApiKey() == null) ? 0 : getApiKey().hashCode());
        result = prime * result + ((getReportAppId() == null) ? 0 : getReportAppId().hashCode());
        result = prime * result + ((getNewAccountKey() == null) ? 0 : getNewAccountKey().hashCode());
        result = prime * result + ((getAbTestMode() == null) ? 0 : getAbTestMode().hashCode());
        result = prime * result + ((getReportAccountId() == null) ? 0 : getReportAccountId().hashCode());
        result = prime * result + ((getNewReportAccountId() == null) ? 0 : getNewReportAccountId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}