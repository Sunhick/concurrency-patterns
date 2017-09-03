package com.pattern.specification;

import java.util.Random;

public class IntegerProvider implements Provider<Integer> {
	
	private int counter = 0;
	
	@Override
	public Integer provide() {
		return counter++;
	}
	
}