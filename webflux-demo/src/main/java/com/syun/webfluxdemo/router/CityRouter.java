package com.syun.webfluxdemo.router;

import com.syun.webfluxdemo.component.CalculatorHandler;
import com.syun.webfluxdemo.component.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;





/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-27 23:15
 */
@Configuration
public class CityRouter {


    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler) {

        return route(RequestPredicates.GET("/helloWorld")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), cityHandler::getPerson)
                .andRoute(RequestPredicates.GET("/persons")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), cityHandler::listPeople);
    }


    @Bean
    @Autowired
    public RouterFunction<ServerResponse>routerFunction(final CalculatorHandler calculatorHandler) {

        return RouterFunctions.route(RequestPredicates.path("/calculator"), request ->
                request.queryParam("operator").map(operator ->
                        Mono.justOrEmpty(ReflectionUtils.findMethod(CalculatorHandler.class, operator, ServerRequest.class))
                                .flatMap(method -> (Mono<ServerResponse>) ReflectionUtils.invokeMethod(method, calculatorHandler, request))
                                .switchIfEmpty(ServerResponse.badRequest().build())
                                .onErrorResume(ex -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build()))
                        .orElse(ServerResponse.badRequest().build()));
    }











}
