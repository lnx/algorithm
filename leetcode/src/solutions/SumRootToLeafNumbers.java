package solutions;

import struct.TreeNode;

public class SumRootToLeafNumbers {

	int sum = 0;

	int sumNumbers(TreeNode root) {
		if (root != null) {
			dfs(root, 0);
		}
		return sum;
	}

	void dfs(TreeNode root, int base) {
		if (isLeaf(root)) {
			sum += base * 10 + root.val;
		} else {
			base = base * 10 + root.val;
			if (root.left != null) {
				dfs(root.left, base);
			}
			if (root.right != null) {
				dfs(root.right, base);
			}
		}
	}

	boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(new SumRootToLeafNumbers().sumNumbers(n1));
	}

}
