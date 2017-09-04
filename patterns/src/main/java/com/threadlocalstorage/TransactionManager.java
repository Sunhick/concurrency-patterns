package com.threadlocalstorage;

import java.util.UUID;

public class TransactionManager implements Runnable {
	/**
	 * Transaction id here will be overwritten in case of multi-threaded
	 * application. We could synchronize the methods to control access, but that
	 * would defeat the purpose of multi-threading. To overcome this problem
	 * ThreadLocal storage was introduced. ThreadLocal storage will be specific to a
	 * thread and will be shared with other threads. Thereby making each thread have
	 * it's own transaction id which makes sense since we are creating multi threads
	 * to handle multiple transactions.
	 */
	// private static String transactionId;
	private static ThreadLocal<String> context = new ThreadLocal<>();

	public void startTransaction() {
		String id = UUID.randomUUID().toString();
		System.out.println("generated id:" + id);
		// Performing more complex operation here.
		safeSleep(1000);

		// set the transaction id
		// transactionId = id;

		// Threadlocal transaction id
		context.set(id);

		safeSleep(500);
		printId();
	}

	public void stopTransaction() {
		// transactionId = null;
		context.remove();
	}

	public String getTransactionId() {
		// return transactionId;
		return context.get();
	}

	public void safeSleep(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printId() {
//		System.out.println("Thread name: " + Thread.currentThread().getName());
//		System.out.println("Transaction Id: " + getTransactionId());
		System.out.println(Thread.currentThread().getName() + " [" + getTransactionId() + "]");
	}

	@Override
	public void run() {
		startTransaction();
		safeSleep(1000);
		stopTransaction();
	}
}
