package solutions;

import struct.TreeNode;

public class ValidateBinarySearchTree {

	boolean isValidBST(TreeNode root) {
		return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean check(TreeNode root, long min, long max) {
		return root == null || min < root.val && root.val < max && check(root.left, min, root.val) && check(root.right, root.val, max);
	}

}
