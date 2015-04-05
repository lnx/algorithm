package prime;

import java.util.Arrays;

public class Prime1 {

	boolean[] genPrimes(int max) {
		boolean[] primes = new boolean[(max - 3) / 2 + 1];
		Arrays.fill(primes, true);
		for (int i = 0; i < primes.length; ++i) {
			if (primes[i]) {
				int prime = 3 + 2 * i;
				for (long j = prime * prime; j <= max; j += prime * 2) {
					primes[(int) ((j - 3) / 2)] = false;
				}
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		int max = 100;
		boolean[] primes = new Prime1().genPrimes(max);
		System.out.println(2);
		for (int i = 0; i < primes.length; ++i) {
			if (primes[i]) {
				System.out.println(i * 2 + 3);
			}
		}
	}

}
