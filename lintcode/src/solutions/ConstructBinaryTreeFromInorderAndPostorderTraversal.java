package solutions;

import struct.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	TreeNode buildTree(int[] in, int[] post) {
		return buildTree(in, post, 0, in.length - 1, 0, post.length - 1);
	}

	TreeNode buildTree(int[] in, int[] post, int inStart, int inEnd, int postStart, int postEnd) {
		if (postStart > postEnd) {
			return null;
		}
		TreeNode root = new TreeNode(post[postEnd]);
		int len = 0;
		while (in[inStart + len] != post[postEnd]) {
			++len;
		}
		root.left = buildTree(in, post, inStart, inStart + len - 1, postStart, postStart + len - 1);
		root.right = buildTree(in, post, inStart + len + 1, inEnd, postStart + len, postEnd - 1);
		return root;
	}

}
