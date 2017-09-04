package com.pattern.servant;

public class Starter {

	public static void main(String[] args) {
		// Decorator vs Servant pattern.
		Canvas c = new Canvas();
		Circle cir = new Circle(c);
		
		cir.draw();
		
		MoveServant mover = new MoveServant();
		mover.moveTo(cir, new Position(20, 20));
	}

}
