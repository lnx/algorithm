package solutions;

public class MaximumSubarray {

	int maxSubArray(int[] a) {
		if (a.length == 0) {
			return Integer.MIN_VALUE;
		}
		int max = a[0];
		for (int i = 1, sum = a[0]; i < a.length; ++i) {
			sum = Math.max(sum + a[i], a[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaximumSubarray().maxSubArray(a));
	}

}
