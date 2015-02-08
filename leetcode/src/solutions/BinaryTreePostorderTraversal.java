package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreePostorderTraversal {

	List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> visit = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				visit.push(0);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				if (visit.pop() == 1) {
					ret.add(stack.pop().val);
				} else {
					visit.push(1);
					root = stack.peek().right;
				}
			} else {
				break;
			}
		}
		return ret;
	}

}
