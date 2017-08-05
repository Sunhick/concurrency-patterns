package com.test.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Starter {

	public static void main(String[] args) {
		Injector guice = Guice.createInjector(new AppModule());
		Application app = guice.getInstance(Application.class);
		app.start();
	}

}
