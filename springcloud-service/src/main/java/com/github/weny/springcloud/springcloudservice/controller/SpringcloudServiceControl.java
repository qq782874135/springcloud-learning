package com.github.weny.springcloud.springcloudservice.controller;

import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Weny
 * @Date:2020/7/12下午7:29
 * @desc:
 **/
@RestController
@RequestMapping("service")
public class SpringcloudServiceControl {

    @GetMapping("/getstudent")
    public StudentDTO getStudent(String name){
        System.out.println("feign进入成功 ---");
        if("weny".equals(name)){
            StudentDTO studentDTO=new StudentDTO();
            studentDTO.setName("weny");
            studentDTO.setAge(18);
            return studentDTO;
        }
        return  null;
    }
}
