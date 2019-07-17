package com.syun.spring5demo3.service.impl;

import com.syun.spring5demo3.component.ServiceLock;
import com.syun.spring5demo3.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-07-17 14:55
 */
@Slf4j
@Service
public class GoodServiceImpl implements GoodService {




    @ServiceLock
    @Override
    @Transactional
    public void BuyGood(long seckillId, long userId) {
        Long temp = goods.get(seckillId);
        if (temp > 0) {
            temp--;
        }else {
            return;
        }
        goods.put(seckillId, temp);
        log.info("{} 买到了 {}", userId, seckillId);
        System.out.println("good size: " + temp);
    }
}
