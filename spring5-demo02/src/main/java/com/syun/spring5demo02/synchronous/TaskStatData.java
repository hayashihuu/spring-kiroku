package com.syun.spring5demo02.synchronous;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:27
 */

@Data
public class TaskStatData {

    private String threadName;
    private int executionTime;
    private long startTime;
    private long endTime;

    public TaskStatData(String threadName, long startTime, long endTime) {
        this.threadName = threadName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.executionTime = Math.round((endTime - startTime) / 1000);
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("TaskStatData {thread name: ").append(this.threadName).append(", start time: ").append(new Date(this.startTime));
        result.append(", end time: ").append(new Date(this.endTime)).append(", execution time: ").append(this.executionTime).append(" seconds}");
        return result.toString();
    }
}
