package com.guardedsuspension;

public class GuardedQueue<T extends Object> implements Queue<T> {

	// Java doesn't support creating an array of generic.
	// So, T[] queue; is invalid in java parley. I will
	// create an array of Object and do the type casting.
	private Object[] queue;
	private final static int MAX = 5;
	private int count;

	public GuardedQueue() {
		queue = new Object[MAX];
		count = 0;
	}

	@Override
	public synchronized void put(T element) {
		try {
			// guard precondition.
			while (isFull()) {
				System.out.println("put -- wait");
				wait();
			}
			
			queue[count++] = element;
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized T get() {
		T element = null;
		try {
			// guard precondition.
			while (isEmpty()) {
				System.out.println("get -- wait");
				wait();
			}
			
			element = (T)queue[--count];
			notifyAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return element;
	}

	@Override
	public synchronized boolean isEmpty() {
		return count == 0;
	}

	@Override
	public synchronized boolean isFull() {
		return count + 1 == MAX;
	}
}
