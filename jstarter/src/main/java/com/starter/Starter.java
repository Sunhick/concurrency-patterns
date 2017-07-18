package com.starter;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Starter extends Application {
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());
	private final static CommandLine cmdline = new CommandLine();

	public static void main(String[] args) {
		cmdline.run(args);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}
