package com.pattern.servant;

public class Canvas extends Widget {
	
	public void draw(Position p) {
		System.out.println("Position: " + p.toString());
	}
}
