package com.syun.spring5demo3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

/*
 * @description:
 * @program: spring5-demo3
 * @author: syun
 * @create: 2019-06-08 12:52
 */
@RestController
@RequestMapping("/base")
@Slf4j
public class BaseController {


    @GetMapping
    public String hello(){
        log.info("request ");
        return "hello world";
    }

}
