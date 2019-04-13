package com.syun.spring5demo02.synchronous;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:26
 */
@Component
public class TaskStatsHolder {

    private Map<String, TaskStatData> tasks = new HashMap<>();

    public void addNewTaskStatHolder(String key, TaskStatData value) {
        tasks.put(key, value);
    }

    public TaskStatData getTaskStatHolder(String key) {
        return tasks.get(key);
    }
}
