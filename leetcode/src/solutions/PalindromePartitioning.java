package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {

	List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		dfs(s, new Stack<String>(), ret);
		return ret;
	}

	void dfs(String s, Stack<String> stack, List<List<String>> ret) {
		if (s.length() == 0) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = 1, len = s.length(); i <= len; ++i) {
				String prefix = s.substring(0, i);
				if (isPalindrome(prefix)) {
					stack.push(prefix);
					dfs(s.substring(i), stack, ret);
					stack.pop();
				}
			}
		}
	}

	boolean isPalindrome(String s) {
		for (int i = 0, len = s.length(), size = len / 2; i < size; ++i) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		List<List<String>> ret = new PalindromePartitioning().partition("efe");
		for (List<String> list : ret) {
			System.out.println(list);
		}
	}

}
