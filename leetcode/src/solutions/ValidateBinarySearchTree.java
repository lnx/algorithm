package solutions;

import struct.TreeNode;

public class ValidateBinarySearchTree {

	boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isValidBST(TreeNode root, long min, long max) {
		return root == null || root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}

}
