package com.pattern.specification;

import java.util.ArrayList;
import java.util.List;

public class NumbersFilter<T> {
	
	private NumbersRepository<T> repo;
	
	public NumbersFilter(NumbersRepository<T> repo) {
		this.repo = repo;
	}
	
	public List<T> filter(Specification<T> specs) {
		final List<T> collections = repo.getNumbers();
		final List<T> selected = new ArrayList<>();
		
		for (T each : collections) {
			if (specs.isSatisfiedBy(each)) {
				selected.add(each);
			}
		}
		
		return selected;
	}
}
