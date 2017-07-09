package com.activeobject;

public class Starter {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Active object design pattern");
		MathProxy proxy = new MathProxy();
		Future f = proxy.add(100, 100);
		
		// more parallel ops here.
		Thread.sleep(4000);
		
		f.show();
		System.out.println("Done");
	}

}
