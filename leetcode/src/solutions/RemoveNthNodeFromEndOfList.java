package solutions;

import struct.ListNode;

public class RemoveNthNodeFromEndOfList {

	ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode rear = move(head, n);
		if (rear != null) {
			ListNode front = head;
			while (rear.next != null) {
				front = front.next;
				rear = rear.next;
			}
			front.next = front.next.next;
			return head;
		} else {
			return head.next;
		}
	}

	ListNode move(ListNode node, int k) {
		for (int i = 0; i < k; ++i) {
			node = node.next;
		}
		return node;
	}

}
