// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatUserLtvCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatUserLtvCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Date value) {
            addCriterionForJDBCDate("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Date value) {
            addCriterionForJDBCDate("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Date value) {
            addCriterionForJDBCDate("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Date> values) {
            addCriterionForJDBCDate("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andBaseDateIsNull() {
            addCriterion("base_date is null");
            return (Criteria) this;
        }

        public Criteria andBaseDateIsNotNull() {
            addCriterion("base_date is not null");
            return (Criteria) this;
        }

        public Criteria andBaseDateEqualTo(Date value) {
            addCriterionForJDBCDate("base_date =", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("base_date <>", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("base_date >", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("base_date >=", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateLessThan(Date value) {
            addCriterionForJDBCDate("base_date <", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("base_date <=", value, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateIn(List<Date> values) {
            addCriterionForJDBCDate("base_date in", values, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("base_date not in", values, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("base_date between", value1, value2, "baseDate");
            return (Criteria) this;
        }

        public Criteria andBaseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("base_date not between", value1, value2, "baseDate");
            return (Criteria) this;
        }

        public Criteria andRetentionDayIsNull() {
            addCriterion("retention_day is null");
            return (Criteria) this;
        }

        public Criteria andRetentionDayIsNotNull() {
            addCriterion("retention_day is not null");
            return (Criteria) this;
        }

        public Criteria andRetentionDayEqualTo(Integer value) {
            addCriterion("retention_day =", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayNotEqualTo(Integer value) {
            addCriterion("retention_day <>", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayGreaterThan(Integer value) {
            addCriterion("retention_day >", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("retention_day >=", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayLessThan(Integer value) {
            addCriterion("retention_day <", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayLessThanOrEqualTo(Integer value) {
            addCriterion("retention_day <=", value, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayIn(List<Integer> values) {
            addCriterion("retention_day in", values, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayNotIn(List<Integer> values) {
            addCriterion("retention_day not in", values, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayBetween(Integer value1, Integer value2) {
            addCriterion("retention_day between", value1, value2, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andRetentionDayNotBetween(Integer value1, Integer value2) {
            addCriterion("retention_day not between", value1, value2, "retentionDay");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
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

        public Criteria andPubAppIdIsNull() {
            addCriterion("pub_app_id is null");
            return (Criteria) this;
        }

        public Criteria andPubAppIdIsNotNull() {
            addCriterion("pub_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andPubAppIdEqualTo(Integer value) {
            addCriterion("pub_app_id =", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdNotEqualTo(Integer value) {
            addCriterion("pub_app_id <>", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdGreaterThan(Integer value) {
            addCriterion("pub_app_id >", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pub_app_id >=", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdLessThan(Integer value) {
            addCriterion("pub_app_id <", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("pub_app_id <=", value, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdIn(List<Integer> values) {
            addCriterion("pub_app_id in", values, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdNotIn(List<Integer> values) {
            addCriterion("pub_app_id not in", values, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdBetween(Integer value1, Integer value2) {
            addCriterion("pub_app_id between", value1, value2, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andPubAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pub_app_id not between", value1, value2, "pubAppId");
            return (Criteria) this;
        }

        public Criteria andUserCntNewIsNull() {
            addCriterion("user_cnt_new is null");
            return (Criteria) this;
        }

        public Criteria andUserCntNewIsNotNull() {
            addCriterion("user_cnt_new is not null");
            return (Criteria) this;
        }

        public Criteria andUserCntNewEqualTo(Long value) {
            addCriterion("user_cnt_new =", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewNotEqualTo(Long value) {
            addCriterion("user_cnt_new <>", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewGreaterThan(Long value) {
            addCriterion("user_cnt_new >", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewGreaterThanOrEqualTo(Long value) {
            addCriterion("user_cnt_new >=", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewLessThan(Long value) {
            addCriterion("user_cnt_new <", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewLessThanOrEqualTo(Long value) {
            addCriterion("user_cnt_new <=", value, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewIn(List<Long> values) {
            addCriterion("user_cnt_new in", values, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewNotIn(List<Long> values) {
            addCriterion("user_cnt_new not in", values, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewBetween(Long value1, Long value2) {
            addCriterion("user_cnt_new between", value1, value2, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntNewNotBetween(Long value1, Long value2) {
            addCriterion("user_cnt_new not between", value1, value2, "userCntNew");
            return (Criteria) this;
        }

        public Criteria andUserCntOldIsNull() {
            addCriterion("user_cnt_old is null");
            return (Criteria) this;
        }

        public Criteria andUserCntOldIsNotNull() {
            addCriterion("user_cnt_old is not null");
            return (Criteria) this;
        }

        public Criteria andUserCntOldEqualTo(Long value) {
            addCriterion("user_cnt_old =", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldNotEqualTo(Long value) {
            addCriterion("user_cnt_old <>", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldGreaterThan(Long value) {
            addCriterion("user_cnt_old >", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldGreaterThanOrEqualTo(Long value) {
            addCriterion("user_cnt_old >=", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldLessThan(Long value) {
            addCriterion("user_cnt_old <", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldLessThanOrEqualTo(Long value) {
            addCriterion("user_cnt_old <=", value, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldIn(List<Long> values) {
            addCriterion("user_cnt_old in", values, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldNotIn(List<Long> values) {
            addCriterion("user_cnt_old not in", values, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldBetween(Long value1, Long value2) {
            addCriterion("user_cnt_old between", value1, value2, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andUserCntOldNotBetween(Long value1, Long value2) {
            addCriterion("user_cnt_old not between", value1, value2, "userCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewIsNull() {
            addCriterion("retention_cnt_new is null");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewIsNotNull() {
            addCriterion("retention_cnt_new is not null");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewEqualTo(Long value) {
            addCriterion("retention_cnt_new =", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewNotEqualTo(Long value) {
            addCriterion("retention_cnt_new <>", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewGreaterThan(Long value) {
            addCriterion("retention_cnt_new >", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewGreaterThanOrEqualTo(Long value) {
            addCriterion("retention_cnt_new >=", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewLessThan(Long value) {
            addCriterion("retention_cnt_new <", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewLessThanOrEqualTo(Long value) {
            addCriterion("retention_cnt_new <=", value, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewIn(List<Long> values) {
            addCriterion("retention_cnt_new in", values, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewNotIn(List<Long> values) {
            addCriterion("retention_cnt_new not in", values, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewBetween(Long value1, Long value2) {
            addCriterion("retention_cnt_new between", value1, value2, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntNewNotBetween(Long value1, Long value2) {
            addCriterion("retention_cnt_new not between", value1, value2, "retentionCntNew");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldIsNull() {
            addCriterion("retention_cnt_old is null");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldIsNotNull() {
            addCriterion("retention_cnt_old is not null");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldEqualTo(Long value) {
            addCriterion("retention_cnt_old =", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldNotEqualTo(Long value) {
            addCriterion("retention_cnt_old <>", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldGreaterThan(Long value) {
            addCriterion("retention_cnt_old >", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldGreaterThanOrEqualTo(Long value) {
            addCriterion("retention_cnt_old >=", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldLessThan(Long value) {
            addCriterion("retention_cnt_old <", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldLessThanOrEqualTo(Long value) {
            addCriterion("retention_cnt_old <=", value, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldIn(List<Long> values) {
            addCriterion("retention_cnt_old in", values, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldNotIn(List<Long> values) {
            addCriterion("retention_cnt_old not in", values, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldBetween(Long value1, Long value2) {
            addCriterion("retention_cnt_old between", value1, value2, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andRetentionCntOldNotBetween(Long value1, Long value2) {
            addCriterion("retention_cnt_old not between", value1, value2, "retentionCntOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewIsNull() {
            addCriterion("mediation_value_new is null");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewIsNotNull() {
            addCriterion("mediation_value_new is not null");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewEqualTo(BigDecimal value) {
            addCriterion("mediation_value_new =", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewNotEqualTo(BigDecimal value) {
            addCriterion("mediation_value_new <>", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewGreaterThan(BigDecimal value) {
            addCriterion("mediation_value_new >", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mediation_value_new >=", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewLessThan(BigDecimal value) {
            addCriterion("mediation_value_new <", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mediation_value_new <=", value, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewIn(List<BigDecimal> values) {
            addCriterion("mediation_value_new in", values, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewNotIn(List<BigDecimal> values) {
            addCriterion("mediation_value_new not in", values, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mediation_value_new between", value1, value2, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mediation_value_new not between", value1, value2, "mediationValueNew");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldIsNull() {
            addCriterion("mediation_value_old is null");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldIsNotNull() {
            addCriterion("mediation_value_old is not null");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldEqualTo(BigDecimal value) {
            addCriterion("mediation_value_old =", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldNotEqualTo(BigDecimal value) {
            addCriterion("mediation_value_old <>", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldGreaterThan(BigDecimal value) {
            addCriterion("mediation_value_old >", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mediation_value_old >=", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldLessThan(BigDecimal value) {
            addCriterion("mediation_value_old <", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mediation_value_old <=", value, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldIn(List<BigDecimal> values) {
            addCriterion("mediation_value_old in", values, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldNotIn(List<BigDecimal> values) {
            addCriterion("mediation_value_old not in", values, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mediation_value_old between", value1, value2, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andMediationValueOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mediation_value_old not between", value1, value2, "mediationValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueNewIsNull() {
            addCriterion("iap_value_new is null");
            return (Criteria) this;
        }

        public Criteria andIapValueNewIsNotNull() {
            addCriterion("iap_value_new is not null");
            return (Criteria) this;
        }

        public Criteria andIapValueNewEqualTo(BigDecimal value) {
            addCriterion("iap_value_new =", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewNotEqualTo(BigDecimal value) {
            addCriterion("iap_value_new <>", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewGreaterThan(BigDecimal value) {
            addCriterion("iap_value_new >", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_value_new >=", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewLessThan(BigDecimal value) {
            addCriterion("iap_value_new <", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_value_new <=", value, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewIn(List<BigDecimal> values) {
            addCriterion("iap_value_new in", values, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewNotIn(List<BigDecimal> values) {
            addCriterion("iap_value_new not in", values, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_value_new between", value1, value2, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_value_new not between", value1, value2, "iapValueNew");
            return (Criteria) this;
        }

        public Criteria andIapValueOldIsNull() {
            addCriterion("iap_value_old is null");
            return (Criteria) this;
        }

        public Criteria andIapValueOldIsNotNull() {
            addCriterion("iap_value_old is not null");
            return (Criteria) this;
        }

        public Criteria andIapValueOldEqualTo(BigDecimal value) {
            addCriterion("iap_value_old =", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldNotEqualTo(BigDecimal value) {
            addCriterion("iap_value_old <>", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldGreaterThan(BigDecimal value) {
            addCriterion("iap_value_old >", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_value_old >=", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldLessThan(BigDecimal value) {
            addCriterion("iap_value_old <", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_value_old <=", value, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldIn(List<BigDecimal> values) {
            addCriterion("iap_value_old in", values, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldNotIn(List<BigDecimal> values) {
            addCriterion("iap_value_old not in", values, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_value_old between", value1, value2, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andIapValueOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_value_old not between", value1, value2, "iapValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewIsNull() {
            addCriterion("total_value_new is null");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewIsNotNull() {
            addCriterion("total_value_new is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewEqualTo(BigDecimal value) {
            addCriterion("total_value_new =", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewNotEqualTo(BigDecimal value) {
            addCriterion("total_value_new <>", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewGreaterThan(BigDecimal value) {
            addCriterion("total_value_new >", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_value_new >=", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewLessThan(BigDecimal value) {
            addCriterion("total_value_new <", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_value_new <=", value, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewIn(List<BigDecimal> values) {
            addCriterion("total_value_new in", values, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewNotIn(List<BigDecimal> values) {
            addCriterion("total_value_new not in", values, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_value_new between", value1, value2, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_value_new not between", value1, value2, "totalValueNew");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldIsNull() {
            addCriterion("total_value_old is null");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldIsNotNull() {
            addCriterion("total_value_old is not null");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldEqualTo(BigDecimal value) {
            addCriterion("total_value_old =", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldNotEqualTo(BigDecimal value) {
            addCriterion("total_value_old <>", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldGreaterThan(BigDecimal value) {
            addCriterion("total_value_old >", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_value_old >=", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldLessThan(BigDecimal value) {
            addCriterion("total_value_old <", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_value_old <=", value, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldIn(List<BigDecimal> values) {
            addCriterion("total_value_old in", values, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldNotIn(List<BigDecimal> values) {
            addCriterion("total_value_old not in", values, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_value_old between", value1, value2, "totalValueOld");
            return (Criteria) this;
        }

        public Criteria andTotalValueOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_value_old not between", value1, value2, "totalValueOld");
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
    }
}