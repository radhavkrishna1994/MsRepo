package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.OperatorDemo;

public class App1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans1.xml");
		OperatorDemo demo = (OperatorDemo)context.getBean("opdemo");
		
		System.out.println("Result:"+demo.getResult(12, 23));
		System.out.println(demo.hashCode());
		
		OperatorDemo demo1 = (OperatorDemo)context.getBean("opdemo"); // singleton
		System.out.println(demo1.hashCode());
		
		
	}

}
