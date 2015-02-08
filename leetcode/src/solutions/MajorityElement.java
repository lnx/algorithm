package solutions;

import java.util.Stack;

public class MajorityElement {

	int majorityElement(int[] num) {
		Stack<Integer> stack = new Stack<>();
		for (int i : num) {
			if (stack.isEmpty()) {
				stack.push(i);
			} else {
				if (stack.peek() == i) {
					stack.push(i);
				} else {
					stack.pop();
				}
			}
		}
		return stack.peek();
	}

}
