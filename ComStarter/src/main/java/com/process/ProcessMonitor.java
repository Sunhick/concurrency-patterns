package com.process;

import java.util.logging.Logger;

public class ProcessMonitor extends Thread {
	private final static Logger log = Logger.getLogger(ProcessMonitor.class.getSimpleName());
	private String moniker;
	private Process process;
	private ProcessKilledListener listener;
	
	public ProcessMonitor(String name, Process p) {
		moniker = name;
		process = p;
	}
	
	@Override
	public void run() {
		try {
			process.waitFor();
			log.info("Proces with name: " + moniker + " exited.");
			listener.onProcessKilled(moniker);
		} catch (InterruptedException e) {
			log.warning("Process with name:" + moniker + " interrupted.");
		}
	}

	public void onProcessKilledListener(ProcessKilledListener listener) {
		this.listener = listener;
	}
}
