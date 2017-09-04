package com.activeobject;

import java.util.Optional;

import com.scheduler.Scheduler;

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
	public void addAsync(MathArgs args, Future ftr) {
		// System.out.println("here");
		try {
			// System.out.println("add. id = " + Thread.currentThread().getId());
			sched.addTask(() -> {
					try {
						Thread.sleep(3000);
						synchronized(ftr) {
							// System.out.println("run. id = " + Thread.currentThread().getId());
							// System.out.println("adding " + x  + " and " + y);
							Integer x = args.getValue(MathArgs._0);
							Integer y = args.getValue(MathArgs._1);
							Integer c = x + y;
							ftr.answer = Optional.of(c);
							ftr.notify();
							// System.out.println("Ans = "+ c);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
