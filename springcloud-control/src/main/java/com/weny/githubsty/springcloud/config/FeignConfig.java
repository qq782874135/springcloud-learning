package com.weny.githubsty.springcloud.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.concurrent.TimeUnit;

/**
 * @author: Weny
 * @Date:2020/7/22下午3:18
 * @desc:
 **/
@Configuration
public class FeignConfig {
    public static int connectTimeOutMillis = 5000;//超时时间
    public static int readTimeOutMillis = 5000;
    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }
//    @Bean
//    public Retryer feignRetryer() {
//        return new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(5),3);
//    }
}
