package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.filters.CustomFilter;

import reactor.core.publisher.Mono;

@Configuration
@SpringBootApplication
public class HelloWorldGatewayServiceApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldGatewayServiceApplication.class, args);
	}


	
	
	
	
	/*
	 * @Bean public RouteLocator myRoutes(RouteLocatorBuilder builder) { return
	 * builder.routes() .route(p -> p .path("/helloservice2/**") .filters(f ->
	 * f.addRequestHeader("request-header", " Hello World Request")
	 * .addResponseHeader("response-header","hello World response"))
	 * .uri("http://localhost:8089")) .build(); }
	 */
	 
	 


	
	
	
	
	
	  @Bean public GlobalFilter globalFilter() { return (exchange, chain) -> {
	  System.out.println("First Global filter");
	  System.out.println(exchange.getRequest().getPath()); return
	  chain.filter(exchange).then(Mono.fromRunnable(() -> {
	  System.out.println("Second Global filter"); })); }; }
	 
	 
	 


	

}
