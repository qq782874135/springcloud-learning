package com.github.weny.springcloud.springcloudcommon.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Weny
 * @Date:2020/7/5下午6:17
 * @desc:
 **/
@Data
public class StudentDTO implements Serializable {

    private  String name;
    private  Integer age;

}
