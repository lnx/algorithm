package solutions;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class SymmetricTree {

	boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetric(root.left, root.right);
	}

	boolean isSymmetric(TreeNode left, TreeNode right) {
		return (left == null && right == null)
				|| (left != null && right != null && left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
	}

	boolean isSymmetric1(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		while (!list.isEmpty()) {
			int size = list.size();
			for (int i = 0; i < size / 2; ++i) {
				TreeNode left = list.get(i);
				TreeNode right = list.get(size - i - 1);
				if ((left != null && right == null) || (left == null && right != null) || (left != null && right != null && left.val != right.val)) {
					return false;
				}
			}
			for (int i = 0; i < size; ++i) {
				TreeNode node = list.remove(0);
				if (node != null) {
					list.add(node.left);
					list.add(node.right);
				}
			}
		}
		return true;
	}

}
