package com.pattern.specification;

public class PrimeNumberSpecification<T> extends AbstractSpecification<T> {

	@Override
	public boolean isSatisfiedBy(T obj) {
		if (obj instanceof Integer) {
			int n = (int) obj;
			
			if (n < 2 || n <= 0) {
				return false;
			}
			
			if (n > 2 && n % 2 == 0) {
				// Number is not a prime.
		        return false;
			}
			
			// Sieve of Eratosthenes
			// Ref: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
			int limit = (int) Math.sqrt(n) + 1;
		    for(int i = 3; i < limit; i+=2) {
		        if(n % i == 0){
		            // Not a prime
		            return false;
		        }
		    }
		    
		    // otherwise it should be a prime number.
		    return true;
		}
		return false;
	}

}
