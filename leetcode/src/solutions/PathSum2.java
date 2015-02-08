package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import struct.TreeNode;

public class PathSum2 {

	List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<>();
		dfs(root, sum, new Stack<Integer>(), ret);
		return ret;
	}

	void dfs(TreeNode root, int sum, Stack<Integer> stack, List<List<Integer>> ret) {
		if (root != null) {
			if (isLeaf(root)) {
				if (root.val == sum) {
					List<Integer> list = new ArrayList<>(stack);
					list.add(root.val);
					ret.add(list);
				}
			} else {
				stack.push(root.val);
				dfs(root.left, sum - root.val, stack, ret);
				dfs(root.right, sum - root.val, stack, ret);
				stack.pop();
			}
		}
	}

	boolean isLeaf(TreeNode node) {
		return node != null && node.left == null && node.right == null;
	}

}
