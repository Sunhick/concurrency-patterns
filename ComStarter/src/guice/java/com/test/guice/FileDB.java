package com.test.guice;

public class FileDB implements DB {

	@Override
	public Integer query(String q) {
		System.out.println("File db");
		return 7;
	}
	
}