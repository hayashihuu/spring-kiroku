package com.syun.spring5demo3;

import com.syun.spring5demo3.listener.MyApplicationEnvironmentPreparedEventListener;
import com.syun.spring5demo3.listener.MyApplicationFailedEventListener;
import com.syun.spring5demo3.listener.MyApplicationPreparedEventListener;
import com.syun.spring5demo3.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * 用以分析 spring boot 的源码
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Spring5Demo3Application {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Spring5Demo3Application.class);

        application.addListeners(new MyApplicationStartedEventListener());
        application.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        application.addListeners(new MyApplicationPreparedEventListener());
        application.addListeners(new MyApplicationFailedEventListener());

        application.run(args);
    }

}
