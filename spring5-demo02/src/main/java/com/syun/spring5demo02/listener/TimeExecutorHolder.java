package com.syun.spring5demo02.listener;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-09 22:36
 */

@Component("timeExecutorHolder")
public class TimeExecutorHolder {
    private Map<String, Integer> testTimes = new HashMap();

    public void addNewTime(String key, Integer value) {
        testTimes.put(key, value);
    }

    public Integer getTestTime(String key) {
        return testTimes.get(key);
    }
}
