package solutions;

import struct.TreeNode;

public class MaximumDepthOfBinaryTree {

	int maxDepth(TreeNode root) {
		return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}

}
