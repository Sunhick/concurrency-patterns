package com.activeobject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Scheduler {
	private BlockingQueue<Runnable> tasks;
	private List<PoolThread> threads = new ArrayList<>();
	
	public Scheduler(BlockingQueue<Runnable> t, int count) {
		tasks = t;
		
		for (int i=0; i< count; i++) {
            threads.add(new PoolThread(tasks));
        }
	}
	
	public void start() {
		for (PoolThread p : threads) {
			p.start();
		}
	}
	
}