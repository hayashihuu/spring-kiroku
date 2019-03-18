package com.syun.pro01;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:08
 */
public class HelloWorld {

    private String message;

    private String message1;

    public void getMessage1() {
        System.out.println(message1);
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    private User user;

    public HelloWorld(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("your message: " + message);
    }

    public void init(){
        System.out.println("Bean is going through init");
    }

    public void destroy() {
        System.out.println("Bean will destroy now");

    }


}
