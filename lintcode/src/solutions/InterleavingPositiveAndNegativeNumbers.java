package solutions;

import java.util.Arrays;

public class InterleavingPositiveAndNegativeNumbers {

	int[] rerange(int[] a) {
		int negCount = 0;
		for (int i : a) {
			if (i < 0) {
				++negCount;
			}
		}
		int neg = negCount >= (a.length + 1) / 2 ? 0 : 1, pos = 1 - neg;
		while (true) {
			while (neg < a.length && a[neg] < 0) {
				neg += 2;
			}
			while (pos < a.length && a[pos] > 0) {
				pos += 2;
			}
			if (neg < a.length && pos < a.length) {
				swap(a, neg, pos);
			} else {
				break;
			}
		}
		return a;
	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int[] a = { -13, -8, -12, -15, -14, 35, 7, -1, 11, 27, 10, -7, -12, 28, 18 };
		System.out.println(Arrays.toString(new InterleavingPositiveAndNegativeNumbers().rerange(a)));
	}

}
