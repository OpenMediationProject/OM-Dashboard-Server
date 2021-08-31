package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmPlacementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmPlacementCriteria() {
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

        public Criteria andMainPlacementIsNull() {
            addCriterion("main_placement is null");
            return (Criteria) this;
        }

        public Criteria andMainPlacementIsNotNull() {
            addCriterion("main_placement is not null");
            return (Criteria) this;
        }

        public Criteria andMainPlacementEqualTo(Byte value) {
            addCriterion("main_placement =", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementNotEqualTo(Byte value) {
            addCriterion("main_placement <>", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementGreaterThan(Byte value) {
            addCriterion("main_placement >", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementGreaterThanOrEqualTo(Byte value) {
            addCriterion("main_placement >=", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementLessThan(Byte value) {
            addCriterion("main_placement <", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementLessThanOrEqualTo(Byte value) {
            addCriterion("main_placement <=", value, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementIn(List<Byte> values) {
            addCriterion("main_placement in", values, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementNotIn(List<Byte> values) {
            addCriterion("main_placement not in", values, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementBetween(Byte value1, Byte value2) {
            addCriterion("main_placement between", value1, value2, "mainPlacement");
            return (Criteria) this;
        }

        public Criteria andMainPlacementNotBetween(Byte value1, Byte value2) {
            addCriterion("main_placement not between", value1, value2, "mainPlacement");
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

        public Criteria andPreloadTimeoutIsNull() {
            addCriterion("preload_timeout is null");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutIsNotNull() {
            addCriterion("preload_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutEqualTo(Byte value) {
            addCriterion("preload_timeout =", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutNotEqualTo(Byte value) {
            addCriterion("preload_timeout <>", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutGreaterThan(Byte value) {
            addCriterion("preload_timeout >", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutGreaterThanOrEqualTo(Byte value) {
            addCriterion("preload_timeout >=", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutLessThan(Byte value) {
            addCriterion("preload_timeout <", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutLessThanOrEqualTo(Byte value) {
            addCriterion("preload_timeout <=", value, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutIn(List<Byte> values) {
            addCriterion("preload_timeout in", values, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutNotIn(List<Byte> values) {
            addCriterion("preload_timeout not in", values, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutBetween(Byte value1, Byte value2) {
            addCriterion("preload_timeout between", value1, value2, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andPreloadTimeoutNotBetween(Byte value1, Byte value2) {
            addCriterion("preload_timeout not between", value1, value2, "preloadTimeout");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusIsNull() {
            addCriterion("ab_test_status is null");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusIsNotNull() {
            addCriterion("ab_test_status is not null");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusEqualTo(Byte value) {
            addCriterion("ab_test_status =", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusNotEqualTo(Byte value) {
            addCriterion("ab_test_status <>", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusGreaterThan(Byte value) {
            addCriterion("ab_test_status >", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ab_test_status >=", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusLessThan(Byte value) {
            addCriterion("ab_test_status <", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ab_test_status <=", value, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusIn(List<Byte> values) {
            addCriterion("ab_test_status in", values, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusNotIn(List<Byte> values) {
            addCriterion("ab_test_status not in", values, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusBetween(Byte value1, Byte value2) {
            addCriterion("ab_test_status between", value1, value2, "abTestStatus");
            return (Criteria) this;
        }

        public Criteria andAbTestStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ab_test_status not between", value1, value2, "abTestStatus");
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

        public Criteria andIcUrlIsNull() {
            addCriterion("ic_url is null");
            return (Criteria) this;
        }

        public Criteria andIcUrlIsNotNull() {
            addCriterion("ic_url is not null");
            return (Criteria) this;
        }

        public Criteria andIcUrlEqualTo(String value) {
            addCriterion("ic_url =", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlNotEqualTo(String value) {
            addCriterion("ic_url <>", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlGreaterThan(String value) {
            addCriterion("ic_url >", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ic_url >=", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlLessThan(String value) {
            addCriterion("ic_url <", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlLessThanOrEqualTo(String value) {
            addCriterion("ic_url <=", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlLike(String value) {
            addCriterion("ic_url like", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlNotLike(String value) {
            addCriterion("ic_url not like", value, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlIn(List<String> values) {
            addCriterion("ic_url in", values, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlNotIn(List<String> values) {
            addCriterion("ic_url not in", values, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlBetween(String value1, String value2) {
            addCriterion("ic_url between", value1, value2, "icUrl");
            return (Criteria) this;
        }

        public Criteria andIcUrlNotBetween(String value1, String value2) {
            addCriterion("ic_url not between", value1, value2, "icUrl");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNull() {
            addCriterion("floor_price is null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNotNull() {
            addCriterion("floor_price is not null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceEqualTo(BigDecimal value) {
            addCriterion("floor_price =", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotEqualTo(BigDecimal value) {
            addCriterion("floor_price <>", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThan(BigDecimal value) {
            addCriterion("floor_price >", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("floor_price >=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThan(BigDecimal value) {
            addCriterion("floor_price <", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("floor_price <=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIn(List<BigDecimal> values) {
            addCriterion("floor_price in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotIn(List<BigDecimal> values) {
            addCriterion("floor_price not in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floor_price between", value1, value2, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floor_price not between", value1, value2, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchIsNull() {
            addCriterion("floor_price_switch is null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchIsNotNull() {
            addCriterion("floor_price_switch is not null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchEqualTo(Byte value) {
            addCriterion("floor_price_switch =", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchNotEqualTo(Byte value) {
            addCriterion("floor_price_switch <>", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchGreaterThan(Byte value) {
            addCriterion("floor_price_switch >", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchGreaterThanOrEqualTo(Byte value) {
            addCriterion("floor_price_switch >=", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchLessThan(Byte value) {
            addCriterion("floor_price_switch <", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchLessThanOrEqualTo(Byte value) {
            addCriterion("floor_price_switch <=", value, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchIn(List<Byte> values) {
            addCriterion("floor_price_switch in", values, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchNotIn(List<Byte> values) {
            addCriterion("floor_price_switch not in", values, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchBetween(Byte value1, Byte value2) {
            addCriterion("floor_price_switch between", value1, value2, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andFloorPriceSwitchNotBetween(Byte value1, Byte value2) {
            addCriterion("floor_price_switch not between", value1, value2, "floorPriceSwitch");
            return (Criteria) this;
        }

        public Criteria andHbStatusIsNull() {
            addCriterion("hb_status is null");
            return (Criteria) this;
        }

        public Criteria andHbStatusIsNotNull() {
            addCriterion("hb_status is not null");
            return (Criteria) this;
        }

        public Criteria andHbStatusEqualTo(Byte value) {
            addCriterion("hb_status =", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotEqualTo(Byte value) {
            addCriterion("hb_status <>", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusGreaterThan(Byte value) {
            addCriterion("hb_status >", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("hb_status >=", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusLessThan(Byte value) {
            addCriterion("hb_status <", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusLessThanOrEqualTo(Byte value) {
            addCriterion("hb_status <=", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusIn(List<Byte> values) {
            addCriterion("hb_status in", values, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotIn(List<Byte> values) {
            addCriterion("hb_status not in", values, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusBetween(Byte value1, Byte value2) {
            addCriterion("hb_status between", value1, value2, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("hb_status not between", value1, value2, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andFanOutIsNull() {
            addCriterion("fan_out is null");
            return (Criteria) this;
        }

        public Criteria andFanOutIsNotNull() {
            addCriterion("fan_out is not null");
            return (Criteria) this;
        }

        public Criteria andFanOutEqualTo(Byte value) {
            addCriterion("fan_out =", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutNotEqualTo(Byte value) {
            addCriterion("fan_out <>", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutGreaterThan(Byte value) {
            addCriterion("fan_out >", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutGreaterThanOrEqualTo(Byte value) {
            addCriterion("fan_out >=", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutLessThan(Byte value) {
            addCriterion("fan_out <", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutLessThanOrEqualTo(Byte value) {
            addCriterion("fan_out <=", value, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutIn(List<Byte> values) {
            addCriterion("fan_out in", values, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutNotIn(List<Byte> values) {
            addCriterion("fan_out not in", values, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutBetween(Byte value1, Byte value2) {
            addCriterion("fan_out between", value1, value2, "fanOut");
            return (Criteria) this;
        }

        public Criteria andFanOutNotBetween(Byte value1, Byte value2) {
            addCriterion("fan_out not between", value1, value2, "fanOut");
            return (Criteria) this;
        }

        public Criteria andBatchSizeIsNull() {
            addCriterion("batch_size is null");
            return (Criteria) this;
        }

        public Criteria andBatchSizeIsNotNull() {
            addCriterion("batch_size is not null");
            return (Criteria) this;
        }

        public Criteria andBatchSizeEqualTo(Byte value) {
            addCriterion("batch_size =", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeNotEqualTo(Byte value) {
            addCriterion("batch_size <>", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeGreaterThan(Byte value) {
            addCriterion("batch_size >", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeGreaterThanOrEqualTo(Byte value) {
            addCriterion("batch_size >=", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeLessThan(Byte value) {
            addCriterion("batch_size <", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeLessThanOrEqualTo(Byte value) {
            addCriterion("batch_size <=", value, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeIn(List<Byte> values) {
            addCriterion("batch_size in", values, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeNotIn(List<Byte> values) {
            addCriterion("batch_size not in", values, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeBetween(Byte value1, Byte value2) {
            addCriterion("batch_size between", value1, value2, "batchSize");
            return (Criteria) this;
        }

        public Criteria andBatchSizeNotBetween(Byte value1, Byte value2) {
            addCriterion("batch_size not between", value1, value2, "batchSize");
            return (Criteria) this;
        }

        public Criteria andInventoryCountIsNull() {
            addCriterion("inventory_count is null");
            return (Criteria) this;
        }

        public Criteria andInventoryCountIsNotNull() {
            addCriterion("inventory_count is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryCountEqualTo(Byte value) {
            addCriterion("inventory_count =", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountNotEqualTo(Byte value) {
            addCriterion("inventory_count <>", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountGreaterThan(Byte value) {
            addCriterion("inventory_count >", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("inventory_count >=", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountLessThan(Byte value) {
            addCriterion("inventory_count <", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountLessThanOrEqualTo(Byte value) {
            addCriterion("inventory_count <=", value, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountIn(List<Byte> values) {
            addCriterion("inventory_count in", values, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountNotIn(List<Byte> values) {
            addCriterion("inventory_count not in", values, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountBetween(Byte value1, Byte value2) {
            addCriterion("inventory_count between", value1, value2, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryCountNotBetween(Byte value1, Byte value2) {
            addCriterion("inventory_count not between", value1, value2, "inventoryCount");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalIsNull() {
            addCriterion("inventory_interval is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalIsNotNull() {
            addCriterion("inventory_interval is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalEqualTo(Integer value) {
            addCriterion("inventory_interval =", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalNotEqualTo(Integer value) {
            addCriterion("inventory_interval <>", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalGreaterThan(Integer value) {
            addCriterion("inventory_interval >", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("inventory_interval >=", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalLessThan(Integer value) {
            addCriterion("inventory_interval <", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("inventory_interval <=", value, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalIn(List<Integer> values) {
            addCriterion("inventory_interval in", values, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalNotIn(List<Integer> values) {
            addCriterion("inventory_interval not in", values, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalBetween(Integer value1, Integer value2) {
            addCriterion("inventory_interval between", value1, value2, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("inventory_interval not between", value1, value2, "inventoryInterval");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepIsNull() {
            addCriterion("inventory_interval_step is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepIsNotNull() {
            addCriterion("inventory_interval_step is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepEqualTo(String value) {
            addCriterion("inventory_interval_step =", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepNotEqualTo(String value) {
            addCriterion("inventory_interval_step <>", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepGreaterThan(String value) {
            addCriterion("inventory_interval_step >", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepGreaterThanOrEqualTo(String value) {
            addCriterion("inventory_interval_step >=", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepLessThan(String value) {
            addCriterion("inventory_interval_step <", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepLessThanOrEqualTo(String value) {
            addCriterion("inventory_interval_step <=", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepLike(String value) {
            addCriterion("inventory_interval_step like", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepNotLike(String value) {
            addCriterion("inventory_interval_step not like", value, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepIn(List<String> values) {
            addCriterion("inventory_interval_step in", values, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepNotIn(List<String> values) {
            addCriterion("inventory_interval_step not in", values, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepBetween(String value1, String value2) {
            addCriterion("inventory_interval_step between", value1, value2, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andInventoryIntervalStepNotBetween(String value1, String value2) {
            addCriterion("inventory_interval_step not between", value1, value2, "inventoryIntervalStep");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalIsNull() {
            addCriterion("reload_interval is null");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalIsNotNull() {
            addCriterion("reload_interval is not null");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalEqualTo(Integer value) {
            addCriterion("reload_interval =", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalNotEqualTo(Integer value) {
            addCriterion("reload_interval <>", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalGreaterThan(Integer value) {
            addCriterion("reload_interval >", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("reload_interval >=", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalLessThan(Integer value) {
            addCriterion("reload_interval <", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("reload_interval <=", value, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalIn(List<Integer> values) {
            addCriterion("reload_interval in", values, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalNotIn(List<Integer> values) {
            addCriterion("reload_interval not in", values, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalBetween(Integer value1, Integer value2) {
            addCriterion("reload_interval between", value1, value2, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andReloadIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("reload_interval not between", value1, value2, "reloadInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIsNull() {
            addCriterion("frequency_cap is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIsNotNull() {
            addCriterion("frequency_cap is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapEqualTo(Integer value) {
            addCriterion("frequency_cap =", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotEqualTo(Integer value) {
            addCriterion("frequency_cap <>", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapGreaterThan(Integer value) {
            addCriterion("frequency_cap >", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_cap >=", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapLessThan(Integer value) {
            addCriterion("frequency_cap <", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_cap <=", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIn(List<Integer> values) {
            addCriterion("frequency_cap in", values, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotIn(List<Integer> values) {
            addCriterion("frequency_cap not in", values, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapBetween(Integer value1, Integer value2) {
            addCriterion("frequency_cap between", value1, value2, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_cap not between", value1, value2, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIsNull() {
            addCriterion("frequency_unit is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIsNotNull() {
            addCriterion("frequency_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitEqualTo(Integer value) {
            addCriterion("frequency_unit =", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotEqualTo(Integer value) {
            addCriterion("frequency_unit <>", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitGreaterThan(Integer value) {
            addCriterion("frequency_unit >", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_unit >=", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitLessThan(Integer value) {
            addCriterion("frequency_unit <", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_unit <=", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIn(List<Integer> values) {
            addCriterion("frequency_unit in", values, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotIn(List<Integer> values) {
            addCriterion("frequency_unit not in", values, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitBetween(Integer value1, Integer value2) {
            addCriterion("frequency_unit between", value1, value2, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_unit not between", value1, value2, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIsNull() {
            addCriterion("frequency_interval is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIsNotNull() {
            addCriterion("frequency_interval is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalEqualTo(Integer value) {
            addCriterion("frequency_interval =", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotEqualTo(Integer value) {
            addCriterion("frequency_interval <>", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalGreaterThan(Integer value) {
            addCriterion("frequency_interval >", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_interval >=", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalLessThan(Integer value) {
            addCriterion("frequency_interval <", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_interval <=", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIn(List<Integer> values) {
            addCriterion("frequency_interval in", values, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotIn(List<Integer> values) {
            addCriterion("frequency_interval not in", values, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalBetween(Integer value1, Integer value2) {
            addCriterion("frequency_interval between", value1, value2, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_interval not between", value1, value2, "frequencyInterval");
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

        public Criteria andOsvMaxIsNull() {
            addCriterion("osv_max is null");
            return (Criteria) this;
        }

        public Criteria andOsvMaxIsNotNull() {
            addCriterion("osv_max is not null");
            return (Criteria) this;
        }

        public Criteria andOsvMaxEqualTo(String value) {
            addCriterion("osv_max =", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotEqualTo(String value) {
            addCriterion("osv_max <>", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxGreaterThan(String value) {
            addCriterion("osv_max >", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxGreaterThanOrEqualTo(String value) {
            addCriterion("osv_max >=", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLessThan(String value) {
            addCriterion("osv_max <", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLessThanOrEqualTo(String value) {
            addCriterion("osv_max <=", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLike(String value) {
            addCriterion("osv_max like", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotLike(String value) {
            addCriterion("osv_max not like", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxIn(List<String> values) {
            addCriterion("osv_max in", values, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotIn(List<String> values) {
            addCriterion("osv_max not in", values, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxBetween(String value1, String value2) {
            addCriterion("osv_max between", value1, value2, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotBetween(String value1, String value2) {
            addCriterion("osv_max not between", value1, value2, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMinIsNull() {
            addCriterion("osv_min is null");
            return (Criteria) this;
        }

        public Criteria andOsvMinIsNotNull() {
            addCriterion("osv_min is not null");
            return (Criteria) this;
        }

        public Criteria andOsvMinEqualTo(String value) {
            addCriterion("osv_min =", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotEqualTo(String value) {
            addCriterion("osv_min <>", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinGreaterThan(String value) {
            addCriterion("osv_min >", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinGreaterThanOrEqualTo(String value) {
            addCriterion("osv_min >=", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLessThan(String value) {
            addCriterion("osv_min <", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLessThanOrEqualTo(String value) {
            addCriterion("osv_min <=", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLike(String value) {
            addCriterion("osv_min like", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotLike(String value) {
            addCriterion("osv_min not like", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinIn(List<String> values) {
            addCriterion("osv_min in", values, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotIn(List<String> values) {
            addCriterion("osv_min not in", values, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinBetween(String value1, String value2) {
            addCriterion("osv_min between", value1, value2, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotBetween(String value1, String value2) {
            addCriterion("osv_min not between", value1, value2, "osvMin");
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