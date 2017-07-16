package com.starter;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

public class NonUIShell extends Application {
	
	private final static Logger log = Logger.getLogger(NonUIShell.class.getSimpleName());
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		log.info("Start process in a non-window shell mode.");
	}
}
