package com.threadlocalstorage;

import java.util.ArrayList;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		TransactionManager tm = new TransactionManager();
		
		List<Thread> workers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			workers.add(new Thread(tm, "tr." + i));
		}

		workers.forEach(Thread::start);

		workers.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		tm.printId();
		System.out.println("=== Done ===");
	}

}
