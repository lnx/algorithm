package solutions;

public class FirstMissingPositive {

	int firstMissingPositive(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			a[i] = a[i] <= 0 ? Integer.MAX_VALUE : a[i];
		}
		for (int i = 0; i < a.length; ++i) {
			int index = Math.abs(a[i]);
			if (index <= a.length) {
				a[index - 1] = -Math.abs(a[index - 1]);
			}
		}
		for (int i = 0; i < a.length; ++i) {
			if (a[i] > 0) {
				return i + 1;
			}
		}
		return a.length + 1;
	}

}
