package com.process;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.inject.Inject;
import com.process.ProcessMonitor.ProcessMonitorFactory;
import com.starter.Bootstrap;

public class ProcessManager {
	private final static Logger log = Logger.getLogger(ProcessManager.class.getSimpleName());
	private List<Process> processes = new ArrayList<Process>();
	private List<ProcessMonitor> monitors = new ArrayList<ProcessMonitor>();
	private AtomicBoolean restart = new AtomicBoolean(true);
	private ProcessMonitorFactory monitorFactory;

	@Inject
	ProcessManager(ProcessMonitorFactory monitorFactory) {
		this.monitorFactory = monitorFactory;
	}

	public synchronized void start(com.config.Process process) {
		try {
			log.info("starting process" + process.getId());
			exec(process);
		} catch (IOException | InterruptedException e) {
			log.log(Level.SEVERE, "Error in starting the process.", e);
		}
	}

	public void exec(com.config.Process process) throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		log.info("classpath: " + classpath);
		String className = Bootstrap.class.getCanonicalName();

		String config = process.getPath();
		log.info("config: " + config);
		String type = process.getType().equals("frontend") ? "-frontend" : "";

		log.info("starting process " + process.getId() + " in mode:" + type);
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className, "-ui", config, type)
				.inheritIO();
		log.info(builder.toString());
		Process runningProcess = builder.start();
		processes.add(runningProcess);

		ProcessMonitor monitor = monitorFactory.createInstance(process.getId(), runningProcess);
		monitor.onProcessKilledListener(name -> {
			// clean up process data structures and then restart the killed process.
			// log.info("Running on thread: " + Thread.currentThread().getName());

			// run on main thread.
			ThreadUtils.runOnUiThread(() -> {
				// clean up process data structures and then restart the killed process.
				log.info("Running on thread: " + Thread.currentThread().getName());
				monitors.remove(monitor);
				processes.remove(runningProcess);
				try {
					if (!restart.get())
						return;
					log.info("Restarting the process:" + process.getId());
					exec(process);
				} catch (IOException | InterruptedException e) {
					log.warning("unable to restart the proces: " + process.getId());
				}
			});

		});
		monitor.start();
		monitors.add(monitor);
	}

	public void killAll() {
		restart.set(false);
		log.info("Killing all the processes");
		for (Process p : processes)
			p.destroy();
	}
}