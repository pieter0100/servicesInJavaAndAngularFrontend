package com.architekturyusluginternetowych.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("departments", r -> r
						.host("localhost:8080")
						.and()
						.path("/departments", "/departments/**")
						.uri("http://localhost:8081"))
				.route("scientists", r -> r
						.host("localhost:8080")
						.and()
						.path("/scientists", "/scientists/**")
						.uri("http://localhost:8082"))
				.build();
	}
}
