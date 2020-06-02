package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmAdnetworkAppChangeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmAdnetworkAppChangeCriteria() {
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

        public Criteria andAdnAppKeyIsNull() {
            addCriterion("adn_app_key is null");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyIsNotNull() {
            addCriterion("adn_app_key is not null");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyEqualTo(String value) {
            addCriterion("adn_app_key =", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyNotEqualTo(String value) {
            addCriterion("adn_app_key <>", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyGreaterThan(String value) {
            addCriterion("adn_app_key >", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyGreaterThanOrEqualTo(String value) {
            addCriterion("adn_app_key >=", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyLessThan(String value) {
            addCriterion("adn_app_key <", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyLessThanOrEqualTo(String value) {
            addCriterion("adn_app_key <=", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyLike(String value) {
            addCriterion("adn_app_key like", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyNotLike(String value) {
            addCriterion("adn_app_key not like", value, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyIn(List<String> values) {
            addCriterion("adn_app_key in", values, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyNotIn(List<String> values) {
            addCriterion("adn_app_key not in", values, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyBetween(String value1, String value2) {
            addCriterion("adn_app_key between", value1, value2, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andAdnAppKeyNotBetween(String value1, String value2) {
            addCriterion("adn_app_key not between", value1, value2, "adnAppKey");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNull() {
            addCriterion("client_secret is null");
            return (Criteria) this;
        }

        public Criteria andClientSecretIsNotNull() {
            addCriterion("client_secret is not null");
            return (Criteria) this;
        }

        public Criteria andClientSecretEqualTo(String value) {
            addCriterion("client_secret =", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotEqualTo(String value) {
            addCriterion("client_secret <>", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThan(String value) {
            addCriterion("client_secret >", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretGreaterThanOrEqualTo(String value) {
            addCriterion("client_secret >=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThan(String value) {
            addCriterion("client_secret <", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLessThanOrEqualTo(String value) {
            addCriterion("client_secret <=", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretLike(String value) {
            addCriterion("client_secret like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotLike(String value) {
            addCriterion("client_secret not like", value, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretIn(List<String> values) {
            addCriterion("client_secret in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotIn(List<String> values) {
            addCriterion("client_secret not in", values, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretBetween(String value1, String value2) {
            addCriterion("client_secret between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andClientSecretNotBetween(String value1, String value2) {
            addCriterion("client_secret not between", value1, value2, "clientSecret");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNull() {
            addCriterion("refresh_token is null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIsNotNull() {
            addCriterion("refresh_token is not null");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenEqualTo(String value) {
            addCriterion("refresh_token =", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotEqualTo(String value) {
            addCriterion("refresh_token <>", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThan(String value) {
            addCriterion("refresh_token >", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenGreaterThanOrEqualTo(String value) {
            addCriterion("refresh_token >=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThan(String value) {
            addCriterion("refresh_token <", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLessThanOrEqualTo(String value) {
            addCriterion("refresh_token <=", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenLike(String value) {
            addCriterion("refresh_token like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotLike(String value) {
            addCriterion("refresh_token not like", value, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenIn(List<String> values) {
            addCriterion("refresh_token in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotIn(List<String> values) {
            addCriterion("refresh_token not in", values, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenBetween(String value1, String value2) {
            addCriterion("refresh_token between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andRefreshTokenNotBetween(String value1, String value2) {
            addCriterion("refresh_token not between", value1, value2, "refreshToken");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNull() {
            addCriterion("api_key is null");
            return (Criteria) this;
        }

        public Criteria andApiKeyIsNotNull() {
            addCriterion("api_key is not null");
            return (Criteria) this;
        }

        public Criteria andApiKeyEqualTo(String value) {
            addCriterion("api_key =", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotEqualTo(String value) {
            addCriterion("api_key <>", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThan(String value) {
            addCriterion("api_key >", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("api_key >=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThan(String value) {
            addCriterion("api_key <", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLessThanOrEqualTo(String value) {
            addCriterion("api_key <=", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyLike(String value) {
            addCriterion("api_key like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotLike(String value) {
            addCriterion("api_key not like", value, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyIn(List<String> values) {
            addCriterion("api_key in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotIn(List<String> values) {
            addCriterion("api_key not in", values, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyBetween(String value1, String value2) {
            addCriterion("api_key between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andApiKeyNotBetween(String value1, String value2) {
            addCriterion("api_key not between", value1, value2, "apiKey");
            return (Criteria) this;
        }

        public Criteria andReportAppIdIsNull() {
            addCriterion("report_app_id is null");
            return (Criteria) this;
        }

        public Criteria andReportAppIdIsNotNull() {
            addCriterion("report_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportAppIdEqualTo(String value) {
            addCriterion("report_app_id =", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdNotEqualTo(String value) {
            addCriterion("report_app_id <>", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdGreaterThan(String value) {
            addCriterion("report_app_id >", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_app_id >=", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdLessThan(String value) {
            addCriterion("report_app_id <", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdLessThanOrEqualTo(String value) {
            addCriterion("report_app_id <=", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdLike(String value) {
            addCriterion("report_app_id like", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdNotLike(String value) {
            addCriterion("report_app_id not like", value, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdIn(List<String> values) {
            addCriterion("report_app_id in", values, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdNotIn(List<String> values) {
            addCriterion("report_app_id not in", values, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdBetween(String value1, String value2) {
            addCriterion("report_app_id between", value1, value2, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andReportAppIdNotBetween(String value1, String value2) {
            addCriterion("report_app_id not between", value1, value2, "reportAppId");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyIsNull() {
            addCriterion("new_account_key is null");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyIsNotNull() {
            addCriterion("new_account_key is not null");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyEqualTo(String value) {
            addCriterion("new_account_key =", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyNotEqualTo(String value) {
            addCriterion("new_account_key <>", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyGreaterThan(String value) {
            addCriterion("new_account_key >", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyGreaterThanOrEqualTo(String value) {
            addCriterion("new_account_key >=", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyLessThan(String value) {
            addCriterion("new_account_key <", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyLessThanOrEqualTo(String value) {
            addCriterion("new_account_key <=", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyLike(String value) {
            addCriterion("new_account_key like", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyNotLike(String value) {
            addCriterion("new_account_key not like", value, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyIn(List<String> values) {
            addCriterion("new_account_key in", values, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyNotIn(List<String> values) {
            addCriterion("new_account_key not in", values, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyBetween(String value1, String value2) {
            addCriterion("new_account_key between", value1, value2, "newAccountKey");
            return (Criteria) this;
        }

        public Criteria andNewAccountKeyNotBetween(String value1, String value2) {
            addCriterion("new_account_key not between", value1, value2, "newAccountKey");
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

        public Criteria andNewReportAccountIdIsNull() {
            addCriterion("new_report_account_id is null");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdIsNotNull() {
            addCriterion("new_report_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdEqualTo(Integer value) {
            addCriterion("new_report_account_id =", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdNotEqualTo(Integer value) {
            addCriterion("new_report_account_id <>", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdGreaterThan(Integer value) {
            addCriterion("new_report_account_id >", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_report_account_id >=", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdLessThan(Integer value) {
            addCriterion("new_report_account_id <", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("new_report_account_id <=", value, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdIn(List<Integer> values) {
            addCriterion("new_report_account_id in", values, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdNotIn(List<Integer> values) {
            addCriterion("new_report_account_id not in", values, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("new_report_account_id between", value1, value2, "newReportAccountId");
            return (Criteria) this;
        }

        public Criteria andNewReportAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("new_report_account_id not between", value1, value2, "newReportAccountId");
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