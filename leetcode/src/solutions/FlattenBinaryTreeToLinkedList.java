package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import struct.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	void flatten(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode pre = cur.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				pre.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	void flatten1(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (true) {
			while (cur != null) {
				list.add(cur);
				stack.push(cur);
				cur = cur.left;
			}
			if (!stack.isEmpty()) {
				cur = stack.pop().right;
			} else {
				break;
			}
		}
		int size = list.size();
		if (size > 0) {
			for (int i = 0; i < size - 1; ++i) {
				list.get(i).left = null;
				list.get(i).right = list.get(i + 1);
			}
			list.get(size - 1).left = null;
			list.get(size - 1).right = null;
		}
	}

}
