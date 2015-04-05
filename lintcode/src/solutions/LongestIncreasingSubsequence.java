package solutions;

public class LongestIncreasingSubsequence {

	int longestIncreasingSubsequence(int[] nums) {
		int max = 0;
		int len = nums.length;
		int[] dp = new int[len];
		for (int j = 0; j < len; ++j) {
			dp[j] = 1;
			for (int i = 0; i < j; ++i) {
				if (nums[i] <= nums[j]) {
					dp[j] = Math.max(dp[j], dp[i] + 1);
				}
			}
			max = Math.max(max, dp[j]);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = new int[0];
		System.out.println(a.length);
	}

}
