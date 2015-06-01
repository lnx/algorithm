package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import struct.TreeNode;

public class BinaryTreeRightSideView {

	List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode cur = null;
				for (int i = 0, size = queue.size(); i < size; ++i) {
					cur = queue.poll();
					if (cur.left != null) {
						queue.offer(cur.left);
					}
					if (cur.right != null) {
						queue.offer(cur.right);
					}
				}
				ret.add(cur.val);
			}
		}
		return ret;
	}

}
