package com.activeobject;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Math implements Operations {

	private final BlockingQueue<Runnable> dispatchQueue;
	private final Scheduler sched;
	
	public Math() {
		dispatchQueue = new LinkedBlockingQueue<>();
		sched = new Scheduler(dispatchQueue, 5);
		sched.start();
	}
	
	public void stop() {
		sched.stop();
	}
	
	@Override
	public void add(Integer x, Integer y, Future f) {
		System.out.println("here");
		try {
			// System.out.println("add. id = " + Thread.currentThread().getId());
			dispatchQueue.put(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						synchronized(f) {
							// System.out.println("run. id = " + Thread.currentThread().getId());
							System.out.println("adding " + x  + " and " + y);
							Integer c = x + y;
							f.answer = Optional.of(c);
							f.notify();
							System.out.println("Ans = "+ c);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
