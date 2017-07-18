package com.balking;

import java.util.ArrayList;
import java.util.List;

public class Starter {

	public static void main(String[] args) {
		Car ferrari = new Car();
		List<Thread> t = new ArrayList<>();
		t.add(new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ferrari.Stop();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}));

		t.add(new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ferrari.Start();
					Thread.sleep(1000);
					ferrari.Accelerate();
					ferrari.Accelerate();
					Thread.sleep(1000);
					ferrari.Brake();
					Thread.sleep(1000);
					ferrari.Stop();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}));
		
		t.stream().forEach(e -> e.start());
		
		for (Thread e : t) {
			try {
				e.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}
