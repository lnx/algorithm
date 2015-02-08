package solutions;

import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class PathSum {

	boolean hasPathSum(TreeNode root, int sum) {
		return (isLeaf(root) && root.val == sum) || (root != null && (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val)));
	}

	boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}

	boolean hasPathSum2(TreeNode root, int sum) {
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> sumQueue = new LinkedList<>();
		if (root != null) {
			nodeQueue.offer(root);
			sumQueue.offer(root.val);
			while (!nodeQueue.isEmpty()) {
				TreeNode node = nodeQueue.poll();
				int num = sumQueue.poll();
				if (num == sum && isLeaf(node)) {
					return true;
				} else {
					if (node.left != null) {
						nodeQueue.offer(node.left);
						sumQueue.offer(num + node.left.val);
					}
					if (node.right != null) {
						nodeQueue.offer(node.right);
						sumQueue.offer(num + node.right.val);
					}
				}
			}
		}
		return false;
	}

}
