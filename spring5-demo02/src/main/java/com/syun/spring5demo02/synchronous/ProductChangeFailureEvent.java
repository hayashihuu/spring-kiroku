package com.syun.spring5demo02.synchronous;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:29
 */
public class ProductChangeFailureEvent extends ApplicationContextEvent {
    private static final long serialVersionUID = -1681426286796814792L;
    public static final String TASK_KEY = "ProductChangeFailureEvent";


    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public ProductChangeFailureEvent(ApplicationContext source) {
        super(source);
    }
}
