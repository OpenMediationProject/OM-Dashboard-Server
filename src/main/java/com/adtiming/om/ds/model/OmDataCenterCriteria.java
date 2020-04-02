// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmDataCenterCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmDataCenterCriteria() {
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

        public Criteria andIdEqualTo(Byte value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Byte value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Byte value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Byte value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Byte value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Byte> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Byte> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Byte value1, Byte value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Byte value1, Byte value2) {
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

        public Criteria andZkIsNull() {
            addCriterion("zk is null");
            return (Criteria) this;
        }

        public Criteria andZkIsNotNull() {
            addCriterion("zk is not null");
            return (Criteria) this;
        }

        public Criteria andZkEqualTo(String value) {
            addCriterion("zk =", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotEqualTo(String value) {
            addCriterion("zk <>", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThan(String value) {
            addCriterion("zk >", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThanOrEqualTo(String value) {
            addCriterion("zk >=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThan(String value) {
            addCriterion("zk <", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThanOrEqualTo(String value) {
            addCriterion("zk <=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLike(String value) {
            addCriterion("zk like", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotLike(String value) {
            addCriterion("zk not like", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkIn(List<String> values) {
            addCriterion("zk in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotIn(List<String> values) {
            addCriterion("zk not in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkBetween(String value1, String value2) {
            addCriterion("zk between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotBetween(String value1, String value2) {
            addCriterion("zk not between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andKafkaIsNull() {
            addCriterion("kafka is null");
            return (Criteria) this;
        }

        public Criteria andKafkaIsNotNull() {
            addCriterion("kafka is not null");
            return (Criteria) this;
        }

        public Criteria andKafkaEqualTo(String value) {
            addCriterion("kafka =", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaNotEqualTo(String value) {
            addCriterion("kafka <>", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaGreaterThan(String value) {
            addCriterion("kafka >", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaGreaterThanOrEqualTo(String value) {
            addCriterion("kafka >=", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaLessThan(String value) {
            addCriterion("kafka <", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaLessThanOrEqualTo(String value) {
            addCriterion("kafka <=", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaLike(String value) {
            addCriterion("kafka like", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaNotLike(String value) {
            addCriterion("kafka not like", value, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaIn(List<String> values) {
            addCriterion("kafka in", values, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaNotIn(List<String> values) {
            addCriterion("kafka not in", values, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaBetween(String value1, String value2) {
            addCriterion("kafka between", value1, value2, "kafka");
            return (Criteria) this;
        }

        public Criteria andKafkaNotBetween(String value1, String value2) {
            addCriterion("kafka not between", value1, value2, "kafka");
            return (Criteria) this;
        }

        public Criteria andRedisIsNull() {
            addCriterion("redis is null");
            return (Criteria) this;
        }

        public Criteria andRedisIsNotNull() {
            addCriterion("redis is not null");
            return (Criteria) this;
        }

        public Criteria andRedisEqualTo(String value) {
            addCriterion("redis =", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisNotEqualTo(String value) {
            addCriterion("redis <>", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisGreaterThan(String value) {
            addCriterion("redis >", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisGreaterThanOrEqualTo(String value) {
            addCriterion("redis >=", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisLessThan(String value) {
            addCriterion("redis <", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisLessThanOrEqualTo(String value) {
            addCriterion("redis <=", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisLike(String value) {
            addCriterion("redis like", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisNotLike(String value) {
            addCriterion("redis not like", value, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisIn(List<String> values) {
            addCriterion("redis in", values, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisNotIn(List<String> values) {
            addCriterion("redis not in", values, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisBetween(String value1, String value2) {
            addCriterion("redis between", value1, value2, "redis");
            return (Criteria) this;
        }

        public Criteria andRedisNotBetween(String value1, String value2) {
            addCriterion("redis not between", value1, value2, "redis");
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