package com.pattern.specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Numbers repository will provide a 
 * range of numbers.
 *
 */
public class NumbersRepository<T> {
	
	private Provider<T> provider;
	private int count;
	
	public NumbersRepository(Provider<T> provider, int count) {
		this.provider = provider;
		this.count = count;
	}
	
	public List<T> getNumbers() {
		List<T> numbers = new ArrayList<>();
		
		int i = count;
		while (i > 0) {
			numbers.add(provider.provide());
			i--;
		}
		
		provider.reset();
		return numbers;
	}
	
}
