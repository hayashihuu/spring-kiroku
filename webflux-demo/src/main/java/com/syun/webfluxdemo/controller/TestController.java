package com.syun.webfluxdemo.controller;

import com.syun.webfluxdemo.entity.User;
import com.syun.webfluxdemo.service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @description: spring reactor 编程基本demo restful式
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-27 23:00
 */



@RestController
@RequestMapping("/user")
public class TestController {

    private final UserService userService;

    @Autowired
    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello world");
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    @ExceptionHandler(ResourceNotFoundException.class)
    public void notFound() {

    }

    @GetMapping("")
    public Flux<User> list() {
        return this.userService.list();
    }

    @GetMapping("/{id}")
    public Mono<User>getById(@PathVariable("id") final String id) {
        return this.userService.getById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody final User user) {
        return this.userService.createOrUpdate(user);
    }

    @PutMapping("/{id}")
    public Mono<User>  update(@PathVariable("id") final String id, @RequestBody final User user) {
        Objects.requireNonNull(user);
        user.setId(id);
        return this.userService.createOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public Mono<User>  delete(@PathVariable("id") final String id) {
        return this.userService.delete(id);
    }







}
