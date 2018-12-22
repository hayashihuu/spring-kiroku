package com.syun.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2018-12-16 20:33
 */
@RestController
public class TestController {

    @GetMapping("/test/test")
    public String test(){
        return " test test tes t" ;
    }

}
