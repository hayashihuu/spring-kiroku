package com.syun.spring5demo3.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-05-25 19:08
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable throwable = event.getException();
        handleThrowable(throwable);

    }

    /*处理异常*/
    private void handleThrowable(Throwable throwable) {

    }
}
