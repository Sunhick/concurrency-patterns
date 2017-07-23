package com.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.config.Configuration;
import com.config.Processes;
import com.process.ProcessManager;

public class Starter {
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());

	public static void main(String[] args) {
		log.log(Level.INFO, "Starting Application");
		Options options = new Options(); 
		options.addOption("config", true, "configuration file name");
		options.addOption("ui", true, "UI file");
		
		CommandLineParser parser = new DefaultParser();
		ProcessManager manager = new ProcessManager();
		
		try {
			CommandLine cmdArgs = parser.parse(options, args);
			// start all the other process if config file is present.
			if (cmdArgs.hasOption("config")) {
				String conf = cmdArgs.getOptionValue("config");
				Configuration cfg = new Configuration();
				Processes processes = cfg.parse(conf);
				processes.getProcess().forEach(process -> manager.start(process));
				
				// add a shutdown hook so that we can kill all running process. SIGTERM
				Runtime.getRuntime().addShutdownHook(new Thread(()-> manager.killAll()));
			}
			
			
			Shell shell = cmdArgs.hasOption("ui") ? new UIShell() : new NonUIShell();
			shell.setProcessManager(manager);
			shell.run(cmdArgs);
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Error in parsing.", e);
		}
		
		log.log(Level.INFO, "Application stopped.");
	}
}