package com.starter;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Bootstrap {

	public static void main(String[] args) {
		Injector guice = Guice.createInjector(new ApplicationModule());
		Application app = guice.getInstance(Application.class);
		app.run(args);
	}
}
