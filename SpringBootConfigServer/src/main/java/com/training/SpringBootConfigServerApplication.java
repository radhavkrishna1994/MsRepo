package com.training;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
public class SpringBootConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigServerApplication.class, args);
	}

	@Value("${message:hello}")
	private String message;
	
	@Bean
	CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			System.out.println(message);
		};
	}
}
