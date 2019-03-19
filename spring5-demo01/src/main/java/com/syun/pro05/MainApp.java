package com.syun.pro05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 21:00
 */
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("BeansPro05.xml");

        Student s = (Student) context.getBean("student");

        System.out.println(s.getName());
        System.out.println(s.getAge());



    }


}
