package com.syun.pro01;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:35
 */
public class HelloIndia {
    private String message1;
    private String message2;
    private String message3;

    public String getMessage1() {
        System.out.println(message1);
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        System.out.println(message2);
        return message2;
    }

    public void setMessage2(String message2) {

        this.message2 = message2;
    }

    public String getMessage3() {
        System.out.println(message3);
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }
}
