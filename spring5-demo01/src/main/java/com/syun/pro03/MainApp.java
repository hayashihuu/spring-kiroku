package com.syun.pro03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 自动装配
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 22:24
 */
public class MainApp {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("BeansPro03.xml");

        TextEditor te = (TextEditor) context.getBean("textEditor02");
        te.spellCheck();


    }

}
