package com.syun.spring5demo3.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;


/*
 * @description: spring boot 启动时开始执行的事件
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-05-25 18:35
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationStartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
//        在该事件中可获取 SpringApplication 对象，可做一些前置设置
//        在该监听中获取到 ConfigurableEnvironment 后可以对配置信息做操作，例如：修改默认的配置信息，增加额外的配置信息等等～～～
        SpringApplication application = applicationStartedEvent.getSpringApplication();
        logger.info("== myApplicationStartedEventListener");
    }
}
