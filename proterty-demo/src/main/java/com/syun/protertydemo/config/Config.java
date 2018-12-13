package com.syun.protertydemo.config;

import com.syun.protertydemo.service.HelloSerivce;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @description:
 * @program: proterty-demo
 * @author: syun
 * @create: 2018-12-13 14:29
 */
@Configuration
@ImportResource(locations = {"classpath:beans.xml"})
public class Config {

    @Bean
    public HelloSerivce helloSerivce(){
        return new HelloSerivce();
    }

}
