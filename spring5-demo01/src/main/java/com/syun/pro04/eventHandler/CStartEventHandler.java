package com.syun.pro04.eventHandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @description: context 启动时
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:41
 */
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {

        System.out.println("ContextEvent Received");

    }
}
