package solutions;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (token.matches("[\\+\\-\\*/]")) {
				int b = stack.pop();
				int a = stack.pop();
				switch (token) {
				case "+":
					stack.push(a + b);
					break;
				case "-":
					stack.push(a - b);
					break;
				case "*":
					stack.push(a * b);
					break;
				case "/":
					stack.push(a / b);
					break;
				default:
					break;
				}
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

}
