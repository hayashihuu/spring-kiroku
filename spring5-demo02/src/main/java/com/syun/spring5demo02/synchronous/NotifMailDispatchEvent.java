package com.syun.spring5demo02.synchronous;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:29
 */

public class NotifMailDispatchEvent extends ApplicationContextEvent{


    private static final long serialVersionUID = 9202282810553100778L;
    public static final String TASK_KEY = "NotifMailDispatchEvent";

    public NotifMailDispatchEvent(ApplicationContext source) {
        super(source);
    }
}
