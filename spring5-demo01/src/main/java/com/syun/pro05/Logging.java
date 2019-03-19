package com.syun.pro05;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:59
 */
public class Logging {

    public void beforeAdvice(){
        System.out.println("Going to setup student profile.");
    }

    public void afterAdvice(){
        System.out.println("Student profile has been setup.");
    }

    public void afterReturningAdvice(Object retVal){
        System.out.println("Returning:" + retVal.toString() );
    }

    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("There has been an exception: " + ex.toString());
    }

}
