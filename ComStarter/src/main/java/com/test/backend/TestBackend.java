package com.test.backend;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.arunsoman.ipc.mappedbus.MappedBusReader;
import com.test.common.Message;

import javafx.fxml.FXML;

public class TestBackend {
	private final static Logger log = Logger.getLogger(TestBackend.class.getSimpleName());
	private MappedBusReader reader;

	public TestBackend() {
		reader = new MappedBusReader("/Users/Sunny/prv/comm", 1000L, 32);
		try {
			reader.open();
		} catch (IOException e1) {
			log.severe("Error in creating reader.");
		}

		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(() -> {
			try {
				reader.open();

				Message msg = new Message("");
				// read messages
				while (true) {
					if (reader.next()) {
						int type = reader.readType();
						if (type == Message.TYPE) {
							reader.readMessage(msg);
							log.info(msg.getMessage());
						}
					}
				}
			} catch (IOException e) {
				log.log(Level.SEVERE, "Error in opening mapped bus.", e);
			}
		});
	}

	@FXML
	void initialize() {
		log.info("Testbacked initialized.");
	}
}
