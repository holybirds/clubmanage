package com.example.clubmanage.dao;

import com.example.clubmanage.bean.ClubJoin;
import com.example.clubmanage.bean.ClubJoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClubJoinMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int countByExample(ClubJoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int deleteByExample(ClubJoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer clubjoinId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int insert(ClubJoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int insertSelective(ClubJoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    List<ClubJoin> selectByExample(ClubJoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    ClubJoin selectByPrimaryKey(Integer clubjoinId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClubJoin record, @Param("example") ClubJoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClubJoin record, @Param("example") ClubJoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClubJoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_join
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClubJoin record);
}