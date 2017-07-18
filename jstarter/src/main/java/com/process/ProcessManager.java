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

	public void start(com.config.Process process) {
		try {
			 exec(Starter.class);
		} catch (IOException | InterruptedException e) {
			log.log(Level.SEVERE, "Error in starting the process.", e);
		}
	}

	public int exec(Class clazz) throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clazz.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

		Process process = builder.start();
		processes.add(process);
		// process.waitFor();
		// return process.exitValue();
		return 1;
	}

	public void killAll() {
		for (Process p : processes)
			p.destroy();
	}
}