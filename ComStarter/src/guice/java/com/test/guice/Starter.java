package com.test.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Starter {

	public static void main(String[] args) {
		Injector guice = Guice.createInjector();
		// Application app = guice.getInstance(Application.class);
		// app.start();

		Injector child = guice.createChildInjector(new AppModule());
		ScopedSingleton ss = child.getInstance(ScopedSingleton.class);
		ScopedSingleton ss2 = child.getInstance(ScopedSingleton.class);
		ss.showId();
		ss2.showId();

		Injector child2 = guice.createChildInjector(new AppModule());
		ScopedSingleton s = child2.getInstance(ScopedSingleton.class);
		ScopedSingleton s2 = child2.getInstance(ScopedSingleton.class);
		s.showId();
		s2.showId();
	}

}
