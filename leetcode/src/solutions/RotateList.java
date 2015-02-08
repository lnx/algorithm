package solutions;

import struct.ListNode;

public class RotateList {

	ListNode rotateRight(ListNode head, int n) {
		int len = getLength(head);
		if (len <= 1) {
			return head;
		}
		n %= len;
		if (n > 0) {
			ListNode prev = head, tail = head;
			for (int i = 0; i < n; ++i) {
				tail = tail.next;
			}
			while (tail.next != null) {
				prev = prev.next;
				tail = tail.next;
			}
			tail.next = head;
			head = prev.next;
			prev.next = null;
		}
		return head;
	}

	int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			++len;
		}
		return len;
	}

}
