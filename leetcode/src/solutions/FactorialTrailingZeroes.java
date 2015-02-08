package solutions;

public class FactorialTrailingZeroes {

	int trailingZeroes(int n) {
		if (n < 5) {
			return 0;
		}
		int exp = (int) (Math.log(n) / Math.log(5));
		int count = 0;
		for (int i = 1, cur = 5; i <= exp; ++i) {
			count += n / cur;
			cur *= 5;
		}
		return count;
	}

}
