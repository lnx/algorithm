package solutions;

import struct.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	TreeNode buildTree(int[] pre, int[] in) {
		return buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
	}

	TreeNode buildTree(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preStart]);
		int len = 0;
		while (in[inStart + len] != pre[preStart]) {
			++len;
		}
		root.left = buildTree(pre, in, preStart + 1, preStart + len, inStart, inStart + len - 1);
		root.right = buildTree(pre, in, preStart + len + 1, preEnd, inStart + len + 1, inEnd);
		return root;
	}

}
