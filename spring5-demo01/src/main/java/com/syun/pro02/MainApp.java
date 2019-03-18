package com.syun.pro02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: Spring 依赖注入
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:50
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("BeansPro02.xml");
        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();

        TextEditor tek = (TextEditor) context.getBean("textEditork");
        System.out.println(tek.toString());

//        集合注入
        JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
        System.out.println(jc.toString());

    }
}
