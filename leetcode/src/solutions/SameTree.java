package solutions;

import struct.TreeNode;

public class SameTree {

	boolean isSameTree(TreeNode p, TreeNode q) {
		return (p == null && q == null) || (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

}
