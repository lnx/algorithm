package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarray2 {

	int maxTwoSubArrays(ArrayList<Integer> nums) {
		int size = nums.size();
		if (size <= 1) {
			return 0;
		}
		int[] dp1 = new int[size];
		dp1[0] = nums.get(0);
		for (int i = 1, sum = nums.get(0); i < size; ++i) {
			sum = Math.max(sum + nums.get(i), nums.get(i));
			dp1[i] = Math.max(dp1[i - 1], sum);
		}
		int[] dp2 = new int[size];
		dp2[size - 1] = nums.get(size - 1);
		for (int i = size - 2, sum = nums.get(size - 1); i >= 0; --i) {
			sum = Math.max(sum + nums.get(i), nums.get(i));
			dp2[i] = Math.max(dp2[i + 1], sum);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size - 1; ++i) {
			max = Math.max(max, dp1[i] + dp2[i + 1]);
		}
		return max;
	}

	public static void main(String[] args) {
		Integer[] a = { -1, -1 };
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a));
		System.out.println(new MaximumSubarray2().maxTwoSubArrays(nums));
	}

}
