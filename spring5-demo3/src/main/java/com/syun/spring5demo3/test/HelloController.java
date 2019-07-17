package com.syun.spring5demo3.test;



import com.syun.spring5demo3.component.Bean2;
import com.syun.spring5demo3.service.CourseService;
import com.syun.spring5demo3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Currency;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;


/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-07 18:45
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloController {

    @Autowired
    @Qualifier("list")
    private ArrayList arrayList;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Test
    public void test(){
        log.info("AopImplementController ==> call method: {}", userService.getClass());
        userService.getUserInfo();
    }

    @Test
    public void testInterface(){
        log.info("AopImplementController ==> call method: {}", userService.getClass());
        userService.getUserPassword();
    }

    @Test
    public void testBeanRegister(){
        Bean2 b = (Bean2) applicationContext.getBean("bean2");
        b.test();
    }


    @Test
    public void testCourse(){
        AtomicLong atomicLong = new AtomicLong(0);
        IntStream.range(0,10)
                .parallel()
                .forEach(p->{
                    long start = System.currentTimeMillis();
                    for (int i = 0; i < 100; i++) {
                        courseService.submitCourse(1);
                    }
                    atomicLong.addAndGet(System.currentTimeMillis() - start);
                });
        System.out.println("total cost " + atomicLong + "ms");
    }
//    total cost 117157ms
//               57700ms
    @Test
    public void testCourse1(){
        IntStream.range(0,10)
                .parallel()
                .forEach(p->{
                    for (int i = 0; i < 100; i++) {
                        courseService.submitCourseAsync(1);
                    }
                });
        courseService.submitCourseAsync();
    }





}
