package solutions;

public class KthPrimeNumber {

	long kthPrimeNumber(int k) {
		long[] h = new long[k + 1];
		h[0] = 1;
		for (int i = 1, i3 = 0, i5 = 0, i7 = 0; i <= k; ++i) {
			long x3 = h[i3] * 3, x5 = h[i5] * 5, x7 = h[i7] * 7;
			h[i] = Math.min(x3, Math.min(x5, x7));
			if (h[i] == x3) {
				++i3;
			}
			if (h[i] == x5) {
				++i5;
			}
			if (h[i] == x7) {
				++i7;
			}
		}
		return h[k];
	}

	public static void main(String[] args) {
		KthPrimeNumber o = new KthPrimeNumber();
		System.out.println(o.kthPrimeNumber(100));
	}

}
