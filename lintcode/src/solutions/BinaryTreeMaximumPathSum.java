package solutions;

import struct.TreeNode;

public class BinaryTreeMaximumPathSum {

	class Ret {

		int single;
		int sum;

		public Ret(int single, int sum) {
			this.single = single;
			this.sum = sum;
		}

	}

	int maxPathSum(TreeNode root) {
		return search(root).sum;
	}

	Ret search(TreeNode root) {
		if (root == null) {
			return new Ret(0, Integer.MIN_VALUE);
		}
		Ret left = search(root.left);
		Ret right = search(root.right);
		int single = Math.max(0, root.val + Math.max(left.single, right.single));
		int sum = Math.max(root.val + left.single + right.single, Math.max(left.sum, right.sum));
		return new Ret(single, sum);
	}

}
