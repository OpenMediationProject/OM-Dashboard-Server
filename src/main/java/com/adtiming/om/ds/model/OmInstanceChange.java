package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class OmInstanceChange extends OmInstanceChangeKey {
    private String instanceName;

    private Integer adnAppId;

    private Integer pubAppId;

    private Integer placementId;

    private Byte adnId;

    private String appKey;

    private Integer accountId;

    private Byte accountOwner;

    private BigDecimal revenueSharing;

    private Byte abTestMode;

    private Byte status;

    private Date createTime;

    private Date lastmodify;

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName == null ? null : instanceName.trim();
    }

    public Integer getAdnAppId() {
        return adnAppId;
    }

    public void setAdnAppId(Integer adnAppId) {
        this.adnAppId = adnAppId;
    }

    public Integer getPubAppId() {
        return pubAppId;
    }

    public void setPubAppId(Integer pubAppId) {
        this.pubAppId = pubAppId;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public Byte getAdnId() {
        return adnId;
    }

    public void setAdnId(Byte adnId) {
        this.adnId = adnId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
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

    public BigDecimal getRevenueSharing() {
        return revenueSharing;
    }

    public void setRevenueSharing(BigDecimal revenueSharing) {
        this.revenueSharing = revenueSharing;
    }

    public Byte getAbTestMode() {
        return abTestMode;
    }

    public void setAbTestMode(Byte abTestMode) {
        this.abTestMode = abTestMode;
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
        OmInstanceChange other = (OmInstanceChange) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPlacementKey() == null ? other.getPlacementKey() == null : this.getPlacementKey().equals(other.getPlacementKey()))
                && (this.getInstanceName() == null ? other.getInstanceName() == null : this.getInstanceName().equals(other.getInstanceName()))
                && (this.getAdnAppId() == null ? other.getAdnAppId() == null : this.getAdnAppId().equals(other.getAdnAppId()))
                && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
                && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getAppKey() == null ? other.getAppKey() == null : this.getAppKey().equals(other.getAppKey()))
                && (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
                && (this.getAccountOwner() == null ? other.getAccountOwner() == null : this.getAccountOwner().equals(other.getAccountOwner()))
                && (this.getRevenueSharing() == null ? other.getRevenueSharing() == null : this.getRevenueSharing().equals(other.getRevenueSharing()))
                && (this.getAbTestMode() == null ? other.getAbTestMode() == null : this.getAbTestMode().equals(other.getAbTestMode()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlacementKey() == null) ? 0 : getPlacementKey().hashCode());
        result = prime * result + ((getInstanceName() == null) ? 0 : getInstanceName().hashCode());
        result = prime * result + ((getAdnAppId() == null) ? 0 : getAdnAppId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAppKey() == null) ? 0 : getAppKey().hashCode());
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAccountOwner() == null) ? 0 : getAccountOwner().hashCode());
        result = prime * result + ((getRevenueSharing() == null) ? 0 : getRevenueSharing().hashCode());
        result = prime * result + ((getAbTestMode() == null) ? 0 : getAbTestMode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}