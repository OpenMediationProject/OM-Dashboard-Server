// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StatLrCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatLrCriteria() {
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

        public Criteria andDayHourGreaterThanOrEqualTo(String day, Integer hour) {
            addCriterion(" (day = '" + day + "' and hour >= " + hour + " or day > '" + day + "') ");
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

        public Criteria andDayHourLessThanOrEqualTo(String day, Integer hour) {
            addCriterion(" (day = '" + day + "' and hour < " + hour + " or day < '" + day + "') ");
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

        public Criteria andSceneIdIsNull() {
            addCriterion("scene_id is null");
            return (Criteria) this;
        }

        public Criteria andSceneIdIsNotNull() {
            addCriterion("scene_id is not null");
            return (Criteria) this;
        }

        public Criteria andSceneIdEqualTo(Integer value) {
            addCriterion("scene_id =", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotEqualTo(Integer value) {
            addCriterion("scene_id <>", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThan(Integer value) {
            addCriterion("scene_id >", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scene_id >=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThan(Integer value) {
            addCriterion("scene_id <", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdLessThanOrEqualTo(Integer value) {
            addCriterion("scene_id <=", value, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdIn(List<Integer> values) {
            addCriterion("scene_id in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotIn(List<Integer> values) {
            addCriterion("scene_id not in", values, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdBetween(Integer value1, Integer value2) {
            addCriterion("scene_id between", value1, value2, "sceneId");
            return (Criteria) this;
        }

        public Criteria andSceneIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scene_id not between", value1, value2, "sceneId");
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

        public Criteria andWaterfallRequestIsNull() {
            addCriterion("waterfall_request is null");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestIsNotNull() {
            addCriterion("waterfall_request is not null");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestEqualTo(Integer value) {
            addCriterion("waterfall_request =", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestNotEqualTo(Integer value) {
            addCriterion("waterfall_request <>", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestGreaterThan(Integer value) {
            addCriterion("waterfall_request >", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestGreaterThanOrEqualTo(Integer value) {
            addCriterion("waterfall_request >=", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestLessThan(Integer value) {
            addCriterion("waterfall_request <", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestLessThanOrEqualTo(Integer value) {
            addCriterion("waterfall_request <=", value, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestIn(List<Integer> values) {
            addCriterion("waterfall_request in", values, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestNotIn(List<Integer> values) {
            addCriterion("waterfall_request not in", values, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestBetween(Integer value1, Integer value2) {
            addCriterion("waterfall_request between", value1, value2, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallRequestNotBetween(Integer value1, Integer value2) {
            addCriterion("waterfall_request not between", value1, value2, "waterfallRequest");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledIsNull() {
            addCriterion("waterfall_filled is null");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledIsNotNull() {
            addCriterion("waterfall_filled is not null");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledEqualTo(Integer value) {
            addCriterion("waterfall_filled =", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledNotEqualTo(Integer value) {
            addCriterion("waterfall_filled <>", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledGreaterThan(Integer value) {
            addCriterion("waterfall_filled >", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledGreaterThanOrEqualTo(Integer value) {
            addCriterion("waterfall_filled >=", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledLessThan(Integer value) {
            addCriterion("waterfall_filled <", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledLessThanOrEqualTo(Integer value) {
            addCriterion("waterfall_filled <=", value, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledIn(List<Integer> values) {
            addCriterion("waterfall_filled in", values, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledNotIn(List<Integer> values) {
            addCriterion("waterfall_filled not in", values, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledBetween(Integer value1, Integer value2) {
            addCriterion("waterfall_filled between", value1, value2, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andWaterfallFilledNotBetween(Integer value1, Integer value2) {
            addCriterion("waterfall_filled not between", value1, value2, "waterfallFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestIsNull() {
            addCriterion("instance_request is null");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestIsNotNull() {
            addCriterion("instance_request is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestEqualTo(Integer value) {
            addCriterion("instance_request =", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestNotEqualTo(Integer value) {
            addCriterion("instance_request <>", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestGreaterThan(Integer value) {
            addCriterion("instance_request >", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestGreaterThanOrEqualTo(Integer value) {
            addCriterion("instance_request >=", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestLessThan(Integer value) {
            addCriterion("instance_request <", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestLessThanOrEqualTo(Integer value) {
            addCriterion("instance_request <=", value, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestIn(List<Integer> values) {
            addCriterion("instance_request in", values, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestNotIn(List<Integer> values) {
            addCriterion("instance_request not in", values, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestBetween(Integer value1, Integer value2) {
            addCriterion("instance_request between", value1, value2, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceRequestNotBetween(Integer value1, Integer value2) {
            addCriterion("instance_request not between", value1, value2, "instanceRequest");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledIsNull() {
            addCriterion("instance_filled is null");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledIsNotNull() {
            addCriterion("instance_filled is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledEqualTo(Integer value) {
            addCriterion("instance_filled =", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledNotEqualTo(Integer value) {
            addCriterion("instance_filled <>", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledGreaterThan(Integer value) {
            addCriterion("instance_filled >", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledGreaterThanOrEqualTo(Integer value) {
            addCriterion("instance_filled >=", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledLessThan(Integer value) {
            addCriterion("instance_filled <", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledLessThanOrEqualTo(Integer value) {
            addCriterion("instance_filled <=", value, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledIn(List<Integer> values) {
            addCriterion("instance_filled in", values, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledNotIn(List<Integer> values) {
            addCriterion("instance_filled not in", values, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledBetween(Integer value1, Integer value2) {
            addCriterion("instance_filled between", value1, value2, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andInstanceFilledNotBetween(Integer value1, Integer value2) {
            addCriterion("instance_filled not between", value1, value2, "instanceFilled");
            return (Criteria) this;
        }

        public Criteria andVideoStartIsNull() {
            addCriterion("video_start is null");
            return (Criteria) this;
        }

        public Criteria andVideoStartIsNotNull() {
            addCriterion("video_start is not null");
            return (Criteria) this;
        }

        public Criteria andVideoStartEqualTo(Integer value) {
            addCriterion("video_start =", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartNotEqualTo(Integer value) {
            addCriterion("video_start <>", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartGreaterThan(Integer value) {
            addCriterion("video_start >", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_start >=", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartLessThan(Integer value) {
            addCriterion("video_start <", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartLessThanOrEqualTo(Integer value) {
            addCriterion("video_start <=", value, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartIn(List<Integer> values) {
            addCriterion("video_start in", values, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartNotIn(List<Integer> values) {
            addCriterion("video_start not in", values, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartBetween(Integer value1, Integer value2) {
            addCriterion("video_start between", value1, value2, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoStartNotBetween(Integer value1, Integer value2) {
            addCriterion("video_start not between", value1, value2, "videoStart");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteIsNull() {
            addCriterion("video_complete is null");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteIsNotNull() {
            addCriterion("video_complete is not null");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteEqualTo(Integer value) {
            addCriterion("video_complete =", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteNotEqualTo(Integer value) {
            addCriterion("video_complete <>", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteGreaterThan(Integer value) {
            addCriterion("video_complete >", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_complete >=", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteLessThan(Integer value) {
            addCriterion("video_complete <", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteLessThanOrEqualTo(Integer value) {
            addCriterion("video_complete <=", value, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteIn(List<Integer> values) {
            addCriterion("video_complete in", values, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteNotIn(List<Integer> values) {
            addCriterion("video_complete not in", values, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteBetween(Integer value1, Integer value2) {
            addCriterion("video_complete between", value1, value2, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andVideoCompleteNotBetween(Integer value1, Integer value2) {
            addCriterion("video_complete not between", value1, value2, "videoComplete");
            return (Criteria) this;
        }

        public Criteria andCalledShowIsNull() {
            addCriterion("called_show is null");
            return (Criteria) this;
        }

        public Criteria andCalledShowIsNotNull() {
            addCriterion("called_show is not null");
            return (Criteria) this;
        }

        public Criteria andCalledShowEqualTo(Integer value) {
            addCriterion("called_show =", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowNotEqualTo(Integer value) {
            addCriterion("called_show <>", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowGreaterThan(Integer value) {
            addCriterion("called_show >", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("called_show >=", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowLessThan(Integer value) {
            addCriterion("called_show <", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowLessThanOrEqualTo(Integer value) {
            addCriterion("called_show <=", value, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowIn(List<Integer> values) {
            addCriterion("called_show in", values, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowNotIn(List<Integer> values) {
            addCriterion("called_show not in", values, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowBetween(Integer value1, Integer value2) {
            addCriterion("called_show between", value1, value2, "calledShow");
            return (Criteria) this;
        }

        public Criteria andCalledShowNotBetween(Integer value1, Integer value2) {
            addCriterion("called_show not between", value1, value2, "calledShow");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueIsNull() {
            addCriterion("is_ready_true is null");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueIsNotNull() {
            addCriterion("is_ready_true is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueEqualTo(Integer value) {
            addCriterion("is_ready_true =", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueNotEqualTo(Integer value) {
            addCriterion("is_ready_true <>", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueGreaterThan(Integer value) {
            addCriterion("is_ready_true >", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ready_true >=", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueLessThan(Integer value) {
            addCriterion("is_ready_true <", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueLessThanOrEqualTo(Integer value) {
            addCriterion("is_ready_true <=", value, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueIn(List<Integer> values) {
            addCriterion("is_ready_true in", values, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueNotIn(List<Integer> values) {
            addCriterion("is_ready_true not in", values, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueBetween(Integer value1, Integer value2) {
            addCriterion("is_ready_true between", value1, value2, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyTrueNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ready_true not between", value1, value2, "isReadyTrue");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseIsNull() {
            addCriterion("is_ready_false is null");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseIsNotNull() {
            addCriterion("is_ready_false is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseEqualTo(Integer value) {
            addCriterion("is_ready_false =", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseNotEqualTo(Integer value) {
            addCriterion("is_ready_false <>", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseGreaterThan(Integer value) {
            addCriterion("is_ready_false >", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_ready_false >=", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseLessThan(Integer value) {
            addCriterion("is_ready_false <", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseLessThanOrEqualTo(Integer value) {
            addCriterion("is_ready_false <=", value, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseIn(List<Integer> values) {
            addCriterion("is_ready_false in", values, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseNotIn(List<Integer> values) {
            addCriterion("is_ready_false not in", values, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseBetween(Integer value1, Integer value2) {
            addCriterion("is_ready_false between", value1, value2, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andIsReadyFalseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_ready_false not between", value1, value2, "isReadyFalse");
            return (Criteria) this;
        }

        public Criteria andClickIsNull() {
            addCriterion("click is null");
            return (Criteria) this;
        }

        public Criteria andClickIsNotNull() {
            addCriterion("click is not null");
            return (Criteria) this;
        }

        public Criteria andClickEqualTo(Integer value) {
            addCriterion("click =", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotEqualTo(Integer value) {
            addCriterion("click <>", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThan(Integer value) {
            addCriterion("click >", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickGreaterThanOrEqualTo(Integer value) {
            addCriterion("click >=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThan(Integer value) {
            addCriterion("click <", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickLessThanOrEqualTo(Integer value) {
            addCriterion("click <=", value, "click");
            return (Criteria) this;
        }

        public Criteria andClickIn(List<Integer> values) {
            addCriterion("click in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotIn(List<Integer> values) {
            addCriterion("click not in", values, "click");
            return (Criteria) this;
        }

        public Criteria andClickBetween(Integer value1, Integer value2) {
            addCriterion("click between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andClickNotBetween(Integer value1, Integer value2) {
            addCriterion("click not between", value1, value2, "click");
            return (Criteria) this;
        }

        public Criteria andImprIsNull() {
            addCriterion("impr is null");
            return (Criteria) this;
        }

        public Criteria andImprIsNotNull() {
            addCriterion("impr is not null");
            return (Criteria) this;
        }

        public Criteria andImprEqualTo(Integer value) {
            addCriterion("impr =", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprNotEqualTo(Integer value) {
            addCriterion("impr <>", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprGreaterThan(Integer value) {
            addCriterion("impr >", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprGreaterThanOrEqualTo(Integer value) {
            addCriterion("impr >=", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprLessThan(Integer value) {
            addCriterion("impr <", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprLessThanOrEqualTo(Integer value) {
            addCriterion("impr <=", value, "impr");
            return (Criteria) this;
        }

        public Criteria andImprIn(List<Integer> values) {
            addCriterion("impr in", values, "impr");
            return (Criteria) this;
        }

        public Criteria andImprNotIn(List<Integer> values) {
            addCriterion("impr not in", values, "impr");
            return (Criteria) this;
        }

        public Criteria andImprBetween(Integer value1, Integer value2) {
            addCriterion("impr between", value1, value2, "impr");
            return (Criteria) this;
        }

        public Criteria andImprNotBetween(Integer value1, Integer value2) {
            addCriterion("impr not between", value1, value2, "impr");
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

        public Criteria andBidReqIsNull() {
            addCriterion("bid_req is null");
            return (Criteria) this;
        }

        public Criteria andBidReqIsNotNull() {
            addCriterion("bid_req is not null");
            return (Criteria) this;
        }

        public Criteria andBidReqEqualTo(Integer value) {
            addCriterion("bid_req =", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqNotEqualTo(Integer value) {
            addCriterion("bid_req <>", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqGreaterThan(Integer value) {
            addCriterion("bid_req >", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_req >=", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqLessThan(Integer value) {
            addCriterion("bid_req <", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqLessThanOrEqualTo(Integer value) {
            addCriterion("bid_req <=", value, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqIn(List<Integer> values) {
            addCriterion("bid_req in", values, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqNotIn(List<Integer> values) {
            addCriterion("bid_req not in", values, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqBetween(Integer value1, Integer value2) {
            addCriterion("bid_req between", value1, value2, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidReqNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_req not between", value1, value2, "bidReq");
            return (Criteria) this;
        }

        public Criteria andBidRespIsNull() {
            addCriterion("bid_resp is null");
            return (Criteria) this;
        }

        public Criteria andBidRespIsNotNull() {
            addCriterion("bid_resp is not null");
            return (Criteria) this;
        }

        public Criteria andBidRespEqualTo(Integer value) {
            addCriterion("bid_resp =", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespNotEqualTo(Integer value) {
            addCriterion("bid_resp <>", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespGreaterThan(Integer value) {
            addCriterion("bid_resp >", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_resp >=", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespLessThan(Integer value) {
            addCriterion("bid_resp <", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespLessThanOrEqualTo(Integer value) {
            addCriterion("bid_resp <=", value, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespIn(List<Integer> values) {
            addCriterion("bid_resp in", values, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespNotIn(List<Integer> values) {
            addCriterion("bid_resp not in", values, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespBetween(Integer value1, Integer value2) {
            addCriterion("bid_resp between", value1, value2, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_resp not between", value1, value2, "bidResp");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceIsNull() {
            addCriterion("bid_resp_price is null");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceIsNotNull() {
            addCriterion("bid_resp_price is not null");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceEqualTo(BigDecimal value) {
            addCriterion("bid_resp_price =", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceNotEqualTo(BigDecimal value) {
            addCriterion("bid_resp_price <>", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceGreaterThan(BigDecimal value) {
            addCriterion("bid_resp_price >", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_resp_price >=", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceLessThan(BigDecimal value) {
            addCriterion("bid_resp_price <", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_resp_price <=", value, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceIn(List<BigDecimal> values) {
            addCriterion("bid_resp_price in", values, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceNotIn(List<BigDecimal> values) {
            addCriterion("bid_resp_price not in", values, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_resp_price between", value1, value2, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidRespPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_resp_price not between", value1, value2, "bidRespPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinIsNull() {
            addCriterion("bid_win is null");
            return (Criteria) this;
        }

        public Criteria andBidWinIsNotNull() {
            addCriterion("bid_win is not null");
            return (Criteria) this;
        }

        public Criteria andBidWinEqualTo(Integer value) {
            addCriterion("bid_win =", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinNotEqualTo(Integer value) {
            addCriterion("bid_win <>", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinGreaterThan(Integer value) {
            addCriterion("bid_win >", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid_win >=", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinLessThan(Integer value) {
            addCriterion("bid_win <", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinLessThanOrEqualTo(Integer value) {
            addCriterion("bid_win <=", value, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinIn(List<Integer> values) {
            addCriterion("bid_win in", values, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinNotIn(List<Integer> values) {
            addCriterion("bid_win not in", values, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinBetween(Integer value1, Integer value2) {
            addCriterion("bid_win between", value1, value2, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinNotBetween(Integer value1, Integer value2) {
            addCriterion("bid_win not between", value1, value2, "bidWin");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceIsNull() {
            addCriterion("bid_win_price is null");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceIsNotNull() {
            addCriterion("bid_win_price is not null");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceEqualTo(BigDecimal value) {
            addCriterion("bid_win_price =", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceNotEqualTo(BigDecimal value) {
            addCriterion("bid_win_price <>", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceGreaterThan(BigDecimal value) {
            addCriterion("bid_win_price >", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_win_price >=", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceLessThan(BigDecimal value) {
            addCriterion("bid_win_price <", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bid_win_price <=", value, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceIn(List<BigDecimal> values) {
            addCriterion("bid_win_price in", values, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceNotIn(List<BigDecimal> values) {
            addCriterion("bid_win_price not in", values, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_win_price between", value1, value2, "bidWinPrice");
            return (Criteria) this;
        }

        public Criteria andBidWinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bid_win_price not between", value1, value2, "bidWinPrice");
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