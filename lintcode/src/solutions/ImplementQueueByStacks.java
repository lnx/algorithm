package solutions;

import java.util.Stack;

public class ImplementQueueByStacks {

	Stack<Integer> stk1 = new Stack<>();
	Stack<Integer> stk2 = new Stack<>();

	public void push(int element) {
		stk1.push(element);
	}

	public int pop() {
		if (stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
		return stk2.pop();
	}

	public int top() {
		if (stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				stk2.push(stk1.pop());
			}
		}
		return stk2.peek();
	}

}
