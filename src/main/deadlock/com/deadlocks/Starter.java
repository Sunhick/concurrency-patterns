package com.deadlocks;

import java.util.Arrays;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		// install deadlock detection service
		DeadlockDetection deadlockDetector = new DeadlockDetection();
		deadlockDetector.start();
		
		Resources resources = new Resources();
		List<Thread> ts = Arrays.asList(new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					resources.doSomething();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}), new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					resources.doSomethingElse();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}));
		
		for (int i = 0; i < ThreadNames.names.length; i++) {
			ts.get(i).setName(ThreadNames.names[i]);
		}
		
		ts.stream().forEach(Thread::start);
		ts.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println("=== Done ===");
	}

}
