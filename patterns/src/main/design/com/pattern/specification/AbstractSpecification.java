package com.pattern.specification;

public abstract class AbstractSpecification<T> implements Specification<T> {

	// To be implemented by the concrete specifications.
	public abstract boolean isSatisfiedBy(T obj);

	@Override
	public Specification<T> and(Specification<T> spec) {
		return new AndSpecification<>(this, spec);
	}

	@Override
	public Specification<T> or(Specification<T> spec) {
		return new OrSpecification<>(this, spec);
	}

	@Override
	public Specification<T> not(Specification<T> spec) {
		return new AndSpecification<>(this, new NotSpecification<>(spec));
	}

}
