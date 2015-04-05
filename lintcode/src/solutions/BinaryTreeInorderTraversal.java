package solutions;

import java.util.ArrayList;
import java.util.Stack;

import struct.TreeNode;

public class BinaryTreeInorderTraversal {

	ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (stack.isEmpty()) {
				break;
			} else {
				TreeNode node = stack.pop();
				root = node.right;
				ret.add(node.val);
			}
		}
		return ret;
	}

}
