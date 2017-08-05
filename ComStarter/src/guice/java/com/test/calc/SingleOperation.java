package com.test.calc;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class SingleOperation implements Operation {
	private Integer a;
	private Integer b;
	private String id;
	private Calculator c;

	@Inject
	public SingleOperation(@Assisted("a") Integer a, @Assisted("b") Integer b, @Assisted("Id") String id,
			Calculator c) {
		this.a = a;
		this.b = b;
		this.id = id;
		this.c = c;
	}

	@Override
	public void perform() {
		System.out.println("------");
		System.out.println("performed ans = " + c.add(a, b));
		System.out.println(c.getClass().getSimpleName());
		System.out.println(id);
		System.out.println("------");
	}

	public interface SingleOperationFactory {
		SingleOperation create(@Assisted("a") Integer a, @Assisted("b") Integer b, @Assisted("Id") String id);
	}
}