package solutions;

public class TrailingZeros {

	long trailingZeros(long n) {
		long count = 0;
		for (long i = 1, exp = (long) (Math.log(n) / Math.log(5)), cur = 1; i <= exp; ++i) {
			cur *= 5;
			count += n / cur;
		}
		return count;
	}

}
