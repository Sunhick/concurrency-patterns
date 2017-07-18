package com.concurrent;

public class ExecutorTask implements Runnable {

	private String name = "Task.name.0";
	
	public ExecutorTask(String n) {
		name = n;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(500);
			System.out.println("Task " + name + " . Thread: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}