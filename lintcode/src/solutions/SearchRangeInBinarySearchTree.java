package solutions;

import java.util.ArrayList;

import struct.TreeNode;

public class SearchRangeInBinarySearchTree {

	ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> ret = new ArrayList<>();
		search(root, k1, k2, ret);
		return ret;
	}

	void search(TreeNode root, int k1, int k2, ArrayList<Integer> ret) {
		if (root != null) {
			if (root.val >= k1) {
				search(root.left, k1, k2, ret);
			}
			if (root.val >= k1 && root.val <= k2) {
				ret.add(root.val);
			}
			if (root.val <= k2) {
				search(root.right, k1, k2, ret);
			}
		}
	}

}
