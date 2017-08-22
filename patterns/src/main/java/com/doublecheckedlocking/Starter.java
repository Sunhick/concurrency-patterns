package com.doublecheckedlocking;

import java.util.ArrayList;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<SimpleComponent> jobs = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			jobs.add(new SimpleComponent());			
		}
		
		for (SimpleComponent c : jobs) {
			c.start();
		}
		
		jobs.forEach(e -> {
			try {
				e.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		System.out.println("=== Done ===");
		
		Logger.getInstance().close();
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");
	}

}
