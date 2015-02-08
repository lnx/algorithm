package solutions;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

	int largestRectangleArea(int[] height) {
		int ret = 0;
		int[] h = Arrays.copyOf(height, height.length + 1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < h.length;) {
			if (stack.isEmpty() || h[stack.peek()] < h[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				int area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				ret = Math.max(area, ret);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] height = { 1, 2, 3 };
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(height));
	}

}
