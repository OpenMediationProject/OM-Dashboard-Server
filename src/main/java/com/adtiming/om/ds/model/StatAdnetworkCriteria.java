// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatAdnetworkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatAdnetworkCriteria() {
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

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(Byte value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(Byte value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(Byte value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(Byte value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(Byte value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(Byte value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<Byte> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<Byte> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(Byte value1, Byte value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(Byte value1, Byte value2) {
            addCriterion("hour not between", value1, value2, "hour");
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

        public Criteria andPlatformIsNull() {
            addCriterion("platform is null");
            return (Criteria) this;
        }

        public Criteria andPlatformIsNotNull() {
            addCriterion("platform is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformEqualTo(Byte value) {
            addCriterion("platform =", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotEqualTo(Byte value) {
            addCriterion("platform <>", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThan(Byte value) {
            addCriterion("platform >", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformGreaterThanOrEqualTo(Byte value) {
            addCriterion("platform >=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThan(Byte value) {
            addCriterion("platform <", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformLessThanOrEqualTo(Byte value) {
            addCriterion("platform <=", value, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformIn(List<Byte> values) {
            addCriterion("platform in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotIn(List<Byte> values) {
            addCriterion("platform not in", values, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformBetween(Byte value1, Byte value2) {
            addCriterion("platform between", value1, value2, "platform");
            return (Criteria) this;
        }

        public Criteria andPlatformNotBetween(Byte value1, Byte value2) {
            addCriterion("platform not between", value1, value2, "platform");
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

        public Criteria andPlacementIdIsNull() {
            addCriterion("placement_id is null");
            return (Criteria) this;
        }

        public Criteria andPlacementIdIsNotNull() {
            addCriterion("placement_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlacementIdEqualTo(Integer value) {
            addCriterion("placement_id =", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdNotEqualTo(Integer value) {
            addCriterion("placement_id <>", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdGreaterThan(Integer value) {
            addCriterion("placement_id >", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("placement_id >=", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdLessThan(Integer value) {
            addCriterion("placement_id <", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdLessThanOrEqualTo(Integer value) {
            addCriterion("placement_id <=", value, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdIn(List<Integer> values) {
            addCriterion("placement_id in", values, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdNotIn(List<Integer> values) {
            addCriterion("placement_id not in", values, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdBetween(Integer value1, Integer value2) {
            addCriterion("placement_id between", value1, value2, "placementId");
            return (Criteria) this;
        }

        public Criteria andPlacementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("placement_id not between", value1, value2, "placementId");
            return (Criteria) this;
        }

        public Criteria andAdTypeIsNull() {
            addCriterion("ad_type is null");
            return (Criteria) this;
        }

        public Criteria andAdTypeIsNotNull() {
            addCriterion("ad_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdTypeEqualTo(Byte value) {
            addCriterion("ad_type =", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotEqualTo(Byte value) {
            addCriterion("ad_type <>", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThan(Byte value) {
            addCriterion("ad_type >", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ad_type >=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThan(Byte value) {
            addCriterion("ad_type <", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeLessThanOrEqualTo(Byte value) {
            addCriterion("ad_type <=", value, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeIn(List<Byte> values) {
            addCriterion("ad_type in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotIn(List<Byte> values) {
            addCriterion("ad_type not in", values, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeBetween(Byte value1, Byte value2) {
            addCriterion("ad_type between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andAdTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ad_type not between", value1, value2, "adType");
            return (Criteria) this;
        }

        public Criteria andAdnIdIsNull() {
            addCriterion("adn_id is null");
            return (Criteria) this;
        }

        public Criteria andAdnIdIsNotNull() {
            addCriterion("adn_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdnIdEqualTo(Integer value) {
            addCriterion("adn_id =", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotEqualTo(Integer value) {
            addCriterion("adn_id <>", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdGreaterThan(Integer value) {
            addCriterion("adn_id >", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adn_id >=", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdLessThan(Integer value) {
            addCriterion("adn_id <", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdLessThanOrEqualTo(Integer value) {
            addCriterion("adn_id <=", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdIn(List<Integer> values) {
            addCriterion("adn_id in", values, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotIn(List<Integer> values) {
            addCriterion("adn_id not in", values, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdBetween(Integer value1, Integer value2) {
            addCriterion("adn_id between", value1, value2, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adn_id not between", value1, value2, "adnId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(Integer value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(Integer value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(Integer value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(Integer value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<Integer> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<Integer> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(Integer value1, Integer value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Byte value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Byte value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Byte value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Byte value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Byte value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Byte value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Byte> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Byte> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Byte value1, Byte value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Byte value1, Byte value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andAbtIsNull() {
            addCriterion("abt is null");
            return (Criteria) this;
        }

        public Criteria andAbtIsNotNull() {
            addCriterion("abt is not null");
            return (Criteria) this;
        }

        public Criteria andAbtEqualTo(Byte value) {
            addCriterion("abt =", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtNotEqualTo(Byte value) {
            addCriterion("abt <>", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtGreaterThan(Byte value) {
            addCriterion("abt >", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtGreaterThanOrEqualTo(Byte value) {
            addCriterion("abt >=", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtLessThan(Byte value) {
            addCriterion("abt <", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtLessThanOrEqualTo(Byte value) {
            addCriterion("abt <=", value, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtIn(List<Byte> values) {
            addCriterion("abt in", values, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtNotIn(List<Byte> values) {
            addCriterion("abt not in", values, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtBetween(Byte value1, Byte value2) {
            addCriterion("abt between", value1, value2, "abt");
            return (Criteria) this;
        }

        public Criteria andAbtNotBetween(Byte value1, Byte value2) {
            addCriterion("abt not between", value1, value2, "abt");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNull() {
            addCriterion("exchange_rate is null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIsNotNull() {
            addCriterion("exchange_rate is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeRateEqualTo(BigDecimal value) {
            addCriterion("exchange_rate =", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <>", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThan(BigDecimal value) {
            addCriterion("exchange_rate >", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate >=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThan(BigDecimal value) {
            addCriterion("exchange_rate <", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exchange_rate <=", value, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateIn(List<BigDecimal> values) {
            addCriterion("exchange_rate in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotIn(List<BigDecimal> values) {
            addCriterion("exchange_rate not in", values, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andExchangeRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exchange_rate not between", value1, value2, "exchangeRate");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(BigDecimal value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(BigDecimal value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(BigDecimal value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(BigDecimal value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<BigDecimal> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<BigDecimal> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostOriIsNull() {
            addCriterion("cost_ori is null");
            return (Criteria) this;
        }

        public Criteria andCostOriIsNotNull() {
            addCriterion("cost_ori is not null");
            return (Criteria) this;
        }

        public Criteria andCostOriEqualTo(BigDecimal value) {
            addCriterion("cost_ori =", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriNotEqualTo(BigDecimal value) {
            addCriterion("cost_ori <>", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriGreaterThan(BigDecimal value) {
            addCriterion("cost_ori >", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_ori >=", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriLessThan(BigDecimal value) {
            addCriterion("cost_ori <", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_ori <=", value, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriIn(List<BigDecimal> values) {
            addCriterion("cost_ori in", values, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriNotIn(List<BigDecimal> values) {
            addCriterion("cost_ori not in", values, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_ori between", value1, value2, "costOri");
            return (Criteria) this;
        }

        public Criteria andCostOriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_ori not between", value1, value2, "costOri");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNull() {
            addCriterion("revenue is null");
            return (Criteria) this;
        }

        public Criteria andRevenueIsNotNull() {
            addCriterion("revenue is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueEqualTo(BigDecimal value) {
            addCriterion("revenue =", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotEqualTo(BigDecimal value) {
            addCriterion("revenue <>", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThan(BigDecimal value) {
            addCriterion("revenue >", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue >=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThan(BigDecimal value) {
            addCriterion("revenue <", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue <=", value, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueIn(List<BigDecimal> values) {
            addCriterion("revenue in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotIn(List<BigDecimal> values) {
            addCriterion("revenue not in", values, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue not between", value1, value2, "revenue");
            return (Criteria) this;
        }

        public Criteria andRevenueOriIsNull() {
            addCriterion("revenue_ori is null");
            return (Criteria) this;
        }

        public Criteria andRevenueOriIsNotNull() {
            addCriterion("revenue_ori is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueOriEqualTo(BigDecimal value) {
            addCriterion("revenue_ori =", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriNotEqualTo(BigDecimal value) {
            addCriterion("revenue_ori <>", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriGreaterThan(BigDecimal value) {
            addCriterion("revenue_ori >", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_ori >=", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriLessThan(BigDecimal value) {
            addCriterion("revenue_ori <", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_ori <=", value, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriIn(List<BigDecimal> values) {
            addCriterion("revenue_ori in", values, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriNotIn(List<BigDecimal> values) {
            addCriterion("revenue_ori not in", values, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_ori between", value1, value2, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andRevenueOriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_ori not between", value1, value2, "revenueOri");
            return (Criteria) this;
        }

        public Criteria andApiRequestIsNull() {
            addCriterion("api_request is null");
            return (Criteria) this;
        }

        public Criteria andApiRequestIsNotNull() {
            addCriterion("api_request is not null");
            return (Criteria) this;
        }

        public Criteria andApiRequestEqualTo(Integer value) {
            addCriterion("api_request =", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestNotEqualTo(Integer value) {
            addCriterion("api_request <>", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestGreaterThan(Integer value) {
            addCriterion("api_request >", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_request >=", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestLessThan(Integer value) {
            addCriterion("api_request <", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestLessThanOrEqualTo(Integer value) {
            addCriterion("api_request <=", value, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestIn(List<Integer> values) {
            addCriterion("api_request in", values, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestNotIn(List<Integer> values) {
            addCriterion("api_request not in", values, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestBetween(Integer value1, Integer value2) {
            addCriterion("api_request between", value1, value2, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiRequestNotBetween(Integer value1, Integer value2) {
            addCriterion("api_request not between", value1, value2, "apiRequest");
            return (Criteria) this;
        }

        public Criteria andApiFilledIsNull() {
            addCriterion("api_filled is null");
            return (Criteria) this;
        }

        public Criteria andApiFilledIsNotNull() {
            addCriterion("api_filled is not null");
            return (Criteria) this;
        }

        public Criteria andApiFilledEqualTo(Integer value) {
            addCriterion("api_filled =", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledNotEqualTo(Integer value) {
            addCriterion("api_filled <>", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledGreaterThan(Integer value) {
            addCriterion("api_filled >", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_filled >=", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledLessThan(Integer value) {
            addCriterion("api_filled <", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledLessThanOrEqualTo(Integer value) {
            addCriterion("api_filled <=", value, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledIn(List<Integer> values) {
            addCriterion("api_filled in", values, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledNotIn(List<Integer> values) {
            addCriterion("api_filled not in", values, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledBetween(Integer value1, Integer value2) {
            addCriterion("api_filled between", value1, value2, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiFilledNotBetween(Integer value1, Integer value2) {
            addCriterion("api_filled not between", value1, value2, "apiFilled");
            return (Criteria) this;
        }

        public Criteria andApiClickIsNull() {
            addCriterion("api_click is null");
            return (Criteria) this;
        }

        public Criteria andApiClickIsNotNull() {
            addCriterion("api_click is not null");
            return (Criteria) this;
        }

        public Criteria andApiClickEqualTo(Integer value) {
            addCriterion("api_click =", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickNotEqualTo(Integer value) {
            addCriterion("api_click <>", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickGreaterThan(Integer value) {
            addCriterion("api_click >", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_click >=", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickLessThan(Integer value) {
            addCriterion("api_click <", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickLessThanOrEqualTo(Integer value) {
            addCriterion("api_click <=", value, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickIn(List<Integer> values) {
            addCriterion("api_click in", values, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickNotIn(List<Integer> values) {
            addCriterion("api_click not in", values, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickBetween(Integer value1, Integer value2) {
            addCriterion("api_click between", value1, value2, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiClickNotBetween(Integer value1, Integer value2) {
            addCriterion("api_click not between", value1, value2, "apiClick");
            return (Criteria) this;
        }

        public Criteria andApiImprIsNull() {
            addCriterion("api_impr is null");
            return (Criteria) this;
        }

        public Criteria andApiImprIsNotNull() {
            addCriterion("api_impr is not null");
            return (Criteria) this;
        }

        public Criteria andApiImprEqualTo(Integer value) {
            addCriterion("api_impr =", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprNotEqualTo(Integer value) {
            addCriterion("api_impr <>", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprGreaterThan(Integer value) {
            addCriterion("api_impr >", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_impr >=", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprLessThan(Integer value) {
            addCriterion("api_impr <", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprLessThanOrEqualTo(Integer value) {
            addCriterion("api_impr <=", value, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprIn(List<Integer> values) {
            addCriterion("api_impr in", values, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprNotIn(List<Integer> values) {
            addCriterion("api_impr not in", values, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprBetween(Integer value1, Integer value2) {
            addCriterion("api_impr between", value1, value2, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiImprNotBetween(Integer value1, Integer value2) {
            addCriterion("api_impr not between", value1, value2, "apiImpr");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartIsNull() {
            addCriterion("api_video_start is null");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartIsNotNull() {
            addCriterion("api_video_start is not null");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartEqualTo(Integer value) {
            addCriterion("api_video_start =", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartNotEqualTo(Integer value) {
            addCriterion("api_video_start <>", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartGreaterThan(Integer value) {
            addCriterion("api_video_start >", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_video_start >=", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartLessThan(Integer value) {
            addCriterion("api_video_start <", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartLessThanOrEqualTo(Integer value) {
            addCriterion("api_video_start <=", value, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartIn(List<Integer> values) {
            addCriterion("api_video_start in", values, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartNotIn(List<Integer> values) {
            addCriterion("api_video_start not in", values, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartBetween(Integer value1, Integer value2) {
            addCriterion("api_video_start between", value1, value2, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoStartNotBetween(Integer value1, Integer value2) {
            addCriterion("api_video_start not between", value1, value2, "apiVideoStart");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteIsNull() {
            addCriterion("api_video_complete is null");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteIsNotNull() {
            addCriterion("api_video_complete is not null");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteEqualTo(Integer value) {
            addCriterion("api_video_complete =", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteNotEqualTo(Integer value) {
            addCriterion("api_video_complete <>", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteGreaterThan(Integer value) {
            addCriterion("api_video_complete >", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("api_video_complete >=", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteLessThan(Integer value) {
            addCriterion("api_video_complete <", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("api_video_complete <=", value, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteIn(List<Integer> values) {
            addCriterion("api_video_complete in", values, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteNotIn(List<Integer> values) {
            addCriterion("api_video_complete not in", values, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteBetween(Integer value1, Integer value2) {
            addCriterion("api_video_complete between", value1, value2, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andApiVideoCompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("api_video_complete not between", value1, value2, "apiVideoComplete");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerIsNull() {
            addCriterion("account_owner is null");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerIsNotNull() {
            addCriterion("account_owner is not null");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerEqualTo(Byte value) {
            addCriterion("account_owner =", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerNotEqualTo(Byte value) {
            addCriterion("account_owner <>", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerGreaterThan(Byte value) {
            addCriterion("account_owner >", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerGreaterThanOrEqualTo(Byte value) {
            addCriterion("account_owner >=", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerLessThan(Byte value) {
            addCriterion("account_owner <", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerLessThanOrEqualTo(Byte value) {
            addCriterion("account_owner <=", value, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerIn(List<Byte> values) {
            addCriterion("account_owner in", values, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerNotIn(List<Byte> values) {
            addCriterion("account_owner not in", values, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerBetween(Byte value1, Byte value2) {
            addCriterion("account_owner between", value1, value2, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andAccountOwnerNotBetween(Byte value1, Byte value2) {
            addCriterion("account_owner not between", value1, value2, "accountOwner");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Byte value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Byte value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Byte value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Byte value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Byte> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Byte> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Byte value1, Byte value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNull() {
            addCriterion("account_name is null");
            return (Criteria) this;
        }

        public Criteria andAccountNameIsNotNull() {
            addCriterion("account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            addCriterion("account_name =", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            addCriterion("account_name <>", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            addCriterion("account_name >", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("account_name >=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThan(String value) {
            addCriterion("account_name <", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            addCriterion("account_name <=", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameLike(String value) {
            addCriterion("account_name like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotLike(String value) {
            addCriterion("account_name not like", value, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameIn(List<String> values) {
            addCriterion("account_name in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            addCriterion("account_name not in", values, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyIsNull() {
            addCriterion("adn_account_key is null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyIsNotNull() {
            addCriterion("adn_account_key is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyEqualTo(String value) {
            addCriterion("adn_account_key =", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyNotEqualTo(String value) {
            addCriterion("adn_account_key <>", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyGreaterThan(String value) {
            addCriterion("adn_account_key >", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyGreaterThanOrEqualTo(String value) {
            addCriterion("adn_account_key >=", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyLessThan(String value) {
            addCriterion("adn_account_key <", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyLessThanOrEqualTo(String value) {
            addCriterion("adn_account_key <=", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyLike(String value) {
            addCriterion("adn_account_key like", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyNotLike(String value) {
            addCriterion("adn_account_key not like", value, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyIn(List<String> values) {
            addCriterion("adn_account_key in", values, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyNotIn(List<String> values) {
            addCriterion("adn_account_key not in", values, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyBetween(String value1, String value2) {
            addCriterion("adn_account_key between", value1, value2, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andAdnAccountKeyNotBetween(String value1, String value2) {
            addCriterion("adn_account_key not between", value1, value2, "adnAccountKey");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdIsNull() {
            addCriterion("report_account_id is null");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdIsNotNull() {
            addCriterion("report_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdEqualTo(Integer value) {
            addCriterion("report_account_id =", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdNotEqualTo(Integer value) {
            addCriterion("report_account_id <>", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdGreaterThan(Integer value) {
            addCriterion("report_account_id >", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_account_id >=", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdLessThan(Integer value) {
            addCriterion("report_account_id <", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("report_account_id <=", value, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdIn(List<Integer> values) {
            addCriterion("report_account_id in", values, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdNotIn(List<Integer> values) {
            addCriterion("report_account_id not in", values, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("report_account_id between", value1, value2, "reportAccountId");
            return (Criteria) this;
        }

        public Criteria andReportAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("report_account_id not between", value1, value2, "reportAccountId");
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