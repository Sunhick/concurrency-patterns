package com.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UIShell extends Application {
	
	private final static Logger log = Logger.getLogger(UIShell.class.getSimpleName());
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			log.info("Start process in a window shell mode (UI).");
			
			AnchorPane page = (AnchorPane) FXMLLoader.load(Starter.class.getResource("DevUI.fxml"));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dev UI");
			log.info("Starting App");
			primaryStage.show();
		} catch (Exception ex) {
			log.log(Level.SEVERE, null, ex);
		}
	}

}
