package com.starter;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UIShell extends Application implements Shell {
	
	private final static Logger log = Logger.getLogger(UIShell.class.getSimpleName());
	private CommandLine args;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			log.info("Start process in a window shell mode (UI).");
			
			Parameters params = getParameters();
			List<String> args = params.getRaw();
			
			AnchorPane page = (AnchorPane) FXMLLoader.load(Starter.class.getResource(args.get(0)));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dev UI");
			log.info("Starting App");
			primaryStage.show();
		} catch (Exception ex) {
			log.log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run(CommandLine args) {
		this.args = args;
		String config = args.getOptionValue("config");
		Application.launch(UIShell.class, config);
	}

}
