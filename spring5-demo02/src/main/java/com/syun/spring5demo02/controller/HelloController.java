package com.syun.spring5demo02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-03 19:59
 */
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public String helloWorld(){
        return "hello world";
    }


}
