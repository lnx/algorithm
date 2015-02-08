package solutions;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	boolean wordBreak(String s, Set<String> dict) {
		int slen = s.length();
		boolean[] dp = new boolean[slen + 1];
		dp[0] = true;
		for (int i = 1; i <= slen; ++i) {
			for (int j = 0; j < i; ++j) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[slen];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(new WordBreak().wordBreak(s, dict));
	}

}
