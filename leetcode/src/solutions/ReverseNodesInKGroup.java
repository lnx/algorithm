package solutions;

import struct.ListNode;

public class ReverseNodesInKGroup {

	ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(-1);
		ListNode newTail = newHead;
		while (head != null) {
			ListNode tail = head;
			int i = 0;
			while (i < k - 1 && tail.next != null) {
				tail = tail.next;
				++i;
			}
			if (i == k - 1) {
				ListNode next = tail.next;
				tail.next = null;
				newTail.next = reverse(head);
				newTail = head;
				head = next;
			} else {
				newTail.next = head;
				break;
			}
		}
		return newHead.next;
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
