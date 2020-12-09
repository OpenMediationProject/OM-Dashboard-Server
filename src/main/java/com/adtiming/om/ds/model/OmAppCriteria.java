// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmAppCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmAppCriteria() {
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

        public Criteria andOtherStoreIdIsNull() {
            addCriterion("other_store_id is null");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdIsNotNull() {
            addCriterion("other_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdEqualTo(String value) {
            addCriterion("other_store_id =", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdNotEqualTo(String value) {
            addCriterion("other_store_id <>", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdGreaterThan(String value) {
            addCriterion("other_store_id >", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("other_store_id >=", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdLessThan(String value) {
            addCriterion("other_store_id <", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdLessThanOrEqualTo(String value) {
            addCriterion("other_store_id <=", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdLike(String value) {
            addCriterion("other_store_id like", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdNotLike(String value) {
            addCriterion("other_store_id not like", value, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdIn(List<String> values) {
            addCriterion("other_store_id in", values, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdNotIn(List<String> values) {
            addCriterion("other_store_id not in", values, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdBetween(String value1, String value2) {
            addCriterion("other_store_id between", value1, value2, "otherStoreId");
            return (Criteria) this;
        }

        public Criteria andOtherStoreIdNotBetween(String value1, String value2) {
            addCriterion("other_store_id not between", value1, value2, "otherStoreId");
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

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
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

        public Criteria andSubCategoryId1IsNull() {
            addCriterion("sub_category_id1 is null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1IsNotNull() {
            addCriterion("sub_category_id1 is not null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1EqualTo(Integer value) {
            addCriterion("sub_category_id1 =", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1NotEqualTo(Integer value) {
            addCriterion("sub_category_id1 <>", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1GreaterThan(Integer value) {
            addCriterion("sub_category_id1 >", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id1 >=", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1LessThan(Integer value) {
            addCriterion("sub_category_id1 <", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1LessThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id1 <=", value, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1In(List<Integer> values) {
            addCriterion("sub_category_id1 in", values, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1NotIn(List<Integer> values) {
            addCriterion("sub_category_id1 not in", values, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1Between(Integer value1, Integer value2) {
            addCriterion("sub_category_id1 between", value1, value2, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId1NotBetween(Integer value1, Integer value2) {
            addCriterion("sub_category_id1 not between", value1, value2, "subCategoryId1");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2IsNull() {
            addCriterion("sub_category_id2 is null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2IsNotNull() {
            addCriterion("sub_category_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2EqualTo(Integer value) {
            addCriterion("sub_category_id2 =", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2NotEqualTo(Integer value) {
            addCriterion("sub_category_id2 <>", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2GreaterThan(Integer value) {
            addCriterion("sub_category_id2 >", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id2 >=", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2LessThan(Integer value) {
            addCriterion("sub_category_id2 <", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2LessThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id2 <=", value, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2In(List<Integer> values) {
            addCriterion("sub_category_id2 in", values, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2NotIn(List<Integer> values) {
            addCriterion("sub_category_id2 not in", values, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2Between(Integer value1, Integer value2) {
            addCriterion("sub_category_id2 between", value1, value2, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId2NotBetween(Integer value1, Integer value2) {
            addCriterion("sub_category_id2 not between", value1, value2, "subCategoryId2");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3IsNull() {
            addCriterion("sub_category_id3 is null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3IsNotNull() {
            addCriterion("sub_category_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3EqualTo(Integer value) {
            addCriterion("sub_category_id3 =", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3NotEqualTo(Integer value) {
            addCriterion("sub_category_id3 <>", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3GreaterThan(Integer value) {
            addCriterion("sub_category_id3 >", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3GreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id3 >=", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3LessThan(Integer value) {
            addCriterion("sub_category_id3 <", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3LessThanOrEqualTo(Integer value) {
            addCriterion("sub_category_id3 <=", value, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3In(List<Integer> values) {
            addCriterion("sub_category_id3 in", values, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3NotIn(List<Integer> values) {
            addCriterion("sub_category_id3 not in", values, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3Between(Integer value1, Integer value2) {
            addCriterion("sub_category_id3 between", value1, value2, "subCategoryId3");
            return (Criteria) this;
        }

        public Criteria andSubCategoryId3NotBetween(Integer value1, Integer value2) {
            addCriterion("sub_category_id3 not between", value1, value2, "subCategoryId3");
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

        public Criteria andRatingValueIsNull() {
            addCriterion("rating_value is null");
            return (Criteria) this;
        }

        public Criteria andRatingValueIsNotNull() {
            addCriterion("rating_value is not null");
            return (Criteria) this;
        }

        public Criteria andRatingValueEqualTo(BigDecimal value) {
            addCriterion("rating_value =", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueNotEqualTo(BigDecimal value) {
            addCriterion("rating_value <>", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueGreaterThan(BigDecimal value) {
            addCriterion("rating_value >", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rating_value >=", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueLessThan(BigDecimal value) {
            addCriterion("rating_value <", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rating_value <=", value, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueIn(List<BigDecimal> values) {
            addCriterion("rating_value in", values, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueNotIn(List<BigDecimal> values) {
            addCriterion("rating_value not in", values, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rating_value between", value1, value2, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rating_value not between", value1, value2, "ratingValue");
            return (Criteria) this;
        }

        public Criteria andRatingCountIsNull() {
            addCriterion("rating_count is null");
            return (Criteria) this;
        }

        public Criteria andRatingCountIsNotNull() {
            addCriterion("rating_count is not null");
            return (Criteria) this;
        }

        public Criteria andRatingCountEqualTo(Integer value) {
            addCriterion("rating_count =", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountNotEqualTo(Integer value) {
            addCriterion("rating_count <>", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountGreaterThan(Integer value) {
            addCriterion("rating_count >", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("rating_count >=", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountLessThan(Integer value) {
            addCriterion("rating_count <", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountLessThanOrEqualTo(Integer value) {
            addCriterion("rating_count <=", value, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountIn(List<Integer> values) {
            addCriterion("rating_count in", values, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountNotIn(List<Integer> values) {
            addCriterion("rating_count not in", values, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountBetween(Integer value1, Integer value2) {
            addCriterion("rating_count between", value1, value2, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andRatingCountNotBetween(Integer value1, Integer value2) {
            addCriterion("rating_count not between", value1, value2, "ratingCount");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
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

        public Criteria andFetchedIsNull() {
            addCriterion("fetched is null");
            return (Criteria) this;
        }

        public Criteria andFetchedIsNotNull() {
            addCriterion("fetched is not null");
            return (Criteria) this;
        }

        public Criteria andFetchedEqualTo(Byte value) {
            addCriterion("fetched =", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedNotEqualTo(Byte value) {
            addCriterion("fetched <>", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedGreaterThan(Byte value) {
            addCriterion("fetched >", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedGreaterThanOrEqualTo(Byte value) {
            addCriterion("fetched >=", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedLessThan(Byte value) {
            addCriterion("fetched <", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedLessThanOrEqualTo(Byte value) {
            addCriterion("fetched <=", value, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedIn(List<Byte> values) {
            addCriterion("fetched in", values, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedNotIn(List<Byte> values) {
            addCriterion("fetched not in", values, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedBetween(Byte value1, Byte value2) {
            addCriterion("fetched between", value1, value2, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchedNotBetween(Byte value1, Byte value2) {
            addCriterion("fetched not between", value1, value2, "fetched");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNull() {
            addCriterion("fetch_time is null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIsNotNull() {
            addCriterion("fetch_time is not null");
            return (Criteria) this;
        }

        public Criteria andFetchTimeEqualTo(Date value) {
            addCriterion("fetch_time =", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotEqualTo(Date value) {
            addCriterion("fetch_time <>", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThan(Date value) {
            addCriterion("fetch_time >", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fetch_time >=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThan(Date value) {
            addCriterion("fetch_time <", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeLessThanOrEqualTo(Date value) {
            addCriterion("fetch_time <=", value, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeIn(List<Date> values) {
            addCriterion("fetch_time in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotIn(List<Date> values) {
            addCriterion("fetch_time not in", values, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeBetween(Date value1, Date value2) {
            addCriterion("fetch_time between", value1, value2, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFetchTimeNotBetween(Date value1, Date value2) {
            addCriterion("fetch_time not between", value1, value2, "fetchTime");
            return (Criteria) this;
        }

        public Criteria andFailedTimesIsNull() {
            addCriterion("failed_times is null");
            return (Criteria) this;
        }

        public Criteria andFailedTimesIsNotNull() {
            addCriterion("failed_times is not null");
            return (Criteria) this;
        }

        public Criteria andFailedTimesEqualTo(Integer value) {
            addCriterion("failed_times =", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesNotEqualTo(Integer value) {
            addCriterion("failed_times <>", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesGreaterThan(Integer value) {
            addCriterion("failed_times >", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed_times >=", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesLessThan(Integer value) {
            addCriterion("failed_times <", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesLessThanOrEqualTo(Integer value) {
            addCriterion("failed_times <=", value, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesIn(List<Integer> values) {
            addCriterion("failed_times in", values, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesNotIn(List<Integer> values) {
            addCriterion("failed_times not in", values, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesBetween(Integer value1, Integer value2) {
            addCriterion("failed_times between", value1, value2, "failedTimes");
            return (Criteria) this;
        }

        public Criteria andFailedTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("failed_times not between", value1, value2, "failedTimes");
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