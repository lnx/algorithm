package solutions;

import struct.TreeNode;

public class LowestCommonAncestor {
	
	TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null || root == a || root == b) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, a, b);
		TreeNode right = lowestCommonAncestor(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

}
