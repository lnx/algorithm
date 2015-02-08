package solutions;

public class MaximumProductSubarray {

	int maxProduct(int[] a) {
		int ret = a[0];
		for (int i = 1, pos = Math.max(a[0], 0), neg = Math.min(a[0], 0); i < a.length; ++i) {
			if (a[i] > 0) {
				pos = Math.max(pos * a[i], a[i]);
				neg *= a[i];
			} else if (a[i] == 0) {
				pos = neg = 0;
			} else {
				int temp = pos;
				pos = neg * a[i];
				neg = Math.min(temp * a[i], a[i]);
			}
			if (pos > ret) {
				ret = pos;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, -2, 4 };
		System.out.println(new MaximumProductSubarray().maxProduct(a));
	}

}
