package solutions;

import java.util.Stack;

import struct.TreeNode;

public class MaxTree {

	TreeNode maxTree(int[] a) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(new TreeNode(a[0]));
		for (int i = 1; i < a.length; ++i) {
			if (a[i] < stack.peek().val) {
				stack.push(new TreeNode(a[i]));
			} else {
				TreeNode cur = stack.pop();
				while (!stack.isEmpty() && stack.peek().val < a[i]) {
					stack.peek().right = cur;
					cur = stack.pop();
				}
				TreeNode node = new TreeNode(a[i]);
				node.left = cur;
				stack.push(node);
			}
		}
		TreeNode root = stack.pop();
		while (!stack.isEmpty()) {
			stack.peek().right = root;
			root = stack.pop();
		}
		return root;
	}

}
