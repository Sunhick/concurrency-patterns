package com.starter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;

import com.Root;
import com.process.ProcessManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UIShell extends Application implements Shell {

	private final static Logger log = Logger.getLogger(UIShell.class.getSimpleName());
	private static ProcessManager manager;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			log.info("Start process in a window shell mode (UI).");

			Parameters params = getParameters();
			List<String> args = params.getRaw();
			String uifile = args.get(0);

			log.log(Level.INFO, "loading ui file: " + uifile);
			AnchorPane page = (AnchorPane) FXMLLoader.load(Root.class.getResource(uifile));
			Scene scene = new Scene(page);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dev UI");
			primaryStage.show();
		} catch (Exception ex) {
			log.log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void stop() {
		manager.killAll();
	}

	@Override
	public void run(CommandLine args) {
		String uifile = args.getOptionValue("ui");
		Application.launch(UIShell.class, uifile);
	}

	@Override
	public void setProcessManager(ProcessManager p) {
		manager = p;
	}

}
