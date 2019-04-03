package com.syun.spring5demo02;

import com.syun.spring5demo02.interceptor.LotteryInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @program: spring5-demo02
 * @author: syun
 * @create: 2019-04-03 21:37
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("add interceptores");
        registry.addInterceptor(new LotteryInterceptor()).addPathPatterns("/**");
    }
}
