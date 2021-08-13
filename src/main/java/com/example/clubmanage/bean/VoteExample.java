package com.example.clubmanage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VoteExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vote
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vote
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vote
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public VoteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
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
     * This method corresponds to the database table vote
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
     * This method corresponds to the database table vote
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vote
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
     * This class corresponds to the database table vote
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

        public Criteria andVoteIdIsNull() {
            addCriterion("vote_id is null");
            return (Criteria) this;
        }

        public Criteria andVoteIdIsNotNull() {
            addCriterion("vote_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoteIdEqualTo(Integer value) {
            addCriterion("vote_id =", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotEqualTo(Integer value) {
            addCriterion("vote_id <>", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThan(Integer value) {
            addCriterion("vote_id >", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_id >=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThan(Integer value) {
            addCriterion("vote_id <", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdLessThanOrEqualTo(Integer value) {
            addCriterion("vote_id <=", value, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdIn(List<Integer> values) {
            addCriterion("vote_id in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotIn(List<Integer> values) {
            addCriterion("vote_id not in", values, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdBetween(Integer value1, Integer value2) {
            addCriterion("vote_id between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andVoteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_id not between", value1, value2, "voteId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andJoinedNumberIsNull() {
            addCriterion("joined_number is null");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberIsNotNull() {
            addCriterion("joined_number is not null");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberEqualTo(Integer value) {
            addCriterion("joined_number =", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberNotEqualTo(Integer value) {
            addCriterion("joined_number <>", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberGreaterThan(Integer value) {
            addCriterion("joined_number >", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("joined_number >=", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberLessThan(Integer value) {
            addCriterion("joined_number <", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberLessThanOrEqualTo(Integer value) {
            addCriterion("joined_number <=", value, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberIn(List<Integer> values) {
            addCriterion("joined_number in", values, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberNotIn(List<Integer> values) {
            addCriterion("joined_number not in", values, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberBetween(Integer value1, Integer value2) {
            addCriterion("joined_number between", value1, value2, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andJoinedNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("joined_number not between", value1, value2, "joinedNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberIsNull() {
            addCriterion("yes_number is null");
            return (Criteria) this;
        }

        public Criteria andYesNumberIsNotNull() {
            addCriterion("yes_number is not null");
            return (Criteria) this;
        }

        public Criteria andYesNumberEqualTo(Integer value) {
            addCriterion("yes_number =", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberNotEqualTo(Integer value) {
            addCriterion("yes_number <>", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberGreaterThan(Integer value) {
            addCriterion("yes_number >", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("yes_number >=", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberLessThan(Integer value) {
            addCriterion("yes_number <", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberLessThanOrEqualTo(Integer value) {
            addCriterion("yes_number <=", value, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberIn(List<Integer> values) {
            addCriterion("yes_number in", values, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberNotIn(List<Integer> values) {
            addCriterion("yes_number not in", values, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberBetween(Integer value1, Integer value2) {
            addCriterion("yes_number between", value1, value2, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andYesNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("yes_number not between", value1, value2, "yesNumber");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateIsNull() {
            addCriterion("vote_creatstate is null");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateIsNotNull() {
            addCriterion("vote_creatstate is not null");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateEqualTo(Integer value) {
            addCriterion("vote_creatstate =", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateNotEqualTo(Integer value) {
            addCriterion("vote_creatstate <>", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateGreaterThan(Integer value) {
            addCriterion("vote_creatstate >", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote_creatstate >=", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateLessThan(Integer value) {
            addCriterion("vote_creatstate <", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateLessThanOrEqualTo(Integer value) {
            addCriterion("vote_creatstate <=", value, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateIn(List<Integer> values) {
            addCriterion("vote_creatstate in", values, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateNotIn(List<Integer> values) {
            addCriterion("vote_creatstate not in", values, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateBetween(Integer value1, Integer value2) {
            addCriterion("vote_creatstate between", value1, value2, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteCreatstateNotBetween(Integer value1, Integer value2) {
            addCriterion("vote_creatstate not between", value1, value2, "voteCreatstate");
            return (Criteria) this;
        }

        public Criteria andVoteContentIsNull() {
            addCriterion("vote_content is null");
            return (Criteria) this;
        }

        public Criteria andVoteContentIsNotNull() {
            addCriterion("vote_content is not null");
            return (Criteria) this;
        }

        public Criteria andVoteContentEqualTo(String value) {
            addCriterion("vote_content =", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentNotEqualTo(String value) {
            addCriterion("vote_content <>", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentGreaterThan(String value) {
            addCriterion("vote_content >", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentGreaterThanOrEqualTo(String value) {
            addCriterion("vote_content >=", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentLessThan(String value) {
            addCriterion("vote_content <", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentLessThanOrEqualTo(String value) {
            addCriterion("vote_content <=", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentLike(String value) {
            addCriterion("vote_content like", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentNotLike(String value) {
            addCriterion("vote_content not like", value, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentIn(List<String> values) {
            addCriterion("vote_content in", values, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentNotIn(List<String> values) {
            addCriterion("vote_content not in", values, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentBetween(String value1, String value2) {
            addCriterion("vote_content between", value1, value2, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteContentNotBetween(String value1, String value2) {
            addCriterion("vote_content not between", value1, value2, "voteContent");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemIsNull() {
            addCriterion("vote_yesitem is null");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemIsNotNull() {
            addCriterion("vote_yesitem is not null");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemEqualTo(String value) {
            addCriterion("vote_yesitem =", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemNotEqualTo(String value) {
            addCriterion("vote_yesitem <>", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemGreaterThan(String value) {
            addCriterion("vote_yesitem >", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemGreaterThanOrEqualTo(String value) {
            addCriterion("vote_yesitem >=", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemLessThan(String value) {
            addCriterion("vote_yesitem <", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemLessThanOrEqualTo(String value) {
            addCriterion("vote_yesitem <=", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemLike(String value) {
            addCriterion("vote_yesitem like", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemNotLike(String value) {
            addCriterion("vote_yesitem not like", value, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemIn(List<String> values) {
            addCriterion("vote_yesitem in", values, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemNotIn(List<String> values) {
            addCriterion("vote_yesitem not in", values, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemBetween(String value1, String value2) {
            addCriterion("vote_yesitem between", value1, value2, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteYesitemNotBetween(String value1, String value2) {
            addCriterion("vote_yesitem not between", value1, value2, "voteYesitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemIsNull() {
            addCriterion("vote_noitem is null");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemIsNotNull() {
            addCriterion("vote_noitem is not null");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemEqualTo(String value) {
            addCriterion("vote_noitem =", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemNotEqualTo(String value) {
            addCriterion("vote_noitem <>", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemGreaterThan(String value) {
            addCriterion("vote_noitem >", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemGreaterThanOrEqualTo(String value) {
            addCriterion("vote_noitem >=", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemLessThan(String value) {
            addCriterion("vote_noitem <", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemLessThanOrEqualTo(String value) {
            addCriterion("vote_noitem <=", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemLike(String value) {
            addCriterion("vote_noitem like", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemNotLike(String value) {
            addCriterion("vote_noitem not like", value, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemIn(List<String> values) {
            addCriterion("vote_noitem in", values, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemNotIn(List<String> values) {
            addCriterion("vote_noitem not in", values, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemBetween(String value1, String value2) {
            addCriterion("vote_noitem between", value1, value2, "voteNoitem");
            return (Criteria) this;
        }

        public Criteria andVoteNoitemNotBetween(String value1, String value2) {
            addCriterion("vote_noitem not between", value1, value2, "voteNoitem");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vote
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
     * This class corresponds to the database table vote
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