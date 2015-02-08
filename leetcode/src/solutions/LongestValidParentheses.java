package solutions;

import java.util.Stack;

public class LongestValidParentheses {

	int longestValidParentheses(String s) {
		int ret = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0, pre = -1, len = s.length(); i < len; ++i) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					pre = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						ret = Math.max(i - pre, ret);
					} else {
						ret = Math.max(i - stack.peek(), ret);
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		LongestValidParentheses obj = new LongestValidParentheses();
		System.out.println(obj.longestValidParentheses("(())"));
	}

}
