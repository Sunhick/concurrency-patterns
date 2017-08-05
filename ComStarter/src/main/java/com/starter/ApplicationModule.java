package com.starter;

import com.config.ConfigModule;
import com.google.inject.AbstractModule;
import com.process.ProcessModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		// install dependent modules.
		install(new ConfigModule());
		install(new ProcessModule());
		
		// configure application/starter level modules here.
	}

}
