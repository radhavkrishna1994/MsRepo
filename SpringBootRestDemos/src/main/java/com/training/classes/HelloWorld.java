package com.training.classes;

public class HelloWorld {

	private String message="This is a message";
	
	/*
	 * public HelloWorld(String message) { this.message=message; }
	 */
	
	public void setMessage(String message)
	{
		this.message=message;
	}
		
	public String sayHello()
	{
		return message;
	}
}
