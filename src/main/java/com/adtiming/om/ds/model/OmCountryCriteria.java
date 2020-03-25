// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmCountryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmCountryCriteria() {
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

        public Criteria andA2IsNull() {
            addCriterion("a2 is null");
            return (Criteria) this;
        }

        public Criteria andA2IsNotNull() {
            addCriterion("a2 is not null");
            return (Criteria) this;
        }

        public Criteria andA2EqualTo(String value) {
            addCriterion("a2 =", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotEqualTo(String value) {
            addCriterion("a2 <>", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThan(String value) {
            addCriterion("a2 >", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2GreaterThanOrEqualTo(String value) {
            addCriterion("a2 >=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThan(String value) {
            addCriterion("a2 <", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2LessThanOrEqualTo(String value) {
            addCriterion("a2 <=", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Like(String value) {
            addCriterion("a2 like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotLike(String value) {
            addCriterion("a2 not like", value, "a2");
            return (Criteria) this;
        }

        public Criteria andA2In(List<String> values) {
            addCriterion("a2 in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotIn(List<String> values) {
            addCriterion("a2 not in", values, "a2");
            return (Criteria) this;
        }

        public Criteria andA2Between(String value1, String value2) {
            addCriterion("a2 between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA2NotBetween(String value1, String value2) {
            addCriterion("a2 not between", value1, value2, "a2");
            return (Criteria) this;
        }

        public Criteria andA3IsNull() {
            addCriterion("a3 is null");
            return (Criteria) this;
        }

        public Criteria andA3IsNotNull() {
            addCriterion("a3 is not null");
            return (Criteria) this;
        }

        public Criteria andA3EqualTo(String value) {
            addCriterion("a3 =", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotEqualTo(String value) {
            addCriterion("a3 <>", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThan(String value) {
            addCriterion("a3 >", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3GreaterThanOrEqualTo(String value) {
            addCriterion("a3 >=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThan(String value) {
            addCriterion("a3 <", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3LessThanOrEqualTo(String value) {
            addCriterion("a3 <=", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Like(String value) {
            addCriterion("a3 like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotLike(String value) {
            addCriterion("a3 not like", value, "a3");
            return (Criteria) this;
        }

        public Criteria andA3In(List<String> values) {
            addCriterion("a3 in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotIn(List<String> values) {
            addCriterion("a3 not in", values, "a3");
            return (Criteria) this;
        }

        public Criteria andA3Between(String value1, String value2) {
            addCriterion("a3 between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andA3NotBetween(String value1, String value2) {
            addCriterion("a3 not between", value1, value2, "a3");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("num like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("num not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andTierIsNull() {
            addCriterion("tier is null");
            return (Criteria) this;
        }

        public Criteria andTierIsNotNull() {
            addCriterion("tier is not null");
            return (Criteria) this;
        }

        public Criteria andTierEqualTo(Byte value) {
            addCriterion("tier =", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotEqualTo(Byte value) {
            addCriterion("tier <>", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierGreaterThan(Byte value) {
            addCriterion("tier >", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierGreaterThanOrEqualTo(Byte value) {
            addCriterion("tier >=", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierLessThan(Byte value) {
            addCriterion("tier <", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierLessThanOrEqualTo(Byte value) {
            addCriterion("tier <=", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierIn(List<Byte> values) {
            addCriterion("tier in", values, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotIn(List<Byte> values) {
            addCriterion("tier not in", values, "tier");
            return (Criteria) this;
        }

        public Criteria andTierBetween(Byte value1, Byte value2) {
            addCriterion("tier between", value1, value2, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotBetween(Byte value1, Byte value2) {
            addCriterion("tier not between", value1, value2, "tier");
            return (Criteria) this;
        }

        public Criteria andContinentIsNull() {
            addCriterion("continent is null");
            return (Criteria) this;
        }

        public Criteria andContinentIsNotNull() {
            addCriterion("continent is not null");
            return (Criteria) this;
        }

        public Criteria andContinentEqualTo(String value) {
            addCriterion("continent =", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotEqualTo(String value) {
            addCriterion("continent <>", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentGreaterThan(String value) {
            addCriterion("continent >", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentGreaterThanOrEqualTo(String value) {
            addCriterion("continent >=", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLessThan(String value) {
            addCriterion("continent <", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLessThanOrEqualTo(String value) {
            addCriterion("continent <=", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentLike(String value) {
            addCriterion("continent like", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotLike(String value) {
            addCriterion("continent not like", value, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentIn(List<String> values) {
            addCriterion("continent in", values, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotIn(List<String> values) {
            addCriterion("continent not in", values, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentBetween(String value1, String value2) {
            addCriterion("continent between", value1, value2, "continent");
            return (Criteria) this;
        }

        public Criteria andContinentNotBetween(String value1, String value2) {
            addCriterion("continent not between", value1, value2, "continent");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNull() {
            addCriterion("capital is null");
            return (Criteria) this;
        }

        public Criteria andCapitalIsNotNull() {
            addCriterion("capital is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalEqualTo(String value) {
            addCriterion("capital =", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotEqualTo(String value) {
            addCriterion("capital <>", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThan(String value) {
            addCriterion("capital >", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalGreaterThanOrEqualTo(String value) {
            addCriterion("capital >=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThan(String value) {
            addCriterion("capital <", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLessThanOrEqualTo(String value) {
            addCriterion("capital <=", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalLike(String value) {
            addCriterion("capital like", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotLike(String value) {
            addCriterion("capital not like", value, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalIn(List<String> values) {
            addCriterion("capital in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotIn(List<String> values) {
            addCriterion("capital not in", values, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalBetween(String value1, String value2) {
            addCriterion("capital between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andCapitalNotBetween(String value1, String value2) {
            addCriterion("capital not between", value1, value2, "capital");
            return (Criteria) this;
        }

        public Criteria andDcenterIsNull() {
            addCriterion("dcenter is null");
            return (Criteria) this;
        }

        public Criteria andDcenterIsNotNull() {
            addCriterion("dcenter is not null");
            return (Criteria) this;
        }

        public Criteria andDcenterEqualTo(Byte value) {
            addCriterion("dcenter =", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterNotEqualTo(Byte value) {
            addCriterion("dcenter <>", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterGreaterThan(Byte value) {
            addCriterion("dcenter >", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterGreaterThanOrEqualTo(Byte value) {
            addCriterion("dcenter >=", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterLessThan(Byte value) {
            addCriterion("dcenter <", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterLessThanOrEqualTo(Byte value) {
            addCriterion("dcenter <=", value, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterIn(List<Byte> values) {
            addCriterion("dcenter in", values, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterNotIn(List<Byte> values) {
            addCriterion("dcenter not in", values, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterBetween(Byte value1, Byte value2) {
            addCriterion("dcenter between", value1, value2, "dcenter");
            return (Criteria) this;
        }

        public Criteria andDcenterNotBetween(Byte value1, Byte value2) {
            addCriterion("dcenter not between", value1, value2, "dcenter");
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

        public Criteria andNameCnIsNull() {
            addCriterion("name_cn is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("name_cn =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("name_cn <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("name_cn >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("name_cn >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("name_cn <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("name_cn <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("name_cn like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("name_cn not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("name_cn in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("name_cn not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("name_cn between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("name_cn not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdIsNull() {
            addCriterion("store_front_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdIsNotNull() {
            addCriterion("store_front_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdEqualTo(Integer value) {
            addCriterion("store_front_id =", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdNotEqualTo(Integer value) {
            addCriterion("store_front_id <>", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdGreaterThan(Integer value) {
            addCriterion("store_front_id >", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_front_id >=", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdLessThan(Integer value) {
            addCriterion("store_front_id <", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdLessThanOrEqualTo(Integer value) {
            addCriterion("store_front_id <=", value, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdIn(List<Integer> values) {
            addCriterion("store_front_id in", values, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdNotIn(List<Integer> values) {
            addCriterion("store_front_id not in", values, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdBetween(Integer value1, Integer value2) {
            addCriterion("store_front_id between", value1, value2, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andStoreFrontIdNotBetween(Integer value1, Integer value2) {
            addCriterion("store_front_id not between", value1, value2, "storeFrontId");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNull() {
            addCriterion("population is null");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNotNull() {
            addCriterion("population is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationEqualTo(Integer value) {
            addCriterion("population =", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotEqualTo(Integer value) {
            addCriterion("population <>", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThan(Integer value) {
            addCriterion("population >", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("population >=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThan(Integer value) {
            addCriterion("population <", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("population <=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationIn(List<Integer> values) {
            addCriterion("population in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotIn(List<Integer> values) {
            addCriterion("population not in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationBetween(Integer value1, Integer value2) {
            addCriterion("population between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("population not between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andMainLangIsNull() {
            addCriterion("main_lang is null");
            return (Criteria) this;
        }

        public Criteria andMainLangIsNotNull() {
            addCriterion("main_lang is not null");
            return (Criteria) this;
        }

        public Criteria andMainLangEqualTo(String value) {
            addCriterion("main_lang =", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangNotEqualTo(String value) {
            addCriterion("main_lang <>", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangGreaterThan(String value) {
            addCriterion("main_lang >", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangGreaterThanOrEqualTo(String value) {
            addCriterion("main_lang >=", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangLessThan(String value) {
            addCriterion("main_lang <", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangLessThanOrEqualTo(String value) {
            addCriterion("main_lang <=", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangLike(String value) {
            addCriterion("main_lang like", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangNotLike(String value) {
            addCriterion("main_lang not like", value, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangIn(List<String> values) {
            addCriterion("main_lang in", values, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangNotIn(List<String> values) {
            addCriterion("main_lang not in", values, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangBetween(String value1, String value2) {
            addCriterion("main_lang between", value1, value2, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMainLangNotBetween(String value1, String value2) {
            addCriterion("main_lang not between", value1, value2, "mainLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangIsNull() {
            addCriterion("muti_lang is null");
            return (Criteria) this;
        }

        public Criteria andMutiLangIsNotNull() {
            addCriterion("muti_lang is not null");
            return (Criteria) this;
        }

        public Criteria andMutiLangEqualTo(String value) {
            addCriterion("muti_lang =", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangNotEqualTo(String value) {
            addCriterion("muti_lang <>", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangGreaterThan(String value) {
            addCriterion("muti_lang >", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangGreaterThanOrEqualTo(String value) {
            addCriterion("muti_lang >=", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangLessThan(String value) {
            addCriterion("muti_lang <", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangLessThanOrEqualTo(String value) {
            addCriterion("muti_lang <=", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangLike(String value) {
            addCriterion("muti_lang like", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangNotLike(String value) {
            addCriterion("muti_lang not like", value, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangIn(List<String> values) {
            addCriterion("muti_lang in", values, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangNotIn(List<String> values) {
            addCriterion("muti_lang not in", values, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangBetween(String value1, String value2) {
            addCriterion("muti_lang between", value1, value2, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andMutiLangNotBetween(String value1, String value2) {
            addCriterion("muti_lang not between", value1, value2, "mutiLang");
            return (Criteria) this;
        }

        public Criteria andTldIsNull() {
            addCriterion("tld is null");
            return (Criteria) this;
        }

        public Criteria andTldIsNotNull() {
            addCriterion("tld is not null");
            return (Criteria) this;
        }

        public Criteria andTldEqualTo(String value) {
            addCriterion("tld =", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldNotEqualTo(String value) {
            addCriterion("tld <>", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldGreaterThan(String value) {
            addCriterion("tld >", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldGreaterThanOrEqualTo(String value) {
            addCriterion("tld >=", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldLessThan(String value) {
            addCriterion("tld <", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldLessThanOrEqualTo(String value) {
            addCriterion("tld <=", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldLike(String value) {
            addCriterion("tld like", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldNotLike(String value) {
            addCriterion("tld not like", value, "tld");
            return (Criteria) this;
        }

        public Criteria andTldIn(List<String> values) {
            addCriterion("tld in", values, "tld");
            return (Criteria) this;
        }

        public Criteria andTldNotIn(List<String> values) {
            addCriterion("tld not in", values, "tld");
            return (Criteria) this;
        }

        public Criteria andTldBetween(String value1, String value2) {
            addCriterion("tld between", value1, value2, "tld");
            return (Criteria) this;
        }

        public Criteria andTldNotBetween(String value1, String value2) {
            addCriterion("tld not between", value1, value2, "tld");
            return (Criteria) this;
        }

        public Criteria andTzIsNull() {
            addCriterion("tz is null");
            return (Criteria) this;
        }

        public Criteria andTzIsNotNull() {
            addCriterion("tz is not null");
            return (Criteria) this;
        }

        public Criteria andTzEqualTo(Byte value) {
            addCriterion("tz =", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzNotEqualTo(Byte value) {
            addCriterion("tz <>", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzGreaterThan(Byte value) {
            addCriterion("tz >", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzGreaterThanOrEqualTo(Byte value) {
            addCriterion("tz >=", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzLessThan(Byte value) {
            addCriterion("tz <", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzLessThanOrEqualTo(Byte value) {
            addCriterion("tz <=", value, "tz");
            return (Criteria) this;
        }

        public Criteria andTzIn(List<Byte> values) {
            addCriterion("tz in", values, "tz");
            return (Criteria) this;
        }

        public Criteria andTzNotIn(List<Byte> values) {
            addCriterion("tz not in", values, "tz");
            return (Criteria) this;
        }

        public Criteria andTzBetween(Byte value1, Byte value2) {
            addCriterion("tz between", value1, value2, "tz");
            return (Criteria) this;
        }

        public Criteria andTzNotBetween(Byte value1, Byte value2) {
            addCriterion("tz not between", value1, value2, "tz");
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