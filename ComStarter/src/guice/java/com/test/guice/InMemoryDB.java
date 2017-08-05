package com.test.guice;

public class InMemoryDB implements DB {

	@Override
	public Integer query(String q) {
		System.out.println("InMemory db");
		return 5;
	}

}