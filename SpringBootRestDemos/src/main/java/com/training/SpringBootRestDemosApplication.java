package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.classes.OperatorDemo;
import com.training.config.MyConfiguration;
import com.training.interfaces.TestProfile;

@SpringBootApplication
public class SpringBootRestDemosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestDemosApplication.class, args);
	}

	@Autowired
	private OperatorDemo operatorDemo;
	
	@Autowired
	private MyConfiguration config;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("result:"+operatorDemo.getResult(12, 10));
		System.out.println("Message:"+config.getMessage());
		
		//config.print();
		profile.process();
	}
	
	@Autowired
	private TestProfile profile;
	

	
}
