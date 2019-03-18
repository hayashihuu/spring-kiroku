package com.syun.pro01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: Spring Ioc 容器
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:09
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansPro01.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.getMessage();

//        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
//        objB.getMessage();

        HelloIndia india = (HelloIndia) context.getBean("helloIndia");
        india.getMessage1();
        india.getMessage2();
        india.getMessage3();

    }


}
