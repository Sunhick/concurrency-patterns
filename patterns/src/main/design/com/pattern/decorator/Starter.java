package com.pattern.decorator;

public class Starter {

	public static void main(String[] args) {
		Triangle tri = new Triangle();
		Ellipse ellipse = new Ellipse();
		
		// tri.draw();
		// ellipse.draw();
		
		System.out.println(tri.describe());
		System.out.println(ellipse.describe());
		
		// Lets make those object movable.
		Movable movableTri = new Movable(tri);
		Movable movableEllipse = new Movable(ellipse);
		
		// movableTri.draw();
		// movableEllipse.draw();
		
		System.out.println(movableTri.describe());
		System.out.println(movableEllipse.describe());
		
		// Lets turn that movable shape into scalable.
		Scalable rect = new Scalable(new Movable(new Rectangle()));
		// rect.draw();
		System.out.println(rect.describe());
	}

}
