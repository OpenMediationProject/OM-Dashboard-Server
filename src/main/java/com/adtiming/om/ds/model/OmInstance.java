// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.Date;

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
        OmInstance other = (OmInstance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOldId() == null ? other.getOldId() == null : this.getOldId().equals(other.getOldId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAdnId() == null ? other.getAdnId() == null : this.getAdnId().equals(other.getAdnId()))
                && (this.getAdnAppId() == null ? other.getAdnAppId() == null : this.getAdnAppId().equals(other.getAdnAppId()))
                && (this.getPubAppId() == null ? other.getPubAppId() == null : this.getPubAppId().equals(other.getPubAppId()))
                && (this.getPlacementId() == null ? other.getPlacementId() == null : this.getPlacementId().equals(other.getPlacementId()))
                && (this.getPlacementKey() == null ? other.getPlacementKey() == null : this.getPlacementKey().equals(other.getPlacementKey()))
                && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
                && (this.getDescn() == null ? other.getDescn() == null : this.getDescn().equals(other.getDescn()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getOsvMax() == null ? other.getOsvMax() == null : this.getOsvMax().equals(other.getOsvMax()))
                && (this.getOsvMin() == null ? other.getOsvMin() == null : this.getOsvMin().equals(other.getOsvMin()))
                && (this.getFrequencyCap() == null ? other.getFrequencyCap() == null : this.getFrequencyCap().equals(other.getFrequencyCap()))
                && (this.getFrequencyUnit() == null ? other.getFrequencyUnit() == null : this.getFrequencyUnit().equals(other.getFrequencyUnit()))
                && (this.getFrequencyInterval() == null ? other.getFrequencyInterval() == null : this.getFrequencyInterval().equals(other.getFrequencyInterval()))
                && (this.getAbTestMode() == null ? other.getAbTestMode() == null : this.getAbTestMode().equals(other.getAbTestMode()))
                && (this.getMediationAudienceSegment() == null ? other.getMediationAudienceSegment() == null : this.getMediationAudienceSegment().equals(other.getMediationAudienceSegment()))
                && (this.getMediationAudienceSegmentDay() == null ? other.getMediationAudienceSegmentDay() == null : this.getMediationAudienceSegmentDay().equals(other.getMediationAudienceSegmentDay()))
                && (this.getAudienceSegment() == null ? other.getAudienceSegment() == null : this.getAudienceSegment().equals(other.getAudienceSegment()))
                && (this.getAudienceSegmentExpected() == null ? other.getAudienceSegmentExpected() == null : this.getAudienceSegmentExpected().equals(other.getAudienceSegmentExpected()))
                && (this.getHbStatus() == null ? other.getHbStatus() == null : this.getHbStatus().equals(other.getHbStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastmodify() == null ? other.getLastmodify() == null : this.getLastmodify().equals(other.getLastmodify()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOldId() == null) ? 0 : getOldId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAdnId() == null) ? 0 : getAdnId().hashCode());
        result = prime * result + ((getAdnAppId() == null) ? 0 : getAdnAppId().hashCode());
        result = prime * result + ((getPubAppId() == null) ? 0 : getPubAppId().hashCode());
        result = prime * result + ((getPlacementId() == null) ? 0 : getPlacementId().hashCode());
        result = prime * result + ((getPlacementKey() == null) ? 0 : getPlacementKey().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getDescn() == null) ? 0 : getDescn().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOsvMax() == null) ? 0 : getOsvMax().hashCode());
        result = prime * result + ((getOsvMin() == null) ? 0 : getOsvMin().hashCode());
        result = prime * result + ((getFrequencyCap() == null) ? 0 : getFrequencyCap().hashCode());
        result = prime * result + ((getFrequencyUnit() == null) ? 0 : getFrequencyUnit().hashCode());
        result = prime * result + ((getFrequencyInterval() == null) ? 0 : getFrequencyInterval().hashCode());
        result = prime * result + ((getAbTestMode() == null) ? 0 : getAbTestMode().hashCode());
        result = prime * result + ((getMediationAudienceSegment() == null) ? 0 : getMediationAudienceSegment().hashCode());
        result = prime * result + ((getMediationAudienceSegmentDay() == null) ? 0 : getMediationAudienceSegmentDay().hashCode());
        result = prime * result + ((getAudienceSegment() == null) ? 0 : getAudienceSegment().hashCode());
        result = prime * result + ((getAudienceSegmentExpected() == null) ? 0 : getAudienceSegmentExpected().hashCode());
        result = prime * result + ((getHbStatus() == null) ? 0 : getHbStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastmodify() == null) ? 0 : getLastmodify().hashCode());
        return result;
    }
}