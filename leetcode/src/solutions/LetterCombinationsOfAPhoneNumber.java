package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LetterCombinationsOfAPhoneNumber {

	static final Map<Integer, List<Character>> map = new HashMap<>();

	static {
		map.put(2, Arrays.asList('a', 'b', 'c'));
		map.put(3, Arrays.asList('d', 'e', 'f'));
		map.put(4, Arrays.asList('g', 'h', 'i'));
		map.put(5, Arrays.asList('j', 'k', 'l'));
		map.put(6, Arrays.asList('m', 'n', 'o'));
		map.put(7, Arrays.asList('p', 'q', 'r', 's'));
		map.put(8, Arrays.asList('t', 'u', 'v'));
		map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
	}

	List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		dfs(digits, 0, new Stack<Character>(), ret);
		return ret;
	}

	void dfs(String digits, int k, Stack<Character> stack, List<String> ret) {
		if (k == digits.length()) {
			StringBuilder sb = new StringBuilder();
			for (char c : stack) {
				sb.append(c);
			}
			ret.add(sb.toString());
		} else {
			int cur = digits.charAt(k) - '0';
			for (char c : map.get(cur)) {
				stack.push(c);
				dfs(digits, k + 1, stack, ret);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		List<String> ret = lc.letterCombinations("32");
		for (String s : ret) {
			System.out.println(s);
		}
	}

}
