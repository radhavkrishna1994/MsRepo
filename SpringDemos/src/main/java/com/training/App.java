package com.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.classes.HelloWorld;

public class App 
{
    public static void main( String[] args )
    {
      
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
    HelloWorld helloBean = (HelloWorld) context.getBean("hello");

    System.out.println(helloBean.sayHello());
    
    }
}


