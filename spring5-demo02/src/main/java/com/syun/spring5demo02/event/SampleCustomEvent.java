package com.syun.spring5demo02.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @description: 与 sampleCustomEventListener 相匹配
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-09 22:37
 */

public class SampleCustomEvent extends ApplicationContextEvent {

    private static final long serialVersionUID = 4236181525834402987L;

    public SampleCustomEvent(ApplicationContext source) {
        super(source);
    }

}
