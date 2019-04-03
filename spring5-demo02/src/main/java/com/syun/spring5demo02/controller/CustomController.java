package com.syun.spring5demo02.controller;

import com.syun.spring5demo02.interceptor.LotteryInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-03 20:52
 */
@Slf4j
@RequestMapping("/custom")
@Controller
public class CustomController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String customGet(){
        return "info info ";
    }



    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(HttpServletRequest request) {
        log.debug("Controller asks, are you a lottery winner ?     "+request.getSession().getAttribute(LotteryInterceptor.ATTR_NAME));
        return "test";
    }

}
