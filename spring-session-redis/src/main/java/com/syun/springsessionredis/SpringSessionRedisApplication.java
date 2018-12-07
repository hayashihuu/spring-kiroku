package com.syun.springsessionredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600,redisNamespace = "t1") 设置过期时间


@SpringBootApplication
@EnableRedisHttpSession
public class SpringSessionRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionRedisApplication.class, args);
    }
}
