package com.training.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.interfaces.Operator;

@Component
public class OperatorDemo {
	
	@Autowired
	private Operator operator; // MultiplyOperator

	
	
	public int getResult(int x,int y) 
	{
		return operator.operate(x, y);
	}

}
