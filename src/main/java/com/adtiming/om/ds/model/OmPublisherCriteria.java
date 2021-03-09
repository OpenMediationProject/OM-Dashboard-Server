package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmPublisherCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmPublisherCriteria() {
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
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

        public Criteria andVerifyStatusIsNull() {
            addCriterion("verify_status is null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIsNotNull() {
            addCriterion("verify_status is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusEqualTo(Byte value) {
            addCriterion("verify_status =", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotEqualTo(Byte value) {
            addCriterion("verify_status <>", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThan(Byte value) {
            addCriterion("verify_status >", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("verify_status >=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThan(Byte value) {
            addCriterion("verify_status <", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusLessThanOrEqualTo(Byte value) {
            addCriterion("verify_status <=", value, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusIn(List<Byte> values) {
            addCriterion("verify_status in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotIn(List<Byte> values) {
            addCriterion("verify_status not in", values, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusBetween(Byte value1, Byte value2) {
            addCriterion("verify_status between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andVerifyStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("verify_status not between", value1, value2, "verifyStatus");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
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

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
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

        public Criteria andImTypeIsNull() {
            addCriterion("im_type is null");
            return (Criteria) this;
        }

        public Criteria andImTypeIsNotNull() {
            addCriterion("im_type is not null");
            return (Criteria) this;
        }

        public Criteria andImTypeEqualTo(Byte value) {
            addCriterion("im_type =", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeNotEqualTo(Byte value) {
            addCriterion("im_type <>", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeGreaterThan(Byte value) {
            addCriterion("im_type >", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("im_type >=", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeLessThan(Byte value) {
            addCriterion("im_type <", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeLessThanOrEqualTo(Byte value) {
            addCriterion("im_type <=", value, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeIn(List<Byte> values) {
            addCriterion("im_type in", values, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeNotIn(List<Byte> values) {
            addCriterion("im_type not in", values, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeBetween(Byte value1, Byte value2) {
            addCriterion("im_type between", value1, value2, "imType");
            return (Criteria) this;
        }

        public Criteria andImTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("im_type not between", value1, value2, "imType");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerIsNull() {
            addCriterion("publisher_manager is null");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerIsNotNull() {
            addCriterion("publisher_manager is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerEqualTo(Integer value) {
            addCriterion("publisher_manager =", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerNotEqualTo(Integer value) {
            addCriterion("publisher_manager <>", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerGreaterThan(Integer value) {
            addCriterion("publisher_manager >", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher_manager >=", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerLessThan(Integer value) {
            addCriterion("publisher_manager <", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerLessThanOrEqualTo(Integer value) {
            addCriterion("publisher_manager <=", value, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerIn(List<Integer> values) {
            addCriterion("publisher_manager in", values, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerNotIn(List<Integer> values) {
            addCriterion("publisher_manager not in", values, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerBetween(Integer value1, Integer value2) {
            addCriterion("publisher_manager between", value1, value2, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andPublisherManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher_manager not between", value1, value2, "publisherManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerIsNull() {
            addCriterion("account_manager is null");
            return (Criteria) this;
        }

        public Criteria andAccountManagerIsNotNull() {
            addCriterion("account_manager is not null");
            return (Criteria) this;
        }

        public Criteria andAccountManagerEqualTo(Integer value) {
            addCriterion("account_manager =", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerNotEqualTo(Integer value) {
            addCriterion("account_manager <>", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerGreaterThan(Integer value) {
            addCriterion("account_manager >", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_manager >=", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerLessThan(Integer value) {
            addCriterion("account_manager <", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerLessThanOrEqualTo(Integer value) {
            addCriterion("account_manager <=", value, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerIn(List<Integer> values) {
            addCriterion("account_manager in", values, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerNotIn(List<Integer> values) {
            addCriterion("account_manager not in", values, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerBetween(Integer value1, Integer value2) {
            addCriterion("account_manager between", value1, value2, "accountManager");
            return (Criteria) this;
        }

        public Criteria andAccountManagerNotBetween(Integer value1, Integer value2) {
            addCriterion("account_manager not between", value1, value2, "accountManager");
            return (Criteria) this;
        }

        public Criteria andTokenIsNull() {
            addCriterion("token is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("token is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("token =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("token <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("token >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("token >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("token <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("token <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("token like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("token not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("token in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("token not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("token between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("token not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeIsNull() {
            addCriterion("token_create_time is null");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeIsNotNull() {
            addCriterion("token_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeEqualTo(Date value) {
            addCriterion("token_create_time =", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeNotEqualTo(Date value) {
            addCriterion("token_create_time <>", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeGreaterThan(Date value) {
            addCriterion("token_create_time >", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("token_create_time >=", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeLessThan(Date value) {
            addCriterion("token_create_time <", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("token_create_time <=", value, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeIn(List<Date> values) {
            addCriterion("token_create_time in", values, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeNotIn(List<Date> values) {
            addCriterion("token_create_time not in", values, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeBetween(Date value1, Date value2) {
            addCriterion("token_create_time between", value1, value2, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andTokenCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("token_create_time not between", value1, value2, "tokenCreateTime");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNull() {
            addCriterion("skype is null");
            return (Criteria) this;
        }

        public Criteria andSkypeIsNotNull() {
            addCriterion("skype is not null");
            return (Criteria) this;
        }

        public Criteria andSkypeEqualTo(String value) {
            addCriterion("skype =", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotEqualTo(String value) {
            addCriterion("skype <>", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThan(String value) {
            addCriterion("skype >", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeGreaterThanOrEqualTo(String value) {
            addCriterion("skype >=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThan(String value) {
            addCriterion("skype <", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLessThanOrEqualTo(String value) {
            addCriterion("skype <=", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeLike(String value) {
            addCriterion("skype like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotLike(String value) {
            addCriterion("skype not like", value, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeIn(List<String> values) {
            addCriterion("skype in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotIn(List<String> values) {
            addCriterion("skype not in", values, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeBetween(String value1, String value2) {
            addCriterion("skype between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andSkypeNotBetween(String value1, String value2) {
            addCriterion("skype not between", value1, value2, "skype");
            return (Criteria) this;
        }

        public Criteria andWechatQqIsNull() {
            addCriterion("wechat_qq is null");
            return (Criteria) this;
        }

        public Criteria andWechatQqIsNotNull() {
            addCriterion("wechat_qq is not null");
            return (Criteria) this;
        }

        public Criteria andWechatQqEqualTo(String value) {
            addCriterion("wechat_qq =", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqNotEqualTo(String value) {
            addCriterion("wechat_qq <>", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqGreaterThan(String value) {
            addCriterion("wechat_qq >", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_qq >=", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqLessThan(String value) {
            addCriterion("wechat_qq <", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqLessThanOrEqualTo(String value) {
            addCriterion("wechat_qq <=", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqLike(String value) {
            addCriterion("wechat_qq like", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqNotLike(String value) {
            addCriterion("wechat_qq not like", value, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqIn(List<String> values) {
            addCriterion("wechat_qq in", values, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqNotIn(List<String> values) {
            addCriterion("wechat_qq not in", values, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqBetween(String value1, String value2) {
            addCriterion("wechat_qq between", value1, value2, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andWechatQqNotBetween(String value1, String value2) {
            addCriterion("wechat_qq not between", value1, value2, "wechatQq");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountIsNull() {
            addCriterion("facebook_account is null");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountIsNotNull() {
            addCriterion("facebook_account is not null");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountEqualTo(String value) {
            addCriterion("facebook_account =", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountNotEqualTo(String value) {
            addCriterion("facebook_account <>", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountGreaterThan(String value) {
            addCriterion("facebook_account >", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountGreaterThanOrEqualTo(String value) {
            addCriterion("facebook_account >=", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountLessThan(String value) {
            addCriterion("facebook_account <", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountLessThanOrEqualTo(String value) {
            addCriterion("facebook_account <=", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountLike(String value) {
            addCriterion("facebook_account like", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountNotLike(String value) {
            addCriterion("facebook_account not like", value, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountIn(List<String> values) {
            addCriterion("facebook_account in", values, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountNotIn(List<String> values) {
            addCriterion("facebook_account not in", values, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountBetween(String value1, String value2) {
            addCriterion("facebook_account between", value1, value2, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andFacebookAccountNotBetween(String value1, String value2) {
            addCriterion("facebook_account not between", value1, value2, "facebookAccount");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIsNull() {
            addCriterion("owner_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIsNotNull() {
            addCriterion("owner_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdEqualTo(Integer value) {
            addCriterion("owner_user_id =", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotEqualTo(Integer value) {
            addCriterion("owner_user_id <>", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdGreaterThan(Integer value) {
            addCriterion("owner_user_id >", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_user_id >=", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdLessThan(Integer value) {
            addCriterion("owner_user_id <", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_user_id <=", value, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdIn(List<Integer> values) {
            addCriterion("owner_user_id in", values, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotIn(List<Integer> values) {
            addCriterion("owner_user_id not in", values, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_user_id between", value1, value2, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andOwnerUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_user_id not between", value1, value2, "ownerUserId");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchIsNull() {
            addCriterion("impr_callback_switch is null");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchIsNotNull() {
            addCriterion("impr_callback_switch is not null");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchEqualTo(Byte value) {
            addCriterion("impr_callback_switch =", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchNotEqualTo(Byte value) {
            addCriterion("impr_callback_switch <>", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchGreaterThan(Byte value) {
            addCriterion("impr_callback_switch >", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchGreaterThanOrEqualTo(Byte value) {
            addCriterion("impr_callback_switch >=", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchLessThan(Byte value) {
            addCriterion("impr_callback_switch <", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchLessThanOrEqualTo(Byte value) {
            addCriterion("impr_callback_switch <=", value, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchIn(List<Byte> values) {
            addCriterion("impr_callback_switch in", values, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchNotIn(List<Byte> values) {
            addCriterion("impr_callback_switch not in", values, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchBetween(Byte value1, Byte value2) {
            addCriterion("impr_callback_switch between", value1, value2, "imprCallbackSwitch");
            return (Criteria) this;
        }

        public Criteria andImprCallbackSwitchNotBetween(Byte value1, Byte value2) {
            addCriterion("impr_callback_switch not between", value1, value2, "imprCallbackSwitch");
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