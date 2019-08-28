package com.likai.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Mono;

@Component
@Order(4)
public class myFilter1 implements WebHandler {

    private static final Logger logger = LoggerFactory.getLogger(myFilter1.class);

    @Override
    public Mono<Void> handle(ServerWebExchange exchange) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        String ss = serverHttpRequest.getHeaders().getFirst("resign");
        logger.error("myFilter" + ss);
        return null;
    }
}
