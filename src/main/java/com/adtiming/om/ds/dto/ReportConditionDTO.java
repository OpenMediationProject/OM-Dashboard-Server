// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

/**
 * Created by ruandianbo on 20-2-18.
 */
public class ReportConditionDTO {

    private String dateBegin;

    private String dateEnd;

    private String[] type;

    private String[] dimension;

    private Integer[] publisherId;

    private Integer[] pubAppId;

    private Byte[] platform;

    private String[] country;

    private Integer[] placementId;

    private Integer[] instanceId;

    private Integer[] adnId;

    private Byte[] abt;

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

    public Byte[] getAbt() {
        return abt;
    }

    public void setAbt(Byte[] abt) {
        this.abt = abt;
    }
}
