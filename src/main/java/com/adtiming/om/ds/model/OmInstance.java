// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OmInstance {
    private Integer id;

    private Integer oldId;

    private String name;

    private Integer adnId;

    private Integer adnAppId;

    private Integer pubAppId;

    private Integer placementId;

    private String placementKey;

    private Integer weight;

    private String descn;

    private Byte status;

    private String osvMax;

    private String osvMin;

    private Integer frequencyCap;

    private Integer frequencyUnit;

    private Integer frequencyInterval;

    private Byte abTestMode;

    private Byte mediationAudienceSegment;

    private Date mediationAudienceSegmentDay;

    private Byte audienceSegment;

    private Integer audienceSegmentExpected;

    private Byte hbStatus;

    private Date createTime;

    private Date lastmodify;

    private Integer priority;

    private Integer placementRuleInstanceId;

    private List<OmInstanceCountry> instanceCountries;

    private Integer groupLevel;

    private Integer autoSwitch;

    private Integer groupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(Integer oldId) {
        this.oldId = oldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer adnId) {
        this.adnId = adnId;
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

    public String getPlacementKey() {
        return placementKey;
    }

    public void setPlacementKey(String placementKey) {
        this.placementKey = placementKey == null ? null : placementKey.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public String getOsvMax() {
        return osvMax;
    }

    public void setOsvMax(String osvMax) {
        this.osvMax = osvMax == null ? null : osvMax.trim();
    }

    public String getOsvMin() {
        return osvMin;
    }

    public void setOsvMin(String osvMin) {
        this.osvMin = osvMin == null ? null : osvMin.trim();
    }

    public Integer getFrequencyCap() {
        return frequencyCap;
    }

    public void setFrequencyCap(Integer frequencyCap) {
        this.frequencyCap = frequencyCap;
    }

    public Integer getFrequencyUnit() {
        return frequencyUnit;
    }

    public void setFrequencyUnit(Integer frequencyUnit) {
        this.frequencyUnit = frequencyUnit;
    }

    public Integer getFrequencyInterval() {
        return frequencyInterval;
    }

    public void setFrequencyInterval(Integer frequencyInterval) {
        this.frequencyInterval = frequencyInterval;
    }

    public Byte getAbTestMode() {
        return abTestMode;
    }

    public void setAbTestMode(Byte abTestMode) {
        this.abTestMode = abTestMode;
    }

    public Byte getMediationAudienceSegment() {
        return mediationAudienceSegment;
    }

    public void setMediationAudienceSegment(Byte mediationAudienceSegment) {
        this.mediationAudienceSegment = mediationAudienceSegment;
    }

    public Date getMediationAudienceSegmentDay() {
        return mediationAudienceSegmentDay;
    }

    public void setMediationAudienceSegmentDay(Date mediationAudienceSegmentDay) {
        this.mediationAudienceSegmentDay = mediationAudienceSegmentDay;
    }

    public Byte getAudienceSegment() {
        return audienceSegment;
    }

    public void setAudienceSegment(Byte audienceSegment) {
        this.audienceSegment = audienceSegment;
    }

    public Integer getAudienceSegmentExpected() {
        return audienceSegmentExpected;
    }

    public void setAudienceSegmentExpected(Integer audienceSegmentExpected) {
        this.audienceSegmentExpected = audienceSegmentExpected;
    }

    public Byte getHbStatus() {
        return hbStatus;
    }

    public void setHbStatus(Byte hbStatus) {
        this.hbStatus = hbStatus;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPlacementRuleInstanceId() {
        return placementRuleInstanceId;
    }

    public void setPlacementRuleInstanceId(Integer placementRuleInstanceId) {
        this.placementRuleInstanceId = placementRuleInstanceId;
    }

    public List<OmInstanceCountry> getInstanceCountries() {
        return instanceCountries;
    }

    public void setInstanceCountries(List<OmInstanceCountry> instanceCountries) {
        this.instanceCountries = instanceCountries;
    }

    public Integer getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(Integer groupLevel) {
        this.groupLevel = groupLevel;
    }

    public Integer getAutoSwitch() {
        return autoSwitch;
    }

    public void setAutoSwitch(Integer autoSwitch) {
        this.autoSwitch = autoSwitch;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}