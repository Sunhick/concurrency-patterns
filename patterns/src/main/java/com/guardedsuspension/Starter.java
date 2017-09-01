package com.guardedsuspension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		int max = 20;
		
		Provider<Integer> intProvider = new IntegerProvider();
		Provider<String> strProvider = new StringProvider();
		
		Queue<String> queue = new GuardedQueue<>();
		
		List<Thread> workers = new ArrayList<>(
				Arrays.asList(
						new Thread(new Producer<>(queue, max, strProvider)),
						new Thread(new Consumer<>(queue, max))
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
