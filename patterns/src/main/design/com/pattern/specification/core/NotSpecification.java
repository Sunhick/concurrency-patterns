package com.pattern.specification.core;

import com.pattern.specification.Specification;

public class NotSpecification<T> extends AbstractSpecification<T> {
	
	private Specification<T> spec;
	
	public NotSpecification(Specification<T> spec) {
		this.spec = spec;
	}

	@Override
	public boolean isSatisfiedBy(T obj) {
		return !spec.isSatisfiedBy(obj);
	}

}