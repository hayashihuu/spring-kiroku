package com.syun.spring5demo02.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-03-25 20:49
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class SpringPrototypeTest  {

    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void test() {
        Robot robot = (Robot) beanFactory.getBean("shoppingCart");
        System.out.println(robot.getName());

    }
}
