package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import struct.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 0; queue.size() > 0; ++i) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0, size = queue.size(); j < size; ++j) {
				TreeNode node = queue.poll();
				if (node != null) {
					if (i % 2 == 0) {
						list.add(node.val);
					} else {
						list.add(0, node.val);
					}
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			if (list.size() > 0) {
				ret.add(list);
			}
		}
		return ret;
	}

}
