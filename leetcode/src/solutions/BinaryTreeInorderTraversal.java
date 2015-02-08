package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreeInorderTraversal {

	List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			while (true) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}
				if (!stack.isEmpty()) {
					ret.add(stack.peek().val);
					root = stack.pop().right;
				} else {
					break;
				}
			}
		}
		return ret;
	}

}
