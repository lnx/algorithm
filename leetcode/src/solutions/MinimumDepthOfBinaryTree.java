package solutions;

import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class MinimumDepthOfBinaryTree {

	int minDepth(TreeNode root) {
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			++depth;
			for (int i = 0, size = queue.size(); i < size; ++i) {
				TreeNode node = queue.poll();
				if (isLeaf(node)) {
					return depth;
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return depth;
	}

	boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}

}
