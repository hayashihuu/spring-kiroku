package com.syun.webfluxdemo.controller;

import com.syun.webfluxdemo.entity.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2019-04-08 22:38
 */
@RestController
public class CoffeeController {

    private final ReactiveRedisOperations<String, Coffee> coffeeOps;


    @Autowired
    public CoffeeController(ReactiveRedisOperations<String, Coffee> coffeeOps) {
        this.coffeeOps = coffeeOps;
    }

    @GetMapping("/coffees")
    public Flux<Coffee> all(){
        return coffeeOps.keys("*")
                .flatMap(coffeeOps.opsForValue()::get);
    }


}
