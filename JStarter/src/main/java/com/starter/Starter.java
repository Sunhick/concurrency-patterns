package com.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Starter {
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());

	public static void main(String[] args) {
		log.log(Level.INFO, "Starting Application");
		Options options = new Options();
		options.addOption("config", true, "configuration file name");
		options.addOption("showUI", true, "launch ui");
		
		CommandLineParser parser = new BasicParser();
		try {
			CommandLine cmdArgs = parser.parse(options, args);
			Shell shell = cmdArgs.hasOption("showUI") ? new UIShell() : new NonUIShell();
			shell.run(cmdArgs);
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Error in parsing.", e);
		}
	}
}