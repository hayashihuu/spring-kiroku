//package com.syun.auth.aop;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @description:
// * @program: spring-cloud-security
// * @author: syun
// * @create: 2018-12-19 10:32
// */
//@Aspect
//@Component
//@Slf4j
//public class HttpRequestInfo {
//
//    @Pointcut("execution(public * com.syun.auth.controller*.*(..))")
//    public void requestInfo(){
//
//    }
//
//    @Before("requestInfo()")
//    public void doBefore(JoinPoint joinPoint){
//
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        System.out.println("" + request.getContextPath());
//        System.out.println(request.getSession());
//        System.out.println(request.getHeader("Authorization"));
//        System.out.println( request.getHeaderNames());
//    }
//
//
//
//
//}
