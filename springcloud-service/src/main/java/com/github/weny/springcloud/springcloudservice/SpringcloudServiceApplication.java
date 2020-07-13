package com.github.weny.springcloud.springcloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceApplication.class, args);
    }

}
