package com.eco.mybatis.generate.mapper;

import com.eco.mybatis.generate.entity.FlWorkUserCount;

public interface FlWorkUserCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    int deleteByPrimaryKey(Integer wechatWorkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    int insert(FlWorkUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    int insertSelective(FlWorkUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    FlWorkUserCount selectByPrimaryKey(Integer wechatWorkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    int updateByPrimaryKeySelective(FlWorkUserCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_work_user_count
     *
     * @mbggenerated Wed Jun 10 15:38:05 CST 2020
     */
    int updateByPrimaryKey(FlWorkUserCount record);
}