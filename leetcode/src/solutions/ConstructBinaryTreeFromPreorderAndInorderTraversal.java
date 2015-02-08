package solutions;

import struct.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	TreeNode buildTree(int[] preOrder, int[] inOrder) {
		return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
	}

	TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
		TreeNode ret = null;
		if (preStart <= preEnd) {
			int count = 0;
			for (int i = inStart; i <= inEnd && inOrder[i] != preOrder[preStart]; ++i) {
				++count;
			}
			ret = new TreeNode(preOrder[preStart]);
			ret.left = buildTree(preOrder, preStart + 1, preStart + count, inOrder, inStart, inStart + count - 1);
			ret.right = buildTree(preOrder, preStart + count + 1, preEnd, inOrder, inStart + count + 1, inEnd);
		}
		return ret;
	}

}
