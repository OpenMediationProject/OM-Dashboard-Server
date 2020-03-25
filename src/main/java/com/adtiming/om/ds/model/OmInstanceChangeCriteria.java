package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmInstanceChangeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmInstanceChangeCriteria() {
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

        public Criteria andPlacementKeyIsNull() {
            addCriterion("placement_key is null");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyIsNotNull() {
            addCriterion("placement_key is not null");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyEqualTo(String value) {
            addCriterion("placement_key =", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyNotEqualTo(String value) {
            addCriterion("placement_key <>", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyGreaterThan(String value) {
            addCriterion("placement_key >", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyGreaterThanOrEqualTo(String value) {
            addCriterion("placement_key >=", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyLessThan(String value) {
            addCriterion("placement_key <", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyLessThanOrEqualTo(String value) {
            addCriterion("placement_key <=", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyLike(String value) {
            addCriterion("placement_key like", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyNotLike(String value) {
            addCriterion("placement_key not like", value, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyIn(List<String> values) {
            addCriterion("placement_key in", values, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyNotIn(List<String> values) {
            addCriterion("placement_key not in", values, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyBetween(String value1, String value2) {
            addCriterion("placement_key between", value1, value2, "placementKey");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyNotBetween(String value1, String value2) {
            addCriterion("placement_key not between", value1, value2, "placementKey");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIsNull() {
            addCriterion("instance_name is null");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIsNotNull() {
            addCriterion("instance_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceNameEqualTo(String value) {
            addCriterion("instance_name =", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotEqualTo(String value) {
            addCriterion("instance_name <>", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameGreaterThan(String value) {
            addCriterion("instance_name >", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameGreaterThanOrEqualTo(String value) {
            addCriterion("instance_name >=", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLessThan(String value) {
            addCriterion("instance_name <", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLessThanOrEqualTo(String value) {
            addCriterion("instance_name <=", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLike(String value) {
            addCriterion("instance_name like", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotLike(String value) {
            addCriterion("instance_name not like", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIn(List<String> values) {
            addCriterion("instance_name in", values, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotIn(List<String> values) {
            addCriterion("instance_name not in", values, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameBetween(String value1, String value2) {
            addCriterion("instance_name between", value1, value2, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotBetween(String value1, String value2) {
            addCriterion("instance_name not between", value1, value2, "instanceName");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdIsNull() {
            addCriterion("adn_app_id is null");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdIsNotNull() {
            addCriterion("adn_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdEqualTo(Integer value) {
            addCriterion("adn_app_id =", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotEqualTo(Integer value) {
            addCriterion("adn_app_id <>", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdGreaterThan(Integer value) {
            addCriterion("adn_app_id >", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adn_app_id >=", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdLessThan(Integer value) {
            addCriterion("adn_app_id <", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdLessThanOrEqualTo(Integer value) {
            addCriterion("adn_app_id <=", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdIn(List<Integer> values) {
            addCriterion("adn_app_id in", values, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotIn(List<Integer> values) {
            addCriterion("adn_app_id not in", values, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdBetween(Integer value1, Integer value2) {
            addCriterion("adn_app_id between", value1, value2, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adn_app_id not between", value1, value2, "adnAppId");
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

        public Criteria andAbTestModeIsNull() {
            addCriterion("ab_test_mode is null");
            return (Criteria) this;
        }

        public Criteria andAbTestModeIsNotNull() {
            addCriterion("ab_test_mode is not null");
            return (Criteria) this;
        }

        public Criteria andAbTestModeEqualTo(Byte value) {
            addCriterion("ab_test_mode =", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeNotEqualTo(Byte value) {
            addCriterion("ab_test_mode <>", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeGreaterThan(Byte value) {
            addCriterion("ab_test_mode >", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ab_test_mode >=", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeLessThan(Byte value) {
            addCriterion("ab_test_mode <", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeLessThanOrEqualTo(Byte value) {
            addCriterion("ab_test_mode <=", value, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeIn(List<Byte> values) {
            addCriterion("ab_test_mode in", values, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeNotIn(List<Byte> values) {
            addCriterion("ab_test_mode not in", values, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeBetween(Byte value1, Byte value2) {
            addCriterion("ab_test_mode between", value1, value2, "abTestMode");
            return (Criteria) this;
        }

        public Criteria andAbTestModeNotBetween(Byte value1, Byte value2) {
            addCriterion("ab_test_mode not between", value1, value2, "abTestMode");
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