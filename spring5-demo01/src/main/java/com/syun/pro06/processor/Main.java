package com.syun.pro06.processor;

import com.syun.pro06.processorKai.ViewChecker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试 bean 工厂的后置处理器，对于 bean 初始化的一些额外操作
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-04-10 21:28
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("BeansPro05.xml");

//        Welcomer welcomer = (Welcomer) context.getBean("welcomerBean");
//        System.out.println("Text: " + welcomer.getWelcomeText());

//        InitSequenceBean initSequenceBean = (InitSequenceBean) context.getBean("initSequenceBean");


        ViewChecker viewChecker = (ViewChecker) context.getBean("viewChecker");
        viewChecker.get();
    }
}
