package com.syun.springbootswagger.controller;

import com.syun.springbootswagger.UrlE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @program: springboot-swagger
 * @author: syun
 * @create: 2018-11-12 17:18
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String indexIndex(){
        return "index";
    }

    @PostMapping("/urlSave")
    @ResponseBody
    public String urlSave(@RequestBody List<UrlE> urlES){

        urlES.forEach(System.out::println);
        return "test";
    }
}
