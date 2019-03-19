package com.syun.pro04.eventHandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @description: 在 context 结束时
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:43
 */
public class CCloseEventHandler implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {

        System.out.println("ContextStoppedEvent Received");
    }

}
