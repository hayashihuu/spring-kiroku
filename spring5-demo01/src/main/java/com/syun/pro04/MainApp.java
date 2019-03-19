package com.syun.pro04;

import com.syun.pro01.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * @description: 基于注解依赖注入
 *  Spring 事件处理 事件可自定义
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:03
 */
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("BeansPro04.xml");

        TextEditor editor = (TextEditor) context.getBean("textEditor");

        editor.spellCheck();

    }

    @Test
    public void test01(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld helloWorld = context.getBean(HelloWorld.class);

        helloWorld.getMessage();

        HelloWorldExt helloWorldExt = context.getBean(HelloWorldExt.class);

        helloWorldExt.hello();


//        context.register("xxxxConfig.class");
//        context.refresh();

    }


    /**
     * 时间处理
     */
    @Test
    public void test02(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfigs.class);
        context.start();
        context.getBean(HelloWorldExt.class).hello();
        context.stop();

    }

}
