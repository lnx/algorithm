package solutions;

import struct.TreeNode;

public class MaximumDepthOfBinaryTree {
	
	int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (isLeaf(root)) {
			return 1;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	boolean isLeaf(TreeNode root) {
		return root != null && root.left == null && root.right == null;
	}

}
