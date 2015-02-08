package solutions;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class RecoverBinarySearchTree {

	void recoverTree(TreeNode root) {
		List<TreeNode> ret = new ArrayList<>();
		TreeNode before = null;
		while (root != null) {
			if (root.left == null) {
				check(before, root, ret);
				before = root;
				root = root.right;
			} else {
				TreeNode pre = root.left;
				while (pre.right != null && pre.right != root) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = root;
					root = root.left;
				} else {
					check(before, root, ret);
					pre.right = null;
					before = root;
					root = root.right;
				}
			}
		}
		swap(ret);
	}

	void check(TreeNode before, TreeNode cur, List<TreeNode> ret) {
		if (before != null && before.val > cur.val) {
			if (ret.size() == 2) {
				ret.set(1, cur);
			} else {
				ret.add(before);
				ret.add(cur);
			}
		}
	}

	void swap(List<TreeNode> ret) {
		if (ret.size() == 2) {
			int temp = ret.get(0).val;
			ret.get(0).val = ret.get(1).val;
			ret.get(1).val = temp;
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node2.right = node3;
		node3.left = node1;
		new RecoverBinarySearchTree().recoverTree(node2);
		System.out.println(node2);
	}

}
