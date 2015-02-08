package solutions;

import struct.TreeNode;

public class BinarySearchTreeIterator {

	TreeNode cur;

	BinarySearchTreeIterator(TreeNode root) {
		if (root != null) {
			init(root);
			cur = root;
			while (cur.left != null) {
				cur = cur.left;
			}
		}
	}

	void init(TreeNode root) {
		if (root.left != null) {
			init(root.left);
			TreeNode pre = root.left;
			while (pre.right != null) {
				pre = pre.right;
			}
			pre.right = root;
		}
		if (root.right != null) {
			init(root.right);
		}
	}

	boolean hasNext() {
		return cur != null;
	}

	int next() {
		int ret = cur.val;
		cur = cur.right;
		return ret;
	}

}
