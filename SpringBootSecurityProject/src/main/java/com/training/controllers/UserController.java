package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping({"/","/hello"})
	public String sayHello()
	{
		return "Hi ! Welcome to Spring Security";
	}
	
	@GetMapping({"/user/hello"})
	public String sayHelloUser()
	{
		return "Hi ! Welcome to Spring Security!! User";
	}
	
	@GetMapping({"/admin/hello"})
	public String sayHelloAdmin()
	{
		return "Hi ! Welcome to Spring Security!! Admin";
	}
}
