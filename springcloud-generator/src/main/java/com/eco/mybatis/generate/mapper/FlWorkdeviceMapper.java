package com.eco.mybatis.generate.mapper;

import com.eco.mybatis.generate.entity.FlWorkdevice;

public interface FlWorkdeviceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    int insert(FlWorkdevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    int insertSelective(FlWorkdevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    FlWorkdevice selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    int updateByPrimaryKeySelective(FlWorkdevice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_workdevice
     *
     * @mbggenerated Wed Jun 10 15:38:53 CST 2020
     */
    int updateByPrimaryKey(FlWorkdevice record);
}