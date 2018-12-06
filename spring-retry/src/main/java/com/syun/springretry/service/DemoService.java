package com.syun.springretry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @description:
 * @program: spring-retry
 * @author: syun
 * @create: 2018-12-06 13:51
 */

@Slf4j
@Service
public class DemoService {

    private static int totalNum = 10000;


    /**
     * value：抛出指定异常才会重试
     * include：和value一样，默认为空，当exclude也为空时，默认所以异常
     * exclude：指定不处理的异常
     * maxAttempts：最大重试次数，默认3次
     * backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     * @param num
     * @return
     */
    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public int minGoodSum(int num){
        log.info("减库存开始：" + LocalDateTime.now());

        try {
            int i = 1 / 0;
        }catch (Exception e){
            log.error("illegal");
        }

        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束：" + LocalDateTime.now());

        return totalNum - num;
    }

    /**
     * 添加回调函数则不会触发异常
     * @param e 与抛出异常类型相同
     * @return
     */
    @Recover
    public int recover(Exception e) {
        log.warn("回调，减库存失败" + LocalDateTime.now());
        return totalNum;
    }

}
