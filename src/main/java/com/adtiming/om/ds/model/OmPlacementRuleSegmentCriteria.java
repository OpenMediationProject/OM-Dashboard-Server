package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmPlacementRuleSegmentCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmPlacementRuleSegmentCriteria() {
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

        public Criteria andCountriesIsNull() {
            addCriterion("countries is null");
            return (Criteria) this;
        }

        public Criteria andCountriesIsNotNull() {
            addCriterion("countries is not null");
            return (Criteria) this;
        }

        public Criteria andCountriesEqualTo(String value) {
            addCriterion("countries =", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotEqualTo(String value) {
            addCriterion("countries <>", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThan(String value) {
            addCriterion("countries >", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesGreaterThanOrEqualTo(String value) {
            addCriterion("countries >=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThan(String value) {
            addCriterion("countries <", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLessThanOrEqualTo(String value) {
            addCriterion("countries <=", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesLike(String value) {
            addCriterion("countries like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotLike(String value) {
            addCriterion("countries not like", value, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesIn(List<String> values) {
            addCriterion("countries in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotIn(List<String> values) {
            addCriterion("countries not in", values, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesBetween(String value1, String value2) {
            addCriterion("countries between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andCountriesNotBetween(String value1, String value2) {
            addCriterion("countries not between", value1, value2, "countries");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andConTypeIsNull() {
            addCriterion("con_type is null");
            return (Criteria) this;
        }

        public Criteria andConTypeIsNotNull() {
            addCriterion("con_type is not null");
            return (Criteria) this;
        }

        public Criteria andConTypeEqualTo(Byte value) {
            addCriterion("con_type =", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotEqualTo(Byte value) {
            addCriterion("con_type <>", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeGreaterThan(Byte value) {
            addCriterion("con_type >", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("con_type >=", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeLessThan(Byte value) {
            addCriterion("con_type <", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeLessThanOrEqualTo(Byte value) {
            addCriterion("con_type <=", value, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeIn(List<Byte> values) {
            addCriterion("con_type in", values, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotIn(List<Byte> values) {
            addCriterion("con_type not in", values, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeBetween(Byte value1, Byte value2) {
            addCriterion("con_type between", value1, value2, "conType");
            return (Criteria) this;
        }

        public Criteria andConTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("con_type not between", value1, value2, "conType");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeMinIsNull() {
            addCriterion("age_min is null");
            return (Criteria) this;
        }

        public Criteria andAgeMinIsNotNull() {
            addCriterion("age_min is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMinEqualTo(Integer value) {
            addCriterion("age_min =", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotEqualTo(Integer value) {
            addCriterion("age_min <>", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThan(Integer value) {
            addCriterion("age_min >", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("age_min >=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThan(Integer value) {
            addCriterion("age_min <", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinLessThanOrEqualTo(Integer value) {
            addCriterion("age_min <=", value, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinIn(List<Integer> values) {
            addCriterion("age_min in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotIn(List<Integer> values) {
            addCriterion("age_min not in", values, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinBetween(Integer value1, Integer value2) {
            addCriterion("age_min between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMinNotBetween(Integer value1, Integer value2) {
            addCriterion("age_min not between", value1, value2, "ageMin");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNull() {
            addCriterion("age_max is null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIsNotNull() {
            addCriterion("age_max is not null");
            return (Criteria) this;
        }

        public Criteria andAgeMaxEqualTo(Integer value) {
            addCriterion("age_max =", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotEqualTo(Integer value) {
            addCriterion("age_max <>", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThan(Integer value) {
            addCriterion("age_max >", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("age_max >=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThan(Integer value) {
            addCriterion("age_max <", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxLessThanOrEqualTo(Integer value) {
            addCriterion("age_max <=", value, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxIn(List<Integer> values) {
            addCriterion("age_max in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotIn(List<Integer> values) {
            addCriterion("age_max not in", values, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxBetween(Integer value1, Integer value2) {
            addCriterion("age_max between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andAgeMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("age_max not between", value1, value2, "ageMax");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andIapMinIsNull() {
            addCriterion("iap_min is null");
            return (Criteria) this;
        }

        public Criteria andIapMinIsNotNull() {
            addCriterion("iap_min is not null");
            return (Criteria) this;
        }

        public Criteria andIapMinEqualTo(BigDecimal value) {
            addCriterion("iap_min =", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinNotEqualTo(BigDecimal value) {
            addCriterion("iap_min <>", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinGreaterThan(BigDecimal value) {
            addCriterion("iap_min >", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_min >=", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinLessThan(BigDecimal value) {
            addCriterion("iap_min <", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_min <=", value, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinIn(List<BigDecimal> values) {
            addCriterion("iap_min in", values, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinNotIn(List<BigDecimal> values) {
            addCriterion("iap_min not in", values, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_min between", value1, value2, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_min not between", value1, value2, "iapMin");
            return (Criteria) this;
        }

        public Criteria andIapMaxIsNull() {
            addCriterion("iap_max is null");
            return (Criteria) this;
        }

        public Criteria andIapMaxIsNotNull() {
            addCriterion("iap_max is not null");
            return (Criteria) this;
        }

        public Criteria andIapMaxEqualTo(BigDecimal value) {
            addCriterion("iap_max =", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxNotEqualTo(BigDecimal value) {
            addCriterion("iap_max <>", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxGreaterThan(BigDecimal value) {
            addCriterion("iap_max >", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_max >=", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxLessThan(BigDecimal value) {
            addCriterion("iap_max <", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iap_max <=", value, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxIn(List<BigDecimal> values) {
            addCriterion("iap_max in", values, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxNotIn(List<BigDecimal> values) {
            addCriterion("iap_max not in", values, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_max between", value1, value2, "iapMax");
            return (Criteria) this;
        }

        public Criteria andIapMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iap_max not between", value1, value2, "iapMax");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBowIsNull() {
            addCriterion("channel_bow is null");
            return (Criteria) this;
        }

        public Criteria andChannelBowIsNotNull() {
            addCriterion("channel_bow is not null");
            return (Criteria) this;
        }

        public Criteria andChannelBowEqualTo(Byte value) {
            addCriterion("channel_bow =", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowNotEqualTo(Byte value) {
            addCriterion("channel_bow <>", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowGreaterThan(Byte value) {
            addCriterion("channel_bow >", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowGreaterThanOrEqualTo(Byte value) {
            addCriterion("channel_bow >=", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowLessThan(Byte value) {
            addCriterion("channel_bow <", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowLessThanOrEqualTo(Byte value) {
            addCriterion("channel_bow <=", value, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowIn(List<Byte> values) {
            addCriterion("channel_bow in", values, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowNotIn(List<Byte> values) {
            addCriterion("channel_bow not in", values, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowBetween(Byte value1, Byte value2) {
            addCriterion("channel_bow between", value1, value2, "channelBow");
            return (Criteria) this;
        }

        public Criteria andChannelBowNotBetween(Byte value1, Byte value2) {
            addCriterion("channel_bow not between", value1, value2, "channelBow");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Integer value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Integer value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Integer value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Integer value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Integer> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Integer> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Integer value1, Integer value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
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