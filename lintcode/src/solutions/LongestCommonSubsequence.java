package solutions;

public class LongestCommonSubsequence {

	int longestCommonSubsequence(String s1, String s2) {
		int len1 = s1 != null ? s1.length() : 0, len2 = s2 != null ? s2.length() : 0;
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i <= len1; ++i) {
			for (int j = 1; j <= len2; ++j) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}
		return dp[len1][len2];
	}

}
