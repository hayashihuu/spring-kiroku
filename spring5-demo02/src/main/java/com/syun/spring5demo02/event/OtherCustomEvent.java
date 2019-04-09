package com.syun.spring5demo02.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @description: 默认的 applicationContextEvent 事件
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-09 22:38
 */
public class OtherCustomEvent extends ApplicationContextEvent {

    private static final long serialVersionUID = 5236181525834402987L;

    public OtherCustomEvent(ApplicationContext source) {
        super(source);
    }
}
