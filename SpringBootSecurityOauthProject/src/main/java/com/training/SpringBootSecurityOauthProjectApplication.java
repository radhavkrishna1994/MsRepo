package com.training;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringBootSecurityOauthProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOauthProjectApplication.class, args);
	}

	@GetMapping("/")
	public String sayHelloOauth2(Principal principal)
	{
		
		return principal.getName()+" Welcome Oauth2 Cloud";
	}
}
