package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpCampaignCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpCampaignCriteria() {
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

        public Criteria andSkaCampaignIdIsNull() {
            addCriterion("ska_campaign_id is null");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdIsNotNull() {
            addCriterion("ska_campaign_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdEqualTo(Byte value) {
            addCriterion("ska_campaign_id =", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdNotEqualTo(Byte value) {
            addCriterion("ska_campaign_id <>", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdGreaterThan(Byte value) {
            addCriterion("ska_campaign_id >", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("ska_campaign_id >=", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdLessThan(Byte value) {
            addCriterion("ska_campaign_id <", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdLessThanOrEqualTo(Byte value) {
            addCriterion("ska_campaign_id <=", value, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdIn(List<Byte> values) {
            addCriterion("ska_campaign_id in", values, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdNotIn(List<Byte> values) {
            addCriterion("ska_campaign_id not in", values, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdBetween(Byte value1, Byte value2) {
            addCriterion("ska_campaign_id between", value1, value2, "skaCampaignId");
            return (Criteria) this;
        }

        public Criteria andSkaCampaignIdNotBetween(Byte value1, Byte value2) {
            addCriterion("ska_campaign_id not between", value1, value2, "skaCampaignId");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andBillingTypeIsNull() {
            addCriterion("billing_type is null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIsNotNull() {
            addCriterion("billing_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeEqualTo(Byte value) {
            addCriterion("billing_type =", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotEqualTo(Byte value) {
            addCriterion("billing_type <>", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThan(Byte value) {
            addCriterion("billing_type >", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("billing_type >=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThan(Byte value) {
            addCriterion("billing_type <", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThanOrEqualTo(Byte value) {
            addCriterion("billing_type <=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIn(List<Byte> values) {
            addCriterion("billing_type in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotIn(List<Byte> values) {
            addCriterion("billing_type not in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeBetween(Byte value1, Byte value2) {
            addCriterion("billing_type between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("billing_type not between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDailyCapIsNull() {
            addCriterion("daily_cap is null");
            return (Criteria) this;
        }

        public Criteria andDailyCapIsNotNull() {
            addCriterion("daily_cap is not null");
            return (Criteria) this;
        }

        public Criteria andDailyCapEqualTo(Integer value) {
            addCriterion("daily_cap =", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapNotEqualTo(Integer value) {
            addCriterion("daily_cap <>", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapGreaterThan(Integer value) {
            addCriterion("daily_cap >", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_cap >=", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapLessThan(Integer value) {
            addCriterion("daily_cap <", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapLessThanOrEqualTo(Integer value) {
            addCriterion("daily_cap <=", value, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapIn(List<Integer> values) {
            addCriterion("daily_cap in", values, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapNotIn(List<Integer> values) {
            addCriterion("daily_cap not in", values, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapBetween(Integer value1, Integer value2) {
            addCriterion("daily_cap between", value1, value2, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyCapNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_cap not between", value1, value2, "dailyCap");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetIsNull() {
            addCriterion("daily_budget is null");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetIsNotNull() {
            addCriterion("daily_budget is not null");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetEqualTo(BigDecimal value) {
            addCriterion("daily_budget =", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetNotEqualTo(BigDecimal value) {
            addCriterion("daily_budget <>", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetGreaterThan(BigDecimal value) {
            addCriterion("daily_budget >", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("daily_budget >=", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetLessThan(BigDecimal value) {
            addCriterion("daily_budget <", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("daily_budget <=", value, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetIn(List<BigDecimal> values) {
            addCriterion("daily_budget in", values, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetNotIn(List<BigDecimal> values) {
            addCriterion("daily_budget not in", values, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("daily_budget between", value1, value2, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andDailyBudgetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("daily_budget not between", value1, value2, "dailyBudget");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceIsNull() {
            addCriterion("max_bidprice is null");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceIsNotNull() {
            addCriterion("max_bidprice is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceEqualTo(BigDecimal value) {
            addCriterion("max_bidprice =", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceNotEqualTo(BigDecimal value) {
            addCriterion("max_bidprice <>", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceGreaterThan(BigDecimal value) {
            addCriterion("max_bidprice >", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bidprice >=", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceLessThan(BigDecimal value) {
            addCriterion("max_bidprice <", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_bidprice <=", value, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceIn(List<BigDecimal> values) {
            addCriterion("max_bidprice in", values, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceNotIn(List<BigDecimal> values) {
            addCriterion("max_bidprice not in", values, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bidprice between", value1, value2, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andMaxBidpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_bidprice not between", value1, value2, "maxBidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceIsNull() {
            addCriterion("bidprice is null");
            return (Criteria) this;
        }

        public Criteria andBidpriceIsNotNull() {
            addCriterion("bidprice is not null");
            return (Criteria) this;
        }

        public Criteria andBidpriceEqualTo(BigDecimal value) {
            addCriterion("bidprice =", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceNotEqualTo(BigDecimal value) {
            addCriterion("bidprice <>", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceGreaterThan(BigDecimal value) {
            addCriterion("bidprice >", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bidprice >=", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceLessThan(BigDecimal value) {
            addCriterion("bidprice <", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bidprice <=", value, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceIn(List<BigDecimal> values) {
            addCriterion("bidprice in", values, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceNotIn(List<BigDecimal> values) {
            addCriterion("bidprice not in", values, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bidprice between", value1, value2, "bidprice");
            return (Criteria) this;
        }

        public Criteria andBidpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bidprice not between", value1, value2, "bidprice");
            return (Criteria) this;
        }

        public Criteria andImprCapIsNull() {
            addCriterion("impr_cap is null");
            return (Criteria) this;
        }

        public Criteria andImprCapIsNotNull() {
            addCriterion("impr_cap is not null");
            return (Criteria) this;
        }

        public Criteria andImprCapEqualTo(Integer value) {
            addCriterion("impr_cap =", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapNotEqualTo(Integer value) {
            addCriterion("impr_cap <>", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapGreaterThan(Integer value) {
            addCriterion("impr_cap >", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("impr_cap >=", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapLessThan(Integer value) {
            addCriterion("impr_cap <", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapLessThanOrEqualTo(Integer value) {
            addCriterion("impr_cap <=", value, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapIn(List<Integer> values) {
            addCriterion("impr_cap in", values, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapNotIn(List<Integer> values) {
            addCriterion("impr_cap not in", values, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapBetween(Integer value1, Integer value2) {
            addCriterion("impr_cap between", value1, value2, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprCapNotBetween(Integer value1, Integer value2) {
            addCriterion("impr_cap not between", value1, value2, "imprCap");
            return (Criteria) this;
        }

        public Criteria andImprFreqIsNull() {
            addCriterion("impr_freq is null");
            return (Criteria) this;
        }

        public Criteria andImprFreqIsNotNull() {
            addCriterion("impr_freq is not null");
            return (Criteria) this;
        }

        public Criteria andImprFreqEqualTo(Integer value) {
            addCriterion("impr_freq =", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqNotEqualTo(Integer value) {
            addCriterion("impr_freq <>", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqGreaterThan(Integer value) {
            addCriterion("impr_freq >", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqGreaterThanOrEqualTo(Integer value) {
            addCriterion("impr_freq >=", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqLessThan(Integer value) {
            addCriterion("impr_freq <", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqLessThanOrEqualTo(Integer value) {
            addCriterion("impr_freq <=", value, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqIn(List<Integer> values) {
            addCriterion("impr_freq in", values, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqNotIn(List<Integer> values) {
            addCriterion("impr_freq not in", values, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqBetween(Integer value1, Integer value2) {
            addCriterion("impr_freq between", value1, value2, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andImprFreqNotBetween(Integer value1, Integer value2) {
            addCriterion("impr_freq not between", value1, value2, "imprFreq");
            return (Criteria) this;
        }

        public Criteria andAdDomainIsNull() {
            addCriterion("ad_domain is null");
            return (Criteria) this;
        }

        public Criteria andAdDomainIsNotNull() {
            addCriterion("ad_domain is not null");
            return (Criteria) this;
        }

        public Criteria andAdDomainEqualTo(String value) {
            addCriterion("ad_domain =", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainNotEqualTo(String value) {
            addCriterion("ad_domain <>", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainGreaterThan(String value) {
            addCriterion("ad_domain >", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainGreaterThanOrEqualTo(String value) {
            addCriterion("ad_domain >=", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainLessThan(String value) {
            addCriterion("ad_domain <", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainLessThanOrEqualTo(String value) {
            addCriterion("ad_domain <=", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainLike(String value) {
            addCriterion("ad_domain like", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainNotLike(String value) {
            addCriterion("ad_domain not like", value, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainIn(List<String> values) {
            addCriterion("ad_domain in", values, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainNotIn(List<String> values) {
            addCriterion("ad_domain not in", values, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainBetween(String value1, String value2) {
            addCriterion("ad_domain between", value1, value2, "adDomain");
            return (Criteria) this;
        }

        public Criteria andAdDomainNotBetween(String value1, String value2) {
            addCriterion("ad_domain not between", value1, value2, "adDomain");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNull() {
            addCriterion("click_url is null");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNotNull() {
            addCriterion("click_url is not null");
            return (Criteria) this;
        }

        public Criteria andClickUrlEqualTo(String value) {
            addCriterion("click_url =", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotEqualTo(String value) {
            addCriterion("click_url <>", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThan(String value) {
            addCriterion("click_url >", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThanOrEqualTo(String value) {
            addCriterion("click_url >=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThan(String value) {
            addCriterion("click_url <", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThanOrEqualTo(String value) {
            addCriterion("click_url <=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLike(String value) {
            addCriterion("click_url like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotLike(String value) {
            addCriterion("click_url not like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlIn(List<String> values) {
            addCriterion("click_url in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotIn(List<String> values) {
            addCriterion("click_url not in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlBetween(String value1, String value2) {
            addCriterion("click_url between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotBetween(String value1, String value2) {
            addCriterion("click_url not between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlIsNull() {
            addCriterion("impr_url is null");
            return (Criteria) this;
        }

        public Criteria andImprUrlIsNotNull() {
            addCriterion("impr_url is not null");
            return (Criteria) this;
        }

        public Criteria andImprUrlEqualTo(String value) {
            addCriterion("impr_url =", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlNotEqualTo(String value) {
            addCriterion("impr_url <>", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlGreaterThan(String value) {
            addCriterion("impr_url >", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlGreaterThanOrEqualTo(String value) {
            addCriterion("impr_url >=", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlLessThan(String value) {
            addCriterion("impr_url <", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlLessThanOrEqualTo(String value) {
            addCriterion("impr_url <=", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlLike(String value) {
            addCriterion("impr_url like", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlNotLike(String value) {
            addCriterion("impr_url not like", value, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlIn(List<String> values) {
            addCriterion("impr_url in", values, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlNotIn(List<String> values) {
            addCriterion("impr_url not in", values, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlBetween(String value1, String value2) {
            addCriterion("impr_url between", value1, value2, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andImprUrlNotBetween(String value1, String value2) {
            addCriterion("impr_url not between", value1, value2, "imprUrl");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsIsNull() {
            addCriterion("click_tk_urls is null");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsIsNotNull() {
            addCriterion("click_tk_urls is not null");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsEqualTo(String value) {
            addCriterion("click_tk_urls =", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsNotEqualTo(String value) {
            addCriterion("click_tk_urls <>", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsGreaterThan(String value) {
            addCriterion("click_tk_urls >", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("click_tk_urls >=", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsLessThan(String value) {
            addCriterion("click_tk_urls <", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsLessThanOrEqualTo(String value) {
            addCriterion("click_tk_urls <=", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsLike(String value) {
            addCriterion("click_tk_urls like", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsNotLike(String value) {
            addCriterion("click_tk_urls not like", value, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsIn(List<String> values) {
            addCriterion("click_tk_urls in", values, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsNotIn(List<String> values) {
            addCriterion("click_tk_urls not in", values, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsBetween(String value1, String value2) {
            addCriterion("click_tk_urls between", value1, value2, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andClickTkUrlsNotBetween(String value1, String value2) {
            addCriterion("click_tk_urls not between", value1, value2, "clickTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsIsNull() {
            addCriterion("impr_tk_urls is null");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsIsNotNull() {
            addCriterion("impr_tk_urls is not null");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsEqualTo(String value) {
            addCriterion("impr_tk_urls =", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsNotEqualTo(String value) {
            addCriterion("impr_tk_urls <>", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsGreaterThan(String value) {
            addCriterion("impr_tk_urls >", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("impr_tk_urls >=", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsLessThan(String value) {
            addCriterion("impr_tk_urls <", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsLessThanOrEqualTo(String value) {
            addCriterion("impr_tk_urls <=", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsLike(String value) {
            addCriterion("impr_tk_urls like", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsNotLike(String value) {
            addCriterion("impr_tk_urls not like", value, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsIn(List<String> values) {
            addCriterion("impr_tk_urls in", values, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsNotIn(List<String> values) {
            addCriterion("impr_tk_urls not in", values, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsBetween(String value1, String value2) {
            addCriterion("impr_tk_urls between", value1, value2, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andImprTkUrlsNotBetween(String value1, String value2) {
            addCriterion("impr_tk_urls not between", value1, value2, "imprTkUrls");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andRunStatusIsNull() {
            addCriterion("run_status is null");
            return (Criteria) this;
        }

        public Criteria andRunStatusIsNotNull() {
            addCriterion("run_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunStatusEqualTo(Byte value) {
            addCriterion("run_status =", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotEqualTo(Byte value) {
            addCriterion("run_status <>", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThan(Byte value) {
            addCriterion("run_status >", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("run_status >=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThan(Byte value) {
            addCriterion("run_status <", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusLessThanOrEqualTo(Byte value) {
            addCriterion("run_status <=", value, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusIn(List<Byte> values) {
            addCriterion("run_status in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotIn(List<Byte> values) {
            addCriterion("run_status not in", values, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusBetween(Byte value1, Byte value2) {
            addCriterion("run_status between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andRunStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("run_status not between", value1, value2, "runStatus");
            return (Criteria) this;
        }

        public Criteria andLastReasonIsNull() {
            addCriterion("last_reason is null");
            return (Criteria) this;
        }

        public Criteria andLastReasonIsNotNull() {
            addCriterion("last_reason is not null");
            return (Criteria) this;
        }

        public Criteria andLastReasonEqualTo(String value) {
            addCriterion("last_reason =", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonNotEqualTo(String value) {
            addCriterion("last_reason <>", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonGreaterThan(String value) {
            addCriterion("last_reason >", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonGreaterThanOrEqualTo(String value) {
            addCriterion("last_reason >=", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonLessThan(String value) {
            addCriterion("last_reason <", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonLessThanOrEqualTo(String value) {
            addCriterion("last_reason <=", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonLike(String value) {
            addCriterion("last_reason like", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonNotLike(String value) {
            addCriterion("last_reason not like", value, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonIn(List<String> values) {
            addCriterion("last_reason in", values, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonNotIn(List<String> values) {
            addCriterion("last_reason not in", values, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonBetween(String value1, String value2) {
            addCriterion("last_reason between", value1, value2, "lastReason");
            return (Criteria) this;
        }

        public Criteria andLastReasonNotBetween(String value1, String value2) {
            addCriterion("last_reason not between", value1, value2, "lastReason");
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