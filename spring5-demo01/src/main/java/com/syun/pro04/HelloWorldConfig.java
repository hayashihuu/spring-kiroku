package com.syun.pro04;

import com.syun.pro01.HelloWorld;
import com.syun.pro04.eventHandler.CCloseEventHandler;
import com.syun.pro04.eventHandler.CStartEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:19
 */
@Configuration
public class HelloWorldConfig {

    @Bean
    @Scope("prototype")
    public HelloWorld helloWorld(){
        return new HelloWorld("こんにちは！");
    }

    @Bean
    public HelloWorldExt helloWorldExt(){
        return new HelloWorldExt(helloWorld());
    }


    @Bean
    public CCloseEventHandler cCloseEventHandler(){
        return new CCloseEventHandler();
    }

    @Bean
    public CStartEventHandler cStartEventHandler(){
        return new CStartEventHandler();
    }

}
