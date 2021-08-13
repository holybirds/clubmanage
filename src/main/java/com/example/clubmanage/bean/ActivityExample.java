package com.example.clubmanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ActivityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table activity
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table activity
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table activity
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public ActivityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table activity
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNull() {
            addCriterion("activity_name is null");
            return (Criteria) this;
        }

        public Criteria andActivityNameIsNotNull() {
            addCriterion("activity_name is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNameEqualTo(String value) {
            addCriterion("activity_name =", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotEqualTo(String value) {
            addCriterion("activity_name <>", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThan(String value) {
            addCriterion("activity_name >", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameGreaterThanOrEqualTo(String value) {
            addCriterion("activity_name >=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThan(String value) {
            addCriterion("activity_name <", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLessThanOrEqualTo(String value) {
            addCriterion("activity_name <=", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameLike(String value) {
            addCriterion("activity_name like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotLike(String value) {
            addCriterion("activity_name not like", value, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameIn(List<String> values) {
            addCriterion("activity_name in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotIn(List<String> values) {
            addCriterion("activity_name not in", values, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameBetween(String value1, String value2) {
            addCriterion("activity_name between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andActivityNameNotBetween(String value1, String value2) {
            addCriterion("activity_name not between", value1, value2, "activityName");
            return (Criteria) this;
        }

        public Criteria andClubIsNull() {
            addCriterion("club is null");
            return (Criteria) this;
        }

        public Criteria andClubIsNotNull() {
            addCriterion("club is not null");
            return (Criteria) this;
        }

        public Criteria andClubEqualTo(String value) {
            addCriterion("club =", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubNotEqualTo(String value) {
            addCriterion("club <>", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubGreaterThan(String value) {
            addCriterion("club >", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubGreaterThanOrEqualTo(String value) {
            addCriterion("club >=", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubLessThan(String value) {
            addCriterion("club <", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubLessThanOrEqualTo(String value) {
            addCriterion("club <=", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubLike(String value) {
            addCriterion("club like", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubNotLike(String value) {
            addCriterion("club not like", value, "club");
            return (Criteria) this;
        }

        public Criteria andClubIn(List<String> values) {
            addCriterion("club in", values, "club");
            return (Criteria) this;
        }

        public Criteria andClubNotIn(List<String> values) {
            addCriterion("club not in", values, "club");
            return (Criteria) this;
        }

        public Criteria andClubBetween(String value1, String value2) {
            addCriterion("club between", value1, value2, "club");
            return (Criteria) this;
        }

        public Criteria andClubNotBetween(String value1, String value2) {
            addCriterion("club not between", value1, value2, "club");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionIsNull() {
            addCriterion("activity_permission is null");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionIsNotNull() {
            addCriterion("activity_permission is not null");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionEqualTo(String value) {
            addCriterion("activity_permission =", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionNotEqualTo(String value) {
            addCriterion("activity_permission <>", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionGreaterThan(String value) {
            addCriterion("activity_permission >", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("activity_permission >=", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionLessThan(String value) {
            addCriterion("activity_permission <", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionLessThanOrEqualTo(String value) {
            addCriterion("activity_permission <=", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionLike(String value) {
            addCriterion("activity_permission like", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionNotLike(String value) {
            addCriterion("activity_permission not like", value, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionIn(List<String> values) {
            addCriterion("activity_permission in", values, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionNotIn(List<String> values) {
            addCriterion("activity_permission not in", values, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionBetween(String value1, String value2) {
            addCriterion("activity_permission between", value1, value2, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityPermissionNotBetween(String value1, String value2) {
            addCriterion("activity_permission not between", value1, value2, "activityPermission");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNull() {
            addCriterion("activity_content is null");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNotNull() {
            addCriterion("activity_content is not null");
            return (Criteria) this;
        }

        public Criteria andActivityContentEqualTo(String value) {
            addCriterion("activity_content =", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotEqualTo(String value) {
            addCriterion("activity_content <>", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThan(String value) {
            addCriterion("activity_content >", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThanOrEqualTo(String value) {
            addCriterion("activity_content >=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThan(String value) {
            addCriterion("activity_content <", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThanOrEqualTo(String value) {
            addCriterion("activity_content <=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLike(String value) {
            addCriterion("activity_content like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotLike(String value) {
            addCriterion("activity_content not like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentIn(List<String> values) {
            addCriterion("activity_content in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotIn(List<String> values) {
            addCriterion("activity_content not in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentBetween(String value1, String value2) {
            addCriterion("activity_content between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotBetween(String value1, String value2) {
            addCriterion("activity_content not between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridIsNull() {
            addCriterion("joined_userid is null");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridIsNotNull() {
            addCriterion("joined_userid is not null");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridEqualTo(String value) {
            addCriterion("joined_userid =", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridNotEqualTo(String value) {
            addCriterion("joined_userid <>", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridGreaterThan(String value) {
            addCriterion("joined_userid >", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridGreaterThanOrEqualTo(String value) {
            addCriterion("joined_userid >=", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridLessThan(String value) {
            addCriterion("joined_userid <", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridLessThanOrEqualTo(String value) {
            addCriterion("joined_userid <=", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridLike(String value) {
            addCriterion("joined_userid like", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridNotLike(String value) {
            addCriterion("joined_userid not like", value, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridIn(List<String> values) {
            addCriterion("joined_userid in", values, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridNotIn(List<String> values) {
            addCriterion("joined_userid not in", values, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridBetween(String value1, String value2) {
            addCriterion("joined_userid between", value1, value2, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andJoinedUseridNotBetween(String value1, String value2) {
            addCriterion("joined_userid not between", value1, value2, "joinedUserid");
            return (Criteria) this;
        }

        public Criteria andActivityImageIsNull() {
            addCriterion("activity_image is null");
            return (Criteria) this;
        }

        public Criteria andActivityImageIsNotNull() {
            addCriterion("activity_image is not null");
            return (Criteria) this;
        }

        public Criteria andActivityImageEqualTo(String value) {
            addCriterion("activity_image =", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotEqualTo(String value) {
            addCriterion("activity_image <>", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageGreaterThan(String value) {
            addCriterion("activity_image >", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageGreaterThanOrEqualTo(String value) {
            addCriterion("activity_image >=", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLessThan(String value) {
            addCriterion("activity_image <", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLessThanOrEqualTo(String value) {
            addCriterion("activity_image <=", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLike(String value) {
            addCriterion("activity_image like", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotLike(String value) {
            addCriterion("activity_image not like", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageIn(List<String> values) {
            addCriterion("activity_image in", values, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotIn(List<String> values) {
            addCriterion("activity_image not in", values, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageBetween(String value1, String value2) {
            addCriterion("activity_image between", value1, value2, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotBetween(String value1, String value2) {
            addCriterion("activity_image not between", value1, value2, "activityImage");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table activity
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table activity
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}