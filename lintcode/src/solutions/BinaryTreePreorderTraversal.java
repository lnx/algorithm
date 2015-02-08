package solutions;

import java.util.ArrayList;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreePreorderTraversal {
	
	ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				ret.add(root.val);
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			} else {
				root = stack.pop().right;
			}
		}
		return ret;
	}

}
