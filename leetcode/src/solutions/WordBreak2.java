package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WordBreak2 {

	List<String> wordBreak(String s, Set<String> dict) {
		List<String> ret = new ArrayList<>();
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
		if (dp[slen]) {
			dfs(s, dict, new Stack<String>(), ret);
		}
		return ret;
	}

	void dfs(String s, Set<String> dict, Stack<String> stack, List<String> ret) {
		if (s.equals("")) {
			StringBuilder sb = new StringBuilder();
			for (String word : stack) {
				sb.append(word + " ");
			}
			ret.add(sb.toString().trim());
		} else {
			for (String word : dict) {
				if (s.startsWith(word)) {
					stack.push(word);
					dfs(s.substring(word.length()), dict, stack, ret);
					stack.pop();
				}
			}
		}
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(new WordBreak2().wordBreak(s, dict));
	}

}
