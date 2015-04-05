package solutions;

import java.util.ArrayList;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreePostorderTraversal {

	ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> visit = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				visit.push(0);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			} else {
				if (visit.pop() == 1) {
					ret.add(stack.pop().val);
				} else {
					root = stack.peek().right;
					visit.push(1);
				}
			}
		}
		return ret;
	}

}
