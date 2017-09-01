package com.guardedsuspension;

import java.util.Random;

public class IntegerProvider implements Provider<Integer> {

	private Random random = new Random();
	
	@Override
	public Integer provide() {
		return random.nextInt();
	}

}
