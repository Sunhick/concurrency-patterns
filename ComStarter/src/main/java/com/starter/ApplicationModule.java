package com.starter;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import com.config.ConfigModule;
import com.config.Configuration;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.process.ProcessManager;
import com.process.ProcessModule;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		// install dependent modules.
		install(new ConfigModule());
		install(new ProcessModule());

		// configure application/starter level modules here.
		bind(Options.class);
		bind(Configuration.class);
		bind(CommandLineParser.class).to(DefaultParser.class);

		// singleton scoped objects.
		bind(ShellFactory.class).in(Singleton.class);
	}

}
