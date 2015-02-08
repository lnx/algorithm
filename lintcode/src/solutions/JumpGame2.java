package solutions;

import java.util.Arrays;

public class JumpGame2 {

	int jump(int[] a) {
		int[] dp = new int[a.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0, last = 0; i <= last && last < a.length - 1; ++i) {
			for (int j = last + 1; j <= i + a[i] && j < a.length; ++j) {
				dp[j] = dp[i] + 1;
			}
			last = Math.max(last, i + a[i]);
		}
		return dp[a.length - 1];
	}

}
