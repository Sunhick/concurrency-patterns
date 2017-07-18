package com.deadlocks;

public class Task extends Thread {
	
	private Resources resources;
	
	public Task(Resources resources) {
		this.resources = resources;
		
	}
	
	@Override
	public void run() {
		super.run();
		try {
			resources.doSomething();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
