package solutions;

public class LongestPalindromicSubstring {

	String longestPalindrome(String s) {
		String ret = "";
		for (int i = 0, len = s.length(); i < len; ++i) {
			int step = 0;
			while (i - step - 1 >= 0 && i + step + 1 < len && s.charAt(i - step - 1) == s.charAt(i + step + 1)) {
				++step;
			}
			if (step * 2 + 1 > ret.length()) {
				ret = s.substring(i - step, i + step + 1);
			}
			step = 0;
			while (i - step >= 0 && i + step + 1 < len && s.charAt(i - step) == s.charAt(i + step + 1)) {
				++step;
			}
			if (step * 2 > ret.length()) {
				ret = s.substring(i - step + 1, i + step + 1);
			}
		}
		return ret;
	}

	String longestPalindrome1(String s) {
		String ret = "";
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = len - 1; i >= 0; --i) {
			for (int j = i; j < len; ++j) {
				if (j - i >= 3) {
					dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}
				if (dp[i][j] && j - i + 1 > ret.length()) {
					ret = s.substring(i, j + 1);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("aa"));
	}

}
