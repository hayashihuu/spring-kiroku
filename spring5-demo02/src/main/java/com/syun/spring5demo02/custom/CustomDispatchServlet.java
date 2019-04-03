package com.syun.spring5demo02.custom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-03 20:12
 */
@Slf4j
@Component
public class CustomDispatchServlet extends FrameworkServlet {


    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("[CustomDispatcherServlet] I got the request !");
    }
}
