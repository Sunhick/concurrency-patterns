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
		try {
			exec(Starter.class);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
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

	public static int exec(Class klass) throws IOException, InterruptedException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = klass.getCanonicalName();

		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

		Process process = builder.start();
		// process.waitFor();
		// return process.exitValue();
		return 1;
	}
}
