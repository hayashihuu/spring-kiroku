package com.syun.pro05;

import lombok.Data;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 20:59
 */
@Data
public class Student {

    private String name;

    private Integer age;



    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }

}
