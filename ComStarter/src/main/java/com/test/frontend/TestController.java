package com.test.frontend;

import java.io.EOFException;
import java.io.IOException;
import java.util.logging.Logger;

import com.github.arunsoman.ipc.mappedbus.MappedBusWriter;
import com.test.common.Message;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TestController {
	private final static Logger log = Logger.getLogger(TestController.class.getSimpleName());
	private MappedBusWriter writer;
	@FXML
	private Button send;

	@FXML
	private TextField textField;

	@FXML
	private TextArea textArea;

	public TestController() {
		// Setup a writer
		writer = new MappedBusWriter("/Users/Sunny/prv/comm", 1000L, 32, true);
		try {
			writer.open();
		} catch (IOException e) {
			log.severe("Error in creating a writer.");
		}
	}

	@FXML
	void initialize() {
		assert send != null : "fx:id=\"send\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'HelloWorld.fxml'.";
		assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'HelloWorld.fxml'.";

		send.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String data = textField.getText();
				Message msg = new Message(data);
				try {
					if (writer != null)
						writer.write(msg);
				} catch (EOFException e) {
					log.severe("unable to write the message.");
				}

				log.info("send button clicked. Message sent.");

			}
		});
	}
}
