package com.syun.spring5demo3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * @description:上下文创建完成后执行的事件监听器
 * ApplicationPreparedEvent:spring boot 上下文 context 创建完成，但此时 spring 中的 bean 是没有完全加载完成的。
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-05-25 19:04
 */
@Slf4j
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {

        ConfigurableApplicationContext cac = applicationPreparedEvent.getApplicationContext();

        log.info("get ApplicationContext ");
        passContextInfo(cac);
    }
    /**
     * 传递上下文
     * @param cac
     */
    private void passContextInfo(ApplicationContext cac) {
        //dosomething()
//        获取上下文可以获取一些额外操作，在该监听器中是无法获取自定义 bean 并进行操作的。
    }


}
