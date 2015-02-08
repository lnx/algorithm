package solutions;

public class DistinctSubsequences {

	int numDistinct(String s, String t) {
		int slen = s.length(), tlen = t.length();
		int[] dp = new int[tlen + 1];
		dp[0] = 1;
		for (int i = 1; i <= slen; ++i) {
			for (int j = tlen; j >= 1; --j) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[j] += dp[j - 1];
				}
			}
		}
		return dp[tlen];
	}

}
