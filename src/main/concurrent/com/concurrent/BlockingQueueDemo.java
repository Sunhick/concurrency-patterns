package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * BlockingQueueDemo
 * 
 * BlockingQueue is an interface. It's core implementations are,
 * 		ArrayBlockingQueue
 * 		DelayQueue
 * 		LinkedBlockingQueue
 * 		PriorityBlockingQueue
 * 		SynchronousQueue 
 */
public class BlockingQueueDemo {

	private BlockingQueue<Integer> queue;
	@SuppressWarnings("unused")
	private BlockingQueue<DelayElement> queue2;
	@SuppressWarnings("unused")
	private BlockingQueue<String> queue3;
	
	public BlockingQueueDemo() {
		start();
	}

	private void start()  {
	    queue = new ArrayBlockingQueue<>(1024);
	    queue2 = new DelayQueue<DelayElement>();
	    queue3 = new LinkedBlockingQueue<String>(1024);
		try {
			queue.put(34);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public class DelayElement implements Delayed {

		@Override
		public int compareTo(Delayed o) {
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return 0;
		}
		
	}
}
