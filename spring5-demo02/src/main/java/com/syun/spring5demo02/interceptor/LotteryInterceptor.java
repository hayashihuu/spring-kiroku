package com.syun.spring5demo02.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @description: 自定义处理程序拦截器
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-03 21:31
 */
@Slf4j
public class LotteryInterceptor implements HandlerInterceptor {
    public static final String ATTR_NAME = "lottery_winner";


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        log.info("[LotteryInterceptor] afterCompletion");

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) throws Exception {
        log.info("[LotteryInterceptor] postHandle");

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("[LotteryInterceptor] preHandle");
        if (request.getSession().getAttribute(ATTR_NAME) == null) {
            Random random = new Random();
            int i = random.nextInt(10);
            request.getSession().setAttribute(ATTR_NAME, i%2 == 0);
        }
        return true;
    }

}
