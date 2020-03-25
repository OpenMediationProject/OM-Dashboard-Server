// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.dto;

import com.adtiming.om.ds.model.OmReportBuilderWithBLOBs;
import org.apache.commons.lang.StringUtils;

/**
 * Created by ruandianbo on 20-2-27.
 */
public class ReportBuilderDTO {

    public static final String SPLIT_TAG = ",";

    private Integer id;

    private Integer publisherId;

    private String name;

    private Byte dataSource;

    private String recipients;

    private Integer schedule;

    private Byte weeklyDay;

    private Integer status;

    private String[] dimensions;

    private String[] metrics;

    private Byte condDayPeriod;

    private Integer creatorId;

    private Integer[] condPubAppList;

    private Integer[] condPlacementList;

    private Integer[] condInstanceList;

    private Integer[] condAdnList;

    private String[] condCountryList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getDataSource() {
        return dataSource;
    }

    public void setDataSource(Byte dataSource) {
        this.dataSource = dataSource;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
    }

    public Byte getWeeklyDay() {
        return weeklyDay;
    }

    public void setWeeklyDay(Byte weeklyDay) {
        this.weeklyDay = weeklyDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(String[] dimensions) {
        this.dimensions = dimensions;
    }

    public String[] getMetrics() {
        return metrics;
    }

    public void setMetrics(String[] metrics) {
        this.metrics = metrics;
    }

    public Byte getCondDayPeriod() {
        return condDayPeriod;
    }

    public void setCondDayPeriod(Byte condDayPeriod) {
        this.condDayPeriod = condDayPeriod;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer[] getCondPubAppList() {
        return condPubAppList;
    }

    public void setCondPubAppList(Integer[] condPubAppList) {
        this.condPubAppList = condPubAppList;
    }

    public Integer[] getCondPlacementList() {
        return condPlacementList;
    }

    public void setCondPlacementList(Integer[] condPlacementList) {
        this.condPlacementList = condPlacementList;
    }

    public Integer[] getCondInstanceList() {
        return condInstanceList;
    }

    public void setCondInstanceList(Integer[] condInstanceList) {
        this.condInstanceList = condInstanceList;
    }

    public Integer[] getCondAdnList() {
        return condAdnList;
    }

    public void setCondAdnList(Integer[] condAdnList) {
        this.condAdnList = condAdnList;
    }

    public String[] getCondCountryList() {
        return condCountryList;
    }

    public void setCondCountryList(String[] condCountryList) {
        this.condCountryList = condCountryList;
    }

    public OmReportBuilderWithBLOBs build() {
        OmReportBuilderWithBLOBs reportBuilder = new OmReportBuilderWithBLOBs();
        reportBuilder.setId(this.id);
        reportBuilder.setPublisherId(this.publisherId);
        reportBuilder.setName(this.name);
        reportBuilder.setDataSource(this.dataSource);
        reportBuilder.setRecipients(this.recipients);
        reportBuilder.setSchedule(this.schedule);
        reportBuilder.setWeeklyDay(this.weeklyDay);
        reportBuilder.setStatus(this.status);
        if (dimensions != null && dimensions.length > 0) {
            reportBuilder.setDimensions(StringUtils.join(this.dimensions, SPLIT_TAG));
        }
        if (metrics != null && metrics.length > 0) {
            reportBuilder.setMetrics(StringUtils.join(this.metrics, SPLIT_TAG));
        }
        reportBuilder.setCondDayPeriod(this.condDayPeriod);
        reportBuilder.setCreatorId(this.creatorId);
        if (condPubAppList != null && condPubAppList.length > 0) {
            reportBuilder.setCondPubAppList(StringUtils.join(this.condPubAppList, SPLIT_TAG));
        }
        if (condPlacementList != null && condPlacementList.length > 0) {
            reportBuilder.setCondPlacementList(StringUtils.join(this.condPlacementList, SPLIT_TAG));
        }
        if (condInstanceList != null && condInstanceList.length > 0) {
            reportBuilder.setCondInstanceList(StringUtils.join(this.condInstanceList, SPLIT_TAG));
        }
        if (condAdnList != null && condAdnList.length > 0) {
            reportBuilder.setCondAdnList(StringUtils.join(this.condAdnList, SPLIT_TAG));
        }
        if (condCountryList != null && condCountryList.length > 0) {
            reportBuilder.setCondCountryList(StringUtils.join(this.condCountryList, SPLIT_TAG));
        }

        return reportBuilder;
    }
}
