package com.starter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Starter extends Application {
	private final static Logger log = Logger.getLogger(Starter.class.getSimpleName());
	private final CommandLine cmdline = new CommandLine();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) {
        try {
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
