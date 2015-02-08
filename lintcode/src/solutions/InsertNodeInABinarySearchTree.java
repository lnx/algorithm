package solutions;

import struct.TreeNode;

public class InsertNodeInABinarySearchTree {
	
	TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		if (node == null) {
			return root;
		}
		TreeNode pre = null;
		TreeNode cur = root;
		while (cur != null) {
			pre = cur;
			cur = cur.val > node.val ? cur.left : cur.right;
		}
		if (pre != null) {
			if (pre.val > node.val) {
				pre.left = node;
			} else {
				pre.right = node;
			}
		}
		return root;
	}

}
