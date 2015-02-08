package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		int level = 0;
		while (!queue.isEmpty()) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0, size = queue.size(); i < size; ++i) {
				TreeNode cur = queue.poll();
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
				if (level % 2 == 0) {
					list.add(cur.val);
				} else {
					list.add(0, cur.val);
				}
			}
			ret.add(list);
			++level;
		}
		return ret;
	}

}
