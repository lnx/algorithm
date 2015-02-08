package solutions;

import struct.ListNode;

public class SwapNodesInPairs {

	ListNode swapPairs(ListNode head) {
		ListNode newHead = new ListNode(-1);
		ListNode newTail = newHead;
		newTail.next = head;
		while (newTail.next != null && newTail.next.next != null) {
			ListNode first = newTail.next;
			ListNode second = newTail.next.next;
			first.next = second.next;
			second.next = first;
			newTail.next = second;
			newTail = first;
		}
		return newHead.next;
	}

}
