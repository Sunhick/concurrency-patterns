package com.pattern.specification.core;

import com.pattern.specification.Specification;

public class AndSpecification<T> extends AbstractSpecification<T> {
	
	private Specification<T> spec1;
	private Specification<T> spec2;
	
	public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}

	@Override
	public boolean isSatisfiedBy(T obj) {
		return spec1.isSatisfiedBy(obj) && spec2.isSatisfiedBy(obj);
	}

}
