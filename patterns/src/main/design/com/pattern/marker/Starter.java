package com.pattern.marker;

public class Starter {

	public static void main(String[] args) throws CloneNotSupportedException {
		ImagingService service = new ImagingService();
		service.printId();
		ImagingService clone = service.clone();
		clone.printId();
	}

}
