package com.doublecheckedlocking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements AutoCloseable {

	private FileWriter log;
	private static Logger singleton;
	
	public static Logger getInstance() {
		// Making this method synchronized will solve the problem 
		// but makes it slower by introducing sequential access 
		// even after the instance is created.
		
		// Fix: Double checked locking.
		// Double checked locking. So that once instance is created
		// all the threads can call this method unsynchronized without
		// having to access singleton in a sequential fashion. This 
		// will improve the performance of threading and the application
		// in overall.
		if (singleton == null) {
			synchronized(Logger.class) {
				if (singleton == null) {
					singleton = new Logger(new File("log.txt"));
				}
			}
		}
		
		return singleton;
	}
	
	public synchronized static Logger getInstanceClassicWay() {
		if (singleton == null) {
			singleton = new Logger(new File("classic.txt"));
		}
		return singleton;
	}
	
	private Logger(File file) {
		try {
			log = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			log.flush();
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void Log(String type, String message) {
		try {
			log.write(type + " | " + message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
