package com.syun.pro05;

import org.aspectj.lang.annotation.*;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:59
 */
@Aspect
public class LoggingKai {

    @Pointcut("execution(* com.syun.pro05.Student.*(..))")
    private void selectAll(){

    }

    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Going to setup student profile.");
    }

    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("Student profile has been setup.");
    }

    @AfterReturning(pointcut = "selectAll()",returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an exception: " + ex.toString());
    }

}
