package com.example.clubmanage.bean;

import java.util.Date;

public class ClubJoin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.clubjoin_id
     *
     * @mbggenerated
     */
    private Integer clubjoinId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.club_name
     *
     * @mbggenerated
     */
    private String clubName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.clubmanager_name
     *
     * @mbggenerated
     */
    private String clubmanagerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.userjoin_name
     *
     * @mbggenerated
     */
    private String userjoinName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.join_date
     *
     * @mbggenerated
     */
    private Date joinDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.joined_club
     *
     * @mbggenerated
     */
    private String joinedClub;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column club_join.clubjoin_state
     *
     * @mbggenerated
     */
    private Integer clubjoinState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.clubjoin_id
     *
     * @return the value of club_join.clubjoin_id
     *
     * @mbggenerated
     */
    public Integer getClubjoinId() {
        return clubjoinId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.clubjoin_id
     *
     * @param clubjoinId the value for club_join.clubjoin_id
     *
     * @mbggenerated
     */
    public void setClubjoinId(Integer clubjoinId) {
        this.clubjoinId = clubjoinId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.club_name
     *
     * @return the value of club_join.club_name
     *
     * @mbggenerated
     */
    public String getClubName() {
        return clubName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.club_name
     *
     * @param clubName the value for club_join.club_name
     *
     * @mbggenerated
     */
    public void setClubName(String clubName) {
        this.clubName = clubName == null ? null : clubName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.clubmanager_name
     *
     * @return the value of club_join.clubmanager_name
     *
     * @mbggenerated
     */
    public String getClubmanagerName() {
        return clubmanagerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.clubmanager_name
     *
     * @param clubmanagerName the value for club_join.clubmanager_name
     *
     * @mbggenerated
     */
    public void setClubmanagerName(String clubmanagerName) {
        this.clubmanagerName = clubmanagerName == null ? null : clubmanagerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.userjoin_name
     *
     * @return the value of club_join.userjoin_name
     *
     * @mbggenerated
     */
    public String getUserjoinName() {
        return userjoinName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.userjoin_name
     *
     * @param userjoinName the value for club_join.userjoin_name
     *
     * @mbggenerated
     */
    public void setUserjoinName(String userjoinName) {
        this.userjoinName = userjoinName == null ? null : userjoinName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.join_date
     *
     * @return the value of club_join.join_date
     *
     * @mbggenerated
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.join_date
     *
     * @param joinDate the value for club_join.join_date
     *
     * @mbggenerated
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.joined_club
     *
     * @return the value of club_join.joined_club
     *
     * @mbggenerated
     */
    public String getJoinedClub() {
        return joinedClub;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.joined_club
     *
     * @param joinedClub the value for club_join.joined_club
     *
     * @mbggenerated
     */
    public void setJoinedClub(String joinedClub) {
        this.joinedClub = joinedClub == null ? null : joinedClub.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column club_join.clubjoin_state
     *
     * @return the value of club_join.clubjoin_state
     *
     * @mbggenerated
     */
    public Integer getClubjoinState() {
        return clubjoinState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column club_join.clubjoin_state
     *
     * @param clubjoinState the value for club_join.clubjoin_state
     *
     * @mbggenerated
     */
    public void setClubjoinState(Integer clubjoinState) {
        this.clubjoinState = clubjoinState;
    }
}