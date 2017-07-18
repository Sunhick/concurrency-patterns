package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * ExecutorServiceDemo
 * 
 * Is an interace. It's implementation is similar to Thread pool. It's concrete
 * impl. are ThreadPoolExecutor, ScheduledThreadPoolExecutor
 */
public class ExecutorServiceDemo {
	// ExecutorService executorService1 = Executors.newSingleThreadExecutor();
	// ExecutorService executorService2 = Executors.newFixedThreadPool(10);
	// ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
	private final ExecutorService service;

	public ExecutorServiceDemo() {
		service = Executors.newFixedThreadPool(10);
	}

	public void start() {
		service.execute(new ExecutorTask("Demo.Task.0"));
		service.execute(new ExecutorTask("Demo.Task.1"));
		service.execute(new ExecutorTask("Demo.Task.2"));
		service.execute(new ExecutorTask("Demo.Task.3"));
		service.execute(new ExecutorTask("Demo.Task.4"));
		
//		ScheduledExecutorService scheduledExecutorService =
//		        Executors.newScheduledThreadPool(5);
//
//		ScheduledFuture scheduledFuture =
//		    scheduledExecutorService.schedule(new Callable() {
//		        public Object call() throws Exception {
//		            System.out.println("Executed!");
//		            return "Called!";
//		        }
//		    },
//		    5,
//		    TimeUnit.SECONDS);
		
		service.shutdown();
	}
}
