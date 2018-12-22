package com.syun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
    }


    @PostMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        System.out.println(name);
        return "hello" + name;
    }

}

