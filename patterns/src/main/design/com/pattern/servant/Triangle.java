package com.pattern.servant;

public class Triangle implements Movable {

	private Position position;
	
	@Override
	public void setPosition(Position p) {
		position = p;
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
