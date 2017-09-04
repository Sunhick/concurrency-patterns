package com.pattern.marker;

import java.util.UUID;

/**
 * Cloneable here is an empty interface marker. Clone() method is defined in
 * Object class which every class/object in java inherits. Object.clone method
 * just throws CloneNotSupportedException. When you override don't call
 * super.clone()
 * 
 * It provides a means to associate metadata with a class where the language
 * does not have explicit support for such metadata.
 */
public class ImagingService implements Cloneable {

	private final static String VERSION = "0.1";
	private final static String CODE_NAME = "Imaging Service";
	private static String id;

	public ImagingService() {
		id = UUID.randomUUID().toString();
		// More complex variable initialization here.
	}

	public void printId() {
		System.out.println("Id: " + id);
	}

	@Override
	protected ImagingService clone() throws CloneNotSupportedException {
		return new ImagingService();
	}

}
