package com.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.starter.Starter;

public class ProcessManager {
	private final static Logger log = Logger.getLogger(ProcessManager.class.getSimpleName());
	private List<Process> processes = new ArrayList<Process>();
	private List<ProcessMonitor> monitors = new ArrayList<ProcessMonitor>();

	public synchronized void start(com.config.Process process) {
		try {
			log.info("starting process" + process.getId());
			 exec(process);
		} catch (IOException | InterruptedException e) {
			log.log(Level.SEVERE, "Error in starting the process.", e);
		}
	}

	public int exec(com.config.Process process) throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = Starter.class.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, "-ui", "IssueTracking.fxml").inheritIO();
		log.info(builder.toString());
		Process runningProcess = builder.start();
		processes.add(runningProcess);
		
		ProcessMonitor monitor = new ProcessMonitor(process.getId(), runningProcess);
		monitor.start();
		monitors.add(monitor);
		return 1;
	}

	public void killAll() {
		log.info("Killing all the processes");
		for (Process p : processes)
			p.destroy();
	}
}