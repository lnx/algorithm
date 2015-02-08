package solutions;

import struct.TreeNode;

public class BinaryTreeMaximumPathSum {

	int max = Integer.MIN_VALUE;

	int maxPathSum(TreeNode root) {
		search(root);
		return max;
	}

	int search(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = search(root.left);
		int right = search(root.right);
		max = Math.max(root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0), max);
		int child = Math.max(left, right);
		return root.val + (child > 0 ? child : 0);
	}

}
