package solutions;

import struct.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

	void connect(TreeLinkNode root) {
		TreeLinkNode cur = root;
		while (cur != null && cur.left != null) {
			TreeLinkNode node = cur;
			while (node != null) {
				node.left.next = node.right;
				if (node.next != null) {
					node.right.next = node.next.left;
				}
				node = node.next;
			}
			cur = cur.left;
		}
	}

}
