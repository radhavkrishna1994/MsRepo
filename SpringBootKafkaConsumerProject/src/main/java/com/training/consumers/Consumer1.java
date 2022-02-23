package com.training.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
	
	@KafkaListener(topics = {"training_topic1"},groupId = "test-consumer-group")
	public void receiveMessage(String message)
	{
		System.out.println("Received message:"+message);
	}

}
