package solutions;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	int maximalRectangle(char[][] matrix) {
		int ret = 0;
		int m = matrix.length, n = m > 0 ? matrix[0].length : 0;
		int[] height = new int[n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
			}
			ret = Math.max(getMaxArea(height), ret);
		}
		return ret;
	}

	int getMaxArea(int[] height) {
		int ret = 0;
		int[] h = Arrays.copyOf(height, height.length + 1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < h.length;) {
			if (stack.isEmpty() || h[i] >= h[stack.peek()]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				int area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				ret = Math.max(area, ret);
			}
		}
		return ret;
	}

}
