package com.concurrent;

public class Starter {

	public static void main(String[] args) {
		// new CyclicBarrierDemo().start();
		// new ExecutorServiceDemo().start();
		new ForkJoinPoolDemo().start();
		
		System.out.println("=== Done ===");
	}

}
