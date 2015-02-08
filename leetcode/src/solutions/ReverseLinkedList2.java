package solutions;

import struct.ListNode;

public class ReverseLinkedList2 {

	ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		ListNode prev = move(newHead, m - 1);
		ListNode start = move(prev, 1);
		ListNode end = move(start, n - m);
		ListNode behind = move(end, 1);
		end.next = null;
		prev.next = reverse(start);
		start.next = behind;
		return newHead.next;
	}

	ListNode move(ListNode node, int k) {
		for (int i = 0; i < k; ++i) {
			node = node.next;
		}
		return node;
	}

	ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

}
