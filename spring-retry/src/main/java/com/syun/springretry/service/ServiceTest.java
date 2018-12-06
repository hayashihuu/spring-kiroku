package com.syun.springretry.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @program: spring-retry
 * @author: syun
 * @create: 2018-12-06 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private DemoService demoService;

    @Test
    public void payTest(){
        int store = demoService.minGoodSum(-1);
        System.out.println("库存为：" + store);
    }

}
