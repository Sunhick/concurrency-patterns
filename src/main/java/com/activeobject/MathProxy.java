package com.activeobject;

public class MathProxy implements AsyncOperations {

	private Math math;
	
	public MathProxy() {
		math = new Math();
	}
	@Override
	public Future add(Integer x, Integer y) {
		Future f = new Future();
		// place a async request for add operation.
		math.add(x, y, f);
		return f;
	}

}
