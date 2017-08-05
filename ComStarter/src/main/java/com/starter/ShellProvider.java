package com.starter;

enum ShellType {
	UIShell, NonUIShell
}

public interface ShellProvider {
	Shell create(ShellType type);
}

class ShellFactory implements ShellProvider {

	@Override
	public Shell create(ShellType type) {
		return type == ShellType.UIShell ? new UIShell() : new NonUIShell();
	}
	
}