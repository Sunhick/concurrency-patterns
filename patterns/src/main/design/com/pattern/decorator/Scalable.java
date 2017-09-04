package com.pattern.decorator;

public class Scalable extends Decorator {

	Scalable(Shape sh) {
		super(sh);
	}

	@Override
	public void draw() {
		System.out.println("Scalable shape!");
		shape.draw();
	}

	@Override
	public String describe() {
		return "Scalable " + shape.describe();
	}

}
