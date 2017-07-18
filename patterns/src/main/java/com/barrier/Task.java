package com.barrier;

public class Task {

	private String file;

	public Task(String file) {
		this.file = file;
	}

	public void execute() {
		readFile();
		processFile();
		System.out.println("Done with " + file + " file.");
	}

	private void processFile() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void readFile() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}