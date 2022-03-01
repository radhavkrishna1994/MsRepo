package com.training.controllers;


import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.User;
import com.training.services.UserService;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveUserController {
	
	@GetMapping(value="/getstream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Integer> getStream()
	{
		return Flux.just(4,3,2,1)
				.delayElements(Duration.ofSeconds(2))
				.log();
	}
	
	@Autowired
	private UserService userService ;
	
	@GetMapping("/getusers")
	public List<User> getUsers()
	{
		return userService.getUsers();
	}
	
	@GetMapping(value="/getusersstream",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersStream()
	{
		return userService.getUsersStream();
	}

}
