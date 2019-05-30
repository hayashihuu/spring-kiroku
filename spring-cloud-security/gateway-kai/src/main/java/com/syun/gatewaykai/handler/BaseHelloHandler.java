package com.syun.gatewaykai.handler;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/*
 * @description:
 * @program: spring-cloud-security
 * @author: syun
 * @create: 2019-05-06 09:55
 */
@Component
public class BaseHelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just("hello world"), String.class);
    }


}
