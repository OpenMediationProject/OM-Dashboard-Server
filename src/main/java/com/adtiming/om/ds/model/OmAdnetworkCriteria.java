// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmAdnetworkCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmAdnetworkCriteria() {
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

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
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

        public Criteria andIosAdtypeIsNull() {
            addCriterion("ios_adtype is null");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeIsNotNull() {
            addCriterion("ios_adtype is not null");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeEqualTo(Byte value) {
            addCriterion("ios_adtype =", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeNotEqualTo(Byte value) {
            addCriterion("ios_adtype <>", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeGreaterThan(Byte value) {
            addCriterion("ios_adtype >", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ios_adtype >=", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeLessThan(Byte value) {
            addCriterion("ios_adtype <", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeLessThanOrEqualTo(Byte value) {
            addCriterion("ios_adtype <=", value, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeIn(List<Byte> values) {
            addCriterion("ios_adtype in", values, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeNotIn(List<Byte> values) {
            addCriterion("ios_adtype not in", values, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeBetween(Byte value1, Byte value2) {
            addCriterion("ios_adtype between", value1, value2, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andIosAdtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ios_adtype not between", value1, value2, "iosAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeIsNull() {
            addCriterion("android_adtype is null");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeIsNotNull() {
            addCriterion("android_adtype is not null");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeEqualTo(Byte value) {
            addCriterion("android_adtype =", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeNotEqualTo(Byte value) {
            addCriterion("android_adtype <>", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeGreaterThan(Byte value) {
            addCriterion("android_adtype >", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("android_adtype >=", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeLessThan(Byte value) {
            addCriterion("android_adtype <", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeLessThanOrEqualTo(Byte value) {
            addCriterion("android_adtype <=", value, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeIn(List<Byte> values) {
            addCriterion("android_adtype in", values, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeNotIn(List<Byte> values) {
            addCriterion("android_adtype not in", values, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeBetween(Byte value1, Byte value2) {
            addCriterion("android_adtype between", value1, value2, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andAndroidAdtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("android_adtype not between", value1, value2, "androidAdtype");
            return (Criteria) this;
        }

        public Criteria andSdkVersionIsNull() {
            addCriterion("sdk_version is null");
            return (Criteria) this;
        }

        public Criteria andSdkVersionIsNotNull() {
            addCriterion("sdk_version is not null");
            return (Criteria) this;
        }

        public Criteria andSdkVersionEqualTo(String value) {
            addCriterion("sdk_version =", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionNotEqualTo(String value) {
            addCriterion("sdk_version <>", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionGreaterThan(String value) {
            addCriterion("sdk_version >", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionGreaterThanOrEqualTo(String value) {
            addCriterion("sdk_version >=", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionLessThan(String value) {
            addCriterion("sdk_version <", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionLessThanOrEqualTo(String value) {
            addCriterion("sdk_version <=", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionLike(String value) {
            addCriterion("sdk_version like", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionNotLike(String value) {
            addCriterion("sdk_version not like", value, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionIn(List<String> values) {
            addCriterion("sdk_version in", values, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionNotIn(List<String> values) {
            addCriterion("sdk_version not in", values, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionBetween(String value1, String value2) {
            addCriterion("sdk_version between", value1, value2, "sdkVersion");
            return (Criteria) this;
        }

        public Criteria andSdkVersionNotBetween(String value1, String value2) {
            addCriterion("sdk_version not between", value1, value2, "sdkVersion");
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

        public Criteria andPublisherVisibleIsNull() {
            addCriterion("publisher_visible is null");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleIsNotNull() {
            addCriterion("publisher_visible is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleEqualTo(Byte value) {
            addCriterion("publisher_visible =", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleNotEqualTo(Byte value) {
            addCriterion("publisher_visible <>", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleGreaterThan(Byte value) {
            addCriterion("publisher_visible >", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleGreaterThanOrEqualTo(Byte value) {
            addCriterion("publisher_visible >=", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleLessThan(Byte value) {
            addCriterion("publisher_visible <", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleLessThanOrEqualTo(Byte value) {
            addCriterion("publisher_visible <=", value, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleIn(List<Byte> values) {
            addCriterion("publisher_visible in", values, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleNotIn(List<Byte> values) {
            addCriterion("publisher_visible not in", values, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleBetween(Byte value1, Byte value2) {
            addCriterion("publisher_visible between", value1, value2, "publisherVisible");
            return (Criteria) this;
        }

        public Criteria andPublisherVisibleNotBetween(Byte value1, Byte value2) {
            addCriterion("publisher_visible not between", value1, value2, "publisherVisible");
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