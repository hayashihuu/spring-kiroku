package com.syun.spring5demo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Spring5Demo02Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring5Demo02Application.class, args);
    }

}
