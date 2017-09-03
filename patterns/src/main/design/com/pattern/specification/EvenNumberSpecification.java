package com.pattern.specification;

import com.pattern.specification.core.AbstractSpecification;

public class EvenNumberSpecification<T>extends AbstractSpecification<T> {

	@Override
	public boolean isSatisfiedBy(T obj) {
		if (obj instanceof Integer) {
			int n = (int) obj;
			return n % 2 == 0;
		}
		
		return false;
	}

}
