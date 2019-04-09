package com.syun.spring5demo02.listener;

import com.syun.spring5demo02.event.SampleCustomEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-09 22:39
 */

//通过  ApplicationListener<T> 泛型来判断事件
@Component
public class SampleCustomEventListener implements ApplicationListener<SampleCustomEvent> {


    @Override
    public void onApplicationEvent(SampleCustomEvent event) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        int testTime = Math.round((end - start) / 1000);
        ((TimeExecutorHolder) event.getApplicationContext().getBean("timeExecutorHolder")).addNewTime("sampleCustomEventListener", testTime);
    }

}
