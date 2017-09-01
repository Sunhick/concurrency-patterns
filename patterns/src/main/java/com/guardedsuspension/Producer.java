package com.guardedsuspension;

public class Producer<T> implements Runnable {

	private Queue<T> queue;
	private int max;

	Producer(Queue<T> queue, int max) {
		this.queue = queue;
		this.max = max;
	}

	@Override
	public void run() {
		for (int i = 0; i < max; i++) {
			// This producer know in advance that object types are
			// integers. One good way to prevent that is to inject
			// a object / element provider factory.
			T element = (T) new Integer(i);
			queue.put(element);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
