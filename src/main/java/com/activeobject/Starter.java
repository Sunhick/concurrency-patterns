package com.activeobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Starter {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Active object design pattern");
		try	(MathProxy proxy = new MathProxy()) {
			//System.out.println("main. id = " + Thread.currentThread().getId());
			Stream<Future> fs = Arrays.asList(
					proxy.add(100, 100),
					proxy.add(100, 200),
					proxy.add(100, 300),
					proxy.add(100, 400),
					proxy.add(100, 500),
					proxy.add(100, 600),
					proxy.add(100, 700)
			).stream();
			
			// more parallel ops here.
			Thread.sleep(600);
			List<Thread> workers = new ArrayList<Thread>();
			
			// Java8 Stream feature
			fs.parallel().forEach((f) -> {
				// System.out.println("forEach. id = " + Thread.currentThread().getId());
				Thread t = new Thread(() -> f.show());
				t.start();
				workers.add(t);
			});
			
			for (Thread t : workers) {
				t.join();
			}
		}
		
		System.out.println("==== Done ====");
	}

}
