package main.java;
/* Based on http://stackoverflow.com/posts/28948975/revisions */

public class ProductCalculations {
	private int[] PRIMES = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
	        37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103,
	        107, 109, 113 };
	
	/* Calculate Product for given word. */
	public long Calculate(String word){
		long result = 1L;
		
		if (word.length() > 11) {
			/* It might overflow long so won't be calculated.  */
			return -1;
		}
		
	    for (char c : word.toLowerCase().toCharArray()) {
	        if (c < 'a' | c > 'z') {
	            return -1;
	        }
	        int pos = c - 'a';
	        result *= PRIMES[pos];
	    }
	    return result;
	}

}
