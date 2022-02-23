package com.training.services;

import javax.security.auth.callback.Callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.training.model.Training;

@Service
public class KafkaMessageService {
	
	private static final String TOPIC = "training_topic1";
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String,Training> kafkaTemplateObject;
	
	
	public void publish(String message)
	{
		ListenableFuture<SendResult<String,String>> future= kafkaTemplate.send(TOPIC, message);
		
		future.addCallback(new ListenableFutureCallback() {

			@Override
			public void onSuccess(Object result) {
			System.out.println(result.toString() + " published..");

			}
			@Override
			public void onFailure(Throwable ex) {
				
				System.out.println("Failed to publish");
			}

			
		});
		
		
		//return message + " published";
	}
	
	public void publish(Training training)
	{
		ListenableFuture<SendResult<String,Training>> future= kafkaTemplateObject.send(TOPIC, training);
		
		future.addCallback(new ListenableFutureCallback() {

			@Override
			public void onSuccess(Object result) {
			System.out.println(result + " published..");

			}
			@Override
			public void onFailure(Throwable ex) {
				
				System.out.println("Failed to publish");
			}

			
		});
		
		
		//return message + " published";
	}


}
