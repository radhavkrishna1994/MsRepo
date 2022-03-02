package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/helloservice2")
//@EnableEurekaClient
public class HelloWorldService2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldService2Application.class, args);
	}
	
	@GetMapping("/hello2")
	public String sayHello( /* @RequestHeader("request-header") String header */  )
	{
		//System.out.println(header);
		return "Hello Service 2";
	}

}
