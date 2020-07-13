package com.weny.githubsty.springcloud.controller;

import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import com.weny.githubsty.springcloud.service.SpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Weny
 * @Date:2020/7/5下午6:16
 * @desc:
 **/
@RestController
public class SpringcloudControl {

    @Autowired
    private SpringcloudService springcloudService;

    @GetMapping(value ="test")
    public  StudentDTO testFeign(){

        return   springcloudService.getStudent("weny");

    };


}
