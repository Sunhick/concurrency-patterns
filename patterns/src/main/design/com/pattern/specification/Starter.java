package com.pattern.specification;

import java.util.List;

import com.pattern.specification.core.NotSpecification;
import com.pattern.specification.rules.CompositeNumberSpecification;
import com.pattern.specification.rules.EvenNumberSpecification;
import com.pattern.specification.rules.PrimeNumberSpecification;
import com.pattern.specification.rules.SquaredNumberSpecification;

public class Starter {

	public static void main(String[] args) {
		Provider<Integer> intProvider = new IntegerProvider();
		NumbersRepository repo = new NumbersRepository(intProvider, 20000);
		NumbersFilter<Integer> numbers = new NumbersFilter<>(repo);
		
		Specification<Integer> evens = new EvenNumberSpecification<>();
		Specification<Integer> squares = new SquaredNumberSpecification<>();
		Specification<Integer> specs = evens.not(squares);
		
		List<Integer> evenNumbers = numbers.filter(specs);
		// evenNumbers.forEach(System.out::println);
		
		System.out.println("Even Count: " + evenNumbers.size());
		
		Specification<Integer> odds = new NotSpecification<>(evens);
		Specification<Integer> spec2 = odds.and(squares);
		
		List<Integer> oddsNumbers = numbers.filter(spec2);
		// oddsNumbers.forEach(System.out::println);
		
		System.out.println("Odd Count: " + oddsNumbers.size());
		
		Specification<Integer> composite = new CompositeNumberSpecification<>();
		List<Integer> composites = numbers.filter(composite);
		// composites.forEach(System.out::println);
		System.out.println("composites: " + composites.size());
		
		// Even Composites.
		Specification<Integer> evenComposites = evens.and(composite);
		List<Integer> ec = numbers.filter(evenComposites);
		// ec.forEach(System.out::println);
		System.out.println("even composites:" + ec.size());
		
		// odd compsites
		Specification<Integer> oddComposites = odds.and(composite);
		List<Integer> oc = numbers.filter(oddComposites);
		// oc.forEach(System.out::println);
		System.out.println("odd composites:" + oc.size());
		
		Specification<Integer> primeSpec = new PrimeNumberSpecification<>();
		List<Integer> primes = numbers.filter(primeSpec);
		// primes.forEach(System.out::println);
		// Dont' use this technique to count the number of primes.
		// It's a tedius, time consuming & compute heavy operation.
		// Use the prime counting method if you just want number of primes.
		// 
		//      Prime counts, π(x) = x / ln(x)
		//     
		// https://en.wikipedia.org/wiki/Prime-counting_function
		// online tool: https://primes.utm.edu/nthprime/index.php
		System.out.println("Primes: " + primes.size());
		
		Specification<Integer> oddCmpSqr = odds.and(composite).and(squares);
		List<Integer> f = numbers.filter(oddCmpSqr);
		// f.forEach(System.out::println);
		System.out.println("odd composite perfect square: " + f.size());
		
		System.out.println("=== done ===");
	}

}
