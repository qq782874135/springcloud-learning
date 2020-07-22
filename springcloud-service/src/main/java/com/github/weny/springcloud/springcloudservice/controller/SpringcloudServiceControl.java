package com.github.weny.springcloud.springcloudservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: Weny
 * @Date:2020/7/12下午7:29
 * @desc:
 **/
@RestController
@RequestMapping("service")
@Component
public class SpringcloudServiceControl {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/getstudent")
    public StudentDTO getStudent(String name) {
        System.out.println("feign进入成功 ---");
        if ("weny".equals(name)) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName("weny");
            studentDTO.setAge(18);
            return studentDTO;
        }
        return null;
    }

    @GetMapping("/getstudent1")
    public StudentDTO getMappingStudent1(String name) {
        System.out.println("feign进入成功 ---");
        if ("weny".equals(name)) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName("get1");
            studentDTO.setAge(18);
            return studentDTO;
        }
        return null;
    }

    @PostMapping("/poststudent")
    public StudentDTO postMappingStudent(String name) {
        System.out.println("feign进入成功 ---");
        if ("weny".equals(name)) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName("post");
            studentDTO.setAge(18);
            return studentDTO;
        }
        return null;
    }

    /*
     * description: redis发布消息
     * date: 2020/7/22 上午11:59
     * author: Weny
     * @params [studentDTO]
     * @return void
     */
    @PostMapping(value = "/redisSuber")
    public String redisSuber(StudentDTO studentDTO) {
        String topicData = JSONObject.toJSONString(studentDTO);
        redisTemplate.convertAndSend("topic", topicData);
        redisTemplate.opsForValue().set("test","playgameing");
        return "redis消息发布成功。";
    }
}