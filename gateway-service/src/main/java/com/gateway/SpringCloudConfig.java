package com.gateway;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableDiscoveryClient
@CrossOrigin(origins = "*")
public class SpringCloudConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

		System.out.println("############# Cal Api Get Way ###############");

		return builder.routes()
				.route(r -> r.path("/api/grade/**")
						.filters(f -> f.addRequestHeader("Access-Control-Allow-Origin", "*")
								.addRequestHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
								.addRequestHeader("Access-Control-Allow-Headers", "first-request-header")
								.addRequestHeader("Access-Control-Max-Age", "Authorization, Content-Type")
								.addResponseHeader("first-response", "3600"))
						.uri("http://localhost:8082/").id("grade-service-api"))

				.route(r -> r.path("/api/employee/**").uri("http://localhost:8081/").id("employee-service-api"))

				.route(r -> r.path("/api/department/**").uri("http://localhost:8082/").id("employee-service-api"))
				
				.build();
	}

}