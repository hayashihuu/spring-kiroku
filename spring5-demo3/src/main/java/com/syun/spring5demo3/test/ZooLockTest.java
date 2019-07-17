package com.syun.spring5demo3.test;

import com.google.common.collect.Lists;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @description: 测试使用 zookeeper 实现分布式锁
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-12 12:18
 */
public class ZooLockTest {


    private final static String zkHost = "118.89.170.23";

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    @Test
    public void test() throws InterruptedException {

//        设置重试次数
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        通过工厂创建连接
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkHost, retryPolicy);
//        开始连接
        client.start();
//        分布式锁
//        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client, "/curator/lock");
        final InterProcessMultiLock multiLock = new InterProcessMultiLock(client, Lists.newArrayList("/curator/lock"));


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        reentrantLock.lock();

        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(() -> {
                boolean flag = false;
                try {
                    //尝试获取锁，最多等待5秒
                    flag = multiLock.acquire(5, TimeUnit.SECONDS);
                    Thread currentThread = Thread.currentThread();
                    if (flag) {
                        System.out.println("线程" + currentThread.getId() + "获取锁成功");
                    } else {
                        System.out.println("线程" + currentThread.getId() + "获取锁失败");
                    }
                    //模拟业务逻辑，延时4秒
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (flag) {
                        try {
                            multiLock.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        condition.await();
    }

    @Test
    public void test1() throws InterruptedException {

//        设置重试次数
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        通过工厂创建连接
        CuratorFramework client = CuratorFrameworkFactory.newClient(zkHost, retryPolicy);
//        开始连接
        client.start();
//        分布式锁
//        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client, "/curator/lock");
        final InterProcessMultiLock multiLock = new InterProcessMultiLock(client, Lists.newArrayList("/curator/lock"));


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        reentrantLock.lock();
        new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();

        }).start();
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(() -> {
                try {
                    Thread currentThread = Thread.currentThread();
                    System.out.println("线程："+currentThread.getName()+" 开始尝试获取锁");
                    multiLock.acquire();
                    System.out.println("线程" + currentThread.getName() + "获取锁成功");
                    //模拟业务逻辑，延时1秒
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        multiLock.release();  //获取到之后一定要释放
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        condition.await();

    }
}
