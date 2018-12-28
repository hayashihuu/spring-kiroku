package com.syun.webfluxdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-28 16:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String name;

    private String email;




}
