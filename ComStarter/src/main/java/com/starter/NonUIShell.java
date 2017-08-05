package com.starter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;

import com.Root;
import com.process.ProcessManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class NonUIShell extends Application implements Shell {

	private final static Logger log = Logger.getLogger(NonUIShell.class.getSimpleName());
	private static ProcessManager manager;

	@Override
	public void start(Stage primaryStage) throws Exception {
		log.info("Start process in a non-window shell mode.");
		Parameters params = getParameters();
		List<String> args = params.getRaw();
		String uifile = args.get(0);
		log.log(Level.INFO, "loading ui file: " + uifile);
		FXMLLoader.load(Root.class.getResource(uifile));
	}

	@Override
	public void run(CommandLine args) {
		String uifile = args.getOptionValue("ui");
		Application.launch(NonUIShell.class, uifile);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		manager.killAll();
	}

	@Override
	public void setProcessManager(ProcessManager p) {
		manager = p;
	}
}
