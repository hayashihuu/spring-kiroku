package com.syun.springsessionredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @program: spring-session-redis
 * @author: syun
 * @create: 2018-12-06 14:18
 */

@Component
public class RedisLockHelper {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "StringRedisTemplate")
    private RedisTemplate stringRedisTemplate;

    @SuppressWarnings("all")
    public  boolean lock(String uid, String now, Long second) {
        return stringRedisTemplate.opsForValue().setIfAbsent(uid, now, second, TimeUnit.SECONDS);
    }

    @SuppressWarnings("all")
    public void unLock(String uid) {
        stringRedisTemplate.delete(uid);
    }






}
