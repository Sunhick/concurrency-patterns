package com.monitorobject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deadlocks.DeadlockDetection;
import com.guardedsuspension.Consumer;
import com.guardedsuspension.IntegerProvider;
import com.guardedsuspension.Producer;
import com.guardedsuspension.Provider;
import com.guardedsuspension.Queue;
import com.guardedsuspension.StringProvider;

public class Starter {

	public static void main(String[] args) {
		DeadlockDetection deadlockDetector = new DeadlockDetection();
		deadlockDetector.start();
		
		int max = 20;
		
		Provider<Integer> intProvider = new IntegerProvider();
		Provider<String> strProvider = new StringProvider();
		Provider<Integer> printIndexProvider = new CountedIntegerProvider();
		
		Queue<String> queue = new WaitQueue<>();
		
		List<Thread> workers = new ArrayList<>(
				Arrays.asList(
						new Thread(new Producer<>(queue, max, strProvider), Producer.class.getName()),
						new Thread(new Consumer<>(queue, max), Consumer.class.getName())
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
		
		if (deadlockDetector.isAlive()) {
			// stop deadlock detector thread forcefully.
			deadlockDetector.interrupt();
		}
		
		try {
			// finally wait for deadlock detector thread to 
			// stop/ whatever at this point since we called force terminate.
			deadlockDetector.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("=== Done ===");
	}

}
