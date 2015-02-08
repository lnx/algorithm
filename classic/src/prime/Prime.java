package prime;

import java.util.Arrays;

public class Prime {

	boolean[] getPrimes(int max) {
		boolean[] primes = new boolean[(max - 3) / 2 + 1];
		Arrays.fill(primes, true);
		for (long i = 0; i < primes.length - 1; ++i) {
			if (primes[(int) i]) {
				long prime = i * 2 + 3;
				for (long j = prime * prime; j <= max; j += prime * 2) {
					primes[(int) ((j - 3) / 2)] = false;
				}
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		int max = 100;
		boolean[] primes = new Prime().getPrimes(max);
		System.out.println(2);
		for (int i = 0; i < primes.length; ++i) {
			if (primes[i]) {
				System.out.println(i * 2 + 3);
			}
		}
	}

}
