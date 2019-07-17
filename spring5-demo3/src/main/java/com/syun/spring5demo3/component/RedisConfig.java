package com.syun.spring5demo3.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-11 10:34
 */
@Configuration
public class RedisConfig  {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Autowired
    @Bean("redisOp")
    public ValueOperations valueOperations(StringRedisTemplate redisTemplate) {

        System.out.println("host = " + host);
        System.out.println("port = " + port);
        System.out.println("password = " + password);

        return redisTemplate.opsForValue();
    }


}
