package com.starter;

import org.apache.commons.cli.CommandLine;

import com.process.ProcessManager;

public interface Shell {
	void setProcessManager(ProcessManager p);
	void run(CommandLine args);
}