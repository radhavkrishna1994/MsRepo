package com.training.classes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.training.interfaces.Operator;


public class MultiplyOperator implements Operator {

	@Override
	public int operate(int x, int y) {
		
		return x * y;
	}

}
