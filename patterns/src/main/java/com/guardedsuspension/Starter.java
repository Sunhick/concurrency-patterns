package com.guardedsuspension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		int max = 20;
		
		Queue<Integer> queue = new GuardedQueue<>();
		List<Thread> workers = new ArrayList<>(
				Arrays.asList(
						new Thread(new Producer<Integer>(queue, max)),
						new Thread(new Consumer<Integer>(queue, max))
						)
				);
		
		workers.forEach(t -> t.start());
		workers.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println("=== Done ===");
	}
}
