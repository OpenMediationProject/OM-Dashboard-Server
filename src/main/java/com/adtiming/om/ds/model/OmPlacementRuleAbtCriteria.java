// Copyright 2020 ADTIMING TECHNOLOGY COMPANY LIMITED
// Licensed under the GNU Lesser General Public License Version 3

package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmPlacementRuleAbtCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmPlacementRuleAbtCriteria() {
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Integer value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Integer value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Integer value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Integer value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Integer> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Integer> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andResultAbIsNull() {
            addCriterion("result_ab is null");
            return (Criteria) this;
        }

        public Criteria andResultAbIsNotNull() {
            addCriterion("result_ab is not null");
            return (Criteria) this;
        }

        public Criteria andResultAbEqualTo(Integer value) {
            addCriterion("result_ab =", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbNotEqualTo(Integer value) {
            addCriterion("result_ab <>", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbGreaterThan(Integer value) {
            addCriterion("result_ab >", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbGreaterThanOrEqualTo(Integer value) {
            addCriterion("result_ab >=", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbLessThan(Integer value) {
            addCriterion("result_ab <", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbLessThanOrEqualTo(Integer value) {
            addCriterion("result_ab <=", value, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbIn(List<Integer> values) {
            addCriterion("result_ab in", values, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbNotIn(List<Integer> values) {
            addCriterion("result_ab not in", values, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbBetween(Integer value1, Integer value2) {
            addCriterion("result_ab between", value1, value2, "resultAb");
            return (Criteria) this;
        }

        public Criteria andResultAbNotBetween(Integer value1, Integer value2) {
            addCriterion("result_ab not between", value1, value2, "resultAb");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andRuleConfIsNull() {
            addCriterion("rule_conf is null");
            return (Criteria) this;
        }

        public Criteria andRuleConfIsNotNull() {
            addCriterion("rule_conf is not null");
            return (Criteria) this;
        }

        public Criteria andRuleConfEqualTo(Object value) {
            addCriterion("rule_conf =", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfNotEqualTo(Object value) {
            addCriterion("rule_conf <>", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfGreaterThan(Object value) {
            addCriterion("rule_conf >", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfGreaterThanOrEqualTo(Object value) {
            addCriterion("rule_conf >=", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfLessThan(Object value) {
            addCriterion("rule_conf <", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfLessThanOrEqualTo(Object value) {
            addCriterion("rule_conf <=", value, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfIn(List<Object> values) {
            addCriterion("rule_conf in", values, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfNotIn(List<Object> values) {
            addCriterion("rule_conf not in", values, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfBetween(Object value1, Object value2) {
            addCriterion("rule_conf between", value1, value2, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andRuleConfNotBetween(Object value1, Object value2) {
            addCriterion("rule_conf not between", value1, value2, "ruleConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfIsNull() {
            addCriterion("instance_conf is null");
            return (Criteria) this;
        }

        public Criteria andInstanceConfIsNotNull() {
            addCriterion("instance_conf is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceConfEqualTo(Object value) {
            addCriterion("instance_conf =", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfNotEqualTo(Object value) {
            addCriterion("instance_conf <>", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfGreaterThan(Object value) {
            addCriterion("instance_conf >", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfGreaterThanOrEqualTo(Object value) {
            addCriterion("instance_conf >=", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfLessThan(Object value) {
            addCriterion("instance_conf <", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfLessThanOrEqualTo(Object value) {
            addCriterion("instance_conf <=", value, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfIn(List<Object> values) {
            addCriterion("instance_conf in", values, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfNotIn(List<Object> values) {
            addCriterion("instance_conf not in", values, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfBetween(Object value1, Object value2) {
            addCriterion("instance_conf between", value1, value2, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andInstanceConfNotBetween(Object value1, Object value2) {
            addCriterion("instance_conf not between", value1, value2, "instanceConf");
            return (Criteria) this;
        }

        public Criteria andReportIsNull() {
            addCriterion("report is null");
            return (Criteria) this;
        }

        public Criteria andReportIsNotNull() {
            addCriterion("report is not null");
            return (Criteria) this;
        }

        public Criteria andReportEqualTo(Object value) {
            addCriterion("report =", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotEqualTo(Object value) {
            addCriterion("report <>", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportGreaterThan(Object value) {
            addCriterion("report >", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportGreaterThanOrEqualTo(Object value) {
            addCriterion("report >=", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportLessThan(Object value) {
            addCriterion("report <", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportLessThanOrEqualTo(Object value) {
            addCriterion("report <=", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportIn(List<Object> values) {
            addCriterion("report in", values, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotIn(List<Object> values) {
            addCriterion("report not in", values, "report");
            return (Criteria) this;
        }

        public Criteria andReportBetween(Object value1, Object value2) {
            addCriterion("report between", value1, value2, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotBetween(Object value1, Object value2) {
            addCriterion("report not between", value1, value2, "report");
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