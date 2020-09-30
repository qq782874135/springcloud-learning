package com.weny.githubsty.springcloud.controller;

import com.github.weny.springcloud.springcloudcommon.message.MsgBean;
import com.github.weny.springcloud.springcloudcommon.model.StudentDTO;
import com.weny.githubsty.springcloud.GyPlusMaterialBo;
import com.weny.githubsty.springcloud.result.CommonResult;
import com.weny.githubsty.springcloud.service.SpringcloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Weny
 * @Date:2020/7/5下午6:16
 * @desc:
 **/
@RestController
public class SpringcloudControl extends  BaseResultController{

    @Autowired
    private SpringcloudService springcloudService;



    @GetMapping(value ="test")
    public  StudentDTO testFeign(){

        return   springcloudService.getStudent("weny");

    };

    /*
     * description:
     * date: 2020/7/22 上午11:25
     * author: Weny
     * @params []
     * @return com.github.weny.springcloud.springcloudcommon.model.StudentDTO
     * @desc redis发布订阅+分布式
     */
    @GetMapping(value ="redisSuber")
    public String redisSuber(StudentDTO studentDTO){
        return springcloudService.redisSuber(studentDTO);
    }

    /*
     * description:  分布式事务seata 转换班级 模拟不同数据库表数据变更
     *  https://github.com/seata/seata-samples/blob/master/doc/quick-integration-with-spring-cloud.md#2--%25E6%25B7%25BB%25E5%258A%25A0seata-%25E9%2585%258D%25E7%25BD%25AE%25E6%2596%2587%25E4%25BB%25B6
     * date: 2020/7/27 下午2:00
     * author: Weny
     * @params []
     * @return java.lang.String
     */
    @GetMapping("add")
    public String gloabalTrans(int age,String name){
        return  springcloudService.addStu(age,name);
    }

    @PostMapping("sendMsg")
    public CommonResult sendMsg(MsgBean msgBean){
        try{

        }catch (Exception e){

        }
        return  Result.error("A");
    }

    @PostMapping("sendMsg2")
    public CommonResult sendMsg2(@RequestBody  GyPlusMaterialBo msgBean){
        System.out.println(msgBean);
        try{

        }catch (Exception e){

        }
        return  Result.error("A");
    }
}
