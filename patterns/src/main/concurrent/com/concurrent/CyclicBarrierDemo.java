package com.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * CyclicBarrier
 */
public class CyclicBarrierDemo {

	private Runnable action = new Runnable() {

		@Override
		public void run() {
			System.out.println("Barrier action executed. Thread : " + Thread.currentThread().getName());
		}
	};

	// barrier action is optional
	private CyclicBarrier barrier = new CyclicBarrier(2, action);

	public void start() {
		BarrierRunnable r1 = new BarrierRunnable(barrier);
		BarrierRunnable r2 = new BarrierRunnable(barrier);

		List<Thread> ts = Arrays.asList(new Thread(r1), new Thread(r2));
		ts.forEach(Thread::start);
		
		ts.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}