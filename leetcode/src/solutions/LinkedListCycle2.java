package solutions;

import struct.ListNode;

public class LinkedListCycle2 {

	ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		return null;
	}

}
