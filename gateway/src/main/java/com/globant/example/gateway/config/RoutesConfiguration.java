package com.globant.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes().
                route(p -> p
                        .path("/employees")
                        .uri("http://service-a:8080/"))
                .route(p -> p
                        .path("/addresses")
                        .uri("http://service-b:8080/"))
                .route(p -> p
                        .path("/loans")
                        .filters(f -> f.circuitBreaker(c -> c.setFallbackUri("forward:/inCaseOfFailureUseThis")))
                        .uri("http://service-c:8080"))
                .build();
    }

}
