package com.activeobject;

import java.io.IOException;

public class MathProxy implements AsyncOperations, AutoCloseable {

	private Math math;
	
	public MathProxy() {
		math = new Math();
	}
	
	@Override
	public Future add(Integer x, Integer y) {
		Future f = new Future();
		// place a async request for add operation.
		math.addAsync(x, y, f);
		return f;
	}

	@Override
	public void close() throws IOException {
		// System.out.println("in close");
		math.stop();
	}

}
