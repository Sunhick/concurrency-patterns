package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierRunnable implements Runnable {

	private CyclicBarrier b;
	
	public BarrierRunnable(CyclicBarrier b) {
		this.b = b;
		
	}
	
	@Override
	public void run() {
		try {
			// perform some activity that doesn't require a barrier.
			Thread.sleep(1000);
			
			// wait for the other barrier thread to reach it's await point.
			b.await();
			
			System.out.println("Done waiting. Thread : " + Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}