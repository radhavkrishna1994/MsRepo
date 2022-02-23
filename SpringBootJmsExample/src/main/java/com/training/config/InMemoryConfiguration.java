package com.training.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class InMemoryConfiguration {
	
	@Bean
	public ActiveMQQueue getActiveMq()
	{
		return new ActiveMQQueue("test-inmemory-queue");
	}

}
