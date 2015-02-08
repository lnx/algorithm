package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		dfs(n, n, n, new Stack<Character>(), ret);
		return ret;
	}

	void dfs(int n, int left, int right, Stack<Character> stack, List<String> ret) {
		if (left == 0 && right == 0) {
			StringBuilder sb = new StringBuilder();
			for (char c : stack) {
				sb.append(c);
			}
			ret.add(sb.toString());
		} else {
			if (left > 0) {
				stack.push('(');
				dfs(n, left - 1, right, stack, ret);
				stack.pop();
			}
			if (right > left) {
				stack.push(')');
				dfs(n, left, right - 1, stack, ret);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new GenerateParentheses().generateParenthesis(3));
	}

}
