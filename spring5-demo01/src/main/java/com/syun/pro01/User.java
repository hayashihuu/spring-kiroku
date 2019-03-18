package com.syun.pro01;

import javax.swing.*;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-18 21:20
 */
public class User {
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
