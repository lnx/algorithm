package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {

	List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		if (s != null) {
			search(s, new Stack<String>(), ret);
		}
		return ret;
	}

	void search(String s, Stack<String> stack, List<List<String>> ret) {
		if (s.equals("")) {
			ret.add(new ArrayList<>(stack));
		} else {
			for (int i = 1, len = s.length(); i <= len; ++i) {
				String prefix = s.substring(0, i);
				if (isPalindrome(prefix)) {
					stack.push(prefix);
					search(s.substring(i), stack, ret);
					stack.pop();
				}
			}
		}
	}

	boolean isPalindrome(String s) {
		for (int i = 0, len = s.length(), steps = len / 2; i < steps; ++i) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("aab"));
	}

}
