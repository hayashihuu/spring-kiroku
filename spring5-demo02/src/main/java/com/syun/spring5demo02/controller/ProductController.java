package com.syun.spring5demo02.controller;

import com.syun.spring5demo02.synchronous.NotifMailDispatchEvent;
import com.syun.spring5demo02.synchronous.ProductChangeFailureEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 异步事件
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-13 20:22
 */
@RestController
public class ProductController {

    @Autowired
    private ApplicationContext context;


    @GetMapping("/products/change-failure")
    public String  test(){
        try {
            System.out.println("I'm modifying the product but a NullPointerException will be thrown");
            String name = null;
            if (name.isEmpty()) {
                // show error message here
                throw new RuntimeException("NullPointerException");
            }
        } catch (Exception e) {
            context.publishEvent(new ProductChangeFailureEvent(context));
        }
        return "success";
    }


    @GetMapping(value = "/products/change-success")
    public String changeSuccess() {
        System.out.println("Product was correctly changed");
        context.publishEvent(new NotifMailDispatchEvent(context));
        return "success";
    }




}
