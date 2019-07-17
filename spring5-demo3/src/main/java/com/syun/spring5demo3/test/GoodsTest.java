package com.syun.spring5demo3.test;

import com.syun.spring5demo3.component.ServiceLock;
import com.syun.spring5demo3.service.GoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.reflect.generics.tree.Tree;

import java.util.concurrent.locks.Condition;
import java.util.stream.IntStream;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-07-17 15:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsTest {

    @Autowired
    private GoodService goodService;


    /**
     * 简单测试使用 lock 进行秒杀锁
     */
    @Test
    public void test01(){

        goodService.goods.put(1L, 1000L);

        IntStream.range(0, 100)
                .forEach(p -> new Thread(()->{

                    IntStream.range(0,20)
                            .forEach(thread->{
                                goodService.BuyGood(1, p);
                            });
                }).start());

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
