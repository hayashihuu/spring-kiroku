package com.syun.webfluxdemo.router;

import com.syun.webfluxdemo.component.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2019-03-31 17:04
 */

@Configuration
public class TimeRouter {

    private final TimeHandler timeHandler;

    public TimeRouter(TimeHandler timeHandler) {
        this.timeHandler = timeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), req -> timeHandler.getTime(req))
                .andRoute(GET("/date"), timeHandler::getDate)  // 这种方式相对于上一行更加简洁
                .andRoute(GET("/times"), timeHandler::sendTimePerSec);  // 增加这一行
    }

}
