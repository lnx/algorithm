package solutions;

public class MaximumSubarray {

    int maxSubArray(int[] a) {
        int ret = a[0];
        for (int i = 1, sum = a[0]; i < a.length; ++i) {
            sum = sum > 0 ? sum + a[i] : a[i];
            ret = sum > ret ? sum : ret;
        }
        return ret;
    }

	public static void main(String[] args) {
		int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new MaximumSubarray().maxSubArray(a));
	}

}
