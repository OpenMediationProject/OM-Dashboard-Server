// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;

public class OmPlacementCountry {
    private Integer id;

    private Integer placementId;

    private String country;

    private Byte floorPriceSwitch;

    private BigDecimal floorPrice;

    private BigDecimal maxPrice;

    private Byte billingType;

    private BigDecimal revenueSharing;

    private BigDecimal ecpm;

    private Integer hour0;

    private Integer hour1;

    private Integer hour2;

    private Integer hour3;

    private Integer hour4;

    private Integer hour5;

    private Integer hour6;

    private Date createTime;

    private Date lastmodify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Byte getFloorPriceSwitch() {
        return floorPriceSwitch;
    }

    public void setFloorPriceSwitch(Byte floorPriceSwitch) {
        this.floorPriceSwitch = floorPriceSwitch;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Byte getBillingType() {
        return billingType;
    }

    public void setBillingType(Byte billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getRevenueSharing() {
        return revenueSharing;
    }

    public void setRevenueSharing(BigDecimal revenueSharing) {
        this.revenueSharing = revenueSharing;
    }

    public BigDecimal getEcpm() {
        return ecpm;
    }

    public void setEcpm(BigDecimal ecpm) {
        this.ecpm = ecpm;
    }

    public Integer getHour0() {
        return hour0;
    }

    public void setHour0(Integer hour0) {
        this.hour0 = hour0;
    }

    public Integer getHour1() {
        return hour1;
    }

    public void setHour1(Integer hour1) {
        this.hour1 = hour1;
    }

    public Integer getHour2() {
        return hour2;
    }

    public void setHour2(Integer hour2) {
        this.hour2 = hour2;
    }

    public Integer getHour3() {
        return hour3;
    }

    public void setHour3(Integer hour3) {
        this.hour3 = hour3;
    }

    public Integer getHour4() {
        return hour4;
    }

    public void setHour4(Integer hour4) {
        this.hour4 = hour4;
    }

    public Integer getHour5() {
        return hour5;
    }

    public void setHour5(Integer hour5) {
        this.hour5 = hour5;
    }

    public Integer getHour6() {
        return hour6;
    }

    public void setHour6(Integer hour6) {
        this.hour6 = hour6;
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
        OmPlacementCountry other = (OmPlacementCountry) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
                && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
                && (this.getFloorPriceSwitch() == null ? other.getFloorPriceSwitch() == null : this.getFloorPriceSwitch().equals(other.getFloorPriceSwitch()))
                && (this.getFloorPrice() == null ? other.getFloorPrice() == null : this.getFloorPrice().equals(other.getFloorPrice()))
                && (this.getMaxPrice() == null ? other.getMaxPrice() == null : this.getMaxPrice().equals(other.getMaxPrice()))
                && (this.getBillingType() == null ? other.getBillingType() == null : this.getBillingType().equals(other.getBillingType()))
                && (this.getRevenueSharing() == null ? other.getRevenueSharing() == null : this.getRevenueSharing().equals(other.getRevenueSharing()))
                && (this.getEcpm() == null ? other.getEcpm() == null : this.getEcpm().equals(other.getEcpm()))
                && (this.getHour0() == null ? other.getHour0() == null : this.getHour0().equals(other.getHour0()))
                && (this.getHour1() == null ? other.getHour1() == null : this.getHour1().equals(other.getHour1()))
                && (this.getHour2() == null ? other.getHour2() == null : this.getHour2().equals(other.getHour2()))
                && (this.getHour3() == null ? other.getHour3() == null : this.getHour3().equals(other.getHour3()))
                && (this.getHour4() == null ? other.getHour4() == null : this.getHour4().equals(other.getHour4()))
                && (this.getHour5() == null ? other.getHour5() == null : this.getHour5().equals(other.getHour5()))
                && (this.getHour6() == null ? other.getHour6() == null : this.getHour6().equals(other.getHour6()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getFloorPriceSwitch() == null) ? 0 : getFloorPriceSwitch().hashCode());
        result = prime * result + ((getFloorPrice() == null) ? 0 : getFloorPrice().hashCode());
        result = prime * result + ((getMaxPrice() == null) ? 0 : getMaxPrice().hashCode());
        result = prime * result + ((getBillingType() == null) ? 0 : getBillingType().hashCode());
        result = prime * result + ((getRevenueSharing() == null) ? 0 : getRevenueSharing().hashCode());
        result = prime * result + ((getEcpm() == null) ? 0 : getEcpm().hashCode());
        result = prime * result + ((getHour0() == null) ? 0 : getHour0().hashCode());
        result = prime * result + ((getHour1() == null) ? 0 : getHour1().hashCode());
        result = prime * result + ((getHour2() == null) ? 0 : getHour2().hashCode());
        result = prime * result + ((getHour3() == null) ? 0 : getHour3().hashCode());
        result = prime * result + ((getHour4() == null) ? 0 : getHour4().hashCode());
        result = prime * result + ((getHour5() == null) ? 0 : getHour5().hashCode());
        result = prime * result + ((getHour6() == null) ? 0 : getHour6().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}