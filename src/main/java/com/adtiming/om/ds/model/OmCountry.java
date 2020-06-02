// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

public class OmCountry {
    private Integer id;

    private String a2;

    private String a3;

    private String num;

    private Byte tier;

    private String continent;

    private String capital;

    private Byte dcenter;

    private String name;

    private String nameCn;

    private Integer storeFrontId;

    private Integer area;

    private Integer population;

    private String mainLang;

    private String mutiLang;

    private String tld;

    private Byte tz;

    private Date createTime;

    private Date lastmodify;

    private String timeZones;

    private Double revenue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3 == null ? null : a3.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public Byte getTier() {
        return tier;
    }

    public void setTier(Byte tier) {
        this.tier = tier;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent == null ? null : continent.trim();
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital == null ? null : capital.trim();
    }

    public Byte getDcenter() {
        return dcenter;
    }

    public void setDcenter(Byte dcenter) {
        this.dcenter = dcenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public Integer getStoreFrontId() {
        return storeFrontId;
    }

    public void setStoreFrontId(Integer storeFrontId) {
        this.storeFrontId = storeFrontId;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getMainLang() {
        return mainLang;
    }

    public void setMainLang(String mainLang) {
        this.mainLang = mainLang == null ? null : mainLang.trim();
    }

    public String getMutiLang() {
        return mutiLang;
    }

    public void setMutiLang(String mutiLang) {
        this.mutiLang = mutiLang == null ? null : mutiLang.trim();
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld == null ? null : tld.trim();
    }

    public Byte getTz() {
        return tz;
    }

    public void setTz(Byte tz) {
        this.tz = tz;
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

    public String getTimeZones() {
        return timeZones;
    }

    public void setTimeZones(String timeZones) {
        this.timeZones = timeZones == null ? null : timeZones.trim();
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
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
        OmCountry other = (OmCountry) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getA2() == null ? other.getA2() == null : this.getA2().equals(other.getA2()))
                && (this.getA3() == null ? other.getA3() == null : this.getA3().equals(other.getA3()))
                && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
                && (this.getTier() == null ? other.getTier() == null : this.getTier().equals(other.getTier()))
                && (this.getContinent() == null ? other.getContinent() == null : this.getContinent().equals(other.getContinent()))
                && (this.getCapital() == null ? other.getCapital() == null : this.getCapital().equals(other.getCapital()))
                && (this.getDcenter() == null ? other.getDcenter() == null : this.getDcenter().equals(other.getDcenter()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getNameCn() == null ? other.getNameCn() == null : this.getNameCn().equals(other.getNameCn()))
                && (this.getStoreFrontId() == null ? other.getStoreFrontId() == null : this.getStoreFrontId().equals(other.getStoreFrontId()))
                && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
                && (this.getPopulation() == null ? other.getPopulation() == null : this.getPopulation().equals(other.getPopulation()))
                && (this.getMainLang() == null ? other.getMainLang() == null : this.getMainLang().equals(other.getMainLang()))
                && (this.getMutiLang() == null ? other.getMutiLang() == null : this.getMutiLang().equals(other.getMutiLang()))
                && (this.getTld() == null ? other.getTld() == null : this.getTld().equals(other.getTld()))
                && (this.getTz() == null ? other.getTz() == null : this.getTz().equals(other.getTz()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()))
                && (this.getTimeZones() == null ? other.getTimeZones() == null : this.getTimeZones().equals(other.getTimeZones()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getA2() == null) ? 0 : getA2().hashCode());
        result = prime * result + ((getA3() == null) ? 0 : getA3().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getTier() == null) ? 0 : getTier().hashCode());
        result = prime * result + ((getContinent() == null) ? 0 : getContinent().hashCode());
        result = prime * result + ((getCapital() == null) ? 0 : getCapital().hashCode());
        result = prime * result + ((getDcenter() == null) ? 0 : getDcenter().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameCn() == null) ? 0 : getNameCn().hashCode());
        result = prime * result + ((getStoreFrontId() == null) ? 0 : getStoreFrontId().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getPopulation() == null) ? 0 : getPopulation().hashCode());
        result = prime * result + ((getMainLang() == null) ? 0 : getMainLang().hashCode());
        result = prime * result + ((getMutiLang() == null) ? 0 : getMutiLang().hashCode());
        result = prime * result + ((getTld() == null) ? 0 : getTld().hashCode());
        result = prime * result + ((getTz() == null) ? 0 : getTz().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        result = prime * result + ((getTimeZones() == null) ? 0 : getTimeZones().hashCode());
        return result;
    }
}