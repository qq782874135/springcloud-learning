package com.eco.mybatis.generate.mapper;

import com.eco.mybatis.generate.entity.FlWxCount;

public interface FlWxCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    int deleteByPrimaryKey(Integer wechatId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    int insert(FlWxCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    int insertSelective(FlWxCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    FlWxCount selectByPrimaryKey(Integer wechatId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    int updateByPrimaryKeySelective(FlWxCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fl_wx_count
     *
     * @mbggenerated Tue Jun 16 17:18:25 CST 2020
     */
    int updateByPrimaryKey(FlWxCount record);
}