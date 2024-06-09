package com.ltb.gateway.center.domain.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 消息推送服务
 *
 * @author leetao
 */
@Service
public class Publisher {

    private final RedisTemplate<String,Object> redisMessageTemplate;

    @Autowired
    public Publisher(RedisTemplate<String,Object> redisMessageTemplate) {
        this.redisMessageTemplate = redisMessageTemplate;
    }

    public void publish(String topic,Object message) {
        redisMessageTemplate.convertAndSend(topic,message);
    }

}
