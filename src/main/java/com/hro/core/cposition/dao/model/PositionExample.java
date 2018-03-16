package com.hro.core.cposition.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        public Criteria andDevidIsNull() {
            addCriterion("DEVID is null");
            return (Criteria) this;
        }

        public Criteria andDevidIsNotNull() {
            addCriterion("DEVID is not null");
            return (Criteria) this;
        }

        public Criteria andDevidEqualTo(String value) {
            addCriterion("DEVID =", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotEqualTo(String value) {
            addCriterion("DEVID <>", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThan(String value) {
            addCriterion("DEVID >", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThanOrEqualTo(String value) {
            addCriterion("DEVID >=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThan(String value) {
            addCriterion("DEVID <", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThanOrEqualTo(String value) {
            addCriterion("DEVID <=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLike(String value) {
            addCriterion("DEVID like", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotLike(String value) {
            addCriterion("DEVID not like", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidIn(List<String> values) {
            addCriterion("DEVID in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotIn(List<String> values) {
            addCriterion("DEVID not in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidBetween(String value1, String value2) {
            addCriterion("DEVID between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotBetween(String value1, String value2) {
            addCriterion("DEVID not between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("LNG is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("LNG is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("LNG =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("LNG <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("LNG >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("LNG >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("LNG <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("LNG <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("LNG in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("LNG not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("LNG between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("LNG not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("LAT is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("LAT is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("LAT =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("LAT <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("LAT >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("LAT >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("LAT <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("LAT <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("LAT in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("LAT not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("LAT between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("LAT not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andBdLngIsNull() {
            addCriterion("BD_LNG is null");
            return (Criteria) this;
        }

        public Criteria andBdLngIsNotNull() {
            addCriterion("BD_LNG is not null");
            return (Criteria) this;
        }

        public Criteria andBdLngEqualTo(Double value) {
            addCriterion("BD_LNG =", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngNotEqualTo(Double value) {
            addCriterion("BD_LNG <>", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngGreaterThan(Double value) {
            addCriterion("BD_LNG >", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngGreaterThanOrEqualTo(Double value) {
            addCriterion("BD_LNG >=", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngLessThan(Double value) {
            addCriterion("BD_LNG <", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngLessThanOrEqualTo(Double value) {
            addCriterion("BD_LNG <=", value, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngIn(List<Double> values) {
            addCriterion("BD_LNG in", values, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngNotIn(List<Double> values) {
            addCriterion("BD_LNG not in", values, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngBetween(Double value1, Double value2) {
            addCriterion("BD_LNG between", value1, value2, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLngNotBetween(Double value1, Double value2) {
            addCriterion("BD_LNG not between", value1, value2, "bdLng");
            return (Criteria) this;
        }

        public Criteria andBdLatIsNull() {
            addCriterion("BD_LAT is null");
            return (Criteria) this;
        }

        public Criteria andBdLatIsNotNull() {
            addCriterion("BD_LAT is not null");
            return (Criteria) this;
        }

        public Criteria andBdLatEqualTo(Double value) {
            addCriterion("BD_LAT =", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatNotEqualTo(Double value) {
            addCriterion("BD_LAT <>", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatGreaterThan(Double value) {
            addCriterion("BD_LAT >", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatGreaterThanOrEqualTo(Double value) {
            addCriterion("BD_LAT >=", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatLessThan(Double value) {
            addCriterion("BD_LAT <", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatLessThanOrEqualTo(Double value) {
            addCriterion("BD_LAT <=", value, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatIn(List<Double> values) {
            addCriterion("BD_LAT in", values, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatNotIn(List<Double> values) {
            addCriterion("BD_LAT not in", values, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatBetween(Double value1, Double value2) {
            addCriterion("BD_LAT between", value1, value2, "bdLat");
            return (Criteria) this;
        }

        public Criteria andBdLatNotBetween(Double value1, Double value2) {
            addCriterion("BD_LAT not between", value1, value2, "bdLat");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDevidLikeInsensitive(String value) {
            addCriterion("upper(DEVID) like", value.toUpperCase(), "devid");
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