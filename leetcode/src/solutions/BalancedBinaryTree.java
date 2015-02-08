package solutions;

import struct.TreeNode;

public class BalancedBinaryTree {

	boolean isBalanced(TreeNode root) {
		return check(root) != -1;
	}

	int check(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = check(root.left);
		if (left == -1) {
			return -1;
		}
		int right = check(root.right);
		if (right == -1) {
			return -1;
		}
		return Math.abs(left - right) <= 1 ? (1 + Math.max(left, right)) : -1;
	}

}
