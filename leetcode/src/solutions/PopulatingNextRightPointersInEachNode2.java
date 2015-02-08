package solutions;

import struct.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode2 {

	void connect(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while (cur != null) {
			if (isLeaf(cur)) {
				cur = cur.next;
			} else {
				TreeLinkNode child = getLeftChild(cur);
				while (cur != null) {
					if (cur.left != null && cur.right != null) {
						cur.left.next = cur.right;
					}
					TreeLinkNode next = cur.next;
					while (isLeaf(next)) {
						next = next.next;
					}
					if (next != null) {
						getRightChild(cur).next = getLeftChild(next);
					}
					cur = next;
				}
				cur = child;
			}
		}
	}

	boolean isLeaf(TreeLinkNode node) {
		return node != null && node.left == null && node.right == null;
	}

	TreeLinkNode getLeftChild(TreeLinkNode node) {
		return node.left != null ? node.left : node.right;
	}

	TreeLinkNode getRightChild(TreeLinkNode node) {
		return node.right != null ? node.right : node.left;
	}

}
