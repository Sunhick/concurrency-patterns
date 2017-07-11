package com.concurrent;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
	private ForkJoinPool forkJoinPool = new ForkJoinPool(10);
	
	public void start() {
		WriteToDisk fileWriter = new WriteToDisk(24);
		forkJoinPool.invoke(fileWriter);
		
		MathCompute mathOp = new MathCompute(24);
		Long val = forkJoinPool.invoke(mathOp);
		System.out.println("got output = " + val);
	}
	
}