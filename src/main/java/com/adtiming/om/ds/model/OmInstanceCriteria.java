// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OmInstanceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmInstanceCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andOldIdIsNull() {
            addCriterion("old_id is null");
            return (Criteria) this;
        }

        public Criteria andOldIdIsNotNull() {
            addCriterion("old_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldIdEqualTo(Integer value) {
            addCriterion("old_id =", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotEqualTo(Integer value) {
            addCriterion("old_id <>", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThan(Integer value) {
            addCriterion("old_id >", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_id >=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThan(Integer value) {
            addCriterion("old_id <", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdLessThanOrEqualTo(Integer value) {
            addCriterion("old_id <=", value, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdIn(List<Integer> values) {
            addCriterion("old_id in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotIn(List<Integer> values) {
            addCriterion("old_id not in", values, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdBetween(Integer value1, Integer value2) {
            addCriterion("old_id between", value1, value2, "oldId");
            return (Criteria) this;
        }

        public Criteria andOldIdNotBetween(Integer value1, Integer value2) {
            addCriterion("old_id not between", value1, value2, "oldId");
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

        public Criteria andPlacementKeyIsNull() {
            addCriterion("placement_key is null");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyIsNotNull() {
            addCriterion("placement_key is not null");
            return (Criteria) this;
        }

        public Criteria andPlacementKeyEqualTo(String value) {
            addCriterion(" binary placement_key =", value, "placementKey");
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

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
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

        public Criteria andOsvMaxIsNull() {
            addCriterion("osv_max is null");
            return (Criteria) this;
        }

        public Criteria andOsvMaxIsNotNull() {
            addCriterion("osv_max is not null");
            return (Criteria) this;
        }

        public Criteria andOsvMaxEqualTo(String value) {
            addCriterion("osv_max =", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotEqualTo(String value) {
            addCriterion("osv_max <>", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxGreaterThan(String value) {
            addCriterion("osv_max >", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxGreaterThanOrEqualTo(String value) {
            addCriterion("osv_max >=", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLessThan(String value) {
            addCriterion("osv_max <", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLessThanOrEqualTo(String value) {
            addCriterion("osv_max <=", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxLike(String value) {
            addCriterion("osv_max like", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotLike(String value) {
            addCriterion("osv_max not like", value, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxIn(List<String> values) {
            addCriterion("osv_max in", values, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotIn(List<String> values) {
            addCriterion("osv_max not in", values, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxBetween(String value1, String value2) {
            addCriterion("osv_max between", value1, value2, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMaxNotBetween(String value1, String value2) {
            addCriterion("osv_max not between", value1, value2, "osvMax");
            return (Criteria) this;
        }

        public Criteria andOsvMinIsNull() {
            addCriterion("osv_min is null");
            return (Criteria) this;
        }

        public Criteria andOsvMinIsNotNull() {
            addCriterion("osv_min is not null");
            return (Criteria) this;
        }

        public Criteria andOsvMinEqualTo(String value) {
            addCriterion("osv_min =", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotEqualTo(String value) {
            addCriterion("osv_min <>", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinGreaterThan(String value) {
            addCriterion("osv_min >", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinGreaterThanOrEqualTo(String value) {
            addCriterion("osv_min >=", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLessThan(String value) {
            addCriterion("osv_min <", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLessThanOrEqualTo(String value) {
            addCriterion("osv_min <=", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinLike(String value) {
            addCriterion("osv_min like", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotLike(String value) {
            addCriterion("osv_min not like", value, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinIn(List<String> values) {
            addCriterion("osv_min in", values, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotIn(List<String> values) {
            addCriterion("osv_min not in", values, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinBetween(String value1, String value2) {
            addCriterion("osv_min between", value1, value2, "osvMin");
            return (Criteria) this;
        }

        public Criteria andOsvMinNotBetween(String value1, String value2) {
            addCriterion("osv_min not between", value1, value2, "osvMin");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIsNull() {
            addCriterion("frequency_cap is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIsNotNull() {
            addCriterion("frequency_cap is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapEqualTo(Integer value) {
            addCriterion("frequency_cap =", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotEqualTo(Integer value) {
            addCriterion("frequency_cap <>", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapGreaterThan(Integer value) {
            addCriterion("frequency_cap >", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_cap >=", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapLessThan(Integer value) {
            addCriterion("frequency_cap <", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_cap <=", value, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapIn(List<Integer> values) {
            addCriterion("frequency_cap in", values, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotIn(List<Integer> values) {
            addCriterion("frequency_cap not in", values, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapBetween(Integer value1, Integer value2) {
            addCriterion("frequency_cap between", value1, value2, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyCapNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_cap not between", value1, value2, "frequencyCap");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIsNull() {
            addCriterion("frequency_unit is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIsNotNull() {
            addCriterion("frequency_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitEqualTo(Integer value) {
            addCriterion("frequency_unit =", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotEqualTo(Integer value) {
            addCriterion("frequency_unit <>", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitGreaterThan(Integer value) {
            addCriterion("frequency_unit >", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_unit >=", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitLessThan(Integer value) {
            addCriterion("frequency_unit <", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_unit <=", value, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitIn(List<Integer> values) {
            addCriterion("frequency_unit in", values, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotIn(List<Integer> values) {
            addCriterion("frequency_unit not in", values, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitBetween(Integer value1, Integer value2) {
            addCriterion("frequency_unit between", value1, value2, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_unit not between", value1, value2, "frequencyUnit");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIsNull() {
            addCriterion("frequency_interval is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIsNotNull() {
            addCriterion("frequency_interval is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalEqualTo(Integer value) {
            addCriterion("frequency_interval =", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotEqualTo(Integer value) {
            addCriterion("frequency_interval <>", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalGreaterThan(Integer value) {
            addCriterion("frequency_interval >", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency_interval >=", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalLessThan(Integer value) {
            addCriterion("frequency_interval <", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("frequency_interval <=", value, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalIn(List<Integer> values) {
            addCriterion("frequency_interval in", values, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotIn(List<Integer> values) {
            addCriterion("frequency_interval not in", values, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalBetween(Integer value1, Integer value2) {
            addCriterion("frequency_interval between", value1, value2, "frequencyInterval");
            return (Criteria) this;
        }

        public Criteria andFrequencyIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency_interval not between", value1, value2, "frequencyInterval");
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

        public Criteria andMediationAudienceSegmentIsNull() {
            addCriterion("mediation_audience_segment is null");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentIsNotNull() {
            addCriterion("mediation_audience_segment is not null");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentEqualTo(Byte value) {
            addCriterion("mediation_audience_segment =", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentNotEqualTo(Byte value) {
            addCriterion("mediation_audience_segment <>", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentGreaterThan(Byte value) {
            addCriterion("mediation_audience_segment >", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentGreaterThanOrEqualTo(Byte value) {
            addCriterion("mediation_audience_segment >=", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentLessThan(Byte value) {
            addCriterion("mediation_audience_segment <", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentLessThanOrEqualTo(Byte value) {
            addCriterion("mediation_audience_segment <=", value, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentIn(List<Byte> values) {
            addCriterion("mediation_audience_segment in", values, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentNotIn(List<Byte> values) {
            addCriterion("mediation_audience_segment not in", values, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentBetween(Byte value1, Byte value2) {
            addCriterion("mediation_audience_segment between", value1, value2, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentNotBetween(Byte value1, Byte value2) {
            addCriterion("mediation_audience_segment not between", value1, value2, "mediationAudienceSegment");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayIsNull() {
            addCriterion("mediation_audience_segment_day is null");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayIsNotNull() {
            addCriterion("mediation_audience_segment_day is not null");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayEqualTo(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day =", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day <>", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayGreaterThan(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day >", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day >=", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayLessThan(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day <", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mediation_audience_segment_day <=", value, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayIn(List<Date> values) {
            addCriterionForJDBCDate("mediation_audience_segment_day in", values, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("mediation_audience_segment_day not in", values, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mediation_audience_segment_day between", value1, value2, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andMediationAudienceSegmentDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mediation_audience_segment_day not between", value1, value2, "mediationAudienceSegmentDay");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentIsNull() {
            addCriterion("audience_segment is null");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentIsNotNull() {
            addCriterion("audience_segment is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentEqualTo(Byte value) {
            addCriterion("audience_segment =", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentNotEqualTo(Byte value) {
            addCriterion("audience_segment <>", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentGreaterThan(Byte value) {
            addCriterion("audience_segment >", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentGreaterThanOrEqualTo(Byte value) {
            addCriterion("audience_segment >=", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentLessThan(Byte value) {
            addCriterion("audience_segment <", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentLessThanOrEqualTo(Byte value) {
            addCriterion("audience_segment <=", value, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentIn(List<Byte> values) {
            addCriterion("audience_segment in", values, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentNotIn(List<Byte> values) {
            addCriterion("audience_segment not in", values, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentBetween(Byte value1, Byte value2) {
            addCriterion("audience_segment between", value1, value2, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentNotBetween(Byte value1, Byte value2) {
            addCriterion("audience_segment not between", value1, value2, "audienceSegment");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedIsNull() {
            addCriterion("audience_segment_expected is null");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedIsNotNull() {
            addCriterion("audience_segment_expected is not null");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedEqualTo(Integer value) {
            addCriterion("audience_segment_expected =", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedNotEqualTo(Integer value) {
            addCriterion("audience_segment_expected <>", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedGreaterThan(Integer value) {
            addCriterion("audience_segment_expected >", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedGreaterThanOrEqualTo(Integer value) {
            addCriterion("audience_segment_expected >=", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedLessThan(Integer value) {
            addCriterion("audience_segment_expected <", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedLessThanOrEqualTo(Integer value) {
            addCriterion("audience_segment_expected <=", value, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedIn(List<Integer> values) {
            addCriterion("audience_segment_expected in", values, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedNotIn(List<Integer> values) {
            addCriterion("audience_segment_expected not in", values, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedBetween(Integer value1, Integer value2) {
            addCriterion("audience_segment_expected between", value1, value2, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andAudienceSegmentExpectedNotBetween(Integer value1, Integer value2) {
            addCriterion("audience_segment_expected not between", value1, value2, "audienceSegmentExpected");
            return (Criteria) this;
        }

        public Criteria andHbStatusIsNull() {
            addCriterion("hb_status is null");
            return (Criteria) this;
        }

        public Criteria andHbStatusIsNotNull() {
            addCriterion("hb_status is not null");
            return (Criteria) this;
        }

        public Criteria andHbStatusEqualTo(Byte value) {
            addCriterion("hb_status =", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotEqualTo(Byte value) {
            addCriterion("hb_status <>", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusGreaterThan(Byte value) {
            addCriterion("hb_status >", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("hb_status >=", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusLessThan(Byte value) {
            addCriterion("hb_status <", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusLessThanOrEqualTo(Byte value) {
            addCriterion("hb_status <=", value, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusIn(List<Byte> values) {
            addCriterion("hb_status in", values, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotIn(List<Byte> values) {
            addCriterion("hb_status not in", values, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusBetween(Byte value1, Byte value2) {
            addCriterion("hb_status between", value1, value2, "hbStatus");
            return (Criteria) this;
        }

        public Criteria andHbStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("hb_status not between", value1, value2, "hbStatus");
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