package com.syun.webfluxdemo.component;


import com.syun.webfluxdemo.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-27 23:17
 */
@Component
public class CityHandler {


    public Mono<ServerResponse>  getPerson(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, syun!"));
    }


    public Mono<ServerResponse> listPeople(ServerRequest request) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("syun", 11, "changzhou"));
        list.add(new Person("hayashi", 111, "常州"));

        Flux<Person> personFlux= Flux.create(sink -> {
            list.forEach(sink::next);
            sink.complete();
        });

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(personFlux, Person.class);
    }



}
