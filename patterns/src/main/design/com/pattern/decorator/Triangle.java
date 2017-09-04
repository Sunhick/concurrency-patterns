package com.pattern.decorator;

public class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drawing a Triangle");
	}

	@Override
	public String describe() {
		return "Triangle";
	}

}
