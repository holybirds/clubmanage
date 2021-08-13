package com.example.clubmanage.dao;

import com.example.clubmanage.bean.ClubCreat;
import com.example.clubmanage.bean.ClubCreatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClubCreatMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int countByExample(ClubCreatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int deleteByExample(ClubCreatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer clubcreatId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int insert(ClubCreat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int insertSelective(ClubCreat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    List<ClubCreat> selectByExample(ClubCreatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    ClubCreat selectByPrimaryKey(Integer clubcreatId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ClubCreat record, @Param("example") ClubCreatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ClubCreat record, @Param("example") ClubCreatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClubCreat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table club_creat
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClubCreat record);
}