package solutions;

import java.util.Set;

public class WordSegmentation {

	boolean wordSegmentation(String s, Set<String> dict) {
		if (s == null || s.equals("")) {
			return s != null;
		}
		int len = s.length(), maxLen = getMaxLen(dict);
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		for (int i = 1; i <= len; ++i) {
			for (int l = 1; l <= maxLen && i - l >= 0; ++l) {
				if (dp[i - l] && dict.contains(s.substring(i - l, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[len];
	}

	int getMaxLen(Set<String> dict) {
		int max = 0;
		for (String s : dict) {
			max = Math.max(max, s.length());
		}
		return max;
	}

}
