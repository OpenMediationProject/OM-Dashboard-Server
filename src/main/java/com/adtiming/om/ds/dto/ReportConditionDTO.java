// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * Created by ruandianbo on 20-2-18.
 */
public class ReportConditionDTO  implements Cloneable{

    protected static final Logger log = LogManager.getLogger();

    private String dateBegin;

    private String dateEnd;

    private Integer hourBegin;

    private Integer hourEnd;

    private String[] type;

    private String[] dimension;

    private Integer[] publisherId;

    private Integer[] pubAppId;

    private Byte[] platform;

    private String[] country;

    private Integer[] placementId;

    private Integer[] instanceId;

    private Integer[] sceneId;

    private Integer[] adnId;

    private Byte[] abt;

    private Integer[] abtId;

    private Byte[] bid;

    private Integer[] creativeId;

    private String[] appVersion;

    private String[] sdkVersion;

    private String osVersion;

    Set<String> dimensionSet;

    private Integer[] ruleId;

    @Override
    public ReportConditionDTO clone() {
        try {
            return (ReportConditionDTO) super.clone();
        } catch (CloneNotSupportedException e) {
            log.error("Clone ReportConditionDTO {} error:", JSONObject.toJSON(this), e);
        }
        return this;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(Integer hourBegin) {
        this.hourBegin = hourBegin;
    }

    public Integer getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Integer hourEnd) {
        this.hourEnd = hourEnd;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getDimension() {
        return dimension;
    }

    public void setDimension(String[] dimension) {
        this.dimension = dimension;
    }

    public Integer[] getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer[] publisherId) {
        this.publisherId = publisherId;
    }

    public Integer[] getPubAppId() {
        return pubAppId;
    }

    public void setPubAppId(Integer[] pubAppId) {
        this.pubAppId = pubAppId;
    }

    public Byte[] getPlatform() {
        return platform;
    }

    public void setPlatform(Byte[] platform) {
        this.platform = platform;
    }

    public String[] getCountry() {
        return country;
    }

    public void setCountry(String[] country) {
        this.country = country;
    }

    public Integer[] getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer[] placementId) {
        this.placementId = placementId;
    }

    public Integer[] getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Integer[] instanceId) {
        this.instanceId = instanceId;
    }

    public Integer[] getAdnId() {
        return adnId;
    }

    public void setAdnId(Integer[] adnId) {
        this.adnId = adnId;
    }

    public Integer[] getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer[] sceneId) {
        this.sceneId = sceneId;
    }

    public Byte[] getAbt() {
        return abt;
    }

    public void setAbt(Byte[] abt) {
        this.abt = abt;
    }

    public Integer[] getAbtId() {
        return abtId;
    }

    public void setAbtId(Integer[] abtId) {
        this.abtId = abtId;
    }

    public Byte[] getBid() {
        return bid;
    }

    public void setBid(Byte[] bid) {
        this.bid = bid;
    }

    public Integer[] getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(Integer[] creativeId) {
        this.creativeId = creativeId;
    }

    public String[] getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String[] appVersion) {
        this.appVersion = appVersion;
    }

    public String[] getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String[] sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Set<String> getDimensionSet() {
        return dimensionSet;
    }

    public void setDimensionSet(Set<String> dimensionSet) {
        this.dimensionSet = dimensionSet;
    }

    public Integer[] getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer[] ruleId) {
        this.ruleId = ruleId;
    }
}
