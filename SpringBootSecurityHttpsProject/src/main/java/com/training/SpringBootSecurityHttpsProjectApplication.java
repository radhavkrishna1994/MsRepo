package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootSecurityHttpsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityHttpsProjectApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello! This is SSL enabled";
	}

}
