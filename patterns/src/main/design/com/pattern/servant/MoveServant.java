package com.pattern.servant;

public class MoveServant {
	public void moveTo(Movable obj, Position to) {
		obj.setPosition(to);
	}
	
	public void moveBy(Movable obj, int dx, int dy) {
		dx += obj.getPosition().getX();
		dy += obj.getPosition().getY();
		
		obj.setPosition(new Position(dx, dy));
	}
}
