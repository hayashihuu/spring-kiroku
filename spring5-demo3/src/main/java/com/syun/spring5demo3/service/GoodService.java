package com.syun.spring5demo3.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * @description: 使用 lock 锁实现秒杀
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-07-17 14:53
 */
public interface GoodService {

     Map<Long, Long> goods = new HashMap<>();

    void BuyGood(long seckillId, long userId);

}
