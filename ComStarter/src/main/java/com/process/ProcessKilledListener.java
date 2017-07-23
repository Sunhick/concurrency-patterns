package com.process;

@FunctionalInterface
public interface ProcessKilledListener {
	void onProcessKilled(String Id);
}