package com.activeobject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starter {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("Active object design pattern");
		try	(MathProxy proxy = new MathProxy()) {
			//System.out.println("main. id = " + Thread.currentThread().getId());
			List<Future> fs = Arrays.asList(
					proxy.add(100, 100),
					proxy.add(100, 200),
					proxy.add(100, 300),
					proxy.add(100, 400),
					proxy.add(100, 500),
					proxy.add(100, 600),
					proxy.add(100, 700)
			);
			
			// more parallel ops here.
			Thread.sleep(600);
			
			List<Thread> workers = new ArrayList();
			
			for (Future f : fs) {
				// I dont wish to track teh state of thread. so just start and leave it.
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						f.show();
					}
				});
				t.start();
				workers.add(t);
			}
			
			for (Thread t : workers) {
				t.join();
			}
		}
		
		System.out.println("==== Done ====");
	}

}
