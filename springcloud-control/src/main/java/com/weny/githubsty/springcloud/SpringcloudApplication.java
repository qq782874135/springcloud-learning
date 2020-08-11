package com.weny.githubsty.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class SpringcloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudApplication.class, args);
    }

    @Value("${author.name}")
    private  String author;

    @RequestMapping(value = "/author")
    @ResponseBody
    public String nacostest() {
        return  author;
    }

}
