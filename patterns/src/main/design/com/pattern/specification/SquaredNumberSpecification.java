package com.pattern.specification;

public class SquaredNumberSpecification<T> extends AbstractSpecification<T> {

	@Override
	public boolean isSatisfiedBy(T obj) {
		if (obj instanceof Integer) {
			int n = (int) obj;
			long sqrt = Math.round(Math.sqrt(n));
			return (sqrt * sqrt) == n;
		}
		return false;
	}

}
