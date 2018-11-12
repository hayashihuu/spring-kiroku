package com.syun.springbootswagger.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @program: springboot-swagger
 * @author: syun
 * @create: 2018-11-12 16:09
 */
@RestController()
public class TestController {

    @GetMapping("/indexjosn")
    public String hello(){
        return "hello world";
    }

    @ApiOperation("返回姓名测试")
    @GetMapping("/index2")
    public String world(@RequestParam("name") @ApiParam("姓名") String name){
        return name;
    }

    @ApiOperation("测试rest风格")
    @PostMapping("/index/{time}/time")
    public String reset(@PathVariable("time") String time){
        return time;
    }





}
