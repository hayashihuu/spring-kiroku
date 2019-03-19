package com.syun.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @program: spring5-demo01
 * @author: syun
 * @create: 2019-03-19 21:31
 */
@Controller
@RequestMapping
public class HelloController {

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping("/")
    public String index(){
        return "hello world";
    }

}
