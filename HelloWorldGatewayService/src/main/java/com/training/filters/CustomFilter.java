package com.training.filters;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config>
{
	public CustomFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(CustomFilter.Config config) {
		
		return (exchange, chain) -> {
			System.out.println("First pre filter");
			
			System.out.println(exchange.getRequest().getPath()); // path of the service 
			System.out.println(exchange.getRequest().getMethod()); 
			//Custom Post Filter.Suppose we can call error response handler based on error code.
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				System.out.println("First post filter");
			}));
		};
	}
	

	
	public static class Config
	{
		
	}
	
}
