package com.barrier;

import java.io.IOException;
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Barrier concurrency pattern.");
		
		List<Task> tasks = Arrays.asList(
				new Task("doc-1"), 
				new Task("doc-2"), 
				new Task("doc-3"));
		
		System.out.println("Task count : " + tasks.size());
		long startTime = System.currentTimeMillis();
		
		// Without concurrency
		// tasks.Stream().forEach(t -> t.execute());
		
		tasks.parallelStream().forEach(t -> t.execute());
//		Implementation of parallel stream without streams.
//		List<Thread> ths = new ArrayList<Thread>();
//		tasks.stream().forEach(t -> {
//			Thread n = new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					t.execute();
//				}
//			});
//			ths.add(n);
//			n.start();
//		});
//		
//		for (Thread t : ths) {
//			t.join();
//		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("That took " + (endTime - startTime)/1000 + " secs");
		
		System.out.println("==== Done ====");
	}

}