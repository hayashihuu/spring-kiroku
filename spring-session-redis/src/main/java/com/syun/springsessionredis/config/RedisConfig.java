package com.syun.springsessionredis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @program: spring-session-redis
 * @author: syun
 * @create: 2018-11-08 14:49
 */
@Configuration
@Component
public class RedisConfig  {

    @Autowired
    private RedisTemplate redisTemplate;


    @Bean("StringRedisTemplate")
    public RedisTemplate redisTemplate(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }


}
