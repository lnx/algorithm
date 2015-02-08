package solutions;

import struct.ListNode;

public class ReorderList {

	void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode mid = findMid(head);
		ListNode h1 = head, h2 = reverse(mid.next);
		mid.next = null;
		while (h2 != null) {
			ListNode next = h2.next;
			h2.next = h1.next;
			h1.next = h2;
			h1 = h2.next;
			h2 = next;
		}
	}

	ListNode findMid(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	ListNode reverse(ListNode head) {
		ListNode dummy = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = dummy;
			dummy = head;
			head = next;
		}
		return dummy;
	}

}
