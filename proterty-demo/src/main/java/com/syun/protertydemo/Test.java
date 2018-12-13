package com.syun.protertydemo;

import com.syun.protertydemo.config.PropertiesFormFile;
import com.syun.protertydemo.service.HelloSerivce;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @program: proterty-demo
 * @author: syun
 * @create: 2018-12-13 14:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private PropertiesFormFile propertiesFormFile;

    @Autowired
    private ApplicationContext ioc;

    @Autowired
    private HelloSerivce helloSerivce;


    @org.junit.Test
    public void test01(){
        System.out.println(propertiesFormFile.toString());

    }

    @org.junit.Test
    public void test02(){
        System.out.println(ioc.containsBean("helloSerivce"));
    }



}
