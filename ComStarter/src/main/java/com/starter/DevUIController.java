package com.starter;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DevUIController {

	private final static Logger log = Logger.getLogger(DevUIController.class.getSimpleName());

	@FXML
	private Button refresh;

	@FXML
	private Button start;

	@FXML
	private Button stop;

	@FXML
	private Button kill;

	@FXML
	void initialize() {
		assert refresh != null : "fx:id=\"refresh\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		assert start != null : "fx:id=\"start\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		assert stop != null : "fx:id=\"stop\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		assert kill != null : "fx:id=\"kill\" was not injected: check your FXML file 'HelloWorld.fxml'.";

		refresh.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				log.info("Refresh button clicked");
			}
		});

		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				log.info("Start button clicked");
			}
		});

		stop.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				log.info("Stop button clicked");
			}
		});

		kill.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			    Stage stage = (Stage) kill.getScene().getWindow();
			    stage.close();
			}
		});

	}
}
