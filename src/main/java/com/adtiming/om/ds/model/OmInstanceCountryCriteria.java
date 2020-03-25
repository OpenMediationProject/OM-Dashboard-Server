// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmInstanceCountryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmInstanceCountryCriteria() {
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

        public Criteria andAdnIdIsNull() {
            addCriterion("adn_id is null");
            return (Criteria) this;
        }

        public Criteria andAdnIdIsNotNull() {
            addCriterion("adn_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdnIdEqualTo(Byte value) {
            addCriterion("adn_id =", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotEqualTo(Byte value) {
            addCriterion("adn_id <>", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdGreaterThan(Byte value) {
            addCriterion("adn_id >", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("adn_id >=", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdLessThan(Byte value) {
            addCriterion("adn_id <", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdLessThanOrEqualTo(Byte value) {
            addCriterion("adn_id <=", value, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdIn(List<Byte> values) {
            addCriterion("adn_id in", values, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotIn(List<Byte> values) {
            addCriterion("adn_id not in", values, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdBetween(Byte value1, Byte value2) {
            addCriterion("adn_id between", value1, value2, "adnId");
            return (Criteria) this;
        }

        public Criteria andAdnIdNotBetween(Byte value1, Byte value2) {
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

        public Criteria andRevenueSharingIsNull() {
            addCriterion("revenue_sharing is null");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingIsNotNull() {
            addCriterion("revenue_sharing is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingEqualTo(BigDecimal value) {
            addCriterion("revenue_sharing =", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingNotEqualTo(BigDecimal value) {
            addCriterion("revenue_sharing <>", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingGreaterThan(BigDecimal value) {
            addCriterion("revenue_sharing >", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_sharing >=", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingLessThan(BigDecimal value) {
            addCriterion("revenue_sharing <", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("revenue_sharing <=", value, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingIn(List<BigDecimal> values) {
            addCriterion("revenue_sharing in", values, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingNotIn(List<BigDecimal> values) {
            addCriterion("revenue_sharing not in", values, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_sharing between", value1, value2, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andRevenueSharingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("revenue_sharing not between", value1, value2, "revenueSharing");
            return (Criteria) this;
        }

        public Criteria andEcpmIsNull() {
            addCriterion("ecpm is null");
            return (Criteria) this;
        }

        public Criteria andEcpmIsNotNull() {
            addCriterion("ecpm is not null");
            return (Criteria) this;
        }

        public Criteria andEcpmEqualTo(BigDecimal value) {
            addCriterion("ecpm =", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmNotEqualTo(BigDecimal value) {
            addCriterion("ecpm <>", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmGreaterThan(BigDecimal value) {
            addCriterion("ecpm >", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ecpm >=", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmLessThan(BigDecimal value) {
            addCriterion("ecpm <", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ecpm <=", value, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmIn(List<BigDecimal> values) {
            addCriterion("ecpm in", values, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmNotIn(List<BigDecimal> values) {
            addCriterion("ecpm not in", values, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ecpm between", value1, value2, "ecpm");
            return (Criteria) this;
        }

        public Criteria andEcpmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ecpm not between", value1, value2, "ecpm");
            return (Criteria) this;
        }

        public Criteria andHour0IsNull() {
            addCriterion("hour0 is null");
            return (Criteria) this;
        }

        public Criteria andHour0IsNotNull() {
            addCriterion("hour0 is not null");
            return (Criteria) this;
        }

        public Criteria andHour0EqualTo(Integer value) {
            addCriterion("hour0 =", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotEqualTo(Integer value) {
            addCriterion("hour0 <>", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0GreaterThan(Integer value) {
            addCriterion("hour0 >", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour0 >=", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0LessThan(Integer value) {
            addCriterion("hour0 <", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0LessThanOrEqualTo(Integer value) {
            addCriterion("hour0 <=", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0In(List<Integer> values) {
            addCriterion("hour0 in", values, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotIn(List<Integer> values) {
            addCriterion("hour0 not in", values, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0Between(Integer value1, Integer value2) {
            addCriterion("hour0 between", value1, value2, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotBetween(Integer value1, Integer value2) {
            addCriterion("hour0 not between", value1, value2, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour1IsNull() {
            addCriterion("hour1 is null");
            return (Criteria) this;
        }

        public Criteria andHour1IsNotNull() {
            addCriterion("hour1 is not null");
            return (Criteria) this;
        }

        public Criteria andHour1EqualTo(Integer value) {
            addCriterion("hour1 =", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotEqualTo(Integer value) {
            addCriterion("hour1 <>", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThan(Integer value) {
            addCriterion("hour1 >", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour1 >=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThan(Integer value) {
            addCriterion("hour1 <", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThanOrEqualTo(Integer value) {
            addCriterion("hour1 <=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1In(List<Integer> values) {
            addCriterion("hour1 in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotIn(List<Integer> values) {
            addCriterion("hour1 not in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1Between(Integer value1, Integer value2) {
            addCriterion("hour1 between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotBetween(Integer value1, Integer value2) {
            addCriterion("hour1 not between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour2IsNull() {
            addCriterion("hour2 is null");
            return (Criteria) this;
        }

        public Criteria andHour2IsNotNull() {
            addCriterion("hour2 is not null");
            return (Criteria) this;
        }

        public Criteria andHour2EqualTo(Integer value) {
            addCriterion("hour2 =", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotEqualTo(Integer value) {
            addCriterion("hour2 <>", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2GreaterThan(Integer value) {
            addCriterion("hour2 >", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour2 >=", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2LessThan(Integer value) {
            addCriterion("hour2 <", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2LessThanOrEqualTo(Integer value) {
            addCriterion("hour2 <=", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2In(List<Integer> values) {
            addCriterion("hour2 in", values, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotIn(List<Integer> values) {
            addCriterion("hour2 not in", values, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2Between(Integer value1, Integer value2) {
            addCriterion("hour2 between", value1, value2, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotBetween(Integer value1, Integer value2) {
            addCriterion("hour2 not between", value1, value2, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour3IsNull() {
            addCriterion("hour3 is null");
            return (Criteria) this;
        }

        public Criteria andHour3IsNotNull() {
            addCriterion("hour3 is not null");
            return (Criteria) this;
        }

        public Criteria andHour3EqualTo(Integer value) {
            addCriterion("hour3 =", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotEqualTo(Integer value) {
            addCriterion("hour3 <>", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3GreaterThan(Integer value) {
            addCriterion("hour3 >", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour3 >=", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3LessThan(Integer value) {
            addCriterion("hour3 <", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3LessThanOrEqualTo(Integer value) {
            addCriterion("hour3 <=", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3In(List<Integer> values) {
            addCriterion("hour3 in", values, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotIn(List<Integer> values) {
            addCriterion("hour3 not in", values, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3Between(Integer value1, Integer value2) {
            addCriterion("hour3 between", value1, value2, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotBetween(Integer value1, Integer value2) {
            addCriterion("hour3 not between", value1, value2, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour4IsNull() {
            addCriterion("hour4 is null");
            return (Criteria) this;
        }

        public Criteria andHour4IsNotNull() {
            addCriterion("hour4 is not null");
            return (Criteria) this;
        }

        public Criteria andHour4EqualTo(Integer value) {
            addCriterion("hour4 =", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotEqualTo(Integer value) {
            addCriterion("hour4 <>", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4GreaterThan(Integer value) {
            addCriterion("hour4 >", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour4 >=", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4LessThan(Integer value) {
            addCriterion("hour4 <", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4LessThanOrEqualTo(Integer value) {
            addCriterion("hour4 <=", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4In(List<Integer> values) {
            addCriterion("hour4 in", values, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotIn(List<Integer> values) {
            addCriterion("hour4 not in", values, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4Between(Integer value1, Integer value2) {
            addCriterion("hour4 between", value1, value2, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotBetween(Integer value1, Integer value2) {
            addCriterion("hour4 not between", value1, value2, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour5IsNull() {
            addCriterion("hour5 is null");
            return (Criteria) this;
        }

        public Criteria andHour5IsNotNull() {
            addCriterion("hour5 is not null");
            return (Criteria) this;
        }

        public Criteria andHour5EqualTo(Integer value) {
            addCriterion("hour5 =", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotEqualTo(Integer value) {
            addCriterion("hour5 <>", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5GreaterThan(Integer value) {
            addCriterion("hour5 >", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour5 >=", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5LessThan(Integer value) {
            addCriterion("hour5 <", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5LessThanOrEqualTo(Integer value) {
            addCriterion("hour5 <=", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5In(List<Integer> values) {
            addCriterion("hour5 in", values, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotIn(List<Integer> values) {
            addCriterion("hour5 not in", values, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5Between(Integer value1, Integer value2) {
            addCriterion("hour5 between", value1, value2, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotBetween(Integer value1, Integer value2) {
            addCriterion("hour5 not between", value1, value2, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour6IsNull() {
            addCriterion("hour6 is null");
            return (Criteria) this;
        }

        public Criteria andHour6IsNotNull() {
            addCriterion("hour6 is not null");
            return (Criteria) this;
        }

        public Criteria andHour6EqualTo(Integer value) {
            addCriterion("hour6 =", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotEqualTo(Integer value) {
            addCriterion("hour6 <>", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6GreaterThan(Integer value) {
            addCriterion("hour6 >", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour6 >=", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6LessThan(Integer value) {
            addCriterion("hour6 <", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6LessThanOrEqualTo(Integer value) {
            addCriterion("hour6 <=", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6In(List<Integer> values) {
            addCriterion("hour6 in", values, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotIn(List<Integer> values) {
            addCriterion("hour6 not in", values, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6Between(Integer value1, Integer value2) {
            addCriterion("hour6 between", value1, value2, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotBetween(Integer value1, Integer value2) {
            addCriterion("hour6 not between", value1, value2, "hour6");
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