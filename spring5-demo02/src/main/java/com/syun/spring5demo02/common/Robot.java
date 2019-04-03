package com.syun.spring5demo02.common;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-03-25 20:47
 */


public class Robot implements Cloneable {
    private String name;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

