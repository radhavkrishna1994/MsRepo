package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
public class SpringBootConfigClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigClient1Application.class, args);
	}

}
