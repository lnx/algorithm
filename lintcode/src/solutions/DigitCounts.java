package solutions;

public class DigitCounts {

	int digitCounts(int k, int n) {
		if (n == 0) {
			return k == 0 ? 1 : 0;
		}
		int count = 0;
		int base = 1;
		while (n >= base) {
			int i = (n / base) % 10;
			if (i < k) {
				count += (n / (base * 10)) * base;
			} else if (i == k) {
				count += (n / (base * 10)) * base + n % base + 1;
			} else {
				count += (n / (base * 10) + 1) * base;
			}
			base *= 10;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new DigitCounts().digitCounts(0, 0));
	}

}
