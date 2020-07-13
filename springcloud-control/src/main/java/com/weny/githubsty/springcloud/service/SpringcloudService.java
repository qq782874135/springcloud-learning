package com.weny.githubsty.springcloud.service;

import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Weny
 * @Date:2020/7/5下午6:23
 * @desc:
 **/
@FeignClient(value = "weny-service")
public interface SpringcloudService {

    /*get请求需要加上 @RequestParam识别参数 否则会被转化成post*/
    @RequestMapping(value="/service/getstudent",method = RequestMethod.GET)
    StudentDTO getStudent(@RequestParam  String name);


}
