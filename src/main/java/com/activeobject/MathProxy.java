package com.activeobject;

import java.io.IOException;

public class MathProxy implements AsyncOperations, AutoCloseable {

	private Math math;
	
	public MathProxy() {
		math = new Math();
	}
	
	@Override
	public Future add(Integer x, Integer y) {
		MathArgs args = new MathArgs();
		args.putValue(MathArgs._0, x);
		args.putValue(MathArgs._1, y);
		
		Future ftr = new Future(args);
		
		// place a async request for add operation.
		math.addAsync(args, ftr);
		return ftr;
	}

	@Override
	public void close() throws IOException {
		// System.out.println("in close");
		math.stop();
	}

}
