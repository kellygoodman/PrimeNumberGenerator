import java.util.*;

public class PrimeGenerator implements Iterator<Integer> {
	
	public static void main (String [ ] args) {
		// Make sure there is exactly one argument, an integer.
		// Store the argument, converted to an int, in n.
		PrimeGenerator primeGen = new PrimeGenerator (n);
		int mostRecentPrime = 0;
		while (primeGen.hasNext ( )) {
			mostRecentPrime = primeGen.next ( );
		}
		System.out.println("The nth prime is: " + mostRecentPrime + " where n was: " + n);
	}
	
	public PrimeGenerator (int n) {
		// Make sure n is positive; throw IllegalArgumentException if not.
		// Initialize the iterator of the first n prime numbers.
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