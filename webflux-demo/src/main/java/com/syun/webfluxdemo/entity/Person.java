package com.syun.webfluxdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-28 15:59
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;

    private Integer age;

    private String addr;


}
