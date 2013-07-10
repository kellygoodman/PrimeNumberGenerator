import java.util.*;


public class PrimeGenerator2 implements Iterator<Integer> {
	private int totalPrimes;
	private int iterPrimes;
	private int index;
	boolean[] primes;
	public static void main (String [ ] args) {
		// Make sure there is exactly one argument, an integer.
		// Store the argument, converted to an int, in n.
		int n=0;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Input is not an integer");
			System.exit(1);
		}
		PrimeGenerator primeGen = new PrimeGenerator (n);
		int mostRecentPrime = 0;
		while (primeGen.hasNext ( )) {
			mostRecentPrime = primeGen.next ( );
		}
		System.out.println("The nth prime is: " + mostRecentPrime + " where n was: " + n);
	}
	
	public PrimeGenerator2 (int n) {
		// Make sure n is positive; throw IllegalArgumentException if not.
		// Initialize the iterator of the first n prime numbers.
		int endpoint;
		if (n<=0) {
			throw new IllegalArgumentException("n is not positive");
		}
		if (n<6) {
			endpoint = (int) (n*(Math.log(Math.log(6))));
		} else {
			endpoint = (int) (n*(Math.log(Math.log(n))));
		}
		index = 2;
		totalPrimes = n;
		iterPrimes = 0;
		primes = new boolean [endpoint];
		Arrays.fill(primes, true);
		for (int k = 4; k <= endpoint; k+=2) {
			primes[k] = false;
		}
		for (int divisor = 3; divisor * divisor <= endpoint; divisor+=2) {
			if (primes[divisor]) {
				for (int i =divisor * divisor; i<= endpoint; i = i+ divisor) {
					primes[i] = false;
				}
			}
		}
		
	}
	
	// Return true if there are more primes to return.
	public boolean hasNext ( ) {
		return (iterPrimes < totalPrimes);
	}
	
	// Return the next prime number.
	public Integer next ( )	{
		int returnVal=0;
		while (index < primes.length) {
			if (primes[index]) {
				returnVal = index;
				index++;
				iterPrimes++;
				break;
			}
			index++;
		}
		return returnVal;
	}
	
	// This is only here because the Iterator interface requires it.
	public void remove ( ) {		
	}
}