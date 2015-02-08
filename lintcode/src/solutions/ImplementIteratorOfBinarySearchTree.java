package solutions;

import java.util.Stack;

import struct.TreeNode;

public class ImplementIteratorOfBinarySearchTree {

	Stack<TreeNode> stack = new Stack<>();

	ImplementIteratorOfBinarySearchTree(TreeNode root) {
		push(root);
	}

	boolean hasNext() {
		return !stack.isEmpty();
	}

	TreeNode next() {
		TreeNode node = null;
		if (!stack.isEmpty()) {
			node = stack.pop();
			push(node.right);
		}
		return node;
	}

	void push(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

}
