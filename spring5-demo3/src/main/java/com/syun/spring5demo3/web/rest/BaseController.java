package com.syun.spring5demo3.web.rest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.util.stream.IntStream;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-08 12:52
 */
@RestController
@RequestMapping("/base")
@Slf4j
public class BaseController {


    @GetMapping
    public String hello(){
        log.info("request ");
        return "hello world";
    }

    @Test
    public void test(){

        Annotation annotation = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);

    }


    private final static Integer MAX = Integer.MAX_VALUE;

    @Test
    public void testStream(){
        long start = System.currentTimeMillis();
        IntStream.range(0, MAX)
                .forEach(p -> System.out.println(p));
        long startFor = System.currentTimeMillis();
        for (int i = 0; i < MAX; i++) {
            System.out.println(1);
        }

        System.out.println("stream cost " + (startFor - start)+"ms");
        System.out.println("for cost " + (System.currentTimeMillis() - startFor) + "ms");

    }


}