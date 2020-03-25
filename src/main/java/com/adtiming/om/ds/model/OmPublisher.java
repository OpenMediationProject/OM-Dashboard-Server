// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OmPublisher implements Serializable {
    private Integer id;

    private String name;

    private String nickname;

    private Byte status;

    private Byte verifyStatus;

    private String domain;

    private String descn;

    private String contacts;

    private BigDecimal revenueSharing;

    private Byte imType;

    private Integer publisherManager;

    private Integer accountManager;

    private String token;

    private Date tokenCreateTime;

    private String address;

    private String email;

    private String country;

    private String phone;

    private String skype;

    private String wechatQq;

    private String facebookAccount;

    private Integer ownerUserId;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Byte verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public BigDecimal getRevenueSharing() {
        return revenueSharing;
    }

    public void setRevenueSharing(BigDecimal revenueSharing) {
        this.revenueSharing = revenueSharing;
    }

    public Byte getImType() {
        return imType;
    }

    public void setImType(Byte imType) {
        this.imType = imType;
    }

    public Integer getPublisherManager() {
        return publisherManager;
    }

    public void setPublisherManager(Integer publisherManager) {
        this.publisherManager = publisherManager;
    }

    public Integer getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Integer accountManager) {
        this.accountManager = accountManager;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(Date tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype == null ? null : skype.trim();
    }

    public String getWechatQq() {
        return wechatQq;
    }

    public void setWechatQq(String wechatQq) {
        this.wechatQq = wechatQq == null ? null : wechatQq.trim();
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount == null ? null : facebookAccount.trim();
    }

    public Integer getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Integer ownerUserId) {
        this.ownerUserId = ownerUserId;
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
        OmPublisher other = (OmPublisher) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getVerifyStatus() == null ? other.getVerifyStatus() == null : this.getVerifyStatus().equals(other.getVerifyStatus()))
                && (this.getDomain() == null ? other.getDomain() == null : this.getDomain().equals(other.getDomain()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
                && (this.getRevenueSharing() == null ? other.getRevenueSharing() == null : this.getRevenueSharing().equals(other.getRevenueSharing()))
                && (this.getImType() == null ? other.getImType() == null : this.getImType().equals(other.getImType()))
                && (this.getPublisherManager() == null ? other.getPublisherManager() == null : this.getPublisherManager().equals(other.getPublisherManager()))
                && (this.getAccountManager() == null ? other.getAccountManager() == null : this.getAccountManager().equals(other.getAccountManager()))
                && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
                && (this.getTokenCreateTime() == null ? other.getTokenCreateTime() == null : this.getTokenCreateTime().equals(other.getTokenCreateTime()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getSkype() == null ? other.getSkype() == null : this.getSkype().equals(other.getSkype()))
                && (this.getWechatQq() == null ? other.getWechatQq() == null : this.getWechatQq().equals(other.getWechatQq()))
                && (this.getFacebookAccount() == null ? other.getFacebookAccount() == null : this.getFacebookAccount().equals(other.getFacebookAccount()))
                && (this.getOwnerUserId() == null ? other.getOwnerUserId() == null : this.getOwnerUserId().equals(other.getOwnerUserId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVerifyStatus() == null) ? 0 : getVerifyStatus().hashCode());
        result = prime * result + ((getDomain() == null) ? 0 : getDomain().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getRevenueSharing() == null) ? 0 : getRevenueSharing().hashCode());
        result = prime * result + ((getImType() == null) ? 0 : getImType().hashCode());
        result = prime * result + ((getPublisherManager() == null) ? 0 : getPublisherManager().hashCode());
        result = prime * result + ((getAccountManager() == null) ? 0 : getAccountManager().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getTokenCreateTime() == null) ? 0 : getTokenCreateTime().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getSkype() == null) ? 0 : getSkype().hashCode());
        result = prime * result + ((getWechatQq() == null) ? 0 : getWechatQq().hashCode());
        result = prime * result + ((getFacebookAccount() == null) ? 0 : getFacebookAccount().hashCode());
        result = prime * result + ((getOwnerUserId() == null) ? 0 : getOwnerUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}