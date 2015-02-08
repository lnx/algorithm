package solutions;

import struct.TreeNode;

public class RemoveNodeInBinarySearchTree {

	TreeNode removeNode(TreeNode root, int value) {
		TreeNode dummy = new TreeNode(0);
		dummy.left = root;
		TreeNode parent = find(dummy, root, value);
		TreeNode node = null;
		if (parent.left != null && parent.left.val == value) {
			node = parent.left;
		} else if (parent.right != null && parent.right.val == value) {
			node = parent.right;
		}
		if (node != null) {
			delete(parent, node);
		}
		return dummy.left;
	}

	TreeNode find(TreeNode parent, TreeNode node, int value) {
		if (node == null || node.val == value) {
			return parent;
		}
		return value < node.val ? find(node, node.left, value) : find(node, node.right, value);
	}

	void delete(TreeNode parent, TreeNode node) {
		if (node.left == null) {
			if (parent.left == node) {
				parent.left = node.right;
			} else {
				parent.right = node.right;
			}
		} else {
			TreeNode pre = node;
			TreeNode cur = node.left;
			while (cur.right != null) {
				pre = cur;
				cur = cur.right;
			}
			if (pre.left == cur) {
				pre.left = cur.left;
			} else {
				pre.right = cur.left;
			}
			if (parent.left == node) {
				parent.left = cur;
			} else {
				parent.right = cur;
			}
			cur.left = node.left;
			cur.right = node.right;
		}
	}

}
