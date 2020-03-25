// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UmUser implements Serializable, Cloneable {
    private Integer id;

    private String name;

    private String username;

    private String email;

    private String phone;

    private String avatar;

    private String password;

    private String salt;

    private String pwdOld;

    private Date pwdLastmodify;

    private String secretKey;

    private Date secretKeyLastmodify;

    private Byte secretKeyDone;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Byte status;

    private String descn;

    private Integer creatorId;

    private Date createTime;

    private Date lastmodify;

    private String token;

    private Integer roleId;

    private String roleName;

    private Integer publisherId;

    private Integer oldPublisherId;

    private String publisherName;

    private List<UmRole> roles;

    private List<UmPermission> perms;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld == null ? null : pwdOld.trim();
    }

    public Date getPwdLastmodify() {
        return pwdLastmodify;
    }

    public void setPwdLastmodify(Date pwdLastmodify) {
        this.pwdLastmodify = pwdLastmodify;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey == null ? null : secretKey.trim();
    }

    public Date getSecretKeyLastmodify() {
        return secretKeyLastmodify;
    }

    public void setSecretKeyLastmodify(Date secretKeyLastmodify) {
        this.secretKeyLastmodify = secretKeyLastmodify;
    }

    public Byte getSecretKeyDone() {
        return secretKeyDone;
    }

    public void setSecretKeyDone(Byte secretKeyDone) {
        this.secretKeyDone = secretKeyDone;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<UmRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UmRole> roles) {
        this.roles = roles;
    }

    public List<UmPermission> getPerms() {
        return perms;
    }

    public void setPerms(List<UmPermission> perms) {
        this.perms = perms;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOldPublisherId() {
        return oldPublisherId;
    }

    public void setOldPublisherId(Integer oldPublisherId) {
        this.oldPublisherId = oldPublisherId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
        UmUser other = (UmUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
                && (this.getPwdOld() == null ? other.getPwdOld() == null : this.getPwdOld().equals(other.getPwdOld()))
                && (this.getPwdLastmodify() == null ? other.getPwdLastmodify() == null : this.getPwdLastmodify().equals(other.getPwdLastmodify()))
                && (this.getSecretKey() == null ? other.getSecretKey() == null : this.getSecretKey().equals(other.getSecretKey()))
                && (this.getSecretKeyLastmodify() == null ? other.getSecretKeyLastmodify() == null : this.getSecretKeyLastmodify().equals(other.getSecretKeyLastmodify()))
                && (this.getSecretKeyDone() == null ? other.getSecretKeyDone() == null : this.getSecretKeyDone().equals(other.getSecretKeyDone()))
                && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
                && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getPublisherId() == null ? other.getPublisherId() == null : this.getPublisherId().equals(other.getPublisherId()))
                && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getPwdOld() == null) ? 0 : getPwdOld().hashCode());
        result = prime * result + ((getPwdLastmodify() == null) ? 0 : getPwdLastmodify().hashCode());
        result = prime * result + ((getSecretKey() == null) ? 0 : getSecretKey().hashCode());
        result = prime * result + ((getSecretKeyLastmodify() == null) ? 0 : getSecretKeyLastmodify().hashCode());
        result = prime * result + ((getSecretKeyDone() == null) ? 0 : getSecretKeyDone().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getPublisherId() == null) ? 0 : getPublisherId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }

    @Override
    public UmUser clone() {
        UmUser u = new UmUser();
        u.setId(id);
        u.setAvatar(avatar);
        u.setName(name);
        u.setUsername(username);
        u.setEmail(email);
        /*u.setPassword(password);
        u.setSalt(salt);
        u.setPwdOld(pwdOld);
        u.setSecretKey(secretKey);
        u.setSecretKeyDone(secretKeyDone);
        u.setSecretKeyLastmodify(secretKeyLastmodify);*/
        u.setPhone(phone);
        u.setDescn(descn);
        u.setStatus(status);
        u.setToken(token);
        u.setRoleId(roleId);
        u.setRoleName(roleName);
        u.setPublisherId(publisherId);
        u.setPublisherName(publisherName);
        u.setCreateTime(createTime);
        u.setCreatorId(creatorId);
        u.setLastmodify(lastmodify);
        u.setLastLoginIp(lastLoginIp);
        u.setLastLoginTime(lastLoginTime);
        u.setPerms(perms);
        u.setRoles(roles);
        u.setRoleId(roleId);
        u.setPublisherId(publisherId);
        u.setRoleName(roleName);
        u.setPublisherName(publisherName);
        return u;
    }
}