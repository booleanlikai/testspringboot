package com.likai.gateway.Interceptor;

import org.springframework.web.filter.reactive.ForwardedHeaderFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class MyInterceptor extends ForwardedHeaderFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return super.filter(exchange, chain);
    }
}
