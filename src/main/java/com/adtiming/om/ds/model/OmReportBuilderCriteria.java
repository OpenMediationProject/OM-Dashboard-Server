// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmReportBuilderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmReportBuilderCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(Integer value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(Integer value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(Integer value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(Integer value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<Integer> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<Integer> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNull() {
            addCriterion("data_source is null");
            return (Criteria) this;
        }

        public Criteria andDataSourceIsNotNull() {
            addCriterion("data_source is not null");
            return (Criteria) this;
        }

        public Criteria andDataSourceEqualTo(Byte value) {
            addCriterion("data_source =", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotEqualTo(Byte value) {
            addCriterion("data_source <>", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThan(Byte value) {
            addCriterion("data_source >", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("data_source >=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThan(Byte value) {
            addCriterion("data_source <", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceLessThanOrEqualTo(Byte value) {
            addCriterion("data_source <=", value, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceIn(List<Byte> values) {
            addCriterion("data_source in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotIn(List<Byte> values) {
            addCriterion("data_source not in", values, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceBetween(Byte value1, Byte value2) {
            addCriterion("data_source between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andDataSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("data_source not between", value1, value2, "dataSource");
            return (Criteria) this;
        }

        public Criteria andRecipientsIsNull() {
            addCriterion("recipients is null");
            return (Criteria) this;
        }

        public Criteria andRecipientsIsNotNull() {
            addCriterion("recipients is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientsEqualTo(String value) {
            addCriterion("recipients =", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotEqualTo(String value) {
            addCriterion("recipients <>", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsGreaterThan(String value) {
            addCriterion("recipients >", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsGreaterThanOrEqualTo(String value) {
            addCriterion("recipients >=", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLessThan(String value) {
            addCriterion("recipients <", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLessThanOrEqualTo(String value) {
            addCriterion("recipients <=", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsLike(String value) {
            addCriterion("recipients like", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotLike(String value) {
            addCriterion("recipients not like", value, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsIn(List<String> values) {
            addCriterion("recipients in", values, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotIn(List<String> values) {
            addCriterion("recipients not in", values, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsBetween(String value1, String value2) {
            addCriterion("recipients between", value1, value2, "recipients");
            return (Criteria) this;
        }

        public Criteria andRecipientsNotBetween(String value1, String value2) {
            addCriterion("recipients not between", value1, value2, "recipients");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNull() {
            addCriterion("schedule is null");
            return (Criteria) this;
        }

        public Criteria andScheduleIsNotNull() {
            addCriterion("schedule is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleEqualTo(Integer value) {
            addCriterion("schedule =", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotEqualTo(Integer value) {
            addCriterion("schedule <>", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThan(Integer value) {
            addCriterion("schedule >", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleGreaterThanOrEqualTo(Integer value) {
            addCriterion("schedule >=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThan(Integer value) {
            addCriterion("schedule <", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleLessThanOrEqualTo(Integer value) {
            addCriterion("schedule <=", value, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleIn(List<Integer> values) {
            addCriterion("schedule in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotIn(List<Integer> values) {
            addCriterion("schedule not in", values, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleBetween(Integer value1, Integer value2) {
            addCriterion("schedule between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andScheduleNotBetween(Integer value1, Integer value2) {
            addCriterion("schedule not between", value1, value2, "schedule");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayIsNull() {
            addCriterion("weekly_day is null");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayIsNotNull() {
            addCriterion("weekly_day is not null");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayEqualTo(Byte value) {
            addCriterion("weekly_day =", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayNotEqualTo(Byte value) {
            addCriterion("weekly_day <>", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayGreaterThan(Byte value) {
            addCriterion("weekly_day >", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayGreaterThanOrEqualTo(Byte value) {
            addCriterion("weekly_day >=", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayLessThan(Byte value) {
            addCriterion("weekly_day <", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayLessThanOrEqualTo(Byte value) {
            addCriterion("weekly_day <=", value, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayIn(List<Byte> values) {
            addCriterion("weekly_day in", values, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayNotIn(List<Byte> values) {
            addCriterion("weekly_day not in", values, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayBetween(Byte value1, Byte value2) {
            addCriterion("weekly_day between", value1, value2, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andWeeklyDayNotBetween(Byte value1, Byte value2) {
            addCriterion("weekly_day not between", value1, value2, "weeklyDay");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDimensionsIsNull() {
            addCriterion("dimensions is null");
            return (Criteria) this;
        }

        public Criteria andDimensionsIsNotNull() {
            addCriterion("dimensions is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionsEqualTo(String value) {
            addCriterion("dimensions =", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotEqualTo(String value) {
            addCriterion("dimensions <>", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsGreaterThan(String value) {
            addCriterion("dimensions >", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsGreaterThanOrEqualTo(String value) {
            addCriterion("dimensions >=", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLessThan(String value) {
            addCriterion("dimensions <", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLessThanOrEqualTo(String value) {
            addCriterion("dimensions <=", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsLike(String value) {
            addCriterion("dimensions like", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotLike(String value) {
            addCriterion("dimensions not like", value, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsIn(List<String> values) {
            addCriterion("dimensions in", values, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotIn(List<String> values) {
            addCriterion("dimensions not in", values, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsBetween(String value1, String value2) {
            addCriterion("dimensions between", value1, value2, "dimensions");
            return (Criteria) this;
        }

        public Criteria andDimensionsNotBetween(String value1, String value2) {
            addCriterion("dimensions not between", value1, value2, "dimensions");
            return (Criteria) this;
        }

        public Criteria andMetricsIsNull() {
            addCriterion("metrics is null");
            return (Criteria) this;
        }

        public Criteria andMetricsIsNotNull() {
            addCriterion("metrics is not null");
            return (Criteria) this;
        }

        public Criteria andMetricsEqualTo(String value) {
            addCriterion("metrics =", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsNotEqualTo(String value) {
            addCriterion("metrics <>", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsGreaterThan(String value) {
            addCriterion("metrics >", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsGreaterThanOrEqualTo(String value) {
            addCriterion("metrics >=", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsLessThan(String value) {
            addCriterion("metrics <", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsLessThanOrEqualTo(String value) {
            addCriterion("metrics <=", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsLike(String value) {
            addCriterion("metrics like", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsNotLike(String value) {
            addCriterion("metrics not like", value, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsIn(List<String> values) {
            addCriterion("metrics in", values, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsNotIn(List<String> values) {
            addCriterion("metrics not in", values, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsBetween(String value1, String value2) {
            addCriterion("metrics between", value1, value2, "metrics");
            return (Criteria) this;
        }

        public Criteria andMetricsNotBetween(String value1, String value2) {
            addCriterion("metrics not between", value1, value2, "metrics");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodIsNull() {
            addCriterion("cond_day_period is null");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodIsNotNull() {
            addCriterion("cond_day_period is not null");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodEqualTo(Byte value) {
            addCriterion("cond_day_period =", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodNotEqualTo(Byte value) {
            addCriterion("cond_day_period <>", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodGreaterThan(Byte value) {
            addCriterion("cond_day_period >", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodGreaterThanOrEqualTo(Byte value) {
            addCriterion("cond_day_period >=", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodLessThan(Byte value) {
            addCriterion("cond_day_period <", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodLessThanOrEqualTo(Byte value) {
            addCriterion("cond_day_period <=", value, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodIn(List<Byte> values) {
            addCriterion("cond_day_period in", values, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodNotIn(List<Byte> values) {
            addCriterion("cond_day_period not in", values, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodBetween(Byte value1, Byte value2) {
            addCriterion("cond_day_period between", value1, value2, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondDayPeriodNotBetween(Byte value1, Byte value2) {
            addCriterion("cond_day_period not between", value1, value2, "condDayPeriod");
            return (Criteria) this;
        }

        public Criteria andCondAdnListIsNull() {
            addCriterion("cond_adn_list is null");
            return (Criteria) this;
        }

        public Criteria andCondAdnListIsNotNull() {
            addCriterion("cond_adn_list is not null");
            return (Criteria) this;
        }

        public Criteria andCondAdnListEqualTo(String value) {
            addCriterion("cond_adn_list =", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListNotEqualTo(String value) {
            addCriterion("cond_adn_list <>", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListGreaterThan(String value) {
            addCriterion("cond_adn_list >", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListGreaterThanOrEqualTo(String value) {
            addCriterion("cond_adn_list >=", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListLessThan(String value) {
            addCriterion("cond_adn_list <", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListLessThanOrEqualTo(String value) {
            addCriterion("cond_adn_list <=", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListLike(String value) {
            addCriterion("cond_adn_list like", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListNotLike(String value) {
            addCriterion("cond_adn_list not like", value, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListIn(List<String> values) {
            addCriterion("cond_adn_list in", values, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListNotIn(List<String> values) {
            addCriterion("cond_adn_list not in", values, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListBetween(String value1, String value2) {
            addCriterion("cond_adn_list between", value1, value2, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondAdnListNotBetween(String value1, String value2) {
            addCriterion("cond_adn_list not between", value1, value2, "condAdnList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListIsNull() {
            addCriterion("cond_country_list is null");
            return (Criteria) this;
        }

        public Criteria andCondCountryListIsNotNull() {
            addCriterion("cond_country_list is not null");
            return (Criteria) this;
        }

        public Criteria andCondCountryListEqualTo(String value) {
            addCriterion("cond_country_list =", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListNotEqualTo(String value) {
            addCriterion("cond_country_list <>", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListGreaterThan(String value) {
            addCriterion("cond_country_list >", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListGreaterThanOrEqualTo(String value) {
            addCriterion("cond_country_list >=", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListLessThan(String value) {
            addCriterion("cond_country_list <", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListLessThanOrEqualTo(String value) {
            addCriterion("cond_country_list <=", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListLike(String value) {
            addCriterion("cond_country_list like", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListNotLike(String value) {
            addCriterion("cond_country_list not like", value, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListIn(List<String> values) {
            addCriterion("cond_country_list in", values, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListNotIn(List<String> values) {
            addCriterion("cond_country_list not in", values, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListBetween(String value1, String value2) {
            addCriterion("cond_country_list between", value1, value2, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCondCountryListNotBetween(String value1, String value2) {
            addCriterion("cond_country_list not between", value1, value2, "condCountryList");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNull() {
            addCriterion("execute_times is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIsNotNull() {
            addCriterion("execute_times is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesEqualTo(Integer value) {
            addCriterion("execute_times =", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotEqualTo(Integer value) {
            addCriterion("execute_times <>", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThan(Integer value) {
            addCriterion("execute_times >", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("execute_times >=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThan(Integer value) {
            addCriterion("execute_times <", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("execute_times <=", value, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesIn(List<Integer> values) {
            addCriterion("execute_times in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotIn(List<Integer> values) {
            addCriterion("execute_times not in", values, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesBetween(Integer value1, Integer value2) {
            addCriterion("execute_times between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andExecuteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("execute_times not between", value1, value2, "executeTimes");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIsNull() {
            addCriterion("last_execute_time is null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIsNotNull() {
            addCriterion("last_execute_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeEqualTo(Date value) {
            addCriterion("last_execute_time =", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotEqualTo(Date value) {
            addCriterion("last_execute_time <>", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeGreaterThan(Date value) {
            addCriterion("last_execute_time >", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_execute_time >=", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeLessThan(Date value) {
            addCriterion("last_execute_time <", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_execute_time <=", value, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeIn(List<Date> values) {
            addCriterion("last_execute_time in", values, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotIn(List<Date> values) {
            addCriterion("last_execute_time not in", values, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("last_execute_time between", value1, value2, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_execute_time not between", value1, value2, "lastExecuteTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifyIsNull() {
            addCriterion("lastmodify is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifyIsNotNull() {
            addCriterion("lastmodify is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifyEqualTo(Date value) {
            addCriterion("lastmodify =", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyNotEqualTo(Date value) {
            addCriterion("lastmodify <>", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyGreaterThan(Date value) {
            addCriterion("lastmodify >", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyGreaterThanOrEqualTo(Date value) {
            addCriterion("lastmodify >=", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyLessThan(Date value) {
            addCriterion("lastmodify <", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyLessThanOrEqualTo(Date value) {
            addCriterion("lastmodify <=", value, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyIn(List<Date> values) {
            addCriterion("lastmodify in", values, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyNotIn(List<Date> values) {
            addCriterion("lastmodify not in", values, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyBetween(Date value1, Date value2) {
            addCriterion("lastmodify between", value1, value2, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andLastmodifyNotBetween(Date value1, Date value2) {
            addCriterion("lastmodify not between", value1, value2, "lastmodify");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}