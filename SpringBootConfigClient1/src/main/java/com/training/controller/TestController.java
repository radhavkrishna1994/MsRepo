package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.ClientConfiguration;

@RestController
public class TestController {

	@Autowired
	private ClientConfiguration config;

	@GetMapping("/getmessage")
	public String getMessage()
	{
			return config.getMessage();
	}


}
