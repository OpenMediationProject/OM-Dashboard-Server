// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

import com.adtiming.om.ds.model.OmInstanceWithBLOBs;

import java.math.BigDecimal;

/**
 * Created by ruandianbo on 20-2-18.
 */
public class SegmentDTO {

    private Integer id;

    private Integer publisherId;

    private Integer pubAppId;

    private Integer placementId;

    private String name;

    private Integer segmentId;

    private Byte abTest;

    private Byte autoOpt;

    private Byte sortType;

    private Integer priority;

    private Byte status;

    private Integer createUserId;

    private String countries;

    private Integer frequency;

    private Byte conType;

    private String brandWhitelist;

    private String brandBlacklist;

    private String modelWhitelist;

    private String modelBlacklist;

    private Byte gender;

    private Integer ageMin;

    private Integer ageMax;

    private BigDecimal iapMin;

    private BigDecimal iapMax;

    private String channel;

    private Byte channelBow;

    private Integer deviceModelType;

    private OmInstanceWithBLOBs[] instances;

    private OmInstanceWithBLOBs[] headerbidding;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Integer segmentId) {
        this.segmentId = segmentId;
    }

    public Byte getAbTest() {
        return abTest;
    }

    public void setAbTest(Byte abTest) {
        this.abTest = abTest;
    }

    public Byte getAutoOpt() {
        return autoOpt;
    }

    public void setAutoOpt(Byte autoOpt) {
        this.autoOpt = autoOpt;
    }

    public Byte getSortType() {
        return sortType;
    }

    public void setSortType(Byte sortType) {
        this.sortType = sortType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Byte getConType() {
        return conType;
    }

    public void setConType(Byte conType) {
        this.conType = conType;
    }

    public String getBrandWhitelist() {
        return brandWhitelist;
    }

    public void setBrandWhitelist(String brandWhitelist) {
        this.brandWhitelist = brandWhitelist;
    }

    public String getBrandBlacklist() {
        return brandBlacklist;
    }

    public void setBrandBlacklist(String brandBlacklist) {
        this.brandBlacklist = brandBlacklist;
    }

    public String getModelWhitelist() {
        return modelWhitelist;
    }

    public void setModelWhitelist(String modelWhitelist) {
        this.modelWhitelist = modelWhitelist;
    }

    public String getModelBlacklist() {
        return modelBlacklist;
    }

    public void setModelBlacklist(String modelBlacklist) {
        this.modelBlacklist = modelBlacklist;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Byte getChannelBow() {
        return channelBow;
    }

    public void setChannelBow(Byte channelBow) {
        this.channelBow = channelBow;
    }

    public Integer getDeviceModelType() {
        return deviceModelType;
    }

    public void setDeviceModelType(Integer deviceModelType) {
        this.deviceModelType = deviceModelType;
    }

    public BigDecimal getIapMin() {
        return iapMin;
    }

    public void setIapMin(BigDecimal iapMin) {
        this.iapMin = iapMin;
    }

    public BigDecimal getIapMax() {
        return iapMax;
    }

    public void setIapMax(BigDecimal iapMax) {
        this.iapMax = iapMax;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public OmInstanceWithBLOBs[] getInstances() {
        return instances;
    }

    public void setInstances(OmInstanceWithBLOBs[] instances) {
        this.instances = instances;
    }

    public OmInstanceWithBLOBs[] getHeaderbidding() {
        return headerbidding;
    }

    public void setHeaderbidding(OmInstanceWithBLOBs[] headerbidding) {
        this.headerbidding = headerbidding;
    }
}
