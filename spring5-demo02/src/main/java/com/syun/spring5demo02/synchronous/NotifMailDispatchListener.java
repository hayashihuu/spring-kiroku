package com.syun.spring5demo02.synchronous;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:45
 */
@Component
public class NotifMailDispatchListener implements ApplicationListener<NotifMailDispatchEvent> {

    @Override
    public void onApplicationEvent(NotifMailDispatchEvent event) {
        long start = System.currentTimeMillis();
        // sleep 5 seconds to avoid that two listeners execute at the same moment
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        ((TaskStatsHolder) event.getApplicationContext().getBean("taskStatsHolder")).addNewTaskStatHolder(NotifMailDispatchEvent.TASK_KEY, new TaskStatData(Thread.currentThread().getName(), start, end));
    }
}
