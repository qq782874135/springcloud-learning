package com.weny.githubsty.springcloud.service;

import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/service/getstudent1")
    StudentDTO getMappingStudent1(String param);

    @PostMapping("/service/poststudent")
    StudentDTO postMappingStudent(String param);

    @RequestMapping(value="/service/redisSuber",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    String redisSuber(@RequestBody StudentDTO studentDTO);

    @RequestMapping(value="/service/addStu",method = RequestMethod.GET)
    String addStu(@RequestParam int age, @RequestParam String name);
}
