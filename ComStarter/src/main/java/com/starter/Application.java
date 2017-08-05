package com.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.config.Configuration;
import com.config.Processes;
import com.google.inject.Inject;
import com.process.ProcessManager;

public class Application {
	private final static Logger log = Logger.getLogger(Application.class.getSimpleName());
	private final Options options;
	private final ProcessManager manager;
	private final CommandLineParser parser;
	private final Configuration cfg;
	private ShellFactory shellFactory;

	@Inject
	public Application(Options options, CommandLineParser parser, ProcessManager manager, Configuration cfg,
			ShellFactory shellFactory) {
		this.parser = parser;
		this.manager = manager;
		this.options = options;
		this.cfg = cfg;
		this.shellFactory = shellFactory;

		setupCmdlineOptions();
	}

	private void setupCmdlineOptions() {
		options.addOption("config", true, "configuration file name");
		options.addOption("ui", true, "UI file");
		options.addOption("frontend", false, "starts process with UI view.");
	}

	public void run(String[] args) {
		debugArgs(args);
		log.log(Level.INFO, "Starting Application");

		try {
			CommandLine cmdArgs = parser.parse(options, args);
			// start all the other process if config file is present.
			if (cmdArgs.hasOption("config")) {
				String conf = cmdArgs.getOptionValue("config");
				Processes processes = cfg.parse(conf);
				processes.getProcess().forEach(process -> manager.start(process));

				// add a shutdown hook so that we can kill all running process. SIGTERM
				Runtime.getRuntime().addShutdownHook(new Thread(() -> manager.killAll()));
			}

			ShellType type = cmdArgs.hasOption("frontend") ? ShellType.UIShell : ShellType.NonUIShell;
			Shell shell = shellFactory.create(type);
			shell.setProcessManager(manager);
			shell.run(cmdArgs);
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Error in parsing.", e);
		}

		log.log(Level.INFO, "Application stopped.");
	}

	private void debugArgs(String[] args) {
		log.info("ARGS===");
		for (String arg : args) {
			log.info(arg);
		}
	}
}