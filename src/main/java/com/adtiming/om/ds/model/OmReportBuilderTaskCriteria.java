package com.adtiming.om.ds.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OmReportBuilderTaskCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmReportBuilderTaskCriteria() {
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

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Date value) {
            addCriterionForJDBCDate("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Date value) {
            addCriterionForJDBCDate("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Date value) {
            addCriterionForJDBCDate("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Date> values) {
            addCriterionForJDBCDate("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andBuilderIdIsNull() {
            addCriterion("builder_id is null");
            return (Criteria) this;
        }

        public Criteria andBuilderIdIsNotNull() {
            addCriterion("builder_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuilderIdEqualTo(Integer value) {
            addCriterion("builder_id =", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdNotEqualTo(Integer value) {
            addCriterion("builder_id <>", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdGreaterThan(Integer value) {
            addCriterion("builder_id >", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("builder_id >=", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdLessThan(Integer value) {
            addCriterion("builder_id <", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdLessThanOrEqualTo(Integer value) {
            addCriterion("builder_id <=", value, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdIn(List<Integer> values) {
            addCriterion("builder_id in", values, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdNotIn(List<Integer> values) {
            addCriterion("builder_id not in", values, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdBetween(Integer value1, Integer value2) {
            addCriterion("builder_id between", value1, value2, "builderId");
            return (Criteria) this;
        }

        public Criteria andBuilderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("builder_id not between", value1, value2, "builderId");
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

        public Criteria andReparationCountIsNull() {
            addCriterion("reparation_count is null");
            return (Criteria) this;
        }

        public Criteria andReparationCountIsNotNull() {
            addCriterion("reparation_count is not null");
            return (Criteria) this;
        }

        public Criteria andReparationCountEqualTo(Integer value) {
            addCriterion("reparation_count =", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountNotEqualTo(Integer value) {
            addCriterion("reparation_count <>", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountGreaterThan(Integer value) {
            addCriterion("reparation_count >", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reparation_count >=", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountLessThan(Integer value) {
            addCriterion("reparation_count <", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountLessThanOrEqualTo(Integer value) {
            addCriterion("reparation_count <=", value, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountIn(List<Integer> values) {
            addCriterion("reparation_count in", values, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountNotIn(List<Integer> values) {
            addCriterion("reparation_count not in", values, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountBetween(Integer value1, Integer value2) {
            addCriterion("reparation_count between", value1, value2, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReparationCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reparation_count not between", value1, value2, "reparationCount");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeIsNull() {
            addCriterion("report_line_size is null");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeIsNotNull() {
            addCriterion("report_line_size is not null");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeEqualTo(Integer value) {
            addCriterion("report_line_size =", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeNotEqualTo(Integer value) {
            addCriterion("report_line_size <>", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeGreaterThan(Integer value) {
            addCriterion("report_line_size >", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("report_line_size >=", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeLessThan(Integer value) {
            addCriterion("report_line_size <", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeLessThanOrEqualTo(Integer value) {
            addCriterion("report_line_size <=", value, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeIn(List<Integer> values) {
            addCriterion("report_line_size in", values, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeNotIn(List<Integer> values) {
            addCriterion("report_line_size not in", values, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeBetween(Integer value1, Integer value2) {
            addCriterion("report_line_size between", value1, value2, "reportLineSize");
            return (Criteria) this;
        }

        public Criteria andReportLineSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("report_line_size not between", value1, value2, "reportLineSize");
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