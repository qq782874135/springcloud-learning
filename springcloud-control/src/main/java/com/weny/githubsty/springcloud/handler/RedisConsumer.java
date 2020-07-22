package com.weny.githubsty.springcloud.handler;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Weny
 * @Date:2020/7/22下午1:35
 * @desc:
 **/
@Component
public class RedisConsumer implements MessageListener {
    @Resource
    RedisTemplate<String,String> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        //消息体
        String body = new String(message.getBody());
        //渠道名称
        String topic = new String(bytes);
        System.out.println("listener:消息体：" + body + "渠道名称：" + topic);
        String value = redisTemplate.opsForValue().get("test");
        System.out.println("redis取得key=test value="+value);

    }
}
