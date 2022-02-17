package com.training.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.classes.MultiplyOperator;
import com.training.classes.OperatorDemo;
import com.training.interfaces.Operator;


@Configuration
//@ConfigurationProperties("number")
public class MyConfiguration {

	@Value("${message}")
	private String  message;
	
	
	/*
	 * private int maximum;
	 * 
	 * public void setMaximum(int maximum) { this.maximum = maximum; } public void
	 * setMinimum(int minimum) { this.minimum = minimum; }
	 * 
	 * 
	 * private int minimum;
	 */
	
	
	
	//  public void print() { System.out.println(maximum+" "+minimum); }
	public String getMessage() { return message; }
	  
	  
	  @Bean public Operator getOperator() { return new MultiplyOperator(); }
	 
	
	
	  @Bean public OperatorDemo getOperatorDemo() { return new OperatorDemo(); }
	 
	
}
