package com.doublecheckedlocking;

public class SimpleComponent extends Thread {
	@Override
	public void run() {
		int i = 0;
		while (i < 100) {
			i++;
			Logger logger = Logger.getInstance();
			// Logger logger = Logger.getInstanceClassicWay();
			logger.Log("Info", "Demo of double checked locking!");
		}
	}
}
