package com.balking;

public class Car {
	private Status state;
	private int speed;
	private Object lock = new Object();
	
	public Car() {
		state = Status.Stop;
		speed = 0;
	}
	
	public void Start() throws InterruptedException {
		if (state == Status.Stop) {
			System.out.println("Error! (Balking) car already started.");
			return;
		}
		synchronized (lock) {
			Thread.sleep(1000);
			state = Status.Start;
			speed = 0;
			System.out.println("car started.");
		}
	}
	
	public void Stop() throws InterruptedException {
		if (state != Status.Stop) {
			System.out.println("Error! (Balking) car not started yet.");
			return;
		}
		synchronized (lock) {
			Thread.sleep(1000);
			state = Status.Stop;
			speed = 0;
			System.out.println("car stopped.");
		}
	}
	
	public void Accelerate() throws InterruptedException {
		if (state == Status.Stop) {
			System.out.println("Error! (Balking) start the car first.");
			return;
		}
		synchronized (lock) {
			Thread.sleep(1000);
			state = Status.Accelerate;
			speed += 10;
			System.out.println("car accelerated.");
		}
	}
	
	public void Brake() throws InterruptedException {
		if (state == Status.Stop || speed <= 0) {
			System.out.println("Error! (Balking) car already stopped.");
			return;
		}
		
		synchronized (lock) {
			Thread.sleep(1000);
			state = Status.Brake;
			speed -= 10;
			System.out.println("Applied brake.");
		}
	}
}