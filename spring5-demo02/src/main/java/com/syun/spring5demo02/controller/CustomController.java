package com.syun.spring5demo02.controller;

import com.syun.spring5demo02.event.OtherCustomEvent;
import com.syun.spring5demo02.event.SampleCustomEvent;
import com.syun.spring5demo02.interceptor.LotteryInterceptor;
import com.syun.spring5demo02.listener.TimeExecutorHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

    @Autowired
    private ApplicationContext context;

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


// - --------------------------------测试 事件 监视器

    @RequestMapping(value = "/testEvent")
    @ResponseBody
    public String testEvent() {
        long start = System.currentTimeMillis();
//        发送事件
        context.publishEvent(new SampleCustomEvent(context));
        long end = System.currentTimeMillis();
        int testTime = (int)((end - start) / 1000);
        ((TimeExecutorHolder) context.getBean("timeExecutorHolder")).addNewTime("testController", new Integer(testTime));
        return "success";
    }


    @RequestMapping(value = "/testOtherEvent")
    @ResponseBody
    public String testOtherEvent() {
//        发送时间
        context.publishEvent(new OtherCustomEvent(context));
        return "success";
    }

}
