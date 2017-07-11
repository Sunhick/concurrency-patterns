package com.deadlocks;

public class Resources {
	private Object writer = new Object();
	private Object file = new Object();
	
	public void doSomething() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " trying to acquiring lock on " + " writer.");
		synchronized(writer) {
			System.out.println(Thread.currentThread().getName() + " acquired lock on " + " writer.");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + " trying to acquiring lock on " + " file.");
			synchronized(file) {
				System.out.println(Thread.currentThread().getName() + " acquired lock on " + " file.");
				Thread.sleep(500);
			}
		}
	}
	
	public void doSomethingElse() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " trying to acquiring lock on " + " file.");
		synchronized(file) {
			System.out.println(Thread.currentThread().getName() + " acquired lock on " + " file.");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + " trying to acquiring lock on " + " writer.");
			synchronized(writer) {
				System.out.println(Thread.currentThread().getName() + " acquired lock on " + " writer.");
				Thread.sleep(500);
			}
		}
	}
	
	public void noLockCall() throws InterruptedException {
		Thread.sleep(400);
	}
}