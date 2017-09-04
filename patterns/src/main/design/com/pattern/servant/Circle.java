package com.pattern.servant;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Circle implements Movable {

	private Position position;
	private WeakReference<Canvas> weakWidget;
	private SoftReference<Canvas> softWidget;

	Circle(Canvas w) {
		this.position = new Position(0, 0);
		// Read about WeakReference and SoftReference
		// https://stackoverflow.com/questions/299659/what-is-the-difference-between-a-soft-reference-and-a-weak-reference-in-java
		// https://web.archive.org/web/20061130103858/http://weblogs.java.net/blog/enicholas/archive/2006/05/understanding_w.html
		this.weakWidget = new WeakReference<Canvas>(w);
		this.softWidget = new SoftReference<Canvas>(w);
	}

	@Override
	public void setPosition(Position p) {
		position = p;
		Canvas canvas = weakWidget.get();
		if (canvas != null) {
			canvas.draw(position);
		}
	}
	
	public void draw() {
		Canvas canvas = weakWidget.get();
		if (canvas != null) {
			canvas.draw(position);
		}
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
