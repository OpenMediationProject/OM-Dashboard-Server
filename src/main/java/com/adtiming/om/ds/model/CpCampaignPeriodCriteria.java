package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpCampaignPeriodCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpCampaignPeriodCriteria() {
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

        public Criteria andCampaignIdIsNull() {
            addCriterion("campaign_id is null");
            return (Criteria) this;
        }

        public Criteria andCampaignIdIsNotNull() {
            addCriterion("campaign_id is not null");
            return (Criteria) this;
        }

        public Criteria andCampaignIdEqualTo(Integer value) {
            addCriterion("campaign_id =", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotEqualTo(Integer value) {
            addCriterion("campaign_id <>", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdGreaterThan(Integer value) {
            addCriterion("campaign_id >", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("campaign_id >=", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdLessThan(Integer value) {
            addCriterion("campaign_id <", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdLessThanOrEqualTo(Integer value) {
            addCriterion("campaign_id <=", value, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdIn(List<Integer> values) {
            addCriterion("campaign_id in", values, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotIn(List<Integer> values) {
            addCriterion("campaign_id not in", values, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdBetween(Integer value1, Integer value2) {
            addCriterion("campaign_id between", value1, value2, "campaignId");
            return (Criteria) this;
        }

        public Criteria andCampaignIdNotBetween(Integer value1, Integer value2) {
            addCriterion("campaign_id not between", value1, value2, "campaignId");
            return (Criteria) this;
        }

        public Criteria andHour0IsNull() {
            addCriterion("hour0 is null");
            return (Criteria) this;
        }

        public Criteria andHour0IsNotNull() {
            addCriterion("hour0 is not null");
            return (Criteria) this;
        }

        public Criteria andHour0EqualTo(Integer value) {
            addCriterion("hour0 =", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotEqualTo(Integer value) {
            addCriterion("hour0 <>", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0GreaterThan(Integer value) {
            addCriterion("hour0 >", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour0 >=", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0LessThan(Integer value) {
            addCriterion("hour0 <", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0LessThanOrEqualTo(Integer value) {
            addCriterion("hour0 <=", value, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0In(List<Integer> values) {
            addCriterion("hour0 in", values, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotIn(List<Integer> values) {
            addCriterion("hour0 not in", values, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0Between(Integer value1, Integer value2) {
            addCriterion("hour0 between", value1, value2, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour0NotBetween(Integer value1, Integer value2) {
            addCriterion("hour0 not between", value1, value2, "hour0");
            return (Criteria) this;
        }

        public Criteria andHour1IsNull() {
            addCriterion("hour1 is null");
            return (Criteria) this;
        }

        public Criteria andHour1IsNotNull() {
            addCriterion("hour1 is not null");
            return (Criteria) this;
        }

        public Criteria andHour1EqualTo(Integer value) {
            addCriterion("hour1 =", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotEqualTo(Integer value) {
            addCriterion("hour1 <>", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThan(Integer value) {
            addCriterion("hour1 >", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour1 >=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThan(Integer value) {
            addCriterion("hour1 <", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1LessThanOrEqualTo(Integer value) {
            addCriterion("hour1 <=", value, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1In(List<Integer> values) {
            addCriterion("hour1 in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotIn(List<Integer> values) {
            addCriterion("hour1 not in", values, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1Between(Integer value1, Integer value2) {
            addCriterion("hour1 between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour1NotBetween(Integer value1, Integer value2) {
            addCriterion("hour1 not between", value1, value2, "hour1");
            return (Criteria) this;
        }

        public Criteria andHour2IsNull() {
            addCriterion("hour2 is null");
            return (Criteria) this;
        }

        public Criteria andHour2IsNotNull() {
            addCriterion("hour2 is not null");
            return (Criteria) this;
        }

        public Criteria andHour2EqualTo(Integer value) {
            addCriterion("hour2 =", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotEqualTo(Integer value) {
            addCriterion("hour2 <>", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2GreaterThan(Integer value) {
            addCriterion("hour2 >", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour2 >=", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2LessThan(Integer value) {
            addCriterion("hour2 <", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2LessThanOrEqualTo(Integer value) {
            addCriterion("hour2 <=", value, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2In(List<Integer> values) {
            addCriterion("hour2 in", values, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotIn(List<Integer> values) {
            addCriterion("hour2 not in", values, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2Between(Integer value1, Integer value2) {
            addCriterion("hour2 between", value1, value2, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour2NotBetween(Integer value1, Integer value2) {
            addCriterion("hour2 not between", value1, value2, "hour2");
            return (Criteria) this;
        }

        public Criteria andHour3IsNull() {
            addCriterion("hour3 is null");
            return (Criteria) this;
        }

        public Criteria andHour3IsNotNull() {
            addCriterion("hour3 is not null");
            return (Criteria) this;
        }

        public Criteria andHour3EqualTo(Integer value) {
            addCriterion("hour3 =", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotEqualTo(Integer value) {
            addCriterion("hour3 <>", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3GreaterThan(Integer value) {
            addCriterion("hour3 >", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour3 >=", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3LessThan(Integer value) {
            addCriterion("hour3 <", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3LessThanOrEqualTo(Integer value) {
            addCriterion("hour3 <=", value, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3In(List<Integer> values) {
            addCriterion("hour3 in", values, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotIn(List<Integer> values) {
            addCriterion("hour3 not in", values, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3Between(Integer value1, Integer value2) {
            addCriterion("hour3 between", value1, value2, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour3NotBetween(Integer value1, Integer value2) {
            addCriterion("hour3 not between", value1, value2, "hour3");
            return (Criteria) this;
        }

        public Criteria andHour4IsNull() {
            addCriterion("hour4 is null");
            return (Criteria) this;
        }

        public Criteria andHour4IsNotNull() {
            addCriterion("hour4 is not null");
            return (Criteria) this;
        }

        public Criteria andHour4EqualTo(Integer value) {
            addCriterion("hour4 =", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotEqualTo(Integer value) {
            addCriterion("hour4 <>", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4GreaterThan(Integer value) {
            addCriterion("hour4 >", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour4 >=", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4LessThan(Integer value) {
            addCriterion("hour4 <", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4LessThanOrEqualTo(Integer value) {
            addCriterion("hour4 <=", value, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4In(List<Integer> values) {
            addCriterion("hour4 in", values, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotIn(List<Integer> values) {
            addCriterion("hour4 not in", values, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4Between(Integer value1, Integer value2) {
            addCriterion("hour4 between", value1, value2, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour4NotBetween(Integer value1, Integer value2) {
            addCriterion("hour4 not between", value1, value2, "hour4");
            return (Criteria) this;
        }

        public Criteria andHour5IsNull() {
            addCriterion("hour5 is null");
            return (Criteria) this;
        }

        public Criteria andHour5IsNotNull() {
            addCriterion("hour5 is not null");
            return (Criteria) this;
        }

        public Criteria andHour5EqualTo(Integer value) {
            addCriterion("hour5 =", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotEqualTo(Integer value) {
            addCriterion("hour5 <>", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5GreaterThan(Integer value) {
            addCriterion("hour5 >", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour5 >=", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5LessThan(Integer value) {
            addCriterion("hour5 <", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5LessThanOrEqualTo(Integer value) {
            addCriterion("hour5 <=", value, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5In(List<Integer> values) {
            addCriterion("hour5 in", values, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotIn(List<Integer> values) {
            addCriterion("hour5 not in", values, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5Between(Integer value1, Integer value2) {
            addCriterion("hour5 between", value1, value2, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour5NotBetween(Integer value1, Integer value2) {
            addCriterion("hour5 not between", value1, value2, "hour5");
            return (Criteria) this;
        }

        public Criteria andHour6IsNull() {
            addCriterion("hour6 is null");
            return (Criteria) this;
        }

        public Criteria andHour6IsNotNull() {
            addCriterion("hour6 is not null");
            return (Criteria) this;
        }

        public Criteria andHour6EqualTo(Integer value) {
            addCriterion("hour6 =", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotEqualTo(Integer value) {
            addCriterion("hour6 <>", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6GreaterThan(Integer value) {
            addCriterion("hour6 >", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6GreaterThanOrEqualTo(Integer value) {
            addCriterion("hour6 >=", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6LessThan(Integer value) {
            addCriterion("hour6 <", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6LessThanOrEqualTo(Integer value) {
            addCriterion("hour6 <=", value, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6In(List<Integer> values) {
            addCriterion("hour6 in", values, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotIn(List<Integer> values) {
            addCriterion("hour6 not in", values, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6Between(Integer value1, Integer value2) {
            addCriterion("hour6 between", value1, value2, "hour6");
            return (Criteria) this;
        }

        public Criteria andHour6NotBetween(Integer value1, Integer value2) {
            addCriterion("hour6 not between", value1, value2, "hour6");
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