package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreePreorderTraversal {

	List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				ret.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop().right;
			} else {
				break;
			}
		}
		return ret;
	}

}
