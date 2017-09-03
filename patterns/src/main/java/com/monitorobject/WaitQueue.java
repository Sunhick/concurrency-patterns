package com.monitorobject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.guardedsuspension.Queue;

/**
 * Wait Queue is a thread safe implementation of queues.
 * This class demonstrates the use of monitors in java
 * and also condition variables.
 *
 */
public class WaitQueue<T> implements Queue<T> {
	
	private final static int MAX_COUNT = 10;
	private Object[] queue;
	private int count;
	private Lock lock;
	private Condition freeSpot;
	private Condition elemAvailable;
	
	WaitQueue() {
		queue = new Object[MAX_COUNT];
		count = 0;
		lock = new ReentrantLock();
		freeSpot = lock.newCondition();
		elemAvailable = lock.newCondition();
	}

	@Override
	public void put(T element) {
		lock.lock();
		while (isFull()) {
			try {
				System.out.println("waiting on freeSpot");
				// Java wait() and await() inherently releases
				// lock. Also you have to acquire lock before
				// you can call wait / await/ signal on the 
				// object being locked. otherwise you will get
				// Illegal monitor exception.
				freeSpot.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("signal on freeSpot. " + count);
		// space available add the element.
		queue[count++] = element;
		elemAvailable.signal();
		lock.unlock();
	}

	@Override
	public T get() {
		lock.lock();
		while(isEmpty()) {
			try {
				System.out.println("waiting on elemAvailable");
				elemAvailable.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("signal on elemAvailable. " + count);
		// Atleast one element is available in the queue.
		// Let's dequeue that.
		T element = (T) queue[--count];
		freeSpot.signal();
		lock.unlock();
		return element;
	}

	@Override
	public synchronized boolean isEmpty() {
		return count == 0;
	}

	@Override
	public synchronized boolean isFull() {
		return count == MAX_COUNT;
	}
}
