// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmAdnetworkAccount {
    private Integer id;

    private Byte adnId;

    private String account;

    private String pwd;

    private String accountVerify;

    private String ip;

    private String telnetAccount;

    private String telnetPwd;

    private String descn;

    private Byte status;

    private Integer operator;

    private Byte operateStatus;

    private Byte blacklist;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getAdnId() {
        return adnId;
    }

    public void setAdnId(Byte adnId) {
        this.adnId = adnId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getAccountVerify() {
        return accountVerify;
    }

    public void setAccountVerify(String accountVerify) {
        this.accountVerify = accountVerify == null ? null : accountVerify.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getTelnetAccount() {
        return telnetAccount;
    }

    public void setTelnetAccount(String telnetAccount) {
        this.telnetAccount = telnetAccount == null ? null : telnetAccount.trim();
    }

    public String getTelnetPwd() {
        return telnetPwd;
    }

    public void setTelnetPwd(String telnetPwd) {
        this.telnetPwd = telnetPwd == null ? null : telnetPwd.trim();
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

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Byte getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(Byte operateStatus) {
        this.operateStatus = operateStatus;
    }

    public Byte getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Byte blacklist) {
        this.blacklist = blacklist;
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
        OmAdnetworkAccount other = (OmAdnetworkAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
                && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
                && (this.getAccountVerify() == null ? other.getAccountVerify() == null : this.getAccountVerify().equals(other.getAccountVerify()))
                && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
                && (this.getTelnetAccount() == null ? other.getTelnetAccount() == null : this.getTelnetAccount().equals(other.getTelnetAccount()))
                && (this.getTelnetPwd() == null ? other.getTelnetPwd() == null : this.getTelnetPwd().equals(other.getTelnetPwd()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
                && (this.getOperateStatus() == null ? other.getOperateStatus() == null : this.getOperateStatus().equals(other.getOperateStatus()))
                && (this.getBlacklist() == null ? other.getBlacklist() == null : this.getBlacklist().equals(other.getBlacklist()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getAccountVerify() == null) ? 0 : getAccountVerify().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getTelnetAccount() == null) ? 0 : getTelnetAccount().hashCode());
        result = prime * result + ((getTelnetPwd() == null) ? 0 : getTelnetPwd().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getOperateStatus() == null) ? 0 : getOperateStatus().hashCode());
        result = prime * result + ((getBlacklist() == null) ? 0 : getBlacklist().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}