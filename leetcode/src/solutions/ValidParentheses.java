package solutions;

import java.util.Stack;

public class ValidParentheses {

	boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0, len = s.length(); i < len; ++i) {
			char cur = s.charAt(i);
			if (cur == '(' || cur == '[' || cur == '{') {
				stack.push(cur);
			} else {
				if (!stack.isEmpty()) {
					char top = stack.pop();
					if ((top == '(' && cur != ')') || (top == '[' && cur != ']') || (top == '{' && cur != '}')) {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("()[]{}a"));
	}

}
