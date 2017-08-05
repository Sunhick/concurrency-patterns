package com.process;

import javafx.application.Platform;

public class ThreadUtils {
	public static void runOnUiThread(Runnable runnable) {
		runOnMainThread(runnable);
	}

	public static void runOnMainThread(Runnable runnable) {
		Platform.runLater(runnable);
	}
}
