package com.starter;

import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;

import javafx.application.Application;
import javafx.stage.Stage;

public class NonUIShell extends Application implements Shell {
	
	private final static Logger log = Logger.getLogger(NonUIShell.class.getSimpleName());
	private CommandLine args;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		log.info("Start process in a non-window shell mode.");
	}

	@Override
	public void run(CommandLine args) {
		this.args = args;
		launch();
	}
}
