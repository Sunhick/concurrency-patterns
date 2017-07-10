package com.activeobject;

import java.util.Optional;

public class Math implements Operations {
	private final Scheduler sched;
	
	public Math() {
		sched = new Scheduler(5);
		sched.start();
	}
	
	public void stop() {
		sched.stop();
	}
	
	@Override
	public void addAsync(Integer x, Integer y, Future f) {
		// System.out.println("here");
		try {
			// System.out.println("add. id = " + Thread.currentThread().getId());
			sched.addTask(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						synchronized(f) {
							// System.out.println("run. id = " + Thread.currentThread().getId());
							// System.out.println("adding " + x  + " and " + y);
							Integer c = x + y;
							f.answer = Optional.of(c);
							f.notify();
							// System.out.println("Ans = "+ c);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
