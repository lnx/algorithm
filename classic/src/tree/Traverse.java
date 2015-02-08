package tree;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class Traverse {

	List<Integer> preOrder(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				ret.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					ret.add(cur.val);
					cur = cur.left;
				} else {
					pre.right = null;
					cur = cur.right;
				}
			}
		}
		return ret;
	}

	List<Integer> inOrder(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				ret.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					ret.add(cur.val);
					cur = cur.right;
				}
			}
		}
		return ret;
	}

	List<Integer> postOrder(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		TreeNode cur = new TreeNode(-1);
		cur.left = root;
		while (cur != null) {
			if (cur.left == null) {
				cur = cur.right;
			} else {
				TreeNode pre = cur.left;
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
				} else {
					pre.right = null;
					reverse(cur.left);
					TreeNode node = pre;
					while (node != null) {
						ret.add(node.val);
						node = node.right;
					}
					reverse(pre);
					cur = cur.right;
				}
			}
		}
		return ret;
	}

	void reverse(TreeNode node) {
		TreeNode prev = null;
		while (node != null) {
			TreeNode next = node.right;
			node.right = prev;
			prev = node;
			node = next;
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		Traverse tree = new Traverse();
		System.out.println(tree.preOrder(node1));
		System.out.println(tree.inOrder(node1));
		System.out.println(tree.postOrder(node1));
	}

}
