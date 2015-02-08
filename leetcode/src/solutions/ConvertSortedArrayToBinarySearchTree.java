package solutions;

import struct.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

	TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	TreeNode sortedArrayToBST(int[] num, int start, int end) {
		TreeNode ret = null;
		if (start <= end) {
			int mid = start + (end - start) / 2;
			ret = new TreeNode(num[mid]);
			ret.left = sortedArrayToBST(num, start, mid - 1);
			ret.right = sortedArrayToBST(num, mid + 1, end);
		}
		return ret;
	}

}
