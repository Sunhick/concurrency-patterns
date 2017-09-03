package com.pattern.specification;

import com.pattern.specification.core.AbstractSpecification;

public class CompositeNumberSpecification<T> extends AbstractSpecification<T> {

	@Override
	public boolean isSatisfiedBy(T obj) {
		if (obj instanceof Integer) {
			int n = (int) obj;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					// Number is divisible by i other than 1 & n. 
					// so it's a composite number.
					return true;
				}
			}
		}
		return false;
	}

}
