package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarray3 {

	int maxSubArray(ArrayList<Integer> nums, int k) {
		int size = nums.size();
		int[][] dp = new int[size + 1][k + 1];
		for (int i = 1; i <= size; ++i) {
			for (int j = 1; j <= k && j <= i; ++j) {
				dp[i][j] = dp[i - 1][j - 1] + nums.get(i - 1);
				for (int d = i - 1, sum = nums.get(i - 1); d >= j; --d) {
					sum = Math.max(sum + nums.get(d - 1), nums.get(d - 1));
					dp[i][j] = Math.max(dp[i][j], dp[d - 1][j - 1] + sum);
				}
			}
		}
		return dp[size][k];
	}

	public static void main(String[] args) {
		Integer[] a = { -1, 4, -2, 3, -2, 3 };
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a));
		int k = 10;
		System.out.println(new MaximumSubarray3().maxSubArray(nums, k));
	}

}
