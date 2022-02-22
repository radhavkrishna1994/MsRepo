package com.training;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class CloudOauth2ExampleApplication {

	@GetMapping("/")
	public String sayHelloOauth2(Principal principal)
	{
		
		return principal.getName()+" Welcome Oauth2 Cloud";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CloudOauth2ExampleApplication.class, args);
	}

}
