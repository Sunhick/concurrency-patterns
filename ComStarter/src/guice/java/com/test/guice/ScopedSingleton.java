package com.test.guice;

import java.util.UUID;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ScopedSingleton {
	private final String Id;
	
	@Inject
	public ScopedSingleton() {
		System.out.println("scoped singleton ctor");
		Id = UUID.randomUUID().toString();
	}
	
	public void showId() {
		System.out.println("Id : " + Id);
	}
}
