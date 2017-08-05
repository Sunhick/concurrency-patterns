package com.starter;

public class ShellFactory implements ShellProvider {

	@Override
	public Shell create(ShellType type) {
		return type == ShellType.UIShell ? new UIShell() : new NonUIShell();
	}
	
}