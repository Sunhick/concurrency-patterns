package com.process;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class ProcessModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ProcessManager.class);

		install(new FactoryModuleBuilder().implement(ProcessMonitor.class, ProcessMonitor.class)
				.build(ProcessMonitor.ProcessMonitorFactory.class));
	}

}
