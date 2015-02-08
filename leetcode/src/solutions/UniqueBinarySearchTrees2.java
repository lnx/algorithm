package solutions;

import java.util.ArrayList;
import java.util.List;

import struct.TreeNode;

public class UniqueBinarySearchTrees2 {

	List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> ret = new ArrayList<>();
		for (int i = start; i <= end; ++i) {
			List<TreeNode> leftNodes = generateTrees(start, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, end);
			for (TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					ret.add(root);
				}
			}
		}
		if (ret.isEmpty()) {
			ret.add(null);
		}
		return ret;
	}

	public static void main(String[] args) {
		List<TreeNode> ret = new UniqueBinarySearchTrees2().generateTrees(3);
		for (TreeNode node : ret) {
			System.out.println(node);
		}
	}

}
