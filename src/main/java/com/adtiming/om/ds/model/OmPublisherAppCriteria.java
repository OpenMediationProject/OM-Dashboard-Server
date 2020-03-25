// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmPublisherAppCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmPublisherAppCriteria() {
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

        public Criteria andPlatIsNull() {
            addCriterion("plat is null");
            return (Criteria) this;
        }

        public Criteria andPlatIsNotNull() {
            addCriterion("plat is not null");
            return (Criteria) this;
        }

        public Criteria andPlatEqualTo(Byte value) {
            addCriterion("plat =", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatNotEqualTo(Byte value) {
            addCriterion("plat <>", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatGreaterThan(Byte value) {
            addCriterion("plat >", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatGreaterThanOrEqualTo(Byte value) {
            addCriterion("plat >=", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatLessThan(Byte value) {
            addCriterion("plat <", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatLessThanOrEqualTo(Byte value) {
            addCriterion("plat <=", value, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatIn(List<Byte> values) {
            addCriterion("plat in", values, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatNotIn(List<Byte> values) {
            addCriterion("plat not in", values, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatBetween(Byte value1, Byte value2) {
            addCriterion("plat between", value1, value2, "plat");
            return (Criteria) this;
        }

        public Criteria andPlatNotBetween(Byte value1, Byte value2) {
            addCriterion("plat not between", value1, value2, "plat");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNull() {
            addCriterion("app_key is null");
            return (Criteria) this;
        }

        public Criteria andAppKeyIsNotNull() {
            addCriterion("app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAppKeyEqualTo(String value) {
            addCriterion("app_key =", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotEqualTo(String value) {
            addCriterion("app_key <>", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThan(String value) {
            addCriterion("app_key >", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("app_key >=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThan(String value) {
            addCriterion("app_key <", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLessThanOrEqualTo(String value) {
            addCriterion("app_key <=", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyLike(String value) {
            addCriterion("app_key like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotLike(String value) {
            addCriterion("app_key not like", value, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyIn(List<String> values) {
            addCriterion("app_key in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotIn(List<String> values) {
            addCriterion("app_key not in", values, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyBetween(String value1, String value2) {
            addCriterion("app_key between", value1, value2, "appKey");
            return (Criteria) this;
        }

        public Criteria andAppKeyNotBetween(String value1, String value2) {
            addCriterion("app_key not between", value1, value2, "appKey");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDebugStatusIsNull() {
            addCriterion("debug_status is null");
            return (Criteria) this;
        }

        public Criteria andDebugStatusIsNotNull() {
            addCriterion("debug_status is not null");
            return (Criteria) this;
        }

        public Criteria andDebugStatusEqualTo(Byte value) {
            addCriterion("debug_status =", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusNotEqualTo(Byte value) {
            addCriterion("debug_status <>", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusGreaterThan(Byte value) {
            addCriterion("debug_status >", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("debug_status >=", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusLessThan(Byte value) {
            addCriterion("debug_status <", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusLessThanOrEqualTo(Byte value) {
            addCriterion("debug_status <=", value, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusIn(List<Byte> values) {
            addCriterion("debug_status in", values, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusNotIn(List<Byte> values) {
            addCriterion("debug_status not in", values, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusBetween(Byte value1, Byte value2) {
            addCriterion("debug_status between", value1, value2, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andDebugStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("debug_status not between", value1, value2, "debugStatus");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsIsNull() {
            addCriterion("sdk_event_ids is null");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsIsNotNull() {
            addCriterion("sdk_event_ids is not null");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsEqualTo(String value) {
            addCriterion("sdk_event_ids =", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsNotEqualTo(String value) {
            addCriterion("sdk_event_ids <>", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsGreaterThan(String value) {
            addCriterion("sdk_event_ids >", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsGreaterThanOrEqualTo(String value) {
            addCriterion("sdk_event_ids >=", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsLessThan(String value) {
            addCriterion("sdk_event_ids <", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsLessThanOrEqualTo(String value) {
            addCriterion("sdk_event_ids <=", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsLike(String value) {
            addCriterion("sdk_event_ids like", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsNotLike(String value) {
            addCriterion("sdk_event_ids not like", value, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsIn(List<String> values) {
            addCriterion("sdk_event_ids in", values, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsNotIn(List<String> values) {
            addCriterion("sdk_event_ids not in", values, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsBetween(String value1, String value2) {
            addCriterion("sdk_event_ids between", value1, value2, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andSdkEventIdsNotBetween(String value1, String value2) {
            addCriterion("sdk_event_ids not between", value1, value2, "sdkEventIds");
            return (Criteria) this;
        }

        public Criteria andCoppaIsNull() {
            addCriterion("coppa is null");
            return (Criteria) this;
        }

        public Criteria andCoppaIsNotNull() {
            addCriterion("coppa is not null");
            return (Criteria) this;
        }

        public Criteria andCoppaEqualTo(Byte value) {
            addCriterion("coppa =", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaNotEqualTo(Byte value) {
            addCriterion("coppa <>", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaGreaterThan(Byte value) {
            addCriterion("coppa >", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaGreaterThanOrEqualTo(Byte value) {
            addCriterion("coppa >=", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaLessThan(Byte value) {
            addCriterion("coppa <", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaLessThanOrEqualTo(Byte value) {
            addCriterion("coppa <=", value, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaIn(List<Byte> values) {
            addCriterion("coppa in", values, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaNotIn(List<Byte> values) {
            addCriterion("coppa not in", values, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaBetween(Byte value1, Byte value2) {
            addCriterion("coppa between", value1, value2, "coppa");
            return (Criteria) this;
        }

        public Criteria andCoppaNotBetween(Byte value1, Byte value2) {
            addCriterion("coppa not between", value1, value2, "coppa");
            return (Criteria) this;
        }

        public Criteria andBundleIdIsNull() {
            addCriterion("bundle_id is null");
            return (Criteria) this;
        }

        public Criteria andBundleIdIsNotNull() {
            addCriterion("bundle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBundleIdEqualTo(String value) {
            addCriterion("bundle_id =", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdNotEqualTo(String value) {
            addCriterion("bundle_id <>", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdGreaterThan(String value) {
            addCriterion("bundle_id >", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdGreaterThanOrEqualTo(String value) {
            addCriterion("bundle_id >=", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdLessThan(String value) {
            addCriterion("bundle_id <", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdLessThanOrEqualTo(String value) {
            addCriterion("bundle_id <=", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdLike(String value) {
            addCriterion("bundle_id like", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdNotLike(String value) {
            addCriterion("bundle_id not like", value, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdIn(List<String> values) {
            addCriterion("bundle_id in", values, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdNotIn(List<String> values) {
            addCriterion("bundle_id not in", values, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdBetween(String value1, String value2) {
            addCriterion("bundle_id between", value1, value2, "bundleId");
            return (Criteria) this;
        }

        public Criteria andBundleIdNotBetween(String value1, String value2) {
            addCriterion("bundle_id not between", value1, value2, "bundleId");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andDescnIsNull() {
            addCriterion("descn is null");
            return (Criteria) this;
        }

        public Criteria andDescnIsNotNull() {
            addCriterion("descn is not null");
            return (Criteria) this;
        }

        public Criteria andDescnEqualTo(String value) {
            addCriterion("descn =", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnNotEqualTo(String value) {
            addCriterion("descn <>", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnGreaterThan(String value) {
            addCriterion("descn >", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnGreaterThanOrEqualTo(String value) {
            addCriterion("descn >=", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnLessThan(String value) {
            addCriterion("descn <", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnLessThanOrEqualTo(String value) {
            addCriterion("descn <=", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnLike(String value) {
            addCriterion("descn like", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnNotLike(String value) {
            addCriterion("descn not like", value, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnIn(List<String> values) {
            addCriterion("descn in", values, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnNotIn(List<String> values) {
            addCriterion("descn not in", values, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnBetween(String value1, String value2) {
            addCriterion("descn between", value1, value2, "descn");
            return (Criteria) this;
        }

        public Criteria andDescnNotBetween(String value1, String value2) {
            addCriterion("descn not between", value1, value2, "descn");
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

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdIsNull() {
            addCriterion("sub_category_id is null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdIsNotNull() {
            addCriterion("sub_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdEqualTo(Integer value) {
            addCriterion("sub_category_id =", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdNotEqualTo(Integer value) {
            addCriterion("sub_category_id <>", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdGreaterThan(Integer value) {
            addCriterion("sub_category_id >", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id >=", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdLessThan(Integer value) {
            addCriterion("sub_category_id <", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id <=", value, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdIn(List<Integer> values) {
            addCriterion("sub_category_id in", values, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdNotIn(List<Integer> values) {
            addCriterion("sub_category_id not in", values, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_category_id between", value1, value2, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andSubCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_category_id not between", value1, value2, "subCategoryId");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlIsNull() {
            addCriterion("preview_url is null");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlIsNotNull() {
            addCriterion("preview_url is not null");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlEqualTo(String value) {
            addCriterion("preview_url =", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlNotEqualTo(String value) {
            addCriterion("preview_url <>", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlGreaterThan(String value) {
            addCriterion("preview_url >", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlGreaterThanOrEqualTo(String value) {
            addCriterion("preview_url >=", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlLessThan(String value) {
            addCriterion("preview_url <", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlLessThanOrEqualTo(String value) {
            addCriterion("preview_url <=", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlLike(String value) {
            addCriterion("preview_url like", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlNotLike(String value) {
            addCriterion("preview_url not like", value, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlIn(List<String> values) {
            addCriterion("preview_url in", values, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlNotIn(List<String> values) {
            addCriterion("preview_url not in", values, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlBetween(String value1, String value2) {
            addCriterion("preview_url between", value1, value2, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andPreviewUrlNotBetween(String value1, String value2) {
            addCriterion("preview_url not between", value1, value2, "previewUrl");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNull() {
            addCriterion("developer is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNotNull() {
            addCriterion("developer is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperEqualTo(String value) {
            addCriterion("developer =", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotEqualTo(String value) {
            addCriterion("developer <>", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThan(String value) {
            addCriterion("developer >", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThanOrEqualTo(String value) {
            addCriterion("developer >=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThan(String value) {
            addCriterion("developer <", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThanOrEqualTo(String value) {
            addCriterion("developer <=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLike(String value) {
            addCriterion("developer like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotLike(String value) {
            addCriterion("developer not like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperIn(List<String> values) {
            addCriterion("developer in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotIn(List<String> values) {
            addCriterion("developer not in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperBetween(String value1, String value2) {
            addCriterion("developer between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotBetween(String value1, String value2) {
            addCriterion("developer not between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andOsRequireIsNull() {
            addCriterion("os_require is null");
            return (Criteria) this;
        }

        public Criteria andOsRequireIsNotNull() {
            addCriterion("os_require is not null");
            return (Criteria) this;
        }

        public Criteria andOsRequireEqualTo(String value) {
            addCriterion("os_require =", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireNotEqualTo(String value) {
            addCriterion("os_require <>", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireGreaterThan(String value) {
            addCriterion("os_require >", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireGreaterThanOrEqualTo(String value) {
            addCriterion("os_require >=", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireLessThan(String value) {
            addCriterion("os_require <", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireLessThanOrEqualTo(String value) {
            addCriterion("os_require <=", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireLike(String value) {
            addCriterion("os_require like", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireNotLike(String value) {
            addCriterion("os_require not like", value, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireIn(List<String> values) {
            addCriterion("os_require in", values, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireNotIn(List<String> values) {
            addCriterion("os_require not in", values, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireBetween(String value1, String value2) {
            addCriterion("os_require between", value1, value2, "osRequire");
            return (Criteria) this;
        }

        public Criteria andOsRequireNotBetween(String value1, String value2) {
            addCriterion("os_require not between", value1, value2, "osRequire");
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

        public Criteria andAvailableCountriesIsNull() {
            addCriterion("available_countries is null");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesIsNotNull() {
            addCriterion("available_countries is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesEqualTo(String value) {
            addCriterion("available_countries =", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesNotEqualTo(String value) {
            addCriterion("available_countries <>", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesGreaterThan(String value) {
            addCriterion("available_countries >", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesGreaterThanOrEqualTo(String value) {
            addCriterion("available_countries >=", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesLessThan(String value) {
            addCriterion("available_countries <", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesLessThanOrEqualTo(String value) {
            addCriterion("available_countries <=", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesLike(String value) {
            addCriterion("available_countries like", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesNotLike(String value) {
            addCriterion("available_countries not like", value, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesIn(List<String> values) {
            addCriterion("available_countries in", values, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesNotIn(List<String> values) {
            addCriterion("available_countries not in", values, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesBetween(String value1, String value2) {
            addCriterion("available_countries between", value1, value2, "availableCountries");
            return (Criteria) this;
        }

        public Criteria andAvailableCountriesNotBetween(String value1, String value2) {
            addCriterion("available_countries not between", value1, value2, "availableCountries");
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