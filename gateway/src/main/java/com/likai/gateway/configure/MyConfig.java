package com.likai.gateway.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Configuration
@EnableWebFlux
public class MyConfig implements WebFluxConfigurer {
//    @Override
//    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
//        configurer.defaultCodecs().enableLoggingRequestDetails(true);
//        Consumer<ClientCodecConfigurer> consumer = configur -> configur
//                .defaultCodecs()
//                .enableLoggingRequestDetails(true);
//        WebClient webClient = WebClient.builder()
//                .exchangeStrategies(ExchangeStrategies.builder().codecs(consumer).build())
//                .build();
//    }
}
