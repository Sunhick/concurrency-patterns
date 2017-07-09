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
	
	@Override
	public void add(Integer x, Integer y, Future f) {
		System.out.println("here");
		try {
			dispatchQueue.put( new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
						System.out.println("adding " + x  + " and " + y);
						Integer c = x + y;
						f.answer = Optional.of(c);
						System.out.println("Ans = "+ c);
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
