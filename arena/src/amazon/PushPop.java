package amazon;

import java.util.Stack;

public class PushPop {

	String genOperations(int[] original, int[] result) {
		if (original.length != result.length || original.length == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int i = 0, j = 0, len = original.length;
		while (i < len && j < len) {
			if (!stack.isEmpty() && stack.peek() == result[j]) {
				stack.pop();
				sb.append("|pop" + result[j++]);
			} else {
				stack.push(original[i]);
				sb.append("|push" + original[i++]);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() != result[j++]) {
				return null;
			}
			sb.append("|pop" + stack.pop());
		}
		return sb.substring(1);
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3 };
		int[] result = { 1, 2, 3 };
		System.out.println(new PushPop().genOperations(original, result));
	}

}
