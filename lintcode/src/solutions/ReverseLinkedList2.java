package solutions;

import struct.ListNode;

public class ReverseLinkedList2 {

	ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for (int i = 0; i < m - 1; ++i) {
			if (pre == null) {
				return null;
			}
			pre = pre.next;
		}
		ListNode mNode = pre.next;
		ListNode nNode = mNode, post = nNode.next;
		for (int i = m; i < n; ++i) {
			if (post == null) {
				return null;
			}
			ListNode next = post.next;
			post.next = nNode;
			nNode = post;
			post = next;
		}
		pre.next = nNode;
		mNode.next = post;
		return dummy.next;
	}

}
