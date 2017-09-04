package com.pattern.decorator;

public abstract class Decorator implements Shape {

	protected Shape shape;
	
	Decorator(Shape sh) {
		shape = sh;
	}
}
