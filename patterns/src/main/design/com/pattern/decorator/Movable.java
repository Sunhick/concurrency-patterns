package com.pattern.decorator;

public class Movable extends Decorator {

	Movable(Shape sh) {
		super(sh);
	}

	@Override
	public void draw() {
		System.out.println("Movable shape!");
		shape.draw();
	}

	@Override
	public String describe() {
		return "Movable " + shape.describe();
	}

}
