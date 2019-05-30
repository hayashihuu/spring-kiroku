package com.syun.spring5demo3.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Optional;

/*
 * @description: spring boot 对应 Enviroment 已经准备完毕，但此时上下文 context 还没有创建。
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-05-25 18:45
 */

/**
 * 环境配置监听
 */
@Slf4j
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        ConfigurableEnvironment envi = applicationEnvironmentPreparedEvent.getEnvironment();
        Optional.ofNullable(envi.getPropertySources())
                .ifPresent(p -> p.forEach(ps -> log.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass())));

    }
}
