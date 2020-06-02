package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportAdnetworkAccountCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReportAdnetworkAccountCriteria() {
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

        public Criteria andAdnAccountIdIsNull() {
            addCriterion("adn_account_id is null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdIsNotNull() {
            addCriterion("adn_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdEqualTo(Integer value) {
            addCriterion("adn_account_id =", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdNotEqualTo(Integer value) {
            addCriterion("adn_account_id <>", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdGreaterThan(Integer value) {
            addCriterion("adn_account_id >", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adn_account_id >=", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdLessThan(Integer value) {
            addCriterion("adn_account_id <", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("adn_account_id <=", value, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdIn(List<Integer> values) {
            addCriterion("adn_account_id in", values, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdNotIn(List<Integer> values) {
            addCriterion("adn_account_id not in", values, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("adn_account_id between", value1, value2, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adn_account_id not between", value1, value2, "adnAccountId");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameIsNull() {
            addCriterion("adn_account_name is null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameIsNotNull() {
            addCriterion("adn_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameEqualTo(String value) {
            addCriterion("adn_account_name =", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameNotEqualTo(String value) {
            addCriterion("adn_account_name <>", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameGreaterThan(String value) {
            addCriterion("adn_account_name >", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("adn_account_name >=", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameLessThan(String value) {
            addCriterion("adn_account_name <", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameLessThanOrEqualTo(String value) {
            addCriterion("adn_account_name <=", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameLike(String value) {
            addCriterion("adn_account_name like", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameNotLike(String value) {
            addCriterion("adn_account_name not like", value, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameIn(List<String> values) {
            addCriterion("adn_account_name in", values, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameNotIn(List<String> values) {
            addCriterion("adn_account_name not in", values, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameBetween(String value1, String value2) {
            addCriterion("adn_account_name between", value1, value2, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountNameNotBetween(String value1, String value2) {
            addCriterion("adn_account_name not between", value1, value2, "adnAccountName");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerIsNull() {
            addCriterion("adn_account_owner is null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerIsNotNull() {
            addCriterion("adn_account_owner is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerEqualTo(Byte value) {
            addCriterion("adn_account_owner =", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerNotEqualTo(Byte value) {
            addCriterion("adn_account_owner <>", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerGreaterThan(Byte value) {
            addCriterion("adn_account_owner >", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerGreaterThanOrEqualTo(Byte value) {
            addCriterion("adn_account_owner >=", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerLessThan(Byte value) {
            addCriterion("adn_account_owner <", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerLessThanOrEqualTo(Byte value) {
            addCriterion("adn_account_owner <=", value, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerIn(List<Byte> values) {
            addCriterion("adn_account_owner in", values, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerNotIn(List<Byte> values) {
            addCriterion("adn_account_owner not in", values, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerBetween(Byte value1, Byte value2) {
            addCriterion("adn_account_owner between", value1, value2, "adnAccountOwner");
            return (Criteria) this;
        }

        public Criteria andAdnAccountOwnerNotBetween(Byte value1, Byte value2) {
            addCriterion("adn_account_owner not between", value1, value2, "adnAccountOwner");
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

        public Criteria andAdnAppIdEqualTo(String value) {
            addCriterion("adn_app_id =", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotEqualTo(String value) {
            addCriterion("adn_app_id <>", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdGreaterThan(String value) {
            addCriterion("adn_app_id >", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("adn_app_id >=", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdLessThan(String value) {
            addCriterion("adn_app_id <", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdLessThanOrEqualTo(String value) {
            addCriterion("adn_app_id <=", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdLike(String value) {
            addCriterion("adn_app_id like", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotLike(String value) {
            addCriterion("adn_app_id not like", value, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdIn(List<String> values) {
            addCriterion("adn_app_id in", values, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotIn(List<String> values) {
            addCriterion("adn_app_id not in", values, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdBetween(String value1, String value2) {
            addCriterion("adn_app_id between", value1, value2, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnAppIdNotBetween(String value1, String value2) {
            addCriterion("adn_app_id not between", value1, value2, "adnAppId");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyIsNull() {
            addCriterion("adn_api_key is null");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyIsNotNull() {
            addCriterion("adn_api_key is not null");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyEqualTo(String value) {
            addCriterion("adn_api_key =", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyNotEqualTo(String value) {
            addCriterion("adn_api_key <>", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyGreaterThan(String value) {
            addCriterion("adn_api_key >", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("adn_api_key >=", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyLessThan(String value) {
            addCriterion("adn_api_key <", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyLessThanOrEqualTo(String value) {
            addCriterion("adn_api_key <=", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyLike(String value) {
            addCriterion("adn_api_key like", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyNotLike(String value) {
            addCriterion("adn_api_key not like", value, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyIn(List<String> values) {
            addCriterion("adn_api_key in", values, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyNotIn(List<String> values) {
            addCriterion("adn_api_key not in", values, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyBetween(String value1, String value2) {
            addCriterion("adn_api_key between", value1, value2, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnApiKeyNotBetween(String value1, String value2) {
            addCriterion("adn_api_key not between", value1, value2, "adnApiKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenIsNull() {
            addCriterion("adn_app_token is null");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenIsNotNull() {
            addCriterion("adn_app_token is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenEqualTo(String value) {
            addCriterion("adn_app_token =", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenNotEqualTo(String value) {
            addCriterion("adn_app_token <>", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenGreaterThan(String value) {
            addCriterion("adn_app_token >", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenGreaterThanOrEqualTo(String value) {
            addCriterion("adn_app_token >=", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenLessThan(String value) {
            addCriterion("adn_app_token <", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenLessThanOrEqualTo(String value) {
            addCriterion("adn_app_token <=", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenLike(String value) {
            addCriterion("adn_app_token like", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenNotLike(String value) {
            addCriterion("adn_app_token not like", value, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenIn(List<String> values) {
            addCriterion("adn_app_token in", values, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenNotIn(List<String> values) {
            addCriterion("adn_app_token not in", values, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenBetween(String value1, String value2) {
            addCriterion("adn_app_token between", value1, value2, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andAdnAppTokenNotBetween(String value1, String value2) {
            addCriterion("adn_app_token not between", value1, value2, "adnAppToken");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIsNull() {
            addCriterion("user_signature is null");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIsNotNull() {
            addCriterion("user_signature is not null");
            return (Criteria) this;
        }

        public Criteria andUserSignatureEqualTo(String value) {
            addCriterion("user_signature =", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotEqualTo(String value) {
            addCriterion("user_signature <>", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureGreaterThan(String value) {
            addCriterion("user_signature >", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("user_signature >=", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLessThan(String value) {
            addCriterion("user_signature <", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLessThanOrEqualTo(String value) {
            addCriterion("user_signature <=", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureLike(String value) {
            addCriterion("user_signature like", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotLike(String value) {
            addCriterion("user_signature not like", value, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureIn(List<String> values) {
            addCriterion("user_signature in", values, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotIn(List<String> values) {
            addCriterion("user_signature not in", values, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureBetween(String value1, String value2) {
            addCriterion("user_signature between", value1, value2, "userSignature");
            return (Criteria) this;
        }

        public Criteria andUserSignatureNotBetween(String value1, String value2) {
            addCriterion("user_signature not between", value1, value2, "userSignature");
            return (Criteria) this;
        }

        public Criteria andCredentialPathIsNull() {
            addCriterion("credential_path is null");
            return (Criteria) this;
        }

        public Criteria andCredentialPathIsNotNull() {
            addCriterion("credential_path is not null");
            return (Criteria) this;
        }

        public Criteria andCredentialPathEqualTo(String value) {
            addCriterion("credential_path =", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathNotEqualTo(String value) {
            addCriterion("credential_path <>", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathGreaterThan(String value) {
            addCriterion("credential_path >", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathGreaterThanOrEqualTo(String value) {
            addCriterion("credential_path >=", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathLessThan(String value) {
            addCriterion("credential_path <", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathLessThanOrEqualTo(String value) {
            addCriterion("credential_path <=", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathLike(String value) {
            addCriterion("credential_path like", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathNotLike(String value) {
            addCriterion("credential_path not like", value, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathIn(List<String> values) {
            addCriterion("credential_path in", values, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathNotIn(List<String> values) {
            addCriterion("credential_path not in", values, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathBetween(String value1, String value2) {
            addCriterion("credential_path between", value1, value2, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andCredentialPathNotBetween(String value1, String value2) {
            addCriterion("credential_path not between", value1, value2, "credentialPath");
            return (Criteria) this;
        }

        public Criteria andAuthKeyIsNull() {
            addCriterion("auth_key is null");
            return (Criteria) this;
        }

        public Criteria andAuthKeyIsNotNull() {
            addCriterion("auth_key is not null");
            return (Criteria) this;
        }

        public Criteria andAuthKeyEqualTo(String value) {
            addCriterion("auth_key =", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyNotEqualTo(String value) {
            addCriterion("auth_key <>", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyGreaterThan(String value) {
            addCriterion("auth_key >", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyGreaterThanOrEqualTo(String value) {
            addCriterion("auth_key >=", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyLessThan(String value) {
            addCriterion("auth_key <", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyLessThanOrEqualTo(String value) {
            addCriterion("auth_key <=", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyLike(String value) {
            addCriterion("auth_key like", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyNotLike(String value) {
            addCriterion("auth_key not like", value, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyIn(List<String> values) {
            addCriterion("auth_key in", values, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyNotIn(List<String> values) {
            addCriterion("auth_key not in", values, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyBetween(String value1, String value2) {
            addCriterion("auth_key between", value1, value2, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthKeyNotBetween(String value1, String value2) {
            addCriterion("auth_key not between", value1, value2, "authKey");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNull() {
            addCriterion("auth_type is null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIsNotNull() {
            addCriterion("auth_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuthTypeEqualTo(Byte value) {
            addCriterion("auth_type =", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotEqualTo(Byte value) {
            addCriterion("auth_type <>", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThan(Byte value) {
            addCriterion("auth_type >", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("auth_type >=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThan(Byte value) {
            addCriterion("auth_type <", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeLessThanOrEqualTo(Byte value) {
            addCriterion("auth_type <=", value, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeIn(List<Byte> values) {
            addCriterion("auth_type in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotIn(List<Byte> values) {
            addCriterion("auth_type not in", values, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeBetween(Byte value1, Byte value2) {
            addCriterion("auth_type between", value1, value2, "authType");
            return (Criteria) this;
        }

        public Criteria andAuthTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("auth_type not between", value1, value2, "authType");
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

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
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