package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {

	ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
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
				list.add(cur.val);
			}
			ret.add(0, list);
		}
		return ret;
	}

}
