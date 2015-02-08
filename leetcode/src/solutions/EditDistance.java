package solutions;

public class EditDistance {

	int minDistance(String w1, String w2) {
		int len1 = w1.length(), len2 = w2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; ++i) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; ++j) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= len1; ++i) {
			for (int j = 1; j <= len2; ++j) {
				if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
				}
			}
		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {
		String word1 = "a";
		String word2 = "abc";
		System.out.println(new EditDistance().minDistance(word1, word2));
	}

}
