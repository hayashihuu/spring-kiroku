package com.syun.spring5demo3.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-11 10:53
 */
@Component
public class CourseInit implements CommandLineRunner {

    @Resource(name = "redisOp")
    private ValueOperations valueOperations;

    @Override
    @SuppressWarnings("unchecked")
    public void run(String... args) {
        valueOperations.set("Course:Id:1", "1000");
        valueOperations.set("Course:Id:2", "100");
        valueOperations.set("Course:Id:3", "100");
        valueOperations.set("Course:Id:4", "100");
        valueOperations.set("Course:Id:5", "100");

    }
}
