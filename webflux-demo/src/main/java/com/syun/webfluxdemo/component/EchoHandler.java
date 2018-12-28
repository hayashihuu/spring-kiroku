package com.syun.webfluxdemo.component;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @program: webflux-demo
 * @author: syun
 * @create: 2018-12-28 16:46
 */
@Component
public class EchoHandler implements WebSocketHandler {


    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {

        return webSocketSession.send(
                webSocketSession.receive()
                        .map(msg -> webSocketSession.textMessage("ECHO ->" + msg.getPayloadAsText()))
        );
    }
}
