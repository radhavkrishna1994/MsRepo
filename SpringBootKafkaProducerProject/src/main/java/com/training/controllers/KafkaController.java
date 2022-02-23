package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Training;
import com.training.services.KafkaMessageService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaMessageService kafkaMessageService;
	
	@GetMapping("/publish/{message}")
	public void publish(@PathVariable("message") String message)
	{
		kafkaMessageService.publish(message);
	}
	
	@PostMapping("/publish")
	public void publish(@RequestBody Training training)
	{
		kafkaMessageService.publish(training);
	}
}




