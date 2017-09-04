package com.scheduler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.activeobject.Task;
import com.threadpool.PoolThread;

public class Scheduler {
	private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();
	private List<PoolThread> threads = new ArrayList<>();
	private Object lock = new Object();
	
	public Scheduler(int count) {
		for (int i=0; i< count; i++) {
            threads.add(new PoolThread(tasks));
        }
	}
	
	public void stop() {
		synchronized (lock) {
			for (PoolThread p : threads) {
				p.doStop();
			}	
		}
	}
	
	public void start() {
		synchronized(lock) {
			for (PoolThread p : threads) {
				p.start();
			}
		}
	}

	public void addTask(Task task) throws InterruptedException {
		synchronized(lock) {
			tasks.put(new Runnable() {
				
				@Override
				public void run() {
					task.invoke();
				}
			});
		}
	}
	
}