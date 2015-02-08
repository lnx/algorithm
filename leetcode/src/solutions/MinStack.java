package solutions;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stk = new Stack<>();
	Stack<Integer> min = new Stack<>();

	void push(int x) {
		stk.push(x);
		if (min.isEmpty() || x <= min.peek()) {
			min.push(x);
		}
	}

	void pop() {
		if (stk.pop().equals(min.peek())) {
			min.pop();
		}
	}

	int top() {
		return stk.peek();
	}

	int getMin() {
		return min.peek();
	}

}
