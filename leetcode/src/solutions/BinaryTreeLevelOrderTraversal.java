package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import struct.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0, size = queue.size(); i < size; ++i) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			ret.add(list);
		}
		return ret;
	}

}
