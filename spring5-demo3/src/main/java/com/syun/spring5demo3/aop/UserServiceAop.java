package com.syun.spring5demo3.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-07 19:00
 */
@Aspect
@Component
@Slf4j
public class UserServiceAop {

    @Pointcut("execution(public * com.syun.spring5demo3.service.impl.UserServiceImpl.getUserInfo())")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        log.info("前置处理");
    }


    @AfterReturning("pointCut()")
    public void afterReturn(){
        log.info("afterReturn");
    }

    @After("pointCut()")
    public void beforeReturn(){
        log.info("After");
    }

//    @Around("pointCut()")
//    public void around(){
//        log.info("around");
//    }

    @Pointcut("execution(public * com.syun.spring5demo3.service.UserService.getUserPassword())")
    public void interfacePointcut(){

    }

    @Before("interfacePointcut()")
    public void beforeInterface(){
        log.info("前置处理");
    }


    @AfterReturning("pointCut()")
    public void afterReturnInterface(){
        log.info("afterReturn");
    }

    @After("pointCut()")
    public void beforeReturnInterface(){
        log.info("After");
    }


}
