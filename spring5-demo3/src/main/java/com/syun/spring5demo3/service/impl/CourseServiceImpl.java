package com.syun.spring5demo3.service.impl;

import com.syun.spring5demo3.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-11 10:32
 */
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final RedisTemplate redisTemplate;

    private final ValueOperations Ops;

    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();

    public CourseServiceImpl(RedisTemplate redisTemplate, ValueOperations ops, ValueOperations Ops) {
        this.redisTemplate = redisTemplate;
        this.Ops = Ops;
    }

    @Override
    public void submitCourse(Integer id) {
        Long result = Ops.decrement("Course:Id:" + id);

    }

    @Override
    public void submitCourseAsync(Integer id) {
        copyOnWriteArrayList.add(id);
    }

    @Override
    public void submitCourseAsync(){
        long start = System.currentTimeMillis();
        copyOnWriteArrayList.forEach(p -> Ops.decrement("Course:Id:" + p));
        log.info("total cost " + (System.currentTimeMillis() - start) + "ms");

    }
}
