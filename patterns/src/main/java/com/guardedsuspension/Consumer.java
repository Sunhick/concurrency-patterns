package com.guardedsuspension;

public class Consumer<T> implements Runnable {

	private Queue<T> queue;
	private int max;
	
	Consumer(Queue<T> queue, int max) {
		this.queue = queue;
		this.max = max;
	}
	
	@Override
	public void run() {
		while(max > 0) {
			T element = queue.get();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Got: " + element.toString());
			max--;
		}
	}

}
