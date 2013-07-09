import java.util.*;
import java.math.*;

public class PrimeGenerator implements Iterator<Integer> {
	
	public static void main (String [ ] args) {
		// Make sure there is exactly one argument, an integer.
		// Store the argument, converted to an int, in n.

		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.close();
		PrimeGenerator primeGen = new PrimeGenerator (n);
		int mostRecentPrime = 0;
		while (primeGen.hasNext ( )) {
			mostRecentPrime = primeGen.next ( );
		}
		System.out.println("The nth prime is: " + mostRecentPrime + " where n was: " + n);
	}
	
	public PrimeGenerator (int n) throws IllegalArgumentException{
		// Make sure n is positive; throw IllegalArgumentException if not.
		// Initialize the iterator of the first n prime numbers.
		if (n<=0) {
			throw new IllegalArgumentException("n is not positive");
		}
		ArrayList <Integer> values= new ArrayList<Integer>();
		int start = (int) (n*Math.log(n)+n*(Math.log(Math.log(n))-1));
		int end = (int) (n*Math.log(n)+n*(Math.log(Math.log(n))));
		for (int i = start; i<=end;i++) {
			if (i%2 != 0 //get rid of multiples of 2, 3, 5
					&& i%3 != 0 
					&& i%5 != 0) {
				values.add(i);
			}
		}

	}
	
	// Return true if there are more primes to return.
	public boolean hasNext ( ) {
		return true;
	}
	
	// Return the next prime number.
	public Integer next ( )	{
		return new Integer (5);
	}
	
	// This is only here because the Iterator interface requires it.
	public void remove ( ) {		
	}
}