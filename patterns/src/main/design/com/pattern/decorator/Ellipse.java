package com.pattern.decorator;

public class Ellipse implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing a Ellipse");
	}

	@Override
	public String describe() {
		return "Ellipse";
	}

}
