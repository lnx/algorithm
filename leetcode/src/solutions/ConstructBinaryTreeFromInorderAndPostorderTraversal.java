package solutions;

import struct.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	TreeNode buildTree(int[] inOrder, int[] postOrder) {
		return buildTree(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
	}

	TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
		TreeNode ret = null;
		if (postStart <= postEnd) {
			int count = 0;
			for (int i = inStart; i <= inEnd && inOrder[i] != postOrder[postEnd]; ++i) {
				++count;
			}
			ret = new TreeNode(postOrder[postEnd]);
			ret.left = buildTree(inOrder, inStart, inStart + count - 1, postOrder, postStart, postStart + count - 1);
			ret.right = buildTree(inOrder, inStart + count + 1, inEnd, postOrder, postStart + count, postEnd - 1);
		}
		return ret;
	}

}
