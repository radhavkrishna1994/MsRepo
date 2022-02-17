package com.training.classes;

import org.springframework.stereotype.Component;

import com.training.interfaces.Operator;


public class AddOperator implements Operator {

	@Override
	public int operate(int x, int y) {
		
		return x+y;
	}

}
