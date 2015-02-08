package solutions;

import struct.ListNode;
import struct.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
	TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode pre = findMidPre(head);
		TreeNode root = new TreeNode(pre.next.val);
		root.right = sortedListToBST(pre.next.next);
		pre.next = null;
		root.left = sortedListToBST(head);
		return root;
	}

	ListNode findMidPre(ListNode head) {
		ListNode pre = head, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return pre;
	}

}
