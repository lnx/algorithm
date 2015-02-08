package solutions;

import struct.ListNode;

public class ReorderList {

	void reorderList(ListNode head) {
		if (head != null && head.next != null) {
			ListNode slow = head, fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode node1 = head;
			ListNode node2 = reverse(slow.next);
			slow.next = null;
			while (node2 != null) {
				ListNode next = node2.next;
				node2.next = node1.next;
				node1.next = node2;
				node1 = node1.next.next;
				node2 = next;
			}
		}
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
