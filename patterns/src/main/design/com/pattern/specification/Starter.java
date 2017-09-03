package com.pattern.specification;

import java.util.List;

public class Starter {

	public static void main(String[] args) {
		Provider<Integer> intProvider = new IntegerProvider();
		NumbersRepository repo = new NumbersRepository(intProvider, 2000);
		NumbersFilter<Integer> numbers = new NumbersFilter<>(repo);
		
		Specification<Integer> evens = new EvenNumberSpecification<>();
		Specification<Integer> squares = new SquaredNumberSpecification<>();
		Specification<Integer> specs = evens.not(squares);		
		
		List<Integer> evenNumbers = numbers.filter(specs);
		for (int e : evenNumbers) {
			System.out.println(e);
		}
		
		System.out.println("Count: " + evenNumbers.size());
		System.out.println("=== done ===");
	}

}
