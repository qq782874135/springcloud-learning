package com.github.weny.springcloud.springcloudservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
//    @Autowired
//    private StudentService studentService;

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
    public String redisSuber(@RequestBody  StudentDTO studentDTO) {
        String topicData = JSONObject.toJSONString(studentDTO);
        redisTemplate.convertAndSend("topic", topicData);
        redisTemplate.opsForValue().set("test","playgameing");
        return "redis消息发布成功。";
    }

    /*
     * author: Weny
     * @params [age, name]
     * @desc 分布式事务seata，双数据源学习 --https://blog.csdn.net/qq_28193409/article/details/89537216
     */
//    @GetMapping("/addStu")
//    @GlobalTransactional
//    public String galobTrans(int age,String name){
//            //db2+1 简单期间2班新来一个同学
//            Student  student = new Student();
//            student.setAge(age);
//            student.setName(name);
//            student.setCode(UUID.randomUUID().toString());
//            Student student1 = studentService.insert2(student);
//            //db1- 1班随机kill一个小朋友
////            List<Student> students = studentService.queryAll();
////            int number = new Random().nextInt(students.size()) ;
////            int id =students.get(number).getId();
//            boolean b = studentService.deleteById(2);
//            //没有这个人或者kill失败 全局回滚
//            if(!b){
//                throw  new RuntimeException();
//            }
//
//        return "success";
//    }

//    @GetMapping("/addStu")
//    public String addStu(int age,String name) {
//        return  this.galobTrans(age, name);
//    }
}