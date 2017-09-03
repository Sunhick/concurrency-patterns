package com.monitorobject;

import java.util.Random;

import com.guardedsuspension.Provider;

public class CountedIntegerProvider implements Provider<Integer> {

	private int index = 0;
	private Random random = new Random();
	
	@Override
	public Integer provide() {
		index++;
		Integer value = random.nextInt();
		// System.out.println("Providing value = " + value + " count: " + index);
		return value;
	}

}
