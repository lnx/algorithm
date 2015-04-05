package solutions;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stk = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int number) {
		if (min.isEmpty() || number <= min.peek()) {
			min.push(number);
		}
		stk.push(number);
	}

	public int pop() {
		if (stk.peek() == min.peek()) {
			min.pop();
		}
		return stk.pop();
	}

	public int min() {
		return min.peek();
	}

}
