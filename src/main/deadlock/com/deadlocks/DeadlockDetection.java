package com.deadlocks;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DeadlockDetection extends Thread {

	public DeadlockDetection() {
		setName("DeadlockDetection.Thread.2");
	}

	@Override
	public void run() {
		super.run();

		System.out.println("Running deadlock detection on " + Thread.currentThread().getName() + " thread.");
		List<String> names = Arrays.asList(ThreadNames.names);
		
		while (!isInterrupted()) {
			ThreadMXBean bean = ManagementFactory.getThreadMXBean();
			long[] ids = bean.findDeadlockedThreads();

			if (ids != null) {
				System.out.println("Error! Deadlock detected");
				ThreadInfo[] threadInfos = bean.getThreadInfo(ids);
				Arrays.asList(threadInfos).forEach(e -> {
					StackTraceElement[] stack = e.getStackTrace();
					System.out.println("Stack trace: " + stack.toString());
				});
				
				Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
				Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
				
				for (Thread t : threadArray) {
					String tname = t.getName();
					if (names.contains(tname)) {
						System.out.println("Killing the thread : " + tname);
						t.interrupt();
					}
				}
				
				// figure out graceful termination here.
				System.exit(0);
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("deadlock detection thread stopped forcefully.");
				return;
				// e.printStackTrace();
			}
		}
	}
}