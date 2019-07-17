package com.syun.spring5demo3.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sun.reflect.generics.tree.Tree;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-07-17 14:58
 */
@Component
@Scope
@Aspect
public class LockAspect {

    /**
     * service 默认是单例，并发下 lock 只有一个实例
     */
    private static Lock lock = new ReentrantLock(true);

    @Pointcut("@annotation(com.syun.spring5demo3.component.ServiceLock)")
    public void lockAspect(){

    }

    @Around("lockAspect()")
    public Object aroud(ProceedingJoinPoint joinPoint){
        lock.lock();
        Object object = null;
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            lock.unlock();
        }
        return object;
    }

}
