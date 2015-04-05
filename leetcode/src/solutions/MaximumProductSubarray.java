package solutions;

public class MaximumProductSubarray {

	int maxProduct(int[] a) {
		if (a.length == 0) {
			return Integer.MIN_VALUE;
		}
		int max = a[0];
		for (int i = 1, pos = Math.max(a[0], 0), neg = Math.min(a[0], 0); i < a.length; ++i) {
			if (a[i] >= 0) {
				pos = Math.max(pos * a[i], a[i]);
				neg = Math.min(neg * a[i], a[i]);
			} else {
				int t = Math.max(neg * a[i], a[i]);
				neg = Math.min(pos * a[i], a[i]);
				pos = t;
			}
			max = Math.max(max, pos);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, -2, 4 };
		System.out.println(new MaximumProductSubarray().maxProduct(a));
	}

}
