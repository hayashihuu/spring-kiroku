package com.syun.spring5demo02.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:33
 */
@Component
public class ProductChangeFailureListener implements ApplicationListener<ProductChangeFailureEvent> {


    @Override
    public void onApplicationEvent(ProductChangeFailureEvent event) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        ((TaskStatsHolder) event.getApplicationContext().getBean("taskStatsHolder")).addNewTaskStatHolder(ProductChangeFailureEvent.TASK_KEY, new TaskStatData(Thread.currentThread().getName(), start, end));
    }
}
