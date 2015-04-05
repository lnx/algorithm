package solutions;

import java.util.Arrays;

public class KSum {

	int kSum(int nums[], int k, int target) {
		Arrays.sort(nums);
		int[][][] dp = new int[nums.length][k + 1][target + 1];
		for (int i = 0; i < nums.length; ++i) {
			dp[i][0][0] = 1;
			for (int t = 0; t <= i; ++t) {
				if (nums[t] <= target) {
					dp[i][1][nums[t]] = 1;
				}
			}
		}
		for (int i = 1; i < nums.length; ++i) {
			for (int j = 2; j <= k; ++j) {
				for (int t = 0; t <= target; ++t) {
					dp[i][j][t] = dp[i - 1][j][t];
					if (t >= nums[i]) {
						dp[i][j][t] += dp[i - 1][j - 1][t - nums[i]];
					}
				}
			}
		}
		return dp[nums.length - 1][k][target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 5, 8, 10, 11, 12, 14, 17, 20, 22, 24, 25, 28, 30, 31, 34, 35, 37, 38, 40, 42, 44, 45, 48, 51, 54, 56, 59, 60, 61, 63, 66 };
		int k = 24;
		int target = 842;
		System.out.println(new KSum().kSum(nums, k, target));
	}

}
